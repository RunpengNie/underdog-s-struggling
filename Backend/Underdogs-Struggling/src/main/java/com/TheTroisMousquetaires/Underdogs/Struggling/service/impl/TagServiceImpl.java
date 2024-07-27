package com.TheTroisMousquetaires.Underdogs.Struggling.service.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.TagRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Tag;
import com.TheTroisMousquetaires.Underdogs.Struggling.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
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
