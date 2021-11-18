package life.controllers;

import life.config.Config;
import life.utils.Status;
import life.view.Pixel;
import java.awt.*;

public interface FrameController {

    default void startGame() {

    }

    default void stopGame() {

    }

    default void clearGame(Pixel[][] pixels) {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                pixels[x][y].cell.status = Status.NONE;
                pixels[x][y].setBackground(Color.pink);
            }
        }
    }

}
