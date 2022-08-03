package com.esoft.subhasis.myapplication;

public class Card {

    private String name = "";
    private String phone = "";
    private String email = "";
    private String address = "";
    private String cardtype = "";
    private String cardexpirydate = "";
    private String validity="";
    private String barcode="";




    public Card() {

    }

    public Card(String name, String phone, String email, String address, String cardtype, String cardexpirydate, String validity, String barcode) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.cardtype = cardtype;
        this.cardexpirydate = cardexpirydate;
        this.validity=validity;
        this.barcode=barcode;

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

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardexpirydate() {
        return cardexpirydate;
    }

    public void setCardexpirydate(String cardexpirydate) {
        this.cardexpirydate = cardexpirydate;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

