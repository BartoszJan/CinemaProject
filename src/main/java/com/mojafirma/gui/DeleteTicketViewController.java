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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeleteTicketViewController implements BootInitializable {

    static Logger log = Logger.getLogger(ClientPanelViewController.class.getName());
    private ApplicationContext springContext;

    @Autowired
    private MovieServiceImpl movieService = new MovieServiceImpl();
    @Autowired
    private ShowingServiceImpl showingService = new ShowingServiceImpl();
    @Autowired
    private TicketServiceImpl ticketService = new TicketServiceImpl();

    @FXML
    private Button approveButton;

    @FXML
    private ListView<Showing> showingListView;
    private ObservableList<Showing> showingObservableList;
    @FXML
    private ListView<Movie> movieListView;
    private ObservableList<Movie> movies;
    @FXML
    private ListView<String> clientListView;
    private ObservableList<String> clientsList;

    @FXML
    private TableView<Ticket> reservaionTable;
    private ObservableList<Ticket> ticketObservableList;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn showingColumn;
    @FXML
    private TableColumn seatColumn;

    @FXML
    private ComboBox<String> searchingChooser;
    private ObservableList<String> options;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/DeleteTicketView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("DeleteTicketView initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        Image addImage = new Image(getClass().getResource("/images/declineImage.png").toExternalForm(), 16, 16, true, true);
        approveButton.setGraphic(new ImageView(addImage));

        options = FXCollections.observableArrayList();
        options.addAll("Tytułów Filmów", "Daty Seansów", "Klientów");

        searchingChooser.setItems(options);

        idColumn.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("ticket_id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Ticket, String>("user_name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Ticket, String>("user_last_name"));
        showingColumn.setCellValueFactory(new PropertyValueFactory<Ticket, Showing>("showing"));
        showingColumn.setCellFactory(column -> {
            return new TableCell<Ticket, Showing>() {
                @Override
                protected void updateItem(Showing item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getMovie().getTitle() + " Data: " + item.getShowing_date_time() + " Sala: " +
                                item.getRoom_number());
                    }
                }
            };
        });
        seatColumn.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seat"));
    }

    @FXML
    void chooseSearchAction(ActionEvent event) {
        if (searchingChooser.getSelectionModel().getSelectedItem().equals("Tytułów Filmów")) {
            clientListView.setVisible(false);
            showingListView.setVisible(false);
            movieListView.setVisible(true);

            movies = FXCollections.observableArrayList(movieService.showMovieList());
            movieListView.setItems(movies);

            movieListView.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
                @Override
                public ListCell<Movie> call(ListView<Movie> p) {

                    final ListCell<Movie> cell = new ListCell<Movie>() {
                        @Override
                        protected void updateItem(Movie t, boolean bln) {
                            super.updateItem(t, bln);

                            if (t != null) {
                                setText(t.getTitle());
                            } else {
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            });
        }
        if (searchingChooser.getSelectionModel().getSelectedItem().equals("Daty Seansów")) {
            clientListView.setVisible(false);
            movieListView.setVisible(false);
            showingListView.setVisible(true);

            List<Showing> sortedShowings = showingService.getShowings().stream().
                    sorted(Comparator.comparing(Showing::getShowing_date_time)).collect(Collectors.toList());
            showingObservableList = FXCollections.observableArrayList(sortedShowings);
            showingListView.setItems(showingObservableList);

            showingListView.setCellFactory(new Callback<ListView<Showing>, ListCell<Showing>>() {
                @Override
                public ListCell<Showing> call(ListView<Showing> p) {

                    final ListCell<Showing> cell = new ListCell<Showing>() {
                        @Override
                        protected void updateItem(Showing t, boolean bln) {
                            super.updateItem(t, bln);

                            if (t != null) {
                                setText(t.getMovie().getTitle() + " Data i godzina : " + t.getShowing_date_time()
                                        + " Sala numer: " + t.getRoom_number());
                            } else {
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            });
        }
        if (searchingChooser.getSelectionModel().getSelectedItem().equals("Klientów")) {
            showingListView.setVisible(false);
            movieListView.setVisible(false);
            clientListView.setVisible(true);

            List<Ticket> tickets = ticketService.getTickets();
            Set<String> clientsSet = new HashSet<>();

            for (int i = 0; i < tickets.size(); i++) {
                clientsSet.add(tickets.get(i).getUser_name() + " " + tickets.get(i).getUser_last_name());
            }
            clientsList = FXCollections.observableArrayList(new ArrayList<String>(clientsSet));
            clientListView.setItems(clientsList);
        }
    }

    @FXML
    void movieListChooseAction(MouseEvent event) {
        Movie selectedMovie = movieListView.getSelectionModel().getSelectedItem();
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < selectedMovie.getShowings().size(); i++) {
            for (int j = 0; j < selectedMovie.getShowings().get(i).getTickets().size(); j++) {
                tickets.add(selectedMovie.getShowings().get(i).getTickets().get(j));
            }
        }
        ticketObservableList = FXCollections.observableList(tickets);
        reservaionTable.setItems(ticketObservableList);
    }

    @FXML
    void showingListChooseAction(MouseEvent event) {
        Showing selectedShowing = showingListView.getSelectionModel().getSelectedItem();
        ticketObservableList = FXCollections.observableList(selectedShowing.getTickets());
        reservaionTable.setItems(ticketObservableList);
    }

    @FXML
    void clientListChooseAction(MouseEvent event) {
        String selectedClient = clientListView.getSelectionModel().getSelectedItem();
        String[] clientName = selectedClient.split(" ");
        List<Ticket> clientTickets = new ArrayList<>();
        List<Ticket> allTickets = ticketService.getTickets();
        if (clientName.length == 2) {
            for (int i = 0; i < allTickets.size(); i++) {
                if (allTickets.get(i).getUser_name().equals(clientName[0]) && allTickets.get(i).getUser_last_name().equals(clientName[1])) {
                    clientTickets.add(allTickets.get(i));
                }
            }
        }
        ticketObservableList = FXCollections.observableList(clientTickets);
        reservaionTable.setItems(ticketObservableList);
    }

    @FXML
    void reservationDeleteAction(ActionEvent event) {
        Ticket selectedTicket = reservaionTable.getSelectionModel().getSelectedItem();
        if (selectedTicket != null) {
            ticketService.deleteTicket(selectedTicket);

            if (searchingChooser.getSelectionModel().getSelectedItem().equals("Tytułów Filmów")) {
                Movie selectedMovie = movieService.getMovie(movieListView.getSelectionModel().getSelectedItem().getMovie_id());
                List<Ticket> tickets = new ArrayList<>();
                for (int i = 0; i < selectedMovie.getShowings().size(); i++) {
                    for (int j = 0; j < selectedMovie.getShowings().get(i).getTickets().size(); j++) {
                        tickets.add(selectedMovie.getShowings().get(i).getTickets().get(j));
                    }
                }
                ticketObservableList = FXCollections.observableList(tickets);
                reservaionTable.setItems(ticketObservableList);
            }
            if (searchingChooser.getSelectionModel().getSelectedItem().equals("Daty Seansów")) {
                Showing selectedShowing = showingService.getShowing(showingListView.getSelectionModel().getSelectedItem().getShowing_id());
                ticketObservableList = FXCollections.observableList(selectedShowing.getTickets());
                reservaionTable.setItems(ticketObservableList);
            }
            if (searchingChooser.getSelectionModel().getSelectedItem().equals("Klientów")) {
                String selectedClient = clientListView.getSelectionModel().getSelectedItem();
                String[] clientName = selectedClient.split(" ");
                List<Ticket> clientTickets = new ArrayList<>();
                List<Ticket> allTickets = ticketService.getTickets();
                if (clientName.length == 2) {
                    for (int i = 0; i < allTickets.size(); i++) {
                        if (allTickets.get(i).getUser_name().equals(clientName[0]) && allTickets.get(i).getUser_last_name().equals(clientName[1])) {
                            clientTickets.add(allTickets.get(i));
                        }
                    }
                }
                ticketObservableList = FXCollections.observableList(clientTickets);
                reservaionTable.setItems(ticketObservableList);
            }
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
