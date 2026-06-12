package org.example.service;

import org.example.dto.CreateTicketRequest;
import org.example.exception.TicketValidationException;
import org.example.model.Ticket;
import org.example.model.TicketStatus;
import org.example.repository.TicketRepository;

public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(CreateTicketRequest request) {
        String title = request.title() == null ? "" : request.title().trim();
        if (title.length() < 3) {
            throw new TicketValidationException("Le titre doit contenir au moins 3 caracteres utiles");
        }
        if (request.priority() == null) {
            throw new TicketValidationException("La priorité est obligatoire");
        }

        Ticket ticket = new Ticket(null, title, request.priority(), TicketStatus.OPEN);
        return ticketRepository.save(ticket);
    }
}
