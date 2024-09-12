package com.thl.ToDo.Service;

import com.thl.ToDo.Entity.Role;
import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Enums.ERole;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Repository.RoleRepository;
import com.thl.ToDo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private  final RoleRepository roleRepository;
    private  final UserRepository userRepository;
    private  final UserRepository repository;
    private  final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return repository.findAll();
    }

    @Override
    public User fetchUserById(Long userId )  throws NotFoundException{
        Optional<User>  user = repository.findById(userId);
        if(user.isPresent()) {
            throw new NotFoundException(("Ce utilisateur n'existe pas !"));
        }
        return repository.findById(userId).get();
    }


    @Override
    public String deleteUserById(Long userId) {
        return " Cet Id à été Supprimé avec succès!";

    }

    @Override
    public User update(User user) {

        Optional<User> optionalUserDB = repository.findById(user.getId());

        if (optionalUserDB.isPresent()) {
            User userToUpdate = optionalUserDB.get();
            if (!user.getUsername().trim().isEmpty()) {
                userToUpdate.setUsername(user.getUsername());
            }
            if (!user.getLastName().trim().isEmpty()) {
                userToUpdate.setLastName(user.getLastName());
            }

            if (!user.getEmail().trim().isEmpty()) {
                userToUpdate.setEmail(user.getEmail());
            }
            if (!user.getPassword().trim().isEmpty()) {
                userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return repository.save(userToUpdate);

        }
        else {
            throw new NotFoundException("User non trouvé avec l'ID : " + user.getId());
        }
    }

    @Override
    public Optional<User> findById(Long userId) {
       return repository.findById(userId);
    }

    @Override
    public User getAuthor() {
        return null;
    }

    public User registerUser(User user) {
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Erreur : Rôle non trouvé."));

        user.setRoles(Collections.singleton(userRole));
        System.out.println("Rôle assigné à l'utilisateur : " + user.getRoleNames());

        return userRepository.save(user);

    }

    @Override
    public void assignRole(User user) {

        User userToAssign = userRepository.findById(user.getId()).orElseThrow(()
                -> new  NotFoundException("")
        );
        Set<Role> rolesList = user.getRoles();
        for (Role role : rolesList ) {
            Optional<Role> name = roleRepository.findByName(role.getName());
            if (name.isEmpty()) {
               throw new NotFoundException("Ce nom role n'existe pas") ;
            }
        }
        userToAssign.setRoles(user.getRoles());
        userRepository.save(userToAssign);
    }

}
