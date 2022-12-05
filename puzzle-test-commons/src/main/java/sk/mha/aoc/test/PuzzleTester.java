package sk.mha.aoc.test;

import lombok.NonNull;
import sk.mha.aoc.api.PuzzleAPI;

import java.util.List;
import java.util.function.Supplier;

public final class PuzzleTester {

    private PuzzleTester() {
        // private constructor to prevent instantiation
    }

    public static <T> T test(@NonNull Supplier<PuzzleAPI<T>> puzzleSupplier, @NonNull String inputFile) {
        PuzzleAPI<T> puzzle = puzzleSupplier.get();
        if (null == puzzle) {
            throw new IllegalArgumentException("PuzzleSupplier must not return null");
        }
        List<String> input = TestInputLoader.loadTestInput(inputFile);
        return puzzle.solve(input);
    }

}
