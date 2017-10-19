package com.mojafirma.presenter.view;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.model.dao.TicketDao;
import com.mojafirma.presenter.TicketPresenter;

public class TicketView implements TicketPresenter{

    TicketDao ticketDao = new TicketDao();
    Ticket addingTicket = new Ticket();

    @Override
    public void addTicket() {
        ticketDao.addTicket(addingTicket);
    }

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
}
