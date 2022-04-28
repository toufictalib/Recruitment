package com.test.student.controller;

import java.util.List;

import com.test.student.service.IStudentService;
import com.test.student.service.model.StudentRequest;
import com.test.student.service.model.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final static int MAX_ITERATIONS = 50;
	private final IStudentService studentService;

	public StudentController(IStudentService studentService) {this.studentService = studentService;}

	/**
	 * we shouldn't allow any limit to exceed a max value to not break the server
	 *
	 * @param start
	 * @param limit
	 * @return
	 */
	@GetMapping("/all")
	public List<StudentResponse> findAllStudents(@RequestParam(required = false, defaultValue = "0") int start,
		@RequestParam(required = false, defaultValue = MAX_ITERATIONS + "") int limit) {
		if (limit > MAX_ITERATIONS) {
			throw new IllegalArgumentException("Limit must be less or equal to " + MAX_ITERATIONS);
		}

		return studentService.findAllStudents(start, limit);
	}

	@GetMapping
	public StudentResponse findStudentById(@RequestParam Long studentId) {
		return studentService.findStudentById(studentId);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PostMapping
	public void saveStudent(@RequestBody StudentRequest studentRequest) {
		studentService.saveStudent(studentRequest);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{studentId}")
	public void deleteStudent(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);
	}
}
