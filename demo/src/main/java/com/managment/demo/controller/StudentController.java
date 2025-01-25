package com.managment.demo.controller;

import com.managment.demo.dto.CommonDTO;
import com.managment.demo.dto.StudentDTO;
import com.managment.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public CommonDTO getStudent() {
        return new CommonDTO().setObject(studentService.getStudent()).setDate(LocalDateTime.now());
    }

    @GetMapping("/{id}")
    public CommonDTO getStudentById(@PathVariable("id") Integer id) {
        return new CommonDTO().setObject(studentService.getStudentById(id)).setDate(LocalDateTime.now());

    }

    @PostMapping
    public CommonDTO addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
        return new CommonDTO().setMessage("Student added successfully").setDate(LocalDateTime.now());
    }

    @DeleteMapping("/{id}")
    public CommonDTO deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return new CommonDTO().setMessage("Student deleted successfully").setDate(LocalDateTime.now());
    }

    @PutMapping("/{id}")
    public CommonDTO updateStudent(@PathVariable("id") Integer id, @RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(id, studentDTO);
        return new CommonDTO().setMessage("Student updated successfully").setDate(LocalDateTime.now());
    }
}