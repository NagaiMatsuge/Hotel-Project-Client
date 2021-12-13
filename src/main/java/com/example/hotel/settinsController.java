package com.example.hotel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class settinsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    public void backButtonClicked(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'settings.fxml'.";
    }

    public void addUserButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("registration.fxml"));
            Stage registration = new Stage();
            registration.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 520, 450);
            registration.setTitle("Hotel Management System");
            registration.setScene(scene);
            registration.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void deleteUserButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("deleteUser.fxml"));
            Stage deleteUser = new Stage();
            deleteUser.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 360, 373);
            deleteUser.setTitle("Hotel Management System");
            deleteUser.setScene(scene);
            deleteUser.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void viewUsersButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("viewAllUsers.fxml"));
            Stage viewUsers = new Stage();
            viewUsers.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 360, 373);
            viewUsers.setTitle("Hotel Management System");
            viewUsers.setScene(scene);
            viewUsers.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
