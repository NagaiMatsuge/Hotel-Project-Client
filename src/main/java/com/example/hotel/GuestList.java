package com.example.hotel;

public class GuestList {
    public String roomId;
    public String name;
    public String email;
    public String address;
    public String city;
    public String nationality;
    public String passport;
    public String phone;

    public GuestList(String roomId, String name, String email, String address, String city, String nationality, String passport, String phone) {
        this.roomId = roomId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.nationality = nationality;
        this.passport = passport;
        this.phone = phone;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
