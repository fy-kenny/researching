package com.example.researching.service;

import com.example.researching.dynamic_params_strategy.DynamicLoadStrategyClass;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Kenny Fang
 * @since 0.0.2
 */
@Service
public class DynamicParamsStrategyServiceImpl implements DynamicParamsStrategyService {

    private final DynamicLoadStrategyClass dynamicLoadStrategyClass;

    public DynamicParamsStrategyServiceImpl(DynamicLoadStrategyClass dynamicLoadStrategyClass) {
        this.dynamicLoadStrategyClass = dynamicLoadStrategyClass;
    }

    @Override
    public float calculateFee(String... args) {

        return this.dynamicLoadStrategyClass.calculateFee(args)
                .setScale(2, RoundingMode.HALF_UP).floatValue();
    }
}
