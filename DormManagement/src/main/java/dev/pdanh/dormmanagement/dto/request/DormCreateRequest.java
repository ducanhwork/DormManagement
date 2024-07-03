package dev.pdanh.dormmanagement.dto.request;

import dev.pdanh.dormmanagement.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    User user;

}
