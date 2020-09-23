package jules.rpg.gui;

import jules.rpg.App;
import jules.rpg.control.StartControl;
import jules.rpg.view.ViewStart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiStart extends JPanel implements ViewStart {

    private static final long serialVersionUID = 1L;
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JButton newGameButt;
    private JButton selectGameButt;
    private JButton kwit;

    private StartControl control;

    @Override
    public void run() {
        control = new StartControl(this);
        guiMake();
    }

    private void guiMake() {

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        newGameButt = new JButton("New Game");
        selectGameButt = new JButton("Continue");
        kwit = new JButton("Exit");

        App.getFrame().setTitle("Start");
        this.setLayout(gbl);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        this.add(newGameButt, gbc);
        this.add(selectGameButt, gbc);
        this.add(kwit, gbc);

        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();

        newGameButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickNewGame();
            }
        });

        selectGameButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickContinue();
            }
        });

        kwit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickKwit();
            }
        });
    }
    
    @Override
    public void newGame() {
        this.setVisible(false);
        new GuiNewGame().run();
    }

    @Override
    public void loadGame() {
        selectGameButt.setText("This works!");
    }

    @Override
    public void kwit() {
        System.exit(1);
    }    
}