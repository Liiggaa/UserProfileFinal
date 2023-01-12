package com.example.userprofilefinal;

import java.sql.*;

public class User {

    // Methods, which I didn't implemented in UserDataController

        public static void main(String[] args) {

            Connection conn = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_class_db", "root", "admin"); // assign conn new value

                //update(conn, "Elsa", "Doe", "elsadoe1@gmail.com", 28573689, "Brivibas 5, Riga, Latvia", "female", 30, "revdhnn555", "SantaDoe45");


                // logIn(conn, "gdft56jh", "TomSmith45");
                // logIn(conn, "34dhjrj", "JaneDoe65");
                // deleteUser(conn,20 );

            } catch (SQLException ex) {
                ex.printStackTrace();

            }


        }



        public static void update(Connection connection, String firstName, String lastName, String email, int phone, String address, String gender, int age, String password, String username) throws SQLException {

            PreparedStatement pStatement = connection.prepareStatement("UPDATE UserProfile SET first_name= ?, last_name= ?, e_mail= ?, phone= ?, address= ?, gender= ?, age= ?, username = CONCAT(first_name,last_name,RIGHT(phone,2)) WHERE username = " + "'" + username + "'" + " AND user_password= " + "'" + password + "'");

            pStatement.setString(1, firstName);
            pStatement.setString(2, lastName);
            pStatement.setString(3, email);
            pStatement.setInt(4, phone);
            pStatement.setString(5, address);
            pStatement.setString(6, gender);
            pStatement.setInt(7, age);

            pStatement.executeUpdate();

        }


        public static void logIn(Connection connection, String password, String username) throws SQLException {
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM userProfile WHERE username= " + "'" + username + "'" + " AND user_password= " + "'" + password + "'");

            while (resultSet.next()) {
                System.out.println("USER INFORMATION:");
                System.out.println("id: " + resultSet.getInt(1));
                System.out.println("first name: " + resultSet.getString(2));
                System.out.println("last name: " + resultSet.getString(3));
                System.out.println("email: " + resultSet.getString(4));
                System.out.println("phone: " + resultSet.getString(5));
                System.out.println("address: " + resultSet.getString(6));
                System.out.println("gender: " + resultSet.getString(7));
                System.out.println("age: " + resultSet.getInt(8));
                System.out.println("username: " + resultSet.getString(9));
                System.out.println("password: " + resultSet.getString(10));

            }

        }


        public static void deleteUser(Connection connection, int id) throws SQLException {

            PreparedStatement pStatement = connection.prepareStatement("DELETE FROM userProfile WHERE id="+id);

            pStatement.executeUpdate();

        }

    }




