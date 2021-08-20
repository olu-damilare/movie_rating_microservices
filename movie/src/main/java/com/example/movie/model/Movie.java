package com.example.movie.model;

import com.example.movie.exception.MovieException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    @Id
    private Integer movieId;
    private String name;
    private String poster;
    private String synopsis;
    private LocalDate dateOfEntry;
    private Integer yearOfProduction;


    public Movie(String name, String poster, String synopsis, Integer yearOfProduction) throws MovieException {
        if (yearOfProduction == null) throw new MovieException("Please provide the year of production");
        if (yearOfProduction <= 100) throw new MovieException("Invalid year");
        if (yearOfProduction > LocalDateTime.now().getYear())
            throw new MovieException("Provided year is later than current year");
        if (name == null) throw new MovieException("Please provide the name of the movie");
        if (synopsis == null) throw new MovieException("Please provide a synopsis for the movie");

        this.name = name;
        this.poster = poster;
        this.synopsis = synopsis;
        dateOfEntry = LocalDate.now();
        this.yearOfProduction = yearOfProduction;
    }
}
