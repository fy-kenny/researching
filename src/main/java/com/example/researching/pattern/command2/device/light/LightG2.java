package com.example.researching.pattern.command2.device.light;

import com.example.researching.pattern.command2.device.*;

import java.util.Optional;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public class LightG2 implements Controllable, Switcher, Tuner {

    private boolean on;
    private Integer brightness = 50;

    public void turn(boolean turn) {
        this.on = turn;
    }

    public void brightnessUp() {
        this.brightness++;
        System.out.println("brightness: " + this.brightness);
    }

    public void brightnessDown() {
        this.brightness--;
        System.out.println("brightness: " + this.brightness);
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
        }, "Light2 listening").start();
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
    public void up() {
        this.brightnessUp();
    }

    @Override
    public void down() {
        this.brightnessDown();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    interface Command {
        int signal();

        void exec(Controllable controllable);
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
        public void exec(Controllable controllable) {
            System.out.println("Unsupported signal: " + this.signal + " for device: " + controllable);
        }
    }

    static class CommandOn implements Command {

        @Override
        public int signal() {
            return 0;
        }

        @Override
        public void exec(Controllable controllable) {
            if (controllable instanceof Switcher) {
                ((Switcher) controllable).on();
                System.out.println("Light on: " + controllable);
            }
        }
    }

    static class CommandOff implements Command {

        @Override
        public int signal() {
            return 1;
        }

        @Override
        public void exec(Controllable controllable) {
            if (controllable instanceof Switcher) {
                ((Switcher) controllable).off();
                System.out.println("Light off: " + controllable);
            }
        }
    }

    static class CommandUp implements Command {

        @Override
        public int signal() {
            return 2;
        }

        @Override
        public void exec(Controllable controllable) {
            if (controllable instanceof Tuner) {
                System.out.println("Light brightness up");
                ((Tuner) controllable).up();
            }
        }
    }

    static class CommandDown implements Command {

        @Override
        public int signal() {
            return 3;
        }

        @Override
        public void exec(Controllable controllable) {
            if (controllable instanceof Tuner) {
                System.out.println("Light brightness down");
                ((Tuner) controllable).down();
            }
        }
    }


    enum CommandEnum {
        ON(new CommandOn()),
        OFF(new CommandOff()),
        UP(new CommandUp()),
        DOWN(new CommandDown());

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
