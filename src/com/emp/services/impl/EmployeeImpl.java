package com.emp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.emp.dao.Employee;
import com.emp.services.EmployeeInterface;

public class EmployeeImpl implements EmployeeInterface
{
    
	public void addEmployee(Employee employee)
	{
		Session session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
	}

	public void deleteEmployee(Integer serialNo)
	{
		Session session = getSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, serialNo);
		System.out.println("Deleting Employee with Employee Code:"+employee.getEmployeeCode());
		getSession().delete(employee);
		getSession().getTransaction().commit();

	}

	public Employee getEmployee(Integer serialNo)
	{

		Session session = getSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, serialNo);
		session.getTransaction().commit();
		System.out.println("Employee Code :"+employee.getEmployeeCode());
		return employee;

	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee()
	{
		List<Employee> empList = new ArrayList<Employee>();
		Session session = getSession();
		session.beginTransaction();
		empList = session.createQuery("from com.emp.dao.Employee").list();
		session.getTransaction().commit();
		return empList;
	}

	public static Session getSession()
	{
		System.out.println("........getting current Sesion.....");
		
		return MySessionFactory.getSessionFactory().getCurrentSession();
	}

}
