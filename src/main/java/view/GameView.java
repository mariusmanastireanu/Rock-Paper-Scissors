package view;

public interface GameView {

    /**
     * Reset the view for a new game
     */
    void resetView();

    /**
     * Enables/disables player view;
     *
     * @param enable true if enabled
     */
    void enablePlayerView(final boolean enable);

    /**
     * Update the scoreboard based on first's and second's player score
     *
     * @param firstPlayerScore  first player score
     * @param secondPlayerScore second player score
     */
    void updateScore(final int firstPlayerScore, final int secondPlayerScore);

    /**
     * Display the round result.
     *
     * @param roundResult round result
     */
    void displayRoundResult(final String roundResult);

    /**
     * Display computer's move
     *
     * @param resourcePath resource path.
     */
    void displayComputerMove(final String resourcePath);

}
