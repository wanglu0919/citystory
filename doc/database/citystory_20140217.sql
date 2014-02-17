/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : citystory

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2014-02-17 17:16:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `p_city`
-- ----------------------------
DROP TABLE IF EXISTS `p_city`;
CREATE TABLE `p_city` (
  `id` varchar(25) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `provinceId` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_city
-- ----------------------------

-- ----------------------------
-- Table structure for `p_province`
-- ----------------------------
DROP TABLE IF EXISTS `p_province`;
CREATE TABLE `p_province` (
  `id` varchar(25) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_province
-- ----------------------------

-- ----------------------------
-- Table structure for `u_user`
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `cityId` varchar(25) DEFAULT NULL,
  `cityName` varchar(10) DEFAULT NULL,
  `province
provinceId` varchar(10) DEFAULT NULL,
  `provinceName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `U_USER` VALUES ('d21c410d-70e9-405d-8a43-2ebde2f4f014', 'xiaowang', '123', '15', null, null, null);
INSERT INTO `U_USER` VALUES ('d561a752-7a44-486b-a743-0e1982e16481', 'xiaowang', '15', 'asdff', null, null, null);
