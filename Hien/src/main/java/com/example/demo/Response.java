package com.example.demo;

import com.example.demo.constants.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response <T> {
    private String message;
    private Integer num;
    private String status;
    private T data;

    public Response(ErrorCodeEnum errorCodeEnum){
        message = errorCodeEnum.getMessage();
        num = errorCodeEnum.getValue();
        status = errorCodeEnum.getStatus();
    }

    public Response(T data){
        num = 200;
        this.status = getStatus();
        this.data = data;
    }
}
