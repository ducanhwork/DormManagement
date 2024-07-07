package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.GuestCreateRequest;
import dev.pdanh.dormmanagement.dto.response.GuestResponse;
import dev.pdanh.dormmanagement.model.Guest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper {
    Guest toGuest(GuestCreateRequest request);
    GuestResponse toGuestResponse(Guest guest);
    Guest toGuest(GuestResponse response);
}
