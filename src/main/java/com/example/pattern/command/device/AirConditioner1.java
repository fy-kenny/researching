package com.example.pattern.command.device;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class AirConditioner1 extends AbstractAirConditioner {

    @Override
    public void up() {
        this.setValue(this.getValue() + 1);
        log.warn("Air Conditioner temperature up: {}", this.getValue());
    }

    @Override
    public void down() {
        this.setValue(this.getValue() - 1);
        log.warn("Air Conditioner temperature down: {}", this.getValue());
    }
}
