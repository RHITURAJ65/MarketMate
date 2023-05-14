package com.example.mainshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class dealcontroller implements Initializable     {

    public TableView<deal_item> table_deal;
    public TableColumn<deal_item,String> date_deal_col;
    public TableColumn<deal_item,String> name_deal_col;
    public TableColumn<deal_item,String>phone_deal_col;
    public TableColumn<deal_item,Integer>  bill_deal_col;
    private Stage stage;
    private Scene scene;
    private Parent root;
    List<deal_item> cse4 = new ArrayList<deal_item>();
    List<deal_item> cse5 = new ArrayList<deal_item>();
    @FXML
    public TextField searchp1;










    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    date_deal_col.setCellValueFactory(new PropertyValueFactory<>("Date_deal"));
        name_deal_col.setCellValueFactory(new PropertyValueFactory<>("Name_deal"));
        phone_deal_col.setCellValueFactory(new PropertyValueFactory<>("Phone_deal"));
        bill_deal_col.setCellValueFactory(new PropertyValueFactory<>("Bill_deal"));
        ObservableList<deal_item> observableList = FXCollections.observableArrayList(
               //  new deal_item("fdf", "amaee","dfd",4)
        );

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\deal.txt"));
            String line;

            int count = 0;
            while ((line = reader.readLine()) != null) {

                String[] s2 = line.split("\\s+");
                // System.out.println(s2[0]+"    "+s2[1]);
                count++;

                // int a = Integer.parseInt(s2[1]);
                int b = Integer.parseInt(s2[3]);
                 observableList.add(new deal_item(s2[0],s2[1],s2[2],b));
                cse4.add(new deal_item(s2[0],s2[1],s2[2],b));

            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    //search by phone number

        FilteredList<deal_item> filteredList = new FilteredList<>(observableList, b -> true);
        searchp1.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getName_deal().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
else if (employee.getPhone_deal().toLowerCase().indexOf(lowercasefilter) != -1) {
                   return true;
              }
                else return false;


            });


        });

        SortedList<deal_item> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_deal.comparatorProperty());


        //System.out.println(searchp1.getText());


        table_deal.setEditable(true);
       // table_deal.autosize();



        date_deal_col.setCellFactory(TextFieldTableCell.forTableColumn());
        name_deal_col.setCellFactory(TextFieldTableCell.forTableColumn());
        phone_deal_col.setCellFactory(TextFieldTableCell.forTableColumn());
        bill_deal_col.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        table_deal.setItems(sortedList);





    }

    public void oneditchange4(TableColumn.CellEditEvent<items, Integer> event) {
        deal_item product = table_deal.getSelectionModel().getSelectedItem();
        product.setBill_deal(event.getNewValue());
        cse5 = table_deal.getItems();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\deal.txt"));

            for (deal_item s : cse5) {

                writer.write(s.getDate_deal() + "   " + s.getName_deal() + "   " + s.getPhone_deal() + "  " + s.getBill_deal() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
        public void oneditchange1(TableColumn.CellEditEvent<items, String> event) {
            deal_item product = table_deal.getSelectionModel().getSelectedItem();
            product.setDate_deal(event.getNewValue());
            cse5=table_deal.getItems();
            try{
                BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\deal.txt"));

                for(deal_item s:cse5){

                    writer.write(s.getDate_deal()+"   "+s.getName_deal()+"   "+s.getPhone_deal()+"  "+s.getBill_deal()+"\n");
                }

                writer.close();
            }
            catch(IOException e){
                System.out.println(e);
            }



    }

    public void oneditchange2(TableColumn.CellEditEvent<items, String> event) {
        deal_item product = table_deal.getSelectionModel().getSelectedItem();
        product.setName_deal(event.getNewValue());
        cse5=table_deal.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\deal.txt"));

            for(deal_item s:cse5){

                writer.write(s.getDate_deal()+"   "+s.getName_deal()+"   "+s.getPhone_deal()+"  "+s.getBill_deal()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }



    }

    public void oneditchange3(TableColumn.CellEditEvent<items, String> event) {
        deal_item product = table_deal.getSelectionModel().getSelectedItem();
        product.setPhone_deal(event.getNewValue());
        cse5=table_deal.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\deal.txt"));

            for(deal_item s:cse5){

                writer.write(s.getDate_deal()+"   "+s.getName_deal()+"   "+s.getPhone_deal()+"  "+s.getBill_deal()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }



    }
    public void back_deal_page(ActionEvent event) throws  Exception{


        // if(user.hashCode()==testuser.hashCode()&&pass.hashCode()==pass2.hashCode()) {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }








}
