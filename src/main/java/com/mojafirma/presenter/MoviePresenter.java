package com.mojafirma.presenter;

import com.mojafirma.model.Movie;

import java.util.List;

public interface MoviePresenter {

    List<Movie> showMovieList();

    void addMovie();
}
