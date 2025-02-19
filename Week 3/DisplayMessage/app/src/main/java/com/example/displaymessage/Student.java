package com.example.displaymessage;

public class Student extends Human {
    String major;
    String level;

    public Student(String name, String gender, String major, String level) {
        super(name, gender);
        this.major = major;
        this.level = level;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Major: " + major);
        System.out.println("Level: " + level);
    }

    @Override
    public String getDetails() {
        return "Name: " + name + "\nGender: " + gender + "\nMajor: " + major + "\nLevel: " + level;
    }
}
