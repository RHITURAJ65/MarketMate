package com.example.mainshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class add_remove_controller {

    private Stage stage;
    private Scene scene;
    @FXML
    private TextField t_name;
    @FXML
    private TextField t_phone;
    List<product> cse=new ArrayList<product>() ;
    public void customer_start(ActionEvent event) throws Exception {

        String tname=t_name.getText();
        String tphone=t_phone.getText();

        try{
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
            // String line[]=new String[70];

            String line;

            int count=0;
            while((line= reader.readLine())!=null){
                  String[] s2 = line.split("\\s+");
                  count++;
                  cse.add(new product(count,s2[1],s2[2]));

            }

            reader.close();

        }

        catch(IOException e){
            System.out.println(e);
        }



        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
            // System.out.println(lost[0]);String s3=lost[0];
           // cse=table_view.getItems();
            int count1=0;
            for(product s:cse){
                //System.out.println(s);
                count1++;
                writer.write(count1+"   "+s.getName()+"   "+s.getPhone()+"\n");
            }
            count1++;
            writer.write((count1+"  "+tname+"    "+tphone));
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("customerpage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }












}
