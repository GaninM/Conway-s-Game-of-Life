package life.controllers;

import life.view.Pixel;

public class MainThread implements Runnable {

    private Pixel[][] pixels;


    @Override
    public void run() {
        LiveThread liveThread = new LiveThread();
        DeathThread deathThread = new DeathThread();
        liveThread.setPixels(pixels);
        deathThread.setPixels(pixels);
        liveThread.run();
        deathThread.run();
    }

    public void setPixels(Pixel[][] pixels) {
        this.pixels = pixels;
    }

}

