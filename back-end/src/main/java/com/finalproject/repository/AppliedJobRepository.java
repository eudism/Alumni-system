package com.finalproject.repository;

import com.finalproject.entity.AppliedJob;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliedJobRepository extends CrudRepository<AppliedJob,Long> {

    @Query("select f from AppliedJob as f  order by f.dayofApplied desc ")
    List<AppliedJob> findAllByApplied();
}
