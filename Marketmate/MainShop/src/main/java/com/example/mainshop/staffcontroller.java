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

public class staffcontroller implements Initializable {

 public TableView<employeeperson> tableview;
    public TableColumn<employeeperson, String> staffname;
    public TableColumn<employeeperson, String> staffphone;
    public TableColumn<employeeperson, Integer> staffid;

   private List<employeeperson> cse3 = new ArrayList<employeeperson>();

   @FXML
   public TextField name_field;
   @FXML
   public TextField phone_field;
   @FXML
   public TextField id_field;
   @FXML
   public TextField searchbox;


    private Stage stage;
    private Scene scene;
    private Parent root;









    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        staffname.setCellValueFactory(new PropertyValueFactory<>("EMPname"));
        staffphone.setCellValueFactory(new PropertyValueFactory<>("EMPphone"));
        staffid.setCellValueFactory(new PropertyValueFactory<>("EMPid"));


       ObservableList<employeeperson> observableList = FXCollections.observableArrayList(

       );

       try {
          BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));
          String line;

          int count = 0;
          while ((line = reader.readLine()) != null) {

             String[] s2 = line.split("\\s+");
             // System.out.println(s2[0]+"    "+s2[1]);
             count++;

//             int a = Integer.parseInt(s2[1]);
             int b = Integer.parseInt(s2[2]);
             observableList.add(new employeeperson(s2[0], s2[1], b));
             cse3.add(new employeeperson(s2[0], s2[1], b));

          }

          reader.close();

       } catch (IOException e) {
          System.out.println(e);
       }




        FilteredList<employeeperson> filteredList = new FilteredList<>(observableList, b -> true);
        searchbox.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getEMPname().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
//                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
                else return false;


            });


        });

        SortedList<employeeperson> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableview.comparatorProperty());

        tableview.setEditable(true);
        tableview.setItems(sortedList);

        tableview.setEditable(true);
        staffname.setCellFactory(TextFieldTableCell.forTableColumn());
       // pr(TextFieldTableCell.forTableColumn())
//        price_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        staffphone.setCellFactory(TextFieldTableCell.forTableColumn());
        staffid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

     //   item_price.setCellFactory(IntegerFieldTableCell.forTableColumn());


    }


    public void stock_add(){

//
        List<employeeperson> cse33 = new ArrayList<employeeperson>();
         String s11=name_field.getText();
        String a1=phone_field.getText();
//         int a1= Integer.parseInt(price_per_kg_field.getText());
         int b1= Integer.parseInt(id_field.getText());

        //System.out.println(s1+a+b);
       //  items itemss=new items(s1,a,b);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));
            String line;

            int count = 0;
            while ((line = reader.readLine()) != null) {

                String[] s2 = line.split("\\s+");
                // System.out.println(s2[0]+"    "+s2[1]);
                count++;

//                int a = Integer.parseInt(s2[1]);
                int b = Integer.parseInt(s2[2]);
               // observableList.add(new items(s2[0], a, b));
                cse33.add(new employeeperson(s2[0],s2[1], b));

            }
            cse33.add(new employeeperson(s11,a1,b1));

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


        staffname.setCellValueFactory(new PropertyValueFactory<>("EMPname"));
        staffphone.setCellValueFactory(new PropertyValueFactory<>("EMPphone"));
        staffid.setCellValueFactory(new PropertyValueFactory<>("EMPid"));
        ObservableList<employeeperson> observableList = FXCollections.observableArrayList(
                // new items("ami", 22,44)
        );

        try{
            FileWriter fileWriter = new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt", false);
           fileWriter.close();
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
            // cse=table_view.getItems();
            int count1=0;
            for(employeeperson s:cse33){
                //System.out.println(s);
                count1++;
                observableList.add(new employeeperson(s.getEMPname(), s.getEMPphone(), s.getEMPid()));
                writer.write(s.getEMPname()+"   "+s.getEMPphone()+"   "+s.getEMPid()+"\n");
            }
            count1++;
//            //writer.write((s11+"  "+a1+"   "+b1));
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

        FilteredList<employeeperson> filteredList = new FilteredList<>(observableList, b -> true);
        searchbox.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getEMPname().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
//                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
                else return false;


            });


        });

        SortedList<employeeperson> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableview.comparatorProperty());

        tableview.setEditable(true);
        tableview.setItems(sortedList);

        tableview.setEditable(true);
        staffname.setCellFactory(TextFieldTableCell.forTableColumn());
        // pr(TextFieldTableCell.forTableColumn())
//        price_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        staffphone.setCellFactory(TextFieldTableCell.forTableColumn());

        staffid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //   item_price.setCellFactory(IntegerFieldTableCell.forTableColumn());




    }

    public void stock_remove(){
        employeeperson selectedItem = tableview.getSelectionModel().getSelectedItem();
        String s_item=selectedItem.getEMPname();
        System.out.println(selectedItem+" first show");
        List<employeeperson> cse55 = new ArrayList<employeeperson>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));
            String line;

            int count = 0;
            while ((line = reader.readLine()) != null) {

                String[] s2 = line.split("\\s+");
                // System.out.println(s2[0]+"    "+s2[1]);
                count++;

//                int a = Integer.parseInt(s2[1]);
                int b = Integer.parseInt(s2[2]);
                // observableList.add(new items(s2[0], a, b));
                cse55.add(new employeeperson(s2[0], s2[1], b));

            }
           // cse33.add(new items(s11,a1,b1));

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }



        staffname.setCellValueFactory(new PropertyValueFactory<>("EMPname"));
        staffphone.setCellValueFactory(new PropertyValueFactory<>("EMPphone"));
        staffid.setCellValueFactory(new PropertyValueFactory<>("EMPid"));
        ObservableList<employeeperson> observableList = FXCollections.observableArrayList(
                // new items("ami", 22,44)
        );

        try{
            FileWriter fileWriter = new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt", false);
            fileWriter.close();
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
            // cse=table_view.getItems();
            int count1=0;
            for(employeeperson s:cse55){
                //System.out.println(s);
                count1++;
                    String s_new=s.getEMPname();
                if(s_new.equals(s_item)){
                    System.out.println(selectedItem.getEMPname());
                   // continue;
                }
                else {
                    observableList.add(new employeeperson(s.getEMPname(), s.getEMPphone(), s.getEMPid()));
                    writer.write(s.getEMPname() + "   " + s.getEMPphone() + "   " + s.getEMPid() + "\n");
                }
            }
            count1++;
//            //writer.write((s11+"  "+a1+"   "+b1));
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }


        FilteredList<employeeperson> filteredList = new FilteredList<>(observableList, b -> true);
        searchbox.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getEMPname().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                }
//                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
                else return false;


            });


        });

        SortedList<employeeperson> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableview.comparatorProperty());

        tableview.setEditable(true);
        tableview.setItems(sortedList);

        tableview.setEditable(true);
        staffname.setCellFactory(TextFieldTableCell.forTableColumn());
        // pr(TextFieldTableCell.forTableColumn())
//        price_stock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        staffphone.setCellFactory(TextFieldTableCell.forTableColumn());
        staffid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

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


    public void changename(TableColumn.CellEditEvent<employeeperson, String> itemsStringCellEditEvent) {
        employeeperson products=tableview.getSelectionModel().getSelectedItem();
        products.setEMPname(itemsStringCellEditEvent.getNewValue());
     cse3=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(employeeperson s:cse3){

                writer.write(s.getEMPname() + "   " + s.getEMPphone() + "   " + s.getEMPid() + "\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }





    }

    public void changephone(TableColumn.CellEditEvent<employeeperson, String> event) {
        employeeperson product = tableview.getSelectionModel().getSelectedItem();
        product.setEMPphone(event.getNewValue());
        product.setEMPphone(event.getNewValue());
        cse3=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(employeeperson s:cse3){

                writer.write(s.getEMPname() + "   " + s.getEMPphone() + "   " + s.getEMPid() + "\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void changeid(TableColumn.CellEditEvent<employeeperson, Integer> event) {
        employeeperson product = tableview.getSelectionModel().getSelectedItem();
        product.setEmpid(event.getNewValue());
        cse3=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(employeeperson s:cse3){

                writer.write(s.getEMPname() + "   " + s.getEMPphone() + "   " + s.getEMPid() + "\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void backtodash(ActionEvent event)throws  Exception{

        cse3=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(employeeperson s:cse3){

                writer.write(s.getEMPname()+"   "+s.getEMPphone()+"   "+s.getEMPid()+"\n");
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
