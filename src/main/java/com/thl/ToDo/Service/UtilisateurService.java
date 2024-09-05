package com.thl.ToDo.Service;

import com.thl.ToDo.Entity.Utilisateur;
import com.thl.ToDo.Exception.NotFoundException;
//import com.thl.ToDo.Exception.UtilisateurNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
   public Utilisateur saveUtilisateur(Utilisateur utilisateur);

   public List<Utilisateur> fetchUtilisateurList();

   public void deleteUtilisateurById(Long utilisateurId);

   public Utilisateur updateUtilisateur(Long utilisateurId, Utilisateur utilisateur);

   Utilisateur fetchByNom(String utilsateurNom);

   Utilisateur fetchUtilisateurById(Long utilisateurId) throws NotFoundException;

   public Optional<Utilisateur> findById(Long utilisateurId);

   public Utilisateur save(Utilisateur utilisateurDB);
}
