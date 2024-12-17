package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel {
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;
}
