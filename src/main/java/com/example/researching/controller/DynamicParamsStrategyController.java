package com.example.researching.controller;

import com.example.researching.service.DynamicParamsStrategyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@RestController
public class DynamicParamsStrategyController {

    private final DynamicParamsStrategyService dynamicParamsStrategyService;

    public DynamicParamsStrategyController(DynamicParamsStrategyService dynamicParamsStrategyService) {
        this.dynamicParamsStrategyService = dynamicParamsStrategyService;
    }

    @GetMapping("/api/v1/dynamic-params-strategies/calculate-fee")
    public Float calculateFee(String... args) {

        return this.dynamicParamsStrategyService.calculateFee(args);
    }
}
