package br.futurodev.joinville.m1s10.exercicio.services;

import br.futurodev.joinville.m1s10.exercicio.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s10.exercicio.entities.User;
import br.futurodev.joinville.m1s10.exercicio.enums.UserRole;
import br.futurodev.joinville.m1s10.exercicio.mappers.UserMapper;
import br.futurodev.joinville.m1s10.exercicio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASS = "admin";

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDto> getAll() {
        List<User> users = repository.findAll();
        return UserMapper.toDtos(users);
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = findEntityById(id);
        return UserMapper.toDto(user);
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = new User();
        UserMapper.toEntity(user, dto);

        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = repository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        User user = findEntityById(id);
        UserMapper.toEntity(user, dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = repository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public void delete(Long id) {
        User user = findEntityById(id);
        repository.delete(user);

    }

    private User findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  repository.findByUsername(username);
        if (user.isPresent()){
            return user.get();
        }
        if ((username.equals(DEFAULT_USER))){
            return User.builder()
                    .id(0L)
                    .name("ROOT")
                    .username(DEFAULT_USER)
                    .password(passwordEncoder.encode(DEFAULT_PASS))
                    .role(UserRole.valueOf("ADMIN"))
                    .build();
        }
        throw new UsernameNotFoundException(username);
    }
}
