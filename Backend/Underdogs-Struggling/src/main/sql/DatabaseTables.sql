-- Roless: Store roles information
--     RoleID (PK)
--     RoleName
CREATE TABLE Roles(
    RoleID INT,
    RoleName VARCHAR(20),
    PRIMARY KEY (RoleID)
);

-- Tags: Store different tags
--     TagID (PK)
--     TagName
CREATE TABLE Tags(
    TagID INT AUTO_INCREMENT,
    TagName VARCHAR(20),
    Primary Key (TagID)
);

-- Users: Store user information
--     UserID (PK)
--     UserName
--     Password
--     Role (FK, to Roles.RoleID)
--     Email (Unique)
--     RegistrationDate
CREATE TABLE Users(
    UserID INT UNIQUE,
    Username VARCHAR(20) UNIQUE,
    Password VARCHAR(20) NOT NULL,
    Role INT,
    Email VARCHAR(255) UNIQUE,
    RegistrationDate Datetime,
    PRIMARY KEY (UserID),
    FOREIGN KEY (Role) REFERENCES Roles (RoleID)
);



-- Entries: Store knowledge entries
--     EntryID (PK)
--     Title (Unique)
--     Topic/SubTitle
--     Order    (INT?) changed name to Index***
--     Content
--     AuthorID (FK, to Users.UserID)
--     CreatedDate
--     LastModifyDate
--     KnowledgeLevel
CREATE TABLE Entries(
    EntryID INT AUTO_INCREMENT,
    Title VARCHAR(50) UNIQUE,
    Topic VARCHAR(255),
    PositionIndex INT,
    Content TEXT,
    AuthorID INT,
    CreatedDate Datetime,
    LastModified DateTime,
    KnowledgeLevel INT,
    PRIMARY KEY (EntryID),
    FOREIGN KEY (AuthorID) REFERENCES Users (UserID)
);

-- ModificationRecords: Store modification records of entries
--     RecordID (PK)
--     UserID (FK, to Users.UserID)
--     ModificationTimestamp
CREATE TABLE ModificationRecords(
    RecordID INT AUTO_INCREMENT,
    UserID INT,
    ModificationTimestamp Datetime,
    PRIMARY KEY(RecordID),
    FOREIGN KEY(UserID) REFERENCES Users (UserID)
);


-- EntryTags: Store many-to-many relationships between entries and tags
--     EntryTagID (PK)
--     EntryID (FK, to Entries.EntryID)
--     TagID (FK, to Tags.TagID)
CREATE TABLE EntryTags(
    EntryTagID INT,
    EntryID INT,
    TagID INT,
    PRIMARY KEY(EntryTagID),
    FOREIGN KEY(EntryID) REFERENCES Entries (EntryID),
    FOREIGN KEY(TagID) REFERENCES Tags (TagID)
);