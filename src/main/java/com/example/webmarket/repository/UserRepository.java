package com.example.webmarket.repository;

import com.example.webmarket.model.ClotesType;
import com.example.webmarket.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity>findByType(ClotesType type);
    Optional<UserEntity>findByName(String name);
}