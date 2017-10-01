package com.mojafirma.gui;

import com.mojafirma.model.DataPresenter;
import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class ShowingCheckoutPanel extends JFrame {
    private JPanel panel1;
    private JList movieJList;
    private JTextArea movieDescriptionTextArea;
    private JTextArea showingsTextArea;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField1;

    DataPresenter dataPresenter = new DataPresenter();

    public ShowingCheckoutPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        movieJList.setModel(new ListModel() {

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public Object getElementAt(int index) {
                return 10;
            }

            @Override
            public void addListDataListener(ListDataListener l) {

            }

            @Override
            public void removeListDataListener(ListDataListener l) {

            }
        });

        setSize(500, 500);
        setVisible(true);
    }
}
