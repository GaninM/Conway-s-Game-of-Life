package life.model;

import life.CellController;
import life.utils.Status;
import life.config.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Pixel extends JPanel {

    Cell cell;

    CellController cellController;

    public Pixel(int x, int y) {
        super();
        this.cell = new Cell();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBounds(x * Config.PIXEL_SIZE, y * Config.PIXEL_SIZE, Config.PIXEL_SIZE, Config.PIXEL_SIZE);
        setBackground(getColor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.status = Status.LIVE;
            }
        });
    }

    //Присваивание цвета ячейку в зависимости от ее состояния
    public static Color getColor(Status status) {
        switch (status) {
            default:
            case NONE:
                return Color.pink;
            case BORN:
            case DIES:
                return Color.LIGHT_GRAY;
            case LIVE:
                return Color.CYAN;

        }
    }

    public void setColor(){
        setBackground(getColor(cell.status));
    }

    public void firstStep(){
        cellController.firstStep();
        setColor();
    }

    public void secondStep(){
        cellController.secondStep();
        setColor();
    }




}
