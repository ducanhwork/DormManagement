package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.LeaseCreateRequest;
import dev.pdanh.dormmanagement.dto.response.LeaseResponse;
import dev.pdanh.dormmanagement.model.Lease;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class LeaseMapperImpl implements LeaseMapper {

    @Override
    public Lease toLease(LeaseCreateRequest leaseCreateRequest) {
        if ( leaseCreateRequest == null ) {
            return null;
        }

        Lease lease = new Lease();

        lease.setRoom( leaseCreateRequest.getRoom() );
        lease.setGuest( leaseCreateRequest.getGuest() );
        lease.setStartDate( leaseCreateRequest.getStartDate() );
        lease.setEndDate( leaseCreateRequest.getEndDate() );

        return lease;
    }

    @Override
    public LeaseResponse toLeaseResponse(Lease lease) {
        if ( lease == null ) {
            return null;
        }

        LeaseResponse leaseResponse = new LeaseResponse();

        leaseResponse.setRoom( lease.getRoom() );
        leaseResponse.setGuest( lease.getGuest() );
        leaseResponse.setStartDate( lease.getStartDate() );
        leaseResponse.setEndDate( lease.getEndDate() );

        return leaseResponse;
    }
}
