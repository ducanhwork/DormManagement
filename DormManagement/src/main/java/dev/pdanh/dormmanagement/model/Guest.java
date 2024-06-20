package dev.pdanh.dormmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity

@Data

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String firstName;
    String lastName;
    String gender;
    Date dob;
    String phoneNumber;
    String address;
    String identifyNumber;
    String email;
}
