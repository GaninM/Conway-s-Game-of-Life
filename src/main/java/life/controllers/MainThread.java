package life.controllers;

import life.view.Pixel;

public class MainThread implements Runnable {

    private  Pixel[][] pixels;

    public MainThread() {
    }


    @Override
    public void run() {
        LiveThread liveThread = new LiveThread(pixels);
        DeathThread deathThread = new DeathThread(pixels);
        liveThread.run();
        deathThread.run();
    }

    void setPixels(Pixel[][] pixels) {
        this.pixels = pixels;
    }

}

