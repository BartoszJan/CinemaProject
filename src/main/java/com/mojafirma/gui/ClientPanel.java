package com.mojafirma.gui;

import com.mojafirma.presenter.ShowingCheckoutPresenter;
import com.mojafirma.presenter.TicketReservationPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPanel extends JFrame{

    ShowingCheckoutPanel showingCheckoutPanel;
    ShowingCheckoutPresenter moviePresenter;
    TicketReservationPanel ticketReservationPanel;
    TicketReservationPresenter ticketReservationPresenter;

    public ClientPanel() throws HeadlessException {
        showingCheckoutPanel = new ShowingCheckoutPanel();
        moviePresenter = new ShowingCheckoutPresenter(showingCheckoutPanel);
        ticketReservationPanel = new TicketReservationPanel();
        ticketReservationPresenter = new TicketReservationPresenter(ticketReservationPanel);
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
                showingCheckoutPanel.iniShowingCheckoutPanel();
                moviePresenter.showMovie(1);
                moviePresenter.showMovieList();
                showingCheckoutPanel.setSize(700, 500);
                showingCheckoutPanel.setLocation(100, 100);
            }
        });

        goToTicketReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ticketReservationPanel.iniTicketReservationPanel();
                ticketReservationPresenter.showMovieList();
            }
        });
    }
}
