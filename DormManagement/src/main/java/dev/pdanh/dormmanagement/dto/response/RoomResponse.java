package dev.pdanh.dormmanagement.dto.response;


import dev.pdanh.dormmanagement.model.Dorm;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponse {
    Dorm dorm;
    int roomNum;
    boolean status;
}