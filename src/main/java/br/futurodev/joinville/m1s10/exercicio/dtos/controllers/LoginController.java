package br.futurodev.joinville.m1s10.exercicio.dtos.controllers;

import br.futurodev.joinville.m1s10.exercicio.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s10.exercicio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService service;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        return service.authenticate(dto);
    }
}
