package com.thl.ToDo.Service;

import com.thl.ToDo.Entity.Tache;
import com.thl.ToDo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface TacheService {
   public Tache saveTache(Tache tache);

   public List<Tache> fetchTacheList();

   public Tache fetchTacheById(Long tacheId) throws NotFoundException;

   public void deleteTacheById(Long tacheId);

   public Tache updateTache(Long tacheId, Tache tache);

   Tache fetchByNom(String tacheTitre);

   public Tache save(Tache tacheDB);

   Optional<Tache> findById(Long tacheId);

   public Tache assignerTache(Long tacheId, Long utilisateurId);

   public List<Tache> getTachesCreeesParUtilisateur(Long utilisateurId);

   public List<Tache> getTachesAssigneesAUtilisateur(Long utilisateurId);
}
