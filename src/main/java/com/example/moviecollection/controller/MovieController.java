package com.example.moviecollection.controller;

import com.example.moviecollection.model.Movie;
import com.example.moviecollection.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
        model.addAttribute("movie",new Movie());
        return "movies";
    }


}
