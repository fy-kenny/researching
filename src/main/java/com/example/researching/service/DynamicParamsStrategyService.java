package com.example.researching.service;

import java.math.BigDecimal;

/**
 * @author Kenny Fang
 * @since 0.0.2
 */
public interface DynamicParamsStrategyService {

    BigDecimal calculateFee(String... args);
}
