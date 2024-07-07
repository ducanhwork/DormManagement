package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.RoomCreateRequest;
import dev.pdanh.dormmanagement.dto.response.RoomResponse;
import dev.pdanh.dormmanagement.model.Room;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toRoom(RoomCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Room room = new Room();

        room.setDorm( request.getDorm() );
        room.setRoomNum( request.getRoomNum() );
        room.setStatus( request.isStatus() );

        return room;
    }

    @Override
    public RoomResponse toRoomResponse(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomResponse.RoomResponseBuilder roomResponse = RoomResponse.builder();

        roomResponse.dorm( room.getDorm() );
        roomResponse.roomNum( room.getRoomNum() );
        roomResponse.status( room.isStatus() );

        return roomResponse.build();
    }
}
