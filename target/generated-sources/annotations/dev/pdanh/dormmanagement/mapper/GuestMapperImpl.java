package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.GuestCreateRequest;
import dev.pdanh.dormmanagement.dto.response.GuestResponse;
import dev.pdanh.dormmanagement.model.Guest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public Guest toGuest(GuestCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setFirstName( request.getFirstName() );
        guest.setLastName( request.getLastName() );
        guest.setGender( request.getGender() );
        guest.setDob( request.getDob() );
        guest.setPhoneNumber( request.getPhoneNumber() );
        guest.setAddress( request.getAddress() );
        guest.setIdentifyNumber( request.getIdentifyNumber() );
        guest.setEmail( request.getEmail() );

        return guest;
    }

    @Override
    public GuestResponse toGuestResponse(Guest guest) {
        if ( guest == null ) {
            return null;
        }

        GuestResponse.GuestResponseBuilder guestResponse = GuestResponse.builder();

        guestResponse.firstName( guest.getFirstName() );
        guestResponse.lastName( guest.getLastName() );
        guestResponse.gender( guest.getGender() );
        guestResponse.dob( guest.getDob() );
        guestResponse.phoneNumber( guest.getPhoneNumber() );
        guestResponse.address( guest.getAddress() );
        guestResponse.identifyNumber( guest.getIdentifyNumber() );
        guestResponse.email( guest.getEmail() );

        return guestResponse.build();
    }

    @Override
    public Guest toGuest(GuestResponse response) {
        if ( response == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setFirstName( response.getFirstName() );
        guest.setLastName( response.getLastName() );
        guest.setGender( response.getGender() );
        guest.setDob( response.getDob() );
        guest.setPhoneNumber( response.getPhoneNumber() );
        guest.setAddress( response.getAddress() );
        guest.setIdentifyNumber( response.getIdentifyNumber() );
        guest.setEmail( response.getEmail() );

        return guest;
    }
}
