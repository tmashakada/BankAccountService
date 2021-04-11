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
public class AccountException extends Exception{
     private String message;

        
     public AccountException() {
              super();
    }

    public AccountException(String message) {
        super(message);
         this.message = message;
    }  
    

    public AccountException(String message, String string) {
        super(string);
        this.message = message;
    }

    public AccountException(String message, String string, Throwable thrwbl) {
        super(string, thrwbl);
        this.message = message;
    }

    public AccountException(String message, Throwable thrwbl) {
        super(thrwbl);
        this.message = message;
    }
        

        @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
