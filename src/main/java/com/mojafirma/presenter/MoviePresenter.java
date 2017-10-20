package com.mojafirma.presenter;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;

import java.time.LocalDate;
import java.util.List;

public interface MoviePresenter {

    MovieDao movieDao = new MovieDao();
    Movie addingMovie = new Movie();

    default List<Movie> showMovieList() {
        return movieDao.getMovieList();
    }

    default void addMovie() {
        movieDao.addMovie(addingMovie);
    }

    default void setTitleAddingMovie(String title) {
        addingMovie.setTitle(title);
    }

    default void setYearAddingMovie(LocalDate year) {
        addingMovie.setYear(year);
    }

    default void setDurationAddingMovie(int duration) {
        addingMovie.setDuration(duration);
    }

    default void setDirectorAddingMovie(String director) {
        addingMovie.setDirector(director);
    }
}
