package com.mojafirma.gui;

import com.mojafirma.gui.config.BootInitializable;
import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.service.MovieServiceImpl;
import com.mojafirma.service.ShowingServiceImpl;
import com.mojafirma.service.TicketServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ReservationPanelViewController implements BootInitializable {

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    ClientPanelViewController clientPanelViewController;

    @Autowired
    private MovieServiceImpl movieService = new MovieServiceImpl();
    @Autowired
    private TicketServiceImpl ticketService = new TicketServiceImpl();
    @Autowired
    ShowingServiceImpl showingService = new ShowingServiceImpl();

    @FXML
    private ScrollPane content;

    @FXML
    private AnchorPane buttonsPane;

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private ComboBox<Movie> movieChooser;
    private ObservableList<Movie> movies;

    @FXML
    private ListView<Showing> showingChooseList;
    private ObservableList<Showing> showings;

    @FXML
    private Button backButton;

    @FXML
    private RadioButton b101;
    @FXML
    private RadioButton b102;
    @FXML
    private RadioButton b103;
    @FXML
    private RadioButton b104;
    @FXML
    private RadioButton b105;
    @FXML
    private RadioButton b109;
    @FXML
    private RadioButton b111;
    @FXML
    private RadioButton b108;
    @FXML
    private RadioButton b107;
    @FXML
    private RadioButton b106;
    @FXML
    private RadioButton b110;
    @FXML
    private RadioButton b201;
    @FXML
    private RadioButton b212;
    @FXML
    private RadioButton b213;
    @FXML
    private RadioButton b112;
    @FXML
    private RadioButton b113;
    @FXML
    private RadioButton b211;
    @FXML
    private RadioButton b210;
    @FXML
    private RadioButton b209;
    @FXML
    private RadioButton b208;
    @FXML
    private RadioButton b207;
    @FXML
    private RadioButton b206;
    @FXML
    private RadioButton b205;
    @FXML
    private RadioButton b204;
    @FXML
    private RadioButton b203;
    @FXML
    private RadioButton b202;
    @FXML
    private RadioButton b301;
    @FXML
    private RadioButton b302;
    @FXML
    private RadioButton b303;
    @FXML
    private RadioButton b304;
    @FXML
    private RadioButton b305;
    @FXML
    private RadioButton b309;
    @FXML
    private RadioButton b311;
    @FXML
    private RadioButton b308;
    @FXML
    private RadioButton b307;
    @FXML
    private RadioButton b306;
    @FXML
    private RadioButton b310;
    @FXML
    private RadioButton b401;
    @FXML
    private RadioButton b412;
    @FXML
    private RadioButton b413;
    @FXML
    private RadioButton b312;
    @FXML
    private RadioButton b313;
    @FXML
    private RadioButton b411;
    @FXML
    private RadioButton b410;
    @FXML
    private RadioButton b409;
    @FXML
    private RadioButton b408;
    @FXML
    private RadioButton b407;
    @FXML
    private RadioButton b406;
    @FXML
    private RadioButton b405;
    @FXML
    private RadioButton b404;
    @FXML
    private RadioButton b403;
    @FXML
    private RadioButton b402;
    @FXML
    private RadioButton b501;
    @FXML
    private RadioButton b502;
    @FXML
    private RadioButton b503;
    @FXML
    private RadioButton b504;
    @FXML
    private RadioButton b505;
    @FXML
    private RadioButton b509;
    @FXML
    private RadioButton b511;
    @FXML
    private RadioButton b508;
    @FXML
    private RadioButton b507;
    @FXML
    private RadioButton b506;
    @FXML
    private RadioButton b510;
    @FXML
    private RadioButton b601;
    @FXML
    private RadioButton b612;
    @FXML
    private RadioButton b613;
    @FXML
    private RadioButton b512;
    @FXML
    private RadioButton b513;
    @FXML
    private RadioButton b611;
    @FXML
    private RadioButton b610;
    @FXML
    private RadioButton b609;
    @FXML
    private RadioButton b608;
    @FXML
    private RadioButton b607;
    @FXML
    private RadioButton b606;
    @FXML
    private RadioButton b605;
    @FXML
    private RadioButton b604;
    @FXML
    private RadioButton b603;
    @FXML
    private RadioButton b602;
    @FXML
    private RadioButton b701;
    @FXML
    private RadioButton b712;
    @FXML
    private RadioButton b713;
    @FXML
    private RadioButton b711;
    @FXML
    private RadioButton b710;
    @FXML
    private RadioButton b709;
    @FXML
    private RadioButton b708;
    @FXML
    private RadioButton b707;
    @FXML
    private RadioButton b706;
    @FXML
    private RadioButton b705;
    @FXML
    private RadioButton b704;
    @FXML
    private RadioButton b703;
    @FXML
    private RadioButton b702;
    @FXML
    private RadioButton b801;
    @FXML
    private RadioButton b812;
    @FXML
    private RadioButton b813;
    @FXML
    private RadioButton b811;
    @FXML
    private RadioButton b810;
    @FXML
    private RadioButton b809;
    @FXML
    private RadioButton b808;
    @FXML
    private RadioButton b807;
    @FXML
    private RadioButton b806;
    @FXML
    private RadioButton b805;
    @FXML
    private RadioButton b804;
    @FXML
    private RadioButton b803;
    @FXML
    private RadioButton b802;
    List<RadioButton> allRadioButtons = new ArrayList<>();
    @FXML
    private Button reserveButton;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ReservationPanelView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("ReservaionPanel initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        content.getScene().getWindow().setHeight(450);
        content.getScene().getWindow().setWidth(1040);
        content.getScene().getWindow().centerOnScreen();
        content.getScene().getWindow().getScene().getStylesheets().addAll("/css/style.css");
        BackgroundImage myBI= new BackgroundImage(new Image("images/background.png",0,0,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        buttonsPane.setBackground(new Background(myBI));

        Image image = new Image(getClass().getResource("/images/backArrow.jpg").toExternalForm(), 15,15, true, true);
        backButton.setGraphic(new ImageView(image));
        Image reservationImage = new Image(getClass().getResource("/images/reservationImage.png").toExternalForm(), 30,30, true, true);
        reserveButton.setGraphic(new ImageView(reservationImage));

        movies = FXCollections.observableArrayList(movieService.showMovieList());
        movieChooser.setItems(movies);
        movieChooser.setConverter(new StringConverter<Movie>() {
            @Override
            public String toString(Movie movie) {
                if (movie== null){
                    return null;
                } else {
                    return movie.getTitle();
                }
            }

            @Override
            public Movie fromString(String id) {
                return null;
            }
        });

        for (int i = 0; i < buttonsPane.getChildren().size(); i++) {
            if (buttonsPane.getChildren().get(i).getClass().equals(RadioButton.class)) {
                allRadioButtons.add((RadioButton) buttonsPane.getChildren().get(i));
            }
        }
        for (int i = 0; i < allRadioButtons.size(); i++) {
            allRadioButtons.get(i).setStyle("-fx-background-color: #006400;");
            allRadioButtons.get(i).setDisable(true);
        }
    }

    @FXML
    void movieChooseAction(ActionEvent event) {
        Movie choosedMovie = movieChooser.getSelectionModel().getSelectedItem();
        showings = FXCollections.observableArrayList(choosedMovie.getShowings());
        showingChooseList.setItems(showings);

        showingChooseList.setCellFactory(new Callback<ListView<Showing>, ListCell<Showing>>() {
            @Override
            public ListCell<Showing> call(ListView<Showing> p) {

                ListCell<Showing> cell = new ListCell<Showing>() {
                    @Override
                    protected void updateItem(Showing t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText("Data i godzina: " + t.getShowing_date_time() + " Sala numer: " + t.getRoom_number());
                        }
                    }
                };
                return cell;
            }
        });
        for (int i = 0; i < allRadioButtons.size(); i++) {
            allRadioButtons.get(i).setStyle("-fx-background-color: #006400;");
            allRadioButtons.get(i).setDisable(true);
        }
    }

    @FXML
    void setShowingAction(MouseEvent event) {
        Showing selecedShowing =  showingService.getShowing(showingChooseList.getSelectionModel().getSelectedItem().getShowing_id());

        for (int i = 0; i < allRadioButtons.size(); i++) {
            allRadioButtons.get(i).setStyle("-fx-background-color: #006400;");
            allRadioButtons.get(i).setDisable(false);
        }
        for (int i = 0; i < selecedShowing.getTickets().size(); i++) {
            int seatNumber = selecedShowing.getTickets().get(i).getSeat();
            for (int j = 0; j < allRadioButtons.size(); j++) {
                if (allRadioButtons.get(j).getText().contains(String.valueOf(seatNumber))) {
                    allRadioButtons.get(j).setStyle("-fx-background-color: #FF0000;");
                    allRadioButtons.get(j).setDisable(true);
                }
            }
        }
    }

    @FXML
    void reserveAction(ActionEvent event) {
        Ticket addingTicket = new Ticket();
        addingTicket.setUser_name(nameField.getText());
        addingTicket.setUser_last_name(lastNameField.getText());
        addingTicket.setShowing(showingChooseList.getSelectionModel().getSelectedItem());
        int choosedSeatNumber = 0;
        for (int i = 0; i < allRadioButtons.size(); i++) {
            if (allRadioButtons.get(i).isSelected()) {
                choosedSeatNumber = Integer.parseInt(allRadioButtons.get(i).getText());
                allRadioButtons.get(i).setStyle("-fx-background-color: #FF0000;");
                allRadioButtons.get(i).setDisable(true);
                allRadioButtons.get(i).setSelected(false);
                break;
            }
        }
        addingTicket.setSeat(choosedSeatNumber);

        ticketService.addTicket(addingTicket);
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            clientPanelViewController = springContext.getBean(ClientPanelViewController.class);
            Stage stage = springContext.getBean(Stage.class);

            Parent root = (Parent) clientPanelViewController.initView();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

            clientPanelViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        springContext = applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
