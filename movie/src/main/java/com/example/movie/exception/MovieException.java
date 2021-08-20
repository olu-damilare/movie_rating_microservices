package com.example.movie.exception;

public class MovieException extends Exception {

    public MovieException(String message) {
        super(message);
    }

    public MovieException() {
        super();
    }

    public MovieException(String message, Throwable ex) {
        super(message, ex);
    }

    public MovieException(Throwable ex) {
        super(ex);
    }

}
