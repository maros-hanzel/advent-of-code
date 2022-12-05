package sk.mha.aoc.day3.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.data.Pair;
import sk.mha.aoc.day3.AbstractRucksackReorganizationPuzzle;

import java.util.List;
import java.util.Set;

@Component
@Order(31)
public class FindDuplicatesPuzzle extends AbstractRucksackReorganizationPuzzle {
    @Override
    public Long solve(List<String> input) {
        return input.stream()
            .map(this::split)
            .map(pair -> pair.map(this::toSet))
            .map(pair -> {
                pair.left().retainAll(pair.right());
                return pair.left();
            })
            .flatMap(Set::stream)
            .mapToLong(this::priority)
            .sum();
    }

    private Pair<String> split(String line) {
        int half = line.length() / 2;
        return new Pair<>(line.substring(0, half), line.substring(half));
    }
}
