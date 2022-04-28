package com.test.student.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.student.service.IStudentService;
import com.test.student.service.model.StudentResponse;
import com.test.student.util.exception.NotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(properties = "application.environment=DEV", controllers = StudentController.class)
class StudentControllerTest {

	@MockBean
	public IStudentService studentService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testFindStudentById() throws Exception {

		// given
		Long studentId = 1L;
		StudentResponse studentResponse = StudentResponse.builder()
			.id(studentId)
			.name("Student 1")
			.build();

		when(studentService.findStudentById(studentId)).thenReturn(studentResponse);

		// when
		ResultActions result = mockMvc.perform(
			get("/student")
				.queryParam("studentId", String.valueOf(studentId))
				.contentType(MediaType.APPLICATION_JSON));

		// then
		result.andExpect(status().isOk());
		assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo(
			objectMapper.writeValueAsString(studentResponse));
	}

	@Test
	void testFindStudentById_notFound() throws Exception {

		// given
		Long studentId = 1L;

		when(studentService.findStudentById(studentId)).thenThrow(new NotFoundException("Student is not existing"));

		// when
		ResultActions result = mockMvc.perform(
			get("/student")
				.queryParam("studentId", String.valueOf(studentId))
				.contentType(MediaType.APPLICATION_JSON));

		// then
		result.andExpect(status().isNotFound());
	}
}
