package pl.sda.sdaspringtraining.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.sdaspringtraining.api.model.NewUser;
import pl.sda.sdaspringtraining.domain.user.UserEntity;
import pl.sda.sdaspringtraining.domain.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(NewUser newUser) {
        UserEntity userEntity = UserEntity.builder()
                .login(newUser.getLogin())
                .password(passwordEncoder.encode(newUser.getPassword()))
                .role(newUser.getRole())
                .build();

        userRepository.save(userEntity);
    }
}
