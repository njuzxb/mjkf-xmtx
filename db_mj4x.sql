/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : db_mj4x

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-04-10 17:39:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL COMMENT '盐_用于哈希加密',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for browsing_history
-- ----------------------------
DROP TABLE IF EXISTS `browsing_history`;
CREATE TABLE `browsing_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jobid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `gmt_browsing` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for enterprise_info
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_info`;
CREATE TABLE `enterprise_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_name` char(255) NOT NULL,
  `logo` varchar(255) DEFAULT NULL COMMENT '商户logo',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `website` varchar(255) DEFAULT NULL COMMENT '官网',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job_fair
-- ----------------------------
DROP TABLE IF EXISTS `job_fair`;
CREATE TABLE `job_fair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `promoter` char(255) NOT NULL,
  `meeting_time` date DEFAULT NULL COMMENT '宣讲会时间',
  `address` varchar(255) DEFAULT NULL COMMENT '宣讲会地址',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '官网',
  `db_source` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`),
  KEY `fk_enterprise_on_cid` (`eid`),
  CONSTRAINT `fk_enterprise_on_cid` FOREIGN KEY (`eid`) REFERENCES `enterprise_info` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job_fair_comment
-- ----------------------------
DROP TABLE IF EXISTS `job_fair_comment`;
CREATE TABLE `job_fair_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobid` int(11) DEFAULT NULL,
  `username` char(255) DEFAULT NULL,
  `content` longtext,
  `pubtime` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `prove` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `gmt_create` date DEFAULT NULL COMMENT '宣讲会时间',
  `gmt_modified` date DEFAULT NULL COMMENT '宣讲会时间',
  `eid` int(11) DEFAULT NULL,
  `is_enterprise` tinyint(1) DEFAULT NULL COMMENT '权限',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
