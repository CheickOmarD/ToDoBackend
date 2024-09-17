package com.thl.ToDo.Service;


import com.thl.ToDo.Entity.Tache;
import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Enums.Status;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Repository.TacheRepository;
import com.thl.ToDo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TacheServiceImpl implements TacheService {

    private final TacheRepository tacheRepository;
    private final UserRepository userRepository;
    private UserService userService;
    private User user;


    @Override
    public Tache saveTache(Tache tache) {
        User author = userService.getAuthor();
        if (author != null) {
            tache.setAssigneA(author);
            tache.setCreateur(author);
        }
        return tacheRepository.save(tache);
    }


    @Override
    public List<Tache> fetchTacheList() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache fetchTacheById(Long tacheId) throws NotFoundException {
        Optional<Tache> tache = tacheRepository.findById(tacheId);
        if (tache.isPresent()) {
            throw new NotFoundException("Cette tache n'existe pas!");
        }
        return tache.get();
    }

    @Override
    public void deleteTacheById(Long tacheId) {
        tacheRepository.deleteById(tacheId);
    }

    @Override
    public Tache updateTache(Tache tache) {
        Tache tacheDB = tacheRepository.findById(tache.getId()).get();
        return tacheRepository.save(tacheDB);
    }

    @Override
    public Tache fetchByNom(String titre) {
        return tacheRepository.findByTitreIgnoreCase(titre);

    }

    @Override
    public Optional<Tache> findById(Long tacheId) {
        return Optional.empty();
    }

    @Override
    public Tache assignerTache(Long tacheId, Long userId) {
        Tache tache = tacheRepository.findById(tacheId)
                .orElseThrow(() -> new NotFoundException("Tâche non trouvée avec l'ID : " + tacheId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User non trouvé avec l'ID : " + userId));

        tache.setAssigneA(user);
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> getTachesCreeesParUser(Long userId) {
        return tacheRepository.findByCreateurId(userId);
    }

    @Override
    public List<Tache> getTachesAssigneesAUser(Long userId) {
        return tacheRepository.findByCreateurId(userId);
    }

    @Override
    public List<Tache> getTachesByUserId(Long userId) {

        return tacheRepository.findByAssigneAId(userId);
    }

    @Override
    public Tache fetchByTitre(String tache) {
        return tacheRepository.findByTitre(tache);
    }


    @Override
    public Tache assignerTache(Tache tache) {
        Tache statusTache = tacheRepository.findById(tache.getId()).orElseThrow(() ->
                new NotFoundException("Tache:"));
        User user = userRepository.findById(tache.getAssigneA().getId()).orElseThrow(()->
                new NotFoundException("Cette utilisateur n existe pas!"));
        if (user!=null) {
            statusTache.setAssigneA(tache.getAssigneA());
        }
        return statusTache;
    }

    public List<Tache> getAllCreateurs(){
        return tacheRepository.findAll();
    }




    public Tache updateTacheStatus(Long tacheId, Status newStatus) {
        Tache tache = tacheRepository.findById(tacheId)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));

        tache.setStatus(newStatus);
        return tacheRepository.save(tache);
    }



}
