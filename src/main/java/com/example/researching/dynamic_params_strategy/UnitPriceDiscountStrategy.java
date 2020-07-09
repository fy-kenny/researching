package com.example.researching.dynamic_params_strategy;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class UnitPriceDiscountStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {

        // months
        int months = Integer.parseInt(args[0]);
        float price = Float.parseFloat(args[1]);
        float discount = Float.parseFloat(args[2]);

        return BigDecimal.valueOf(months * price - discount);
    }
}
