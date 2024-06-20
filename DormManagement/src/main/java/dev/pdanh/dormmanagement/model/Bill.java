package dev.pdanh.dormmanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomID")
    Room room;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID")
    Service service;
    int oldNum;
    int newNum;
    double serviceCost;
}
