package dev.pdanh.dormmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class GuestCreateRequest {
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
