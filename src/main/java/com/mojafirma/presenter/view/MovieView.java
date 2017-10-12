package com.mojafirma.presenter.view;

import com.mojafirma.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieView {

    private List<Movie> movieList = new ArrayList<>();
    private Movie addingMovie = new Movie();

    public void setMovieList(List<Movie> movies) {
        movieList = movies;
    }

    public List<Movie> getMovieList() {
        return movieList;
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

    public Movie getAddingMovie() {
        return addingMovie;
    }
}


