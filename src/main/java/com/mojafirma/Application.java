package com.mojafirma;

import com.mojafirma.gui.MenuPanelViewController;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class Application extends javafx.application.Application {

    static Logger log = Logger.getLogger(Application.class.getName());

    private ConfigurableApplicationContext springContext;
    private static String[] mainArgs;

    @Bean
    public Stage getStage() {
        Stage newStage = new Stage(StageStyle.DECORATED);
        newStage.setTitle("Cinema Service v2.0");
        return newStage;
    }

    public static void main(String[] args) {
        mainArgs = args;
        Application.launch(Application.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Task<Object> worker = new Task<Object>() {
            @Override
            protected Object call() throws Exception {
                log.info("Application running");
                springContext = SpringApplication.run(Application.class, mainArgs);
                return null;
            }
        };
        worker.run();

        worker.setOnSucceeded(event -> {
            try {
                MenuPanelViewController menuPanelViewController = springContext.getBean(MenuPanelViewController.class);
                Stage stage = springContext.getBean(Stage.class);

                Parent root = (Parent) menuPanelViewController.initView();
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();

                menuPanelViewController.initConstuct();
            } catch (Exception ex) {
                ex.printStackTrace();
                log.info("MenuPanel initialize error.");
            }
        });

        worker.setOnFailed(event -> {
            try {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                log.info("Loading Spring Failing, Application will shutdown now.");
                alert.setContentText("Loading Spring Failing, Application will shutdown now.");
                alert.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        log.info("Application shutdown.");
        Platform.exit();
        springContext.close();
    }
}