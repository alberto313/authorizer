package com.exercise.api;

@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
