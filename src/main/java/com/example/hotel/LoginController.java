package com.example.hotel;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


public class LoginController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;


    @FXML
    Button cancelButton;

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label loginMsgLabel;

    public void loginButtonOnAction(ActionEvent event) throws IOException {


        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            System.out.println(DATA.rank);

            // if(DATA.rank=="admin")
            loginAdmin();
            System.out.println(DATA.rank);
        } else {
            loginMsgLabel.setText("Invalid input!");
        }
    }

    public void validateLogin() {
    }

    public void signUpButtonOnAction(ActionEvent event) {
        signUp();

    }

    public void signUp() {
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

    public void loginAdmin() throws IOException {
        LoginObj log = new LoginObj();
        log.setUsername(usernameTextField.getText());
        log.setPassword(enterPasswordField.getText());
        Gson json = new Gson();
        GreetClient t = new GreetClient();
        String response = json.toJson(log);
        t.startConnection(DATA.ip, DATA.port);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
        if (!rr.getSuccess()) {
            loginMsgLabel.setText(rr.getMessage());
        } else {
            DATA.username = rr.getData()[0][1];
            DATA.rank = rr.getData()[0][3];
            if (Objects.equals(DATA.rank, "admin")) {

                try {

                    Parent root = FXMLLoader.load(getClass().getResource("homepage-admin.fxml"));
                    Stage homepage = new Stage();
                    homepage.initStyle(StageStyle.UNDECORATED);
                    homepage.setScene(new Scene(root, 694, 470));
                    homepage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();

                }
            } else {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("homepageGuest.fxml"));
                    Stage homepage = new Stage();
                    homepage.initStyle(StageStyle.UNDECORATED);
                    homepage.setScene(new Scene(root, 694, 470));
                    homepage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();

                }
            }
        }
    }
}
