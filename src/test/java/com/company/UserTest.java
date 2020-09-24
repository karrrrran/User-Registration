package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user = new User();     // Create a User object to test

    // Testing SetEmailAddress
    // Testing SetPassword
    // Testing SetName
    // Testing SetDateOfBirth
    // Testing SetGender

    @Test
    public void testSetEmailAddress() {
        System.out.println("-------------***************-------------***************----------------------");
        System.out.println("Testing 'setEmailAddress' method from 'User' class:");
        Boolean answer = user.setEmailAddress("karan@yahoo.com");
        assertEquals(true, answer);
        System.out.println("[Input] 'karan@yahoo.com'");
        System.out.println("[Output] " + answer);
        System.out.println("[Expected] true");
        System.out.println("---------------------");
        System.out.println("[Result] PASSED");
    }

    @Test
    public void testSetPassword() {
        System.out.println("-------------***************-------------***************----------------------");
        System.out.println("#Testing 'setPassword' method from 'User' class:");
        Boolean answer = user.setPassword("hellohunter");
        assertEquals(true, answer);
        System.out.println("[Input] 'hellohunter'");
        System.out.println("[Output] " + answer);
        System.out.println("[Expected] true");
        System.out.println("----------------------");
        System.out.println("[Result] PASSED");
    }

    @Test
    public void testSetName() {
        System.out.println("-------------***************-------------***************----------------------");
        System.out.println("#Testing 'setName' method from 'User' class:");
        Boolean answer = user.setName("Megan");
        assertEquals(true, answer);
        System.out.println("[Input] 'Megan'");
        System.out.println("[Output] " + answer);
        System.out.println("[Expected] true");
        System.out.println("-----------------------");
        System.out.println("[Result] PASSED");
    }

    @Test
    public void testSetDateOfBirth() {
        System.out.println("-------------***************-------------***************----------------------");
        System.out.println("#Testing 'setDateOfBirth' method from 'User' class:");
        Boolean answer = user.setDateOfBirth("06/03/1996");
        assertEquals(true, answer);
        System.out.println("[Input] '06/03/1996'");
        System.out.println("[Output] " + answer);
        System.out.println("[Expected] true");
        System.out.println("------------------------");
        System.out.println("[Result] PASSED");
    }

    @Test
    public void testSetGender() {
        System.out.println("-------------***************-------------***************----------------------");
        System.out.println("#Testing 'setGender' method from 'User' class:");
        Boolean answer = user.setGender("male");
        assertEquals(true, answer);
        System.out.println("[Input] 'male'");
        System.out.println("[Output] " + answer);
        System.out.println("[Expected] true");
        System.out.println("-------------------------");
        System.out.println("[Result] PASSED");
    }
}
