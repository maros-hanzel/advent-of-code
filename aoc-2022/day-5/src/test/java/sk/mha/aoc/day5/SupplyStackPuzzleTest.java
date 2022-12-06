package sk.mha.aoc.day5;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day5.impl.CrateMover9000;
import sk.mha.aoc.day5.impl.CrateMover9001;
import sk.mha.aoc.test.PuzzleTester;

class SupplyStackPuzzleTest {

    @Test
    void part1ExampleTest() {
        PuzzleTester.test(CrateMover9000::new, "CMZ");
    }

    @Test
    void part2ExampleTest() {
        PuzzleTester.test(CrateMover9001::new, "MCD");
    }

}
