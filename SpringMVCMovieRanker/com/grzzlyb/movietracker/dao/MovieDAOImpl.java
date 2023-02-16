package com.grzzlyb.movietracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grzzlyb.movietracker.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getMovies() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Movie> theQuery = currentSession.createQuery("from Movie order by rating DESC", Movie.class);

		List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public void saveMovie(Movie theMovie) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the movie to the database
		currentSession.saveOrUpdate(theMovie);
	}

	@Override
	public Movie getMovie(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Movie theMovie = currentSession.get(Movie.class, theId);

		return theMovie;
	}

	@Override
	public void deleteMovie(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Movie where id=:movieId");

		theQuery.setParameter("movieId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Movie> searchMovies(String theSearchName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if (theSearchName != null && theSearchName.trim().length() > 0) {

			theQuery = currentSession.createQuery("from Movie where movieName like :theName or genre like :theName",
					Movie.class);

			theQuery.setParameter("theName", "%" + theSearchName + "%");
		} else {

			theQuery = currentSession.createQuery("from Movie", Movie.class);
		}

		List<Movie> movies = theQuery.getResultList();
		
		System.out.println("theMovies: " + movies);

		return movies;
	}

}
