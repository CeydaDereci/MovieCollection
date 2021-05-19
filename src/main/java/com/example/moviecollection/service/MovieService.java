package com.example.moviecollection.service;

import com.example.moviecollection.model.Movie;
import com.example.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie findByMovieName(String movieName){
        return movieRepository.findByMovieName(movieName);
    }

    public Movie findByGenre(String genre){
        return movieRepository.findByMovieName(genre);
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }
}
