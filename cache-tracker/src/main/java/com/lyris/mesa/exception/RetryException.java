package com.lyris.mesa.exception;

/**
 * RetryException that will be used in the mule JMS flows that want to attempt a retry use-case.
 * 
 * @author cveerapaneni
 * 
 */
public class RetryException extends Exception {

    /** Default serial version UID */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * 
     * @param message
     *            Error message
     */
    public RetryException(final String message) {
        super(message);
    }

    /**
     * Constructor
     * 
     * @param message
     *            Error message
     * @param throwable
     *            Cause
     */
    public RetryException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
