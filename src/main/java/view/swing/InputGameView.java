package view.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.GameController;
import view.util.ViewConstants;

public class InputGameView extends JPanel {

    private final GameController gameController;

    private JLabel numberOfRoundsLabel;
    private JSpinner numberOfRoundsSpinner;
    private JButton startButton;

    public InputGameView(final GameController gameController) {
        this.gameController = gameController;
        initComponents();
        initLayout();
        initEvents();
    }

    private void initComponents() {
        numberOfRoundsLabel = new JLabel(ViewConstants.CHOOSE_ROUNDS_NUMBER_TEXT);
        numberOfRoundsSpinner = new JSpinner(new SpinnerNumberModel());
        ((SpinnerNumberModel) numberOfRoundsSpinner.getModel()).setMinimum(GameController.MINIMUM_NUMBER_OF_ROUNDS);
        numberOfRoundsSpinner.setValue(GameController.DEFAULT_NUMBER_OF_ROUNDS);
        startButton = new JButton(ViewConstants.START_BUTTON_TEXT);
    }

    private void initLayout() {
        setLayout(new FlowLayout());
        add(numberOfRoundsLabel);
        add(numberOfRoundsSpinner);
        add(startButton);
    }

    private void initEvents() {
        startButton.addActionListener(e -> gameController.startGame((Integer) numberOfRoundsSpinner.getValue()));
    }
}
