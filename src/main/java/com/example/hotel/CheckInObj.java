package com.example.hotel;

public class CheckInObj {
    public String name;
    public String phone;
    public String target;
    public String email;
    public String address;
    public String city;
    public String nationality;
    public String card_no;
    public String type;
    public String capacity;
    public String id;
    public String check_in;
    public String check_out;



    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }



    public String getType() {
        return type;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName(){
        return name;
    }
    //CheckInObj(){target = "check_in";};
    public void setTarget(String target){
        this.target=target;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }



    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTarget() {
        return target;
    }
}
