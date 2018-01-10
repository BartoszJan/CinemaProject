package com.mojafirma.gui;

import com.mojafirma.Application;
import com.mojafirma.gui.config.BootInitializable;
import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.service.MovieServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ClientPanelViewController implements BootInitializable {

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    private ReservationPanelViewController reservationPanelViewController;

    @Autowired
    private MenuPanelViewController menuPanelViewController;

    @Autowired
    private MovieServiceImpl movieService = new MovieServiceImpl();

    @FXML
    private ScrollPane content;
    @FXML
    private AnchorPane pane;

    @FXML
    private ListView<Movie> movieChooserList;
    private ObservableList<Movie> movies;

    @FXML
    private TextArea showingsTextField;

    @FXML
    private TextField durationFiled;

    @FXML
    private TextField dateProductionField;

    @FXML
    private TextField directorField;

    @FXML
    private Button reservationPanelButton;

    @FXML
    private Button backButton;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ClientPanelView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("ClientPanel initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        content.getScene().getWindow().setHeight(450);
        content.getScene().getWindow().setWidth(670);
        content.getScene().getWindow().centerOnScreen();
        content.getScene().getWindow().getScene().getStylesheets().addAll("/css/style.css");
        BackgroundImage myBI= new BackgroundImage(new Image("images/background.png",0,0,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));
        Image backImage = new Image(getClass().getResource("/images/backArrow.jpg").toExternalForm(), 15,15, true, true);
        backButton.setGraphic(new ImageView(backImage));
        Image forwardImage = new Image(getClass().getResource("/images/forwardImage.png").toExternalForm(), 30,30, true, true);
        reservationPanelButton.setGraphic(new ImageView(forwardImage));

        movies = FXCollections.observableArrayList(movieService.showMovieList());
        movieChooserList.setItems(movies);

        movieChooserList.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>(){

            @Override
            public ListCell<Movie> call(ListView<Movie> p) {

                ListCell<Movie> cell = new ListCell<Movie>(){

                    @Override
                    protected void updateItem(Movie t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getTitle());
                        }
                    }
                };
                return cell;
            }
        });
    }

    @FXML
    void movieChoosed(MouseEvent event) {
        showingsTextField.setText("");
        Movie choosedMovie = movieChooserList.getSelectionModel().getSelectedItem();
        dateProductionField.setText(choosedMovie.getYear().toString());
        directorField.setText(choosedMovie.getDirector());
        durationFiled.setText(String.valueOf(choosedMovie.getDuration()));
        List<Showing> showings = choosedMovie.getShowings();

        for (int i = 0; i < showings.size(); i++) {
            showingsTextField.setText(showingsTextField.getText() + (i + 1) + ") Data i godzina: " +
                    showings.get(i).getShowing_date_time() + " Sala numer: " + showings.get(i).getRoom_number() + "\n");
        }
    }

    @FXML
    void goToReservationPanel(ActionEvent event) {
        try {
            reservationPanelViewController = springContext.getBean(ReservationPanelViewController.class);
            Stage stage = springContext.getBean(Stage.class);

            Parent root = (Parent) reservationPanelViewController.initView();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

            reservationPanelViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            menuPanelViewController = springContext.getBean(MenuPanelViewController.class);
            Stage stage = springContext.getBean(Stage.class);

            Parent root = (Parent) menuPanelViewController.initView();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

            menuPanelViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        springContext = applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
