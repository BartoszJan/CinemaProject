package com.mojafirma.presenter.view;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;
import com.mojafirma.presenter.MoviePresenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieView implements MoviePresenter {

    private List<Movie> movieList = new ArrayList<>();
    private Movie addingMovie = new Movie();
    private MovieDao movieDao = new MovieDao();

    @Override
    public List<Movie> showMovieList() {
        movieList = movieDao.getMovieList();
        return movieList;
    }

    @Override
    public void addMovie() {
        movieDao.addMovie(addingMovie);
    }

    public void setTitleAddingMovie(String title) {
        addingMovie.setTitle(title);
    }

    public void setYearAddingMovie(LocalDate year) {
        addingMovie.setYear(year);
    }

    public void setDurationAddingMovie(int duration) {
        addingMovie.setDuration(duration);
    }

    public void setDirectorAddingMovie(String director) {
        addingMovie.setDirector(director);
    }
}


