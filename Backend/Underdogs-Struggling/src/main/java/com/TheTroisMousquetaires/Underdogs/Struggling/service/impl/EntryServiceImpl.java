package com.TheTroisMousquetaires.Underdogs.Struggling.service.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.EntryRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Tag;
import com.TheTroisMousquetaires.Underdogs.Struggling.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EntryServiceImpl implements EntryService {
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Optional<Entry> findEntryByID(long entryID){
        return entryRepository.findEntryByEntryID(entryID);
    }

    @Override
    public Optional<Entry> findEntryByTitle(String title){
        return entryRepository.findEntryByTitle(title);
    }

    @Override
    public List<Entry> findEntriesByTags(Set<Tag> tags){
//        return entryRepository.findEntriesByTags(tags);
        // Convert Set<Tag> to List<Long> for tag IDs
        Set<Long> tagIds = tags.stream()
                .map(Tag::getTagID)
                .collect(Collectors.toSet());

        // Call the repository method
        return entryRepository.findEntriesByTags(tagIds);
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
        return entryRepository.findAll();
    }

    @Override
    public List<Entry> findEntriesByTopic(String topic) {

        return entryRepository.findEntriesByTopic(topic);
    }

}
