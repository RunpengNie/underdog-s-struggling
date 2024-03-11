package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;

import java.util.Optional;

public interface TagService {
    Optional<Tag> findTagByID(long id);

    Tag addTag(Tag t);

    Tag updateTag(Tag t, long id);

    void deleteTag(long id);
}
