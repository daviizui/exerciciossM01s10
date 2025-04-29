package br.futurodev.joinville.m1s10.exercicio.dtos.users;

import br.futurodev.joinville.m1s10.exercicio.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private UserRole role;
}
