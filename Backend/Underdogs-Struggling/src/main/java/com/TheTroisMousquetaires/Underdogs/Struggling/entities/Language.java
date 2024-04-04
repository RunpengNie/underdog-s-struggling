package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long languageID;

    @Column(name = "language_code", unique = true, nullable = false)
    private String languageCode;

    @Column(name = "language_name")
    private String languageName;
    
}
