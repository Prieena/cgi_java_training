package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Enrollment;
import com.entity.EnrollmentKey;
import com.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;

	public List<Enrollment> findAll() {
		return enrollmentRepository.findAll();
	}
	
	public String addEnrollment(Enrollment enrollment) {
		Optional<Enrollment> result = enrollmentRepository.findById(enrollment.getEk());
		if(result.isPresent()) {
			return "Enrollment id must be unique";
		}else {
			enrollmentRepository.save(enrollment);
			return "Enrollment Record stored successfuly";
		}
	}
	
	public String deleteEnrollemnt(EnrollmentKey ek) {
		Optional<Enrollment> result = enrollmentRepository.findById(ek);
		if(result.isPresent()) {
			enrollmentRepository.deleteById(ek);
			return "Enrollment record deleted successfully";
		}else {
			return "Enrollment record not present";
		}
	}
}
