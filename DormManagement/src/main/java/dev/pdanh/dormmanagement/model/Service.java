package dev.pdanh.dormmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    Double cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dormID", unique = false)
    Dorm dorm;
}
