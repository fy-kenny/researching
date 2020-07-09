package com.example.researching.dynamic_params_strategy;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class TwoParamsAddStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {

        double arg0 = Double.parseDouble(args[0]);
        double arg1 = Double.parseDouble(args[1]);

        return BigDecimal.valueOf(arg0 + arg1);
    }
}
