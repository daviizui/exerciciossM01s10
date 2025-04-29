package br.futurodev.joinville.m1s10.exercicio.dtos.logins;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
