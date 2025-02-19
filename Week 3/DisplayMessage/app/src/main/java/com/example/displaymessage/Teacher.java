package com.example.displaymessage;

public class Teacher extends Human {
    String jobTitle;
    String department;

    public Teacher(String name, String gender, String jobTitle, String department) {
        super(name, gender);
        this.jobTitle = jobTitle;
        this.department = department;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Department: " + department);
    }

    @Override
    public String getDetails() {
        return "Name: " + name + "\nGender: " + gender + "\nJob Title: " + jobTitle + "\nDepartment: " + department;
    }
}
