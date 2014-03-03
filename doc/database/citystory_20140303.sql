/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : citystory

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2014-03-03 16:44:40
*/

SET FOREIGN_KEY_CHECKS=0;
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
  `accessToken` varchar(50) DEFAULT NULL,
  `tokenUpdatetTime` bigint(20) DEFAULT NULL,
  `registTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('061a60e9-8464-4e60-b116-4ef27240c3e3', '操', '12', null, null, null, null, 'sss', null, '1393834761742', '1393834761742');
INSERT INTO `u_user` VALUES ('0867cf98-8322-4236-a72d-5c45d25c316a', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('0ab84111-68c1-45f2-b21a-9b45b1fcd97b', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('0b0f9bcc-a1fc-488d-895a-bc11e901c7d3', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('0c426ff0-4580-4611-a326-5459d57ed8a3', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('10389a4f-928f-4d84-96ec-880360749001', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('10affa9d-c8ed-47fd-be07-d9fe0ed28fe9', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('3e67743c-d434-495a-90cd-f34c4c559ac4', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('4b7d9de3-85ff-40a9-9270-7403fa259828', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('63baf147-e5d9-4dc3-81f6-d55eb1349dbc', 'xiaops02', '12', null, null, null, null, 'sss', '323232', '1393833933361', '1393833933361');
INSERT INTO `u_user` VALUES ('73327ca2-f4d7-4da2-b157-53975fc92538', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('80bd80a9-759b-422f-b0bd-15a33a014c43', '操2', '12', null, null, null, null, 'sss', '44b97d7d191d66655ef907879339991c', '1393834858446', '1393834858446');
INSERT INTO `u_user` VALUES ('863e1f64-31f0-4a74-8716-a8d1e9d24117', 'xiaopang', '12', null, null, null, null, 'sss', null, null, null);
INSERT INTO `u_user` VALUES ('884cc488-e030-4032-8d02-0341f0b03e19', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('9a2b73da-0518-4ca7-a737-b0a48e6a779a', '', '12', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('a1f6a8f2-015e-4d4c-b7f5-120d6b97e5e6', 'sa3', '0', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('a715892a-cd07-476f-8ec7-129cae4f3f23', 'xiaopang08', '12', null, null, null, null, 'sss', '323232', '1393833859821', '1393833859821');
INSERT INTO `u_user` VALUES ('ac1dd685-42ea-4dcd-9764-4bdcc31b9430', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('dabc997f-4364-48d8-adf6-e68124d35413', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('ec8ef453-5ac8-47ed-95db-cc83a9170b23', 'xiao67', '12', null, null, null, null, 'sss', '323232', '1393833945898', '1393833945898');
INSERT INTO `u_user` VALUES ('f0f00d3b-5030-48e6-a77f-84427256c0e0', '我操', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('f3bcabcb-c37f-46f6-ade0-b386d99bcd24', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('f5061229-e6eb-48ff-8846-9ac5dc720048', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('fab514ee-0253-4a80-9018-713a91979322', 'xiaopang09', '12', null, null, null, null, 'sss', null, null, null);
INSERT INTO `u_user` VALUES ('fb0ba040-90a7-475d-8cc6-3cf47b08329e', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('fb405bfc-bd75-4ca2-a193-869108dd9260', '我操', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('fb415184-c8ee-4d1c-9be9-80820af38a38', 'sa3', '0', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('fb89f665-4190-4b80-8a13-1962b3d9de3c', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('fd58b9be-e556-4590-971f-30a9f53f3bed', 'sa2', '30', null, null, null, null, null, null, null, null);
INSERT INTO `u_user` VALUES ('fe42fc18-75d7-4968-ad44-8c2db4884821', 'sa2', '30', null, null, null, null, null, null, null, null);
