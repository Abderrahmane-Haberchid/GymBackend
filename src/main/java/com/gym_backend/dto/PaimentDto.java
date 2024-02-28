package com.gym_backend.dto;

import com.gym_backend.models.Paiements;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PaimentDto extends Paiements {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_paiement;
    private Date date_expiration;
    private Double prix;
    private String type_abonnement;
    private String type_paiement;
    private boolean dontkeepExpDate = false;
}
