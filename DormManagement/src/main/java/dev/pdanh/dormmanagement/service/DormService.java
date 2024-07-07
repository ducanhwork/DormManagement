package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.dto.request.DormCreateRequest;
import dev.pdanh.dormmanagement.dto.response.DormResponse;
import dev.pdanh.dormmanagement.mapper.DormMapper;
import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.DormRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DormService {
    DormRepository repository;
    DormMapper dormMapper;

    public List<Dorm> getAll(User user){
        return repository.findAllByUser(user);
    }

    public DormResponse createDorm(DormCreateRequest request){
        Dorm dorm = dormMapper.toDorm(request);
        Dorm savedDorm = repository.save(dorm);
        return dormMapper.toDormResponse(savedDorm);
    }

    public Dorm findDormById(int id){
        Dorm dorm = repository.findById(id);
        return dorm != null ? dorm : null;
    }
}
