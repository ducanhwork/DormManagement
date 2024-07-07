package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.dto.request.LeaseCreateRequest;
import dev.pdanh.dormmanagement.dto.response.LeaseResponse;
import dev.pdanh.dormmanagement.mapper.LeaseMapper;
import dev.pdanh.dormmanagement.model.Lease;
import dev.pdanh.dormmanagement.repository.GuestRepository;
import dev.pdanh.dormmanagement.repository.LeaseRepository;
import dev.pdanh.dormmanagement.repository.RoomRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class LeaseService {
    LeaseRepository leaseRepository;
    GuestRepository guestRepository;
    RoomRepository roomRepository;
    LeaseMapper leaseMapper;
    public LeaseResponse createLease(LeaseCreateRequest request){
      Lease leaseSaved =   leaseRepository.save(leaseMapper.toLease(request));
        return leaseMapper.toLeaseResponse(leaseSaved);
    }
}

