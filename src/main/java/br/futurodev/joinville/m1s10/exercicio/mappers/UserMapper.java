package br.futurodev.joinville.m1s10.exercicio.mappers;

import br.futurodev.joinville.m1s10.exercicio.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s10.exercicio.entities.User;

import java.util.List;

public class UserMapper {
    
    private UserMapper() {
        // Private constructor to prevent instantiation
    }
    
    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
    
    public static List<UserResponseDto> toDtos(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto)
                .toList();
    }
    
    public static User toEntity(User user, UserRequestDto dto) {
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }
}
