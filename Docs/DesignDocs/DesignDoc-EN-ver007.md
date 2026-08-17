# **Underdogs' Struggling Design Document**

ver007 / 2026-08-16

## 1. Tech Stack Overview

#### (1) Frontend
- Framework: React-next.js

#### (2) Backend
- Coding Language: Java
- Ecosystem: Restful API/Spring Cloud/Spring Boot/MySQL

## 2. Deployment

Step 1 (local run for development) and step 2 (small-scale launch) are defined in [DeploymentPlan-CN-ver001.md](DeploymentPlan-CN-ver001.md), including the frontend hosting used before step 3. This section only describes the step-3 target.

#### (1) FrontEnd
- AWS S3 Bucket
- AWS CloudFront
- Reference Link: [Building and Serving React-Next.js from AWS S3](https://stackoverflow.com/questions/73913516/building-and-serving-react-nextjs-from-aws-s3)

#### (2) BackEnd and Service
- Domain Name: Cloudflare

## 3. Program Logic

### 3.1. Backend Design

#### (1) Basic Entity Design
  - Role
  - User
  - ModificationRecord
  - Tag
  - Entry
  - Language
#### (2) 3 different type of users and guests
  - Administrator/Developer
  - VIP user(Paid user)
  - Registered User
  - Guest User/Unregistered User(they won't appear in our database)
#### (3) Program Logic and Features
  - The goal of the Underdogs' Struggling project is a highly customizable and structured note-taking tool that allows registered users to create and edit structured notes
  - Notes are presented as pages. One note can be displayed on a single page (i.e. all of its content at once), or across multiple pages (split display)
  - Notes exist in the form of knowledge entries (Entry)
  - Besides EntryID (PK), an Entry has its own Title. When displayed on a page, each Entry can be expanded/collapsed by its Title
  - An Entry also has PositionIndex, which determines the display order of the Entry on a page
  - The Content of an Entry holds the actual body of that Entry, supporting text and images (audio may be supported in the future)
  - The KnowledgeLevel of an Entry determines the level of the knowledge (e.g. beginner, intermediate, advanced), which allows one note to be presented as several notes targeting audiences of different levels
  - Entries also support filtering by tag; one or more Entries can be located through a Tag
  - Entries support multilingual storage (e.g. Chinese and English)

### 3.2. Frontend Design

#### 3.2.1. Page Design

#### (1) Display Page 
  - Page should contain a filter on the left side and a display area for entries
  - URL: /#
  - filter description: it is a scroll-down menu like Github style (go check it before implement)

#### 3.2.2. Component Design

#### (1) Entry Component
  - A unified format of displaying entries that returns from the request
  - URL: /entry/[EntryId]
  - Main content can support markdown format
  - Topic and subtopic should be bold and have different font from the main content
  - It should have broder line like a note-like card 

## 4. Database
#### (1) Overview
- MySQL: Store text content, user information, and text editing records
- AWS S3 Bucket: Store graphical data

#### (2) MySQL Database Design
- ##### Roles: Store roles information
    - RoleID (PK)
    - RoleName

- ##### Users: Store user information
    - UserID (PK)
    - UserName
    - Password
    - Role (FK, to Roles.RoleID)
    - Email (Unique)
    - RegistrationDate
    - ~~IsPaidMember~~ (dropped; whether a user is a paid member is determined by Role)

- ##### ModificationRecords: Store modification records of entries(Do we really need this???)
    - RecordID (PK)
    - EntryID (FK, to Entries.EntryID)
    - UserID (FK, to Users.UserID)
    - ModificationTimestamp

- ##### Tags: Store different tags
  - TagID (PK)
  - TagName

- ##### EntryTags: Store many-to-many relationships between entries and tags
  - EntryTagID (PK)
  - EntryID (FK, to Entries.EntryID)
  - TagID (FK, to Tags.TagID)

- ##### Entries: Store knowledge entries
    - EntryID (PK)
    - Title
    - Topic/SubTitle
    - PositionIndex (renamed from Order, which is a MySQL reserved word)
    - Content
    - AuthorID (FK, to Users.UserID)
    - LanguageID (FK, to Languages.LanguageID)
    - CreatedDate
    - LastModificationID (FK, to ModificationRecords.RecordID)
    - KnowledgeLevel

- ##### Languages:
    - LanguageID(PK)
    - LanguageCode
    - LanguageName

##### (3) 
## 4. Milestones
(1) Create a web project that can be run locally with some content and a simple UI

(2) Ensure that the locally running project has relatively complete content, a simple UI, and basic user registration and management functions

(3) Deploy the project to the remote end and access it through the domain name; support user registration, management, and other functions

(4) Include richer content, including bilingual pages, advertisements, and beautiful UI

(5) Achieve more mature technology, better security, and increased carrying capacity
