package com.esoft.subhasis.myapplication;

public class CardApply {

    private String name;

    private String phone;

    private String email;

    private String address;
    public CardApply(){

    }

    public CardApply(String name, String phone, String address, String email ){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.address=address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
