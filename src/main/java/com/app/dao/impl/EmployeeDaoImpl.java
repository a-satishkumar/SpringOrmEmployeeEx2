package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public void saveEmployee(Employee emp) {
		ht.save(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		ht.update(emp);
	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee e=new Employee();
		e.setEmpId(empId);
		ht.delete(e);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee e=ht.get(Employee.class,empId);
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=ht.loadAll(Employee.class);
		return list;
	}

}
