package com.finalproject.controllers;

import com.finalproject.entity.AppliedJob;
import com.finalproject.service.AppliedJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppliedJobController {
    @Autowired
private AppliedJobService appliedJobService;

    @GetMapping("/recentApplied")
    public List<AppliedJob> RecentApplied() {

        return appliedJobService.recentApplied() ;

    }
}
