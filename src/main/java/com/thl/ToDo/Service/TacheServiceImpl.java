package com.thl.ToDo.Service;


import com.thl.ToDo.Entity.Tache;
import com.thl.ToDo.Entity.Utilisateur;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Repository.TacheRepository;
import com.thl.ToDo.Repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TacheServiceImpl implements TacheService{

    private final TacheRepository tacheRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Tache saveTache(Tache tache) {
        return tacheRepository.save(tache);
    }




    @Override
    public List<Tache> fetchTacheList() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache fetchTacheById(Long tacheId) throws NotFoundException {
        Optional<Tache> tache =tacheRepository.findById(tacheId);
        if(tache.isPresent()){
            throw new NotFoundException("Cette tache n'existe pas!");
        }
        return tache.get();
    }

    @Override
    public void deleteTacheById(Long tacheId) {
        tacheRepository.deleteById(tacheId);
    }

    @Override
    public Tache updateTache(Long tacheId, Tache tache) {
        Tache tacheDB = tacheRepository.findById(tacheId).get();
        return tacheRepository.save(tacheDB);
    }

    @Override
    public Tache fetchByNom(String  titre) {
        return tacheRepository.findByTitreIgnoreCase(titre);

    }

    @Override
    public Optional<Tache> findById(Long tacheId) {
        return Optional.empty();
    }

    @Override
    public Tache assignerTache(Long tacheId, Long utilisateurId) {
        Tache tache = tacheRepository.findById(tacheId)
                .orElseThrow(() -> new NotFoundException("Tâche non trouvée avec l'ID : " + tacheId));

        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé avec l'ID : " + utilisateurId));

        tache.setAssigneA(utilisateur);
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> getTachesCreeesParUtilisateur(Long utilisateurId) {
        return tacheRepository.findByCreateurId(utilisateurId);    }

    @Override
    public List<Tache> getTachesAssigneesAUtilisateur(Long utilisateurId) {
        return tacheRepository.findByCreateurId(utilisateurId);
    }

    @Override
    public List<Tache> getTachesByUserId(Long userId) {
        return tacheRepository.findByAssigneAId(userId);
    }

    @Override
    public Tache save(Tache tacheDB) {
        return tacheRepository.save(tacheDB);
    }


}
