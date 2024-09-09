package com.thl.ToDo.Config;

import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count()==0) {
            String encodedPassword = encoder.encode("00000000");
            User admin = new User();
            admin.setEmail("cheick@gmail.com");
            admin.setUsername("cheickna");
            admin.setPassword(encodedPassword);
            userRepository.save(admin);
        }
    }
}
