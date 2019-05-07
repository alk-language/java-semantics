package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    JFrame f = new JFrame();

    public void show() {
        f.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setTitle("Alk");
        f.setLayout(new GridLayout(3, 1));

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createTitledBorder("Input Data"));
        f.add(input);

        JPanel algorithm = new JPanel();
        algorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));
        f.add(algorithm);

        JPanel output = new JPanel();
        output.setBorder(BorderFactory.createTitledBorder("Output"));
        f.add(output);
        f.setVisible(true);
    }
}
