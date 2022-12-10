package sk.mha.aoc.day6;

import sk.mha.aoc.api.PuzzleAPI;

public abstract class TuningTroublePuzzle implements PuzzleAPI<Integer> {
    protected Integer findMarker(String input, int numberOfUniqueChars) {
        char[] dataStream = input.toCharArray();
        for (int i = 0; i < dataStream.length - numberOfUniqueChars; i++) {
            if (isUnique(dataStream, i, numberOfUniqueChars)) {
                return i + numberOfUniqueChars;
            }
        }
        return -1;
    }

    private boolean isUnique(char[] dataStream, int beginIndex, int numberOfUniqueChars) {
        for (int j = beginIndex; j < beginIndex + numberOfUniqueChars; j++) {
            for (int k = beginIndex; k < beginIndex + numberOfUniqueChars; k++) {
                if (j != k && dataStream[j] == dataStream[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int day() {
        return 6;
    }
}
