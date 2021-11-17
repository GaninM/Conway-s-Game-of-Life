package life.view;

import life.config.Config;
import life.model.FrameController;
import life.utils.Status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements Runnable, FrameController {

    private JFrame mainPanel;

    private Pixel[][] pixels;

    @Override
    public void run() {
        initMainPanel();
        initPixels();
    }

    void initMainPanel() {
        mainPanel = new JFrame("Game of Life");
        mainPanel.setLayout(null);
        mainPanel.setSize(Config.WIDTH * Config.PIXEL_SIZE + 175, Config.HEIGHT * Config.PIXEL_SIZE + 55);
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setMinimumSize(new Dimension(300, 300));
        mainPanel.setVisible(true);
        mainPanel.add(initButton("Start", 25));
        mainPanel.add(initButton("Stop", 75));
        mainPanel.add(initButton("Clear", 125));
    }

    private JButton initButton(String nameButton, int y) {
        JButton button = new JButton(nameButton);
        button.setVisible(true);
        button.setBounds(Config.WIDTH * Config.PIXEL_SIZE + 20, y, 120, 30);
        switch (nameButton) {
            case "Start":
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //startGame();
                    }
                });
            case "Stop":
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //stopGame();
                    }
                });
            case "Clear":
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearGame(pixels);
                    }
                });
        }
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
