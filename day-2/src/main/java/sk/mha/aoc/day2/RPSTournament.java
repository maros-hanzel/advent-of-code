package sk.mha.aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class RPSTournament {

    private RPSTournament() {
        // private constructor to prevent instantiation
    }

    public static long playWithIncorrectRules(Path inputFilePath) throws IOException {
        try (Stream<String> lines = Files.lines(inputFilePath)) {
            return lines.map(line -> line.split(" "))
                .map(parts -> new RPSMatch(Hand.get(parts[0]), Hand.get(parts[1])))
                .mapToLong(match -> match.yourHand().getRewardPoints() + match.outcome().getRewardPoints())
                .sum();
        }
    }

    public static long playWithCorrectRules(Path inputFilePath) throws IOException {
        try (Stream<String> lines = Files.lines(inputFilePath)) {
            return lines.map(line -> line.split(" "))
                .map(parts -> RPSMatch.forOutcome(Hand.get(parts[0]), Outcome.get(parts[1])))
                .mapToLong(match -> match.yourHand().getRewardPoints() + match.outcome().getRewardPoints())
                .sum();
        }
    }

}
