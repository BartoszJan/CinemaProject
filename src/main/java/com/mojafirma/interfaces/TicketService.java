package com.mojafirma.interfaces;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    Ticket getTicket(int ticketId);

    List<Ticket> getTickets();

    void deleteTicket(Ticket ticket);
}
