package io.tainishg.moviecatalogservice.services;

import io.tainishg.moviecatalogservice.models.CatalogItem;
import io.tainishg.moviecatalogservice.models.Movie;
import io.tainishg.moviecatalogservice.models.Rating;
import io.tainishg.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieCatalogService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder builder;

    private List<CatalogItem> catalogItems = new ArrayList<>
            (Arrays.asList(new CatalogItem("Transformers", "Test", 4),
                    new CatalogItem("Titanic", "Test", 5)));

//    public List<CatalogItem> getCatalogItems() {
//        return catalogItems;
//    }

    public List<CatalogItem> getCatalogItemByUserId(String userId) {


//        List<Rating> ratings = builder.build()
//                .get()
//                .uri("http://localhost:8082/ratings/users/" + userId)
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<Rating>>() {
//                })
//                .block();

        UserRating userRating = builder.build()
                .get()
                .uri("http://localhost:8082/ratings/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();


//        List<Rating> ratings = new ArrayList<>(Arrays.asList(
//                new Rating("1111", 4),
//                new Rating("2222", 5)
//
//        ));
        return userRating.getUserRating().stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            Movie movie = builder.build()
                    .get()
                    .uri("http://localhost:8081/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            if (movie != null) return new CatalogItem(movie.getName(), "Desc", rating.getRating());
            else return null;

        }).collect(Collectors.toList());
    }

//    public List<CatalogItem> getCatalogItems() {
//
//        List<Rating> ratings = new ArrayList<>(Arrays.asList(
//                new Rating("1111", 4),
//                new Rating("2222", 5)
//
//        ));
//        return ratings.stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
//            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
//        }).collect(Collectors.toList());
//    }

//    public List<CatalogItem> getCatalogItems() {
//
//        List<Rating> ratings = new ArrayList<>(Arrays.asList(
//                new Rating("1111", 4),
//                new Rating("2222", 5)
//
//        ));
//        return ratings.stream().map(rating -> {
////            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
//            Movie movie = builder.build()
//                    .get()
//                    .uri("http://localhost:8081/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
//
//            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
//
//        }).collect(Collectors.toList());
//    }

    public List<CatalogItem> getCatalogItems() {

        List<Rating> ratings = new ArrayList<>(Arrays.asList(
                new Rating("1111", 4),
                new Rating("2222", 5)

        ));
        return ratings.stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            Movie movie = builder.build()
                    .get()
                    .uri("http://localhost:8081/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(movie.getName(), "Desc", rating.getRating());

        }).collect(Collectors.toList());
    }

}
