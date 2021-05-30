package com.bridgelabz.employeepayroll.entity;

public class Employee {
    String name;
    Double salary;
    String gender;

    public Employee(String name, Double salary, String gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
