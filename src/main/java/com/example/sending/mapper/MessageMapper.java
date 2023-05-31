package com.example.sending.mapper;

import com.example.sending.config.MappersConfig;
import com.example.sending.controller.dto.MessageRequest;
import com.example.sending.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappersConfig.class)
public interface MessageMapper {

    @Mapping(target = "users", ignore = true)
    @Mapping(target = "id", ignore = true)
    MessageEntity toMessageEntity (MessageRequest message);
}
