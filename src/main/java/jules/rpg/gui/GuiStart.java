package jules.rpg.gui;

import jules.rpg.App;
import jules.rpg.gui.view.ViewStart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiStart extends JPanel implements ViewStart {

    private static final long serialVersionUID = 1L;
    
    private GridLayout glo;
    private JButton newGameButt;
    private JButton selectGameButt;
    private JButton kwit;

    public void run() {
        guiMake();
    }

    private void guiMake() {

        glo = new GridLayout(3, 0);
        newGameButt = new JButton("New Game");
        selectGameButt = new JButton("Continue");
        kwit = new JButton("Exit");

        App.getFrame().setTitle("Start");
        this.setLayout(glo);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        newGameButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameButt.setText("This works!");
            }
        });

        selectGameButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectGameButt.setText("This works!");
            }
        });

        kwit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(newGameButt, glo);
        this.add(selectGameButt, glo);
        this.add(kwit, glo);

        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();



    }

    
}
