package com.lyris.mesa.sync;

/**
 * GSON mapping class for JSON sync errors
 * @author tchilders
 *
 */
public class SyncError {

    private String errorMessage;
    
    private String errorDiagnostics;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDiagnostics() {
        return errorDiagnostics;
    }

    public void setErrorDiagnostics(String errorDiagnostics) {
        this.errorDiagnostics = errorDiagnostics;
    }
    
}
