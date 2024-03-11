package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.User;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.*;
import java.util.Optional;

public interface EntryRepository extends CrudRepository<Entry, Long> {
    Entry save(Entry entity);

    void deleteEntryByEntryID(long id);

    Optional<Entry> findEntryByEntryID(long id);

    Optional<Entry> findEntryByTitle(String title);

    List<Entry> findEntriesBySubtitle(String subtitle);

    List<Entry> findEntriesByAuthor(User author);

    List<Entry> findEntriesByTagsIn(Set<Tag> tags);

    List<Entry> findEntriesByKnowledgeLevelGreaterThan(int knowledgeLevel);

    List<Entry> findEntriesByKnowledgeLevelLessThan(int knowledgeLevel);

    boolean existsEntryByEntryID(long id);
}
