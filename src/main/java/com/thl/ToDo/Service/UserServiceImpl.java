package com.thl.ToDo.Service;

import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public User saveUser(User user) {
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
            throw new NotFoundException(("Ce user n'existe pas"));
        }
        return repository.findById(userId).get();
    }


    @Override
    public String deleteUserById(Long userId) {
        return " Supprimé!";

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
                userToUpdate.setPassword(user.getPassword());
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
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.getName();
//            return utilisateurRepository.findByUsername(username);
//        }
        return null;
    }
}
