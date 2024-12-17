package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import com.scalar.BookMyShow.models.constants.SeatStatus;
import com.scalar.BookMyShow.models.constants.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

}
