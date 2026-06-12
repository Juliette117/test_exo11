package org.example.service;

import org.example.dto.CreateTicketRequest;
import org.example.model.Ticket;
import org.example.model.TicketStatus;
import org.example.repository.TicketRepository;

public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket(null, request.title(), request.priority(), TicketStatus.OPEN);
        return ticketRepository.save(ticket);
    }
}
