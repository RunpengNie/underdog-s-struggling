package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_name", unique = true)
    private String tagName;

    // Constructors
    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    // Getters and Setters
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
