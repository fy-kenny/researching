package com.example.researching.pattern.command2.test;

import com.example.researching.pattern.command2.device.controller.Controller;
import com.example.researching.pattern.command2.device.light.LightG1;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class User {

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.setTarget(new LightG1());

        controller.turnOn();
        controller.turnUp();
        controller.turnDown();
        controller.turnOff();
    }
}
