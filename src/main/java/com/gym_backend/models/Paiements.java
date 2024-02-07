package com.gym_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paiements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_paiement;
    private Date date_expiration;
    private Double prix;
    private String type_abonnement;
    private String type_paiement;
    @JsonIgnore
    public void setMembreSet(Set<Membre> membres) {
            membres.forEach(membre -> membre.setStatut("Unpaid"));
    }
}
