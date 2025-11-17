package org.example.order.processing;

public class UnknownProductTypeException extends RuntimeException {
    public UnknownProductTypeException(String message) {
        super(message);
    }
}
