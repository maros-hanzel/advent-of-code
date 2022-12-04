package sk.mha.aoc.day1;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CaloriesCounterTest {

    @Test
    void aocExercisePart1() {
        long maxCalories = assertDoesNotThrow(() -> CaloriesCounter.findMaxCalories(Paths.get("src/test/resources", "aocExerciseInput")));
        assertEquals(71124L, maxCalories);
    }

    @Test
    void aocExercisePart2() {
        long max3Calories = assertDoesNotThrow(() -> CaloriesCounter.findMax3Calories(Paths.get("src/test/resources", "aocExerciseInput")));
        assertEquals(204639L, max3Calories);
    }

}