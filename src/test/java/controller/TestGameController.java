package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Move;
import model.Player;
import testutils.TestUtils;
import testutils.GameViewAdapter;

public class TestGameController {

    private final GameController controller = new GameController();

    @BeforeEach
    public void resetController() {
        controller.setView(new GameViewAdapter());
        controller.startGame(0);
    }

    @Test
    public void testViewIsResetWhenStartingNewRound() {
        AtomicBoolean viewIsReset = new AtomicBoolean(Boolean.FALSE);
        controller.setView(new GameViewAdapter() {
            @Override
            public void resetView() {
                viewIsReset.set(Boolean.TRUE);
            }
        });
        controller.startGame(3);
        assertTrue(viewIsReset.get());
    }

    @Test
    public void testEnablePlayerView() {
        AtomicBoolean viewIsEnabled = new AtomicBoolean(Boolean.FALSE);
        controller.setView(new GameViewAdapter() {
            @Override
            public void enablePlayerView(boolean enable) {
                viewIsEnabled.set(enable);
            }
        });

        int numberOfRounds = 0;
        controller.startGame(numberOfRounds);
        assertFalse(viewIsEnabled.get());

        numberOfRounds = 3;
        controller.startGame(numberOfRounds);
        assertTrue(viewIsEnabled.get());

        for (int i = 0; i < numberOfRounds; i++) {
            controller.handlePlayerInput(Move.values()[0]);
        }
        assertFalse(viewIsEnabled.get());
    }

    @Test
    public void testDisplayRoundResults() {
        AtomicBoolean scoreIsUpdated = new AtomicBoolean(Boolean.FALSE);
        AtomicBoolean roundResultUpdated = new AtomicBoolean(Boolean.FALSE);
        AtomicBoolean computerMoveUpdated = new AtomicBoolean(Boolean.FALSE);
        controller.setView(new GameViewAdapter() {
            @Override
            public void updateScore(int firstPlayerScore, int secondPlayerScore) {
                scoreIsUpdated.set(Boolean.TRUE);
            }

            @Override
            public void displayRoundResult(String roundResult) {
                roundResultUpdated.set(Boolean.TRUE);
            }

            @Override
            public void displayComputerMove(String resourcePath) {
                computerMoveUpdated.set(Boolean.TRUE);
            }
        });
        controller.handlePlayerInput(Move.values()[0]);
        assertTrue(scoreIsUpdated.get());
        assertTrue(roundResultUpdated.get());
        assertTrue(computerMoveUpdated.get());
    }

    @Test
    public void testHandlePlayerInput() throws Exception {
        TestUtils.setRestrictedField(GameController.class, "computer", controller, (Player) () -> Move.ROCK);

        AtomicReference<Integer> humanScore = new AtomicReference<>(-1);
        AtomicReference<Integer> computerScore = new AtomicReference<>(-1);
        controller.setView(new GameViewAdapter() {
            @Override
            public void updateScore(int firstPlayerScore, int secondPlayerScore) {
                humanScore.set(firstPlayerScore);
                computerScore.set(secondPlayerScore);
            }
        });

        controller.startGame(0);
        assertEquals(0, humanScore.get());
        assertEquals(0, computerScore.get());

        controller.startGame(3);
        controller.handlePlayerInput(Move.ROCK);
        assertEquals(0, humanScore.get());
        assertEquals(0, computerScore.get());

        controller.handlePlayerInput(Move.PAPER);
        assertEquals(1, humanScore.get());
        assertEquals(0, computerScore.get());

        controller.handlePlayerInput(Move.SCISSORS);
        assertEquals(1, humanScore.get());
        assertEquals(1, computerScore.get());
    }



}