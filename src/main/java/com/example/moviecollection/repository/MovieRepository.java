package com.example.moviecollection.repository;

import com.example.moviecollection.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
