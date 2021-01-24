package view.swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.GameController;
import view.GameView;

public class GameViewImpl extends JPanel implements GameView {

    private InputGameView inputGameView;
    private PlayerView playerView;
    private ComputerView computerView;
    private ScoreboardView scoreboardView;

    public GameViewImpl(final GameController gameController) {
        gameController.setView(this);
        initComponents(gameController);
        initLayout();
    }

    private void initComponents(final GameController gameController) {
        inputGameView = new InputGameView(gameController);
        playerView = new PlayerView(gameController);
        computerView = new ComputerView();
        scoreboardView = new ScoreboardView();
    }

    private void initLayout() {
        setLayout(new BorderLayout());
        final JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputGameView, BorderLayout.NORTH);
        topPanel.add(new JSeparator(), BorderLayout.CENTER);
        topPanel.add(playerView, BorderLayout.SOUTH);

        final JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(new JSeparator(), BorderLayout.NORTH);
        middlePanel.add(computerView, BorderLayout.CENTER);

        final JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JSeparator(), BorderLayout.NORTH);
        bottomPanel.add(scoreboardView, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updateScore(final int firstPlayerScore, final int secondPlayerScore) {
        scoreboardView.updateScore(firstPlayerScore, secondPlayerScore);
    }

    @Override
    public void displayRoundResult(final String result) {
        scoreboardView.updateRoundResult(result);
    }

    @Override
    public void enablePlayerView(boolean enable) {
        playerView.setEnabled(enable);
    }

    @Override
    public void displayComputerMove(final String resourcePath) {
        computerView.updateComputerMove(resourcePath);
    }

    @Override
    public void resetView() {
        computerView.resetView();
    }
}
