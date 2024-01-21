package com.example.webmarket.service.impl;

import com.example.webmarket.Dto.SearchDto;
import com.example.webmarket.Dto.UserDto;
import com.example.webmarket.exc.StoreFailedException;
import com.example.webmarket.mapper.UserMapper;
import com.example.webmarket.repository.UserRepository;
import com.example.webmarket.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public  class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final UserRepository repository;
    @Override
    public List<UserDto> findAll() {

        return mapper
                .toDtos( repository.findAll());
    }

    @Override
    public UserDto find(Integer id) {
        var user=repository.findById(id)
                .orElseThrow(()->new StoreFailedException("User not found"));
        return mapper.toDto(user);
    }

    @Override
    public UserDto update(Integer id, UserDto dto) {
        var user=repository.findById(id)
                .orElseThrow(()-> new StoreFailedException("User not found"));
        mapper.update(user,dto);
        return mapper.toDto(user);
    }

    @Override
    public UserDto save(UserDto dto) {
        return mapper.
                toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer id) {
        var user=repository.findById(id)
                .orElseThrow(()-> new StoreFailedException("User not found"));
        repository.delete(user);
    }

    @Override
    public List<UserDto> find(SearchDto dto) {
        var type = dto.getType();
        return mapper.toDtos(repository.findByType(type));
    }

    @Override
    public UserDto findByName(String username) {
        return null;
    }

    @Override
    public UserDto findByUsername(String username) {
        return mapper.toDto(repository.findByUsername(username)
                .orElseThrow(()-> new StoreFailedException("User not found")));
    }
}


