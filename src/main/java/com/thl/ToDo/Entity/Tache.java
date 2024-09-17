package com.thl.ToDo.Entity;

import com.thl.ToDo.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private User assigneA;
    @ManyToOne
    @JoinColumn(name = "createur_id")
    private User createur;

    }

