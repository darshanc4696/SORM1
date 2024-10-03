package com.springorm.interfaces;

import java.util.ArrayList;

import com.spring.enitity.Employee;

public interface EmployeeDAO {
	
	public void insertEmployee(Employee e);
	public ArrayList<Employee> fetchAllEmployees();
	public Employee fetchSpecificEmployee(int id);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int id);

}
