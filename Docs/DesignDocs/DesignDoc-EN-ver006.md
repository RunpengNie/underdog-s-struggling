# **Underdogs' Struggling Design Document**

## 1. Tech Stack Overview

#### (1) Frontend
- Framework: React-next.js

#### (2) Backend
- Coding Language: Java
- Ecosystem: Restful API/Spring Cloud/Spring Boot/MySQL

## 2. Deployment

#### (1) FrontEnd
- AWS S3 Bucket
- AWS CloudFront
- Reference Link: [Building and Serving React-Next.js from AWS S3](https://stackoverflow.com/questions/73913516/building-and-serving-react-nextjs-from-aws-s3)

#### (2) BackEnd and Service
- Domain Name: Cloudflare
- Vercel: maybe take a look later

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
#### (3) 

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
    ~~- IsPaidMember~~

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
    - Order
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

