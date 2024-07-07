package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.RoomCreateRequest;
import dev.pdanh.dormmanagement.dto.response.RoomResponse;
import dev.pdanh.dormmanagement.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomCreateRequest request);
    RoomResponse toRoomResponse(Room room);
}
