package com.gym_backend.services.Impl;

import com.gym_backend.dto.SaleDto;
import com.gym_backend.models.Sale;
import com.gym_backend.models.User;
import com.gym_backend.repository.SaleRepository;
import com.gym_backend.repository.UserRepository;
import com.gym_backend.services.SaleService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleServiceImpl implements SaleService {

    private  final UserRepository userRepository;
    private final SaleRepository saleRepository;

    public SaleServiceImpl(UserRepository userRepository, SaleRepository saleRepository) {
        this.userRepository = userRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleDto addSale(String email, SaleDto saleDto) {
        User user = userRepository.findByEmail(email).get();

        var sale = Sale.builder()
                .nom(saleDto.getNom())
                .type(saleDto.getType())
                .marque(saleDto.getMarque())
                .quantity(saleDto.getQuantity())
                .dateVente(new Date())
                .prixVente(saleDto.getPrixVente())
                .build();

        user.getSaleSet().add(sale);
        userRepository.save(user);
        return saleDto;
    }
}
