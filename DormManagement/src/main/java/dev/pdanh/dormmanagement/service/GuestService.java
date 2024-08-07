package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.repository.GuestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class GuestService {
    GuestRepository guestRepository;

}
