package sk.mha.aoc.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import sk.mha.aoc.api.PuzzleAPI;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PuzzleTester {

    public static <T> void test(Supplier<PuzzleAPI<T>> puzzleSupplier, T expectedAnswer) {
        test(puzzleSupplier, "test.input", expectedAnswer);
    }

    public static <T> void test(
        @NonNull Supplier<PuzzleAPI<T>> puzzleSupplier,
        @NonNull String inputFile,
        @NonNull T expectedAnswer
    ) {
        PuzzleAPI<T> puzzle = Objects.requireNonNull(puzzleSupplier.get(), "PuzzleSupplier must not return null");
        List<String> input = TestInputLoader.loadTestInput(inputFile);
        assertEquals(expectedAnswer, puzzle.solve(input));
    }

}
