package com.edusys.response;

/**
 * Created by Sumedh on 22-06-2016.
 */
public class RequestAuthenticationResponse {
    String failureMessage;

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    @Override
    public String toString() {
        return "RequestAuthenticationResponse{" +
                "failureMessage='" + failureMessage + '\'' +
                '}';
    }
}