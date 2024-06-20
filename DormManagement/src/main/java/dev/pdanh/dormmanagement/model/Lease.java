package dev.pdanh.dormmanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomID", unique = false)
    Room room;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guestID")
    Guest guest;
    Date startDate;
    Date endDate;
}
