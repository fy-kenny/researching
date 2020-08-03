package com.example.researching.pattern.command;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class SwitchOffCommand implements Command {

    private Switcher switcher;

    @Override
    public void setTarget(RemoteControl target) {
        this.switcher = (Switcher)target;
    }

    @Override
    public void exec() {
        this.switcher.off();
    }
}
