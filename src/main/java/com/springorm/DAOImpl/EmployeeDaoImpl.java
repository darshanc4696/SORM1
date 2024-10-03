package com.springorm.DAOImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.enitity.Employee;
import com.springorm.interfaces.EmployeeDAO;

@Component
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private ArrayList<Employee> list;
	
	@Override
	public void insertEmployee(Employee e) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(e);
		session.getTransaction().commit();
		System.out.println("inserted succesfully");
	    
	}

	@Override
	public ArrayList<Employee> fetchAllEmployees() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		list = (ArrayList<Employee>) query.list();
		
		return list;
	}

	@Override
	public Employee fetchSpecificEmployee(int id) {
		
		Session session = sessionFactory.openSession();
		Employee e = session.get(Employee.class, id);
		
		return e;
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(emp);
		session.getTransaction().commit();
		System.err.println("updated");

	}

	@Override
	public void deleteEmployee(int id) {
		Session session = sessionFactory.openSession();
		Employee emp = session.get(Employee.class, id);
		session.beginTransaction();
		session.delete(emp);
		session.getTransaction().commit();
		System.out.println("deleted");
		
	}
	
	
	
	

}
