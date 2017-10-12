package com.mojafirma.presenter.view;


import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;

import java.time.LocalDateTime;

public class ShowingView {

    Showing addingShowing = new Showing();

    public void setMovieAddingShowing(Movie movie) {
        addingShowing.setMovie(movie);
    }

    public void setDateTimeAddingShowing(LocalDateTime dateTime) {
        addingShowing.setMovie_date_time(dateTime);
    }

    public void setRoomAddingShwoing(int roomNumber) {
        addingShowing.setRoom_number(roomNumber);
    }

    public Showing getAddingShowing() {
        return addingShowing;
    }
}
