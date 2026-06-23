package com.example.student_mgmt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<student, Integer>{
	
}
