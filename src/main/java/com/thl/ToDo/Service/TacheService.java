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

   public Tache updateTache( Tache tache);

   Tache fetchByNom(String tacheTitre);

   Optional<Tache> findById(Long tacheId);

   Tache assignerTache(Long tacheId, Long userId);

   List<Tache> getTachesCreeesParUser(Long userId);

   List<Tache> getTachesAssigneesAUser(Long userId);

   public List<Tache> getTachesByUserId(Long userId);

}
