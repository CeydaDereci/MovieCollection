package com.example.moviecollection.service;

import com.example.moviecollection.model.Movie;
import com.example.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {
    private List<Movie> movies = new ArrayList<Movie>();

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


    public void addMovie(Movie m){
        Movie movie = new Movie(m.getMovieName(),m.getGenre(),m.getLanguage(),m.getInfo(),m.getReleaseYear());
        movieRepository.save(movie);
        movies.add(movie);
        System.out.println(movieRepository.findAll());
    }

    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }


    public Movie findById(long id){
        return movieRepository.findOne(id);
    }

    public void deleteMovieById(long id) {
        movieRepository.delete(id);
        movies.remove(movieRepository.findOne(id));
    }

    public List<Movie> retrieveMoviesName(String name) {
        List<Movie> filteredMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(name)) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

    public List<Movie> retrieveMoviesGenre(String genre) {
        List<Movie> filteredMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getGenre().equals(genre)) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }
}
