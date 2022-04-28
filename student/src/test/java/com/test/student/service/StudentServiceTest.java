package com.test.student.service;

import static org.mockito.Mockito.*;

import com.test.student.dao.StudentRepository;
import com.test.student.dao.model.Student;
import com.test.student.service.converter.StudentConverter;
import com.test.student.service.model.StudentRequest;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;
	@Mock
	private StudentConverter studentConverter;

	@InjectMocks
	private StudentService studentService;

	@Test
	void testSaveStudent() {

		// given
		StudentRequest studentRequest = StudentRequest.builder()
			.id(1L)
			.name("student 1")
			.age(20)
			.build();
		Student student = Student.builder()
			.id(studentRequest.getId())
			.name(studentRequest.getName())
			.age(studentRequest.getAge())
			.build();

		when(studentConverter.toStudent(refEq(studentRequest))).thenReturn(student);

		// when
		studentService.saveStudent(studentRequest);

		// then
		verify(studentRepository).save(student);
	}

}
