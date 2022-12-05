package sk.mha.aoc.day1;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day1.impl.FindMaxCaloriesPuzzle;
import sk.mha.aoc.day1.impl.FindTop3MaxCaloriesPuzzle;
import sk.mha.aoc.test.PuzzleTester;

class CaloriesCounterTest {

    @Test
    void part1ExampleTest() {
        PuzzleTester.test(FindMaxCaloriesPuzzle::new, 24_000L);
    }

    @Test
    void part2ExampleTest() {
        PuzzleTester.test(FindTop3MaxCaloriesPuzzle::new, 45_000L);
    }

}
