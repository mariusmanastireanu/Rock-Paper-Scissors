package model;

import view.util.ViewConstants;

public enum Result {

    WIN(ViewConstants.WIN_TEXT),
    LOSE(ViewConstants.LOSE_TEXT),
    TIE(ViewConstants.TIE_TEXT);

    private final String displayText;
    Result(final String displayText) {
        this.displayText = displayText;
    }

    @Override
    public String toString() {
        return displayText;
    }
}
