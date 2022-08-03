package com.esoft.subhasis.myapplication;

public class ShopList {

    private String name="";
    private String brand="";
    private String image="";
    private String price="";
    private String category="";
    private String color="";
    private String oldprice="";
    private String discount="";
    private String car1="";
    private String car2="";
    private String car3="";
    private String phone="";
    private String largedata="";



    public  ShopList(){

    }

    public ShopList(String name, String brand, String image, String price, String color, String category, String oldprice,String discount,String car1,String car2,String car3,String phone, String largedata){

        this.brand=brand;
        this.image=image;
        this.price=price;
        this.name=name;
        this.category=category;
        this.color=color;
        this.oldprice=oldprice;
        this.discount=discount;
        this.car1=car1;
        this.car2=car2;
        this.car3=car3;
        this.phone=phone;
        this.largedata=largedata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCar1() {
        return car1;
    }

    public void setCar1(String car1) {
        this.car1 = car1;
    }

    public String getCar2() {
        return car2;
    }

    public void setCar2(String car2) {
        this.car2 = car2;
    }

    public String getCar3() {
        return car3;
    }

    public void setCar3(String car3) {
        this.car3 = car3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLargedata() {
        return largedata;
    }

    public void setLargedata(String largedata) {
        this.largedata = largedata;
    }
}
