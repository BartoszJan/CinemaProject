package com.mojafirma.presenter;

import com.mojafirma.model.Ticket;
import com.mojafirma.model.dao.TicketDao;
import com.mojafirma.presenter.view.TicketView;

/**
 * Created by Bartek on 2017-10-12.
 */
public class TicketPresenter {

    private TicketDao ticketDao = new TicketDao();
    TicketView ticketView = new TicketView();

    public TicketPresenter(TicketView ticketView) {
        this.ticketView = ticketView;
    }

    public void addTicket() {
        ticketDao.addTicket(ticketView.getAddingTicket());
    }
}
