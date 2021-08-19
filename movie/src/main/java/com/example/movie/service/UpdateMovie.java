package com.example.movie.service;

import com.example.movie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovie {
    private Integer id;
    private String newName;
    private String newPoster;
    private String newSynopsis;
    private Integer newYearOfProduction;



    Movie updateMovie(UpdateMovie movieObj){
        Movie newMovie = new Movie();
        newMovie.setMovieId(movieObj.getId());
        newMovie.setName(movieObj.getNewName());
        newMovie.setPoster(movieObj.getNewPoster());
        newMovie.setSynopsis(movieObj.getNewSynopsis());
        newMovie.setYearOfProduction(movieObj.getNewYearOfProduction());

        return newMovie;

    }




}
