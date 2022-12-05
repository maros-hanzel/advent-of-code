package sk.mha.aoc.day2.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day2.AbstractRPSTournament;
import sk.mha.aoc.day2.constant.Hand;
import sk.mha.aoc.day2.data.RPSMatch;

import java.util.List;

@Component
@Order(21)
public class IncorrectRulesRPSTournament extends AbstractRPSTournament {
    @Override
    public Long solve(List<String> input) {
        return play(input, pair -> new RPSMatch(pair.map(Hand::get)));
    }
}
