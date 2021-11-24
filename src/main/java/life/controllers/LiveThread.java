package life.controllers;

import life.config.Config;
import life.model.Cell;
import life.utils.Constants;
import life.utils.Status;
import life.view.Pixel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LiveThread implements Runnable {

    private final Pixel[][] pixels;

    public LiveThread(Pixel[][] pixels) {
        this.pixels = pixels;
    }

    @Override
    public void run() {
        initTimer();
    }

    private void initTimer() {
        TimerListener timerListener = new TimerListener();
        Timer timer = new Timer(Constants.TIMER_DELAY, timerListener);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    int neighbors = 0;
                    for (int sx = -1; sx <= 1; sx++) {
                        for (int sy = -1; sy <= 1; sy++) {
                            if (!(sx == 0 && sy == 0)) {
                                if (pixels[(x + sx + Config.WIDTH) % Config.WIDTH]
                                        [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell.getStatus() == Status.LIVE) {
                                    neighbors++;
                                }
                            }
                        }
                    }
                    initCell(neighbors, pixels[x][y].cell);
                    pixels[x][y].setColor();
                }
            }
        }
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

}
