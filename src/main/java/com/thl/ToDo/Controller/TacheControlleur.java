package com.thl.ToDo.Controller;


import com.thl.ToDo.Entity.Tache;
import com.thl.ToDo.Entity.User;
import com.thl.ToDo.Enums.Status;
import com.thl.ToDo.Exception.NotFoundException;
import com.thl.ToDo.Service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Tache saveTache(@RequestBody Tache tache) {
        return tacheService.saveTache(tache);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Tache>> getTachesByUserId(@PathVariable Long userId) {
        List<Tache> taches = tacheService.getTachesByUserId(userId);
        return ResponseEntity.ok(taches);
    }

    @GetMapping("/tache")
    public List<Tache> fetchTacheList() {
        return tacheService.fetchTacheList();
    }

    @GetMapping("/tache/{Id}")
    public Tache fetchTacheById(@PathVariable("Id") Long tacheId)
            throws NotFoundException {
        return tacheService.fetchTacheById(tacheId);
    }

    @DeleteMapping("/tache/{Id}")
    public String deleteTacheById(@PathVariable("Id") Long tacheId) {
        tacheService.deleteTacheById(tacheId);
        return " Supprimé!";
    }

    @PutMapping("/tache/{Id}")
    public Tache updateTache(@PathVariable("Id") Long tacheId, @RequestBody Tache tache) {
        Optional<Tache> optionalTacheDB = tacheService.findById(tacheId);

        if (optionalTacheDB.isPresent()) {
            Tache tacheDB = optionalTacheDB.get();

            if (Objects.nonNull(tache.getTitre()) && !""
                    .equalsIgnoreCase(tache.getTitre())) {
                tacheDB.setTitre(tache.getTitre());
            }
            if (Objects.nonNull(tache.getDescription()) && !""
                    .equalsIgnoreCase(tache.getDescription())) {
                tacheDB.setDescription(tache.getDescription());
            }
            if (Objects.nonNull(tache.getDate())) {
                tacheDB.setDate(tache.getDate());
            }
            if (Objects.nonNull(tache.getStatus())) {
                tacheDB.setStatus(tache.getStatus());
            }

            return tacheService.updateTache(tacheDB);

        } else {
            throw new NotFoundException("Tâche non trouvée avec l'ID : " + tacheId);
        }
    }

    @GetMapping("/tache/titre/{titre}")
    public Tache fetchTacheByTitre(@PathVariable("titre") String tacheTitre) {
        return tacheService.fetchByTitre(tacheTitre);
    }

    @PostMapping("/{tacheId}/assigner/{userId}")
    public Tache assignerTache(@PathVariable Long tacheId, @PathVariable Long userId) {
        return tacheService.assignerTache(tacheId, userId);
    }

    @GetMapping("/creepar/{userId}")
    public List<Tache> getTachesCreeesParUser(@PathVariable Long userId) {
        return tacheService.getTachesCreeesParUser(userId);
    }

    // Voir toutes les tâches assignées à un utilisateur

    @GetMapping("/assigneeA/{userId}")
    public List<Tache> getTachesAssigneesAUser(@PathVariable Long userId) {
        return tacheService.getTachesAssigneesAUser(userId);
    }

    @PutMapping("/assigner")
    public Tache assignerTache(@RequestBody Tache tache){
        return tacheService.assignerTache(tache);
    }



    @PutMapping("status/{id}/")
    public ResponseEntity<Tache> updateTacheStatus(@PathVariable Long id, @RequestParam Status status) {
        Tache updatedTache = tacheService.updateTacheStatus(id, status);
        return new ResponseEntity<>(updatedTache, HttpStatus.OK);
    }


}
