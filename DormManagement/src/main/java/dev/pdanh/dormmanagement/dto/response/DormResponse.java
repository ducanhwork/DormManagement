package dev.pdanh.dormmanagement.dto.response;

import dev.pdanh.dormmanagement.model.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DormResponse {
    String name;
    int numberRoom;
    String address;
    int roomsOnLease;
    User user;
}
