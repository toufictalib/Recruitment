package com.test.student.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.test.student.dao.model.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(studentRepository).isNotNull();
	}

	@Test
	void whenInitializedByDbUnit_thenFindsByName() {

		// given
		Long studentId = 1L;

		// when
		Optional<Student> student = studentRepository.findById(studentId);

		// then
		assertThat(student).isPresent().get().usingRecursiveComparison().isEqualTo(Student.builder()
			.id(studentId)
			.name("Toufic")
			.age(18)
			.build());
	}
}
