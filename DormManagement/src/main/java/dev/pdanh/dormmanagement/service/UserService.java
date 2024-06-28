package dev.pdanh.dormmanagement.service;

import dev.pdanh.dormmanagement.dto.request.AuthenticationRequest;
import dev.pdanh.dormmanagement.dto.request.UserCreateRequest;
import dev.pdanh.dormmanagement.dto.request.UserUpdateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public UserResponse createUser(UserCreateRequest request) {
        User user = new User();
        if (userRepository.findUserByUsername(request.getUsername()) != null || userRepository.findByEmail(request.getEmail()) != null) {
            return null;
        } else {
            user = userMapper.toUser(request);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);
            return userMapper.toUserResponse(user);
        }
    }

    public UserResponse getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(int id, UserUpdateRequest request) {
        User user = userRepository.findById(id + "").orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse loginUser(AuthenticationRequest request) {
        User user = (User) userRepository.findUserByUsername(request.getUsername()).orElseThrow(() -> {
            return null;
        });
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return userMapper.toUserResponse(user);
        }
        return null;
    }

}
