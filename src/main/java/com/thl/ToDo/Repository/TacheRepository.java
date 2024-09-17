package com.thl.ToDo.Repository;

import com.thl.ToDo.Entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacheRepository extends JpaRepository<Tache , Long >{

    Tache findByTitreIgnoreCase(String titre);
    List<Tache> findByCreateurId(Long createurId);
    List<Tache> findByAssigneAId(Long assigneAId);


    Tache findByTitre(String tache);
}
