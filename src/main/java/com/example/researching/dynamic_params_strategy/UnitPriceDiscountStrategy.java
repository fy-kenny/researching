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
        double price = Double.parseDouble(args[1]);
        double discount = Double.parseDouble(args[2]);

        return BigDecimal.valueOf(months * price - discount);
    }
}
