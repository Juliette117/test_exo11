package org.example.service;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

public class TicketServiceTest {

    @Test
    void shouldCreateTicketWithGeneratedId() {

        CreateTicketRequest request = new CreateTicketRequest("Bug paiement", Priority.HIGH);

        when(ticketRepository.save(any(Ticket.class))).thenAnswer(invocation -> {
            Ticket ticket = invocation.getArgument(0);
            ticket.setId(1L);
            return ticket;
        });

        Ticket ticket = ticketService.createTicket(request);

        assertThat(ticket.getId()).isEqualTo(1L);
        assertThat(ticket.getTitle()).isEqualTo("Bug paiement");
        assertThat(ticket.getPriority()).isEqualTo(Priority.HIGH);
    }
}
