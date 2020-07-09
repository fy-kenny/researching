package com.example.researching.dynamic_params_strategy;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class TwoParamsSubStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {

        int arg0 = Integer.parseInt(args[0]);
        int arg1 = Integer.parseInt(args[1]);

        return BigDecimal.valueOf(arg0 - arg1);
    }
}
