package com.finalproject.service;

import com.finalproject.entity.AppliedJob;
import com.finalproject.entity.JobAdvertisement;

import java.util.List;


public interface AppliedJobService {
    void ApplyJob(AppliedJob appliedJob, JobAdvertisement job);
    List<AppliedJob> recentApplied();

}
