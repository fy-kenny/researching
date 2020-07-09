package com.example.researching.dynamic_params_strategy;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public interface DynamicParamsStrategy {

    BigDecimal exec(String... args);
}
