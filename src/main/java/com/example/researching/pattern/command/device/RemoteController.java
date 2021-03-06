package com.example.researching.pattern.command.device;

import com.example.researching.pattern.command.Command;
import com.example.researching.pattern.command.RemoteControl;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class RemoteController<T> {

    private RemoteControl target;

    public void press(Command command) {
        command.setTarget(target);
        command.exec();
    }

    public RemoteControl getTarget() {
        return target;
    }

    public void setTarget(RemoteControl target) {
        this.target = target;
    }
}
