package sk.mha.aoc.day2;

import java.util.HashMap;
import java.util.Map;

public enum Hand {
    ROCK(1, 'A', 'X'),
    PAPER(2, 'B', 'Y'),
    SCISSORS(3, 'C', 'Z');

    private static final Map<Character, Hand> HAND_MAP = characterRepresentationMap();

    private final int rewardPoints;

    private final char[] chars;

    Hand(int rewardPoints, char... chars) {
        this.rewardPoints = rewardPoints;
        this.chars = chars;
    }

    public static Hand get(char c) {
        char upperCase = Character.toUpperCase(c);
        Hand hand = HAND_MAP.get(upperCase);
        if (null == hand) {
            throw new IllegalArgumentException("Undefined hand representation [" + upperCase + "]");
        }
        return hand;
    }

    public static Hand get(String s) {
        return get(s.charAt(0));
    }

    private static Map<Character, Hand> characterRepresentationMap() {
        Map<Character, Hand> handMap = new HashMap<>();
        for (Hand hand : Hand.values()) {
            for (char c : hand.chars) {
                if (null != handMap.putIfAbsent(c, hand)) {
                    throw new IllegalArgumentException("Duplicate hand representation, all characters must be unique");
                }
            }
        }
        return handMap;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

}
