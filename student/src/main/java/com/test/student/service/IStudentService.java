package com.test.student.service;

import java.util.List;

import com.test.student.service.model.StudentRequest;
import com.test.student.service.model.StudentResponse;

public interface IStudentService {

	StudentResponse findStudentById(Long id);

	void saveStudent(StudentRequest studentRequest);

	List<StudentResponse> findAllStudents(int start, int limit);

	void deleteStudent(Long studentId);

}
