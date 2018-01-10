package com.mojafirma.gui.config;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceAware;

import java.io.IOException;

public interface BootInitializable extends Initializable, ApplicationContextAware, MessageSourceAware {

    public Node initView() throws IOException;

    public void initConstuct();
}
