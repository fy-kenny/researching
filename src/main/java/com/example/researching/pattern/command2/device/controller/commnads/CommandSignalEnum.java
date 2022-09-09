package com.example.researching.pattern.command2.device.controller.commnads;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public enum CommandSignalEnum {
    ON(0),
    OFF(1),
    UP(2),
    DOWN(3);

    private int signal;


    CommandSignalEnum(int signal) {
        this.signal = signal;
    }

    public int signal() {
        return signal;
    }
}
