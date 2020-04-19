package com.emp.services;

import java.util.List;

import com.emp.dao.Employee;

public interface EmployeeInterface
{
   public abstract void addEmployee(Employee employee);
   public abstract void deleteEmployee(Integer employeeCode);
   public abstract Employee getEmployee(Integer employeeCode);
   public abstract List<Employee> listEmployee();
   
}
