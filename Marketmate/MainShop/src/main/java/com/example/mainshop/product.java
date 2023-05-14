package com.example.mainshop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class product {
        private SimpleStringProperty Name;
        private   SimpleStringProperty Phone;
        private SimpleIntegerProperty sino;

        public int getSino() {
                return sino.get();
        }

        public SimpleIntegerProperty sinoProperty() {
                return sino;
        }

        public void setSino(int sino) {
                this.sino.set(sino);
        }

        public product(int ssino,String name, String phone){
            this.Name=new SimpleStringProperty(name);
            this.Phone=new SimpleStringProperty(phone);
            this.sino=new SimpleIntegerProperty(ssino);

        }

        public String getName() {
                return Name.get();
        }

        public SimpleStringProperty nameProperty() {
                return Name;
        }

        public void setName(String name) {
                this.Name.set(name);
        }

        public String getPhone() {
                return Phone.get();
        }

        public SimpleStringProperty phoneProperty() {
                return Phone;
        }

        public void setPhone(String phone) {
                this.Phone.set(phone);
        }
}
