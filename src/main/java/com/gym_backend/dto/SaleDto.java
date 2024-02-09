package com.gym_backend.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SaleDto {
    private String nom;
    private String marque;
    private String type;
    private int quantity;
    private Date dateVente;
    private Double prixVente;
}
