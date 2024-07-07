package dev.pdanh.dormmanagement.dto.response;

import dev.pdanh.dormmanagement.model.Guest;
import dev.pdanh.dormmanagement.model.Room;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaseResponse {
    Room room;
    Guest guest;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date endDate;
}
