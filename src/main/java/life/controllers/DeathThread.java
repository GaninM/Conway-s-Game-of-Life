package life.controllers;

import life.config.Config;
import life.model.Cell;
import life.utils.Constants;
import life.utils.Status;
import life.view.Pixel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathThread implements Runnable {

    private Pixel[][] pixels;

    private static Timer timer;

    private int stepCount = 0;


    public DeathThread() {
    }


    @Override
    public void run() {
        initTimer();
    }

    private void initTimer() {
        TimerListener timerListener = new TimerListener();
        timer = new Timer(Constants.TIMER_DELAY, timerListener);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (stepCount != Config.NUMBER_OF_STEPS) {
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
                stepCount++;
            } else {
                System.out.println("DeathThread.stop()");
                timer.stop();
            }
        }
    }

    private void initCell(int neighbors, Cell cell) {
        cell.setStatus(initCellStatus(neighbors, cell.getStatus()));
    }

    private Status initCellStatus(int around, Status status) {
        if (status == Status.LIVE) {
            return (around < 2 || around > 4) ? Status.NONE : Status.LIVE;
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
