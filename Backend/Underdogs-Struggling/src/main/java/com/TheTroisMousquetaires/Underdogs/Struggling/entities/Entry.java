package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Long entryID;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "sub_title")
    // maybe we should call it topic or something else
    private String subtitle;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToMany
    @JoinTable(
            name = "entry_tags",
            joinColumns = @JoinColumn(name = "entry_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @Column(name = "knowledge_level")
    private int knowledgeLevel;
}
