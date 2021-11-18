package life.view;

import life.config.Config;
import life.controllers.FrameController;

import javax.swing.*;
import java.awt.*;

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
        mainPanel.setSize(Config.WIDTH * Config.PIXEL_SIZE + 175, Config.HEIGHT * Config.PIXEL_SIZE + 55);
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setMinimumSize(new Dimension(300, 300));
        mainPanel.setVisible(true);

        JButton start = new JButton("Start");
        start.addActionListener(e -> startGame());

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> stopGame());

        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> clearGame(pixels));

        mainPanel.add(initButton(start, 25));
        mainPanel.add(initButton(stop, 75));
        mainPanel.add(initButton(clear, 125));
    }

    private JButton initButton(JButton button, int axisY) {
        button.setVisible(true);
        button.setBounds(Config.WIDTH * Config.PIXEL_SIZE + 20, axisY, 120, 30);
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
