package dev.pdanh.dormmanagement.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserUpdateRequest {
    String firstName;
    String lastName;
    String gender;
    Date dob;
    @Size(min = 10,max = 10, message = "PHONENUMBER_LENGTH")
    String phoneNumber;
    String address;
    String identifyNumber;
    String email;
    String username;
    @Size(min = 8, message = "PASSWORD_ERROR")
    String password;
}
