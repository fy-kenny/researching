package com.example.researching.pattern.command;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class DownCommand implements Command {

    private Tuner tuner;

    @Override
    public void setTarget(RemoteControl target) {
        this.tuner = (Tuner) target;
    }

    @Override
    public void exec() {
    this.tuner.down();
    }
}
