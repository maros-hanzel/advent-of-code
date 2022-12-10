package sk.mha.aoc.day6;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day6.impl.PacketMarkerLen14Finder;
import sk.mha.aoc.day6.impl.PacketMarkerLen4Finder;
import sk.mha.aoc.test.PuzzleTester;

class TuningTroublePuzzleTest {

    @Test
    void part1Example1Test() {
        PuzzleTester.test(PacketMarkerLen4Finder::new, "test1.input", 7);
    }

    @Test
    void part1Example2Test() {
        PuzzleTester.test(PacketMarkerLen4Finder::new, "test2.input", 5);
    }

    @Test
    void part1Example3Test() {
        PuzzleTester.test(PacketMarkerLen4Finder::new, "test3.input", 6);
    }

    @Test
    void part1Example4Test() {
        PuzzleTester.test(PacketMarkerLen4Finder::new, "test4.input", 10);
    }

    @Test
    void part1Example5Test() {
        PuzzleTester.test(PacketMarkerLen4Finder::new, "test5.input", 11);
    }

    @Test
    void part2Example1Test() {
        PuzzleTester.test(PacketMarkerLen14Finder::new, "test1.input", 19);
    }

    @Test
    void part2Example2Test() {
        PuzzleTester.test(PacketMarkerLen14Finder::new, "test2.input", 23);
    }

    @Test
    void part2Example3Test() {
        PuzzleTester.test(PacketMarkerLen14Finder::new, "test3.input", 23);
    }

    @Test
    void part2Example4Test() {
        PuzzleTester.test(PacketMarkerLen14Finder::new, "test4.input", 29);
    }

    @Test
    void part2Example5Test() {
        PuzzleTester.test(PacketMarkerLen14Finder::new, "test5.input", 26);
    }

}