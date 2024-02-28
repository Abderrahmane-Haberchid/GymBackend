package com.gym_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date_paiement;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date_expiration;
    private Double prix;
    private String type_abonnement;
    private String type_paiement;
    @JsonIgnore
    public void setMembreSet(Set<Membre> membres) {
            membres.forEach(membre -> membre.setStatut("Unpaid"));
    }
}
