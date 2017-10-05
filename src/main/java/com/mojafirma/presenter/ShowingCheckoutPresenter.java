package com.mojafirma.presenter;

import com.mojafirma.gui.ShowingCheckoutPanel;
import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;
import com.mojafirma.model.dao.ShowingDao;

import java.util.List;

public class ShowingCheckoutPresenter {

    private MovieDao movieDao = new MovieDao();
    ShowingCheckoutPanel showingCheckoutPanel = new ShowingCheckoutPanel();

    public ShowingCheckoutPresenter(ShowingCheckoutPanel showingCheckoutPanel) {
        this.showingCheckoutPanel = showingCheckoutPanel;
    }

    public void showMovie(Integer movieID) {
        Movie movie = movieDao.getMovie(movieID);
        showingCheckoutPanel.setMovieYear(movie.getYear());
        showingCheckoutPanel.setMovieDirector(movie.getDirector());
        showingCheckoutPanel.setMOvieDuration("" + movie.getDuration());
        showingCheckoutPanel.setShowings(movie.getShowings());
    }

    public void showMovieList() {
        List<Movie> allMovies = movieDao.getMovieList();
        showingCheckoutPanel.setMovieList(allMovies);
    }

}
