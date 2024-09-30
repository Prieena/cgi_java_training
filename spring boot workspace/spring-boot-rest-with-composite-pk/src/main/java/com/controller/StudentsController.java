package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Students;
import com.service.StudentsService;

@RestController
public class StudentsController {

	@Autowired
	StudentsService studentsService;
	
	// http://localhost:8080/students
	@RequestMapping(value = "students",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Students> findAll() {
		return studentsService.findAll();
	}

	// http://localhost:8080/storestudent
	@RequestMapping(value = "storestudent",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeCourse(@RequestBody Students student) {
		return studentsService.storeStudent(student);
	}

	// http://localhost:8080/deletestudent/1
	@RequestMapping(value = "deletestudent/{sid}",
			method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("sid") int sid) {
		return studentsService.deleteStudent(sid);
	}
}
