package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.TagRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.Optional;

public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Optional<Tag> findTagByID(long id){
        return tagRepository.findTagByTagID(id);
    }

    public Tag addTag(Tag t){
        return tagRepository.save(t);
    }

    @Override
    public Tag updateTag(Tag t, long id){
        return tagRepository.save(t);
    }

    @Override
    public void deleteTag(long id){
        tagRepository.deleteTagByTagID(id);
    }

//    public List<Tag> findTagsByTagName(String name){
//        return tagRepository.findTagsByTagName(name);
//    }
}
