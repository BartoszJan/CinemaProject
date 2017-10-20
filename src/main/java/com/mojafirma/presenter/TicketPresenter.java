package com.mojafirma.presenter;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.model.dao.TicketDao;

public interface TicketPresenter {

    TicketDao ticketDao = new TicketDao();
    Ticket addingTicket = new Ticket();

    default void addTicket() {
        ticketDao.addTicket(addingTicket);
    }

    default void setShowingAddingTicket(Showing showing) {
        addingTicket.setShowing(showing);
    }

    default void setUserNameAddingTicket(String name) {
        addingTicket.setUser_name(name);
    }

    default void setUserLastNameAddingTicket(String lastName) {
        addingTicket.setUser_last_name(lastName);
    }

    default void setSeatAddingTicket(int seatNumber) {
        addingTicket.setSeat(seatNumber);
    }
}
