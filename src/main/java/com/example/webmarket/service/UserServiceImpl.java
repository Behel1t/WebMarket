package com.example.webmarket.service;

import com.example.webmarket.Dto.SearchDTO;
import com.example.webmarket.Dto.UserDTO;
import com.example.webmarket.exc.StoreFailedException;
import com.example.webmarket.mapper.UserMapper;
import com.example.webmarket.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final UserRepository repository;
    @Override
    public List<UserDTO> findAll() {

        return mapper
                .toDtos(repository.findAll());
    }

    @Override
    public UserDTO find(Integer id) {
        var user=repository.findById(id)
                .orElseThrow(()->new StoreFailedException("User not found"));
        return mapper.toDto(user);
    }

    @Override
    public UserDTO update(Integer id, UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UserDTO buy(Integer id) {
        return null;
    }

    @Override
    public List<UserDTO> find(SearchDTO dto) {
        return null;
    }
}
