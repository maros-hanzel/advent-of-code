package sk.mha.aoc.day7;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day7.impl.FindSmallestPossibleDirectory;
import sk.mha.aoc.day7.impl.SumDirSizesUnder100K;
import sk.mha.aoc.test.PuzzleTester;

class NoSpaceLeftOnDevicePuzzleTest {

    @Test
    void part1ExampleTest() {
        PuzzleTester.test(SumDirSizesUnder100K::new, 95_437L);
    }

    @Test
    void part2ExampleTest() {
        PuzzleTester.test(FindSmallestPossibleDirectory::new, 24_933_642L);
    }

}