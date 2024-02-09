package com.gym_backend.services;

import com.gym_backend.dto.SupplementsDto;
import com.gym_backend.models.Supplements;

import java.util.List;

public interface SupplementService {
     List<Supplements> findByType(String type);
     SupplementsDto addProduct(String email, SupplementsDto supplementsDto);
}
