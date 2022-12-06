package sk.mha.aoc.day4;

import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.day4.data.MoveCommand;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class AbstractSupplyStacksPuzzle implements PuzzleAPI<String> {
    @Override
    public String solve(List<String> input) {
        int blankLineIndex = blankLineIndex(input);
        Deque<Character>[] stacks = prepareStacks(input.subList(0, blankLineIndex));
        List<MoveCommand> moveCommands = prepareMoveCommands(input.subList(blankLineIndex + 1, input.size()));

        moveCommands.forEach(command ->
            moveBoxesStream(IntStream.range(0, command.numberOfBoxes()), stacks[command.fromIndex()]::pollLast)
                .filter(Objects::nonNull)
                .forEach(stacks[command.toIndex()]::add)
        );

        return Arrays.stream(stacks)
            .map(Deque::peekLast)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }

    protected abstract Stream<Character> moveBoxesStream(IntStream intRangeStream, Supplier<Character> boxSupplier);

    @SuppressWarnings("unchecked")
    private Deque<Character>[] prepareStacks(List<String> input) {
        String headerStackNumbers = input.get(input.size() - 1);
        String numberString = headerStackNumbers.substring(headerStackNumbers.lastIndexOf(' ') + 1);
        short numberOfStacks = Short.parseShort(numberString);

        Stream<Deque<Character>> stream = IntStream.range(0, numberOfStacks).mapToObj(ArrayDeque::new);
        Deque<Character>[] stacks = stream.toArray(Deque[]::new);

        for (int lineIndex = input.size() - 2; lineIndex >= 0; lineIndex--) {
            String line = input.get(lineIndex);
            for (int charIndex = 1; charIndex < line.length(); charIndex += 4) {
                char c = line.charAt(charIndex);
                if (Character.isAlphabetic(c)) {
                    stacks[charIndex / 4].add(c);
                }
            }
        }

        return stacks;
    }

    private List<MoveCommand> prepareMoveCommands(List<String> inputs) {
        return inputs.stream()
            .map(line -> {
                int numberOfBoxes = numberAfter(line, 'e');
                int from = numberAfter(line, 'm') - 1;
                int to = numberAfter(line, 'o') - 1;
                return new MoveCommand(numberOfBoxes, from, to);
            })
            .toList();
    }

    private int numberAfter(String string, char c) {
        int index = string.lastIndexOf(c) + 2;
        int endIndex = string.indexOf(' ', index);
        return Integer.parseInt(string.substring(index, endIndex != -1 ? endIndex : string.length()));
    }

    protected int blankLineIndex(List<String> input) {
        int blankLineIndex = 0;
        for (String line : input) {
            if (line.isBlank()) {
                break;
            }
            blankLineIndex++;
        }
        return blankLineIndex;
    }

    @Override
    public int day() {
        return 5;
    }
}
