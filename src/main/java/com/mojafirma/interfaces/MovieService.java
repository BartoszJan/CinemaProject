package com.mojafirma.interfaces;

import com.mojafirma.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> showMovieList();

    Movie getMovie(int id);

    void addMovie(Movie movie);

    void deleteMovie(Movie movie);

}
