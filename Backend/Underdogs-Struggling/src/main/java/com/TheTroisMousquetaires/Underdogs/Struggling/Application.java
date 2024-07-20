package com.TheTroisMousquetaires.Underdogs.Struggling;

import com.TheTroisMousquetaires.Underdogs.Struggling.controller.DocServiceController;
import com.TheTroisMousquetaires.Underdogs.Struggling.dao.EntryRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.dao.RoleRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.dao.TagRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Tag;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Entry;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.EntryService;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Optional;
import java.util.*;

@SpringBootApplication
public class Application {

	private final EntryService entryService;
//	private final TagService tagService;

    public Application(EntryService entryService) {
        this.entryService = entryService;
//        this.tagService = tagService;
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(RoleRepository roleRepository, TagRepository tagRepository, EntryRepository entryRepository) throws Exception {
		return args -> {

			Role role = new Role();
			role.setRoleName("TestRole");

			roleRepository.save(role);
			Optional<Role> saved = roleRepository.findRoleByRoleID(role.getRoleID());


			Tag tag1 = tagRepository.findTagByTagName("TestTag1").orElseGet(() -> {
				Tag newTag = new Tag("TestTag1");
				return tagRepository.save(newTag);
			});

			Tag tag2 = tagRepository.findTagByTagName("TestTag2").orElseGet(() -> {
				Tag newTag = new Tag("TestTag2");
				return tagRepository.save(newTag);
			});

//			Entry entry1 = new Entry();
//			entry1.setTitle("TestEntry1");
//			entry1.setTags(Set.of(tag1));
//			entryRepository.save(entry1);
//
//			Entry entry2 = new Entry();
//			entry2.setTitle("TestEntry2");
//			entry2.setTags(Set.of(tag1, tag2));
//			entryRepository.save(entry2);

//			// Print entries and tags for debugging
//			System.out.println("Entries:");
//			entryRepository.findAll().forEach(entry -> {
//				System.out.println("Entry: " + entry.getTitle());
//				System.out.println("Tags:");
//				entry.getTags().forEach(tag -> System.out.println("Tag: " + tag.getTagName()));
//			});

			if (!entryRepository.existsById(1L)) {
				Entry entry1 = new Entry();
				entry1.setTitle("TestEntry1");
				entry1.setTags(Set.of(tag1));
				entryRepository.save(entry1);
			}

			if (!entryRepository.existsById(2L)) {
				Entry entry2 = new Entry();
				entry2.setTitle("TestEntry2");
				entry2.setTags(Set.of(tag1, tag2));
				entryRepository.save(entry2);
			}

			Set<Tag> entry1Tags = Set.of(tag1);
			List<Entry> entriesByTag1 = entryRepository.findEntriesByTags(entry1Tags, entry1Tags.size());

//			works	displayByTag
			System.out.println("Entries by Tag 1:");
			for (Entry entry : entriesByTag1) {
				System.out.println(entry.getTitle());
			}

			Set<Tag> entry2Tags = Set.of(tag1, tag2);
			List<Entry> entriesByTag2 = entryRepository.findEntriesByTags(entry2Tags, entry2Tags.size());

//			works  displayByTag
			System.out.println("Entries by Tag 2:");
			for (Entry entry : entriesByTag2) {
				System.out.println(entry.getTitle());
			}

//			works display All Entries
			List<Entry> allEntries = entryService.getAllEntries();
			for (Entry entry : allEntries) {
				System.out.println("entry: " + entry.getTitle());
			}

		};
    }

}