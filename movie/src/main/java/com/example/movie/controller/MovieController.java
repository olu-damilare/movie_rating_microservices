package com.example.movie.controller;

import com.example.movie.exception.MovieException;
import com.example.movie.model.Movie;
import com.example.movie.model.Rating;
import com.example.movie.service.MovieService;
import com.example.movie.service.UpdateMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("movies/")
    public void addMovie(@RequestBody Movie movie){

        movieService.addMovie(movie);
    }

    @GetMapping("movies/{movieId}/")
    public Movie findMovie(@PathVariable Integer movieId){
        Movie movie = null;
        try {
            movie = movieService.findMovie(movieId);
        } catch (MovieException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @PutMapping("movies/")
    public void updateMovie(@RequestBody UpdateMovie movieObj){
        movieService.updateMovie(movieObj);
    }

    @GetMapping("movies/")
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovie(@PathVariable Integer id){
        try {
            movieService.deleteMovie(id);
        } catch (MovieException e) {
            e.printStackTrace();
        }
    }
 
    @RequestMapping("default")
    public List<Movie> getCatalog(){

        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating(5, "okay", 1),
                new Rating(3, "okay", 2)
        );

       return ratings.stream().map(rating -> {
            try {
               return new Movie("Avengers", "poster", "synopsis", 2020);
            } catch (MovieException e) {
                e.printStackTrace();
                return null;
            }
       }).collect(Collectors.toList());


    }

}
