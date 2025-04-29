package br.futurodev.joinville.m1s10.exercicio.dtos.logins;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponseDto {
    private String type;
    private String token;
}
