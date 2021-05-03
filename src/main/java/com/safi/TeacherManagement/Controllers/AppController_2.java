package com.safi.TeacherManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safi.TeacherManagement.Models.Teacher;
import com.safi.TeacherManagement.Services.MethodContainer;

@RestController
public class AppController_2 {
	@Autowired
	MethodContainer container;
	
	@GetMapping("/addNew")
	public Teacher addNewTeacher(@RequestBody Teacher teacher) {
		return container.addNewTeacher(teacher);
	}
	
	@GetMapping(value="/details/{id}")
	public Teacher showOneTeacherDetails(@PathVariable("id") int tid) {
		return container.showOneTeacherDetails(tid);
	}
	
	@PostMapping(value="/remove/{id}")
	public String remove(@PathVariable("id") int tid) {
		return container.remove(tid);
	}
	
	@PostMapping(value="/showAll")
	public String showAllTeachers() {
		return container.showAllTeachers();
	}
	
	@PostMapping(value="/count")
	public String totalCount() {
		return container.totalCount();
	}
}
