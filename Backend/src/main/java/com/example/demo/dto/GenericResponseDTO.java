package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponseDTO implements Serializable {

    String message;
    Object data;

    public GenericResponseDTO() {
    }

    public GenericResponseDTO(String message) {
        this.message = message;
    }

    public GenericResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
