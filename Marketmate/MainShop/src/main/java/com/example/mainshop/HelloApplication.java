package com.example.mainshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override

    public void start(Stage stage){
        stage.setTitle("Market Mate");

        try{
            Parent root= FXMLLoader.load(getClass().getResource("loginpagae.fxml"));

            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


//thank you very much  ,,i use java fx, and one object help me much ,,that is chatgpt!!!!!!!!!!!!!!!!!!!!!!!!!!!1


//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        launch();

    }
}