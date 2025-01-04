package com.example.storeproject.utils;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private String timeStamp;
    private Integer status;
    private String error;
    private String trace;
    private String message;
    private String path;

}
