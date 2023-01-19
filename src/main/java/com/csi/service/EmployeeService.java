package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void signUp(Employee employee);
    public boolean signIn(String empEmailId, String empPassword);
    public void saveBulkOfData(List<Employee> employee);
    public Employee getDataById(int empId);
    public Employee getDataByEmail(String empEmailId);
    public Employee getDataByContactNumber(long empContactNumber);

    public Employee getDataBySalary(double empSalary);
    public List<Employee> getAllData();
    public List<Employee> filterData(double empSalary);
    public void updateData(int empId, Employee employee);
    public void deleteDataById(int empId);
    public void deleteAllData();
}
