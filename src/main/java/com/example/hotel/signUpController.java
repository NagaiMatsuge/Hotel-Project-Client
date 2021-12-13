package com.example.hotel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.google.gson.Gson;



public class signUpController {

    @FXML
    private Button closeButton;
    @FXML
    private Label registrationLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private ToggleButton adminToggleButton;
    @FXML
    private ToggleButton userToggleButton;

    Customer customer = new Customer();

    public  void adminToggleButtonOnAction(ActionEvent event)
    {
        if(adminToggleButton.isSelected())
        {
            customer.setRank("admin");
        }
    }
    public  void userToggleButtonOnAction(ActionEvent event)
    {
        if(adminToggleButton.isSelected())
        {
            customer.setRank("user");
        }
    }
    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

    public void registerButtonOnAction(ActionEvent event) throws Exception {
        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
            confirmPasswordLabel.setText("");
        }
        else
            confirmPasswordLabel.setText("Password does not match");
    }

    public void registerUser() throws Exception {

        //making readable code


        String username = usernameTextField.getText();
        String password = setPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();


        if (!username.isBlank() && !password.isBlank() && !confirmPassword.isBlank()) {

            customer.setTarget("register");
            customer.setUsername(username);
            customer.setPassword(password);

            Gson json = new Gson();
            GreetClient t =new GreetClient();
            t.startConnection(DATA.ip, DATA.port);
            String response = json.toJson(customer);
            RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
            if(rr.getSuccess()){
                Stage stage = (Stage) closeButton.getScene().getWindow();
                stage.close();
            }else{
                registrationLabel.setText(rr.getMessage());
            }

        }
        else
            registrationLabel.setText("Fill all the fields!!");

    }




}