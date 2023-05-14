package com.example.mainshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.text.SimpleDateFormat;

public class todayshopping extends thispersoncontroller implements Initializable {

    private product this_customer_shopping;
    @FXML
    public TextField price_field;
    @FXML
    private  TextField searchitem;


    public TableView<items> table_items;
    public TableColumn<items, String> item_items;
    public TableColumn<items, Integer> price_items;
    public TableColumn<items, Integer> stock_items;

    public TableView<items> table_bill;
    public TableColumn<items, String> item_bill;
    public TableColumn<items, Integer> price_bill;
    @FXML
    Label today_total_bill;
    @FXML
     Label beforebill;
    @FXML
            TextField discount;

    List<items> cse2 = new ArrayList<items>();

    List<deal_item> cse4 = new ArrayList<deal_item>();

    List<items>cse_bill=new ArrayList<items>();
    List<items>cse7=new ArrayList<items>();
    int count_bil=0;
    int before_bill=0;
    private Parent root;


    public void start(product temp) {


        this_customer_shopping = temp;
        System.out.println("from start");
        System.out.println(temp.getPhone());
        // List<items>cse77=new ArrayList<items>();

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
                // observableList.add(new deal_item(s2[0],s2[1],s2[2],b));
                //cse4.add(new deal_item(s2[0],s2[1],s2[2],b));
                String s22=s2[2];
                String s23=temp.getPhone();
                if(s22.equals(s23)){
                    before_bill+=b;
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(before_bill);
        beforebill.setText(String.valueOf(before_bill));


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        item_items.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
        price_items.setCellValueFactory(new PropertyValueFactory<>("Price_items"));
        stock_items.setCellValueFactory(new PropertyValueFactory<>("Stock_items"));


        item_bill.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
        price_bill.setCellValueFactory(new PropertyValueFactory<>("Price_items"));

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
                cse2.add(new items(s2[0], a, b));

            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }


        FilteredList<items> filteredList = new FilteredList<>(observableList, b -> true);
        searchitem.textProperty().addListener((observable, oldValue, newValue) -> {

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
               // }
                 else return false;


            });


        });

        SortedList<items> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_items.comparatorProperty());














        table_items.setEditable(true);



        table_items.setItems(sortedList);



    }
//    public void purchase(ActionEvent event) {
//        // Get the selected row in the TableView
//        items selectedItem = table_items.getSelectionModel().getSelectedItem();
//
//
//        // Create a new items object with updated stock value
//        items p5 = new items("dlfjdldff",555,555);
//
//        // Update the selected item with the new object
//        int selectedIndex = table_items.getSelectionModel().getSelectedIndex();
//        table_items.getItems().set(selectedIndex, p5);
//
//        // Create a new FilteredList based on the current TableView items
//        FilteredList<items> filteredList = new FilteredList<>(table_items.getItems());
//
//        // Set the filter predicate to only show items with non-zero stock
//        filteredList.setPredicate(item -> item.getStock_items() > 0);
//
//        // Create a new SortedList based on the filtered list
//        SortedList<items> sortedList = new SortedList<>(filteredList);
//        sortedList.comparatorProperty().bind(table_items.comparatorProperty());
//
//        // Set the sorted and filtered list as the items in the TableView
//        table_items.setItems(sortedList);
//
//        // Refresh the TableView to reflect the updated values
//        table_items.refresh();
//    }
public void purchase(ActionEvent event) {
    // Get the selected row in the TableView
    items selectedItem = table_items.getSelectionModel().getSelectedItem();


    String discountInput = discount.getText().trim();
    int discountValue;

    if (discountInput.isEmpty()) {
        discountValue = 0;
    } else {
        try {
            discountValue = Integer.parseInt(discountInput);
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            discountValue = 0; // Or any other default value
        }
    }
    if (selectedItem == null) {
        // If no row is selected, display an error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please select an item to purchase.");
        alert.showAndWait();
        return;
    }

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
            // cse2.add(new items(s2[0], a, b));

        }

        reader.close();

    } catch (IOException e) {
        System.out.println(e);
    }


    // Update the stock value of the selected item in the observableList
    int selectedIndex = table_items.getSelectionModel().getSelectedIndex();
    // items updatedItem = new items(selectedItem.getItem_items(), selectedItem.getPrice_items(), selectedItem.getStock_items() - 1);

    int aa= (Integer.parseInt(price_field.getText()));
    aa=aa-((aa*discountValue)/100);
    count_bil+=aa;
    ObservableList<items> products;
    products = table_items.getSelectionModel().getSelectedItems();
    items p=products.get(0);
    int  update_price=products.get(0).getStock_items();
    String s1=p.getItem_items();
    int a1=p.getPrice_items();
    update_price=update_price-aa;

    if (update_price<0) {
        // If no row is selected, display an error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please sell the item less than the stock value");
        alert.showAndWait();
        return;
    }
    System.out.println("update price is      "+update_price);
    items updatedItem=new items(s1,a1,update_price);
    items products2=new items(s1,aa,33);
    table_bill.getItems().add(products2);
    today_total_bill.setText(Integer.toString(count_bil));









    //  items updatedItem = new items("ami", 55, 33);
    observableList.set(selectedIndex, updatedItem);

    // Create a new FilteredList based on the current TableView items
    FilteredList<items> filteredList = new FilteredList<>(observableList);

    // Set the filter predicate to only show items with non-zero stock
    filteredList.setPredicate(item -> item.getStock_items() > 0);

    // Create a new SortedList based on the filtered list
    SortedList<items> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(table_items.comparatorProperty());

    // Set the sorted and filtered list as the items in the TableView
    table_items.setItems(sortedList);

    // Refresh the TableView to reflect the updated values
    table_items.refresh();



















    item_items.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
    price_items.setCellValueFactory(new PropertyValueFactory<>("Price_items"));
    stock_items.setCellValueFactory(new PropertyValueFactory<>("Stock_items"));


    item_bill.setCellValueFactory(new PropertyValueFactory<>("Item_items"));
    price_bill.setCellValueFactory(new PropertyValueFactory<>("Price_items"));

    ObservableList<items> observableList2 = FXCollections.observableArrayList(
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
            observableList2.add(new items(s2[0], a, b));
            //cse2.add(new items(s2[0], a, b));

        }

        reader.close();

    } catch (IOException e) {
        System.out.println(e);
    }


    FilteredList<items> filteredList2 = new FilteredList<>(observableList2, b -> true);
    searchitem.textProperty().addListener((observable, oldValue, newValue) -> {

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
            // }
            else return false;


        });


    });

    SortedList<items> sortedList2 = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(table_items.comparatorProperty());














    table_items.setEditable(true);



    table_items.setItems(sortedList2);




}

//    @FXML
//    public void purchase(ActionEvent event) throws Exception{
//        // Get the selected row in the TableView
//        items selectedItem = table_items.getSelectionModel().getSelectedItem();
//
//
//        // Create a new items object with updated stock value
//       // items p5 = new items("dslfjdf",3,5);
//        items p5 = new items("dlfjdldff",555,555);
//
//        // Update the selected item with the new object
//        int selectedIndex = table_items.getSelectionModel().getSelectedIndex();
//       // table_items.getItems().set(selectedIndex, p5);
//
//        ObservableList<items> items5 = table_items.getItems();
//          // items5.set(selectedIndex, p5);
//        //selectedItem.setStock_items(selectedIndex - 1);
//        // Create a new FilteredList based on the current TableView items
////        FilteredList<items> filteredList = new FilteredList<>(table_items.getItems());
////
////        // Set the filter predicate to only show items with non-zero stock
////        filteredList.setPredicate(item -> item.getStock_items() > 0);
////
////        // Create a new SortedList based on the filtered list
////        SortedList<items> sortedList = new SortedList<>(filteredList);
////        sortedList.comparatorProperty().bind(table_items.comparatorProperty());
////
////        // Set the sorted and filtered list as the items in the TableView
////        table_items.setItems(sortedList);
////
////        // Refresh the TableView to reflect the updated values
//        table_items.refresh();
//    }

//    @FXML
//    public void purchase(ActionEvent event)throws Exception {
//        // Get the selected row in the TableView
//        items selectedItem = table_items.getSelectionModel().getSelectedItem();
////        if (selectedItem == null) {
////            // If no row is selected, display an error message
////            Alert alert = new Alert(Alert.AlertType.ERROR);
////            alert.setTitle("Error");
////            alert.setHeaderText(null);
////            alert.setContentText("Please select an item to purchase.");
////            alert.showAndWait();
////            return;
////        }
//
//        // Get the current stock value of the selected item
//        int currentStock = selectedItem.getStock_items();
////
//        // Update the stock value of the selected item
//        selectedItem.setStock_items(currentStock - 1);
//        int selectedIndex = table_items.getSelectionModel().getSelectedIndex();
//        ObservableList<items> items = table_items.getItems();
//        items p5=new items("dlfsdj",4,33);
//         // items.set(selectedIndex, p5);
//        //sortedList.set(selectedIndex,p5);
//        System.out.println(selectedIndex);
//
//        // Refresh the TableView to reflect the updated values
//        table_items.refresh();
//    }
//

//    public void purchase(ActionEvent event)throws Exception {
//
//
//        //cse_bill.add(new items())
//        int a= Integer.parseInt(price_field.getText());
//        count_bil+=a;
//      ObservableList<items> products;
//       products = table_items.getSelectionModel().getSelectedItems();
//       items p=products.get(0);
//      int  update_price=products.get(0).getStock_items();
//      String s1=p.getItem_items();
//      int a1=p.getPrice_items();
//       update_price=update_price-a;
//        System.out.println("update price is      "+update_price);
//        items p2=new items(s1,a1,update_price);
//    //   p.setStock_items(update_price);
//
//
//      // table_items.getItems().add(table_items.getSelectionModel().getSelectedIndex(),p);
//
//
////
////
//      String s=products.get(0).getItem_items();
//        System.out.println(s);
////
//   //  ObservableList<items> observableList = FXCollections.observableArrayList(
////                 new items(s, a,44)
////        );
//        items products2=new items(s,a,33);
//
//
//
////
//       table_bill.getItems().add(products2);
////        System.out.println(this_customer_shopping.getName());
//
//       today_total_bill.setText(Integer.toString(count_bil));
//
//        System.out.println(a);
//       // table_items.getItems().remove(table_items.getSelectionModel().getSelectedItems() );
//       // table_items.getItems().remove(table_items.getSelectionModel().getSelectedItems() );
//      //  table_items.getItems().add(p2);
//       // table_items.getItems().remove(table_items.getSelectionModel().getSelectedIndex() );
//        //table_items.getSelectionModel().getSelectedItems()=p2;
////        products.get(0).setStock_items(p2.getStock_items());
////        products.get(0).setPrice_items(p2.getPrice_items());
////        products.get(0).setItem_items(p2.getItem_items());
////        table_items.setSelectionModel(products.get(0));
//       // Button btn= purchase("purchase");// Button("amader");
//      //  Button btn=purchase();//new Button("purchase");
//
//
//
//        FilteredList<items> filteredList = new FilteredList<>(products, b -> true);
//        searchitem.textProperty().addListener((observable, oldValue, newValue) -> {
//
//            filteredList.setPredicate(employee -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowercasefilter = newValue.toLowerCase();
//                if (employee.getItem_items().toLowerCase().indexOf(lowercasefilter) != -1) {
//                    return true;
//                }
////                else if (employee.getName().toLowerCase().indexOf(lowercasefilter) != -1) {
////                    return true;
//                // }
//                else return false;
//
//
//            });
//
//
//        });
//        // Define a comparator to sort the TableView
//      //  Comparator<items> comparator = Comparator.comparing(items::getItem_items);
//
//        SortedList<items> sortedList = new SortedList<>(filteredList);
//        sortedList.comparatorProperty().bind(table_items.comparatorProperty());
//
//
//        table_items.setItems(sortedList);
//
//
//        int selectedIndex = table_items.getSelectionModel().getSelectedIndex();
//        if (selectedIndex != -1) {
//            ObservableList<items> items5 = table_items.getItems();
//            items5.set(selectedIndex, p2);
//            //table_items.refresh();
//            // Define a comparator to sort the TableView
//           // Comparator<items> comparator = Comparator.comparing(items::get);
//
//           // filteredList.getSource().sort(comparator);
//            table_items.getSelectionModel().select(selectedIndex);
//        }
//        ObservableList<items> observableList = FXCollections.observableArrayList(
//                // new items("ami", 22,44)
//        );
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects\\shopping\\items.txt"));
//            String line;
//
//            int count = 0;
//            while ((line = reader.readLine()) != null) {
//
//                String[] s2 = line.split("\\s+");
//                // System.out.println(s2[0]+"    "+s2[1]);
//                count++;
//
//                int a11 = Integer.parseInt(s2[1]);
//                int b = Integer.parseInt(s2[2]);
//                observableList.add(new items(s2[0], a11, b));
//               // cse2.add(new items(s2[0], a, b));
//
//            }
//
//            reader.close();
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//
//        table_items.setItems(observableList);
//
//
//  }


    public void cancel_item(){

        ObservableList<items> products;
        products = (ObservableList<items>) table_bill.getSelectionModel().getSelectedItems();
        int ab=products.get(0).getPrice_items();
        table_bill.getItems().remove(table_bill.getSelectionModel().getSelectedIndex());
       // table_bill.getItems().add(products.get(0));
       // table_bill.getItems().add(products.get(0));

        System.out.println(String.valueOf(ab));
        count_bil=count_bil-ab;
        today_total_bill.setText(Integer.toString(count_bil));







    }

    public void back_todayshopping(ActionEvent event)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("gotothisperson.fxml"));
        root = loader.load();
        thispersoncontroller tempee = loader.getController();
        tempee.start(this_customer_shopping); // Pass the string value

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    public void savetodaybill(){

                String date=new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss").format(Calendar.getInstance().getTime());
        System.out.println(date);
                cse2=table_items.getItems();
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\items.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
           // cse=table_view.getItems();
            int count=0;
            for(items s:cse2){
                //System.out.println(s);
                count++;
                writer.write(s.getItem_items()+"   "+s.getPrice_items()+"    "+s.getStock_items()  +"\n");
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

        deal_item dealItem=new deal_item(date,this_customer_shopping.getName(),this_customer_shopping.getPhone(),count_bil);

        System.out.println("today kinakata of this person all information is"+dealItem.getDate_deal()+" "+dealItem.getName_deal()+"  "+dealItem.getPhone_deal()  +" "+dealItem.getBill_deal());


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
               // observableList.add(new items(s2[0], a, b));
                cse4.add(new deal_item(s2[0],s2[1],s2[2],b));

            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }


        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\deal.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
            // cse=table_view.getItems();
            int count=0;
           for(deal_item ss:cse4){
                //System.out.println(s);
                count++;

               writer.write(ss.getDate_deal()+"   "+ss.getName_deal()+"  "+ss.getPhone_deal()+"   "+ss.getBill_deal()+"\n");
            }

            writer.write(dealItem.getDate_deal()+"   "+dealItem.getName_deal()+"    "+dealItem.getPhone_deal()  +"   "+dealItem.getBill_deal()+"\n");
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }







    }





































}