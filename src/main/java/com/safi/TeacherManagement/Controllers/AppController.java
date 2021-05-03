package com.safi.TeacherManagement.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.safi.TeacherManagement.Models.Teacher;
import com.safi.TeacherManagement.Repositories.TeacherRepository;

@RestController
public class AppController {
	@Autowired
	TeacherRepository repo;
	
	@RequestMapping("/add")
//	@ResponseBody
	public String addTeacher(Model model) {
	//	System.out.println(repo.getHighestId());
		int highest_id=repo.getHighestId();
		System.out.println("Highest Id => "+highest_id);
		model.addAttribute("id",(highest_id+1));
		return "AddTeacher";
	}
	
	@RequestMapping(value="/addNew",method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces="application/json")
	public 
//	String 
	Teacher addNewTeacher(@RequestBody Teacher teacher
		//	,Model model
			) {
		repo.save(teacher);
		int highest_id=repo.getHighestId();
		System.out.println("Highest Id => "+highest_id);
	//	model.addAttribute("id",(highest_id+1));
	//	return "AddTeacher";
		return teacher;
	}
	
	@RequestMapping("/one")
	public String oneTeacher() {
		return "ShowOneDetails";
	}
	
	@RequestMapping(value="/details/{id}",method=RequestMethod.GET,produces="application/json")
//	@ResponseBody
	public 
//	ModelAndView 
//	String
	Teacher
	showOneTeacherDetails(//@RequestParam 
			@PathVariable("id") int tid
			//,Model model
			) {
	//	ModelAndView mv=new ModelAndView("Details.jsp");
		Teacher teacher=repo.findById(tid).orElse(new Teacher());
		/*
		 * System.out.println("Teacher => "+teacher.getName());
		 * mv.setViewName("Details.jsp"); System.out.println("mv => "+mv);
		 * System.out.println("mv View Name => "+mv.getViewName());
		 * mv.addObject(teacher); return mv; return teacher.toString();
		 * model.addAttribute("teacher", teacher); return "Details";
		 */
		return teacher;
	}
	
	@RequestMapping("/removeOne")
	public String removeOne() {
		return "ShowOneDetails";
	}
	
	@RequestMapping(value="/remove/{id}")
//	@ResponseBody
	public String remove(//@RequestParam 
			@PathVariable("id") int tid) {
		try {
			Teacher t=repo.getOne(tid);
			repo.delete(t);
			return "Teacher \n"+t+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
		
	}
	
	@RequestMapping(value="/showAll")
//	@ResponseBody
	public String showAllTeachers(Model model) {
	//	List<Teacher> teachers=repo.getAllDetails();
		List<Teacher> teachers=repo.findAll();
		List<String> names=new ArrayList<>();
		teachers.forEach((t)->names.add(t.getName()));
		List<String> subjects=new ArrayList<>();
		teachers.forEach((t)->subjects.add(t.getSubject()));
	//	model.addAttribute("names",names);
	//	model.addAttribute("subjects", subjects);
	//	model.addAttribute("teachers",teachers);
	//	return "ShowAll";
		return names+"\n"+subjects;
	}
	
	@RequestMapping(value="/count")
//	@ResponseBody
	public 
//	long 
	String totalCount() {
		long c=repo.count();
		return "Total Number Of Teachers : "+c;
	}
}
