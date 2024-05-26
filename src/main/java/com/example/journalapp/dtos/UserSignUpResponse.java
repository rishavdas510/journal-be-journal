package com.example.journalapp.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpResponse {

    public String id;
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public String userName;
}
