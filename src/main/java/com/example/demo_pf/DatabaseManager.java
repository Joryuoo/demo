package com.example.demo_pf;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_pf";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static DatabaseManager instance;
    private DatabaseManager(){

    }

    public static DatabaseManager getInstance(){
        if(instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }

    public int search(String username){
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username=?")) {

            statement.setString(1, username); // ✅ Set parameter BEFORE query

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }

        } catch (SQLException e) {
            System.out.println("User does not exist");
        }
        return -1;
    }


    //returns 1 if teacher, 0 if student, and -1 if invalid password
    public int verifyUser(String username, String password){
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("User authenticated: " + resultSet.getString("username"));
                    boolean isTeacher = resultSet.getBoolean("isteacher");
                    String fname = resultSet.getString("fname");
                    String lname = resultSet.getString("lname");
                    System.out.println("Welcome " + (isTeacher ? "teacher" : "student"));

                    SessionUser.getInstance().setLogged_in_user(new User(username, password, fname, lname, isTeacher));
                    return isTeacher ? 1 : 0;
                } else {
                    System.out.println("Invalid credentials.");
                    return -1;
                }
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("User does not exist");
        }
        return -1;
    }
}
