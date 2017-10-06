package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.util.MovieComboBoxModel;
import com.mojafirma.util.ShowingListModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.util.List;


public class TicketReservationPanel extends JFrame {
    private JList showingsList;
    private JTextField textField2;
    private JButton bookTicketButton;
    private JTextField textField3;
    private JRadioButton a45RadioButton;
    private JRadioButton a35RadioButton;
    private JRadioButton a55RadioButton;
    private JRadioButton a36RadioButton;
    private JRadioButton a46RadioButton;
    private JRadioButton a56RadioButton;
    private JRadioButton a37RadioButton;
    private JRadioButton a47RadioButton;
    private JRadioButton a57RadioButton;
    private JRadioButton a38RadioButton;
    private JRadioButton a48RadioButton;
    private JRadioButton a58RadioButton;
    private JRadioButton a67RadioButton;
    private JRadioButton a68RadioButton;
    private JRadioButton a66RadioButton;
    private JRadioButton a65RadioButton;
    private JTextField textField1;
    private JComboBox movieChooserBox;
    private JTextField textField4;
    private JRadioButton a34RadioButton;
    private JRadioButton a43RadioButton;
    private JRadioButton a44RadioButton;
    private JRadioButton a54RadioButton;
    private JRadioButton a64RadioButton;
    private JRadioButton a63RadioButton;
    private JRadioButton a53RadioButton;
    private JRadioButton a33RadioButton;
    private JRadioButton a32RadioButton;
    private JRadioButton a42RadioButton;
    private JRadioButton a52RadioButton;
    private JRadioButton a62RadioButton;
    private JRadioButton a22RadioButton;
    private JRadioButton a23RadioButton;
    private JRadioButton a24RadioButton;
    private JRadioButton a25RadioButton;
    private JRadioButton a28RadioButton;
    private JRadioButton a27RadioButton;
    private JRadioButton a26RadioButton;
    private JRadioButton a21RadioButton;
    private JRadioButton a11RadioButton;
    private JRadioButton a31RadioButton;
    private JRadioButton a41RadioButton;
    private JRadioButton a51RadioButton;
    private JRadioButton a61RadioButton;
    private JRadioButton a12RadioButton;
    private JRadioButton a13RadioButton;
    private JRadioButton a14RadioButton;
    private JRadioButton a15RadioButton;
    private JRadioButton a16RadioButton;
    private JRadioButton a17RadioButton;
    private JRadioButton a18RadioButton;
    private JRadioButton a19RadioButton;
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public void setMovieList(List<Movie> movies) {
        movieChooserBox.setModel(new MovieComboBoxModel(movies));
    }

    public void setShowingsList(List<Showing> showings) {showingsList.setModel(new ShowingListModel(showings));}

    public void iniTicketReservationPanel() {

        setContentPane(mainPanel);
        pack();
        setTitle("Rezerwacja biletów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     movieChooserBox.setRenderer(new BasicComboBoxRenderer(){
        public Component getListCellRendererComponent(JList list, Object value, int index,              boolean isSelected, boolean cellHasFocus){
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null){
                Movie movie = (Movie) value;
                setText(movie.getTitle());
            }
            return this;
        }
    });

        setLocation(100, 100);
        setVisible(true);
    }
}
