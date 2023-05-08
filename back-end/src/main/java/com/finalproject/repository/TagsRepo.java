package com.finalproject.repository;

import com.finalproject.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends CrudRepository<Tag, Long> {

}
