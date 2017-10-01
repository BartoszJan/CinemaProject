package com.mojafirma.model;

import com.mojafirma.gui.ShowingCheckoutPanel;
import com.mojafirma.model.dao.MovieDao;

import java.util.ArrayList;
import java.util.List;

public class DataPresenter {

    private MovieDao movieDao = new MovieDao();
    private List<Movie> movieList = new ArrayList<>();
    ShowingCheckoutPanel showingCheckoutPanel = new ShowingCheckoutPanel();

    public Movie showMovie(Integer movieID) {
        Movie movie = null;
        return movie;
    }
}
