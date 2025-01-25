package com.managment.demo.service;

import com.managment.demo.dto.StudentDTO;
import com.managment.demo.dto.StudentMapper;
import com.managment.demo.dto.UniversityDTO;
import com.managment.demo.entity.Student;
import com.managment.demo.entity.University;
import com.managment.demo.exeptions.EmailAlreadyExists;
import com.managment.demo.exeptions.UserNotFound;
import com.managment.demo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            studentDTOS.add(StudentMapper.INSTANCE.toStudentDTO(student));
        }
        return studentDTOS;
    }

    public StudentDTO getStudentById(Integer id) {
        Student student = repo.findById(id).orElse(null);
        if (student == null) {
            throw new UserNotFound();
        }
        return StudentMapper.INSTANCE.toStudentDTO(student);
    }

    public void deleteStudent(Integer id) {
        checkUser(id);
        repo.deleteById(id);
    }

    public Student addStudent(StudentDTO studentDTO) {
        checkEmail(studentDTO);
        return repo.save(StudentMapper.INSTANCE.toStudent(studentDTO));
    }

    public void updateStudent(Integer id, StudentDTO studentDTO) {
        checkUser(id);
        StudentDTO st = getStudentById(id);
        st.setId(id);
        st.setName(studentDTO.getName());
        st.setSurname(studentDTO.getSurname());
        st.setEmail(studentDTO.getEmail());
        st.setUniversity(new UniversityDTO().setId(studentDTO.getUniversity().getId()));
        repo.save(StudentMapper.INSTANCE.toStudent(studentDTO));
    }


    public void checkEmail(StudentDTO studentDTO) {
        for (Student student : repo.findAll()) {
            if (student.getEmail().equals(studentDTO.getEmail())) {
                throw new EmailAlreadyExists();
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
            throw new UserNotFound();
        }
    }
}
