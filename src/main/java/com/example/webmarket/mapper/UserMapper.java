package com.example.webmarket.mapper;

import com.example.webmarket.Dto.UserDTO;
import com.example.webmarket.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(UserEntity entity);
    UserEntity toEntity(UserDTO dto);
    List<UserDTO>toDtos(List<UserEntity> entities);

    @Mapping(target = "id", ignore = true)
    default void update(@MappingTarget UserEntity entity, UserDTO dto) {
        
    }

}
