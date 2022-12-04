package sk.mha.aoc.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RPSMatchTest {

    @Test
    void winTest() {
        assertEquals(Outcome.WIN, matchOutcome(Hand.ROCK, Hand.PAPER));
        assertEquals(Outcome.WIN, matchOutcome(Hand.PAPER, Hand.SCISSORS));
        assertEquals(Outcome.WIN, matchOutcome(Hand.SCISSORS, Hand.ROCK));
    }

    @Test
    void lossTest() {
        assertEquals(Outcome.LOSS, matchOutcome(Hand.ROCK, Hand.SCISSORS));
        assertEquals(Outcome.LOSS, matchOutcome(Hand.PAPER, Hand.ROCK));
        assertEquals(Outcome.LOSS, matchOutcome(Hand.SCISSORS, Hand.PAPER));
    }

    @Test
    void tieTest() {
        assertEquals(Outcome.TIE, matchOutcome(Hand.ROCK, Hand.ROCK));
        assertEquals(Outcome.TIE, matchOutcome(Hand.PAPER, Hand.PAPER));
        assertEquals(Outcome.TIE, matchOutcome(Hand.SCISSORS, Hand.SCISSORS));
    }

    @Test
    void winForOutcomeTest() {
        assertEquals(Hand.PAPER, yourHandForOutcome(Hand.ROCK, Outcome.WIN));
        assertEquals(Hand.SCISSORS, yourHandForOutcome(Hand.PAPER, Outcome.WIN));
        assertEquals(Hand.ROCK, yourHandForOutcome(Hand.SCISSORS, Outcome.WIN));
    }

    @Test
    void lossForOutcomeTest() {
        assertEquals(Hand.PAPER, yourHandForOutcome(Hand.SCISSORS, Outcome.LOSS));
        assertEquals(Hand.SCISSORS, yourHandForOutcome(Hand.ROCK, Outcome.LOSS));
        assertEquals(Hand.ROCK, yourHandForOutcome(Hand.PAPER, Outcome.LOSS));
    }

    @Test
    void tieForOutcomeTest() {
        assertEquals(Hand.ROCK, yourHandForOutcome(Hand.ROCK, Outcome.TIE));
        assertEquals(Hand.PAPER, yourHandForOutcome(Hand.PAPER, Outcome.TIE));
        assertEquals(Hand.SCISSORS, yourHandForOutcome(Hand.SCISSORS, Outcome.TIE));
    }

    private Outcome matchOutcome(Hand opponentsHand, Hand yourHand) {
        return new RPSMatch(opponentsHand, yourHand).outcome();
    }

    private Hand yourHandForOutcome(Hand opponentHand, Outcome outcome) {
        return RPSMatch.forOutcome(opponentHand, outcome).yourHand();
    }

}