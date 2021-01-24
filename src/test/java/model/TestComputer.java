package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class TestComputer {

    private final Computer computer = new Computer();

    @Test
    public void testComputerGeneratesValidMove() {
        final Set<Move> validMoves = Arrays.stream(Move.values()).collect(Collectors.toSet());
        for (int i = 0; i < 100; i++) {
            assertTrue(validMoves.contains(computer.getNextMove()));
        }
    }

    @Test
    public void testComputerGeneratesAllMoves() {
        final Set<Move> generatedMoves = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            generatedMoves.add(computer.getNextMove());
        }
        assertEquals(Arrays.stream(Move.values()).collect(Collectors.toSet()), generatedMoves);
    }

}
