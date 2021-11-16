package life.model;

import life.config.Config;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfigFrame extends JFrame implements ActionListener, Runnable {

    JTextField setWidth;

    JTextField setHeight;

    JTextField setPixelSize;

    JButton submitButton;

    public ConfigFrame() {
        this.setTitle("Setting game parameters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        setWidth = new JTextField();
        setWidth.setPreferredSize(new Dimension(80, 20));

        setHeight = new JTextField();
        setHeight.setPreferredSize(new Dimension(80, 20));

        setPixelSize = new JTextField();
        setPixelSize.setPreferredSize(new Dimension(80, 20));

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        this.add(setWidth);
        this.add(setHeight);
        this.add(setPixelSize);
        this.add(submitButton);
        this.pack();
        this.setSize(350, 125);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            Config.width = Integer.parseInt(setWidth.getText());
            Config.heigth = Integer.parseInt(setHeight.getText());
            Config.pixelSize = Integer.parseInt(setPixelSize.getText());
            dispose();
            Window window = new Window();
            window.run();
        }
    }

    @Override
    public void run() {

    }

}
