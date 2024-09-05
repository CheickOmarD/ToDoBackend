package com.thl.ToDo.Repository;

import com.thl.ToDo.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByNomIgnoreCase(String nom);
}
