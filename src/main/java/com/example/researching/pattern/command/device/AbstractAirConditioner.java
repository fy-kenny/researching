package com.example.researching.pattern.command.device;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public abstract class AbstractAirConditioner implements AirConditioner {

    private Integer value = 26;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void on() {
        log.warn("Air Conditioner on");
    }

    @Override
    public void off() {
        log.warn("Air Conditioner off");
    }
}
