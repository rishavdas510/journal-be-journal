package com.example.journalapp.services;

import com.example.journalapp.dtos.UserSignUpRequest;
import com.example.journalapp.dtos.UserSignUpResponse;
import com.example.journalapp.exception.UserSignUpExeception;

public interface IUser {


    public UserSignUpResponse userSignUp(UserSignUpRequest userSignUpRequest) throws UserSignUpExeception, InterruptedException;

    public String userSignIn();
}
