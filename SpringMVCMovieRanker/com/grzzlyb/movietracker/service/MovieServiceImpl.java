package com.grzzlyb.movietracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grzzlyb.movietracker.dao.MovieDAO;
import com.grzzlyb.movietracker.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public void saveMovie(Movie theMovie) {

		movieDAO.saveMovie(theMovie);

	}

	@Override
	@Transactional
	public Movie getMovie(int theId) {

		return movieDAO.getMovie(theId);
	}

	@Override
	@Transactional
	public void deleteMovie(int theId) {

		movieDAO.deleteMovie(theId);
	}

	@Override
	@Transactional
	public List<Movie> searchMovies(String theSearchName) {

		return movieDAO.searchMovies(theSearchName);
	}

}
