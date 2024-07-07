package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.DormCreateRequest;
import dev.pdanh.dormmanagement.dto.response.DormResponse;
import dev.pdanh.dormmanagement.model.Dorm;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class DormMapperImpl implements DormMapper {

    @Override
    public Dorm toDorm(DormCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Dorm dorm = new Dorm();

        dorm.setName( request.getName() );
        dorm.setNumberRoom( request.getNumberRoom() );
        dorm.setRoomsOnLease( request.getRoomsOnLease() );
        dorm.setAddress( request.getAddress() );
        dorm.setUser( request.getUser() );

        return dorm;
    }

    @Override
    public DormResponse toDormResponse(Dorm dorm) {
        if ( dorm == null ) {
            return null;
        }

        DormResponse.DormResponseBuilder dormResponse = DormResponse.builder();

        dormResponse.name( dorm.getName() );
        dormResponse.numberRoom( dorm.getNumberRoom() );
        dormResponse.address( dorm.getAddress() );
        dormResponse.roomsOnLease( dorm.getRoomsOnLease() );
        dormResponse.user( dorm.getUser() );

        return dormResponse.build();
    }

    @Override
    public Dorm toDorm(DormResponse response) {
        if ( response == null ) {
            return null;
        }

        Dorm dorm = new Dorm();

        dorm.setName( response.getName() );
        dorm.setNumberRoom( response.getNumberRoom() );
        dorm.setRoomsOnLease( response.getRoomsOnLease() );
        dorm.setAddress( response.getAddress() );
        dorm.setUser( response.getUser() );

        return dorm;
    }
}
