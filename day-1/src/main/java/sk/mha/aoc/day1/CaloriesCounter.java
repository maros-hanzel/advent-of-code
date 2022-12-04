package sk.mha.aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class CaloriesCounter {

    private CaloriesCounter() {
        // private constructor to prevent instantiation
    }

    public static long findMaxCalories(Path inputFilePath) throws IOException {
        return findMaxNCalories(inputFilePath, 1);
    }

    public static long findMax3Calories(Path inputFilePath) throws IOException {
        return findMaxNCalories(inputFilePath, 3);
    }

    public static long findMaxNCalories(Path inputFilePath, int topN) throws IOException {
        List<Elf> elves = loadInput(inputFilePath);
        elves.sort(Comparator.comparingLong(Elf::carryingCalories).reversed());

        long sum = 0L;
        for (int i = 0; i < Math.min(topN, elves.size()); i++) {
            sum += elves.get(i).carryingCalories();
        }

        return sum;
    }

    static List<Elf> loadInput(Path inputFilePath) throws IOException {
        List<Elf> elves = new ArrayList<>();
        try (Stream<String> lines = Files.lines(inputFilePath)) {
            AtomicLong sumCalories = new AtomicLong(0);
            lines.forEach(line -> {
                if (!line.isBlank()) {
                    sumCalories.addAndGet(Long.parseLong(line));
                } else {
                    elves.add(new Elf(elves.size() + 1, sumCalories.get()));
                    sumCalories.set(0);
                }
            });
            if (sumCalories.get() > 0) {
                elves.add(new Elf(elves.size() + 1, sumCalories.get()));
            }
        }

        return elves;
    }

}
