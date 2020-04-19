package com.emp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.struts2.ServletActionContext;

import com.emp.dao.Employee;
import com.emp.services.impl.EmployeeImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee>
{

	private Employee employee = new Employee();
	private List<Employee> employeeList = new ArrayList<Employee>();
	private EmployeeImpl employeeImpl = new EmployeeImpl();;

	public Employee getModel()
	{
		return employee;
	}

	public String addOrUpdateEmployee()
	{
		employeeImpl.addEmployee(getEmployee());
		return SUCCESS;
	}

	public String updateEmployee()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		employee = employeeImpl.getEmployee(new Integer(request
				.getParameter("serialNo")));
		return SUCCESS;
	}

	public String deleteEmployee()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		employeeImpl.deleteEmployee(new Integer(request
				.getParameter("serialNo")));
		return "success";
	}

	public String employeeList()
	{
		employeeList = employeeImpl.listEmployee();
		return "success";
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public List<Employee> getEmployeeList()
	{
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}

}
