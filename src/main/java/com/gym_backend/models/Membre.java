package com.gym_backend.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_membre;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private int age;
    private int telephone;
    private String adresse;
    private String statut;
    private Date date_inscription;
    private Date date_update;
    private String state;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Paiements> paiementsSet = new HashSet<>();

}
