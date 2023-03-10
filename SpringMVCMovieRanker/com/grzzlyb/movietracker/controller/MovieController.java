package com.grzzlyb.movietracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grzzlyb.movietracker.entity.Movie;
import com.grzzlyb.movietracker.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/list")
	public String listMovies(Model theModel) {

		List<Movie> theMovies = movieService.getMovies();

		theModel.addAttribute("movies", theMovies);

		return "list-movies";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Movie theMovie = new Movie();

		theModel.addAttribute("movie", theMovie);

		return "movie-form";
	}

	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie theMovie) {

		// Save the movie
		movieService.saveMovie(theMovie);

		return "redirect:/movie/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int theId, Model theModel) {

		Movie theMovie = movieService.getMovie(theId);

		theModel.addAttribute("movie", theMovie);

		return "movie-form";
	}

	@GetMapping("/delete")
	public String deleteMovie(@RequestParam("movieId") int theId) {

		movieService.deleteMovie(theId);

		return "redirect:/movie/list";
	}

	@GetMapping("/search")
	public String searchMovie(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		List<Movie> theMovies = movieService.searchMovies(theSearchName);

		theModel.addAttribute("movies", theMovies);

		return "list-movies";
	}

}
