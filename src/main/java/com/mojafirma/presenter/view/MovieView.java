package com.mojafirma.presenter.view;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;

import java.util.ArrayList;
import java.util.List;

public class MovieView {

    private List<Movie> movieList = new ArrayList<>();
    private List<Showing> showingList = new ArrayList<>();

    public void setMovieList(List<Movie> movies) {
        movieList = movies;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setShowingList(List<Showing> showingList) {
        this.showingList = showingList;
    }

    public List<Showing> getShowingList() {
        return showingList;
    }
}


