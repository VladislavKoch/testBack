package com.example.testBack.dto;

import lombok.Data;

@Data
public class InternalErrorDTO {
    private String error;

    public InternalErrorDTO() {
        this.error = "INTERNAL_ERROR";
    }
}
