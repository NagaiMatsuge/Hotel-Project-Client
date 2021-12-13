package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GuestsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<GuestList, String> address = new TableColumn<GuestList, String>("Address");

    @FXML
    private TableColumn<GuestList, String> city = new TableColumn<GuestList, String>("City");

    @FXML
    private TableColumn<GuestList, String> email = new TableColumn<GuestList, String>("Email");

    @FXML
    private TableView<GuestList> guestsTable = new TableView<GuestList>();

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<GuestList, String> name = new TableColumn<GuestList, String>("Name");

    @FXML
    private TableColumn<GuestList, String> nationality = new TableColumn<GuestList, String>("Nationality");

    @FXML
    private TableColumn<GuestList, String> passport = new TableColumn<GuestList, String>("Passport");

    @FXML
    private TableColumn<GuestList, String> phone = new TableColumn<GuestList, String>("Phone");

    @FXML
    private TableColumn<GuestList, String> roomId = new TableColumn<GuestList, String>("roomId");

    @FXML
    void initialize() throws IOException {
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'guests.fxml'.";
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'guests.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'guests.fxml'.";
        assert guestsTable != null : "fx:id=\"guestsTable\" was not injected: check your FXML file 'guests.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'guests.fxml'.";
        assert nationality != null : "fx:id=\"nationality\" was not injected: check your FXML file 'guests.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'guests.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'guests.fxml'.";
        assert roomId != null : "fx:id=\"roomId\" was not injected: check your FXML file 'guests.fxml'.";
        roomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        Gson json = new Gson();
        GreetClient t =new GreetClient();
        t.startConnection(DATA.ip, DATA.port);
        roomsObj ro = new roomsObj("guest_list");
        String response = json.toJson(ro);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
        ObservableList<GuestList> list = FXCollections.observableArrayList();
        for(int i = 0; i < rr.getData().length; i++){
            list.add(new GuestList(rr.getData()[i][0], rr.getData()[i][6], rr.getData()[i][8], rr.getData()[i][9], rr.getData()[i][10], rr.getData()[i][11], rr.getData()[i][12], rr.getData()[i][7]));
        }
        guestsTable.setItems(list);
        guestsTable.getColumns().addAll(roomId, name, email, address, city, nationality, passport, phone);
    }

    public void roomsButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rooms.fxml"));
            Stage rooms =new Stage();
            rooms.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 694, 470);
            rooms.setTitle("Hotel Management System");
            rooms.setScene(scene);
            rooms.show();
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backButtonClicked(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}
