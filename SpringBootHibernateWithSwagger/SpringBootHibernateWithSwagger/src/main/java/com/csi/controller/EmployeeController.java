package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @GetMapping("/getAllData")
    public ResponseEntity<List<Employee>> getAllData(){
       return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyid/{empId}")
    public Employee getDataById(@PathVariable int empId){
        return employeeServiceImpl.getDataById(empId);
    }

    @GetMapping("/getdatabyemail/{empEmailId}")
    public Employee getDataByEmailId(@PathVariable String empEmailId){
        return employeeServiceImpl.getDataByEmail(empEmailId);
    }

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public Employee getDataByContactNumber(@PathVariable long empContactNumber){
        return employeeServiceImpl.getDataByContactNumber(empContactNumber);
    }
    @GetMapping("/filterdata/{empSalary}")
    public List<Employee> filterData(@PathVariable double empSalary){
        return  employeeServiceImpl.filterData(empSalary);
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public boolean signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return employeeServiceImpl.signIn(empEmailId,empPassword);
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody Employee employee){
        employeeServiceImpl.signUp(employee);
        return "Sign Up Done Successfully";
    }

    @PutMapping("/savebulkofdata")
    public String saveBulkOfData(@RequestBody List<Employee> employees){
        employeeServiceImpl.saveBulkOfData(employees);
        return  "Save Bulk Of Data Successfully.";
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public String deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return "Data Deleted Successfully.";
    }

    @DeleteMapping("/deletealldata")
    public String deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return "All Data Deleted Successfully";
    }
}
