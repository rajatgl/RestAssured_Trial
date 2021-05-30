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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
