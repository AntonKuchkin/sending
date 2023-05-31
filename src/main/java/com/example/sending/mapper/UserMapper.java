package com.example.sending.mapper;

import com.example.sending.config.MappersConfig;
import com.example.sending.controller.dto.UserRequest;
import com.example.sending.controller.dto.UserResponse;
import com.example.sending.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappersConfig.class)
public interface UserMapper {

    @Mapping(target = "ChatId", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "id", ignore = true)
    UserEntity toUserEntity(UserRequest user);

    UserResponse toUserResponse (UserEntity user);
}
