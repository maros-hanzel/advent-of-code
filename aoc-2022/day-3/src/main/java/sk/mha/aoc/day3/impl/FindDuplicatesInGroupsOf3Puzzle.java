package sk.mha.aoc.day3.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day3.AbstractRucksackReorganizationPuzzle;

import java.util.List;
import java.util.Set;

@Component
@Order(32)
public class FindDuplicatesInGroupsOf3Puzzle extends AbstractRucksackReorganizationPuzzle {
    @Override
    public Long solve(List<String> input) {
        long sumPriority = 0L;
        for (int i = 0; i < input.size(); i += 3) {
            Set<Character> rucksack1 = toSet(input.get(i));
            rucksack1.retainAll(toSet(input.get(i + 1)));
            rucksack1.retainAll(toSet(input.get(i + 2)));
            sumPriority += priority(rucksack1.iterator().next());
        }
        return sumPriority;
    }
}
