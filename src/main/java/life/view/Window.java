package life.view;

import life.config.Config;
import life.controllers.FrameController;
import life.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame implements Runnable, FrameController {

    private JFrame mainPanel;

    private volatile Pixel[][] pixels;


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
        mainPanel.add(initButton("start", 25, e -> startGame(pixels)));
        mainPanel.add(initButton("stop", 75, e -> stopGame()));
        mainPanel.add(initButton("clear", 125, e -> clearGame(pixels)));
    }

    private JButton initButton(String name, int axisY, ActionListener action) {
        JButton button = new JButton(name);
        button.setVisible(true);
        button.setBounds(Constants.BUTTON_BOUNDS_X, axisY, 120, 30);
        button.addActionListener(action);
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
