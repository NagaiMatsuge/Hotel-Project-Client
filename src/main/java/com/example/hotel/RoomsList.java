package com.example.hotel;

public class RoomsList {
    public String id;
    public String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String capacity;
    public String checkInDate;

    public RoomsList(String id, String type, String capacity, String checkInDate, String checkOutDate, String isAvailable) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isAvailable = isAvailable;
    }

    public String checkOutDate;
    public String isAvailable;

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}


