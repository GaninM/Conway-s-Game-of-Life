package life.view;

import life.config.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfigFrame extends JFrame implements ActionListener, Runnable {

    private final JTextField SET_WIDTH;

    private final JTextField SET_HEIGHT;

    private final JTextField SET_PIXEL_SIZE;

    private final JButton SUBMIT_BUTTON;

    public ConfigFrame() {
        this.setTitle("Setting game parameters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(350, 125);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        SET_WIDTH = new JTextField();
        SET_WIDTH.setPreferredSize(new Dimension(80, 20));

        SET_HEIGHT = new JTextField();
        SET_HEIGHT.setPreferredSize(new Dimension(80, 20));

        SET_PIXEL_SIZE = new JTextField();
        SET_PIXEL_SIZE.setPreferredSize(new Dimension(80, 20));


        SUBMIT_BUTTON = new JButton("Submit");
        SUBMIT_BUTTON.addActionListener(this);

        this.add(new JLabel("Width"));
        this.add(SET_WIDTH);
        this.add(new JLabel("Height"));
        this.add(SET_HEIGHT);
        this.add(new JLabel("Pixel size"));
        this.add(SET_PIXEL_SIZE);
        this.add(SUBMIT_BUTTON);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SUBMIT_BUTTON) {
            Config.WIDTH = Integer.parseInt(SET_WIDTH.getText());
            Config.HEIGHT = Integer.parseInt(SET_HEIGHT.getText());
            Config.PIXEL_SIZE = Integer.parseInt(SET_PIXEL_SIZE.getText());
            dispose();
            life.view.Window window = new Window();
            window.run();
        }
    }

    @Override
    public void run() {

    }

}
