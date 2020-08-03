package com.example.researching.pattern.command.device;

import com.example.researching.pattern.command.Tuner;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Slf4j
public class LightRemoteControl implements Light, Tuner {

    private Light light;

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void on() {
      this.light.on();
    }

    @Override
    public void off() {
        this.light.off();
    }

    @Override
    public void up() {
        ((Tuner)this.light).up();
    }

    @Override
    public void down() {
        ((Tuner)this.light).down();
    }
}
