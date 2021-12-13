package com.example.hotel;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class checkInAdminController {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField nationalityTextField;
    @FXML
    private TextField passportTextField;
    @FXML
    private TextField cardTextField;
    @FXML
    private TextField CVCTextField;
    @FXML
    private RadioButton economyRadio;
    @FXML
    private RadioButton normalRadio;
    @FXML
    private Text message;
    @FXML
    private RadioButton vipRadio;
    @FXML
    private RadioButton singleRadio;
    @FXML
    private RadioButton doubleRadio;
    @FXML
    private Button searchButton;
    @FXML
    private DatePicker checkOutField;
    @FXML
    private DatePicker checkInField;
    @FXML
    private Label idLabel;
    @FXML
    private Button backButton;

    public String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    CheckInObj checkIn=new CheckInObj();
    public void searchButtonOnAction(ActionEvent event) throws IOException {
        checkIn.setTarget("search_room");
        Gson json = new Gson();
        GreetClient t =new GreetClient();
        t.startConnection(DATA.ip, DATA.port);
        String response = json.toJson(checkIn);
        RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
        if(rr.getSuccess()) {
            message.setText(rr.getData()[0][0]);
            setRoomId(rr.getData()[0][0]);
        } else{
            message.setText(rr.getMessage());
        }
    }
    public void radioSelect(ActionEvent event)
    {
        if(economyRadio.isSelected())
        {
            checkIn.setType("economy");
        }
        if (normalRadio.isSelected())
        {
            checkIn.setType("normal");
        }
        if (vipRadio.isSelected())
        {checkIn.setType("vip");}
        if (singleRadio.isSelected())
        {
            checkIn.setCapacity("single");
        }
        if(doubleRadio.isSelected())
        {
            checkIn.setCapacity("double");
        }
    }
    public void clearButtonOnAction(ActionEvent event)
    {
        nameTextField.setText("");
        phoneTextField.setText("");
        emailTextField.setText("");
        addressTextField.setText("");
        cityTextField.setText("");
        nationalityTextField.setText("");
        cardTextField.setText("");
        CVCTextField.setText("");
        passportTextField.setText("");

    }
    public void submitButtonOnAction()throws Exception {registerUser();}

    public void registerUser()throws Exception{
        String name=nameTextField.getText();
        String phone=phoneTextField.getText();
        String email=emailTextField.getText();
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String nationality=nationalityTextField.getText();
        String card=cardTextField.getText();
        String CVC=CVCTextField.getText();
        String passport=passportTextField.getText();

        if(!name.isBlank()&&!phone.isBlank()&&!email.isBlank()&&!address.isBlank()&&!city.isBlank()&&!nationality.isBlank()&&!card.isBlank()&&!CVC.isBlank()&&!passport.isBlank())
        {
            checkIn.setTarget("check_in");
            checkIn.setCard_no(card);
            checkIn.setEmail(email);
            checkIn.setName(name);
            checkIn.setNationality(nationality);
            checkIn.setPhone(phone);
            checkIn.setAddress(address);
            checkIn.setCity(city);
            checkIn.setId(getRoomId());
            checkIn.setCheck_in("12/12/12");
            checkIn.setCheck_out("12/12/12");



            Gson json = new Gson();
            GreetClient t =new GreetClient();
            t.startConnection(DATA.ip, DATA.port);
            String response = json.toJson(checkIn);
            RegisterResponse rr = json.fromJson(t.sendMessage(response), RegisterResponse.class);
            if(rr.getSuccess()){
                message.setText("Successfully booked the room");
            }else{
                message.setText(rr.getMessage());
            }
        } else{
            message.setText("Please provide all the fields");
        }

    }

    public void backButtonClicked(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}