/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : citystory

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2014-02-23 16:49:32
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
INSERT INTO `p_province` VALUES ('06d28eea-4f97-4568-90d3-50dad8528d77', '安徽');
INSERT INTO `p_province` VALUES ('12ac3e43-aba1-4411-86d7-f4bf0e926a60', '安徽');
INSERT INTO `p_province` VALUES ('159841d6-84c4-45c4-b755-a543917628ad', '安徽');
INSERT INTO `p_province` VALUES ('2bde0568-7b34-492a-bd54-6a369feab6ae', '安徽');
INSERT INTO `p_province` VALUES ('490890f6-531c-499b-9822-4b1c1aeb275e', '安徽');
INSERT INTO `p_province` VALUES ('4f80de29-51dd-4b94-a65a-c8b770e43b73', '安徽');
INSERT INTO `p_province` VALUES ('51be3db3-6da9-427e-9011-acd2ec85457d', '安徽');
INSERT INTO `p_province` VALUES ('5e4c1f0a-0c19-4637-9db7-d0031cb9cdd4', '安徽');
INSERT INTO `p_province` VALUES ('64f6b125-6e6c-429c-b4e4-c43981ed94ba', '安徽');
INSERT INTO `p_province` VALUES ('68f5e4eb-4927-4ba7-8b96-1b6533ad6654', '安徽');
INSERT INTO `p_province` VALUES ('6a2cfa06-9317-4e55-97db-2ce7a64c07b3', '安徽');
INSERT INTO `p_province` VALUES ('6c163a78-d960-4676-b665-92e20442d193', '安徽');
INSERT INTO `p_province` VALUES ('6c86887b-afa5-44ab-b2ab-574bf9514e70', '安徽');
INSERT INTO `p_province` VALUES ('6e43c303-dd96-44f0-b043-08b826ede9ce', '安徽');
INSERT INTO `p_province` VALUES ('73c0f080-daf5-492a-854f-98a444b6fc13', '安徽');
INSERT INTO `p_province` VALUES ('758e6852-a60e-434f-bca9-cfc07d223475', '安徽');
INSERT INTO `p_province` VALUES ('797c54e2-fbef-4e1f-9388-c3bbc0966f42', '安徽');
INSERT INTO `p_province` VALUES ('7a2dded3-ee4f-4f63-ae84-17af0e4be41a', '安徽');
INSERT INTO `p_province` VALUES ('8c61adf5-bf0f-4697-97b4-795532335501', '安徽');
INSERT INTO `p_province` VALUES ('9b859677-f328-4d1f-a53d-c009491521b4', '安徽');
INSERT INTO `p_province` VALUES ('9f3eab84-bbf2-4dbb-9bdd-194f4b1bf549', '安徽');
INSERT INTO `p_province` VALUES ('ae547d8a-5ad5-4c3d-9e18-8509d91a1669', '安徽');
INSERT INTO `p_province` VALUES ('b5f450b2-f0f2-4c14-887c-dfbc8fafca41', '安徽');
INSERT INTO `p_province` VALUES ('ba6122cf-6901-4434-9653-78098e3af908', '安徽');
INSERT INTO `p_province` VALUES ('ba87b615-fa24-4fcf-ae17-08e594db3c23', '安徽');
INSERT INTO `p_province` VALUES ('c043873b-45a9-4b0a-bcd7-697729feb899', '安徽');
INSERT INTO `p_province` VALUES ('c945bd26-d3c5-4b83-8de5-86aca9f09159', '安徽');
INSERT INTO `p_province` VALUES ('d5488cee-4585-482c-b5e2-c8b530fac385', '安徽');
INSERT INTO `p_province` VALUES ('e1bd47d4-9598-4899-bda7-0e2d24fe8d5c', '安徽');
INSERT INTO `p_province` VALUES ('ea4b5874-dec2-46e5-8f2c-ecd349aff7bb', '安徽');
INSERT INTO `p_province` VALUES ('f2be7a8d-7a01-4cea-8fa2-69fe50eb1cb9', '湖北');
INSERT INTO `p_province` VALUES ('f3edb56c-3375-4223-a17d-1d85a1c28bc9', '安徽');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('d21c410d-70e9-405d-8a43-2ebde2f4f014', 'xiaowang', '123', '15', null, null, null);
INSERT INTO `u_user` VALUES ('d561a752-7a44-486b-a743-0e1982e16481', 'xiaowang', '15', 'asdff', null, null, null);
INSERT INTO `u_user` VALUES ('f08d7683-4aea-4c36-9cac-bde06ef57e13', '大家好', '15', 'asdff', null, null, null);
