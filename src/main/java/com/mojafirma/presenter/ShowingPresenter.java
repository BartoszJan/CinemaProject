package com.mojafirma.presenter;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDao;

import java.time.LocalDateTime;

public interface ShowingPresenter {

    ShowingDao showingDao = new ShowingDao();
    Showing addingShowing = new Showing();

    default Showing getShowing(Integer showingId) {
        return showingDao.getShowing(showingId);
    }

    default void addShowing() {
        showingDao.addShowing(addingShowing);
    }

    default void setMovieAddingShowing(Movie movie) {
        addingShowing.setMovie(movie);
    }

    default void setDateTimeAddingShowing(LocalDateTime dateTime) {
        addingShowing.setMovie_date_time(dateTime);
    }

    default void setRoomAddingShowing(int roomNumber) {
        addingShowing.setRoom_number(roomNumber);
    }
}
