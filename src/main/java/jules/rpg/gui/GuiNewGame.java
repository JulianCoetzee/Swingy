package jules.rpg.gui;

import jules.rpg.App;
import jules.rpg.control.NewGameControl;
import jules.rpg.view.ViewNewGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiNewGame extends JPanel implements ViewNewGame {

    private static final long serialVersionUID = 1L;

    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel titlePanel;
    private JPanel charPanel;
    private JPanel classPanel;
    private JEditorPane classInfo;
    private JLabel charLabel;
    private JLabel forgeLabel;
    private JTextField charField;
    private JButton warButt;
    private JButton rangeButt;
    private JButton rogueButt;
    private JButton backButt;

    private NewGameControl control;

    @Override
    public void run() {
        control = new NewGameControl(this);

        guiMake();
    }
    
    private void guiMake() {
    
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        titlePanel = new JPanel();
        charPanel = new JPanel();
        classPanel = new JPanel();
        classInfo = new JEditorPane();
        forgeLabel = new JLabel("FORGE YOUR HERO\n");
        charLabel = new JLabel("Name: ");
        charField = new JTextField(10);
        warButt = new JButton("Forge Warrior");
        rangeButt = new JButton("Forge Ranger");
        rogueButt = new JButton("Forge Rogue");
        backButt = new JButton("Back");

        App.getFrame().setTitle("Forge");
        this.setLayout(gbl);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        titlePanel.add(forgeLabel);
        titlePanel.setVisible(true);
        this.add(titlePanel, gbc);

        charPanel.add(charLabel);
        charPanel.add(charField);
        charPanel.setVisible(true);
        this.add(charPanel, gbc);

        classInfo.setEditable(false);
        classInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        classInfo.setText(
            "Class      Attack  Defense HP\n" +
            "Warrior    20      30      120\n" +
            "Ranger     30      20      100\n" +
            "Rogue      30      30      80\n");
        classInfo.setPreferredSize(new Dimension(160, 90));
        classInfo.setMinimumSize(new Dimension(160, 90));
        this.add(classInfo, gbc);

        classPanel.add(warButt, gbc);
        classPanel.add(rangeButt, gbc);
        classPanel.add(rogueButt, gbc);
        classPanel.setVisible(true);
        this.add(classPanel, gbc);

        this.add(backButt, gbc);
        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();

        warButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickWar(charField.getText());
            }
        });

        rangeButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickRanger(charField.getText());
            }
        });

        rogueButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickRogue(charField.getText());
            }
        });

        backButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickRogue(charField.getText());
            }

        });
    }

    @Override
    public void makeWarrior() {
        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void makeRanger() {
        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void makeRogue() {
        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void retreat() {
        this.setVisible(false);
        new GuiStart().run();
    }
}