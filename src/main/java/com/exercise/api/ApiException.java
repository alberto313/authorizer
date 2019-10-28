package com.exercise.api;

@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
