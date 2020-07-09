package com.example.researching.controller.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@AllArgsConstructor
@Builder
@Value
public class Result<T> {

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_FAIL = "fail";


    private Integer code;
    private String msg;
    private T data;

    public Result() {
        this.code = SUCCESS;
        this.msg = MSG_SUCCESS;
        this.data = null;
    }

    public Result(T data) {
        this.code = SUCCESS;
        this.msg = MSG_SUCCESS;
        this.data = data;
    }

    public Result(Throwable e) {
        this.code = FAIL;
        this.msg = e.getMessage();
        this.data = null;
    }

    public static Result success() {

        return Result.builder()
                .code(SUCCESS)
                .msg(MSG_SUCCESS)
                .build();
    }

    public static Result ok() {
        return success();
    }


    public static <T> Result<T> out(int code, String msg, T data) {

        return Result.<T>builder()
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> Result<T> success(T data) {

        return Result.<T>builder()
                .code(SUCCESS)
                .msg(MSG_SUCCESS)
                .data(data)
                .build();
    }

    public static Result success(String msg) {
        return Result.out(SUCCESS, msg, null);
    }

    public static <T> Result<T> success(T data, String msg) {
        return Result.out(SUCCESS, msg, data);
    }

    public static Result fail(Throwable e) {

        return Result.builder()
                .code(FAIL)
                .msg(e.getMessage())
                .build();
    }

    public static Result fail(String msg) {
        return Result.out(FAIL, msg, null);
    }

    public static <T> Result<T> fail(T data, String msg) {
        return Result.out(FAIL, msg, data);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return 0 == this.getCode();
    }

    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }

}
