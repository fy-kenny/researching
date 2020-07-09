package com.example.researching.dynamic_params_strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class UnitByUnitAndDiscountStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {
        log.info("Fee calculated unit by unit");

        return BigDecimal.valueOf(Arrays.stream(args)
                .mapToDouble(Double::parseDouble)
                .sum());
    }
}
