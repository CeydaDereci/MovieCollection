package com.example.moviecollection.model;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "genre")
    private String genre;
    @Column(name = "language")
    private String language;
    @Column(name = "info")
    private String info;
    @Column(name = "release_year")
    private int releaseYear;

    public Movie(String movieName, String genre, String language, String info, int releaseYear) {
        this.movieName = movieName;
        this.genre = genre;
        this.language = language;
        this.info = info;
        this.releaseYear = releaseYear;
    }

    public Movie(){}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", info='" + info + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
