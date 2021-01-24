package view.swing;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.util.ViewConstants;
import view.util.ViewUtils;

public class ComputerView extends JPanel {

    private JLabel computerLabel;
    private JLabel computerOutput;

    public ComputerView() {
        initComponents();
        initLayout();
    }

    private void initComponents() {
        computerLabel = ViewUtils.createCenteredLabel(ViewConstants.COMPUTER_TEXT);
        computerOutput = ViewUtils.createCenteredLabel();
        computerOutput.setIcon(new ImageIcon(getClass().getResource(ViewConstants.QUESTION_MARK_ICON_PATH)));
    }

    private void initLayout() {
        setLayout(new BorderLayout());
        add(computerLabel, BorderLayout.NORTH);
        add(computerOutput, BorderLayout.CENTER);
    }

    public void updateComputerMove(final String resourcePath) {
        computerOutput.setIcon(new ImageIcon(getClass().getResource(resourcePath)));
    }

    public void resetView() {
        computerOutput.setIcon(new ImageIcon(getClass().getResource(ViewConstants.QUESTION_MARK_ICON_PATH)));
    }
}
