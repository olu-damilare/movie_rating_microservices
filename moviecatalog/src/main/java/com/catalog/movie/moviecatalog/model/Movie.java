package com.catalog.movie.moviecatalog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Integer movieId;
    private String title;
    private String poster;
    private String synopsis;
    private LocalDate dateOfEntry;
    private Integer yearOfProduction;


    public Movie(String title, String poster, String synopsis, Integer yearOfProduction) {
        this.title = title;
        this.poster = poster;
        this.synopsis = synopsis;
        dateOfEntry = LocalDate.now();
        this.yearOfProduction = yearOfProduction;
    }
}
