package com.gym_backend.services.Impl;

import com.gym_backend.dto.SupplementsDto;
import com.gym_backend.models.Supplements;
import com.gym_backend.models.User;
import com.gym_backend.repository.SupplementsRepository;
import com.gym_backend.repository.UserRepository;
import com.gym_backend.services.SupplementService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SupplementServiceImpl implements SupplementService {
    private final SupplementsRepository supplementsRepository;
    private final UserRepository userRepository;

    public SupplementServiceImpl(SupplementsRepository supplementsRepository, UserRepository userRepository) {
        this.supplementsRepository = supplementsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Supplements> findByType(String type) {
        return supplementsRepository.findByType(type);
    }

    @Override
    public SupplementsDto addProduct(String email, SupplementsDto supplementsDto) {

        User user = userRepository.findByEmail(email).get();

        var supp = Supplements.builder()
                .nom(supplementsDto.getNom())
                .marque(supplementsDto.getMarque())
                .type(supplementsDto.getType())
                .dateAjout(new Date())
                .quantity(supplementsDto.getQuantity())
                .prixVente(supplementsDto.getPrixVente())
                .prixAchat(supplementsDto.getPrixAchat())
                .build();

        user.getSuppSet().add(supp);

        userRepository.save(user);

        return supplementsDto;
    }

}
