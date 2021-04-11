/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class ApiError {
    private HttpStatus status;
    private String message;
    private String errors;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

     public ApiError() {
        
        super();
         setCurrentTimestamp();
    }

    public ApiError(final HttpStatus status, final String message, final String errors) {
        super();
         setCurrentTimestamp();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

   
    //

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    
    
    private void setCurrentTimestamp() {
        timestamp = LocalDateTime.now();
    }

}
