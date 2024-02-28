package com.gym_backend.services;
import com.gym_backend.dto.MembreDto;
import com.gym_backend.dto.PaimentDto;
import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MembreService {
     Optional<List<Membre>> findAll();
    boolean addMembre(String email, MembreDto membredto);
    MembreDto updateMembre(MembreDto membredto, Long id);
    Optional<List<Membre>> findByName(String name);
    Optional<List<Membre>> findByStatut(String statut);
     Optional<Membre> findByEmail(String email);
     Optional<Membre> findById_membre(Long id);

     PaimentDto addPayment(PaimentDto paimentDto, Long id, String userEmail);

}
