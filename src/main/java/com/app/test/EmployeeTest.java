package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.AppConfig;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		IEmployeeService service=ac.getBean("employeeServiceImpl", IEmployeeService.class);
		//insert
		
		/*
		 * service.saveEmployee(new Employee(1,"A",1.2,"D1","P1"));
		 * service.saveEmployee(new Employee(2,"B",2.2,"D2","P2"));
		 * service.saveEmployee(new Employee(3,"C",3.2,"D3","P3"));
		 * service.saveEmployee(new Employee(4,"D",4.2,"D4","P4"));
		 * service.saveEmployee(new Employee(5,"E",5.2,"D5","P5"));
		 * service.saveEmployee(new Employee(6,"F",6.2,"D6","P6"));
		 */
		 
		
		//fetchAll
		service.getAllEmployees().forEach(System.out::println);
		
		//fetchById
		Employee e=service.getEmployeeById(6);
		System.out.println(e);
		
		//update
		//service.updateEmployee(new Employee(6,"G",6.2,"D6","P7"));

		//delete
		service.deleteEmployee(6);
	}

}
