package sk.mha.aoc.data;

import java.util.function.Function;

public record Pair<T>(T left, T right) {
    public <O> Pair<O> map(Function<T, O> function) {
        return new Pair<>(function.apply(left), function.apply(right));
    }
}
