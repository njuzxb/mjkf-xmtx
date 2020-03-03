# mjkf-xmtx
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

——————mjkf-xmtx-provider-talk   明说服务：提供发帖服务 port：2005

——————mjkf-xmtx-provider-talkComment   明说评论服务：提供贴子评论服务 port：2005

————mjkf-xmtx-provider-api  服务暴露的接口

——————mjkf-xmtx-provider-api-jobfair  招聘会服务接口 

——————mjkf-xmtx-provider-api-jobfairComment  招聘会评论服务接口 

————mjkf-xmtx-webui  前端web模块：存放前端项目文件，调用服务接口   port：80

## 当前任务：（优先级从高到低）
1. 完善数据库表结构和内容
2. 完善权限系统
3. 完善持续部署

## 已完成：
1. eureka服务注册中心的搭建
2. 招聘会服务
3. 招聘会评论服务
4. 招聘会服务接口
5. 招聘会评论服务接口
6. 前端web模块基本搭建
7. 前后端对接

