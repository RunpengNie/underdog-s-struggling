package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Long entryId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "SubTitle")
    // maybe we should call it topic or something else
    private String topicSubtitle;

    @Column(name = "Content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate")
    private Date createdDate;

    @ManyToMany
    @JoinTable(
            name = "tags",
            joinColumns = @JoinColumn(name = "EntryID"),
            inverseJoinColumns = @JoinColumn(name = "TagID")
    )
    private Set<Tag> tags = new HashSet<>();

    @Column(name = "KnowledgeLevel")
    private int knowledgeLevel;
}
