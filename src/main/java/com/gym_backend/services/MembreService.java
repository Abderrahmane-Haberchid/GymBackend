package com.gym_backend.services;
import com.gym_backend.dto.MembreDto;
import com.gym_backend.dto.PaimentDto;
import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;

import java.util.List;
import java.util.Optional;

public interface MembreService {
     Optional<List<Membre>> findAll();
    MembreDto addMembre(String email, MembreDto membredto);
    Boolean updateMembre(MembreDto membredto, Long id);
    Optional<List<Membre>> findByName(String name);
    Optional<List<Membre>> findByStatut(String statut);
     Optional<Membre> findByEmail(String email);
     Optional<Membre> findById_membre(Long id);

     boolean addPayment(PaimentDto paimentDto, Long id);

}
