package com.example.managestudentjooq.exception;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.config.AppConstant;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.SignatureException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ServiceResult<String>> handleBadCredentialsException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResult<>(
                AppConstant.BAD_REQUEST, "Username or password incorrect", null));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ServiceResult<String>> handleExpiredJwtException(ExpiredJwtException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResult<>(
                AppConstant.BAD_REQUEST, "Token has expired", null));
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ServiceResult<String>> handleInvalidTokenException(InvalidTokenException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResult<>(
                AppConstant.BAD_REQUEST, "token invalid", null));
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ServiceResult<String>> handleSignatureException(SignatureException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResult<>(
                AppConstant.BAD_REQUEST, "Token has been tampered", null));
    }

    @ExceptionHandler(UsernameHasExited.class)
    public ResponseEntity<ServiceResult<String>> handleUsernameHasExited(UsernameHasExited ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResult<>(
                AppConstant.BAD_REQUEST, ex.getMessage(), null));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceResult<String>> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResult<>(
                AppConstant.BAD_REQUEST, ex.getMessage(), null));
    }
}
