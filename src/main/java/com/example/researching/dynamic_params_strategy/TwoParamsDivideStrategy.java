package com.example.researching.dynamic_params_strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class TwoParamsDivideStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {

        double arg0 = Double.parseDouble(args[0]);
        double arg1 = Double.parseDouble(args[1]);

        return BigDecimal.valueOf(arg0).divide(BigDecimal.valueOf(arg1),
                3, RoundingMode.HALF_UP);
    }
}
