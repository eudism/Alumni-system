package com.finalproject.service.impl;

import com.finalproject.entity.AppliedJob;
import com.finalproject.entity.JobAdvertisement;
import com.finalproject.repository.AppliedJobRepository;
import com.finalproject.service.AppliedJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppliedJobServiceImpl implements AppliedJobService {
    @Autowired
    private AppliedJobRepository rep;
    @Override
    public void ApplyJob(AppliedJob appliedJob, JobAdvertisement job ) {
        appliedJob.setAdverts(job);
        rep.save(appliedJob);

    }

    @Override
    public List<AppliedJob> recentApplied() {

        List<AppliedJob> hol = new ArrayList<>();
        hol = rep.findAllByApplied().stream().filter(l->l.isMark_deleteapplied()!=true)
                .limit(10)       .collect(Collectors.toList());
        return hol;

    }
}
