package com.company;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    private List<User> userList = new ArrayList<User>();

    public void addUser(User user) {
        userList.add(user);
    }

    // remove contact by name
    public void removeUser(User u) {
        User removed = null;
        for(User user : userList) {
            if(user.equals(u)) {
                removed = user;
            }
        }
        System.out.println("User " + removed.getName() + " has been removed.");
        userList.remove(removed);
    }

    public void updateUser(User u, String emailAddress, String password, String name, String dateOfBirth, String gender) {
        for(User user : userList){
            if(user.equals(u)){
                user.setEmailAddress(emailAddress);
                user.setPassword(password);
                user.setName(name);
                user.setDateOfBirth(dateOfBirth);
                user.setGender(gender);
            }
        }
        System.out.println("User updated!");
    }

    public User getUserNumber(int number) {
        User selected = null;
        int i = 1;
        for(User user : userList) {
            if(i == number) {
                selected = user;
                break;
            }
            i++;
        }
        return selected;
    }

    public void printUsers() {
        if(userList.size() == 0){
            System.out.println("No users present");
        }
        int i = 1;
        System.out.println("Users:- ");
        for(User user : userList) {
            System.out.println(i + " " + user.getName());
            i++;
        }
    }
}

//   CRUD
//Add method     -   Create
//Print Contacts   - Retreive
//Update           - Update
//Remove contact   - Delete