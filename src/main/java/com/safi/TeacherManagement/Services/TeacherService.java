package com.safi.TeacherManagement.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement.Models.Teacher;
import com.safi.TeacherManagement.Repositories.TeacherRepository;

@Component
public class TeacherService implements MethodContainer {

	@Autowired
	TeacherRepository repo;
	
	@Override
	public Teacher addNewTeacher(@RequestBody Teacher teacher) {
		// TODO Auto-generated method stub
	//	return null;
		Teacher current_teacher=repo.save(teacher);
		int highest_id=current_teacher.gettId();
		System.out.println("Highest Id => "+highest_id);
		return teacher;
	}

	@Override
	public Teacher showOneTeacherDetails(int tid) {
		// TODO Auto-generated method stub
	//	return null;
		Teacher teacher=repo.findById(tid).orElse(new Teacher());
		return teacher;
	}

	@Override
	public String remove(int tid) {
		// TODO Auto-generated method stub
	//	return null;
		try {
			Teacher t=repo.getOne(tid);
			repo.delete(t);
			return "Teacher \n"+t+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
	}

	@Override
	public String showAllTeachers() {
		// TODO Auto-generated method stub
	//	return null;
		List<Teacher> teachers=repo.findAll();
		List<String> names=new ArrayList<>();
		teachers.forEach((t)->names.add(t.getName()));
		List<String> subjects=new ArrayList<>();
		teachers.forEach((t)->subjects.add(t.getSubject()));
		return names+"\n"+subjects;
	}

	@Override
	public String totalCount() {
		// TODO Auto-generated method stub
	//	return null;
		long c=repo.count();
		return "Total Number Of Teachers : "+c;
	}

}
