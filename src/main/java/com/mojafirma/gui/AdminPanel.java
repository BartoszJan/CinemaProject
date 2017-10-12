package com.mojafirma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {


    public AdminPanel() throws HeadlessException {
        iniAdminPanel();
    }

    private void iniAdminPanel() {

    setTitle("Panel Administratora");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700, 500);
    setLocation(100, 100);

    setVisible(true);

    GridLayout gridLayout = new GridLayout(1,2);
    JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
    add(panel);

    JButton goToAddMoviePanel = new JButton();
        goToAddMoviePanel.setText("Dodaj Film Do Bazy");
        goToAddMoviePanel.setBackground(Color.GRAY);
        goToAddMoviePanel.setForeground(Color.WHITE);
        goToAddMoviePanel.setFont(new Font("Consolas", Font.BOLD, 20));
    JButton goToAddShowingPanel = new JButton();
        goToAddShowingPanel.setText("Dodaj Seans Do Bazy");
        goToAddShowingPanel.setBackground(Color.WHITE);
        goToAddShowingPanel.setForeground(Color.GRAY);
        goToAddShowingPanel.setFont(new Font("Consolas", Font.BOLD, 20));
        panel.add(goToAddMoviePanel);
        panel.add(goToAddShowingPanel);

        goToAddMoviePanel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            AddMoviePanel addMoviePanel = new AddMoviePanel();
        }
    });

        goToAddShowingPanel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
           AddShowingPanel addShowingPanel = new AddShowingPanel();
        }
    });
}
}
