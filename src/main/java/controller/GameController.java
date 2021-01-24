package controller;

import model.Computer;
import model.Move;
import model.Player;
import model.Result;
import view.GameView;
import view.util.ViewConstants;

public class GameController {

    public static final int MINIMUM_NUMBER_OF_ROUNDS = 1;
    public static final int DEFAULT_NUMBER_OF_ROUNDS = 3;

    private final Player computer = new Computer();

    private GameView view;

    private int humanScore = 0;
    private int computerScore = 0;
    private int numberOfRounds = 0;

    public void setView(final GameView view) {
        this.view = view;
    }

    public void startGame(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        resetScore();
        view.enablePlayerView(numberOfRounds != 0);
        view.resetView();
    }

    private void resetScore() {
        humanScore = 0;
        computerScore = 0;
        view.displayRoundResult(ViewConstants.EMPTY_STRING);
        view.updateScore(humanScore, computerScore);
    }

    public void handlePlayerInput(final Move playerMove) {
        final Move computerMove = computer.getNextMove();
        view.displayComputerMove(computerMove.getIconPath());
        handleResult(playerMove.evaluate(computerMove));
        endRound();
    }

    private void handleResult(final Result result) {
        view.displayRoundResult(result.toString());

        if (Result.WIN.equals(result)) {
            humanScore++;
        } else if (Result.LOSE.equals(result)) {
            computerScore++;
        }

        view.updateScore(humanScore, computerScore);
    }

    private void endRound() {
        numberOfRounds--;
        view.enablePlayerView(numberOfRounds != 0);
    }

}
