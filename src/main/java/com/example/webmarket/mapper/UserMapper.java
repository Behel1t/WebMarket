package com.example.webmarket.mapper;

import com.example.webmarket.Dto.UserDto;
import com.example.webmarket.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserEntity entity);
    UserEntity toEntity(UserDto dto);
    List<UserDto>toDtos(List<UserEntity> entities);

    @Mapping(target = "id", ignore = true)
    default void update(@MappingTarget UserEntity entity, UserDto dto) {

    }

}
