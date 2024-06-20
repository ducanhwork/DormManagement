package dev.pdanh.dormmanagement.ExceptionHandler;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    USER_EXISTED(1001,"User_existed"),
    PASSWORD_ERROR(1002,"Password must be at least 8 character"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized exception"),
    USERNAME_LENGTH(1003,"Username must be at least 3 character"),
    INVALID_KEY(1004,"Invalid key"),
    USER_NOT_FOUND(1005,"User not found"),
    UNAUTHENTICATED (1006,"Unauthenticated"),
    PHONENUMBER_LENGTH(1007,"Phone number must contain 10 digits"),
    SUCCESS(200,"Success"),
    ;


    ErrorCode(int code, String message){
        this.code = code;
        this.message =  message;
    }
    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
