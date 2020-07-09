package com.example.researching.dynamic_params_strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class TwoParamsMultiplyStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {

        int arg1 = Integer.parseInt(args[1]);
        int arg2 = Integer.parseInt(args[2]);
        String description = args[0];

        log.info("You select purchase VIP ".concat(String.valueOf(arg1)).concat(" day，and per day ")
                .concat(String.valueOf(arg2)).concat("$，")
                .concat(description));

        return BigDecimal.valueOf(arg1 * arg2);
    }
}
