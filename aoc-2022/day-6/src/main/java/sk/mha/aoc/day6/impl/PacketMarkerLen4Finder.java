package sk.mha.aoc.day6.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day6.TuningTroublePuzzle;

import java.util.List;

@Component
@Order(61)
public class PacketMarkerLen4Finder extends TuningTroublePuzzle {
    @Override
    public Integer solve(List<String> input) {
        return findMarker(input.get(0), 4);
    }
}
