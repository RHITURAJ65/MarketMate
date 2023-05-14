package com.example.mainshop;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// public class thispersoncontroller {
//    @FXML
//   private  Label namelabel;
//
//    List<product> cse=new ArrayList<product>() ;
//
//    String s1;
//
//    public void start(String akon){
//       // System.out.println("i am talking from thispersoncontroller class");
//      //  System.out.println(akon.getName());
//        namelabel.setText(akon);
//    }





//     public void remove(){
//
//
//
//        int count=0;
//        try{
//            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects\\shopping\\input.txt"));
//            // String line[]=new String[70];
//
//            String line;
//
//            //int count=0;
//            while((line= reader.readLine())!=null){
//                String[] s2 = line.split("\\s+");
//                cse.add(new product(s2[0],s2[1]));
//                count++;
//
//            }
//
//            reader.close();
//
//        }
//
//        catch(IOException e){
//            System.out.println(e);
//        }
//
//        try{
//            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\shopping\\input.txt"));
//            // System.out.println(lost[0]);String s3=lost[0];
//            // cse=table_view.getItems();
//            for(product s:cse){
//                //System.out.println(s);
//                if(temp.getName()==s.getName()){
//                    continue;
//                }
//                writer.write(s.getName()+"   "+s.getPhone()+"\n");
//            }
//           // writer.write((tname+"    "+tphone));
//            writer.close();
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//    }





















//}
public class thispersoncontroller {

    @FXML
    private Label namelabel;
     product this_customer;
    public String amar;
    List<product> cse=new ArrayList<product>() ;
    Stage stage;
    Scene scene;
    private Parent root;



    // Other code ...

    public void start(product temp) {
        this_customer=temp;
amar="fdslfd";

        namelabel.setText("Your Name Is : "+ this_customer.getName()+"  And Your Phone Number Is : "+temp.getPhone());



    }



     public void remove(ActionEvent event)throws Exception{
         //System.out.println(this_customer.getName());


        int count=0;
        try{
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\input.txt"));
            // String line[]=new String[70];

            String line;

            int count1=0;
            while((line= reader.readLine())!=null){

                count1++;
                String[] s2 = line.split("\\s+");
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
           // Iterator<product>it= cse.iterator();


            for(int i=cse.size()-1;i>=0;i--){

               // System.out.println(cse.get(i).getName());

                if(cse.get(i).getName().equals(this_customer.getName())){

                    System.out.println("the removal account name is: "+cse.get(i).getName()+"  and your phone number is "+ cse.get(i).getPhone());
                    cse.remove(i);

                }

            }
            int count2=0;

            for(product s:cse){
                //System.out.println(s);
                count2++;
                writer.write(count2+"   "+s.getName()+"   "+s.getPhone()+"\n");
            }
//            while(it.hasNext()){
//                product temp=it.next();
//                if(temp.getName()==this_customer.getName()){
//                    it.next();
//                }
//                else{
//                    writer.write(temp.getName()+"   "+temp.getPhone()+"\n");
//            }
//            }



           // writer.write((tname+"    "+tphone));
            writer.close();
        }
        catch(IOException e){
            System.out.println(e);
        }


         Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("customerpage.fxml"));
         this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         this.scene = new Scene(root);
         this.stage.setScene(this.scene);
         this.stage.show();











    }
    public void todayshoppingbutton(ActionEvent event)throws Exception{


        FXMLLoader loader = new FXMLLoader(getClass().getResource("todayshoppingpage.fxml"));
        root = loader.load();
        thispersoncontroller tempee = loader.getController();
        tempee.start(this_customer); // Pass the string value

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
  public  void back_thispersoncontroller(ActionEvent event)throws  Exception{
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("customerpage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }









    // Other code ...
}

