package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class viewUsersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableView<usersList> usersTable;

    @FXML
    private TableColumn<usersList, String> password;

    @FXML
    private TableColumn<usersList, String> rank;

    @FXML
    private TableColumn<usersList, String> username;

    @FXML
    void backButtonClicked(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() throws IOException {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'viewAllUsers.fxml'.";
        assert usersTable != null : "fx:id=\"usersTable\" was not injected: check your FXML file 'viewAllUsers.fxml'.";
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        rank.setCellValueFactory(new PropertyValueFactory<>("rank"));

        Gson json = new Gson();
        GreetClient t =new GreetClient();
        t.startConnection(DATA.ip, DATA.port);
        usersObj ro = new usersObj("get_users");
        String response = json.toJson(ro);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
        ObservableList<usersList> list = FXCollections.observableArrayList();
        for(int i = 0; i < rr.getData().length; i++){
            list.add(new usersList(rr.getData()[i][1], rr.getData()[i][2], rr.getData()[i][3]));
        }
        usersTable.setItems(list);
        usersTable.getColumns().addAll(username, password, rank);
    }

}
