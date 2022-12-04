package sk.mha.aoc.day2;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RPSTournamentTest {

    @Test
    void aocExercisePart1() {
        long sumPoints = assertDoesNotThrow(() -> RPSTournament.playWithIncorrectRules(Paths.get("src/test/resources", "aocExerciseInput")));
        assertEquals(10404L, sumPoints);
    }

    @Test
    void aocExercisePart2() {
        long sumPoints = assertDoesNotThrow(() -> RPSTournament.playWithCorrectRules(Paths.get("src/test/resources", "aocExerciseInput")));
        assertEquals(10334L, sumPoints);
    }

}