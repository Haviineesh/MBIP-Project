package com.ip.mbip.exception;

public class DuplicateBillNumberException extends RuntimeException {

    public DuplicateBillNumberException(String message) {
        super(message);
    }
}