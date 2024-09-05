package com.thl.ToDo.Entity;

import com.thl.ToDo.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity

public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Utilisateur assigneA;
    @ManyToOne
    private Utilisateur createur;

    public void setAssigneA(Utilisateur utilisateur) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tache(Long id, String titre, String description, LocalDateTime date, Status status) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }


}
