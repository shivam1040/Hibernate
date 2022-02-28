package com.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EmpManyToMany {
	@Id
	private int eId;
	private String name;
	@ManyToMany
	@JoinTable(name="maps", joinColumns = {@JoinColumn(name="A")}, inverseJoinColumns = {@JoinColumn(name="B")}) //in this annotation the name of table created by fk changes to map, the first field of map tab changes to A and second field changes to B
	private List<ProjManyToMany> projManyToMany;
	public EmpManyToMany() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpManyToMany(int eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}
	public List<ProjManyToMany> getProjManyToMany() {
		return projManyToMany;
	}
	public void setProjManyToMany(List<ProjManyToMany> projManyToMany) {
		this.projManyToMany = projManyToMany;
	}
	
	
}
