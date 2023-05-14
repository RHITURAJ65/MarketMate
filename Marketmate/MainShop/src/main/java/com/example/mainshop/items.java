package com.example.mainshop;
import javafx.beans.property.SimpleIntegerProperty;


import javafx.beans.property.SimpleStringProperty;

public class items {

    private SimpleStringProperty item_items;
    private SimpleIntegerProperty price_items;
    private SimpleIntegerProperty stock_items;
    public  items(String item_items1,int price_items1,int stock_items1){

        this.item_items=new SimpleStringProperty(item_items1);
        this.price_items=new SimpleIntegerProperty(price_items1);
        this.stock_items=new SimpleIntegerProperty(stock_items1);




    }

    public int getStock_items() {
        return stock_items.get();
    }

    public SimpleIntegerProperty stock_itemsProperty() {
        return stock_items;
    }

    public void setStock_items(int stock_items) {
        this.stock_items.set(stock_items);
    }

    public int getPrice_items() {
        return price_items.get();
    }

    public SimpleIntegerProperty price_itemsProperty() {
        return price_items;
    }

    public void setPrice_items(int price_items) {
        this.price_items.set(price_items);
    }

    public String getItem_items() {
        return item_items.get();
    }

    public SimpleStringProperty item_itemsProperty() {
        return item_items;
    }

    public void setItem_items(String item_items) {
        this.item_items.set(item_items);
    }
}
