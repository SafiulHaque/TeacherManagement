package com.safi.TeacherManagement.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {
	@Id
	@SequenceGenerator(name="teacher_id_sequence",sequenceName="teacher_id_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="teacher_id_sequence")
	@Column(name="id",nullable=false,updatable=false)
	int tid;
	@Column(name="teacher_name",nullable=false)
	String name;
	@Column(name="age",nullable=false)
	int age;
	@Column(name="subject",nullable=false)
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
