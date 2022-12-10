package sk.mha.aoc.day7.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day7.NoSpaceLeftOnDevicePuzzle;
import sk.mha.aoc.day7.data.Directory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Component
@Order(72)
public class FindSmallestPossibleDirectory extends NoSpaceLeftOnDevicePuzzle {
    private static final long FILESYSTEM_SIZE = 70_000_000L;
    private static final long UPDATE_SIZE = 30_000_000L;

    @Override
    public Long solve(List<String> input) {
        Map<Path, Directory> directories = createDirectories(input);
        Directory rootDirectory = directories.get(Paths.get("/"));

        long freeSpace = FILESYSTEM_SIZE - rootDirectory.size();
        long requiredSpace = UPDATE_SIZE - freeSpace;

        return directories.values().stream()
            .mapToLong(Directory::size)
            .sorted()
            .filter(size -> size >= requiredSpace)
            .findFirst()
            .orElse(0L);
    }
}
