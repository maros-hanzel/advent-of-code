package sk.mha.aoc.day4.data;

public record Range(int min, int max) {
    public boolean overlaps(Range other) {
        return min <= other.min && max >= other.min
            || max >= other.max && min <= other.max;
    }

    public boolean fullyOverlaps(Range other) {
        return min <= other.min && max >= other.max;
    }
}
