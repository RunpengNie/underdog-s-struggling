package com.TheTroisMousquetaires.Underdogs.Struggling.service;

import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Tag;

import java.util.Optional;
import java.util.*;

public interface EntryService {
    Optional<Entry> findEntryByID(long id);

    Optional<Entry> findEntryByTitle(String title);

    Entry addEntry(Entry e);

    Entry updateEntry(Entry e);

    void deleteEntry(long id);

    List<Entry> getAllEntries();

    List<Entry> findEntriesByTopic(String topic);

    List<Entry> findEntriesByTags(Set<Tag> tags, long tagCount);


}