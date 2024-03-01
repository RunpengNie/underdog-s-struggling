package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagID;

    @Column(name = "tag_name", unique = true)
    private String tagName;

    @ManyToMany
    Set<Entry> entries;

    // Constructors
    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    // Getters and Setters
    public Long getTagID() {
        return tagID;
    }

    public void setTagID(Long tagId) {
        this.tagID = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
