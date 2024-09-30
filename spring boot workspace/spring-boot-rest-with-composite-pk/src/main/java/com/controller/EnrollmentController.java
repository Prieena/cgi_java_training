package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Enrollment;
import com.entity.EnrollmentKey;
import com.entity.Students;
import com.service.EnrollmentService;

@RestController
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentService;
	
	// http://localhost:8080/enrollment
	@RequestMapping(value = "enrollment",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Enrollment> findAll() {
		return enrollmentService.findAll();
	}

	// http://localhost:8080/storeenrollment
	@RequestMapping(value = "storeenrollment",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addEnrollment(@RequestBody Enrollment enrollment) {
		return enrollmentService.addEnrollment(enrollment);
	}

	// http://localhost:8080/deleteenrollemnt/1/1
	@RequestMapping(value = "deleteenrollment/{sid}/{cid}")
	public String deleteEnrollment(@PathVariable("sid") int sid, @PathVariable("cid") int cid) {
		return enrollmentService.deleteEnrollment(sid, cid);
	}
}
