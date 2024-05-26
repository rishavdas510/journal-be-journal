package com.example.journalapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<E> implements Serializable {

    private int statusCode;
    private String message;
    private String status;
    private E data;
    private Object error;

}
