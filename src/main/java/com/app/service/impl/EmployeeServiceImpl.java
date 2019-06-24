package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	@Override
	@Transactional
	public void saveEmployee(Employee emp) {
		dao.saveEmployee(emp);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer empId) {
		dao.deleteEmployee(empId);
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getEmployeeById(Integer empId) {
		return dao.getEmployeeById(empId);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
