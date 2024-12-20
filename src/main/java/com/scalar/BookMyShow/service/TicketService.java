package com.scalar.BookMyShow.service;

import com.scalar.BookMyShow.exception.SeatLockedException;
import com.scalar.BookMyShow.models.ShowSeat;
import com.scalar.BookMyShow.models.Ticket;
import com.scalar.BookMyShow.models.User;
import com.scalar.BookMyShow.models.constants.ShowSeatStatus;
import com.scalar.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {
    Ticket createTicket(List<Integer> showSeatIds, User user);

    @Service
    class Default implements TicketService{

        @Autowired
        ShowSeatRepository showSeatRepository;

        @Override
        @Transactional(isolation = Isolation.SERIALIZABLE)
        public Ticket createTicket(List<Integer> showSeatIds, User user) {
            List<ShowSeat> showSeats =  showSeatRepository.findAllById(showSeatIds);

            for(ShowSeat seat : showSeats){
                if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                    throw new SeatLockedException("Currently Seat Not Available to book.");
                }
            }

            for(ShowSeat seat : showSeats){
                seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                showSeatRepository.save(seat);
            }

            return new Ticket();
        }
    }
}
