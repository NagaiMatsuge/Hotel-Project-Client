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

public class roomsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<RoomsList, String> capacityCol = new TableColumn<RoomsList, String>("Room Capacity");

    @FXML
    private TableColumn<RoomsList, String> checkInCol = new TableColumn<RoomsList, String>("Check-In date");

    @FXML
    private TableColumn<RoomsList, String> checkOutCol = new TableColumn<RoomsList, String>("Check-Out date");

    @FXML
    private TableColumn<RoomsList, Integer> idCol = new TableColumn<RoomsList, Integer>("ID");

    @FXML
    private TableColumn<RoomsList, Integer> isAvailableCol = new TableColumn<RoomsList, Integer>("is Available?");

    @FXML
    private TableView<RoomsList> roomsTable = new TableView<RoomsList>();

    @FXML
    private TableColumn<RoomsList, String> typeCol = new TableColumn<RoomsList, String>("Room Type");

    @FXML
    private Button backButton;

    @FXML
    void initialize() throws IOException {
        assert capacityCol != null : "fx:id=\"capacityCol\" was not injected: check your FXML file 'rooms.fxml'.";
        assert checkInCol != null : "fx:id=\"checkInCol\" was not injected: check your FXML file 'rooms.fxml'.";
        assert checkOutCol != null : "fx:id=\"checkOutCol\" was not injected: check your FXML file 'rooms.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'rooms.fxml'.";
        assert isAvailableCol != null : "fx:id=\"isAvailableCol\" was not injected: check your FXML file 'rooms.fxml'.";
        assert roomsTable != null : "fx:id=\"roomsTable\" was not injected: check your FXML file 'rooms.fxml'.";
        assert typeCol != null : "fx:id=\"typeCol\" was not injected: check your FXML file 'rooms.fxml'.";
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        isAvailableCol.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
        Gson json = new Gson();
        GreetClient t =new GreetClient();
        t.startConnection(DATA.ip, DATA.port);
        roomsObj ro = new roomsObj("get_rooms");
        String response = json.toJson(ro);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
//        RoomsList room1 = new RoomsList(1, "1", "1", "1", "1", 1);
        ObservableList<RoomsList> list = FXCollections.observableArrayList();
        for(int i = 0; i < rr.getData().length; i++){
            list.add(new RoomsList(rr.getData()[i][0], rr.getData()[i][2], rr.getData()[i][3], rr.getData()[i][4], rr.getData()[i][5], rr.getData()[i][1]));
        }
        roomsTable.setItems(list);
        roomsTable.getColumns().addAll(idCol, typeCol, capacityCol, checkInCol, checkOutCol, isAvailableCol);
    }

    public void backButtonClicked(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}
