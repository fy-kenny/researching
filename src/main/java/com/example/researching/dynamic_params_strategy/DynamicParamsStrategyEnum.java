package com.example.researching.dynamic_params_strategy;

import lombok.Getter;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public enum DynamicParamsStrategyEnum {

    TWO_PARAMS_STRATEGY(new TwoParamsAddStrategy()),
    THREE_PARAMS_STRATEGY(new TwoParamsMultiplyStrategy()),
    FOUR_PARAMS_STRATEGY(new FourParamsGreetingStrategy());


    DynamicParamsStrategyEnum(DynamicParamsStrategy dynamicParamsStrategy) {
        this.dynamicParamsStrategy = dynamicParamsStrategy;
    }

    @Getter
    private DynamicParamsStrategy dynamicParamsStrategy;
}
