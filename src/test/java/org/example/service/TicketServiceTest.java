package org.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.example.dto.CreateTicketRequest;
import org.example.model.Priority;
import org.example.model.Ticket;
import org.example.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

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
