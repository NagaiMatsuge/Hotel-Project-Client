package com.example.hotel;

public class deleteUserObj {
    public String user_id;
    public String target;

    public deleteUserObj(String user_id, String target) {
        this.user_id = user_id;
        this.target = target;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
