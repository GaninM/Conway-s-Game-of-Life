package life.view;

import life.config.Config;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigFrame extends JFrame implements ActionListener, Runnable {

    private final JTextField WIDTH;
    private final JTextField HEIGHT;
    private final JTextField PIXEL_SIZE;
    private final JButton SUBMIT;


    public ConfigFrame() {
        this.setTitle("Setting game parameters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(350, 125);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        WIDTH = new JTextField();
        HEIGHT = new JTextField();
        PIXEL_SIZE = new JTextField();
        SUBMIT = new JButton("Submit");
        SUBMIT.addActionListener(this);

        this.add(new JLabel("Width"));
        this.add(initTextField(WIDTH));
        this.add(new JLabel("Height"));
        this.add(initTextField(HEIGHT));
        this.add(new JLabel("Pixel size"));
        this.add(initTextField(PIXEL_SIZE));
        this.add(SUBMIT);
        this.pack();
    }

    private JTextField initTextField(JTextField jTextField) {
        jTextField.setPreferredSize(new Dimension(80, 20));
        return jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SUBMIT) {
            Config.WIDTH = Integer.parseInt(WIDTH.getText());
            Config.HEIGHT = Integer.parseInt(HEIGHT.getText());
            Config.PIXEL_SIZE = Integer.parseInt(PIXEL_SIZE.getText());
            dispose();
            life.view.Window window = new Window();
            window.run();
        }
    }

    @Override
    public void run() {

    }

}
