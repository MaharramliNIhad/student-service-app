package com.managment.demo.service;

import com.managment.demo.dto.StudentDTO;
import com.managment.demo.dto.UniversityDTO;
import com.managment.demo.entity.Student;
import com.managment.demo.entity.University;
import com.managment.demo.exeptions.EmailAlreadyExists;
import com.managment.demo.exeptions.UserNotFound;
import com.managment.demo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public List<StudentDTO> getStudent() {
        List<Student> students = repo.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(new StudentDTO().setName(student.getName()).
                    setEmail(student.getEmail())
                    .setSurname(student.getSurname()).setId(student.getId())
                    .setUniversity(new UniversityDTO().setId(student.getUniversity().getId())
                            .setName(student.getUniversity().getName())));
        }
        return studentDTOS;
    }

    public StudentDTO getStudentById(Integer id) {
        Student student = repo.findById(id).orElse(null);
        return new StudentDTO().setName(student.getName())
                .setId(student.getId())
                .setEmail(student.getEmail())
                .setSurname(student.getSurname())
                .setUniversity(new UniversityDTO().setId(student.getUniversity().getId()).setName(student.getName()));
    }

    public void deleteStudent(Integer id) {
        checkUser(id);
        repo.deleteById(id);
    }

    public Student addStudent(StudentDTO studentDTO) {
        checkEmail(studentDTO);
        return repo.save(toStudent(studentDTO));
    }

    public void updateStudent(Integer id, StudentDTO studentDTO) {
        checkUser(id);
        StudentDTO st = getStudentById(id);
        st.setId(id);
        st.setName(studentDTO.getName());
        st.setSurname(studentDTO.getSurname());
        st.setEmail(studentDTO.getEmail());
        st.setUniversity(new UniversityDTO().setId(studentDTO.getUniversity().getId()));
        Student student = toStudent(st);
        repo.save(student);
    }

    public static Student toStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setSurname(studentDTO.getSurname());
        student.setUniversity(new University()
                .setId(studentDTO.getUniversity().getId())
        );
        return student;
    }

    public void checkEmail(StudentDTO studentDTO) {
        for (Student student : repo.findAll()) {
            if (student.getEmail().equals(studentDTO.getEmail())) {
                throw new EmailAlreadyExists("Email already exists");
            }
        }
    }

    public void checkUser(Integer id) {
        int count = 0;
        for (Student student : repo.findAll()) {
            if (student.getId() == id) {
                count++;
            }
        }
        if (count == 0) {
            throw new UserNotFound("User not found");
        }
    }
}
