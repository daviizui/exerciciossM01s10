package br.futurodev.joinville.m1s10.exercicio.repositories;

import br.futurodev.joinville.m1s10.exercicio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUsername(String username);
    
}
