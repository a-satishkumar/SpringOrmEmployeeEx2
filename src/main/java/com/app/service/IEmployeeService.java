package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {
	public void saveEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(Integer empId);
	public Employee getEmployeeById(Integer empId);
	public List<Employee> getAllEmployees();
}
