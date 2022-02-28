package com.hibernate2;

import javax.persistence.Embeddable;

@Embeddable //this enables adding of refrences in database table Student
public class CertificateRefrenceInsert {
	private String course;
	private String duration;
	public CertificateRefrenceInsert(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "CertificateRefrenceInsert [course=" + course + ", duration=" + duration + "]";
	}
	public CertificateRefrenceInsert() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
