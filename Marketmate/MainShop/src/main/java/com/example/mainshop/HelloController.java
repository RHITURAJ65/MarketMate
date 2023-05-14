package com.example.mainshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

//    @FXML
//    private  ImageView sakibimage;
//    @FXML
//    private  ImageView rhituimage;
//    @FXML
//    private  ImageView nahinimage;

//    @FXML
//    private ImageView nahinimage;
//    @FXML
//    private ImageView sakibimage;
//    @FXML
//    private ImageView rhituimage;


//    Image rhitu=new Image(getClass().getResourceAsStream("F:\\banking\\newbankproject\\src\\rhitu.jpg"));
//    Image nahin=new Image(getClass().getResourceAsStream("F:\\banking\\newbankproject\\src\\nahin.png"));
//    Image sakib=new Image(getClass().getResourceAsStream("F:\\banking\\newbankproject\\src\\sakib.jpg"));
//    @FXML
//    rhituimage.setImage(rhitu);
//    @FXML
//    sakibimage.setImage(sakib);
//    @FXML
//    nahinimage.setImage(nahin);

@FXML
   TextField user_name;

@FXML
 TextField password;
@FXML
 Label test;
    public void ShowDashboard(ActionEvent event) throws  Exception{


       // if(user.hashCode()==testuser.hashCode()&&pass.hashCode()==pass2.hashCode()) {
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

    public void ShowLoginpage(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("loginpagae.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ShowMyBuisnessProfile(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("myprofile.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ShowStock(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("stockpage.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void ShowStaff(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("staff.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    public void ShowStaff(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("staffpage.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void ShowCustomer(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("customerpage.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ShowAbout(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("about.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void show_babsar_poristiti(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("dealpage.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updatepage(ActionEvent event) throws  Exception{
        Parent root= FXMLLoader.load(getClass().getResource("changup.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void updateback(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("myprofile.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }



//
//    public void switchto1(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("loginpagae.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void switchto2(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("About.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
////    public void usertologinpage(ActionEvent event) throws  Exception{
////        Parent root= FXMLLoader.load(getClass().getResource("loginpagae.fxml"));
////        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
////        scene=new Scene(root);
////        stage.setScene(scene);
////        stage.show();
////    }
//
//    public void gofirstpage(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("firstpage.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//    public void loginbutton(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("afterlogin.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void firstadmin(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("adminloginpage.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    public void depositbutton(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("depositstage.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    public void balancebutton(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("balancestage.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    public void withdrawbutton(ActionEvent event) throws  Exception{
//        Parent root= FXMLLoader.load(getClass().getResource("withdrawstage.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }





















//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }





//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }



    @FXML
    private  TextField latest_username;

    @FXML
    private  TextField latest_password;


    public void update(ActionEvent e) throws IOException{
        latest();
//        Parent root = FXMLLoader.load(getClass().getResource("myprofile.fxml"));
//        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }

    public void latest() throws IOException{
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\userpass.txt"));
            String a=latest_username.getText().toString();
            String b=latest_password.getText().toString();

            writer.write(a+"\n"+b);
            writer.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }








    //part2


    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;
    @FXML
    private Label wronglogin;
    @FXML
    private TextField newpassword;

    @FXML
    private TextField newusername;

//    @FXML
//    void cngup(MouseEvent event) {
//        x=newusername.getText();
//        y=newpassword.getText();
//    }


    String x,y;
    public void userlogin(ActionEvent event) throws IOException {
//        checklogin();
        HelloApplication m=new HelloApplication();
        try{
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Telegram Desktop\\shopping (3)\\shopping\\userpass.txt"));
            x= reader.readLine();
            y= reader.readLine();
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }
        if(username.getText().toString().equals(x) && pass.getText().toString().equals(y)){
            wronglogin.setText("Success");
//            m.changeScene("dashboard2.fxml");
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(username.getText().isEmpty() && pass.getText().isEmpty()){
//            wronglogin.setText("Please Enter Your Username And Password");
            Alert alert=new Alert(Alert.AlertType.WARNING);

//            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert with JavaFx");
            alert.setContentText("Please Enter Your Username And Password");
            alert.show();
        }
        else{
//            wronglogin.setText("Wrong username and password");
            Alert alert=new Alert(Alert.AlertType.WARNING);

//            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert with JavaFx");
            alert.setContentText("Wrong username and password");
            alert.show();
        }
    }
//    String x="qwe";
//    String y="qwe";


//    @FXML
//    private Button logoutbutton;
//
//    @FXML
//    private TextField newpassword;
//
//    @FXML
//    private TextField newusername;
//
////    @FXML
////    void changeup(MouseEvent event) {
////        x=newusername.getText();
////        y=newpassword.getText();
////    }
//
//    @FXML
//    public void changup(MouseEvent event) throws Exception{
//
//        x=newusername.getText();
//        y=newpassword.getText();
//
//
////        Main m=new Main();
////        m.changeScene("login.fxml");
//    }

//    String x;
//    String y;
//
//
//    public void checklogin() throws IOException{
//
//    }
}