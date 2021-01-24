package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMove {

    @Test
    public void testRock() {
        assertEquals(Result.TIE, Move.ROCK.evaluate(Move.ROCK));
        assertEquals(Result.LOSE, Move.ROCK.evaluate(Move.PAPER));
        assertEquals(Result.WIN, Move.ROCK.evaluate(Move.SCISSORS));
    }

    @Test
    public void testPaper() {
        assertEquals(Result.WIN, Move.PAPER.evaluate(Move.ROCK));
        assertEquals(Result.TIE, Move.PAPER.evaluate(Move.PAPER));
        assertEquals(Result.LOSE, Move.PAPER.evaluate(Move.SCISSORS));
    }

    @Test
    public void testScissors() {
        assertEquals(Result.LOSE, Move.SCISSORS.evaluate(Move.ROCK));
        assertEquals(Result.WIN, Move.SCISSORS.evaluate(Move.PAPER));
        assertEquals(Result.TIE, Move.SCISSORS.evaluate(Move.SCISSORS));
    }

}
