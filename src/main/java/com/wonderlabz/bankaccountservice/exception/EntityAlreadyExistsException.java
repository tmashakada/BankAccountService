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
public class EntityAlreadyExistsException extends Exception{
    private String message;
    private String error;

    public EntityAlreadyExistsException(String message, String error) {
        super( message);
        this.message = message;
        this.error = error;
    }
  public EntityAlreadyExistsException(String string) {
        super(string);
          
         this.message = string;
    }
    public EntityAlreadyExistsException(String string,String message, String error ) {
        super(string);
        this.message = message;
        this.error = error;
    }

    public EntityAlreadyExistsException(String string, Throwable thrwbl,String message, String error) {
        super(string, thrwbl);
        this.message = message;
        this.error = error;
    }

    public EntityAlreadyExistsException(Throwable thrwbl,String message, String error) {
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
