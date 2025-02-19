package com.example.displaymessage;

public class Human {
    String name;
    String gender;

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
    }

    public String getDetails() {
        return "Name: " + name + "\nGender: " + gender;
    }
}
