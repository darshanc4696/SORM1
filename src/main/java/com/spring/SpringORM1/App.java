package com.spring.SpringORM1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.enitity.Employee;
import com.springorm.DAOImpl.EmployeeDaoImpl;

public class App {
  public static void main(String[] args) {
	  
	  ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("beans.xml");
	  
	  EmployeeDaoImpl edaoi = (EmployeeDaoImpl)cx.getBean("employeeDaoImpl");
	  Employee emp = (Employee)cx.getBean("employee");
	  
	  edaoi.insertEmployee(emp);
	  cx.close();
    
  }
}
