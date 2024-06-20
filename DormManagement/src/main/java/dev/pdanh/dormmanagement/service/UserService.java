package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.ExceptionHandler.AppException;
import dev.pdanh.dormmanagement.ExceptionHandler.ErrorCode;
import dev.pdanh.dormmanagement.dto.request.UserCreateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    public UserResponse createUser(UserCreateRequest request) {
        User user = new User();
        if (userRepository.findUserByUsername(request.getUsername()) != null || userRepository.findByEmail(request.getEmail()) != null) {
            throw new AppException(ErrorCode.USER_EXISTED);
        } else {
            user = userMapper.toUser(request);
            userRepository.save(user);
            return userMapper.toUserResponse(user);
        }
    }

}
