package com.mojafirma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by RENT on 2017-10-01.
 */
public class ClientPanel extends JFrame{

    public ClientPanel() throws HeadlessException {
        iniClientPanel();
    }

    private void iniClientPanel() {
        setTitle("Serwis Obsługi Kina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocation(100, 100);

        setVisible(true);

        GridLayout gridLayout = new GridLayout(1,2);
        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
        add(panel);

        JButton goToShowingCheckout = new JButton();
        goToShowingCheckout.setText("Sprawdź Seanse");
        goToShowingCheckout.setBackground(Color.GRAY);
        goToShowingCheckout.setForeground(Color.WHITE);
        goToShowingCheckout.setFont(new Font("Consolas", Font.BOLD, 20));
        JButton goToTicketReservation = new JButton();
        goToTicketReservation.setText("Rezerwacja biletów");
        goToTicketReservation.setBackground(Color.WHITE);
        goToTicketReservation.setForeground(Color.GRAY);
        goToTicketReservation.setFont(new Font("Consolas", Font.BOLD, 20));
        panel.add(goToShowingCheckout);
        panel.add(goToTicketReservation);

        goToShowingCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ShowingCheckoutPanel showingCheckoutPanel = new ShowingCheckoutPanel();
            }
        });

        goToTicketReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }
}
