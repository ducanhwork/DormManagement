package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.UserCreateRequest;
import dev.pdanh.dormmanagement.dto.request.UserUpdateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserResponse response) {
        if ( response == null ) {
            return null;
        }

        User user = new User();

        if ( response.getId() != null ) {
            user.setId( Integer.parseInt( response.getId() ) );
        }
        user.setFirstName( response.getFirstName() );
        user.setLastName( response.getLastName() );
        user.setGender( response.getGender() );
        user.setDob( response.getDob() );
        user.setPhoneNumber( response.getPhoneNumber() );
        user.setAddress( response.getAddress() );
        user.setIdentifyNumber( response.getIdentifyNumber() );
        user.setEmail( response.getEmail() );
        user.setUsername( response.getUsername() );
        user.setPassword( response.getPassword() );

        return user;
    }

    @Override
    public User toUser(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setGender( request.getGender() );
        user.setDob( request.getDob() );
        user.setPhoneNumber( request.getPhoneNumber() );
        user.setAddress( request.getAddress() );
        user.setIdentifyNumber( request.getIdentifyNumber() );
        user.setEmail( request.getEmail() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );

        return user;
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( String.valueOf( user.getId() ) );
        userResponse.firstName( user.getFirstName() );
        userResponse.lastName( user.getLastName() );
        userResponse.gender( user.getGender() );
        userResponse.dob( user.getDob() );
        userResponse.phoneNumber( user.getPhoneNumber() );
        userResponse.address( user.getAddress() );
        userResponse.identifyNumber( user.getIdentifyNumber() );
        userResponse.email( user.getEmail() );
        userResponse.username( user.getUsername() );
        userResponse.password( user.getPassword() );

        return userResponse.build();
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setGender( request.getGender() );
        user.setDob( request.getDob() );
        user.setPhoneNumber( request.getPhoneNumber() );
        user.setAddress( request.getAddress() );
        user.setIdentifyNumber( request.getIdentifyNumber() );
        user.setEmail( request.getEmail() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
    }
}
