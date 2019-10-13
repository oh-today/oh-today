package com.yangrd.today.commons.core.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * GlobalExceptionHandler
 *
 * @author yangrd
 * @date 2019/04/24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${config.exception.print-stack-trace-flag:true}")
    private Boolean printStackTraceFlag;

    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse res, CustomException ex) throws IOException {
        res.sendError(ex.getHttpStatus().value(), ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(HttpServletResponse res) throws IOException {
        res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res, Exception ex) throws IOException {
        if (printStackTraceFlag) {
            ex.printStackTrace();
        }
        res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }
}
