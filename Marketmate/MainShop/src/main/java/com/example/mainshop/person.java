package com.example.mainshop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class person {

    private SimpleStringProperty empname;
    private SimpleStringProperty empphone;
    private SimpleIntegerProperty empid;
    public person(String empname, String empphone, int empid){

        this.empname=new SimpleStringProperty(empname);
        this.empphone=new SimpleStringProperty(empphone);
        this.empid=new SimpleIntegerProperty(empid);




    }

    public String getEmpname() {
        return empname.get();
    }

    public SimpleStringProperty empnameProperty() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname.set(empname);
    }

    public String getEmpphone() {
        return empphone.get();
    }

    public SimpleStringProperty empphoneProperty() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone.set(empphone);
    }

    public int getEmpid() {
        return empid.get();
    }

    public SimpleIntegerProperty empidProperty() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid.set(empid);
    }
    //    public int getStock_items() {
//        return stock_items.get();
//    }
//
//    public SimpleIntegerProperty stock_itemsProperty() {
//        return stock_items;
//    }
//
//    public void setStock_items(int stock_items) {
//        this.stock_items.set(stock_items);
//    }
//
//    public int getPrice_items() {
//        return price_items.get();
//    }
//
//    public SimpleIntegerProperty price_itemsProperty() {
//        return price_items;
//    }
//
//    public void setPrice_items(int price_items) {
//        this.price_items.set(price_items);
//    }
//
//    public String getItem_items() {
//        return empname.get();
//    }
//
//    public SimpleStringProperty item_itemsProperty() {
//        return empname;
//    }
//
//    public void setItem_items(String item_items) {
//        this.empname.set(item_items);
//    }
}
