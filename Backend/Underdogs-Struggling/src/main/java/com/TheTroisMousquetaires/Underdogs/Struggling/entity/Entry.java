package com.TheTroisMousquetaires.Underdogs.Struggling.entity;

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

    @Column(name = "topic")
    // maybe we should call it topic or something else
    private String topic;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

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

    public Entry(long entryID, String title, String topic, Language language, String content, User author, Date createdDate){
        this.title = title;
        this.topic = topic;
        this.language = language;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.entryID = entryID;
    }

    public Entry() {
    }

    public long getEntryID(){
        return entryID;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTags(Set<Tag> tags){
        this.tags = tags;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }
}
