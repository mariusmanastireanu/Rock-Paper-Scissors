package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.GameController;
import view.swing.GameViewImpl;
import view.util.ViewConstants;

public class Main {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final GameController gameController = new GameController();
        final GameViewImpl gameView = new GameViewImpl(gameController);

        frame.setContentPane(gameView);
        frame.setSize(new Dimension(gameView.getPreferredSize().width, ViewConstants.DEFAULT_WINDOW_HEIGHT));

        frame.setResizable(false);
        frame.setVisible(true);
    }

}
