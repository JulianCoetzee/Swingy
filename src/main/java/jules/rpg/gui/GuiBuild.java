package jules.rpg.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiBuild implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private int i = 0;

    public GuiBuild() {

        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("It works: yes x 0");
        JButton button = new JButton("Please work");

        button.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Babby's first RPG");
        frame.pack();
        frame.setVisible(true);  
    }

    @Override
        public void actionPerformed(ActionEvent e) {

            i++;
            label.setText("It works: yes x " + i);
        }

    
}
