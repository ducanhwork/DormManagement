package dev.pdanh.dormmanagement.mapper;

import dev.pdanh.dormmanagement.dto.request.DormCreateRequest;
import dev.pdanh.dormmanagement.dto.response.DormResponse;
import dev.pdanh.dormmanagement.model.Dorm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DormMapper {
    Dorm toDorm(DormCreateRequest request);
    DormResponse toDormResponse(Dorm dorm);
}
