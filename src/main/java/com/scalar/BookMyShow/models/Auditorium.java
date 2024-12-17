package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.AuditoriumFeature;
import com.scalar.BookMyShow.models.constants.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seats;
    @ManyToMany
    private List<Show> shows;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;
}
