package com.mypractice.authorizationserver.iban;

public class IbanException extends RuntimeException{
    public IbanException(String message){
        super(message);
    }
}
