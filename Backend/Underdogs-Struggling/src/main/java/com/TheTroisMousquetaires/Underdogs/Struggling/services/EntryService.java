package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;

import java.util.Optional;
import java.util.*;

public interface EntryService {
    Optional<Entry> findEntryByID(long id);

    Optional<Entry> getEntryByTitle(String title);

    Entry addEntry(Entry e);

    Entry updateEntry(Entry e);

    void deleteEntry(long id);

    List<Entry> getAllEntries();

    List<Entry> findEntriesByTopic(String topic);

    List<Entry> findEntriesByTags(Set<Tag> tags, long tagCount);
}