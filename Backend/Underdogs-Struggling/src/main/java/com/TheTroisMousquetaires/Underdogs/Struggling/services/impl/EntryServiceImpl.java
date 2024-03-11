package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.EntryRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EntryServiceImpl implements EntryService {
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Optional<Entry> findEntryByID(long entryID){
        return entryRepository.findEntryByEntryID(entryID);
    }

    @Override
    public Optional<Entry> getEntryByTitle(String title){
        return entryRepository.findEntryByTitle(title);
    }

    @Override
    public List<Entry> getEntriesByTags(Set<Tag> tags){
        return entryRepository.findEntriesByTagsIn(tags);
    }

    @Override
    public Entry addEntry(Entry e){
        return entryRepository.save(e);
    }

    @Override
    public Entry updateEntry(Entry e){
        return entryRepository.save(e);
    }

    @Override
    public void deleteEntry(long id){
        entryRepository.deleteEntryByEntryID(id);
    }

}
