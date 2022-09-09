package com.example.researching.pattern.command2.device;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Simulate shared infrared signal channel.
 *
 * @author Kenny Fang
 * @since 0.0.1
 */
public class SignalChannel {
    public static final Queue<Signal> signalQueue = new ArrayBlockingQueue<>(10);

}
