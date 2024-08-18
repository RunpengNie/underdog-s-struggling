package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.User;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Tag;
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

    @Query(value = "SELECT e.* FROM entries e " +
            "JOIN entry_tags et ON e.entry_id = et.entry_id " +
            "WHERE et.tag_id IN (SELECT t.tag_id FROM tags t WHERE t.tag_id IN (:tagIds)) " +
            "GROUP BY e.entry_id " +
            "HAVING COUNT(DISTINCT et.tag_id) = (SELECT COUNT(DISTINCT t.tag_id) FROM tags t WHERE t.tag_id IN (:tagIds))",
            nativeQuery = true)
    List<Entry> findEntriesByTags(@Param("tagIds") Set<Long> tagIds);

    Optional<Entry> findEntryByEntryID(long id);

    Optional<Entry> findEntryByTitle(String title);

    List<Entry> findEntriesByTopic(String topic);

    Optional<Entry> findEntriesByAuthor(User author);

//    @Query("SELECT e FROM Entry e JOIN e.tags t WHERE t IN :tags GROUP BY e HAVING COUNT(DISTINCT t) = :tagCount")

//    List<Entry> findEntriesByTags(Set<Tag> tags);



    Optional<Entry> findEntriesByKnowledgeLevelGreaterThan(int knowledgeLevel);

    Optional<Entry> findEntriesByKnowledgeLevelLessThan(int knowledgeLevel);

    boolean existsEntryByEntryID(long id);

    boolean existsEntryByTitle(String title);

    Optional<Entry> getEntryByTitle(String title);

    List<Entry> findAll();
}
