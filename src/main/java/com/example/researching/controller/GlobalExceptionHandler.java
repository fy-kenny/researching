package com.example.researching.controller;

import com.example.researching.controller.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.researching.controller.vo.Result.fail;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        log.error("服务端异常:", e);

        return fail(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result exception(RuntimeException e) {
        log.error("服务端异常:", e);

        return fail(e.getMessage());
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class,
            IllegalArgumentException.class, MissingServletRequestParameterException.class})
    public Result argumentBindException(Exception e) {
        log.error("服务端异常:", e);

        return fail("参数不正确");
    }
}
