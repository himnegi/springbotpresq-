package com.employecrud.employetable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "employe")
public class EmployeEntity {
	@Id
	
	private Integer employe_id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	
	
	 public EmployeEntity() {
		  
	    }



	public EmployeEntity(Integer employe_id, String name, String location) {
		super();
		this.employe_id = employe_id;
		this.name = name;
		this.location = location;
	}



	public Integer getEmploye_id() {
		return employe_id;
	}



	public void setEmploye_id(Integer employe_id) {
		this.employe_id = employe_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return "EmployeEntity [employe_id=" + employe_id + ", name=" + name + ", location=" + location + "]";
	}
	
	
	

}
