package dev.pdanh.dormmanagement.dto.request;

import dev.pdanh.dormmanagement.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DormUpdateRequest {

    int numberRoom;
    String address;
    User user;
}
