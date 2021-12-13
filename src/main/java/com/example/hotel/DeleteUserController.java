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

public class DeleteUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text messageField;

    @FXML
    private Button backButton;


    @FXML
    private TextField idField;

    @FXML
    void backButtonClicked(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deletelUserButtonCliekd(ActionEvent event) throws IOException {
        Gson json = new Gson();
        GreetClient t =new GreetClient();
        t.startConnection(DATA.ip, DATA.port);
        deleteUserObj duo = new deleteUserObj(idField.getText(), "delete_user");
        String response = json.toJson(duo);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
        if(rr.getSuccess()){
            messageField.setText("Deleted Successfully");
        }else{
            messageField.setText(rr.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert messageField != null : "fx:id=\"messageField\" was not injected: check your FXML file 'deleteUser.fxml'.";
    }

}
