package com.springorm.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.enitity.Employee;
import com.springorm.interfaces.EmployeeDAO;

@Component
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertEmployee(Employee e) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(e);
		session.getTransaction().commit();
		System.out.println("inserted succesfully");
	    
	}
	
	public void print()
	{
		System.out.println(sessionFactory);
	}
	
	

}
