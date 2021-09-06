package com.example.movie.service;

import com.example.movie.exception.MovieException;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie findMovie(Integer id) throws MovieException {
        log.info("ggggg");
        return movieRepository.findById(id).orElseThrow(() -> new MovieException("Invalid movie id"));
    }

    @Override
    public void addMovie(Movie movie) {
        movie.setDateOfEntry(LocalDate.now());
        movieRepository.save(movie);

    }

    @Override
    public void updateMovie(UpdateMovie movieObj) {
        try {

            Movie movieToUpdate = findMovie(movieObj.getId());
            if (movieObj.getNewName() != null) movieToUpdate.setTitle(movieObj.getNewName());
            if (movieObj.getNewPoster() != null) movieToUpdate.setPoster(movieObj.getNewPoster());
            if (movieObj.getNewSynopsis() != null) movieToUpdate.setSynopsis(movieObj.getNewSynopsis());
            if (movieObj.getNewYearOfProduction() != null)
                movieToUpdate.setYearOfProduction(movieObj.getNewYearOfProduction());

            movieRepository.save(movieToUpdate);
        } catch (MovieException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovie(Integer id) throws MovieException {
        Movie movieToDelete = findMovie(id);
        movieRepository.delete(movieToDelete);
    }
}
