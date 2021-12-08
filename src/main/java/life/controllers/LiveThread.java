package life.controllers;

import life.config.Config;
import life.model.Cell;
import life.utils.Constants;
import life.utils.Status;
import life.view.Pixel;

import javax.swing.*;

public class LiveThread implements Runnable {

    private Pixel[][] pixels;

    private int stepCount = 0;

    private static Timer timer;


    @Override
    public void run() {
        initTimer();
    }


    private void initTimer() {
        timer = new Timer(Constants.TIMER_DELAY, e -> liveGeneration());
        timer.start();
    }

        public void liveGeneration() {
            if (stepCount == Config.NUMBER_OF_STEPS) {
                System.out.println("LiveThread is stop");
                timer.stop();
            } else {
                for (int x = 0; x < Config.WIDTH; x++) {
                    for (int y = 0; y < Config.HEIGHT; y++) {
                        int neighbors = aroundAliveNeighbors(x, y);
                        initCell(neighbors, pixels[x][y].cell);
                        pixels[x][y].setColor();
                    }
                }
                stepCount++;
                System.out.println(stepCount);
            }
        }

    int aroundAliveNeighbors(int x, int y) {
        int neighbors = 0;
        for (int sx = -1; sx <= 1; sx++) {
            for (int sy = -1; sy <= 1; sy++) {
                int width = (x + sx + Config.WIDTH) % Config.WIDTH;
                int height = (y + sy + Config.HEIGHT) % Config.HEIGHT;
                if (!(sx == 0 && sy == 0) & pixels[width][height].cell.getStatus() == Status.LIVE) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    private void initCell(int neighbors, Cell cell) {
        cell.setStatus(initCellStatus(neighbors, cell.getStatus()));
    }

    private Status initCellStatus(int around, Status status) {
        if (status == Status.NONE) {
            return (around == 3) ? Status.LIVE : Status.NONE;
        }
        return status;
    }

    public void setPixels(Pixel[][] pixels) {
        this.pixels = pixels;
    }

    public static Timer getTimer() {
        return timer;
    }

}
