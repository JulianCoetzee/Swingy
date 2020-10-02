package jules.rpg.gui;

import jules.rpg.App;
import jules.rpg.control.GameControl;
import jules.rpg.game.Game;
import jules.rpg.game.world.*;
import jules.rpg.view.ViewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGame extends JPanel implements ViewGame {

    private static final long serialVersionUID = 1L;

    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    // private JPanel mapPanel;
    private JEditorPane mapPane;
    private JEditorPane infoPane;
    private JScrollPane mapScroll;
    private JButton northButt;
    private JButton eastButt;
    private JButton southButt;
    private JButton westButt;
    private JButton backButt;

    private GameControl control;

    @Override
    public void run() {
        control = new GameControl(this);

        guiMake();
        control.openMap();
    }

    private void guiMake() {

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        // mapPanel = new JPanel();
        mapPane = new JEditorPane();
        infoPane = new JEditorPane();
        northButt = new JButton("North");
        eastButt = new JButton("East");
        southButt = new JButton("South");
        westButt = new JButton("West");
        backButt = new JButton("Back");

        App.getFrame().setTitle("Adventure");
        this.setLayout(gbl);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        infoPane.setEditable(false);
        infoPane.setText("Select Hero for more info");
        infoPane.setPreferredSize(new Dimension(220, 190));
        infoPane.setMinimumSize(new Dimension(200, 200));
        this.add(infoPane, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);

        mapPane.setEditable(false);
        mapPane.setText("Map");
        mapScroll = new JScrollPane(mapPane);
        mapScroll.setPreferredSize(new Dimension(300, 300));
        mapScroll.setMinimumSize(new Dimension(200, 200));
        this.add(mapScroll, gbc);

        this.add(northButt, gbc);
        this.add(eastButt, gbc);
        this.add(southButt, gbc);
        this.add(westButt, gbc);
        this.add(backButt, gbc);
        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();

        northButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.moveMe("north");
            }
        });
        eastButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.moveMe("east");
            }
        });
        southButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.moveMe("south");
            }
        });
        westButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.moveMe("west");
            }
        });
        backButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickBack();
            }
        });
    }

    @Override
    public void retreat() {

        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void printMap(boolean[][] map, Pos heroPos) {

        // int i = 0;
        // int j = 0;
        int ml = map.length;
        int heroPosx = heroPos.getx();
        int heroPosy = heroPos.gety();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("MAP %dx%d\n", ml, ml));

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (heroPosx == j && heroPosy == i)
                    stringBuilder.append("! ");
                else if (map[i][j])
                    stringBuilder.append("* ");
                else
                    stringBuilder.append(". ");
            }
            stringBuilder.append("\n");
        }
        mapPane.setText(stringBuilder.toString());
    }

    @Override
    public void updateMap(Game game) {

        infoPane.setText(game.getHero().toString() +
        "Position: " + "(" + game.getHeroPos().getx() +
        "," + game.getHeroPos().gety() + ")");

        printMap(game.getMap(), game.getHeroPos());
    }

    @Override
    public void endGameout() {

        App.hideFrame();
        App.getFrame().dispose();
    }

    @Override
    public void showMsg(String message) {

        JOptionPane.showMessageDialog(App.getFrame(), message);
    }

    @Override
    public void encounterOption() {

        Object options[] = {"Fight", "Flee"};

        int result = JOptionPane.showOptionDialog(App.getFrame(),
                "You encountered an enemy!",
                "Fight or Flee?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
        if (result == JOptionPane.YES_OPTION)
            control.fightclub();
        else
            control.fleeclub();
    }

    @Override
    public boolean newGear(String loot) {

        Object options[] = {"Equip", "Leave"};

        int result = JOptionPane.showOptionDialog(App.getFrame(),
                "Would you like to equip " + loot + "?",
                "Equip or leave?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        return result == JOptionPane.YES_OPTION;
    }
}