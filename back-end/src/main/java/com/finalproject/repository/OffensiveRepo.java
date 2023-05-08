package com.finalproject.repository;

import com.finalproject.entity.OffensiveUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffensiveRepo extends CrudRepository<OffensiveUser, Integer> {

    OffensiveUser findByUserName(String name);
}
