package dev.pdanh.dormmanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int numberRoom;
    int roomsOnLease = 0 ;
    String address;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ownerID",unique = false)
    User user;

}
