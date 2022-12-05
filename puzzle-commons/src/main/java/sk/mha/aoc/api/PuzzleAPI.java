package sk.mha.aoc.api;

import java.util.List;

public interface PuzzleAPI<T> {

    int day();

    T solve(List<String> input);

}
