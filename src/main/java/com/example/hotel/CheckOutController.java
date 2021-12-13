package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckOutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text checkOutMessage;

    @FXML
    private TextField roomNumber;

    @FXML
    private Button backButton;

    @FXML
    void checkOutButtonClicked(ActionEvent event) throws IOException {
        Gson json = new Gson();
        GreetClient t =new GreetClient();
        t.startConnection(DATA.ip, DATA.port);
        checkOutObj ro = new checkOutObj("check_out", roomNumber.getText());
        String response = json.toJson(ro);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
        if(!rr.getSuccess()){
            checkOutMessage.setText(rr.getMessage());
        }else{
            checkOutMessage.setText("Checked out Successfully");
        }
    }

    public void clearButtonClicked(ActionEvent event){
        roomNumber.setText("");
        checkOutMessage.setText("");
    }

    @FXML
    void initialize() {
        assert roomNumber != null : "fx:id=\"roomNumber\" was not injected: check your FXML file 'checkOut.fxml'.";
    }

    public void backButtonClicked(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}
