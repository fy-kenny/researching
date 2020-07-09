package com.example.researching.dynamic_params_strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
@Component
public class DynamicLoadStrategyClass {

    public static void main(String[] args) {
        new DynamicLoadStrategyClass().calculateFee(args);
    }

    public BigDecimal calculateFee(String... args) {

        String dynamicParamsStrategyClassName = args[0];
        log.info("Try to find the Strategy: ".concat(dynamicParamsStrategyClassName));

        DynamicParamsStrategy dynamicParamsStrategy = null;
        try {
            dynamicParamsStrategy = (DynamicParamsStrategy) DynamicLoadStrategyClass.class.getClassLoader()
                    .loadClass(DynamicLoadStrategyClass.class.getPackage().getName()
                            .concat(".").concat(dynamicParamsStrategyClassName))
                    .newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String errMsg = "Can not find the strategy: ".concat(dynamicParamsStrategyClassName);
            log.error(errMsg);

            throw new RuntimeException(errMsg);
        }

        log.info("Found Strategy: " + dynamicParamsStrategy.getClass().getSimpleName());
        BigDecimal result = dynamicParamsStrategy.exec(Arrays.copyOfRange(args, 1, args.length));
        log.info("fee is {}", result);

        return result;
    }
}
