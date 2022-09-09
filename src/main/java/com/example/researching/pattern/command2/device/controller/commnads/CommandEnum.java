package com.example.researching.pattern.command2.device.controller.commnads;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
public enum CommandEnum {
    OFF(new CommandOff()),
    ON(new CommandOn()),
    UP(new CommandUp()),
    DOWN(new CommandDown());


    private Command command;

    public Command command() {
        return this.command;
    }

    CommandEnum(Command command) {
        this.command = command;
    }

    public static Command getCommand(int signal) {
        for (CommandEnum commandEnum : values()) {
            if (commandEnum.command.signal() == signal) {
                return commandEnum.command;
            }
        }

        throw new UnsupportedOperationException();
    }

    public static CommandEnum valueOf(Command command) {
        for (CommandEnum commandEnum : values()) {
            if (commandEnum.command.equals(command)) {
                return commandEnum;
            }
        }

        throw new UnsupportedOperationException();
    }
}
