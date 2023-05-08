package com.finalproject.service.impl;

import com.finalproject.entity.Tag;
import com.finalproject.repository.TagsRepo;
import com.finalproject.service.TagSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagSevice {

    @Autowired
    private TagsRepo tagsRepo;

    @Override
    public List<Tag> findAll() {
        List<Tag> tags = new ArrayList<>();
        tagsRepo.findAll().forEach(tag-> {
            tags.add(tag);
        });
        return tags;
    }
}
