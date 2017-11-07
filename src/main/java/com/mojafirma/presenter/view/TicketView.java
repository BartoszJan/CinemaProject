package com.mojafirma.presenter.view;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.presenter.TicketPresenter;

public class TicketView implements TicketPresenter{

    @Override
    public void addTicket() {
        ticketDao.addTicket(addingTicket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketDao.deleteTicket(ticket);
    }

    @Override
    public void setShowingAddingTicket(Showing showing) {
        addingTicket.setShowing(showing);
    }

    @Override
    public void setUserNameAddingTicket(String name) {
        addingTicket.setUser_name(name);
    }

    @Override
    public void setUserLastNameAddingTicket(String lastName) {
        addingTicket.setUser_last_name(lastName);
    }

    @Override
    public void setSeatAddingTicket(int seatNumber) {
        addingTicket.setSeat(seatNumber);
    }
}
