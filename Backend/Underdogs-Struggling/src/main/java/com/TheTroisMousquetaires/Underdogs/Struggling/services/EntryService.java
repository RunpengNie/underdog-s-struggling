package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;

import java.util.Optional;
import java.util.*;

public interface EntryService {
    Optional<Entry> findEntryByID(long id);

    // Todo: get all entry

    List<Entry> getEntriesByTitle(String titles);

    // List<Entry> getEntriesByTitleAndKnowledgeLevel(String titles, int level);

    Entry addEntry(Entry e);

    void deleteEntry(long id);
}
