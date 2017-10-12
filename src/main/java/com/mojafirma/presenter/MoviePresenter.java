package com.mojafirma.presenter;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;
import com.mojafirma.presenter.view.MovieView;

import java.util.List;

/**
 * Created by Bartek on 2017-10-12.
 */
public class MoviePresenter {

    private MovieDao movieDao = new MovieDao();
    MovieView movieView = new MovieView();

    public MoviePresenter(MovieView movieView) {
        this.movieView = movieView;
    }

    public void showMovieList() {
        List<Movie> allMovies = movieDao.getMovieList();
        movieView.setMovieList(allMovies);
    }
}
