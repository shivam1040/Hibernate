package com.hibernate2;
import javax.persistence.Cacheable;
// this demo is for showing hibernate lifecycle/object status
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Entity(name="studentDetails") //to be used when we need to custom name the entity
@Entity //this tag enables hibernate to treat this class as entity or table
//@Table(name="MyStudent") //this will create db table by the name of MyStudent not Student
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) //enables read only type second level caching
public class Student1 {
	@Id //this will treat id var as primary key
	private int id;
	private String name, city;
	private CertificateRefrenceInsert certi;
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student1(int id, String name, String city, CertificateRefrenceInsert certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi=certi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}
	
	
}
