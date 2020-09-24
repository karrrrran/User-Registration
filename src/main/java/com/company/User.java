package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String emailAddress;
    private String password;
    private String name;
    private String dateOfBirth;
    private String gender;

    public User() {
        super();
        this.emailAddress = null;
        this.password = null;
        this.name = null;
        this.dateOfBirth = null;
        this.gender = null;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Boolean setEmailAddress(String email) {
        String email_pattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(email_pattern)){
            this.emailAddress = email;
            return true;
        } else {
            System.out.println("Enter a valid email address.");
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public Boolean setPassword(String password) {
        if(password.length() >= 6) {
            this.password = password;
            return true;
        } else {
            System.out.println("Enter a valid Password {Must be six or more characters.}");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public Boolean setName(String first) {
        if(first != null && first.length() > 0) {
            this.name = first;
            return true;
        }
        else {
            System.out.println("Enter a valid name.");
            return false;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean setDateOfBirth(String dob) {
        String regex = "^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher((CharSequence)dob);

        if(mat.matches()) {
            this.dateOfBirth = dob;
            return true;
        } else {
            System.out.println("Enter a valid date of birth. {mm/dd/yyyy}");
            return false;
        }
    }

    public String getGender() {
        return gender;
    }

    public Boolean setGender(String gender) {
        if(gender.equals("m") || gender.equals("M") || gender.equals("male") || gender.equals("Male")) {
            this.gender = "Male";
            return true;
        } else if(gender.equals("f") || gender.equals("F") || gender.equals("female") || gender.equals("Female")) {
            this.gender = "Female";
            return true;
        }
        else {
            System.out.println("Enter a valid gender");
            return false;
        }
    }
}
