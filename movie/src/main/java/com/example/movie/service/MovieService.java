package com.example.movie.service;


import com.example.movie.exception.MovieException;
import com.example.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    Movie findMovie(Integer id) throws MovieException;
    void addMovie(Movie movie);
    void updateMovie(UpdateMovie movieObj);
    List<Movie> findAll();
    void deleteMovie(Integer id) throws MovieException;


}
