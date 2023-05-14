package com.example.mainshop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class employeeperson {

    private SimpleStringProperty empname;
    private SimpleStringProperty empphone;
    private SimpleIntegerProperty empid;
    public employeeperson(String empname, String empphone, int empid){

        this.empname=new SimpleStringProperty(empname);
        this.empphone=new SimpleStringProperty(empphone);
        this.empid=new SimpleIntegerProperty(empid);




    }

    public int getEMPid() {
        return empid.get();
    }

    public SimpleIntegerProperty empidProperty() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid.set(empid);
    }

    public String getEMPphone() {
        return empphone.get();
    }

    public SimpleStringProperty empphoneProperty() {
        return empphone;
    }

    public void setEMPphone(String empphone) {
        this.empphone.set(empphone);
    }

    public String getEMPname() {
        return empname.get();
    }

    public SimpleStringProperty empnameProperty() {
        return empname;
    }

    public void setEMPname(String empname) {
        this.empname.set(empname);
    }
}
