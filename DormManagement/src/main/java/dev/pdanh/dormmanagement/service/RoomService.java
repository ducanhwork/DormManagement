package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.dto.request.RoomCreateRequest;
import dev.pdanh.dormmanagement.dto.response.RoomResponse;
import dev.pdanh.dormmanagement.mapper.RoomMapper;
import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.Room;
import dev.pdanh.dormmanagement.repository.RoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomService {
    RoomRepository roomRepository;
    RoomMapper roomMapper;

    public RoomResponse createRoom(RoomCreateRequest request) {
        Room room = roomMapper.toRoom(request);
        roomRepository.save(room);
        return roomMapper.toRoomResponse(room);
    }

    public List<Room> getAll(Dorm dorm) {
        return roomRepository.findAllByDorm(dorm);
    }
}
