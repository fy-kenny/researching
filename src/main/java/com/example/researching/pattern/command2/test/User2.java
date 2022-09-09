package com.example.researching.pattern.command2.test;

import com.example.researching.pattern.command2.device.controller.Controller2;
import com.example.researching.pattern.command2.device.light.LightG1;
import com.example.researching.pattern.command2.device.light.LightG2;

import java.util.Random;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class User2 {
    private static final int INTERVAL_MAX_SLEEPING = 2000;
    private static final LightG1 lightG1 = new LightG1();
    private static final LightG2 lightG2 = new LightG2();

    static {
        lightG1.listening();
        lightG2.listening();
    }

    public static void main(String[] args) throws InterruptedException {

        Controller2 controller = new Controller2();

        Random random = new Random();

        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnOn();

        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnDown();

        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnOn();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnUp();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnDown();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnOff();

        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnUp();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnOff();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnUp();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnDown();
        Thread.sleep(random.nextInt(INTERVAL_MAX_SLEEPING));
        controller.turnOff();

    }
}
