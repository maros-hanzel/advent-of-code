package sk.mha.aoc.test;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class TestInputLoader {

    private static final Path TEST_RESOURCES_PATH = Paths.get("src/test/resources/");

    private TestInputLoader() {
        // private constructor to prevent instantiation
    }

    @SneakyThrows
    public static List<String> loadTestInput(@NonNull String fileName) {
        return Files.readAllLines(TEST_RESOURCES_PATH.resolve(fileName));
    }

}
