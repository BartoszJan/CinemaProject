package com.mojafirma.presenter;

import com.mojafirma.gui.AddShowingPanel;
import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;

import java.util.List;


public class AddShowingPresenter {

    private MovieDao movieDao = new MovieDao();
    AddShowingPanel addShowingPanel = new AddShowingPanel();

    public AddShowingPresenter(AddShowingPanel addShowingPanel) {
        this.addShowingPanel = addShowingPanel;
    }

    public void showMovieList() {
        List<Movie> movies = movieDao.getMovieList();
        addShowingPanel.setMovieList(movies);
    }
}
