package com.example.researching.pattern.command2.device;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public interface Controllable {

    void signal(Signal value);

    boolean isTurnOn();
}
