package view.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameController;
import model.Move;
import view.util.ViewConstants;
import view.util.ViewUtils;

public class PlayerView extends JPanel {

    private final Collection<JButton> options = new ArrayList<>();
    private final GameController controller;

    private JLabel infoLabel;

    public PlayerView(final GameController controller) {
        this.controller = controller;
        initComponents();
        initLayout();
        initEvents();
        setEnabled(false);
    }

    private void initComponents() {
        infoLabel = ViewUtils.createCenteredLabel(ViewConstants.CHOOSE_NEXT_MOVE_TEXT);
        Arrays.stream(Move.values()).forEach(move -> {
            final JButton button = new JButton();
            button.setIcon(new ImageIcon(PlayerView.this.getClass().getResource(move.getIconPath())));
            button.addActionListener(e -> controller.handlePlayerInput(move));
            options.add(button);
        });
    }

    private void initLayout() {
        setLayout(new BorderLayout());
        add(infoLabel, BorderLayout.NORTH);
        final JPanel movesPanel = new JPanel(new FlowLayout());
        options.forEach(movesPanel::add);
        add(movesPanel, BorderLayout.SOUTH);
    }

    private void initEvents() {

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        options.forEach(button -> button.setEnabled(enabled));
    }
}
