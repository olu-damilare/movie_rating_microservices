package com.example.movie_rating.exceptions;

public class RatingException extends Exception{

    public RatingException(String message){
        super(message);
    }

    public RatingException(){
        super();
    }

    public RatingException(String message, Throwable ex){
        super(message, ex);
    }

    public RatingException(Throwable ex){
        super(ex);
    }
}
