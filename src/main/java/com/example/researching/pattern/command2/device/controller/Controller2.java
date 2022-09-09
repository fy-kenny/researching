package com.example.researching.pattern.command2.device.controller;

import com.example.researching.pattern.command2.device.controller.commnads.Command;
import com.example.researching.pattern.command2.device.controller.commnads.CommandEnum;

/**
 * Simulate infrared remote controller.
 *
 * @author Kenny Fang
 * @since 0.0.1
 */
public class Controller2 {

    public void command(Command command) {
        command.exec();
    }

    public void turnOn() {
        CommandEnum.ON.command().exec();
    }

    public void turnOff() {
        CommandEnum.OFF.command().exec();
    }

    public void turnUp() {
        CommandEnum.UP.command().exec();
    }

    public void turnDown() {
        CommandEnum.DOWN.command().exec();
    }
}
