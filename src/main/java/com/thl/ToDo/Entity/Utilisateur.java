package com.thl.ToDo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Collection;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDepass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDepass() {
        return motDepass;
    }

    public void setMotDepass(String motDepass) {
        this.motDepass = motDepass;
    }

    public Utilisateur(Long id, String nom, String prenom, String email, String motDepass) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDepass = motDepass;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "motDepass='" + motDepass + '\'' +
                ", email='" + email + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }

    public Utilisateur getRole() {
        return null;
    }

    public Collection<Object> getRoles() {
        return java.util.List.of();
    }
}
