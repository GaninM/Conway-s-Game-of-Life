package life.model;

import life.config.Config;
import javax.swing.*;
import java.awt.*;


public class Window extends JFrame implements Runnable {

    private JFrame mainPanel;

    static Pixel[][] pixels;

    @Override
    public void run() {
        initMainPanel();
        initPixels();
    }

    void initMainPanel() {
        mainPanel = new JFrame("Game of Life");
        mainPanel.setLayout(null);
        mainPanel.setSize(Config.width * Config.pixelSize + 175, Config.heigth * Config.pixelSize + 55);
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setMinimumSize(new Dimension(300, 300));
        mainPanel.setVisible(true);

        JButton startButton = new JButton("Start");
        startButton.setVisible(true);
        startButton.setBounds(Config.width * Config.pixelSize + 20, 25, 120, 30);
        mainPanel.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.setVisible(true);
        stopButton.setBounds(Config.width * Config.pixelSize + 20, 75, 120, 30);
        mainPanel.add(stopButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setVisible(true);
        clearButton.setBounds(Config.width * Config.pixelSize + 20, 125, 120, 30);
        mainPanel.add(clearButton);
    }

    void initPixels() {
        pixels = new Pixel[Config.width][Config.heigth];
        for (int x = 0; x < Config.width; x++) {
            for (int y = 0; y < Config.heigth; y++) {
                pixels[x][y] = new Pixel(x, y);
                mainPanel.add(pixels[x][y]);
            }
        }
    }

}
