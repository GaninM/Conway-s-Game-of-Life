package life.controllers;

import life.config.Config;
import life.utils.Constants;
import life.utils.Status;
import life.view.Pixel;

public interface FrameController {

    MainThread mainThread = new MainThread();

    default void startGame(Pixel[][] pixels) {
        mainThread.setPixels(pixels);
        randomGenerationCell(pixels);
        mainThread.run();
    }

    default void stopGame(Pixel[][] pixels) {

    }

    default void resumeGame() {
        mainThread.notify();
    }

    default void clearGame(Pixel[][] pixels) {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                pixels[x][y].cell.setStatus(Status.NONE);
                pixels[x][y].setColor();
            }
        }
    }

    private void randomGenerationCell(Pixel[][] pixels) {
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

}
