package com.safi.TeacherManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.safi.TeacherManagement.Models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	@Query(value="SELECT MAX(TID) FROM Teacher", nativeQuery = true)
	public int getHighestId();
	
	/*
	 * @Query(value="SELECT * FROM Teacher", nativeQuery = true) public
	 * List<Teacher> getAllDetails();
	 */
}
