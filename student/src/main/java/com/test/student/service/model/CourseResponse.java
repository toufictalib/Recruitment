package com.test.student.service.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CourseResponse {

	private Long id;
	private String name;
	private String description;
	private List<String> steps;

}
