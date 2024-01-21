package com.example.webmarket.service;

import com.example.webmarket.Dto.SearchDto;
import com.example.webmarket.Dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto>findAll();
    UserDto find(Integer id);
    UserDto update(Integer id, UserDto dto);
    UserDto save(UserDto dto);
    void delete(Integer id);
    List<UserDto>find(SearchDto dto);
    UserDto findByName(String username);

    UserDto findByUsername(String username);
}
