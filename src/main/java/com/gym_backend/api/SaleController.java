package com.gym_backend.api;

import com.gym_backend.dto.SaleDto;
import com.gym_backend.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sale")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/add/{email}")
    public ResponseEntity<SaleDto> addSale(@PathVariable String email, @RequestBody SaleDto saleDto){
        return ResponseEntity.ok(saleService.addSale(email, saleDto));
    }
}
