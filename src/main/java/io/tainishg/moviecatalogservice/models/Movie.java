package io.tainishg.moviecatalogservice.models;

import lombok.Data;

@Data
public class Movie {

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public Movie() {
    }

    private String movieId;
    private String name;

}
