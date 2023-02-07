package sk.mha.aoc.day8;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day8.impl.TreesSeenFromOutside;
import sk.mha.aoc.test.PuzzleTester;


class TreetopTreehousePuzzleTest {

    @Test
    void part1ExampleTest() {
        PuzzleTester.test(TreesSeenFromOutside::new, 21);
    }

}