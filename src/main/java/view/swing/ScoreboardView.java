package view.swing;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.util.ViewConstants;
import view.util.ViewUtils;

public class ScoreboardView extends JPanel {

    private JLabel roundResultLabel;
    private JLabel finalResultLabel;
    private JLabel scoreLabel;

    public ScoreboardView() {
        initComponents();
        initLayout();

        updateRoundResult(ViewConstants.EMPTY_STRING);
        updateScore(0, 0);
    }

    private void initComponents() {
        roundResultLabel = ViewUtils.createCenteredLabel();
        finalResultLabel = ViewUtils.createCenteredLabel(ViewConstants.SCOREBOARD_TEXT);
        scoreLabel = ViewUtils.createCenteredLabel();
    }

    private void initLayout() {
        setLayout(new BorderLayout());
        add(roundResultLabel, BorderLayout.NORTH);
        add(finalResultLabel, BorderLayout.CENTER);
        add(scoreLabel, BorderLayout.SOUTH);
    }

    public void updateRoundResult(final String result) {
        roundResultLabel.setText(String.format(ViewConstants.ROUND_RESULT_TEXT, result));
    }

    public void updateScore(int playerScore, int computerScore) {
        scoreLabel.setText(String.format(ViewConstants.SCORE_TEXT, playerScore, computerScore));
    }

}
