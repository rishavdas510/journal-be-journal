package com.example.journalapp.controller;

import com.example.journalapp.Models.User;
import com.example.journalapp.dtos.APIResponse;
import com.example.journalapp.dtos.UserSignUpRequest;
import com.example.journalapp.dtos.UserSignUpResponse;
import com.example.journalapp.exception.UserSignUpExeception;
import com.example.journalapp.services.IUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class onBoardingController {

    private final IUser userService;

    public  onBoardingController(IUser userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<APIResponse<UserSignUpResponse>> signup(@RequestBody UserSignUpRequest userRequest) throws UserSignUpExeception, InterruptedException {
        UserSignUpResponse responseDto =  userService.userSignUp(userRequest);
        return new ResponseEntity<>(
                new APIResponse<>(
                        HttpStatus.CREATED.value(),
                        "User Created SuccessFully",
                        HttpStatus.CREATED.toString(),
                        responseDto,
                        null),
                HttpStatus.CREATED);
    }
}
