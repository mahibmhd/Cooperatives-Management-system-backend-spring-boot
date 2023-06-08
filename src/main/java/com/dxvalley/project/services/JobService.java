package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Federations;
import com.dxvalley.project.models.Job;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface JobService {
    
    Job addJob(Job job);
    Job editJob(Job job);
    List<Job> getJobs();
    Job getJobById(Long jobId);
    Job getJobByJobTitle(String jobTitle);
    List<Job> getJobByUnion(Unions union);
     List<Job> getJobByPrCooperative(PrCooperative prCooperative);
     List<Job> getJobByFederation(Federations federation);
    void deleteJob( Long jobId);

}
