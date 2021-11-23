package life.controllers;

import life.config.Config;
import life.utils.Status;
import life.view.Pixel;

public interface FrameController {

    MainThread mainThread = new MainThread();


    default void startGame(Pixel[][] pixels) {
        mainThread.pixels = pixels;
        mainThread.run();
    }

    default void stopGame() {

    }

    default void clearGame(Pixel[][] pixels) {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                pixels[x][y].cell.setStatus(Status.NONE);
                pixels[x][y].setColor();
            }
        }
    }

}