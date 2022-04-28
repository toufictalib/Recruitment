package com.test.student.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class StudentRequest {

	private Long id;
	private String name;
	private int age;

}
