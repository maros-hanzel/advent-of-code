package sk.mha.aoc.day5.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day5.AbstractSupplyStacksPuzzle;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@Order(51)
public class CrateMover9000 extends AbstractSupplyStacksPuzzle {
    @Override
    protected Stream<Character> moveBoxesStream(IntStream intRangeStream, Supplier<Character> boxSupplier) {
        return intRangeStream.mapToObj(i -> boxSupplier.get());
    }
}
