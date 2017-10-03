package com.mojafirma.model;

import com.mojafirma.HibernateUtil;
import com.mojafirma.gui.ShowingCheckoutPanel;
import com.mojafirma.model.dao.MovieDao;

import java.util.ArrayList;
import java.util.List;

public class DataPresenter {

    private MovieDao movieDao = new MovieDao();
    ShowingCheckoutPanel showingCheckoutPanel = new ShowingCheckoutPanel();

    public Movie showMovie(Integer movieID) {
        Movie movie = null;
        return movie;
    }

    public int movieListSize() {

        List<Movie> movieList = movieDao.getMovieList();
        return movieList.size();
    }

}
