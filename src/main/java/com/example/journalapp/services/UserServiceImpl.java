package com.example.journalapp.services;

import com.example.journalapp.Models.User;
import com.example.journalapp.dtos.UserSignUpRequest;
import com.example.journalapp.dtos.UserSignUpResponse;
import com.example.journalapp.exception.UserSignUpExeception;
import com.example.journalapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUser{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserSignUpResponse userSignUp(UserSignUpRequest userSignUpRequest) throws UserSignUpExeception, InterruptedException {
        try {
            validateUserSignUp(userSignUpRequest);
            User user  = getUserFromUserSignUpRequestDto(userSignUpRequest);
            User savedUser = userRepository.save(user);
            return getUserSignUpResponseFromUser(savedUser);
        }
        catch (UserSignUpExeception ex) {
            throw new UserSignUpExeception("Validation Failed", ex.getDetails());
        } catch (Exception ex) {
            throw new InterruptedException("Exception message: " + ex.getMessage());
        }

    };

    @Override
    public String userSignIn(){
        return "";
    };

    private User getUserFromUserSignUpRequestDto(UserSignUpRequest userSignUpRequest){
        return  User.builder()
                .email(userSignUpRequest.email)
                .firstName(userSignUpRequest.firstName)
                .lastName(userSignUpRequest.lastName)
                .userName(userSignUpRequest.userName)
                .password(userSignUpRequest.password)
                .build();
    }

    private UserSignUpResponse getUserSignUpResponseFromUser(User user){
        return  UserSignUpResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    private void validateUserSignUp(UserSignUpRequest userSignUpRequest){
        List<String> errors = new ArrayList<>();
        if( userSignUpRequest.email == null || userSignUpRequest.email.isEmpty()){
            errors.add("email can not be empty");
        }
        if( userSignUpRequest.password == null || userSignUpRequest.password.isEmpty()){
            errors.add("password can not be empty");
        }
        if( userSignUpRequest.password != null && !userSignUpRequest.password.isEmpty() && userSignUpRequest.password.length() < 3){
            errors.add("password must be at least of length 3");
        }
        if( userSignUpRequest.userName == null || userSignUpRequest.userName.isEmpty()){
            errors.add("user name can not be empty");
        }
        List<User> users =  userRepository.findAll();
        for(User user: users){
            if(user.getEmail().equals(userSignUpRequest.email)){
                errors.add("email "+userSignUpRequest.email+" already exist");
            }
            if(user.getUserName().equals(userSignUpRequest.userName)){
                errors.add("username "+userSignUpRequest.userName+" already exist");
            }
        }
        if(errors.isEmpty()){
            return;
        }
        throw new UserSignUpExeception("Validation Failed",errors);
    }
}
