package org.example.dto;

import org.example.model.Priority;

public record CreateTicketRequest(
        String title,
        Priority priority
) {
}
