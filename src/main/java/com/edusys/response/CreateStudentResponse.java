package com.edusys.response;

/**
 * Created by Sumedh on 26-06-2016.
 */
public class CreateStudentResponse {
    private String successMessage;
    private String failureMessage;

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    @Override
    public String toString() {
        return "CreateStudentResponse{" +
                "successMessage='" + successMessage + '\'' +
                ", failureMessage='" + failureMessage + '\'' +
                '}';
    }
}
