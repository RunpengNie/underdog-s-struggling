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

    Optional<Entry> findEntriesByTitle(String title);

    List<Entry> findEntriesBySubtitle(String subtitle);

    List<Entry> findEntriesByAuthor(User author);

    List<Entry> findEntriesByTags(Tag tag);

    List<Entry> findEntriesByKnowledgeLevelGreaterThan(int knowledgeLevel);

    List<Entry> findEntriesByKnowledgeLevelLessThan(int knowledgeLevel);

    boolean existsEntryByEntryID(long id);
}
