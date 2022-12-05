package sk.mha.aoc.day4;

import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.data.Pair;
import sk.mha.aoc.day4.data.Range;

import java.util.List;
import java.util.function.BiPredicate;

public abstract class AbstractCampCleanupPuzzle implements PuzzleAPI<Long> {
    protected long overlaps(List<String> input, BiPredicate<Range, Range> overlapPredicate) {
        return input.stream()
            .map(line -> line.split(","))
            .map(parts -> new Pair<>(parts[0], parts[1]))
            .map(pair -> pair.map(string -> string.split("-")))
            .map(pair -> pair.map(parts -> new Range(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]))))
            .filter(pair -> overlapPredicate.test(pair.left(), pair.right()) || overlapPredicate.test(pair.right(), pair.left()))
            .count();
    }

    @Override
    public int day() {
        return 4;
    }
}
