package com.esoft.subhasis.myapplication;

public class VerifyUpload {


    private String username="";
    private String useraddress="";
    private String userphone="";
    private String useremail="";
    private String customername="";
    private String customercode="";
    private String customertype="";
    private String customerstatus="";

    public VerifyUpload(){

    }

    public VerifyUpload(String username, String useraddress, String userphone, String useremail, String customername, String customercode, String customertype, String customerstatus){

        this.username=username;
        this.userphone=userphone;
        this.useremail=useremail;
        this.useraddress=useraddress;

        this.customercode=customercode;
        this.customerstatus=customerstatus;
        this.customertype=customertype;
        this.customername=customername;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getCustomerstatus() {
        return customerstatus;
    }

    public void setCustomerstatus(String customerstatus) {
        this.customerstatus = customerstatus;
    }
}
