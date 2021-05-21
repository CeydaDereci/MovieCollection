package com.example.moviecollection.controller;

import com.example.moviecollection.model.Movie;
import com.example.moviecollection.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MovieController {

    MovieService movieService;

    @RequestMapping(value = "/addMovie",method = RequestMethod.GET)
    public String addMoviePage(Model model){
        model.addAttribute("movie",new Movie());
        return "addMovie";
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public String handleMovieAdd(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addMovie";
        movieService.addMovie(movie);
        return "/movies";
    }

    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public String moviesPage(Model model){
        model.addAttribute("movieList", new Movie());
        //List<Movie> movieList = (List<Movie>) movieService.getMovies();
        //for(int i = 0;i < movieList.size() - 1;i++) {
            //model.addAttribute("movieList", movieList.get(i));}
        return "movies";
    }



    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable long id) {
        Movie m = movieService.findById(id);
        if (m != null) {
            movieService.deleteMovieById(id);
        }
    }

    /*
    public Movie findByName(@PathVariable String name){
        List<Movie> movieList = (List<Movie>) movieService.getMovies();
        for(int i = 0;i < movieList.size() - 1;i++) {
            if(movieList.get(i).getMovieName() == name)
                return movieList.get(i);
        }
        return null;
    }
    public Movie findByGenre(@PathVariable String genre){
        List<Movie> movieList = (List<Movie>) movieService.getMovies();
        for(int i = 0;i < movieList.size() - 1;i++) {
            if(movieList.get(i).getGenre() == genre)
                return movieList.get(i);
        }
        return null;
    }*/
    //TO DO
        //edit movie
        //public void sortMovies(){ }

}
