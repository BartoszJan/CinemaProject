package com.mojafirma.service;

import com.mojafirma.model.Ticket;
import com.mojafirma.interfaces.TicketService;
import com.mojafirma.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(int ticketId) {
        return ticketRepository.findOne(ticketId);
    }

    @Override
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }
}
