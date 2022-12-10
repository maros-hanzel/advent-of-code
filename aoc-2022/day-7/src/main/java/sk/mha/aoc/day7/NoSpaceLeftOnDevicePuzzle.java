package sk.mha.aoc.day7;

import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.day7.constant.Command;
import sk.mha.aoc.day7.data.Directory;
import sk.mha.aoc.day7.data.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class NoSpaceLeftOnDevicePuzzle implements PuzzleAPI<Long> {
    protected Map<Path, Directory> createDirectories(List<String> input) {
        Map<Path, Directory> directories = new HashMap<>();
        Directory directory = null;
        for (String line : input) {
            Command command = Command.resolve(line);
            if (null == command) continue;

            switch (command) {
                case CHANGE_DIRECTORY -> {
                    directory = changeDirectory(directory, line);
                    directories.putIfAbsent(directory.path(), directory);
                }
                case MAKE_DIRECTORY -> Objects.requireNonNull(directory).addDirectory(getDirectoryName(line));
                case MAKE_FILE -> Objects.requireNonNull(directory).addFile(makeFile(directory, line));
            }
        }
        return directories;
    }

    private File makeFile(Directory currentDirectory, String line) {
        String[] parts = line.split(" ");
        Path filePath = currentDirectory.path().resolve(parts[1]);
        return new File(filePath, Long.parseLong(parts[0]));
    }

    private Directory changeDirectory(Directory currentDirectory, String line) {
        String directoryName = getDirectoryName(line);
        if (null == currentDirectory) {
            return new Directory(Paths.get(directoryName));
        }
        if ("..".equals(directoryName)) {
            return currentDirectory.parent();
        }
        return currentDirectory.getDirectory(directoryName);
    }

    private String getDirectoryName(String line) {
        return line.substring(line.lastIndexOf(" ") + 1);
    }

    @Override
    public int day() {
        return 7;
    }
}
