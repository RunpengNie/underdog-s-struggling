package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.User;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
import java.util.Optional;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
    Entry save(Entry entity);

    void deleteEntryByEntryID(long id);

    Optional<Entry> findEntryByEntryID(long id);

    Optional<Entry> findEntryByTitle(String title);

    List<Entry> findEntriesByTopic(String topic);

    List<Entry> findEntriesByAuthor(User author);

    @Query("SELECT e FROM Entry e JOIN e.tags t WHERE t IN :tags GROUP BY e HAVING COUNT(DISTINCT t) = :tagCount")
    List<Entry> findEntriesByTags(@Param("tags") Set<Tag> tags, @Param("tagCount") long tagCount);

    List<Entry> findEntriesByKnowledgeLevelGreaterThan(int knowledgeLevel);

    List<Entry> findEntriesByKnowledgeLevelLessThan(int knowledgeLevel);

    boolean existsEntryByEntryID(long id);

    boolean existsEntryByTitle(String title);

}
