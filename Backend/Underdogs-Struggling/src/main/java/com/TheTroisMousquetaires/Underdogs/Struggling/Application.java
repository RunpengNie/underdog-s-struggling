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


			Optional<Tag> optionaltag1 = tagRepository.findTagByTagID((long)1);
			Optional<Tag> optionaltag2 = tagRepository.findTagByTagID((long)2);

			Tag tag1 = optionaltag1.get();
			Tag tag2 = optionaltag2.get();

//			Tag tag1 = new Tag();
//			tag1.setTagName("TestTag1");
//
//			Tag tag2 = new Tag();
//			tag2.setTagName("TestTag2");

//			boolean tag1Exists = tagRepository.existsById((long)2);
//			System.out.println("Tag1 exists in DB " + tag1Exists);
//			boolean tag2Exists = tagRepository.existsById((long)1);
//			System.out.println("Tag2 exists in DB " + tag2Exists);

//			tagRepository.save(tag1);
//			tagRepository.save(tag2);

//			List<Tag> existingTag1 = tagRepository.findTagsByTagName("TestTag1");
//			if (!existingTag1.isEmpty()) {
//				tagRepository.save(tag1);
//			}
//
//			List<Tag> existingTag2 = tagRepository.findTagsByTagName("TestTag2");
//			if (!existingTag2.isEmpty()) {
//				tagRepository.save(tag2);
//			}


			Entry entry1 = new Entry();
			entry1.setTitle("TestEntry1");

			Set<Tag> entry1Tags = new HashSet<>();
			entry1Tags.add(tag1);

			entry1.setTags(entry1Tags);

			Entry entry2 = new Entry();
			entry2.setTitle("TestEntry2");


			Set<Tag> entry2Tags = new HashSet<Tag>();
			entry2Tags.add(tag1);
			entry2Tags.add(tag2);
			entry2.setTags(entry2Tags);

//			entryRepository.save(entry1);
//			entryRepository.save(entry2);

//			Optional<Entry> existingEntry1 = entryRepository.findEntryByTitle("TestEntry1");
//			if (existingEntry1.isPresent()) {
//				entryRepository.save(entry1);
//			}
//
//			Optional<Entry> existingEntry2 = entryRepository.findEntryByTitle("TestEntry2");
//			if (existingEntry2.isPresent()) {
//				entryRepository.save(entry2);
//			}

//			entryRepository.save(entry1);
//			entryRepository.save(entry2);

//			works
//			List<Entry> allEntries = entryService.getAllEntries();
//			for (Entry entry : allEntries) {
//				System.out.println("entry: " + entry.getTitle());
//			}

			List<Entry> entryByTag1 = entryService.findEntriesByTags(entry1Tags);
			for (Entry entry : entryByTag1) {
				System.out.println("Entries by Tag 1: " + entry.getTitle());
			}


			List<Entry> entryByTag2 = entryService.findEntriesByTags(entry2Tags);
			for (Entry entry : entryByTag2) {
				System.out.println("Entries by Tag 2: " + entry.getTitle());
			}
		};
    }

}