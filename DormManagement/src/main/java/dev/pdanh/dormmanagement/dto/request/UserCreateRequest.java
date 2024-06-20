package dev.pdanh.dormmanagement.dto.request;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Size;
import java.util.Date;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
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
