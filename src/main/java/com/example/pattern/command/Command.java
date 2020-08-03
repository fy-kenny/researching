package com.example.pattern.command;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public interface Command {

    void setTarget(RemoteControl target);
    void exec();
}
