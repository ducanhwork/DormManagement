package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.ExceptionHandler.ErrorCode;
import dev.pdanh.dormmanagement.dto.request.APIResponse;
import dev.pdanh.dormmanagement.dto.request.UserCreateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserController {
    UserService userService;
    @PostMapping
    public APIResponse<UserResponse> registerUser(@RequestBody UserCreateRequest request){
            return APIResponse.<UserResponse>builder()
                    .result(userService.createUser(request))
                    .build();
    }
}
