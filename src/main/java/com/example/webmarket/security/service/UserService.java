package com.example.webmarket.security.service;

import com.example.webmarket.security.dto.UserDto;
import com.example.webmarket.security.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
