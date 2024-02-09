package com.gym_backend.services;

import com.gym_backend.dto.SaleDto;

public interface SaleService {
    SaleDto addSale(String email, SaleDto saleDto);
}
