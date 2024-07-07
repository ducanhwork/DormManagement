package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.LeaseCreateRequest;
import dev.pdanh.dormmanagement.dto.response.LeaseResponse;
import dev.pdanh.dormmanagement.model.Lease;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaseMapper {
    Lease toLease(LeaseCreateRequest leaseCreateRequest);
    LeaseResponse toLeaseResponse(Lease lease);


}
