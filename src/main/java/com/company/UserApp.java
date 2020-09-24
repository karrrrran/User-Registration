package com.company;

import java.util.Scanner;

public class UserApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        UsersDAO usrdao = new UsersDAO();

        while(!quit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add New User");
            System.out.println("2. Display all users");
            System.out.println("3. Remove a user");
            System.out.println("4. Quit");
            int option = sc.nextInt();

            if(option == 1) {
                User user = new User();
                signup(user, usrdao);
            }
            else if(option == 2) {
                usrdao.printUsers();
            }
            else if(option == 3) {
                System.out.println("Select a user number you want to remove from the display list:");
                usrdao.printUsers();
                int select = sc.nextInt();
                usrdao.removeUser(usrdao.getUserNumber(select));
            }
            else if(option == 4) {
                System.out.println("Logged out!");
                quit = true;
            }
            else
                System.out.println("Enter a valid number from the list");
        }
    }


    public static void signup(User user, UsersDAO usersDAO) {
        System.out.println("SIGN UP PAGE");
        System.out.println("Enter your information.");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        while(user.getEmailAddress() == null) {
            String input = sc.nextLine();
            user.setEmailAddress(input);
        }

        System.out.println("Enter a password more than 6 characters long: ");
        while(user.getPassword() == null) {
            String input = sc.nextLine();
            user.setPassword(input);
        }

        System.out.print("Enter your Name: ");
        while(user.getName() == null) {
            String input = sc.nextLine();
            user.setName(input);
        }

        System.out.println("Enter your date of birth: ");
        while(user.getDateOfBirth() == null) {
            String input = sc.nextLine();
            user.setDateOfBirth(input);
        }

        System.out.println("Enter your gender: ");
        while(user.getGender() == null) {
            String input = sc.nextLine();
            user.setGender(input);
        }

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Added the User:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmailAddress());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Date of Birth: " + user.getDateOfBirth());
        System.out.println("Gender: " + user.getGender());
        System.out.println("----------------------------------------");
        usersDAO.addUser(user);
    }
}
