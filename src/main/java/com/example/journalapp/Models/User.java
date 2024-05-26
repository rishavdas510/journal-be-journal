package com.example.journalapp.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User implements Serializable {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String firstName;

    private String lastName;

    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}
