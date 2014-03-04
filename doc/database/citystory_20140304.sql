/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : citystory

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2014-03-04 14:38:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `a_oauth`
-- ----------------------------
DROP TABLE IF EXISTS `a_oauth`;
CREATE TABLE `a_oauth` (
  `userId` varchar(50) DEFAULT NULL,
  `accessToken` varchar(50) NOT NULL DEFAULT '',
  `refreshToken` varchar(50) DEFAULT NULL,
  `updateTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`accessToken`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_oauth
-- ----------------------------
INSERT INTO `a_oauth` VALUES ('061a60e9-8464-4e60-b116-4ef27240c3e3', '3c213f54a856096c60a5eb896c339d21', '2680a07dbefa483352c96e99accaf4fd', '1393911029199');
INSERT INTO `a_oauth` VALUES ('0867cf98-8322-4236-a72d-5c45d25c316a', 'ea11a81f5e59c18814f7aa9c2ebc0397', 'fba58bf86307a14d0f6215a75ad2c01b', '1393911126827');

-- ----------------------------
-- Table structure for `i_thingtype`
-- ----------------------------
DROP TABLE IF EXISTS `i_thingtype`;
CREATE TABLE `i_thingtype` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_thingtype
-- ----------------------------

-- ----------------------------
-- Table structure for `i_topic`
-- ----------------------------
DROP TABLE IF EXISTS `i_topic`;
CREATE TABLE `i_topic` (
  `id` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(400) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `provinceId` varchar(50) DEFAULT NULL,
  `cityId` varchar(50) DEFAULT NULL,
  `thingTypeId` varchar(50) DEFAULT NULL,
  `imageUrl` varchar(100) DEFAULT NULL,
  `publishTime` bigint(20) DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of i_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `p_city`
-- ----------------------------
DROP TABLE IF EXISTS `p_city`;
CREATE TABLE `p_city` (
  `id` varchar(50) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `provinceId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_city
-- ----------------------------
INSERT INTO `p_city` VALUES ('12324234', '是的发生', 'f2be7a8d-7a01-4cea-8fa2-69fe50eb1cb9');
INSERT INTO `p_city` VALUES ('232333', '你好随碟附送', 'f2be7a8d-7a01-4cea-8fa2-69fe50eb1cb9');
INSERT INTO `p_city` VALUES ('33', '3234234234', 'f2be7a8d-7a01-4cea-8fa2-69fe50eb1cb9');

-- ----------------------------
-- Table structure for `p_province`
-- ----------------------------
DROP TABLE IF EXISTS `p_province`;
CREATE TABLE `p_province` (
  `id` varchar(50) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_province
-- ----------------------------
INSERT INTO `p_province` VALUES ('28a63eb9-ddc8-42ec-8b52-dd5f4a4dfd53', '你好呀');
INSERT INTO `p_province` VALUES ('5c3ad644-bc9f-4464-956e-0714dc62fa61', 'asdf');
INSERT INTO `p_province` VALUES ('5fb20ba3-9dea-4687-aeb2-140c437c271c', 'asdf');
INSERT INTO `p_province` VALUES ('8c885961-7d83-4f23-acfa-d18e92b1578b', 'a');
INSERT INTO `p_province` VALUES ('9764f64e-4d6f-4735-b943-60dc310ae6a7', 's');
INSERT INTO `p_province` VALUES ('9c580cc8-4eba-4f96-81cb-b9fe22996153', '我操d');
INSERT INTO `p_province` VALUES ('9cf6981b-6933-4f11-af1a-c41a22135585', 'sadf');
INSERT INTO `p_province` VALUES ('9e22ef97-7679-4584-b183-220e96d9795e', 'dd');
INSERT INTO `p_province` VALUES ('a8942c50-98ff-4be8-a8f8-4e41c7fcf0df', 'sdfas ');
INSERT INTO `p_province` VALUES ('cc1c0682-8a0d-4206-9049-4d119bceab0c', 'dsds');
INSERT INTO `p_province` VALUES ('e3f8deae-42ff-4edd-b97c-92bec65f3073', 'asdf');
INSERT INTO `p_province` VALUES ('f5225ca2-0632-4dac-898f-ce26e28363c9', 'sdf');

-- ----------------------------
-- Table structure for `u_user`
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `cityId` varchar(50) DEFAULT NULL,
  `cityName` varchar(10) DEFAULT NULL,
  `province
provinceId` varchar(50) DEFAULT NULL,
  `provinceName` varchar(10) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `registTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('061a60e9-8464-4e60-b116-4ef27240c3e3', 'niya001', '12', null, null, null, null, '12', '1393834761742');
INSERT INTO `u_user` VALUES ('0867cf98-8322-4236-a72d-5c45d25c316a', 'niya002', '30', null, null, null, null, '12', null);
