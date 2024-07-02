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
    public User toUser(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        if ( request.getGender() != null ) {
            user.setGender( Boolean.parseBoolean( request.getGender() ) );
        }
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
        if ( user.getGender() != null ) {
            userResponse.gender( String.valueOf( user.getGender() ) );
        }
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
        if ( request.getGender() != null ) {
            user.setGender( Boolean.parseBoolean( request.getGender() ) );
        }
        else {
            user.setGender( null );
        }
        user.setDob( request.getDob() );
        user.setPhoneNumber( request.getPhoneNumber() );
        user.setAddress( request.getAddress() );
        user.setIdentifyNumber( request.getIdentifyNumber() );
        user.setEmail( request.getEmail() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
    }
}
