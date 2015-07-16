package com.lyris.mesa.sync.exception;

@SuppressWarnings("serial")
public class SyncException extends Exception {

    public SyncException(String message) {
        super(message);
    }
    
    public SyncException(String message, Throwable e) {
        super(message, e);
    }
}