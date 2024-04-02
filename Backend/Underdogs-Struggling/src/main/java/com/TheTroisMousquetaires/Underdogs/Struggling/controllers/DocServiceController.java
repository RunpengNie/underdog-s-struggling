package com.TheTroisMousquetaires.Underdogs.Struggling.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.EntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
class DocServiceController {
  @Autowired
  private EntryRepository entryRepository;

  @GetMapping("/docs/{id}")
  public Entry getEntryByID(@PathVariable Long id) {
      return entryRepository.findEntryByEntryID(id);
  }
  
  @GetMapping("/docs/{title}")
  public Entry getEntryByTitle(@PathVariable String title) {
      return entryRepository.findEntryByTitle(title);
  }
  
  @GetMapping("/docs/{subtitle}")
  public List<Entry> getEntriesBySubtitle(@PathVariable String subtitle) {
      return entryRepository.findEntriesBySubtitle(subtitle);
  }

  @GetMapping("/docs/knowledge_level_less/{knowledgelevel}}")
  public List<Entry> getEntriesLessThanKnowledgeLevel(@PathVariable int knowledgelevel) {
      return entryRepository.findEntriesByKnowledgeLevelLessThan(knowledgelevel);
  }
  
  @GetMapping("/docs/knowledge_level_greater/{knowledgelevel}}")
  public List<Entry> getEntriesGreaterThanKnowledgeLevel(@PathVariable int knowledgelevel) {
      return entryRepository.findEntriesByKnowledgeLevelGreaterThan(knowledgelevel);
  }
}