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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.ResourceBundle;

@Component
public class DeleteShowingViewController implements BootInitializable {

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    private MovieServiceImpl movieService = new MovieServiceImpl();
    @Autowired
    private ShowingServiceImpl showingService = new ShowingServiceImpl();

    @FXML
    private ListView<Showing> showingsListView;
    private ObservableList<Showing> showings;

    @FXML
    private ComboBox<Movie> movieChooser;
    private ObservableList<Movie> movies;

    @FXML
    private Button deleteButton;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/DeleteShowingView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("DeleteShowingView initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        Image addImage = new Image(getClass().getResource("/images/declineImage.png").toExternalForm(), 16, 16, true, true);
        deleteButton.setGraphic(new ImageView(addImage));

        movies = FXCollections.observableArrayList(movieService.showMovieList());
        movieChooser.setItems(movies);

        movieChooser.setConverter(new StringConverter<Movie>() {
            @Override
            public String toString(Movie movie) {
                if (movie == null) {
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
    void movieChooseAction(ActionEvent event) {
        Movie selectedMovie = movieChooser.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            showings = FXCollections.observableArrayList(selectedMovie.getShowings());
            showingsListView.setItems(showings);

            showingsListView.setCellFactory(new Callback<ListView<Showing>, ListCell<Showing>>() {
                @Override
                public ListCell<Showing> call(ListView<Showing> p) {

                    final ListCell<Showing> cell = new ListCell<Showing>() {
                        @Override
                        protected void updateItem(Showing t, boolean bln) {
                            super.updateItem(t, bln);

                            if (t != null) {
                                setText("Data i godzina : " + t.getShowing_date_time() + " Sala numer: " + t.getRoom_number());
                            } else {
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            });
        }
    }

    @FXML
    void deleteShowingAction(ActionEvent event) {
        Showing selectedShowing = showingsListView.getSelectionModel().getSelectedItem();
        showingService.deleteShowing(selectedShowing);
        showingsListView.getSelectionModel().clearSelection();
        movieChooser.getSelectionModel().clearSelection();

        showingsListView.setItems(null);
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
