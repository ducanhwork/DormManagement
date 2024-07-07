package dev.pdanh.dormmanagement.dto.request;

import dev.pdanh.dormmanagement.model.User;

import lombok.*;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DormCreateRequest {
    String name;
    int numberRoom;
    String address;
     int roomsOnLease = 0;
    User user;

}
