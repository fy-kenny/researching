package com.example.researching.pattern.command2.device.light;

import com.example.researching.pattern.command2.device.Controllable;
import com.example.researching.pattern.command2.device.Signal;
import com.example.researching.pattern.command2.device.SignalChannel;
import com.example.researching.pattern.command2.device.Switcher;

import java.util.Optional;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class LightG1 implements Controllable, Switcher {

    private boolean on;

    public void turn(boolean turn) {
        on = turn;
    }

    @Override
    public void signal(Signal signal) {
        Command command = CommandEnum.getCommand(signal.getValue());

        if ((!on && !command.equals(CommandEnum.ON.command)) ||
                (on && command.equals(CommandEnum.ON.command))) {
            System.out.println(this + ": this command is illegal with current state, resignal: " + signal.getValue());

            SignalChannel.signalQueue.add(signal);

            return;
        }
        command.exec(this);
    }

    @Override
    public boolean isTurnOn() {
        return this.on;
    }

    public void listening() {
        new Thread(() -> {
            while (true) {
                Optional.ofNullable(SignalChannel.signalQueue.poll()).ifPresent(signal -> {
                    if (signal.isNotExpired()) {
                        this.signal(signal);
                    }
                });
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }, "Light listening").start();
    }

    @Override
    public void on() {
        turn(true);
    }

    @Override
    public void off() {
        turn(false);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    interface Command {
        int signal();

        void exec(Switcher switcher);
    }

    static class CommandOn implements Command {

        @Override
        public int signal() {
            return 0;
        }

        @Override
        public void exec(Switcher switcher) {
            switcher.on();
            System.out.println("Light on: " + switcher);
        }
    }

    static class CommandOff implements Command {

        @Override
        public int signal() {
            return 1;
        }

        @Override
        public void exec(Switcher switcher) {
            switcher.off();
            System.out.println("Light off: " + switcher);
        }
    }

    static class CommandUnknown implements Command {

        private int signal;

        public CommandUnknown(int signal) {
            this.signal = signal;
        }

        @Override
        public int signal() {
            return this.signal;
        }

        @Override
        public void exec(Switcher switcher) {
            System.out.println("Unsupported signal = " + this.signal);
        }
    }

    enum CommandEnum {
        ON(new CommandOn()),
        OFF(new CommandOff());

        private Command command;

        CommandEnum(Command command) {
            this.command = command;
        }

        public static Command getCommand(int signal) {
            for (CommandEnum commandEnum : values()) {
                if (commandEnum.command.signal() == signal) {
                    return commandEnum.command;
                }
            }

            return new CommandUnknown(signal);
        }
    }
}
