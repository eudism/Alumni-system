package com.finalproject.service;

import com.finalproject.entity.JobAdvertisement;
import com.finalproject.entity.Student;

import java.util.List;

public interface JobService {
    List<JobAdvertisement> findAll();
    List<JobAdvertisement>findRecent();
    JobAdvertisement getById(Long id);

    List<JobAdvertisement>findByCity(String city);
    List<JobAdvertisement>findByState(String states);
    List<JobAdvertisement>findAllByTag(String  tag);
    List<JobAdvertisement>findByCompany(String company);
    void postJobAdvert(JobAdvertisement jobAdvertisement, Student student  );
    void deleteJob(Student student);

    Integer countByState(String state);
    Integer countByCity(String city);


}
