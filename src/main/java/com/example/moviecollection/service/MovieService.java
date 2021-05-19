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
        return movieRepository.findByGenre(genre);
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void addMovie(){
        Movie movie= new Movie();
        movieRepository.save(movie);
    }

    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovieById(long id) {
        movieRepository.delete(id);
    }
}
