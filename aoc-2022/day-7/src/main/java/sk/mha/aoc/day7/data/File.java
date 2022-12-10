package sk.mha.aoc.day7.data;

import java.nio.file.Path;

public record File(Path path, long size) {
    public String name() {
        return path.getFileName().toString();
    }
}
