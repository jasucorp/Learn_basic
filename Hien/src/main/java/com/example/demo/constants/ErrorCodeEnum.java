package com.example.demo.constants;

public enum ErrorCodeEnum {

    NOT_FOUND(401_001, "Not found!","false"),
    CREATE_MUST_NOT_HAVE_ID(409_001, "Create mustn't have id!","false"),
    DELETE_COMPLETE(200_001,"Deleted","true"),
    BAD_FORMAT(402_002,"Wrong format email!","false"),
    USER_EXIST(402_001, "User already exist","false"),
    DONE(200_002, "Done!","true")
    ;

    private String message;
    private int value;
    private String status;

    ErrorCodeEnum( int value, String message, String status){
        this.message = message;
        this.value = value;
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
