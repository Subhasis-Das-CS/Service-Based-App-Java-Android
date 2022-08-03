package com.esoft.subhasis.myapplication;

public class HomeList {

    private String imageurl="";
    private String text="";
    private String text1="";
    private String text2="";
    private String text3="";
    private String carousel1="";
    private String carousel2="";
    private String carousel3="";
    private String email;
    private  String largedata="";
    public HomeList(){

    }

    public  HomeList(String imageurl, String text,String text1,String text2,String text3,String carousel1,String carousel2, String carousel3, String email, String largedata ){

        this.imageurl=imageurl;
        this.text=text;
        this.text1=text1;
        this.text2=text2;
        this.text3=text3;
        this.carousel1=carousel1;
        this.carousel2=carousel2;
        this.carousel3=carousel3;
        this.email=email;
        this.largedata=largedata;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getCarousel1() {
        return carousel1;
    }

    public void setCarousel1(String carousel1) {
        this.carousel1 = carousel1;
    }

    public String getCarousel2() {
        return carousel2;
    }

    public void setCarousel2(String carousel2) {
        this.carousel2 = carousel2;
    }

    public String getCarousel3() {
        return carousel3;
    }

    public void setCarousel3(String carousel3) {
        this.carousel3 = carousel3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLargedata() {
        return largedata;
    }

    public void setLargedata(String largedata) {
        this.largedata = largedata;
    }
}
