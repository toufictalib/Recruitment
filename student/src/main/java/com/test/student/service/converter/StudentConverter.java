package com.test.student.service.converter;

import com.test.student.dao.model.Student;
import com.test.student.service.model.StudentRequest;
import com.test.student.service.model.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

	public StudentResponse toStudentResponse(Student student){
		return StudentResponse.builder()
			.id(student.getId())
			.name(student.getName())
			.age(student.getAge())
			.build();
	}

	public Student toStudent(StudentRequest studentRequest){
		return Student.builder()
			.id(studentRequest.getId())
			.name(studentRequest.getName())
			.age(studentRequest.getAge())
			.build();
	}
}
