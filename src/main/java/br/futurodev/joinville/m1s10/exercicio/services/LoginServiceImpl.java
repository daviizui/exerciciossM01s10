package br.futurodev.joinville.m1s10.exercicio.services;

import br.futurodev.joinville.m1s10.exercicio.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s10.exercicio.entities.User;
import br.futurodev.joinville.m1s10.exercicio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {



    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public LoginResponseDto authenticate(LoginRequestDto dto) {
        User user = repository.findByUsername(dto.getUsername()).orElseThrow();
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            throw new BadCredentialsException("Invalid username or password");
        }
        String token = Base64.getEncoder().encodeToString(
                (user.getUsername() + ":" + dto.getPassword()).getBytes()
        );
        return LoginResponseDto.builder().type("Basic").token(token).build();
    }


}
