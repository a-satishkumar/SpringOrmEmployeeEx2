package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private Double empSal;
	private String empDept;
	private String empPrjs;
	public Employee() {
		super();
	}
	
	
	public Employee(Integer empId, String empName, Double empSal, String empDept, String empPrjs) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDept = empDept;
		this.empPrjs = empPrjs;
	}


	public Employee(String empName, Double empSal, String empDept, String empPrjs) {
		super();
		this.empName = empName;
		this.empSal = empSal;
		this.empDept = empDept;
		this.empPrjs = empPrjs;
	}
	

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpPrjs() {
		return empPrjs;
	}

	public void setEmpPrjs(String empPrjs) {
		this.empPrjs = empPrjs;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empDept=" + empDept
				+ ", empPrjs=" + empPrjs + "]";
	}
	

}
