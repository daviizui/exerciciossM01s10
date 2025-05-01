package br.futurodev.joinville.m1s10.exercicio.services;

import br.futurodev.joinville.m1s10.exercicio.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.logins.LoginResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService {

    LoginResponseDto authenticate(LoginRequestDto dto);
}
