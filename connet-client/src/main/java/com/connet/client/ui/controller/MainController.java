package com.connet.client.ui.controller;

import com.auth0.exception.Auth0Exception;
import com.connet.client.service.AuthService;
import com.connet.client.service.NetworkService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;


@Component
public class MainController {

    private NetworkService networkService;
    private AuthService authService;

    @FXML
    public Label response;
    @FXML
    public Button login;
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;


    public MainController(AuthService authService, NetworkService networkService) {
        this.authService = authService;
        this.networkService = networkService;
    }

    @FXML
    public void initialize() {
        this.login.setOnAction(actionEvent -> {
            try {
                response.setText("");
                authService.retrieveToken(username.getText(), password.getText());
                response.setText(networkService.publishIp().getResponse());
            } catch (Auth0Exception e) {
                response.setText(e.getMessage());
            }
        });
    }
}