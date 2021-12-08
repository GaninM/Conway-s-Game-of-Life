package life.view;

import life.config.Config;
import life.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigFrame extends JFrame implements ActionListener, Runnable {

    private final JTextField WIDTH;

    private final JTextField HEIGHT;

    private final JTextField PIXEL_SIZE;

    private final JTextField NUMBER_OF_STEPS;

    private final JButton SUBMIT;


    public ConfigFrame() {
        this.setTitle("Setting game parameters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(Constants.CONFIG_FRAME_WIDTH, Constants.CONFIG_FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        WIDTH = initTextField();
        HEIGHT = initTextField();
        PIXEL_SIZE = initTextField();
        NUMBER_OF_STEPS = initTextField();
        SUBMIT = new JButton("Submit");
        SUBMIT.addActionListener(this);

        this.add(new JLabel("Width"));
        this.add(WIDTH);
        this.add(new JLabel("Height"));
        this.add(HEIGHT);
        this.add(new JLabel("Pixel size"));
        this.add(PIXEL_SIZE);
        this.add(new JLabel("Number of steps"));
        this.add(NUMBER_OF_STEPS);
        this.add(SUBMIT);
        this.pack();
    }

    private JTextField initTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT));
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SUBMIT) {
            Config.WIDTH = Integer.parseInt(WIDTH.getText());
            Config.HEIGHT = Integer.parseInt(HEIGHT.getText());
            Config.PIXEL_SIZE = Integer.parseInt(PIXEL_SIZE.getText());
            Config.NUMBER_OF_STEPS = Integer.parseInt(NUMBER_OF_STEPS.getText());
            dispose();
            Window window = new Window();
            window.run();
        }
    }

    @Override
    public void run() {
    }

}
