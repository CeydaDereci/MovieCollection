package com.example.moviecollection.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Release Year")
    private int year;
    @Column(name = "Genre")
    private String genre;
    @Column(name = "Info")
    private String info;
    @Column(name = "Language")
    private String language;

    @JoinTable(joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @ManyToMany(mappedBy = "films", fetch = FetchType.EAGER)
    private Collection<Actor> actors;

    public Movie(String name, int year, String genre, String info, String language) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.info = info;
        this.language = language;
    }

    public Movie() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name){this.name = name;}

    public String getName(){return name;}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre){this.genre = genre;}

    public String getGenre(){return genre;}

    public void setLanguage(String language){this.language = language;}

    public String getLanguage(){return language;}

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", info='" + info + '\'' +
                ", language='" + language + '\'' +
                ", actors=" + actors +
                '}';
    }

}
