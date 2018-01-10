package com.mojafirma.gui;

import com.mojafirma.gui.config.BootInitializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AdminPanelViewController implements BootInitializable {

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    private AddMovieViewController addMovieViewController;
    @Autowired
    private AddShowingViewController addShowingViewController;
    @Autowired
    private DeleteMovieViewController deleteMovieViewController;
    @Autowired
    private DeleteShowingViewController deleteShowingViewController;
    @Autowired
    private DeleteTicketViewController deleteTicketViewController;
    @Autowired
    private MenuPanelViewController menuPanelViewController;

    @FXML
    private Button addMovieButton;
    @FXML
    private Button addShowingButton;
    @FXML
    private Button deleteMovieButtonn;
    @FXML
    private Button deleteShowingButton;
    @FXML
    private Button deleteReservationButton;
    @FXML
    private Button backButton;

    @FXML
    private ScrollPane contentChildren;
    @FXML
    private ScrollPane contentParent;


    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/AdminPanelView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("AdministrationPanel initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        contentParent.getScene().getWindow().setHeight(470);
        contentParent.getScene().getWindow().setWidth(690);
        contentParent.getScene().getWindow().centerOnScreen();
        contentParent.getScene().getWindow().getScene().getStylesheets().addAll("/css/style.css");

        Image backArrowImage = new Image(getClass().getResource("/images/backArrow.jpg").toExternalForm(), 15, 15, true, true);
        backButton.setGraphic(new ImageView(backArrowImage));
        Image deleteImage = new Image(getClass().getResource("/images/deleteImage.png").toExternalForm(), 16, 16, true, true);
        deleteMovieButtonn.setGraphic(new ImageView(deleteImage));
        deleteReservationButton.setGraphic(new ImageView(deleteImage));
        deleteShowingButton.setGraphic(new ImageView(deleteImage));
        Image addImage = new Image(getClass().getResource("/images/addImage.png").toExternalForm(), 16, 16, true, true);
        addShowingButton.setGraphic(new ImageView(addImage));
        addMovieButton.setGraphic(new ImageView(addImage));

    }

    @FXML
    void addMovie(ActionEvent event) {
        try {
            Node node = addMovieViewController.initView();
            contentChildren.setContent(node);
            addMovieViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @FXML
    void addShowing(ActionEvent event) {
        try {
            Node node = addShowingViewController.initView();
            contentChildren.setContent(node);
            addShowingViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @FXML
    void deleteMovie(ActionEvent event) {
        try {
            Node node = deleteMovieViewController.initView();
            contentChildren.setContent(node);
            deleteMovieViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @FXML
    void deleteReservation(ActionEvent event) {
        try {
            Node node = deleteTicketViewController.initView();
            contentChildren.setContent(node);
            deleteTicketViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
        }
    }

    @FXML
    void deleteShowing(ActionEvent event) {
        try {
            Node node = deleteShowingViewController.initView();
            contentChildren.setContent(node);
            deleteShowingViewController.initConstuct();
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
