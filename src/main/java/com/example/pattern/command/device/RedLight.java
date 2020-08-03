package com.example.pattern.command.device;

import com.example.pattern.command.Tuner;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class RedLight implements Light, Tuner {

    private Integer brightness = 50;

    @Override
    public void on() {
      log.warn("red light on");
    }

    @Override
    public void off() {
        log.warn("red light off");
    }

    @Override
    public void up() {
        this.setBrightness(this.getBrightness() + 1);
        log.warn("tune red light brightness up to: {}", this.getBrightness());
    }

    @Override
    public void down() {
        this.setBrightness(this.getBrightness() - 1);
        log.warn("tune red light brightness down to: {}", this.getBrightness());
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }
}
