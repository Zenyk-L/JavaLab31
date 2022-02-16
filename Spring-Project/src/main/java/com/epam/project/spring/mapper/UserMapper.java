package com.epam.project.spring.mapper;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.dto.UserWithPasswordDto;
import com.epam.project.spring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userWithPasswordDto.role", target = "role")
    User mapUserWithPasswordDtoToUser(UserWithPasswordDto userWithPasswordDto);

    @Mapping(source = "user.role", target = "role")
    UserDto mapUserToUserDto(User user);

}
