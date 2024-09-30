package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Students;
import com.repository.StudentsRepository;

@Service
public class StudentsService {

	@Autowired
	StudentsRepository studentsRepository;
	
	public List<Students> findAll() {
		return studentsRepository.findAll();
	}
	
	public String storeStudent(Students student) {
		Optional<Students> result = studentsRepository.findById(student.getSid());
		if(result.isPresent()) {
			return "Student id must be unique";
		}else {
			studentsRepository.save(student);
			return "Student Record stored successfuly";
		}
	}
	
	public String deleteStudent(int sid) {
		Optional<Students> result = studentsRepository.findById(sid);
		if(result.isPresent()) {
			studentsRepository.deleteById(sid);
			return "Student record deleted successfully";
		}else {
			return "Student record not present";
		}
	}
}
