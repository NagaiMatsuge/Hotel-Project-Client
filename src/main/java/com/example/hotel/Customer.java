package com.example.hotel;

public class Customer {
    public String target;

    public String rank;
    public String username;
    public String password;
    public Customer (String firstname)
    {

    }
    public Customer() {
        rank="user";
    }

    public void setTarget(String target)
    {
        this.target=target;
    }
    public String getTarget() {
        return target;
    }




    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}