package sk.mha.aoc.test;

import lombok.NonNull;
import sk.mha.aoc.api.PuzzleAPI;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class PuzzleTester {

    private PuzzleTester() {
        // private constructor to prevent instantiation
    }

    public static <T> void test(@NonNull Supplier<PuzzleAPI<T>> puzzleSupplier, @NonNull String inputFile, @NonNull T expectedAnswer) {
        PuzzleAPI<T> puzzle = puzzleSupplier.get();
        if (null == puzzle) {
            throw new IllegalArgumentException("PuzzleSupplier must not return null");
        }
        List<String> input = TestInputLoader.loadTestInput(inputFile);
        assertEquals(expectedAnswer, puzzle.solve(input));
    }

}
