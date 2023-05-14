package com.example.mainshop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class deal_item {

    private SimpleStringProperty date_deal;
    private SimpleIntegerProperty bill_deal;
    private SimpleStringProperty  name_deal;
    private SimpleStringProperty phone_deal;

    public String getDate_deal() {
        return date_deal.get();
    }

    public SimpleStringProperty date_dealProperty() {
        return date_deal;
    }

    public void setDate_deal(String date_deal) {
        this.date_deal.set(date_deal);
    }

    public deal_item(String date_deal, String name_deal, String phone_deal, int bill_deal){

        this.date_deal=new SimpleStringProperty(date_deal);
        this.name_deal=new SimpleStringProperty(name_deal);
        this.phone_deal=new SimpleStringProperty(phone_deal);
        this.bill_deal=new SimpleIntegerProperty(bill_deal);


    }

    public String getName_deal() {
        return name_deal.get();
    }

    public SimpleStringProperty name_dealProperty() {
        return name_deal;
    }

    public void setName_deal(String name_deal) {
        this.name_deal.set(name_deal);
    }

    public int getBill_deal() {
        return bill_deal.get();
    }

    public SimpleIntegerProperty bill_dealProperty() {
        return bill_deal;
    }

    public String getPhone_deal() {
        return phone_deal.get();
    }

    public SimpleStringProperty phone_dealProperty() {
        return phone_deal;
    }

    public void setPhone_deal(String phone_deal) {
        this.phone_deal.set(phone_deal);
    }

    public void setBill_deal(int bill_deal) {
        this.bill_deal.set(bill_deal);
    }
}
