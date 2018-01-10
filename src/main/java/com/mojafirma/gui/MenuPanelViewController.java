package com.mojafirma.gui;

import com.mojafirma.Application;
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
import javafx.scene.layout.*;
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
public class MenuPanelViewController implements BootInitializable {

    static Logger log = Logger.getLogger(MenuPanelViewController.class.getName());
    private ApplicationContext springContext;

    @FXML
    private ScrollPane content;
    @FXML
    private AnchorPane pane;

    @Autowired
    private ClientPanelViewController clientPanelViewController;
    @Autowired
    private AdminPanelViewController adminPanelViewController;

    @FXML
    private Button goToAdminPanelButton;

    @FXML
    private Button goToClientPanelButton;

    @FXML
    void adminPanelAction(ActionEvent event) {
        try {
            adminPanelViewController = springContext.getBean(AdminPanelViewController.class);
            Stage stage = springContext.getBean(Stage.class);

            Parent root = (Parent) adminPanelViewController.initView();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

            adminPanelViewController.initConstuct();
        } catch (Exception e) {
            Stage stage = springContext.getBean(Stage.class);
            log.info("AdminPanel initialize error");
        }
    }

    @FXML
    void clientPanelAction(ActionEvent event) {
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
            log.info("ClientPanel initialize error");
        }
    }

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MenuPanelView.fxml"));
        loader.setController(springContext.getBean(this.getClass()));

        log.info("MenePanelView initialize");
        return loader.load();
    }

    @Override
    public void initConstuct() {
        content.getScene().getWindow().setHeight(450);
        content.getScene().getWindow().setWidth(670);
        content.getScene().getWindow().centerOnScreen();
        BackgroundImage myBI= new BackgroundImage(new Image("images/background.png",0,0,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));
        content.getScene().getStylesheets().add("css/style.css");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        springContext = applicationContext;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
