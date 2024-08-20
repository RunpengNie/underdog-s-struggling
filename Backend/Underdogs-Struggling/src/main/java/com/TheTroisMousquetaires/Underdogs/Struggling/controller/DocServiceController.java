package com.TheTroisMousquetaires.Underdogs.Struggling.controller;

import com.TheTroisMousquetaires.Underdogs.Struggling.service.EntryService;
import com.TheTroisMousquetaires.Underdogs.Struggling.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


public class DocServiceController{
    private EntryService entryService;
    private TagService tagService;

    @GetMapping("/referencesheet")
    public List<Entry> getAllEntries(){
        return entryService.getAllEntries();
    }

    @GetMapping("/{topic}")
    public List<Entry> getEntriesByTopic(String topic){
        return entryService.findEntriesByTopic(topic);
    }

    @GetMapping("/{tags}")
    public List<Entry> getEntriesByTags(@RequestParam Set<Tag> tags){
        return entryService.findEntriesByTags(tags);
    }

    @GetMapping("/{title}")
    public Optional<Entry> getEntryByTitle(String title){
        return entryService.findEntryByTitle(title);
    }

}