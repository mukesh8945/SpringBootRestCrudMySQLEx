package com.app.mukesh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mukesh.entity.Student;
import com.app.mukesh.exception.StudentNotFoundException;
import com.app.mukesh.repo.StudentRepository;
import com.app.mukesh.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(Student s) {
		s = repo.save(s);
		return s.getStudentId();
	}

	@Override
	public void updateStudent(Student s) {
		if (s.getStudentId() == null || !repo.existsById(s.getStudentId()))
			throw new StudentNotFoundException("STUDENT ' " + s.getStudentId() + " ' NOT EXIST");
		else
			repo.save(s);

	}

	@Override
	public void deleteStudent(Integer id) {
		repo.delete(getOneStudent(id));

	}

	@Override
	public Student getOneStudent(Integer id) {
		return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student ' " + id + " ' NOT EXIST"));
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = repo.findAll();
		return list;
	}

}
