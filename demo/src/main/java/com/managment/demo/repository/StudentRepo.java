package com.managment.demo.repository;

import com.managment.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findById(Integer ID);
}
