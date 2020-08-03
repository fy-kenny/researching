package com.example.pattern.command.device;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class CommonLight implements Light {

    @Override
    public void on() {
        log.warn("light on");
    }

    @Override
    public void off() {
        log.warn("light off");
    }
}
