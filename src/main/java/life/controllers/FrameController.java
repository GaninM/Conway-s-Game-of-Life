package life.controllers;

import life.config.Config;
import life.utils.Constants;
import life.utils.Status;
import life.view.Pixel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Optional;

public interface FrameController {

    default void startGame(JFrame jFrame, Pixel[][] pixels) {
        MainThread mainThread = new MainThread();
        JButton start = (JButton) getButtonById(jFrame, Constants.START_BUTTON).get();
        JButton clear = (JButton) getButtonById(jFrame, Constants.CLEAR_BUTTON).get();

        start.setText("Running");
        start.setEnabled(false);
        clear.setEnabled(false);

        mainThread.setPixels(pixels);
        randomGenerationCell(pixels);
        mainThread.run();
    }

    default void stopGame(JFrame jFrame) {
        JButton clear = (JButton) getButtonById(jFrame, Constants.CLEAR_BUTTON).get();
        LiveThread.getTimer().stop();
        DeathThread.getTimer().stop();
        clear.setEnabled(true);
    }

    default void resumeGame(JFrame jFrame) {
        JButton clear = (JButton) getButtonById(jFrame, Constants.CLEAR_BUTTON).get();
        LiveThread.getTimer().start();
        DeathThread.getTimer().start();
        clear.setEnabled(false);
    }

    default void clearGame(Pixel[][] pixels) {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                pixels[x][y].cell.setStatus(Status.NONE);
                pixels[x][y].setColor();
            }
        }
    }

    default void randomGenerationCell(Pixel[][] pixels) {
        int countLiveCell = 0;
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                if (pixels[x][y].cell.getStatus() == Status.LIVE) {
                    countLiveCell++;
                }
            }
        }
        if (countLiveCell <= 0) {
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (countLiveCell <= Constants.START_COUNT_LIVE_CELL) {
                        int randomNumber = (int) (Math.random() * 10);
                        if (randomNumber > 8) {
                            pixels[x][y].cell.setStatus(Status.LIVE);
                            pixels[x][y].setColor();
                            countLiveCell++;
                        }
                    }
                }
            }
        }
    }

    default Optional<Component> getButtonById(JFrame mainPanel, String id) {
        return Arrays.stream(mainPanel.getContentPane().getComponents())
                .filter(component -> component instanceof JButton)
                .filter(button -> id.equals(((JButton) button).getClientProperty("id")))
                .findFirst();
    }

}
