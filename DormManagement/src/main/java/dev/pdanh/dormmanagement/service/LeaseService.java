package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.dto.request.LeaseCreateRequest;
import dev.pdanh.dormmanagement.dto.response.LeaseResponse;
import dev.pdanh.dormmanagement.mapper.LeaseMapper;
import dev.pdanh.dormmanagement.model.Lease;
import dev.pdanh.dormmanagement.model.Room;
import dev.pdanh.dormmanagement.repository.GuestRepository;
import dev.pdanh.dormmanagement.repository.LeaseRepository;
import dev.pdanh.dormmanagement.repository.RoomRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
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
    public List<Lease> findByRoom(Room room){
    return leaseRepository.findAllByRoom(room);
    }
}

