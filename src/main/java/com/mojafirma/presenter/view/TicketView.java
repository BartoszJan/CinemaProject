package com.mojafirma.presenter.view;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;

public class TicketView {

    Ticket addingTicket = new Ticket();

    public void setShowingAddingTicket(Showing showing) {
        addingTicket.setShowing(showing);
    }

    public void setUserNameAddingTicket(String name) {
        addingTicket.setUser_name(name);
    }

    public void setUserLastNameAddingTicket(String lastName) {
        addingTicket.setUser_last_name(lastName);
    }

    public void setSeatAddingTicket(int seatNumber) {
        addingTicket.setSeat(seatNumber);
    }

    public Ticket getAddingTicket() {
        return addingTicket;
    }
}
