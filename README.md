# mjkf-xmtx
## 项目结构
——mjkf-xmtx   父项目，pom工程，定义统一依赖信息

————mjkf-xmtx-geteway   网关

————mjkf-xmtx-eureka    注册中心:port:1000

————mjkf-xmtx-common  公共项目

————mjkf-xmtx-provider  提供服务

——————mjkf-xmtx-provider-admin  管理员服务:提供用户管理、权限管理和招聘会管理等服务。port：2001

——————mjkf-xmtx-provider-user   用户服务：提供用户管理（包括普通用户和企业）port：2002

——————mjkf-xmtx-provider-jobFair    招聘会服务：提供招聘会管理服务 port：2003

——————mjkf-xmtx-provider-forum   论坛服务：提供论坛服务 port：2004

————mjkf-xmtx-provider  服务暴露的接口

## 当前任务：（优先级从高到低）
1. 完成招聘信息发布功能
2. 完成招聘信息评论功能
3. 完成前端页面
4. 完善数据库表结构和内容
5. 完善权限系统

