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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.cell.*;
import javafx.scene.control.cell.*;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class stockcontroller implements Initializable {

 public TableView<items> table_stock;
    public TableColumn<items, String> item_stock;
    public TableColumn<items, Integer> price_stock;
    public TableColumn<items, Integer> stock_stock;

   private List<items> cse3 = new ArrayList<items>();

   @FXML
   public TextField item_field;
   @FXML
   public TextField price_per_kg_field;
   @FXML
   public TextField stock_field;
   @FXML
   public TextField searchs;


    private Stage stage;
    private Scene scene;
    private Parent root;









    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



       item_stock.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
       price_stock.setCellValueFactory(new PropertyValueFactory<>("Price_items"));
       stock_stock.setCellValueFactory(new PropertyValueFactory<>("Stock_items"));


       ObservableList<items> observableList = FXCollections.observableArrayList(
               // new items("ami", 22,44)
       );

       try {
          BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));
          String line;

          int count = 0;
          while ((line = reader.readLine()) != null) {

             String[] s2 = line.split("\\s+");
             // System.out.println(s2[0]+"    "+s2[1]);
             count++;

             int a = Integer.parseInt(s2[1]);
             int b = Integer.parseInt(s2[2]);
             observableList.add(new items(s2[0], a, b));
             cse3.add(new items(s2[0], a, b));

          }

          reader.close();

       } catch (IOException e) {
          System.out.println(e);
       }




        FilteredList<items> filteredList = new FilteredList<>(observableList, b -> true);
        searchs.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getItem_items().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
//                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
                else return false;


            });


        });

        SortedList<items> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_stock.comparatorProperty());

        table_stock.setEditable(true);
       table_stock.setItems(sortedList);

        table_stock.setEditable(true);
        item_stock.setCellFactory(TextFieldTableCell.forTableColumn());
       // pr(TextFieldTableCell.forTableColumn())
        price_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        stock_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

     //   item_price.setCellFactory(IntegerFieldTableCell.forTableColumn());


    }


    public void stock_add(){

//
        List<items> cse33 = new ArrayList<items>();
         String s11=item_field.getText();
         int a1= Integer.parseInt(price_per_kg_field.getText());
         int b1= Integer.parseInt(stock_field.getText());

        //System.out.println(s1+a+b);
       //  items itemss=new items(s1,a,b);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));
            String line;

            int count = 0;
            while ((line = reader.readLine()) != null) {

                String[] s2 = line.split("\\s+");
                // System.out.println(s2[0]+"    "+s2[1]);
                count++;

                int a = Integer.parseInt(s2[1]);
                int b = Integer.parseInt(s2[2]);
               // observableList.add(new items(s2[0], a, b));
                cse33.add(new items(s2[0], a, b));

            }
            cse33.add(new items(s11,a1,b1));

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }


        // table_stock.getItems().add(items);
        // cse33=table_stock.getItems();

      //  cse33.add(new items("amader", 4, 4));
         //cse33.add(new items(s1,a,b));
//        for(items s:cse33){
//
//            System.out.println(s.getItem_items()+"  "+s.getPrice_items()+" "+s.getStock_items());
//        }

        //table_stock.getItems().clear();


        item_stock.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
        price_stock.setCellValueFactory(new PropertyValueFactory<>("Price_items"));
        stock_stock.setCellValueFactory(new PropertyValueFactory<>("Stock_items"));
        ObservableList<items> observableList = FXCollections.observableArrayList(
                // new items("ami", 22,44)
        );

        try{
            FileWriter fileWriter = new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt", false);
           fileWriter.close();
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
            // cse=table_view.getItems();
            int count1=0;
            for(items s:cse33){
                //System.out.println(s);
                count1++;
                observableList.add(new items(s.getItem_items(), s.getPrice_items(), s.getStock_items()));
                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"   "+s.getStock_items()+"\n");
            }
            count1++;
//            //writer.write((s11+"  "+a1+"   "+b1));
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

        FilteredList<items> filteredList = new FilteredList<>(observableList, b -> true);
        searchs.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getItem_items().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
//                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
                else return false;


            });


        });

        SortedList<items> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_stock.comparatorProperty());

        table_stock.setEditable(true);
        table_stock.setItems(sortedList);

        table_stock.setEditable(true);
        item_stock.setCellFactory(TextFieldTableCell.forTableColumn());
        // pr(TextFieldTableCell.forTableColumn())
        price_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        stock_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //   item_price.setCellFactory(IntegerFieldTableCell.forTableColumn());




    }

    public void stock_remove(){
        items selectedItem = table_stock.getSelectionModel().getSelectedItem();
        String s_item=selectedItem.getItem_items();
        System.out.println(selectedItem+" first show");
        List<items> cse55 = new ArrayList<items>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));
            String line;

            int count = 0;
            while ((line = reader.readLine()) != null) {

                String[] s2 = line.split("\\s+");
                // System.out.println(s2[0]+"    "+s2[1]);
                count++;

                int a = Integer.parseInt(s2[1]);
                int b = Integer.parseInt(s2[2]);
                // observableList.add(new items(s2[0], a, b));
                cse55.add(new items(s2[0], a, b));

            }
           // cse33.add(new items(s11,a1,b1));

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }



        item_stock.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
        price_stock.setCellValueFactory(new PropertyValueFactory<>("Price_items"));
        stock_stock.setCellValueFactory(new PropertyValueFactory<>("Stock_items"));
        ObservableList<items> observableList = FXCollections.observableArrayList(
                // new items("ami", 22,44)
        );

        try{
            FileWriter fileWriter = new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt", false);
            fileWriter.close();
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
            // cse=table_view.getItems();
            int count1=0;
            for(items s:cse55){
                //System.out.println(s);
                count1++;
                    String s_new=s.getItem_items();
                if(s_new.equals(s_item)){
                    System.out.println(selectedItem.getItem_items());
                   // continue;
                }
                else {
                    observableList.add(new items(s.getItem_items(), s.getPrice_items(), s.getStock_items()));
                    writer.write(s.getItem_items() + "   " + s.getPrice_items() + "   " + s.getStock_items() + "\n");
                }
            }
            count1++;
//            //writer.write((s11+"  "+a1+"   "+b1));
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }


        FilteredList<items> filteredList = new FilteredList<>(observableList, b -> true);
        searchs.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getItem_items().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
//                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
                else return false;


            });


        });

        SortedList<items> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_stock.comparatorProperty());

        table_stock.setEditable(true);
        table_stock.setItems(sortedList);

        table_stock.setEditable(true);
        item_stock.setCellFactory(TextFieldTableCell.forTableColumn());
        // pr(TextFieldTableCell.forTableColumn())
        price_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        stock_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //   item_price.setCellFactory(IntegerFieldTableCell.forTableColumn());












        //   table_stock.getItems().remove(table_stock.getSelectionModel().getSelectedIndex());
//        cse3=table_stock.getItems();
//        try{
//            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\shopping\\items.txt"));
//
//            for(items s:cse3){
//
//                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"   "+s.getStock_items()+"\n");
//            }
//
//            writer.close();
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }




    }


    public void oneditchange1(TableColumn.CellEditEvent<items, String> itemsStringCellEditEvent) {
        items products=table_stock.getSelectionModel().getSelectedItem();
        products.setItem_items(itemsStringCellEditEvent.getNewValue());
//     cse3=table_stock.getItems();
//        try{
//            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (2)\\shopping\\items.txt"));
//
//            for(items s:cse3){
//
//                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"   "+s.getStock_items()+"\n");
//            }
//
//            writer.close();
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }





    }

    public void oneditchange2(TableColumn.CellEditEvent<items, Integer> event) {
        items product = table_stock.getSelectionModel().getSelectedItem();
        product.setPrice_items(event.getNewValue());
//        cse3=table_stock.getItems();
//        try{
//            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\shopping\\items.txt"));
//
//            for(items s:cse3){
//
//                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"   "+s.getStock_items()+"\n");
//            }
//
//            writer.close();
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }
    }
    public void oneditchange3(TableColumn.CellEditEvent<items, Integer> event) {
        items product = table_stock.getSelectionModel().getSelectedItem();
        product.setStock_items(event.getNewValue());
//        cse3=table_stock.getItems();
//        try{
//            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\shopping\\items.txt"));
//
//            for(items s:cse3){
//
//                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"   "+s.getStock_items()+"\n");
//            }
//
//            writer.close();
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }
    }
    public void back_stockcontroller(ActionEvent event)throws  Exception{

        cse3=table_stock.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));

            for(items s:cse3){

                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"   "+s.getStock_items()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
