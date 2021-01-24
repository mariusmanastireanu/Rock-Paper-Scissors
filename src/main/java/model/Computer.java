package model;

import java.util.Random;

public class Computer implements Player {

    private static final Random RANDOM = new Random();
    private static final Move[] POSSIBLE_VALUES = Move.values();

    @Override
    public Move getNextMove() {
        return POSSIBLE_VALUES[RANDOM.nextInt(POSSIBLE_VALUES.length)];
    }

}
