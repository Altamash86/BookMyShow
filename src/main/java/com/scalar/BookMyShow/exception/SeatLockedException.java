package com.scalar.BookMyShow.exception;

public class SeatLockedException extends RuntimeException{
    public SeatLockedException(String message) {
        super(message);
    }
}
