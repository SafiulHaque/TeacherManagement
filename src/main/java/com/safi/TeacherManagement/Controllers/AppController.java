package com.safi.TeacherManagement.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.safi.TeacherManagement.Models.Teacher;
import com.safi.TeacherManagement.Repositories.TeacherRepository;

@Controller
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
	
	@RequestMapping("/addNew")
	public String addNewTeacher(Teacher teacher,Model model) {
		repo.save(teacher);
		int highest_id=repo.getHighestId();
		System.out.println("Highest Id => "+highest_id);
		model.addAttribute("id",(highest_id+1));
		return "AddTeacher";
	}
	
	@RequestMapping("/one")
	public String oneTeacher() {
		return "ShowOneDetails";
	}
	
	@RequestMapping("/details")
//	@ResponseBody
	public 
//	ModelAndView 
	String
	showOneTeacherDetails(@RequestParam int tid,Model model) {
	//	ModelAndView mv=new ModelAndView("Details.jsp");
		Teacher teacher=repo.findById(tid).orElse(new Teacher());
	//	System.out.println("Teacher => "+teacher.getName());
	//	mv.setViewName("Details.jsp");
	//	System.out.println("mv => "+mv);
	//	System.out.println("mv View Name => "+mv.getViewName());
	//	mv.addObject(teacher);
	//	return mv;
	//	return teacher.toString();
		model.addAttribute("teacher", teacher);
		return "Details";
	}
	
	@RequestMapping("/removeOne")
	public String removeOne() {
		return "ShowOneDetails";
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public String remove(@RequestParam int tid) {
		try {
			Teacher t=repo.getOne(tid);
			repo.delete(t);
			return "Teacher \n"+t+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
		
	}
	
	@RequestMapping("/showAll")
//	@ResponseBody
	public String showAllTeachers(Model model) {
		List<Teacher> teachers=repo.getAllDetails();
		List<String> names=new ArrayList<>();
		teachers.forEach((t)->names.add(t.getName()));
		List<String> subjects=new ArrayList<>();
		teachers.forEach((t)->subjects.add(t.getSubject()));
	//	model.addAttribute("names",names);
	//	model.addAttribute("subjects", subjects);
		model.addAttribute("teachers",teachers);
		return "ShowAll";
	}
	
	@RequestMapping("/count")
	@ResponseBody
	public 
//	long 
	String totalCount() {
		long c=repo.count();
		return "<h2>Total Number Of Teachers</h2>"+c;
	}
}
