package com.managment.demo.dto;

public class StudentDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private UniversityDTO university;

    public Integer getId() {
        return id;
    }

    public StudentDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public StudentDTO setUniversity(UniversityDTO university) {
        this.university = university;
        return this;
    }

    public StudentDTO(Integer id, String name, String surname, String email, UniversityDTO university) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.university = university;
    }

    public StudentDTO() {
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", university=" + university +
                '}';
    }
}
