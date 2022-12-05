package sk.mha.aoc.day1;

import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.day1.data.Elf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractCaloriesCounter implements PuzzleAPI<Long> {

    protected long findMaxNCalories(List<Elf> elves, int topN) {
        elves.sort(Comparator.comparingLong(Elf::carryingCalories).reversed());

        long sum = 0L;
        for (int i = 0; i < Math.min(topN, elves.size()); i++) {
            sum += elves.get(i).carryingCalories();
        }

        return sum;
    }

    protected List<Elf> inputToElves(List<String> input) {
        List<Elf> elves = new ArrayList<>();
        long sumCalories = 0L;
        for (String line : input) {
            if (!line.isBlank()) {
                sumCalories += Long.parseLong(line);
            } else {
                elves.add(new Elf(elves.size() + 1, sumCalories));
                sumCalories = 0L;
            }
        }
        if (sumCalories > 0) {
            elves.add(new Elf(elves.size() + 1, sumCalories));
        }

        return elves;
    }

    @Override
    public int day() {
        return 1;
    }

}
