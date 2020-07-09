package com.example.researching.dynamic_params_strategy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Kenny
 * @since 0.0.1
 */
@Slf4j
public class DynamicMatchStrategyFromStrategyEnum {

    public static void main(String[] args) {
        String dynamicParamsStrategyName = args[0];
        DynamicParamsStrategy dynamicParamsStrategy = DynamicParamsStrategyEnum.valueOf(dynamicParamsStrategyName)
                .getDynamicParamsStrategy();

        log.info("Strategy Name: " + dynamicParamsStrategy.getClass().getSimpleName());
        log.info(String.valueOf(dynamicParamsStrategy.exec(Arrays.copyOfRange(args, 1, args.length))));
    }
}
