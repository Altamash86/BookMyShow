package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import com.scalar.BookMyShow.models.constants.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ShowSeat extends BaseModel {
    private int price;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
