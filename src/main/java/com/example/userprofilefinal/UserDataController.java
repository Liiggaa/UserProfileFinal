package com.example.userprofilefinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;

public class UserDataController {
    Alert alert;

    String firstName;

    String lastName;

    String email;

    Integer phone;

    String address;

    String gender;

    Integer age;

    String password;

    Integer id = 0;


    @FXML
    private TextField addressInput;

    @FXML
    private TextField ageInput;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField genderInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField phoneNumberInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Text addressText;

    @FXML
    private Text ageText;

    @FXML
    private Text emailText;

    @FXML
    private Text firstNameText;

    @FXML
    private Text genderText;

    @FXML
    private Text lastNameText;

    @FXML
    private Text passwordText;

    @FXML
    private Text phoneNumberText;

    @FXML
    private Text usernameText;


    @FXML
    void signUp(ActionEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide(); // close active window (scene)
        showSignUpWindow();
    }

    @FXML
      void cancel(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();

        // show first window user registration form

    }


    @FXML
    void login(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        showUserProfile();

    }


    public void showSignUpWindow () throws IOException { // display new window
        FXMLLoader fxmlLoader = new FXMLLoader(UserDataApplication.class.getResource("sign-up-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage userLoginStage = new Stage();

        userLoginStage.setTitle("User login");
        userLoginStage.setScene(scene);
        userLoginStage.show();


    }

    public void showUserProfile () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserDataApplication.class.getResource("user-profile.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage userProfileStage = new Stage();

        userProfileStage.setTitle("User profile");
        userProfileStage.setScene(scene);
        userProfileStage.show();

    }

    @FXML
   void updateProfile(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Account updated!");
        alert.show();
    }

    @FXML
    void deleteAccount(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Account deleted successful!");
        alert.show();

    }


    @FXML
    void onButtonClick(ActionEvent event) throws IOException {
        if (nameInput.getText().isEmpty()
                || lastNameInput.getText().isEmpty()
                || emailInput.getText().isEmpty()
                || phoneNumberInput.getText().isEmpty()
                || addressInput.getText().isEmpty()
                || genderInput.getText().isEmpty()
                || ageInput.getText().isEmpty()
                || passwordInput.getText().isEmpty())
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please, fill all fields!");
            alert.show();
        } else {

            addUserData();


                // get text from user input and set to text fields NOT working!
//            firstNameText.setText(nameInput.getText());
//            lastNameText.setText(lastNameInput.getText());
//            emailText.setText(emailInput.getText());
//            phoneNumberText.setText(phoneNumberInput.getText());
//            addressText.setText(addressInput.getText());
//            genderText.setText(genderInput.getText());
//            ageText.setText(ageInput.getText());




            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Thank you! \nRegistration was successful!");
            alert.show();

            ((Node) event.getSource()).getScene().getWindow().hide();

            showUserProfile();
        }

    }


    public void addUserData() {

        firstName = nameInput.getText();
        lastName = lastNameInput.getText();
        email = emailInput.getText();
        phone = Integer.valueOf(phoneNumberInput.getText());
        address= addressInput.getText();
        gender = genderInput.getText();
        age = Integer.valueOf(ageInput.getText());
        password = passwordInput.getText();

       // id ++;



        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_class_db", "root", "admin");


            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO UserProfile (first_name, last_name, e_mail, phone, address, gender, age, user_password, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?,"+"null )");

            pStmt.setString(1, firstName);
            pStmt.setString(2, lastName);
            pStmt.setString(3, email);
            pStmt.setInt(4, phone);
            pStmt.setString(5,address);
            pStmt.setString(6, gender);
            pStmt.setInt(7, age);
            pStmt.setString(8, password);


            pStmt.executeUpdate();



            // PreparedStatement pStmt = conn.prepareStatement("INSERT INTO UserProfile VALUES(?, ?, ?, ?, ?, ?, ?, ?,"+"null )");

//            pStmt.setInt(1, id);
//            pStmt.setString(2, firstName);
//            pStmt.setString(3, lastName);
//            pStmt.setString(4, email);
//            pStmt.setInt(5, phone);
//            pStmt.setString(6,address);
//            pStmt.setString(7, gender);
//            pStmt.setInt(8, age);
//            pStmt.setString(9, password);





        } catch (SQLException ex){
            ex.printStackTrace();

        }
    }
}



