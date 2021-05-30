package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> payroll;

    public EmployeeService(List<Employee> list) {
        this.payroll = new ArrayList<Employee>(list);
    }

    public int countEntries(){
        return payroll.size();
    }

    public void addEntryIntoPayroll(Employee employee){
        payroll.add(employee);
    }
}
