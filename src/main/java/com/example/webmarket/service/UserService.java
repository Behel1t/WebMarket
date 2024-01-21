package com.example.webmarket.service;

import com.example.webmarket.Dto.SearchDTO;
import com.example.webmarket.Dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO>findAll();
    UserDTO find(Integer id);
    UserDTO update(Integer id,UserDTO dto);
    UserDTO save(UserDTO dto);
    void delete(Integer id);
    UserDTO buy(Integer id);
    List<UserDTO>find(SearchDTO dto);

}
