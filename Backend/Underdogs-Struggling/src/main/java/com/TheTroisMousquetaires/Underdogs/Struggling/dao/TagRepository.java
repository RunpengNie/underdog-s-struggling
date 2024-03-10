package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.*;
import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long>{
    Tag save(Tag t);

    void deleteTagByTagID(long id);

    Optional<Tag> findTagByTagID(Long id);

    List<Tag> findTagsByTagName(String name);

    boolean existsTagByTagID(long id);

}
