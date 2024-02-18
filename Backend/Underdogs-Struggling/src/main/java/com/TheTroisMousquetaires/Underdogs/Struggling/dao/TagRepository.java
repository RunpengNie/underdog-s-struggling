package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long>{
    Tag save(Tag entity);

    void deleteTagById(long id);

    Optional<Tag> findTagById(Long aLong);

    List<Tag> findTagsByName(String name);

    boolean existsTagById(long id);

}
