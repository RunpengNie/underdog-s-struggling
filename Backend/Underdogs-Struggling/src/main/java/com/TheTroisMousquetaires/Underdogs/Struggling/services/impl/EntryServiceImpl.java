package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.EntryRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.EntryService;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntryServiceImpl implements EntryService {
    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private TagService tagService;

    @Override
    public Optional<Entry> findEntryByID(long entryID){
        return entryRepository.findEntryByEntryID(entryID);
    }

    @Override
    public Optional<Entry> getEntryByTitle(String title){
        return entryRepository.findEntryByTitle(title);
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

    @Override
    public List<Entry> getAllEntries() {
        return (List<Entry>) entryRepository.findAll();
    }

    @Override
    public List<Entry> findEntriesByTopic(String topic){
        return entryRepository.findEntriesByTopic(topic);
    }

    @Override
    public List<Entry> findEntriesByTags(Set<Tag> tags, long tagCount){
        return entryRepository.findEntriesByTags(tags, tagCount);
    }

}
