package com.lyris.mesa.error;

import java.io.Serializable;

public class ErrorInfo implements Serializable {
    /** Reference to the version UID that will be used during serialization process */
    private static final long serialVersionUID = 1L;

    // <Chandra Veerapaneni>
    // Temporarily commented out HttpStatus.
    // HttpStatus is an interface that is available in org.apache.httpcomponents group with the artifact being httpclient.
    // Originally, there was a separate project commons-httpclient which has gone EOL and replaced by org.apache.httpcomponents.
    // Apparently, when the canvas services (campaign-schedule-service, etc) depend on this project (i.e. common/model), the
    // httpclient-xxx.jar & httpcore-xxx.jar are not getting resolved and getting excluded out. Not sure if this has to do anything with the Mule CE version
    // that's excluding these jars. With Mule EE version, these 2 jars are bundled with Mule EE itself.
    // Though we could use commons-httpclient, considering that it has gone EOL and HttpStatus in commons-httpclient also has HttpStatus but the status codes
    // are all integers and if we change our api below to take an integer, it becomes even more difficult as any integer can be passed.
    // Hence, I have commented out the HttpStatus until we find a good solution

    public ErrorInfo(/* final HttpStatus status, */final String errorMessage, final String errorDiagnostics) {
        // setStatus(status);
        setErrorMessage(errorMessage);
        setErrorDiagnostics(errorDiagnostics);
    }

    // private HttpStatus status;
    private String errorMessage;
    private String errorDiagnostics;

    // public HttpStatus getStatus() {
    // return status;
    // }
    //
    // public void setStatus(final HttpStatus status) {
    // this.status = status;
    // }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDiagnostics() {
        return errorDiagnostics;
    }

    public void setErrorDiagnostics(final String errorDiagnostics) {
        this.errorDiagnostics = errorDiagnostics;
    }

}
