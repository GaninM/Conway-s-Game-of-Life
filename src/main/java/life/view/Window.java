package life.view;

import life.config.Config;
import life.controllers.FrameController;
import life.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame implements Runnable, FrameController {

    private JFrame mainPanel;

    private Pixel[][] pixels;


    @Override
    public void run() {
        initMainPanel();
        initPixels();
    }


    private void initMainPanel() {
        mainPanel = new JFrame("Game of Life");
        mainPanel.setLayout(null);
        mainPanel.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setMinimumSize(new Dimension(Constants.MIN_WINDOW_WIDTH, Constants.MIN_WINDOW_HEIGHT));
        mainPanel.setVisible(true);
        mainPanel.add(initButton(Constants.START_BUTTON, Constants.START_BUTTON, 25, e -> startGame(mainPanel, pixels)));
        mainPanel.add(initButton(Constants.STOP_BUTTON, Constants.STOP_BUTTON, 75, e -> stopGame(mainPanel)));
        mainPanel.add(initButton(Constants.RESUME_BUTTON, Constants.RESUME_BUTTON, 125, e -> resumeGame(mainPanel)));
        mainPanel.add(initButton(Constants.CLEAR_BUTTON, Constants.CLEAR_BUTTON, 175, e -> clearGame(pixels)));
    }

    private JButton initButton(String id, String name, int axisY, ActionListener action) {
        JButton button = new JButton(name);
        button.setVisible(true);
        button.setBounds(Constants.BUTTON_BOUNDS_X, axisY, 120, 30);
        button.addActionListener(action);
        button.putClientProperty("id", id);
        return button;
    }

    private void initPixels() {
        pixels = new Pixel[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                pixels[x][y] = new Pixel(x, y);
                mainPanel.add(pixels[x][y]);

            }
        }
    }

}
