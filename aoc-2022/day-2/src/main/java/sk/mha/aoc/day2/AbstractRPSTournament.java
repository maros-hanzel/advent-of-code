package sk.mha.aoc.day2;

import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.day2.data.RPSMatch;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractRPSTournament implements PuzzleAPI<Long> {

    protected long play(List<String> input, Function<String[], RPSMatch> inputParserFunction) {
        return input.stream()
            .map(line -> line.split(" "))
            .map(inputParserFunction)
            .mapToLong(match -> match.yourHand().getRewardPoints() + match.outcome().getRewardPoints())
            .sum();
    }

    @Override
    public int day() {
        return 2;
    }

}
