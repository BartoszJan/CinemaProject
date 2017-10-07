package com.mojafirma.presenter;

import com.mojafirma.gui.ShowingCheckoutPanel;
import com.mojafirma.gui.TicketReservationPanel;
import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.MovieDao;

import java.util.List;

/**
 * Created by Bartek on 2017-10-06.
 */
public class TicketReservationPresenter {

    private MovieDao movieDao = new MovieDao();
    TicketReservationPanel ticketReservationPanel = new TicketReservationPanel();

    public TicketReservationPresenter(TicketReservationPanel ticketReservationPanel) {
        this.ticketReservationPanel = ticketReservationPanel;
    }

    public void showMovieList() {
        List<Movie> movies = movieDao.getMovieList();
        ticketReservationPanel.setMovieList(movies);
    }
}
