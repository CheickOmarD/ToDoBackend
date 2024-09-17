package com.thl.ToDo.Config;

import com.thl.ToDo.Entity.Role;
import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Enums.ERole;
import com.thl.ToDo.Repository.RoleRepository;
import com.thl.ToDo.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private  final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count()==0) {
            String encodedPassword = encoder.encode("00000000");
            User admin = new User();
            admin.setEmail("cheickodi5@gmail.com");
            admin.setUsername("cheickna");
            admin.setPassword(encodedPassword);
            userRepository.save(admin);
        }
    }


    @PostConstruct
    public void initRoles() {
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
        if (roleRepository.findByName(ERole.ROLE_MODERATOR).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        }
    }

}
