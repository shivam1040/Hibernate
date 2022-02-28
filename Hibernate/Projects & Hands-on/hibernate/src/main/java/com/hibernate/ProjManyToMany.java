package com.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;

@Entity
public class ProjManyToMany {
	@Id
	private int pId;
	private String name;
	@ManyToMany(mappedBy = "projManyToMany", fetch = FetchType.EAGER) //fetch type can be set to requirements, and by default type is LAZY
	private List<EmpManyToMany> empManyToMany;
	public ProjManyToMany() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjManyToMany(int pId, String name) {
		super();
		this.pId = pId;
		this.name = name;
	}
	public List<EmpManyToMany> getEmpManyToMany() {
		return empManyToMany;
	}
	public void setEmpManyToMany(List<EmpManyToMany> empManyToMany) {
		this.empManyToMany = empManyToMany;
	}
	
	
}
