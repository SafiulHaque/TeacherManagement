package com.safi.TeacherManagement.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
//	@Column(name="id")
	@GeneratedValue
	int tid;
	String name;
	int age;
	String subject;
	public int gettId() {
		return tid;
	}
	public void settId(int tId) {
		this.tid = tId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", age=" + age + ", subject=" + subject + "]";
	}
}
