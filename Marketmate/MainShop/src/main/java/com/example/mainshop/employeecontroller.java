package com.example.mainshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class employeecontroller implements Initializable {

 public TableView<person> tableview;
    public TableColumn<person, String> colname;
    public TableColumn<person, String> colphone;
    public TableColumn<person, Integer> colid;



   @FXML
   public TextField namefield;
   @FXML
   public TextField phonefield;
   @FXML
   public TextField idfield;
    public TextField searchfield;
    public TextField searchp;


    private Stage stage;
    private Scene scene;
    private Parent root;







    private List<person> employeelist = new ArrayList<person>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



       colname.setCellValueFactory(new PropertyValueFactory<>("Empname"));
       colphone.setCellValueFactory(new PropertyValueFactory<>("Empphone"));
       colid.setCellValueFactory(new PropertyValueFactory<>("Empid"));


       ObservableList<person> observableList = FXCollections.observableArrayList(
               // new items("ami", 22,44)
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
//             int b = Integer.parseInt(s2[2]);
//             observableList.add(new person(s2[0], a, b));
//              employeelist.add(new person(s2[0], a, b));

//              int a = Integer.parseInt(s2[1]);
              int b = Integer.parseInt(s2[2]);
              observableList.add(new person(s2[0], s2[1], b));
              employeelist.add(new person(s2[0], s2[1], b));

          }

          reader.close();

       } catch (IOException e) {
          System.out.println(e);
       }



//       FilteredList<person> filteredList=new FilteredList<>(observableList,b->true);
//        searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
//
//            filteredList.setPredicate(employee -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowercasefilter = newValue.toLowerCase();
//                if (employee.getEmpphone().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                } else if (employee.getEmpname().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                } else return false;
//
//
//            });
//        });



//        SortedList<person> sortedList=new SortedList<>(filteredList);
//        sortedList.comparatorProperty().bind(tableview.comparatorProperty());














//        tableview.setEditable(true);




//        FilteredList<person> filteredList = new FilteredList<>(observableList, b -> true);
//        searchp.textProperty().addListener((observable, oldValue, newValue) -> {
//
//            filteredList.setPredicate(employee -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowercasefilter = newValue.toLowerCase();
//                if (employee.getEmpphone().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                } else if (employee.getEmpname().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                } else return false;
//
//
//            });
//
//
//        });
//
//        SortedList<person> sortedList = new SortedList<>(filteredList);
//        sortedList.comparatorProperty().bind(tableview.comparatorProperty());


        tableview.setItems(observableList);

//        tableview.setItems(sortedList);
        tableview.setEditable(true);

        colname.setCellFactory(TextFieldTableCell.forTableColumn());

        colphone.setCellFactory(TextFieldTableCell.forTableColumn());
        colid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));



//        tableview.setItems(sortedList);

    }


    public void add_employee(){

         String s1=namefield.getText();
//         int a= Integer.parseInt(phonefield.getText());
        String a= phonefield.getText();
         int b= Integer.parseInt(idfield.getText());
        person person=new person(s1,a,b);
        tableview.getItems().add(person);
        employeelist=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            int count1=0;
            for(person empx:employeelist){

                count1++;
                writer.write(empx.getEmpname()+"   "+empx.getEmpphone()+"   "+empx.getEmpid()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

    }

    public void remove_employee(){

        tableview.getItems().remove(tableview.getSelectionModel().getSelectedIndex());
        employeelist=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(person empx:employeelist){

                writer.write(empx.getEmpname()+"   "+empx.getEmpphone()+"   "+empx.getEmpid()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }




    }


    public void nameupdate(TableColumn.CellEditEvent<person, String> itemsStringCellEditEvent) {
        person products=tableview.getSelectionModel().getSelectedItem();
        products.setEmpname(itemsStringCellEditEvent.getNewValue());
        employeelist=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(person empx:employeelist){

                writer.write(empx.getEmpname()+"   "+empx.getEmpphone()+"   "+empx.getEmpid()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }





    }

    public void phoneupdate(TableColumn.CellEditEvent<person, String> event) {
        person product = tableview.getSelectionModel().getSelectedItem();


//        product.setEmpphone(event.getNewValue());
        product.setEmpphone(event.getNewValue());

        employeelist=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(person empx:employeelist){

                writer.write(empx.getEmpname()+"   "+empx.getEmpphone()+"   "+empx.getEmpid()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void idupdate(TableColumn.CellEditEvent<person, Integer> event) {
        person product = tableview.getSelectionModel().getSelectedItem();
        product.setEmpid(event.getNewValue());
        employeelist=tableview.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\staffs.txt"));

            for(person empx:employeelist){

                writer.write(empx.getEmpname()+"   "+empx.getEmpphone()+"   "+empx.getEmpid()+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void back_stockcontroller(ActionEvent event)throws  Exception{


        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void ShowDashboard(ActionEvent event) throws  Exception{


        // if(user.hashCode()==testuser.hashCode()&&pass.hashCode()==pass2.hashCode()) {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



}
