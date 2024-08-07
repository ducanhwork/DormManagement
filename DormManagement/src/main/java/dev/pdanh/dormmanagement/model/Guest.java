package dev.pdanh.dormmanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dob;
    String phoneNumber;
    String address;
    String identifyNumber;
    String email;

}
