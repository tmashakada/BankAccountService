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
public class NoRecordFoundException extends Exception{
    private String message;
    private String error;

    public NoRecordFoundException(String message, String error) {
        super( message);
        this.message = message;
        this.error = error;
    }
  public NoRecordFoundException(String string) {
        super(string);
          
         this.message = string;
    }
    public NoRecordFoundException(String string,String message, String error ) {
        super(string);
        this.message = message;
        this.error = error;
    }

    public NoRecordFoundException(String string, Throwable thrwbl,String message, String error) {
        super(string, thrwbl);
        this.message = message;
        this.error = error;
    }

    public NoRecordFoundException(Throwable thrwbl,String message, String error) {
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
