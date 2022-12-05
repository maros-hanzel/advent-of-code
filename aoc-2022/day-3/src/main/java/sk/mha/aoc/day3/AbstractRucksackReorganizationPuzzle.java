package sk.mha.aoc.day3;

import sk.mha.aoc.api.PuzzleAPI;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractRucksackReorganizationPuzzle implements PuzzleAPI<Long> {

    protected Set<Character> toSet(String line) {
        return line.chars().mapToObj(integer -> (char) integer).collect(Collectors.toSet());
    }

    protected int priority(char c) {
        return Character.isLowerCase(c) ? c - 96 : c - 38;
    }

    @Override
    public int day() {
        return 3;
    }
}
