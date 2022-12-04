package sk.mha.aoc.day2;

import java.util.HashMap;
import java.util.Map;

public enum Outcome {
    LOSS(0, 'X'),
    TIE(3, 'Y'),
    WIN(6, 'Z');

    private static final Map<Character, Outcome> OUTCOME_MAP = characterOutcomeMap();

    private final int rewardPoints;

    private final char characterRepresentation;

    Outcome(int rewardPoints, char characterRepresentation) {
        this.rewardPoints = rewardPoints;
        this.characterRepresentation = characterRepresentation;
    }

    public static Outcome get(char c) {
        char upperCase = Character.toUpperCase(c);
        Outcome outcome = OUTCOME_MAP.get(upperCase);
        if (null == outcome) {
            throw new IllegalArgumentException("Undefined outcome representation [" + upperCase + "]");
        }
        return outcome;
    }

    public static Outcome get(String s) {
        return get(s.charAt(0));
    }

    private static Map<Character, Outcome> characterOutcomeMap() {
        Map<Character, Outcome> outcomeMap = new HashMap<>();
        for (Outcome outcome : Outcome.values()) {
            if (null != outcomeMap.putIfAbsent(outcome.characterRepresentation, outcome)) {
                throw new IllegalArgumentException("Duplicate outcome representation, all characters must be unique");
            }
        }
        return outcomeMap;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

}
