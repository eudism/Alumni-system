package com.finalproject.service.impl;

import com.finalproject.entity.Comments;
import com.finalproject.entity.Student;
import com.finalproject.entity.User;
import com.finalproject.payload.request.CommentRequest;
import com.finalproject.repository.CommentRepo;
import com.finalproject.repository.StudentRepo;
import com.finalproject.repository.UserRepository;
import com.finalproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<User> findAllStudent() {
//returns the list of students that are not soft deleted
        List<User> holder = new ArrayList<>();
        holder = userRepo.findAll().stream().filter(k -> k.isSoft_deleted() != true).collect(Collectors.toList());
        return holder;
    }


    @Override
    public User findById(long id) throws Exception {
        //Returns a user by Id

        var userExist=  userRepo.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));

        if(!userExist.isSoft_deleted()){
            return userExist;
        }
    else {
        throw  new Exception("User is already deleted ");
        }
    }



    @Override
    public Student getbyId(Long id) throws Exception {
        //Returns user attribute of the student
        var n= studentRepo.findById(id).orElseThrow();

        if(!n.getUser().isSoft_deleted()){
            return n;
        }
        else {
            throw new Exception("already deleted ");
        }
    }

    @Override
    public void post(CommentRequest commentRequest, long id) {
        //Posts a comment about a student

        var student = studentRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Student doesnt exist"));
        Comments comment = new Comments();
        comment.setComment(commentRequest.getComment());
        comment.setCommenter(commentRequest.getCommenter());
        comment.setPostTime(LocalDateTime.now());
        comment.setStudent(student);
        commentRepo.save(comment);
    }

    @Override
    public List<Student> getByCity(String city) {

        List<Student>  studentList = new ArrayList<>();
        studentList= studentRepo.findAllByAddress_City(city).stream().filter(s -> s.getUser().isSoft_deleted() != true).collect(Collectors.toList());
        return studentList;
    }

    @Override
    public List<Student> getByState(String state) {
        List<Student>  studentList = new ArrayList<>();
        studentList = studentRepo.findAllByAddress_State(state).stream().filter(s -> s.getUser().isSoft_deleted() != true).collect(Collectors.toList());
        return studentList;
    }

    @Override
    public List<Student> getByMajor(String major) {
        List<Student>  studentList = new ArrayList<>();
        studentList = studentRepo.findAllByMajor(major).stream().filter(s -> s.getUser().isSoft_deleted() != true).collect(Collectors.toList());
        return studentList;
    }

    @Override
    public Student getByStudentId(Integer id) throws Exception {

        var n= studentRepo.findByStudentId(id);
   if(!n.getUser().isSoft_deleted()){

    return  n;
   }
    else {

        throw new Exception(" deleted student");
   }
    }

    @Override
    public List<Student> getByName(String name) {
       List<Student>  studentList = new ArrayList<>();
        studentList =studentRepo.findAllByFirstName(name).stream().filter(s->s.getUser().isSoft_deleted()!=true).collect(Collectors.toList());
        return studentList;
    }



    @Override
    public void deleteStudent(Long id) {
        var n= userRepo.findById(id).orElseThrow();
        n.setSoft_deleted(true);
    }

    @Override
    public Integer countByCity(String city) {
        return studentRepo.countAllByAddress_City(city);
    }

    @Override
    public Integer countByState(String state) {
        return studentRepo.countAllByAddress_State(state);
    }

    // updating his profile
    @Override
    public void updateProfile(Student student,Long id) {
//Allows the users to edit their details
        var  previousDetails =studentRepo.findById(id).orElseThrow();
        previousDetails.setId(student.getId());
        previousDetails.setFirstName(student.getFirstName());
        previousDetails.setLastName(student.getLastName());
        previousDetails.setGpa(student.getGpa());
        previousDetails.setAddress(student.getAddress());
        previousDetails.setMajor(student.getMajor());
        previousDetails.setJobHistory(student.getJobHistory());
      studentRepo.save(previousDetails);
    }

}

