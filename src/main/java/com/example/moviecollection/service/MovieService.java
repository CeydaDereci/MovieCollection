package com.example.moviecollection.service;

import com.example.moviecollection.model.Movie;
import com.example.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
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

    public void addMovie(Movie m){
        Movie movie = new Movie(m.getMovieName(),m.getGenre(),m.getLanguage(),m.getInfo(),m.getReleaseYear());
        movieRepository.save(movie);
    }

    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovieById(long id) {
        movieRepository.delete(id);
    }
}
