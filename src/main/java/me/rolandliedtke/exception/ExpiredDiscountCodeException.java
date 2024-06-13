package me.rolandliedtke.exception;

public class ExpiredDiscountCodeException extends RuntimeException {
    public ExpiredDiscountCodeException(String message) {
        super(message);
    }
}
