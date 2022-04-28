package com.test.student.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class StudentResponse {

	private Long id;
	private String name;
	private int age;

}
