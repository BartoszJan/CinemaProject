package com.mojafirma.gui;

import com.mojafirma.gui.config.BootInitializable;
import com.mojafirma.model.Movie;
import com.mojafirma.service.MovieServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
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
public class DeleteMovieViewController implements BootInitializable {

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    private MovieServiceImpl movieService = new MovieServiceImpl();

    @FXML
    private ComboBox<Movie> movieChooser;
    private ObservableList<Movie> movies;

    @FXML
    private TextField durationField;

    @FXML
    private TextField directorField;

    @FXML
    private TextField yearProductionField;

    @FXML
    private Button approveButton;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/DeleteMovieView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("DeleteMovieView initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        Image addImage = new Image(getClass().getResource("/images/declineImage.png").toExternalForm(), 16, 16, true, true);
        approveButton.setGraphic(new ImageView(addImage));

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
    }

    @FXML
    void chooseMovieAction(ActionEvent event) {
        Movie selectedMovie = movieChooser.getSelectionModel().getSelectedItem();

        if (selectedMovie != null) {
            directorField.setText(selectedMovie.getDirector());
            durationField.setText(String.valueOf(selectedMovie.getDuration()));
            yearProductionField.setText(selectedMovie.getYear().toString());
        }
    }

    @FXML
    void deleteMovieAction(ActionEvent event) {
        movieService.deleteMovie(movieChooser.getSelectionModel().getSelectedItem());
        durationField.setText("");
        yearProductionField.setText("");
        directorField.setText("");
        movieChooser.getSelectionModel().clearSelection();

        movies = FXCollections.observableArrayList(movieService.showMovieList());
        movieChooser.setItems(movies);
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
