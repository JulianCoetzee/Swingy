package jules.rpg.gui;

import jules.rpg.App;
import jules.rpg.control.ContinueControl;
import jules.rpg.view.ViewContinue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.*;

public class GuiContinue extends JPanel implements ViewContinue, ListSelectionListener {

    private static final long serialVersionUID = 1L;

    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private DefaultListModel charList;
    private JList charSelect;
    private JScrollPane charFiles;
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
        charList = new DefaultListModel<String>();
        charFolder = new File("../charfiles").listFiles();
        titlePanel = new JPanel();
        charPanel = new JPanel();
        loadLabel = new JLabel("LOAD CHARACTER\n");
        charLabel = new JLabel("SELECT\n");
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
                charList.addElement(charFolder[i].getName());
            i++;
        }
        charSelect = new JList<String>(charList);
        charSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        charSelect.setSelectedIndex(0);
        charSelect.addListSelectionListener(this);
        charSelect.setVisibleRowCount(5);
        charFiles = new JScrollPane(charSelect);
        charPanel.add(charFiles);
        charPanel.add(loadButt);
        charPanel.add(delButt);
        charPanel.setVisible(true);
        this.add(charPanel, gbc);
        
        this.add(backButt, gbc);
        this.setVisible(true);
        App.getFrame().setContentPane(this);
        App.getFrame().revalidate();
        App.showFrame();

        // charSelect.addListSelectionListener(new ListSelectionListener() {
        //     @Override
        //     public void valueChanged(ListSelectionEvent e) {
        //         if (e.getValueIsAdjusting() == false)
        //         {
        //             if (charSelect.getSelectedIndex() == -1)
        //             {
        //                 loadButt.setEnabled(false);
        //                 delButt.setEnabled(false);
        //             }
        //             else
        //             {
        //                 loadButt.setEnabled(true);
        //                 delButt.setEnabled(true);
        //             }
        //         }
        //     }
        // });

        loadButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickLoad(charSelect.getSelectedValue().toString());
            }
        });

        delButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickDel(charSelect.getSelectedValue().toString());
            }
        });

        backButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.onClickBack();
            }

        });
    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false)
        {
            if (charSelect.getSelectedIndex() == -1)
            {
                loadButt.setEnabled(false);
                delButt.setEnabled(false);
            }
            else
            {
                loadButt.setEnabled(true);
                delButt.setEnabled(true);
            }
        }
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