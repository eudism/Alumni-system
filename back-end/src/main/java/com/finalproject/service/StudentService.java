package com.finalproject.service;

import com.finalproject.entity.Student;
import com.finalproject.entity.User;
import com.finalproject.payload.request.CommentRequest;

import java.util.List;

public interface StudentService {
    List<User> findAllStudent();

    User findById(long id) throws Exception;
    Student getbyId(Long id) throws Exception;

    void post(CommentRequest postRequest, long id);
    List<Student>getByCity(String city);
    List<Student>getByState(String state);
    List<Student>getByMajor(String major);
    Student getByStudentId(Integer id) throws Exception;
    List<Student> getByName(String name);
    void deleteStudent(Long id);
    Integer countByCity(String  city);
    Integer countByState(String  state);
    void updateProfile(Student student,Long id);
}
