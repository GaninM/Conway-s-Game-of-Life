package life.model;

import life.config.Config;
import life.model.Pixel;

import javax.swing.*;


public class Window extends JFrame implements Runnable {

    //Основное окно
    private JFrame mainPanel;

    //Массив пикселей
    static Pixel[][] pixels;

    @Override
    public void run() {
        initMainPanel();
        initPixels();
    }

    void initMainPanel() {
        mainPanel = new JFrame("Game of Life");
        //На весь экран
        mainPanel.setLayout(null);
        //Раземер основного экрана
        mainPanel.setSize(Config.width * Config.PIXEL_SIZE + 175, Config.heigth * Config.PIXEL_SIZE + 55);
        //Зыкрытие на крестик
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создание окна, при запуске программы, по центру экрана
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setVisible(true);


        //Кнопка Start
        //Кнопки
        JButton startButton = new JButton("Start");
        startButton.setVisible(true);
        startButton.setBounds(Config.width * Config.PIXEL_SIZE + 20, 25, 120, 30);
        mainPanel.add(startButton);


        //Кнопка Stop
        JButton stopButton = new JButton("Stop");
        stopButton.setVisible(true);
        stopButton.setBounds(Config.width * Config.PIXEL_SIZE + 20, 75, 120, 30);
        mainPanel.add(stopButton);


        //Кнопка Clear
        JButton clearButton = new JButton("Clear");
        clearButton.setVisible(true);
        clearButton.setBounds(Config.width * Config.PIXEL_SIZE + 20, 125, 120, 30);
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

    public Pixel[][] getPixels() {
        return pixels;
    }
}
