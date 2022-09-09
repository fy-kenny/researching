package com.example.researching.pattern.command2.device.controller.commnads;

import com.example.researching.pattern.command2.device.Signal;
import com.example.researching.pattern.command2.device.SignalChannel;

import java.time.LocalDateTime;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class CommandUp implements Command {

    @Override
    public int signal() {
        return CommandSignalEnum.UP.signal();
    }

    @Override
    public void exec() {
        System.out.println("turn up");
        SignalChannel.signalQueue.add(Signal.builder()
                .value(this.signal())
                .createTime(LocalDateTime.now())
                .build());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CommandUp;
    }
}
