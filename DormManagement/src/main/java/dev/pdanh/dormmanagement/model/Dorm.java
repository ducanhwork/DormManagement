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
    int numberRoom;
    String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerID", unique = true)
     User user;

}
