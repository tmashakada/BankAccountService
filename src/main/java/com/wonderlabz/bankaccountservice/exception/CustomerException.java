/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.exception;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class CustomerException extends Exception{
     private String message;
     private String error;

    public CustomerException(String message, String error) {
        super( message);
        this.message = message;
        this.error = error;
    }

    public CustomerException(String string,String message, String error) {
        super(string);
        this.message = message;
        this.error = error;
    }

    public CustomerException(String string,String message, String error,  Throwable thrwbl) {
        super(string, thrwbl);
        this.message = message;
        this.error = error;
    }

    public CustomerException(String message, String error, Throwable thrwbl) {
        super(thrwbl);
        this.message = message;
        this.error = error;
    }
    
     
     
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
     
     
     
}
