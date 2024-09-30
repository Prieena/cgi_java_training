package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Courses;
import com.repository.CoursesRepository;

@Service
public class CoursesService {
	
	@Autowired
	CoursesRepository coursesRepository;
	
	public List<Courses> findAll() {
		return coursesRepository.findAll();
	}
	
	public String storeCourse(Courses course) {
		Optional<Courses> result = coursesRepository.findById(course.getCid());
		if(result.isPresent()) {
			return "course id must be unique";
		}else {
			coursesRepository.save(course);
			return "Course Record stored successfuly";
		}
	}
	
	public String deleteCourse(int cid) {
		Optional<Courses> result = coursesRepository.findById(cid);
		if(result.isPresent()) {
			coursesRepository.deleteById(cid);
			return "Course record deleted successfully";
		}else {
			return "Course record not present";
		}
	}

}
