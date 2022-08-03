package com.esoft.subhasis.myapplication;

import java.util.SplittableRandom;

public class Songs {

    private String title="";
    private String artist="";
    private String coverImage="";
    private String songUrl="";
    private String phno="";
    private String largedata;
    private  String pin="";

    public Songs(){

    }

    public Songs(String title, String artist, String coverImage, String songUrl, String phno, String largedata, String pin){
        this.title=title;
        this.artist=artist;
        this.coverImage=coverImage;
        this.songUrl=songUrl;
        this.phno=phno;
        this.largedata=largedata;
        this.pin=pin;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getLargedata() {
        return largedata;
    }

    public void setLargedata(String largedata) {
        this.largedata = largedata;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
