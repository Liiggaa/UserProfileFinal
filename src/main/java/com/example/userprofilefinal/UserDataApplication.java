package com.example.userprofilefinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDataApplication extends Application {
//    public Text userEmail;
//    public Text userName;
//    public Text nameInput1;
//    public Text emailInput1;
//    public Text userPhoneNumber;
//    public Text phoneNumberInput1;


    @Override

    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(UserDataApplication.class.getResource("user-registration-data.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 664, 502);

        stage.setTitle("User registration form:");

        stage.setScene(scene);

        stage.show();
    }


    public static void main(String[] args) {
        launch();

    }
}