package com.thl.ToDo.Controller;


import com.thl.ToDo.Entity.Utilisateur;
//import com.thl.ToDo.Exception.UtilisateurNotFoundException;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequestMapping("/utilisateurs")
@RestController
public class UtilisateurController {


    @Autowired
    private UtilisateurService utilisateurService;



    @PostMapping("/utilisateur")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @GetMapping("/utilisateur")
    public List<Utilisateur> fetchUtilisateurList() {

        return utilisateurService.fetchUtilisateurList();
    }
    @GetMapping("/utilisateur/{Id}")
public Utilisateur fetchUtilisateurById(@PathVariable("Id") Long utilisateurId  )
            throws NotFoundException {
        return utilisateurService.fetchUtilisateurById(utilisateurId);
    }


    @DeleteMapping("/utilisateur/{Id}")
    public String deleteUtilisateurById(@PathVariable("Id") Long utilisateurId ) {
        utilisateurService.deleteUtilisateurById(utilisateurId);
        return " Supprimé!";
    }

    @PutMapping("/utilisateur/{Id}")
    public Utilisateur updateUtilisateur(Long utilisateurId, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateurDB = utilisateurService.findById(utilisateurId);

        if (optionalUtilisateurDB.isPresent()) {
            Utilisateur utilisateurDB = optionalUtilisateurDB.get();

            if (Objects.nonNull(utilisateur.getNom()) && !"".equalsIgnoreCase(utilisateur.getNom())) {
                utilisateurDB.setNom(utilisateur.getNom());
            }
            if (Objects.nonNull(utilisateur.getPrenom()) && !"".equalsIgnoreCase(utilisateur.getPrenom())) {
                utilisateurDB.setPrenom(utilisateur.getPrenom());
            }
            if (Objects.nonNull(utilisateur.getMotDepass()) && !"".equalsIgnoreCase(utilisateur.getMotDepass())) {
                utilisateurDB.setMotDepass(utilisateur.getMotDepass());
            }
            if (Objects.nonNull(utilisateur.getEmail()) && !"".equalsIgnoreCase(utilisateur.getEmail())) {
                utilisateurDB.setEmail(utilisateur.getEmail());
            }

            return utilisateurService.save(utilisateurDB);

        } else {
            throw new NotFoundException("Utilisateur non trouvé avec l'ID : " + utilisateurId);
        }
    }

    @GetMapping("/utilisateur/nom/{nom}")
public  Utilisateur fetchUtilsateurByNom(@PathVariable("nom") String utilsateurNom){
        return  utilisateurService.fetchByNom(utilsateurNom);
    }

}
