package com.example.researching.dynamic_params_strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class FourParamsGreetingStrategy implements DynamicParamsStrategy {

    @Override
    public BigDecimal exec(String... args) {
        String before = args[0];
        String prefix = args[1];
        String name = args[2];
        String after = args[3];

        log.info(before);
        log.info(prefix + " " + name);
        log.info(after);

        return BigDecimal.ZERO;
    }
}
