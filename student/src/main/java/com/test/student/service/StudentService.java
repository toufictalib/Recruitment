package com.test.student.service;

import java.util.List;
import java.util.stream.Collectors;

import com.test.student.dao.StudentRepository;
import com.test.student.dao.model.Student;
import com.test.student.service.converter.StudentConverter;
import com.test.student.service.model.StudentRequest;
import com.test.student.service.model.StudentResponse;
import com.test.student.util.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

	private final StudentRepository studentRepository;
	private final StudentConverter studentConverter;

	public StudentService(StudentRepository studentRepository,
		StudentConverter studentConverter) {
		this.studentRepository = studentRepository;
		this.studentConverter = studentConverter;
	}

	@Override
	public StudentResponse findStudentById(Long id) {
		return studentRepository.findById(id)
			.map(studentConverter::toStudentResponse)
			.orElseThrow(() -> new NotFoundException("Student with id " + id + " is not existing"));
	}

	@Override
	public void saveStudent(StudentRequest studentRequest) {
		Student student = studentConverter.toStudent(studentRequest);
		studentRepository.save(student);
	}

	@Override
	/**
	 * it is better to use java 10 to use
	 * var
	 * toUnmodifiableList instead toList to create immutable list
	 */
	public List<StudentResponse> findAllStudents(int start, int limit) {

		Page<Student> page = studentRepository.findAll(PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC,
			"id")));
		return page.map(studentConverter::toStudentResponse)
			.stream().collect(Collectors.toList());
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.delete(Student.builder()
			.id(studentId)
			.build());
	}
}
