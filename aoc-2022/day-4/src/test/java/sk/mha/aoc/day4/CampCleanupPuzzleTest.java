package sk.mha.aoc.day4;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day4.impl.FindFullyOverlappingSections;
import sk.mha.aoc.day4.impl.FindOverlappingSections;
import sk.mha.aoc.test.PuzzleTester;

class CampCleanupPuzzleTest {

    @Test
    void part1ExampleTest() {
        PuzzleTester.test(FindFullyOverlappingSections::new, 2L);
    }

    @Test
    void part2ExampleTest() {
        PuzzleTester.test(FindOverlappingSections::new, 4L);
    }

}
