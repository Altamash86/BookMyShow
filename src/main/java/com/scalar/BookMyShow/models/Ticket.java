package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import com.scalar.BookMyShow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private int totalAmount;
    private LocalDateTime timeOfBooking;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
