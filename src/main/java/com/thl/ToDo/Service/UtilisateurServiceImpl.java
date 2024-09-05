package com.thl.ToDo.Service;


import com.thl.ToDo.Entity.Utilisateur;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> fetchUtilisateurList() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur fetchUtilisateurById(Long utilisateurId) throws NotFoundException {
       Optional<Utilisateur>  utilisateur = utilisateurRepository.findById(utilisateurId);
               if(utilisateur.isPresent()) {
                   throw new NotFoundException(("Ce utilisateur n'existe pas"));
               }
       return utilisateur.get();
    }

    @Override
    public Optional<Utilisateur> findById(Long utilisateurId) {
        return Optional.empty();
    }

    @Override
    public Utilisateur save(Utilisateur utilisateurDB) {
        return utilisateurRepository.save(utilisateurDB);

    }

    @Override
    public void deleteUtilisateurById(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
    }

    @Override
    public Utilisateur updateUtilisateur(Long utilisateurId, Utilisateur utilisateur) {
        Utilisateur utilisateurDB = utilisateurRepository.findById(utilisateurId).get();
        return utilisateurRepository.save(utilisateurDB);
    }

    @Override
    public Utilisateur fetchByNom(String nom) {
        return utilisateurRepository.findByNomIgnoreCase(nom);
    }


}
