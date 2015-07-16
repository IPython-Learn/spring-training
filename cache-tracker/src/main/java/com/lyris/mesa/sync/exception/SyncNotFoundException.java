package com.lyris.mesa.sync.exception;

@SuppressWarnings("serial")
public class SyncNotFoundException extends Exception {

    public SyncNotFoundException(String message) {
        super(message);
    }
    
    public SyncNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}