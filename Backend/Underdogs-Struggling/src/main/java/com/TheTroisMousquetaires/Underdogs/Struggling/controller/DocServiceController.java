package com.TheTroisMousquetaires.Underdogs.Struggling.controller;

import com.TheTroisMousquetaires.Underdogs.Struggling.services.EntryService;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Set;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DocServiceController{
//    @Autowired
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

}