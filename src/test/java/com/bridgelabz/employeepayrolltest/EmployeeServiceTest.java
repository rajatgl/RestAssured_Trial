package com.bridgelabz.employeepayrolltest;

import com.bridgelabz.employeepayroll.entity.Employee;
import com.bridgelabz.employeepayroll.service.EmployeeService;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeServiceTest {

    @Before
    public void setup() {
        baseURI ="http://localhost";
        port = 3000;
    }

    public Employee[] getEmployeeList() {
        Response response = get("/Payroll");
        System.out.println("Payroll Data in JsonServer: "+response.asString());
        Employee[] empArray = new Gson().fromJson(response.asString(),Employee[].class);
        return empArray;
    }

    @Test
    public void givenPayrollData_whenRetrieved_shouldMatchTheCount() {
        Employee[] empArray = getEmployeeList();
        EmployeeService payrollservice = new EmployeeService(Arrays.asList(empArray));
        int entries = payrollservice.countEntries();
        assertEquals(6, entries);
    }

    public Response addEmployee(Employee employee) {
        String empJson = new Gson().toJson(employee);
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        System.out.println(empJson);
        request.body(empJson);
        return request.post("/Payroll");
    }

    @Test
    public void givenNewPayrollRecord_whenAdded_shouldReturn201statusCode() {
        Employee[] empArray = getEmployeeList();
        EmployeeService employeeService = new EmployeeService(Arrays.asList(empArray));

        Employee employee = new Employee("Rajat",50000.00,"M");

        Response response = addEmployee(employee);
        System.out.println(response.asString());
        int statusCode = response.getStatusCode();
        assertEquals(201, statusCode);

        employee = new Gson().fromJson(response.asString(), Employee.class);
        employeeService.addEntryIntoPayroll(employee);
        int entries = employeeService.countEntries();
        assertEquals(6, entries);

    }
}
