package com.test.student.dao;

import com.test.student.dao.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface StudentRepository extends JpaRepository<Student, Long> {

}