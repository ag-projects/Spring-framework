package com.agharibi.gifLibrary.web;


public class FlashMessage {

    private String message;
    private Status status;

    public FlashMessage(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public static enum Status {
        SUCESS, FAILURE
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }
}
