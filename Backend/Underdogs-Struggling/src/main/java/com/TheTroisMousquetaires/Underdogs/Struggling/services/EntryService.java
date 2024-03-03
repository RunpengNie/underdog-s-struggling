package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;

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
