package com.mojafirma.gui;

import com.mojafirma.gui.config.BootInitializable;
import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.service.MovieServiceImpl;
import com.mojafirma.service.ShowingServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Component
public class AddShowingViewController implements BootInitializable{

    @Autowired
    private MovieServiceImpl movieService = new MovieServiceImpl();
    @Autowired
    private ShowingServiceImpl showingService = new ShowingServiceImpl();

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @FXML
    private TextField dateTimeInput;

    @FXML
    private TextField roomNumberField;

    @FXML
    private Button approveButton;

    @FXML
    private ChoiceBox<Movie> movieChooser;
    private ObservableList<Movie> movies;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/AddShowingView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("AddShowingView initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        Image addImage = new Image(getClass().getResource("/images/acceptImage.png").toExternalForm(), 16, 16, true, true);
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
    void addShowingAction(ActionEvent event) {
        LocalDateTime dateTimeShowing = LocalDateTime.parse(dateTimeInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int roomNumber = Integer.parseInt(roomNumberField.getText());
        Movie movie = movieChooser.getSelectionModel().getSelectedItem();

        Showing showing = new Showing();
        showing.setMovie(movie);
        showing.setShowing_date_time(dateTimeShowing);
        showing.setRoom_number(roomNumber);
        showingService.addShowing(showing);
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
