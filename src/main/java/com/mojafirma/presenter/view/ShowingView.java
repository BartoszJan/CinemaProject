package com.mojafirma.presenter.view;


import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.model.dao.ShowingDao;
import com.mojafirma.presenter.ShowingPresenter;

import java.time.LocalDateTime;

public class ShowingView implements ShowingPresenter{

    private ShowingDao showingDao = new ShowingDao();
    private Showing addingShowing = new Showing();


    @Override
    public Showing getShowing(Integer showingId) {
        return showingDao.getShowing(showingId);
    }

    @Override
    public void addShowing() {
        showingDao.addShowing(addingShowing);
    }

    public void setMovieAddingShowing(Movie movie) {
        addingShowing.setMovie(movie);
    }

    public void setDateTimeAddingShowing(LocalDateTime dateTime) {
        addingShowing.setMovie_date_time(dateTime);
    }

    public void setRoomAddingShowing(int roomNumber) {
        addingShowing.setRoom_number(roomNumber);
    }
}
