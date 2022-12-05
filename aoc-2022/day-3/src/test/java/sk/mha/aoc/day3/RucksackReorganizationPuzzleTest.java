package sk.mha.aoc.day3;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day3.impl.FindDuplicatesInGroupsOf3Puzzle;
import sk.mha.aoc.day3.impl.FindDuplicatesPuzzle;
import sk.mha.aoc.test.PuzzleTester;

class RucksackReorganizationPuzzleTest {

    @Test
    void part1exampleTest() {
        PuzzleTester.test(FindDuplicatesPuzzle::new, 157L);
    }

    @Test
    void part2exampleTest() {
        PuzzleTester.test(FindDuplicatesInGroupsOf3Puzzle::new, 70L);
    }

}