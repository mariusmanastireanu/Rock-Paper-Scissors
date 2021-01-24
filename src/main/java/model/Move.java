package model;

import java.util.EnumMap;
import java.util.Map;

import view.util.ViewConstants;

public enum Move {

    ROCK(ViewConstants.ROCK_ICON_PATH),
    PAPER(ViewConstants.PAPER_ICON_PATH),
    SCISSORS(ViewConstants.SCISSORS_ICON_PATH);

    private final String iconPath;
    Move(final String iconPath) {
        this.iconPath = iconPath;
    }

    private static final Map<Move, Move> beats = new EnumMap<>(Move.class);

    static {
        beats.put(ROCK, SCISSORS);
        beats.put(PAPER, ROCK);
        beats.put(SCISSORS, PAPER);
    }

    public Result evaluate(final Move opponent) {
        if (this.equals(opponent)) {
            return Result.TIE;
        }
        return beats.get(this).equals(opponent) ? Result.WIN : Result.LOSE;
    }

    public String getIconPath() {
        return iconPath;
    }

}
