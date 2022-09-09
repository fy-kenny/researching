package com.example.researching.pattern.command2.device.controller;

import com.example.researching.pattern.command2.device.Controllable;
import com.example.researching.pattern.command2.device.Signal;
import com.example.researching.pattern.command2.device.controller.commnads.*;

import java.time.LocalDateTime;

/**
 * This is like a embedded controller or banding remote controller.
 *
 * @author Kenny Fang
 * @since 0.0.1
 */
public class Controller {

    private static final Command ON = new CommandOn();
    private static final Command OFF = new CommandOff();
    private static final Command UP = new CommandUp();
    private static final Command DOWN = new CommandDown();

    private Controllable target;

    public void turnOn() {
        System.out.println("Turn on");
        target.signal(Signal.builder()
                .value(ON.signal())
                .createTime(LocalDateTime.now())
                .build());
    }

    public void turnOff() {
        System.out.println("Turn off");
        target.signal(Signal.builder()
                .value(OFF.signal())
                .createTime(LocalDateTime.now())
                .build());
    }

    public void turnUp() {
        System.out.println("Turn up");
        target.signal(Signal.builder()
                .value(UP.signal())
                .createTime(LocalDateTime.now())
                .build());
    }

    public void turnDown() {
        System.out.println("Turn down");
        target.signal(Signal.builder()
                .value(DOWN.signal())
                .createTime(LocalDateTime.now())
                .build());
    }

    public Controllable getTarget() {
        return target;
    }

    public void setTarget(Controllable target) {
        this.target = target;
    }
}
