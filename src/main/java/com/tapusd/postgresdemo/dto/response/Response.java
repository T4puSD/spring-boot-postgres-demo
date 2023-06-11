package com.tapusd.postgresdemo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    int code;
    String message;
    T data;

    public int getCode() {
        return code;
    }

    public Response<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> Response<T> getSuccessDataResponse(T data) {
        return new Response<T>()
                .setCode(200)
                .setMessage("Success")
                .setData(data);
    }

    public static Response<Object> getIllegalArgumentResponse(IllegalArgumentException ex) {
        return new Response<>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(ex.getMessage());
    }
}
