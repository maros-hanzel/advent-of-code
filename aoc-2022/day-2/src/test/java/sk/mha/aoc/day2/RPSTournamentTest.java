package sk.mha.aoc.day2;

import org.junit.jupiter.api.Test;
import sk.mha.aoc.day2.impl.CorrectRulesRPSTournament;
import sk.mha.aoc.day2.impl.IncorrectRulesRPSTournament;
import sk.mha.aoc.test.PuzzleTester;

class RPSTournamentTest {

    @Test
    void part1ExampleTest() {
        PuzzleTester.test(IncorrectRulesRPSTournament::new, 15L);
    }

    @Test
    void part2ExampleTest() {
        PuzzleTester.test(CorrectRulesRPSTournament::new, 12L);
    }

}
