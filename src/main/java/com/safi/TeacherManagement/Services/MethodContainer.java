package com.safi.TeacherManagement.Services;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement.Models.Teacher;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface MethodContainer {
	
	public Teacher addNewTeacher(@RequestBody Teacher teacher);
	
	public Teacher showOneTeacherDetails(@PathVariable("id") int tid);
	
	public String remove(@PathVariable("id") int tid);
	
	public String showAllTeachers();
	
	public String totalCount();
}
