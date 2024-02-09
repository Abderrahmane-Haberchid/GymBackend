package com.gym_backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String marque;
    private String type;
    private int quantity;
    private Date dateAjout;
    private Double prixAchat;
    private Double prixVente;

}
