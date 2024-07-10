package com.TheTroisMousquetaires.Underdogs.Struggling.service;

import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Tag;

import java.util.Optional;
import java.util.*;

public interface EntryService {
    Optional<Entry> findEntryByID(long id);

    // Todo: get all entry

    Optional<Entry> getEntryByTitle(String title);

    List<Entry> getEntriesByTags(Set<Tag> tags);

    // List<Entry> getEntriesByTitleAndKnowledgeLevel(String titles, int level);

    Entry addEntry(Entry e);

    Entry updateEntry(Entry e);

    void deleteEntry(long id);
}
