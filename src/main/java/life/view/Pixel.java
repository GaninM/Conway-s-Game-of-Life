package life.view;

import life.model.Cell;
import life.utils.Status;
import life.config.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pixel extends JPanel {

    public volatile Cell cell;


    public Pixel(int x, int y) {
        super();
        this.cell = new Cell();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBounds(x * Config.PIXEL_SIZE, y * Config.PIXEL_SIZE, Config.PIXEL_SIZE, Config.PIXEL_SIZE);
        setBackground(getColor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.setStatus(Status.LIVE);
                setColor();
            }
        });
    }

    public static Color getColor(Status status) {
        switch (status) {
            default:
            case NONE:
                return Color.pink;
            case LIVE:
                return Color.CYAN;
        }
    }

    public void setColor() {
        setBackground(getColor(cell.getStatus()));
    }

}
