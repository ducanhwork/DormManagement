package dev.pdanh.dormmanagement.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class GuestResponse {String firstName;
    String lastName;
    String gender;
    Date dob;
    String phoneNumber;
    String address;
    String identifyNumber;
    String email;
}
