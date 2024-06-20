package dev.pdanh.dormmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String firstName;
    String lastName;
    String gender;
    Date dob;
    String phoneNumber;
    String address;
    String identifyNumber;
    String email;
    String username;
    String password;
}
