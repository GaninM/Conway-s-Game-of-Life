package life.controllers;

import life.config.Config;
import life.model.Cell;
import life.utils.Status;
import life.view.Pixel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainThread implements Runnable {

    public Pixel[][] pixels;


    public MainThread() {
    }

    @Override
    public void run() {
        searchCell();
        initTimer();
    }


    private void searchCell() {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                for (int sx = -1; sx <= 1; sx++) {
                    for (int sy = -1; sy <= 1; sy++) {
                        if (!(sx == 0 && sy == 0)) {
                            pixels[x][y].cell.addNearNeighbors(
                                    pixels[(x + sx + Config.WIDTH) % Config.WIDTH][
                                            (y + sy + Config.HEIGHT) % Config.HEIGHT]
                                            .cell);
                        }
                    }
                }
            }
        }
    }

    private void initTimer() {
        TimerListener timerListener = new TimerListener();
        Timer timer = new Timer(500, timerListener);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    initCell(pixels[x][y].cell.getNearNeighbors(), pixels[x][y].cell);
                    pixels[x][y].setColor();
                }
            }
        }
    }

    private void initCell(List<Cell> nearNeighbors, Cell cell) {
        int around = countNearCells(nearNeighbors);
        cell.setStatus(initCellStatus(around, cell.getStatus()));
    }

    private int countNearCells(List<Cell> nearNeighbors) {
        int count = 0;
        for (Cell cell : nearNeighbors) {
            if (cell.getStatus() == Status.LIVE) {
                count++;
            }
        }
        return count;
    }

    private Status initCellStatus(int around, Status status) {
        switch (status) {
            case NONE:
                return (around == 3) ? Status.LIVE : Status.NONE;
            case LIVE:
                return (around < 2 || around > 4) ? Status.NONE : Status.LIVE;
            default:
                return status;
        }
    }
}

