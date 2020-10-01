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
    private JPanel titlePanel;
    // private JPanel mapPanel;
    private JEditorPane mapPane;
    private JEditorPane infoPane;
    private JScrollPane mapScroll;
    private Game game;
    private JPanel ctrlPanel;
    private JLabel titleLabel;
    private JLabel ctrlLabel;
    private JButton northButt;
    private JButton eastButt;
    private JButton southButt;
    private JButton westButt;
    private JButton kickButt;
    private JButton fleeButt;
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
        titlePanel = new JPanel();
        // mapPanel = new JPanel();
        ctrlPanel = new JPanel();
        mapPane = new JEditorPane();
        titleLabel = new JLabel("ADVENTURE TO THE EDGE");
        ctrlLabel = new JLabel("CONTROLS");
        northButt = new JButton("North");
        eastButt = new JButton("East");
        southButt = new JButton("South");
        westButt = new JButton("West");
        kickButt = new JButton("Fight");
        fleeButt = new JButton("Flee");
        backButt = new JButton("Back");

        App.getFrame().setTitle("Adventure");
        this.setLayout(gbl);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        titlePanel.add(titleLabel);
        titlePanel.setVisible(true);
        this.add(titlePanel, gbc);

        mapPane.setEditable(false);
        mapPane.setText("Map");
        mapScroll = new JScrollPane(mapPane);
        mapScroll.setPreferredSize(new Dimension(300, 300));
        mapScroll.setMinimumSize(new Dimension(200, 200));

        this.add(backButt, gbc);
        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();

        backButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickBack();
            }
        });
    }

    // @Override
    // public void north() {

    // }

    // @Override
    // public void east() {

    // }

    // @Override
    // public void south() {

    // }

    // @Override
    // public void west() {

    // }

    @Override
    public void retreat() {
        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void printMap(boolean[][] map, Pos heroPos) {

        int i = 0;
        int j = 0;
        int ml = map.length;
        int heroPosx = game.getHeroPos().getx();
        int heroPosy = game.getHeroPos().gety();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("MAP %dx%d\n", ml, ml));

        while (i < ml)
        {
            while(j < map[i].length)
            {
                if(j == heroPosy && i == heroPosx)
                    stringBuilder.append("H");
                else if(map[i][j])
                {
                    stringBuilder.append("X");
                }
                else
                    stringBuilder.append(".");
                j++;
            }
            stringBuilder.append("\n");
            i++;
        }
        mapPane.setText(stringBuilder.toString());
    }

    @Override
    public void updateMap(Game game) {

        printMap(game.getMap(), game.getHeroPos());
    }

    @Override
    public void endGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showMsg(String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getVillian() {
        // TODO Auto-generated method stub

    }

}
