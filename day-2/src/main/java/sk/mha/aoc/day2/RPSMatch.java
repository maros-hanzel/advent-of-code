package sk.mha.aoc.day2;

import java.util.Map;

public record RPSMatch(Hand opponentsHand, Hand yourHand) {
    private static final Map<Hand, Hand> WINNING_HAND_RULES = Map.of(
        Hand.ROCK, Hand.SCISSORS,
        Hand.SCISSORS, Hand.PAPER,
        Hand.PAPER, Hand.ROCK
    );

    public static RPSMatch forOutcome(Hand opponentsHand, Outcome outcome) {
        return switch (outcome) {
            case TIE -> new RPSMatch(opponentsHand, opponentsHand);
            case LOSS -> new RPSMatch(opponentsHand, WINNING_HAND_RULES.get(opponentsHand));
            case WIN -> WINNING_HAND_RULES.entrySet().stream()
                .filter(entry -> opponentsHand.equals(entry.getValue()))
                .map(entry -> new RPSMatch(opponentsHand, entry.getKey()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This can't happen"));
        };
    }

    public Outcome outcome() {
        if (opponentsHand == yourHand) {
            return Outcome.TIE;
        }
        Hand losingHand = WINNING_HAND_RULES.get(yourHand);
        return losingHand == opponentsHand ? Outcome.WIN : Outcome.LOSS;
    }
}
