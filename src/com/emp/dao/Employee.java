package com.emp.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "EMPLOYEE_INFO")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name = "EMPLOYEE_INFO")
public class Employee
{

	

	@Id
	@GenericGenerator(name = "myGenerator", strategy = "hilo")
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.AUTO)
	@Column(name = "SERIAL_NO", nullable = false)
	private Integer serialNo;

	@Column(name = "EMPLOYEE_CODE")
	private Integer employeeCode;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "DATEOFJOINING")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	@Column(name = "MANAGER_NAME")
	private String managerName;
	@Column(name = "DEPARTMENT")
	private String department;
	public Integer getEmployeeCode()
	{
		return employeeCode;
	}

	public void setEmployeeCode(Integer employeeCode)
	{
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	public Date getDateOfJoining()
	{
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining)
	{
		this.dateOfJoining = dateOfJoining;
	}

	public String getManagerName()
	{
		return managerName;
	}

	public void setManagerName(String managerName)
	{
		this.managerName = managerName;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	/**
	 * @return the serialNo
	 */
	public Integer getSerialNo()
	{
		return serialNo;
	}

	/**
	 * @param serialNo the serialNo to set
	 */
	public void setSerialNo(Integer serialNo)
	{
		this.serialNo = serialNo;
	}


}
