package com.thl.ToDo.Controller;


import com.thl.ToDo.Entity.Tache;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequestMapping("/taches")
@RestController
public class TacheControlleur {


    @Autowired
    private TacheService tacheService;




    @PostMapping("/tache")
    public Tache saveTache(@RequestBody Tache tache){
        return tacheService.saveTache(tache);
    }

    @GetMapping("/tache")
    public List<Tache> fetchTacheList() {
        return tacheService.fetchTacheList();
    }
    @GetMapping("/tache/{Id}")
    public Tache fetchTacheById(@PathVariable("Id") Long tacheId  )
            throws NotFoundException {
        return tacheService.fetchTacheById(tacheId);
    }

    @DeleteMapping("/tache/{Id}")
    public String deleteTacheById(@PathVariable("Id") Long tacheId ) {
        tacheService.deleteTacheById(tacheId);
        return " Supprimé!";
    }

    @PutMapping("/tache/{Id}")
    public Tache updateTache(@PathVariable("Id") Long tacheId, @RequestBody Tache tache) {
        Optional<Tache> optionalTacheDB = tacheService.findById(tacheId);

        if (optionalTacheDB.isPresent()) {
            Tache tacheDB = optionalTacheDB.get();

            if (Objects.nonNull(tache.getTitre()) && !"".equalsIgnoreCase(tache.getTitre())) {
                tacheDB.setTitre(tache.getTitre());
            }
            if (Objects.nonNull(tache.getDescription()) && !"".equalsIgnoreCase(tache.getDescription())) {
                tacheDB.setDescription(tache.getDescription());
            }
            if (Objects.nonNull(tache.getDate())) {
                tacheDB.setDate(tache.getDate());
            }
            if (Objects.nonNull(tache.getStatus())) {
                tacheDB.setStatus(tache.getStatus());
            }

            return tacheService.save(tacheDB);

        } else {
            throw new NotFoundException("Tâche non trouvée avec l'ID : " + tacheId);
        }
    }

    @GetMapping("/tache/titre/{titre}")
    public  Tache fetchTacheByTitre(@PathVariable("titre") String tacheTitre){
        return  tacheService.fetchByNom(tacheTitre);
    }

    @PostMapping("/{tacheId}/assigner/{utlisateurId}")
    public Tache assignerTache(@PathVariable Long tacheId, @PathVariable Long utilisateurId){
        return tacheService.assignerTache(tacheId,utilisateurId);
    }

    @GetMapping("/creepar/{utilisateurId}")
    public List<Tache> getTachesCreeesParUtilisateur(@PathVariable Long utilisateurId) {
        return tacheService.getTachesCreeesParUtilisateur(utilisateurId);
    }

    // Voir toutes les tâches assignées à un utilisateur
    @GetMapping("/assigneeA/{utilisateurId}")
    public List<Tache> getTachesAssigneesAUtilisateur(@PathVariable Long utilisateurId) {
        return tacheService.getTachesAssigneesAUtilisateur(utilisateurId);
    }

}