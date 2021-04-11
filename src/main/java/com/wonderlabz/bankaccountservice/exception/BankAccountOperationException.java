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
public class BankAccountOperationException extends Exception{
    private String error;
    private String message;
    
    public BankAccountOperationException() {
              super();
    }

    public BankAccountOperationException(String message) {
        super(message);
         this.message = message;
    }

    public BankAccountOperationException(String error, String message) {
          super(error);
        this.error = error;
        this.message = message;
    }

    public BankAccountOperationException(String message, Throwable source) {
        super(message, source);
        this.message = message;
    }

    public BankAccountOperationException(Throwable source) {
        super(source);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
