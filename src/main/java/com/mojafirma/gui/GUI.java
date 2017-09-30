package com.mojafirma.gui;

import javax.swing.*;
import java.awt.*;


public class GUI extends AddMoviePanel{

    public GUI() throws HeadlessException {
        iniGUI();
    }

    private void iniGUI() {
        setTitle("HellowSwing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        setVisible(true);
    }
}
