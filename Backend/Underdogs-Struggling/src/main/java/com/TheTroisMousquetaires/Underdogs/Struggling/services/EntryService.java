package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;

import java.util.Optional;
import java.util.*;

public interface EntryService {
    Optional<Entry> findEntryByID(long id);

    // Todo: get all entry

    List<Entry> getEntriesByTitle(String titles);

    List<Entry> getEntriesByTag(Tag tag);

    // List<Entry> getEntriesByTitleAndKnowledgeLevel(String titles, int level);

    Entry addEntry(Entry e);

    Entry updateEntry(Entry e, long id);

    void deleteEntry(long id);
}
