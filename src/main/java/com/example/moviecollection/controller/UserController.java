package com.example.moviecollection.controller;

import com.example.moviecollection.model.Movie;
import com.example.moviecollection.model.User;
import com.example.moviecollection.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.moviecollection.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    MovieService movieService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegisterPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);

        if (result.hasErrors()) {
            return "register";
        } else {
            userService.saveUser(user);

        }
        return "index";
    }

    @RequestMapping(value = "/addMovie",method = RequestMethod.GET)
    public String addMoviePage(Model model){
        model.addAttribute("movie",new Movie());
        return "addMovie";
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public String saveMoviePage(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model){
        model.addAttribute("movie", movie);
        if (bindingResult.hasErrors()) {
            return "addMovie";
        }
        else
            movieService.saveMovie(movie);
        return  "movies";
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index2() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "secure";
    }

    @RequestMapping("/movies")
    public String movies(){return "movies";}

    @RequestMapping("/addMovie")
    public String addMovie(){return "addMovie";}
}
