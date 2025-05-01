package br.futurodev.joinville.m1s10.exercicio.services;

import br.futurodev.joinville.m1s10.exercicio.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.users.UserRequestDto;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService  {
    
    List<UserResponseDto> getAll();
    UserResponseDto getById(Long id);
    UserResponseDto create(UserRequestDto dto);
    UserResponseDto update(Long id, UserRequestDto dto);
    void delete(Long id);


}

