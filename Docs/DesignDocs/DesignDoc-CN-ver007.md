# **Underdogs' Struggling 设计文档**

ver007 / 2026-08-16

## 1. 技术栈概览

#### (1) 前端
- 框架：React-next.js

#### (2) 后端
- 编程语言：Java
- 生态：Restful API/Spring Cloud/Spring Boot/MySQL

## 2. 部署

第一步（开发期本地运行）和第二步（小规模上线）在 [DeploymentPlan-CN-ver001.md](DeploymentPlan-CN-ver001.md) 中定义，第三步之前使用的前端托管方式也在该文档中。本节只描述第三步的目标形态。

#### (1) 前端
- AWS S3 Bucket
- AWS CloudFront
- 参考链接：[Building and Serving React-Next.js from AWS S3](https://stackoverflow.com/questions/73913516/building-and-serving-react-nextjs-from-aws-s3)

#### (2) 后端与服务
- 域名：Cloudflare

## 3. 程序逻辑

### 3.1. 后端设计

#### (1) 基础实体设计
  - Role
  - User
  - ModificationRecord
  - Tag
  - Entry
  - Language
#### (2) 3 种不同类型的用户及访客
  - 管理员/开发者
  - VIP 用户（付费用户）
  - 注册用户
  - 访客/未注册用户（他们不会出现在我们的数据库中）
#### (3) 程序逻辑和功能
  - Underdogs' Struggling 项目的目标是一个高度自定义化且结构化的笔记工具，允许注册用户创建并修改结构化的笔记
  - 笔记以页面的方式展示，同一个笔记可以展示在一个页面上（即展示所有内容），也可以展示在多个页面上（分页面展示）
  - 笔记以知识词条（Entry）的形式存在
  - 除了 EntryID（主键）之外，Entry 拥有自己的 Title，每个 Entry 在页面展示时可以根据 Title 展开/折叠
  - Entry 还拥有 PositionIndex，PositionIndex 决定了 Entry 在页面上的展示顺序
  - Entry 的 Content 包含了这个 Entry 的具体内容，支持文字和图片（未来可以支持音频）
  - Entry 的 KnowledgeLevel 决定了知识的具体等级（比如初级，中级，高级），允许将一份笔记展示为面向不同水平人群的多份笔记
  - Entry 同时支持按照标签过滤，可以通过 Tag 确认一条到多条 Entry
  - Entry 支持多语言存储（比如中文和英文）

### 3.2. 前端设计

#### 3.2.1. 页面设计

#### (1) 展示页 
  - 页面左侧应包含一个筛选器，以及一块用于展示词条的区域
  - URL：/#
  - 筛选器说明：它是一个类似 Github 风格的下拉菜单（实现前先去看一下）

#### 3.2.2. 组件设计

#### (1) 词条组件
  - 用统一的格式展示请求返回的词条
  - URL：/entry/[EntryId]
  - 正文内容可以支持 markdown 格式
  - Topic 和 subtopic 应加粗，并使用与正文不同的字体
  - 它应该有边框线，像一张笔记式的卡片 

## 4. 数据库
#### (1) 概览
- MySQL：存储文本内容、用户信息和文本编辑记录
- AWS S3 Bucket：存储图形数据

#### (2) MySQL 数据库设计
- ##### Roles：存储角色信息
    - RoleID (PK)
    - RoleName

- ##### Users：存储用户信息
    - UserID (PK)
    - UserName
    - Password
    - Role (FK, to Roles.RoleID)
    - Email (Unique)
    - RegistrationDate
    - ~~IsPaidMember~~（已废弃；用户是否为付费会员由 Role 决定）

- ##### ModificationRecords：存储词条的修改记录（我们真的需要这个吗？？？）
    - RecordID (PK)
    - EntryID (FK, to Entries.EntryID)
    - UserID (FK, to Users.UserID)
    - ModificationTimestamp

- ##### Tags：存储不同的标签
  - TagID (PK)
  - TagName

- ##### EntryTags：存储词条与标签之间的多对多关系
  - EntryTagID (PK)
  - EntryID (FK, to Entries.EntryID)
  - TagID (FK, to Tags.TagID)

- ##### Entries：存储知识词条
    - EntryID (PK)
    - Title
    - Topic/SubTitle
    - PositionIndex（原名 Order，因 Order 是 MySQL 保留字而改名）
    - Content
    - AuthorID (FK, to Users.UserID)
    - LanguageID (FK, to Languages.LanguageID)
    - CreatedDate
    - LastModificationID (FK, to ModificationRecords.RecordID)
    - KnowledgeLevel

- ##### Languages：
    - LanguageID(PK)
    - LanguageCode
    - LanguageName

##### (3) 
## 4. 里程碑
(1) 创建一个可以在本地运行、包含部分内容并具有简陋 UI 的网页项目

(2) 确保本地运行的项目拥有较为完整的内容、简单的 UI，以及基本的用户注册和管理功能

(3) 将项目部署到远端，并可以通过域名访问；支持用户注册、管理等功能

(4) 包含更丰富的内容，包括双语页面、广告和美观的 UI

(5) 实现更成熟的技术、更好的安全性和更高的承载能力
