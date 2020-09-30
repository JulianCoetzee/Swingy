package jules.rpg.gui;

import jules.rpg.App;
import jules.rpg.control.ContinueControl;
import jules.rpg.view.ViewContinue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class GuiContinue extends JPanel implements ViewContinue {

    private static final long serialVersionUID = 1L;

    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JComboBox<String> charSelect;
    private ArrayList<String> charList;
    private File[] charFolder;
    private JPanel titlePanel;
    private JPanel charPanel;
    private JLabel charLabel;
    private JLabel loadLabel;
    private JButton loadButt;
    private JButton delButt;
    private JButton backButt;
    private int i;

    private ContinueControl control;

    @Override
    public void run() {
        control = new ContinueControl(this);

        guiMake();
    }

    private void guiMake() {

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        charFolder = new File("src/main/java/jules/rpg/charfiles").listFiles();
        charSelect = new JComboBox<>();
        charList = new ArrayList<String>();
        titlePanel = new JPanel();
        charPanel = new JPanel();
        loadLabel = new JLabel("LOAD CHARACTER\n");
        charLabel = new JLabel("SELECT\n");
        loadButt = new JButton("Load");
        delButt = new JButton("Delete");
        backButt = new JButton("Back");
        i = 0;
        
        App.getFrame().setTitle("Reforge");
        this.setLayout(gbl);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        titlePanel.add(loadLabel);
        titlePanel.setVisible(true);
        this.add(titlePanel, gbc);

        charPanel.add(charLabel);
        while (i < charFolder.length)
        {
            if (charFolder[i].isFile())
                charList.add(charFolder[i].getName());
            i++;
        }
        charSelect.setModel(new DefaultComboBoxModel<String>(charList.toArray(new String[0])));
        charSelect.setSelectedIndex(0);
        charPanel.add(charSelect);
        charPanel.add(loadButt);
        charPanel.add(delButt);
        charPanel.setVisible(true);
        this.add(charPanel, gbc);
        
        this.add(backButt, gbc);
        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();

        loadButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickLoad(charSelect.getSelectedItem().toString());
            }
        });

        delButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickDel(charSelect.getSelectedItem().toString());
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
    public void loadChar() {
        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void delChar() {
        this.setVisible(false);
        new GuiStart().run();
    }

    @Override
    public void retreat() {
        this.setVisible(false);
        new GuiStart().run();
    }
}