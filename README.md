# mjkf-xmtx
## 项目介绍
小明同学是一个信息发布及交流平台，面向对象是企业和学生，为企业提供一个统一的招聘会信息发布平台，提高招聘会人气，同时提供论坛服务，用户可在论坛讨论有关招聘的信息，也可以在其中发布招聘、实习和内推等帖子。

项目采用SpringCloud框架搭建，注册中心：eureka，服务调用：feign，缓存：redis，数据库：MySQL，数据库映射框架：JPA
## 项目结构
——mjkf-xmtx   父项目，pom工程，定义统一依赖信息

————mjkf-xmtx-geteway   网关

————mjkf-xmtx-eureka    注册中心:port:1000

————mjkf-xmtx-common  公共项目：存放公共的VO、PO、Utils等

————mjkf-xmtx-provider  提供服务

——————mjkf-xmtx-provider-admin  管理员服务:提供用户管理、权限管理和招聘会管理等服务。port：2001

——————mjkf-xmtx-provider-user   用户服务：提供用户管理（包括普通用户和企业）port：2002

——————mjkf-xmtx-provider-jobfair    招聘会服务：提供招聘会管理服务 port：2003

——————mjkf-xmtx-provider-jobfairComment    招聘会评论服务：提供招聘会评论管理服务 port：2004

——————mjkf-xmtx-provider-forum   论坛服务：提供发帖服务 port：2005

——————mjkf-xmtx-provider-forumComment   论坛评论服务：提供贴子评论服务 port：2005

——————mjkf-xmtx-provider-redis   redis服务：提供redis服务 port：3000

————mjkf-xmtx-provider-api  服务暴露的接口

——————mjkf-xmtx-provider-api-jobfair  招聘会服务接口 

——————mjkf-xmtx-provider-api-jobfairComment  招聘会评论服务接口 

——————mjkf-xmtx-provider-api-redis redis服务接口 

————mjkf-xmtx-webui  前端web模块：存放前端项目文件，调用服务接口   port：80


