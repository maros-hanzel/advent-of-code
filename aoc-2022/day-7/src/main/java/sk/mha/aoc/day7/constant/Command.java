package sk.mha.aoc.day7.constant;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Command {
    CHANGE_DIRECTORY(s -> s.startsWith("$ cd")),
    MAKE_DIRECTORY(s -> s.startsWith("dir")),
    MAKE_FILE(s -> Character.isDigit(s.charAt(0)));

    private final Predicate<String> isCommand;

    Command(Predicate<String> isCommand) {
        this.isCommand = isCommand;
    }

    public static Command resolve(String commandString) {
        return Arrays.stream(values())
            .filter(command -> command.isCommand.test(commandString))
            .findAny()
            .orElse(null);
    }
}
