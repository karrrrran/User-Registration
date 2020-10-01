package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersDAO {
    private List<User> userList = new ArrayList<User>();
    Scanner sc = new Scanner(System.in);

    public void addUser(User user) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "karan", "1234");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("SELECT user_id FROM users ORDER BY user_id DESC LIMIT 1");
            int id = 0;
            while(rs.next()) {
                id = rs.getInt("user_id") + 1;
            }
            String insertInput = id + ", '" + user.getName() + "', '" + user.getEmailAddress() + "', '" + user.getPassword() + "', '" + user.getDateOfBirth() + "', '" + user.getGender() + "'";
            System.out.println(insertInput);
            myStmt.executeUpdate("INSERT INTO users " + "values(" + insertInput + ")");
            System.out.println("Insert Complete!");
            myStmt.close();
        }catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    public void removeUser(int id) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "karan", "1234");
            Statement myStmt = myConn.createStatement();
            String queryInput = "DELETE FROM users WHERE user_id = " + id;
            myStmt.executeUpdate(queryInput);
            System.out.println("User Removed!");
            myStmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void updateUser(int id) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "karan", "1234");
            Statement myStmt = myConn.createStatement();
            String query = "select * from users where user_id = " + id;
            ResultSet rs = myStmt.executeQuery(query);

            String oldPass = null;
            while(rs.next()) {
                oldPass = rs.getString("password");
            }
            System.out.println("Enter existing password for checking:");
            String pass = sc.nextLine();
            if(pass.equals(oldPass)) {
                System.out.println("Password checked! Update email address:");
                String newEmail = sc.nextLine();
                String queryInput = "UPDATE users set emailAddress = '" + newEmail + "' WHERE user_id = " + id;
                myStmt.executeUpdate(queryInput);
            } else {
                System.out.println("Type correct password!");
            }
            myStmt.close();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println("User updated!");
    }

    public void printUsers() {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "karan", "1234");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select * from users");

            System.out.println("Users:");

            while(rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("emailAddress");
                String dob = rs.getString("dateOfBirth");
                String gender = rs.getString("gender");
                System.out.format("%s, %s, %s, %s, %s\n", userId, name, email, dob, gender);
            }
            myStmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

//   CRUD
//Add method     -   Create
//Print Contacts   - Retreive
//Update           - Update
//Remove contact   - Delete