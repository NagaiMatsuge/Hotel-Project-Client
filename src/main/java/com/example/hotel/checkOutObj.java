package com.example.hotel;

public class checkOutObj {
    public String id;
    public String target;
    public checkOutObj(String target, String id){
        this.target = target;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String roomNumber) {
        this.id = roomNumber;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
