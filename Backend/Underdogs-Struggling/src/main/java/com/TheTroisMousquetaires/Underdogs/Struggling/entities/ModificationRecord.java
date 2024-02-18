//package com.TheTroisMousquetaires.Underdogs.Struggling.entities;
//
//import jakarta.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "modification_records")
//public class ModificationRecord {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "RecordID")
//    private Long recordId;
//
//    @ManyToOne
//    @JoinColumn(name = "UserID")
//    private User user;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "ModificationTimestamp")
//    private Date modificationTimestamp;
//
//    // Constructors
//    public ModificationRecord() {
//    }
//
//    public ModificationRecord(User user, Date modificationTimestamp) {
//        this.user = user;
//        this.modificationTimestamp = modificationTimestamp;
//    }
//
//    // Getters and NO setters
//    public Long getRecordId() {
//        return recordId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public Date getModificationTimestamp() {
//        return modificationTimestamp;
//    }
//}
