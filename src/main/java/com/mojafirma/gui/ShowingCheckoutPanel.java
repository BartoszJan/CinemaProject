package com.mojafirma.gui;

import com.mojafirma.model.Movie;

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

    List<Movie> movieList = new ArrayList<>();


    public ShowingCheckoutPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        setSize(500, 500);
        setVisible(true);
    }
}
