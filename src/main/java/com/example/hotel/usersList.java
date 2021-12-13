package com.example.hotel;

public class usersList {
    public String username;
    public String password;
    public String rank;

    public usersList(String username, String password, String rank) {
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public String getUsername() {
        return username;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
