package life.utils;

import life.config.Config;

public class Constants {

    //Window constants
    public static final int WINDOW_WIDTH = Config.WIDTH * Config.PIXEL_SIZE + 175;

    public static final int WINDOW_HEIGHT = Config.HEIGHT * Config.PIXEL_SIZE + 55;

    public static final int MIN_WINDOW_WIDTH = 300;

    public static final int MIN_WINDOW_HEIGHT = 300;

    public static final int BUTTON_BOUNDS_X = Config.WIDTH * Config.PIXEL_SIZE + 20;

    public static final String START_BUTTON = "Start";

    public static final String STOP_BUTTON = "Stop";

    public static final String CLEAR_BUTTON = "Clear";

    public static final String RESUME_BUTTON = "Resume";


    //ConfigFrame constants
    public static final int CONFIG_FRAME_WIDTH = 200;

    public static final int CONFIG_FRAME_HEIGHT = 300;

    public static final int TEXT_FIELD_WIDTH = 60;

    public static final int TEXT_FIELD_HEIGHT = 20;


    //Game constants
    public static final int TIMER_DELAY = 350;

    public static final int START_COUNT_LIVE_CELL = (int) (Config.WIDTH * Config.HEIGHT * 0.05);

}
