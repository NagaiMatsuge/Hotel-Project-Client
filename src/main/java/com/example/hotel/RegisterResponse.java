package com.example.hotel;

public class RegisterResponse {
    public Boolean success;
    public String message;
    public String[][] data;

    public Boolean getSuccess(){return this.success;}
    public String getMessage(){return this.message;}
    public String[][] getData(){return this.data;}
}
