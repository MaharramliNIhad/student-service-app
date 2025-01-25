package com.managment.demo.dto;

import com.managment.demo.entity.Student;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO studentDTO);
}
