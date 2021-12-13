package com.example.hotel;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HomepageAdminController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label nameTextField;
    @FXML
    private Label positionTextField;
    @FXML
    private  Label positionLabel;
    @FXML
    private Button checkInButton;
    @FXML
    private Button checkOUtButton;
    @FXML
    private Button roomBookingButton;
    @FXML
    private Button cancelBookingButton;
    @FXML
    private Button roomsButton;
    @FXML
    private Button guestsButton;
    @FXML
    private Button settingButton;
    @FXML
    private Button logOutButton;
    public void logOutButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize(){
        nameTextField.setText(DATA.username);
        positionTextField.setText(DATA.rank);
    }

    public void guestsButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guests.fxml"));
            Stage guests =new Stage();
            guests.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 790, 547);
            guests.setTitle("Hotel Management System");
            guests.setScene(scene);
            guests.show();

        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
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

    public void checkOutButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("checkOut.fxml"));
            Stage checkout =new Stage();
            checkout.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 694, 470);
            checkout.setTitle("Hotel Management System");
            checkout.setScene(scene);
            checkout.show();

        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void CheckInButtonOnAction(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("checkIn.fxml"));
            Stage checkIn =new Stage();
            checkIn.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 690, 470);
            checkIn.setTitle("Hotel Management System");
            checkIn.setScene(scene);
            checkIn.show();
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void roomBookingButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("checkIn.fxml"));
            Stage checkIn =new Stage();
            checkIn.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 690, 470);
            checkIn.setTitle("Hotel Management System");
            checkIn.setScene(scene);
            checkIn.show();
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void cancelBookingButtonClicked(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("checkOut.fxml"));
            Stage checkout =new Stage();
            checkout.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 694, 470);
            checkout.setTitle("Hotel Management System");
            checkout.setScene(scene);
            checkout.show();
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void settingButtonOnAction(ActionEvent event)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settings.fxml"));
            Stage setting =new Stage();
            setting.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(fxmlLoader.load(), 363, 390);
            setting.setTitle("Hotel Management System");
            setting.setScene(scene1);
            setting.show();

        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    }
