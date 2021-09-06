package com.example.movie.controller;

import com.example.movie.exception.MovieException;
import com.example.movie.model.Movie;
import com.example.movie.model.MovieSummary;
import com.example.movie.service.MovieService;
import com.example.movie.service.UpdateMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/movies/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{movieId}/")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        MovieSummary movieSummary = restTemplate.getForObject(
            "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
            MovieSummary.class
        );
        assert movieSummary != null;
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview(), movieSummary.getRelease_date());
    }

    @PostMapping("movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @GetMapping("movies/{movieId}")
    public Movie findMovie(@PathVariable Integer movieId) {
        Movie movie = null;
        try {
            movie = movieService.findMovie(movieId);
        } catch (MovieException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @PutMapping("movies/")
    public void updateMovie(@RequestBody UpdateMovie movieObj) {
        movieService.updateMovie(movieObj);
    }

    @GetMapping("movies/")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        try {
            movieService.deleteMovie(id);
        } catch (MovieException e) {
            e.printStackTrace();
        }
    }


}
