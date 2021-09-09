package io.tainishg.moviecatalogservice.models;

import lombok.Data;

@Data
public class Rating {

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Rating() {
    }

    private String movieId;
    private int rating;


}
