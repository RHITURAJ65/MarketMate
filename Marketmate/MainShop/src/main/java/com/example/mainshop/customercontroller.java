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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import  java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class customercontroller implements Initializable {

    @FXML
   public TextField text_phone;
    @FXML
    public TextField searchp;
    @FXML
    public TextField text_name;
    public TableView<product> table_view;
    public TableColumn<product,String> colName;
    public TableColumn<product,String> comP;
    public TableColumn<product,Integer>sino;
    List<product> cse=new ArrayList<product>() ;

    List<product> cse6=new ArrayList<product>() ;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        comP.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        sino.setCellValueFactory(new PropertyValueFactory<>("Sino"));

        ObservableList<product> observableList = FXCollections.observableArrayList(
                //  new product("ami", "dfksdfksd")
        );


        //String lost[]=new String[71];
        try {
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\final project\\shopping\\input.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
            // String line[]=new String[70];

            String line;

            int count=0;
           while ((line = reader.readLine()) != null) {

                //String line1= reader.readLine();
          //  line= reader.readLine();
                String[] s2 = line.split("\\s+");
                // System.out.println(s2[0]+"    "+s2[1]);
                 count++;
                observableList.add(new product(count,s2[1], s2[2]));
                cse.add(new product(count,s2[1], s2[2]));

            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }


        //cse.add(new product("ami","tmi"));


        FilteredList<product> filteredList = new FilteredList<>(observableList, b -> true);
        searchp.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (employee.getPhone().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                } else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
                    return true;
                } else return false;


            });


        });

        SortedList<product> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_view.comparatorProperty());





        table_view.setEditable(true);
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        comP.setCellFactory(TextFieldTableCell.forTableColumn());

        table_view.setItems(sortedList);


    }





//   public void add(ActionEvent event)throws Exception{
////        product product=new product(text_name.getText(),text_phone.getText());
////       table_view.getItems().add(product);
////       //table_view.getItems().add(new product("newName", "newPhone"));
////
////       // cse.add(new product(text_name.getText(),text_phone.getText()));
////       cse=table_view.getItems();
//       Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("add_customer.fxml"));
//       this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//       this.scene = new Scene(root);
//       this.stage.setScene(this.scene);
//       this.stage.show();
//
//   }


//    public void ok(){
//       try{
//           BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\shopping\\input.txt"));
//           // System.out.println(lost[0]);String s3=lost[0];
//           cse=table_view.getItems();
//           int count=0;
//           for(product s:cse){
//               //System.out.println(s);
//               count++;
//               writer.write(count+"   "+s.getName()+"   "+s.getPhone()+"\n");
//           }
//           writer.close();
//       }
//       catch(IOException e){
//           System.out.println(e);
//       }
//   }



public void addnn(ActionEvent event) throws  Exception{
    Parent root= FXMLLoader.load(getClass().getResource("addsomet.fxml"));
    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    //System.out.println("hocca");
}
 public  void oneditchange(TableColumn.CellEditEvent<product,String>productStringCellEditEvent){
        product products=table_view.getSelectionModel().getSelectedItem();
        products.setName(productStringCellEditEvent.getNewValue());
       cse6=table_view.getItems();

     try{
         BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
//         BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\User\\Downloads\\final project\\shopping\\input.txt"));
         // System.out.println(lost[0]);String s3=lost[0];
        // cse=table_view.getItems();
         int count=0;
         for(product s:cse6){
             //System.out.println(s);
             count++;
             writer.write(count+"   "+s.getName()+"   "+s.getPhone()+"\n");
         }
         writer.close();
     }
     catch(IOException e){
         System.out.println(e);
     }








    }

    public  void oneditchange1(TableColumn.CellEditEvent<product,String>productStringCellEditEvent){
        product products=table_view.getSelectionModel().getSelectedItem();
        products.setPhone(productStringCellEditEvent.getNewValue());
        cse6=table_view.getItems();

        try{
//            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\User\\Downloads\\final project\\shopping\\input.txt"));
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
            // cse=table_view.getItems();
            int count=0;
            for(product s:cse6){
                //System.out.println(s);
                count++;
                writer.write(count+"   "+s.getName()+"   "+s.getPhone()+"\n");
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

    }



//    public void search(){
//            String phone=searchp.getText();
//      //  ObservableList<product>allproduct,singleproduct;
//        //allproduct= table_view.getItems();
//       // table_view.setSelectionMode().;
//        table_view.getItems().clear();
//        for(product customer:cse){
//                if(customer.getPhone().contains(phone)){
//                        table_view.getItems().add(customer);
//                }
//        }
//    }

    public void gothisperson(ActionEvent event )throws Exception{

//
//    ObservableList<product>products;
//    products=table_view.getSelectionModel().getSelectedItems();
//
//    FXMLLoader loader=new FXMLLoader(getClass().getResource("gotothisperson.fxml"));
//root = loader.load();
//   // Parent root= FXMLLoader.load(getClass().getResource("gotothisperson.fxml"));
//       // thispersoncontroller atempee=new thispersoncontroller();
//        thispersoncontroller tempee = loader.getController();
//       tempee.start("dlkfjlds");
//
//
//    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//    scene=new Scene(root);
//    stage.setScene(scene);
//    stage.show();
//
////   thispersoncontroller temp=new thispersoncontroller();
////   temp.title(products.get(0).getName());
//   // System.out.println(products.get(0).getName());



            ObservableList<product> products;
            products = table_view.getSelectionModel().getSelectedItems();
            product pro=table_view.getSelectionModel().getSelectedItem();
        if (pro == null) {
            // If no row is selected, display an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Person to Continue.");
            alert.showAndWait();
            return;
        }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("gotothisperson.fxml"));
            root = loader.load();
            thispersoncontroller tempee = loader.getController();
            tempee.start(products.get(0)); // Pass the string value

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();




}


public void okandback_customercontroller(ActionEvent event)throws Exception{

    try{
//        BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\User\\Downloads\\final project\\shopping\\input.txt"));
        BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
        // System.out.println(lost[0]);String s3=lost[0];
        cse=table_view.getItems();
        int count=0;
        for(product s:cse){
            //System.out.println(s);
            count++;
            writer.write(count+"   "+s.getName()+"   "+s.getPhone()+"\n");
        }
        writer.close();
    }
    catch(IOException e){
        System.out.println(e);
    }
    // if(user.hashCode()==testuser.hashCode()&&pass.hashCode()==pass2.hashCode()) {
    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}


}

