package sk.mha.aoc.day7.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day7.NoSpaceLeftOnDevicePuzzle;
import sk.mha.aoc.day7.data.Directory;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Component
@Order(71)
public class SumDirSizesUnder100K extends NoSpaceLeftOnDevicePuzzle {
    @Override
    public Long solve(List<String> input) {
        Map<Path, Directory> directories = createDirectories(input);
        return directories.values().stream()
            .mapToLong(Directory::size)
            .filter(size -> size <= 100_000L)
            .sum();
    }
}
