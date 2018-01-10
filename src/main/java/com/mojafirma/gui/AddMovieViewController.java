package com.mojafirma.gui;

import com.mojafirma.gui.config.BootInitializable;
import com.mojafirma.model.Movie;
import com.mojafirma.service.MovieServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Component
public class AddMovieViewController implements BootInitializable{

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    MovieServiceImpl movieService = new MovieServiceImpl();

    @FXML
    private TextField titleInput;

    @FXML
    private TextField durationInput;

    @FXML
    private TextField directorInput;

    @FXML
    private TextField dateProductionInput;

    @FXML
    private Button approveButton;

    @FXML
    void approveAction(ActionEvent event) throws IOException {

        LocalDate productionDate = LocalDate.parse(dateProductionInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int duration = Integer.parseInt(durationInput.getText());

        Movie movie = new Movie();
        movie.setTitle(titleInput.getText());
        movie.setYear(productionDate);
        movie.setDuration(duration);
        movie.setDirector(directorInput.getText());
        movieService.addMovie(movie);
    }

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/AddMovieView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("AddMovieView initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        Image addImage = new Image(getClass().getResource("/images/acceptImage.png").toExternalForm(), 16, 16, true, true);
        approveButton.setGraphic(new ImageView(addImage));
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
