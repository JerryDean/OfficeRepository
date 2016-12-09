/*
Navicat MySQL Data Transfer

Source Server         : StreetLight - 197
Source Server Version : 50519
Source Host           : 192.168.0.197:3306
Source Database       : sl

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-12-09 21:52:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('117');
INSERT INTO `hibernate_sequence` VALUES ('117');

-- ----------------------------
-- Table structure for stl_asm_lifetime
-- ----------------------------
DROP TABLE IF EXISTS `stl_asm_lifetime`;
CREATE TABLE `stl_asm_lifetime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lifetime` int(11) DEFAULT NULL,
  `luminaire_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tracking_entity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_asm_lifetime
-- ----------------------------
INSERT INTO `stl_asm_lifetime` VALUES ('1', '300', '32', 'asdf', '1');
INSERT INTO `stl_asm_lifetime` VALUES ('2', '250', '32', 'css', '1');
INSERT INTO `stl_asm_lifetime` VALUES ('3', '120', '32', 'ee', '1');
INSERT INTO `stl_asm_lifetime` VALUES ('4', '20', '32', 'ww', '1');
INSERT INTO `stl_asm_lifetime` VALUES ('5', '30', '32', 'wwww', '1');

-- ----------------------------
-- Table structure for stl_asm_luminaire_model
-- ----------------------------
DROP TABLE IF EXISTS `stl_asm_luminaire_model`;
CREATE TABLE `stl_asm_luminaire_model` (
  `id` int(11) NOT NULL,
  `control_protocol` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lamp_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `built_in_light_sensor` bit(1) DEFAULT NULL,
  `manufacturer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `built_in_motion_sensor` bit(1) DEFAULT NULL,
  `pic_str` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `suppor_polling_method` bit(1) DEFAULT NULL,
  `rated_watt` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_asm_luminaire_model
-- ----------------------------
INSERT INTO `stl_asm_luminaire_model` VALUES ('52', 'DALI', 'sad', 'LED', '', 'sss', '32', '\0', '1', '', '35');
INSERT INTO `stl_asm_luminaire_model` VALUES ('65', 'DALI', 'weweq', 'LED', '\0', 'dsasdaas', '213211', '\0', '1', '\0', '322');
INSERT INTO `stl_asm_luminaire_model` VALUES ('113', 'DALI', '', 'LED', '\0', '', 'ee', '\0', '1', '\0', '23');

-- ----------------------------
-- Table structure for stl_asm_pole_model
-- ----------------------------
DROP TABLE IF EXISTS `stl_asm_pole_model`;
CREATE TABLE `stl_asm_pole_model` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `height` double DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pic_str` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_asm_pole_model
-- ----------------------------
INSERT INTO `stl_asm_pole_model` VALUES ('114', '77', '77', '77', '1', null);

-- ----------------------------
-- Table structure for stl_asm_thresholds_lifetime
-- ----------------------------
DROP TABLE IF EXISTS `stl_asm_thresholds_lifetime`;
CREATE TABLE `stl_asm_thresholds_lifetime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alert_msg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `severity_level` int(11) DEFAULT NULL,
  `threshold` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `config_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82gjoksx84nhk9aub8ww9oh1l` (`config_id`),
  CONSTRAINT `FK82gjoksx84nhk9aub8ww9oh1l` FOREIGN KEY (`config_id`) REFERENCES `stl_asm_lifetime` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_asm_thresholds_lifetime
-- ----------------------------
INSERT INTO `stl_asm_thresholds_lifetime` VALUES ('1', 'ffff', '2', '3', '2');

-- ----------------------------
-- Table structure for stl_atm_loginfo
-- ----------------------------
DROP TABLE IF EXISTS `stl_atm_loginfo`;
CREATE TABLE `stl_atm_loginfo` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describeinfo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `methodname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `objectid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `param` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_atm_loginfo
-- ----------------------------
INSERT INTO `stl_atm_loginfo` VALUES ('49', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":48,\"area\":\"gay\",\"kValue\":\"5\",\"other\":\"oooo\"}]', '2016-12-08 16:35:42', null);
INSERT INTO `stl_atm_loginfo` VALUES ('51', 'save', '保存能源管理配置', 'save', null, '[{\"id\":50,\"name\":\"jijikul2\",\"type\":\"Energy Usage\",\"trackingEntityType\":\"CMS-Streetlight\",\"thresholds\":[],\"luminaireTrackingCapability\":false,\"valueType\":\"\"}]', '2016-12-08 16:44:13', null);
INSERT INTO `stl_atm_loginfo` VALUES ('54', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":53,\"area\":\"gays\",\"kValue\":\"5\",\"other\":\"23\"}]', '2016-12-09 09:24:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('55', 'save', '删除二氧化碳设置信息', 'deleteCD', null, '[47]', '2016-12-09 09:24:14', null);
INSERT INTO `stl_atm_loginfo` VALUES ('57', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":56,\"kValue\":\"5\",\"other\":\"\"}]', '2016-12-09 10:56:37', null);
INSERT INTO `stl_atm_loginfo` VALUES ('59', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":58,\"kValue\":\"5\",\"other\":\"\"}]', '2016-12-09 11:01:32', null);
INSERT INTO `stl_atm_loginfo` VALUES ('60', 'save', '修改二氧化碳设置信息', 'update', null, '[{\"id\":53,\"area\":\"gays\",\"kValue\":\"5\",\"other\":\"23\"}]', '2016-12-09 11:41:22', null);
INSERT INTO `stl_atm_loginfo` VALUES ('61', 'save', '修改二氧化碳设置信息', 'update', null, '[{\"id\":53,\"area\":\"gays\",\"kValue\":\"3\",\"other\":\"23\"}]', '2016-12-09 11:41:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('63', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":62,\"area\":\"322\",\"kValue\":\"3\",\"other\":\"dfd\"}]', '2016-12-09 11:42:55', null);
INSERT INTO `stl_atm_loginfo` VALUES ('69', 'save', '删除二氧化碳设置信息', 'deleteCD', null, '[56]', '2016-12-09 17:14:37', null);
INSERT INTO `stl_atm_loginfo` VALUES ('70', 'save', '删除二氧化碳设置信息', 'deleteCD', null, '[58]', '2016-12-09 17:14:38', null);
INSERT INTO `stl_atm_loginfo` VALUES ('71', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[1]', '2016-12-09 17:14:48', null);
INSERT INTO `stl_atm_loginfo` VALUES ('72', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[1]', '2016-12-09 17:14:48', null);
INSERT INTO `stl_atm_loginfo` VALUES ('73', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[1]', '2016-12-09 17:14:48', null);
INSERT INTO `stl_atm_loginfo` VALUES ('74', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[1]', '2016-12-09 17:14:49', null);
INSERT INTO `stl_atm_loginfo` VALUES ('75', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[3]', '2016-12-09 17:14:50', null);
INSERT INTO `stl_atm_loginfo` VALUES ('76', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[5]', '2016-12-09 17:14:51', null);
INSERT INTO `stl_atm_loginfo` VALUES ('77', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[7]', '2016-12-09 17:14:52', null);
INSERT INTO `stl_atm_loginfo` VALUES ('78', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[9]', '2016-12-09 17:14:53', null);
INSERT INTO `stl_atm_loginfo` VALUES ('79', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[5]', '2016-12-09 17:14:57', null);
INSERT INTO `stl_atm_loginfo` VALUES ('80', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[3]', '2016-12-09 17:14:58', null);
INSERT INTO `stl_atm_loginfo` VALUES ('81', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[9]', '2016-12-09 17:14:59', null);
INSERT INTO `stl_atm_loginfo` VALUES ('82', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[25]', '2016-12-09 17:15:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('83', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[42]', '2016-12-09 17:15:03', null);
INSERT INTO `stl_atm_loginfo` VALUES ('84', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:07', null);
INSERT INTO `stl_atm_loginfo` VALUES ('85', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[41]', '2016-12-09 17:15:08', null);
INSERT INTO `stl_atm_loginfo` VALUES ('86', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[50]', '2016-12-09 17:15:24', null);
INSERT INTO `stl_atm_loginfo` VALUES ('87', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('88', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:30', null);
INSERT INTO `stl_atm_loginfo` VALUES ('89', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:31', null);
INSERT INTO `stl_atm_loginfo` VALUES ('90', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[37]', '2016-12-09 17:15:32', null);
INSERT INTO `stl_atm_loginfo` VALUES ('91', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:33', null);
INSERT INTO `stl_atm_loginfo` VALUES ('92', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[35]', '2016-12-09 17:15:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('93', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[33]', '2016-12-09 17:15:35', null);
INSERT INTO `stl_atm_loginfo` VALUES ('94', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[31]', '2016-12-09 17:15:35', null);
INSERT INTO `stl_atm_loginfo` VALUES ('95', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[29]', '2016-12-09 17:15:36', null);
INSERT INTO `stl_atm_loginfo` VALUES ('96', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:43', null);
INSERT INTO `stl_atm_loginfo` VALUES ('97', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:44', null);
INSERT INTO `stl_atm_loginfo` VALUES ('98', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:45', null);
INSERT INTO `stl_atm_loginfo` VALUES ('99', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:15:46', null);
INSERT INTO `stl_atm_loginfo` VALUES ('100', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[37]', '2016-12-09 17:15:47', null);
INSERT INTO `stl_atm_loginfo` VALUES ('101', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[35]', '2016-12-09 17:15:47', null);
INSERT INTO `stl_atm_loginfo` VALUES ('102', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[33]', '2016-12-09 17:15:48', null);
INSERT INTO `stl_atm_loginfo` VALUES ('103', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[31]', '2016-12-09 17:15:49', null);
INSERT INTO `stl_atm_loginfo` VALUES ('104', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[1]', '2016-12-09 17:36:54', null);
INSERT INTO `stl_atm_loginfo` VALUES ('105', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[39]', '2016-12-09 17:36:57', null);
INSERT INTO `stl_atm_loginfo` VALUES ('106', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[37]', '2016-12-09 17:36:58', null);
INSERT INTO `stl_atm_loginfo` VALUES ('107', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[35]', '2016-12-09 17:36:59', null);
INSERT INTO `stl_atm_loginfo` VALUES ('108', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[23]', '2016-12-09 17:37:09', null);
INSERT INTO `stl_atm_loginfo` VALUES ('109', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[19]', '2016-12-09 17:38:02', null);
INSERT INTO `stl_atm_loginfo` VALUES ('110', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[19]', '2016-12-09 17:38:03', null);
INSERT INTO `stl_atm_loginfo` VALUES ('111', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[17]', '2016-12-09 17:38:23', null);
INSERT INTO `stl_atm_loginfo` VALUES ('112', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[19]', '2016-12-09 17:38:24', null);
INSERT INTO `stl_atm_loginfo` VALUES ('115', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[1]', '2016-12-09 19:25:38', null);
INSERT INTO `stl_atm_loginfo` VALUES ('116', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[9]', '2016-12-09 19:25:41', null);

-- ----------------------------
-- Table structure for stl_cpm_calendar_profile
-- ----------------------------
DROP TABLE IF EXISTS `stl_cpm_calendar_profile`;
CREATE TABLE `stl_cpm_calendar_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commisioned_date` date DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `dmg_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_cpm_calendar_profile
-- ----------------------------

-- ----------------------------
-- Table structure for stl_cpm_scheduling_rule
-- ----------------------------
DROP TABLE IF EXISTS `stl_cpm_scheduling_rule`;
CREATE TABLE `stl_cpm_scheduling_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `recurrent_pattern` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `scheduler_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `plan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK25kprmt9oyv1362hkfxqsty66` (`plan_id`),
  CONSTRAINT `FK25kprmt9oyv1362hkfxqsty66` FOREIGN KEY (`plan_id`) REFERENCES `stl_cpm_calendar_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_cpm_scheduling_rule
-- ----------------------------

-- ----------------------------
-- Table structure for stl_dgm_group
-- ----------------------------
DROP TABLE IF EXISTS `stl_dgm_group`;
CREATE TABLE `stl_dgm_group` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` int(11) NOT NULL,
  `reserve1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_dgm_group
-- ----------------------------

-- ----------------------------
-- Table structure for stl_dpm_command
-- ----------------------------
DROP TABLE IF EXISTS `stl_dpm_command`;
CREATE TABLE `stl_dpm_command` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commandtiming` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `commandtype` int(11) DEFAULT NULL,
  `commandvalue` int(11) DEFAULT NULL,
  `starttime` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `timmingtype` int(11) DEFAULT NULL,
  `daily_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmow526jxvmrx6bcmf618xawxj` (`daily_name`),
  CONSTRAINT `FKmow526jxvmrx6bcmf618xawxj` FOREIGN KEY (`daily_name`) REFERENCES `stl_dpm_dailyprofile` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_dpm_command
-- ----------------------------

-- ----------------------------
-- Table structure for stl_dpm_dailyprofile
-- ----------------------------
DROP TABLE IF EXISTS `stl_dpm_dailyprofile`;
CREATE TABLE `stl_dpm_dailyprofile` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_dpm_dailyprofile
-- ----------------------------

-- ----------------------------
-- Table structure for stl_gzm_gzone
-- ----------------------------
DROP TABLE IF EXISTS `stl_gzm_gzone`;
CREATE TABLE `stl_gzm_gzone` (
  `gzone_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gzone_area` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dimming_group_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`gzone_id`),
  KEY `FKnsi0i4xl5a1p08t8n5lemq9xb` (`dimming_group_id`),
  CONSTRAINT `FKnsi0i4xl5a1p08t8n5lemq9xb` FOREIGN KEY (`dimming_group_id`) REFERENCES `stl_dgm_group` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_gzm_gzone
-- ----------------------------
INSERT INTO `stl_gzm_gzone` VALUES ('85c0bc4d-d480-4836-8315-0cf649d33c5e', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.7043846130371,1.3581932067871096],[103.73219375610351,1.3496101379394534],[103.71880416870117,1.3262641906738284],[103.68653182983398,1.300858306884766],[103.67005233764648,1.3399971008300784],[103.6879051208496,1.3674629211425784],[103.7043846130371,1.3581932067871096]]]},\"properties\":{\"type\":\"geozone\",\"gzoneId\":\"85c0bc4d-d480-4836-8315-0cf649d33c5e\",\"name\":\"13\",\"other\":null}}', '131', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('8c563c07-0ea9-4344-8616-1916fe9c5154', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.82111434936523,1.3760459899902346],[103.84755020141601,1.370896148681641],[103.86059646606445,1.3430870056152346],[103.83793716430664,1.3166511535644534],[103.81321792602539,1.3025749206542971],[103.77991561889648,1.3331306457519534],[103.82111434936523,1.3760459899902346]]]},\"properties\":null}', '566', null, null);

-- ----------------------------
-- Table structure for stl_gzm_gzoneandlamprelation
-- ----------------------------
DROP TABLE IF EXISTS `stl_gzm_gzoneandlamprelation`;
CREATE TABLE `stl_gzm_gzoneandlamprelation` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gzoneId` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lampId` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_gzm_gzoneandlamprelation
-- ----------------------------

-- ----------------------------
-- Table structure for stl_gzm_gzonepg
-- ----------------------------
DROP TABLE IF EXISTS `stl_gzm_gzonepg`;
CREATE TABLE `stl_gzm_gzonepg` (
  `gzoneid` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dimminggroupid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gzonearea` tinyblob,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`gzoneid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_gzm_gzonepg
-- ----------------------------

-- ----------------------------
-- Table structure for stl_gzm_gzonetree
-- ----------------------------
DROP TABLE IF EXISTS `stl_gzm_gzonetree`;
CREATE TABLE `stl_gzm_gzonetree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gzoneid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `levelname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_gzm_gzonetree
-- ----------------------------

-- ----------------------------
-- Table structure for stl_lcm_command
-- ----------------------------
DROP TABLE IF EXISTS `stl_lcm_command`;
CREATE TABLE `stl_lcm_command` (
  `device_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `commission_date` date DEFAULT NULL,
  `comtrol_mode` int(11) DEFAULT NULL,
  `lamp_level` int(11) DEFAULT NULL,
  `lamp_switch` bit(1) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lcm_command
-- ----------------------------

-- ----------------------------
-- Table structure for stl_lfm_burning_hour_alert
-- ----------------------------
DROP TABLE IF EXISTS `stl_lfm_burning_hour_alert`;
CREATE TABLE `stl_lfm_burning_hour_alert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alert_msg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `burning_hour` int(11) DEFAULT NULL,
  `luminarire_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ratio` int(11) DEFAULT NULL,
  `severity_level` int(11) DEFAULT NULL,
  `tracking_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lfm_burning_hour_alert
-- ----------------------------
INSERT INTO `stl_lfm_burning_hour_alert` VALUES ('1', 'Very important', '45000', 'Lamp-000', '90', '4', '0');
INSERT INTO `stl_lfm_burning_hour_alert` VALUES ('2', 'Not that important', '10000', 'Lamp-000', '20', '1', '0');
INSERT INTO `stl_lfm_burning_hour_alert` VALUES ('3', 'A little important', '20000', 'Lamp-000', '40', '2', '0');
INSERT INTO `stl_lfm_burning_hour_alert` VALUES ('4', 'Important', '30000', 'Lamp-000', '65', '3', '0');

-- ----------------------------
-- Table structure for stl_lfm_electric_alert
-- ----------------------------
DROP TABLE IF EXISTS `stl_lfm_electric_alert`;
CREATE TABLE `stl_lfm_electric_alert` (
  `id` int(11) NOT NULL,
  `alert_msg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `alert_para` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `luminaire_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ratio` int(11) DEFAULT NULL,
  `severity_level` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `current_value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lfm_electric_alert
-- ----------------------------
INSERT INTO `stl_lfm_electric_alert` VALUES ('1', 'Voltage more than', 'VOLTAGE', 'Lamp-000', '10', '1', null, '12');
INSERT INTO `stl_lfm_electric_alert` VALUES ('2', 'Current more than', 'CURRENT', 'Lamp-000', '20', '2', null, '5');
INSERT INTO `stl_lfm_electric_alert` VALUES ('3', 'PowerFactor less than', 'POWER_FACTOR', 'Lamp-000', '30', '3', null, '0.4');
INSERT INTO `stl_lfm_electric_alert` VALUES ('4', ' less than', 'REACTIVE_POWER', 'Lamp-000', '10', '4', null, '79');
INSERT INTO `stl_lfm_electric_alert` VALUES ('5', 'ActivePower more than', 'ACTIVE_POWER', 'Lamp-000', '100', '10', null, '66');

-- ----------------------------
-- Table structure for stl_lfm_event_log
-- ----------------------------
DROP TABLE IF EXISTS `stl_lfm_event_log`;
CREATE TABLE `stl_lfm_event_log` (
  `id` int(11) NOT NULL,
  `event_source` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `object_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `occur_date` datetime DEFAULT NULL,
  `severity_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lfm_event_log
-- ----------------------------
INSERT INTO `stl_lfm_event_log` VALUES ('1', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('2', 'Application', 'Current is too low', 'Lamp-000', '2016-12-09 15:53:28', '10');
INSERT INTO `stl_lfm_event_log` VALUES ('3', 'Application', 'Power is too high', 'Lamp-001', '2016-12-09 15:53:54', '7');
INSERT INTO `stl_lfm_event_log` VALUES ('4', 'Application', 'Life time is almost over', 'Lamp-002', '2016-12-09 15:54:44', '9');
INSERT INTO `stl_lfm_event_log` VALUES ('5', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('6', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('7', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('8', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('9', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('10', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('11', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('12', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');
INSERT INTO `stl_lfm_event_log` VALUES ('13', 'Application', 'Voltage is too more', 'Lamp-000', '2016-12-09 15:52:56', '8');

-- ----------------------------
-- Table structure for stl_lfm_usage_alert
-- ----------------------------
DROP TABLE IF EXISTS `stl_lfm_usage_alert`;
CREATE TABLE `stl_lfm_usage_alert` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `alertmsg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `groupid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `geozoneid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modelid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `useenergy` double DEFAULT NULL,
  `usepercentage` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lfm_usage_alert
-- ----------------------------
INSERT INTO `stl_lfm_usage_alert` VALUES ('1', 'Too much', 'Test', 'Test', 'Lamp000', '1', null, '1000', '70');
INSERT INTO `stl_lfm_usage_alert` VALUES ('2', 'Too low', 'Test', 'Test', 'Lamp000', '2', null, '2000', '80');
INSERT INTO `stl_lfm_usage_alert` VALUES ('3', 'Too how', 'Test', 'Test', 'Lamp000', '3', null, '3000', '90');
INSERT INTO `stl_lfm_usage_alert` VALUES ('4', 'Too how', 'Test', 'Test', 'Lamp000', '3', null, '4000', '75');

-- ----------------------------
-- Table structure for stl_lim_energy_usage
-- ----------------------------
DROP TABLE IF EXISTS `stl_lim_energy_usage`;
CREATE TABLE `stl_lim_energy_usage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `associated_time` date DEFAULT NULL,
  `energy_usage` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_energy_usage
-- ----------------------------
INSERT INTO `stl_lim_energy_usage` VALUES ('1', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('2', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('3', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('4', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('5', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('6', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('7', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('8', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('9', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('10', '2016-12-08', '100');

-- ----------------------------
-- Table structure for stl_lim_lamp_control
-- ----------------------------
DROP TABLE IF EXISTS `stl_lim_lamp_control`;
CREATE TABLE `stl_lim_lamp_control` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `control_mode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dimg_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `scheduling_plan_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_lamp_control
-- ----------------------------
INSERT INTO `stl_lim_lamp_control` VALUES ('1', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('2', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('3', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('4', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('5', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('6', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('7', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('8', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('9', 'Manual', null, null);
INSERT INTO `stl_lim_lamp_control` VALUES ('10', 'Manual', null, null);

-- ----------------------------
-- Table structure for stl_lim_lamp_info
-- ----------------------------
DROP TABLE IF EXISTS `stl_lim_lamp_info`;
CREATE TABLE `stl_lim_lamp_info` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `geozone_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `module_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `control_id` int(11) NOT NULL,
  `pole_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_o0qelm8i34kbwre7r6eso54r` (`control_id`),
  UNIQUE KEY `UK_fkantbw1no9kh3896rqwx52u5` (`pole_id`),
  UNIQUE KEY `UK_3qrhhlg48t1kkpukruk6ui0fx` (`status_id`),
  UNIQUE KEY `UK_gjqbjvpephfow9gq6wt1o9aog` (`location_id`),
  CONSTRAINT `FKb8hqx73hsghn0skvnen79wjtf` FOREIGN KEY (`location_id`) REFERENCES `stl_lim_location` (`id`),
  CONSTRAINT `FK21gah5lvoii0lbgi03b5pv653` FOREIGN KEY (`control_id`) REFERENCES `stl_lim_lamp_control` (`id`),
  CONSTRAINT `FKjimjrheaqemng8ikhghh43k7d` FOREIGN KEY (`pole_id`) REFERENCES `stl_lim_lamp_pole` (`id`),
  CONSTRAINT `FKmlkykao9bqmd23bfcyuagfoo8` FOREIGN KEY (`status_id`) REFERENCES `stl_lim_lamp_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_lamp_info
-- ----------------------------
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-000', 'Random Address 00', null, 'XSP LED-53', 'Lamp-000', '1', '1', '1', '1');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-001', 'Random Address 01', null, 'XSP LED-53', 'Lamp-001', '2', '2', '2', '2');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-002', 'Random Address 02', null, 'XSP LED-53', 'Lamp-002', '3', '3', '3', '3');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-003', 'Random Address 03', null, 'XSP LED-53', 'Lamp-003', '4', '4', '4', '4');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-004', 'Random Address 04', null, 'XSP LED-53', 'Lamp-004', '5', '5', '5', '5');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-005', 'Random Address 05', null, 'XSP LED-53', 'Lamp-005', '6', '6', '6', '6');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-006', 'Random Address 06', null, 'XSP LED-53', 'Lamp-006', '7', '7', '7', '7');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-007', 'Random Address 07', null, 'XSP LED-53', 'Lamp-007', '8', '8', '8', '8');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-008', 'Random Address 08', null, 'XSP LED-53', 'Lamp-008', '9', '9', '9', '9');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-009', 'Random Address 09', null, 'XSP LED-53', 'Lamp-009', '10', '10', '10', '10');

-- ----------------------------
-- Table structure for stl_lim_lamp_pole
-- ----------------------------
DROP TABLE IF EXISTS `stl_lim_lamp_pole`;
CREATE TABLE `stl_lim_lamp_pole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pole_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_lamp_pole
-- ----------------------------
INSERT INTO `stl_lim_lamp_pole` VALUES ('1', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('2', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('3', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('4', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('5', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('6', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('7', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('8', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('9', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');
INSERT INTO `stl_lim_lamp_pole` VALUES ('10', 'HEX-8 2-Armed Street Pole', 'HEX-8 2-Armed Street Pole');

-- ----------------------------
-- Table structure for stl_lim_lamp_status
-- ----------------------------
DROP TABLE IF EXISTS `stl_lim_lamp_status`;
CREATE TABLE `stl_lim_lamp_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_power` float DEFAULT NULL,
  `apparent_power` float DEFAULT NULL,
  `burn_hour` int(11) DEFAULT NULL,
  `current_flow` float DEFAULT NULL,
  `installed_date` date DEFAULT NULL,
  `lamp_level` int(11) DEFAULT NULL,
  `lamp_switch` bit(1) DEFAULT NULL,
  `node_fail_message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `operation_state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `power_factor` float DEFAULT NULL,
  `reactive_power` float DEFAULT NULL,
  `temperature` float DEFAULT NULL,
  `voltage` float DEFAULT NULL,
  `usage_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mhdbv67lwtsi3p9byxc9jksor` (`usage_id`),
  CONSTRAINT `FKo8urt27f5ywuytwpwmup1ypmt` FOREIGN KEY (`usage_id`) REFERENCES `stl_lim_energy_usage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_lamp_status
-- ----------------------------
INSERT INTO `stl_lim_lamp_status` VALUES ('1', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '1');
INSERT INTO `stl_lim_lamp_status` VALUES ('2', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '2');
INSERT INTO `stl_lim_lamp_status` VALUES ('3', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '3');
INSERT INTO `stl_lim_lamp_status` VALUES ('4', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '4');
INSERT INTO `stl_lim_lamp_status` VALUES ('5', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '5');
INSERT INTO `stl_lim_lamp_status` VALUES ('6', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '6');
INSERT INTO `stl_lim_lamp_status` VALUES ('7', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '7');
INSERT INTO `stl_lim_lamp_status` VALUES ('8', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '8');
INSERT INTO `stl_lim_lamp_status` VALUES ('9', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '9');
INSERT INTO `stl_lim_lamp_status` VALUES ('10', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '10');

-- ----------------------------
-- Table structure for stl_lim_location
-- ----------------------------
DROP TABLE IF EXISTS `stl_lim_location`;
CREATE TABLE `stl_lim_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_location
-- ----------------------------
INSERT INTO `stl_lim_location` VALUES ('1', '1.32592', '103.817');
INSERT INTO `stl_lim_location` VALUES ('2', '1.28678', '103.886');
INSERT INTO `stl_lim_location` VALUES ('3', '1.3575', '103.831');
INSERT INTO `stl_lim_location` VALUES ('4', '1.35926', '103.836');
INSERT INTO `stl_lim_location` VALUES ('5', '1.34592', '103.847');
INSERT INTO `stl_lim_location` VALUES ('6', '1.35921', '103.831');
INSERT INTO `stl_lim_location` VALUES ('7', '1.36592', '103.867');
INSERT INTO `stl_lim_location` VALUES ('8', '1.359214', '103.8314');
INSERT INTO `stl_lim_location` VALUES ('9', '1.38592', '103.887');
INSERT INTO `stl_lim_location` VALUES ('10', '1.359218', '103.8318');

-- ----------------------------
-- Table structure for stl_nia_connect_param
-- ----------------------------
DROP TABLE IF EXISTS `stl_nia_connect_param`;
CREATE TABLE `stl_nia_connect_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_key` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_value` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_nia_connect_param
-- ----------------------------

-- ----------------------------
-- Table structure for stl_nia_lamppoint_meaning
-- ----------------------------
DROP TABLE IF EXISTS `stl_nia_lamppoint_meaning`;
CREATE TABLE `stl_nia_lamppoint_meaning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meaning` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_nia_lamppoint_meaning
-- ----------------------------

-- ----------------------------
-- Table structure for stl_ocm_carbodioxide
-- ----------------------------
DROP TABLE IF EXISTS `stl_ocm_carbodioxide`;
CREATE TABLE `stl_ocm_carbodioxide` (
  `id` int(11) NOT NULL,
  `area` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `k_value` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_ocm_carbodioxide
-- ----------------------------
INSERT INTO `stl_ocm_carbodioxide` VALUES ('48', 'gay', '5', 'oooo');
INSERT INTO `stl_ocm_carbodioxide` VALUES ('53', 'gays', '3', '23');
INSERT INTO `stl_ocm_carbodioxide` VALUES ('62', '322', '3', 'dfd');

-- ----------------------------
-- Table structure for stl_ocm_emc
-- ----------------------------
DROP TABLE IF EXISTS `stl_ocm_emc`;
CREATE TABLE `stl_ocm_emc` (
  `id` int(11) NOT NULL,
  `luminaire_tracking_capability` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tracking_entity_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_ocm_emc
-- ----------------------------
INSERT INTO `stl_ocm_emc` VALUES ('1', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('3', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('5', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('7', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('9', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('11', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('13', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('15', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('17', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('19', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('21', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('23', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('25', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('27', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('29', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('31', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('33', '\0', '11', '', 'Electrical Parameters', 'average');
INSERT INTO `stl_ocm_emc` VALUES ('35', '\0', '12', 'No Tracking', 'Energy Usage', '');
INSERT INTO `stl_ocm_emc` VALUES ('37', '\0', '12', 'No Tracking', 'Energy Usage', '');
INSERT INTO `stl_ocm_emc` VALUES ('39', '\0', '12', 'No Tracking', 'Energy Usage', '');

-- ----------------------------
-- Table structure for stl_ocm_threshold
-- ----------------------------
DROP TABLE IF EXISTS `stl_ocm_threshold`;
CREATE TABLE `stl_ocm_threshold` (
  `id` int(11) NOT NULL,
  `alert_message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `less_alert_message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `less_serverity_level` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `serverity_level` int(11) DEFAULT NULL,
  `th_value` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK70ibfj7mrpril328r01ld7lv1` (`emc_id`),
  CONSTRAINT `FK70ibfj7mrpril328r01ld7lv1` FOREIGN KEY (`emc_id`) REFERENCES `stl_ocm_emc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_ocm_threshold
-- ----------------------------
INSERT INTO `stl_ocm_threshold` VALUES ('2', '1', null, null, 'Power Factor', '2', '1', '1');
INSERT INTO `stl_ocm_threshold` VALUES ('4', '1', null, null, 'Power Factor', '2', '1', '3');
INSERT INTO `stl_ocm_threshold` VALUES ('6', '1', null, null, 'Power Factor', '2', '1', '5');
INSERT INTO `stl_ocm_threshold` VALUES ('8', '1', null, null, 'Power Factor', '2', '1', '7');
INSERT INTO `stl_ocm_threshold` VALUES ('10', '1', null, null, 'Power Factor', '2', '1', '9');
INSERT INTO `stl_ocm_threshold` VALUES ('12', '1', null, null, 'Power Factor', '2', '1', '11');
INSERT INTO `stl_ocm_threshold` VALUES ('14', '1', null, null, 'Power Factor', '2', '1', '13');
INSERT INTO `stl_ocm_threshold` VALUES ('16', '1', null, null, 'Power Factor', '2', '1', '15');
INSERT INTO `stl_ocm_threshold` VALUES ('18', '1', null, null, 'Power Factor', '2', '1', '17');
INSERT INTO `stl_ocm_threshold` VALUES ('20', '1', null, null, 'Power Factor', '2', '1', '19');
INSERT INTO `stl_ocm_threshold` VALUES ('22', '1', null, null, 'Power Factor', '2', '1', '21');
INSERT INTO `stl_ocm_threshold` VALUES ('24', '1', null, null, 'Power Factor', '2', '1', '23');
INSERT INTO `stl_ocm_threshold` VALUES ('26', '1', null, null, 'Power Factor', '2', '1', '25');
INSERT INTO `stl_ocm_threshold` VALUES ('28', '1', null, null, 'Power Factor', '2', '1', '27');
INSERT INTO `stl_ocm_threshold` VALUES ('30', '1', null, null, 'Power Factor', '2', '1', '29');
INSERT INTO `stl_ocm_threshold` VALUES ('32', '1', null, null, 'Power Factor', '2', '1', '31');
INSERT INTO `stl_ocm_threshold` VALUES ('34', '1', null, null, 'Power Factor', '2', '1', '33');
INSERT INTO `stl_ocm_threshold` VALUES ('36', '12', null, null, '', '1', '12', '35');
INSERT INTO `stl_ocm_threshold` VALUES ('38', '12', null, null, '', '1', '12', '37');
INSERT INTO `stl_ocm_threshold` VALUES ('40', '12', null, null, '', '1', '12', '39');

-- ----------------------------
-- Table structure for stl_scm_systemparameter
-- ----------------------------
DROP TABLE IF EXISTS `stl_scm_systemparameter`;
CREATE TABLE `stl_scm_systemparameter` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paramrange` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paramtype` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prefervalue` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unit` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_scm_systemparameter
-- ----------------------------
INSERT INTO `stl_scm_systemparameter` VALUES ('ATM_GETALL_ADDRESS', 'ATM获取日志的地址', null, 'notChange', null, null, 'http://${ATM_IPAndPort}/logInfo/getall');
INSERT INTO `stl_scm_systemparameter` VALUES ('ATM_IPAndPort', 'ATM模块的IP和端口', null, 'Change', null, null, '192.168.0.197:9109');
INSERT INTO `stl_scm_systemparameter` VALUES ('ATM_SAVELOG_ADDRESS', 'ATM存储日志的地址', null, 'notChange', null, null, 'http://${ATM_IPAndPort}/logInfo/save');
INSERT INTO `stl_scm_systemparameter` VALUES ('DGM_GETGZONEID_ADDRESS', '通过dgmName获取包含的GzoneId(GET方法/WebParam传参)', null, 'notChange', null, null, 'http://${DGM_IPAndPort}/dimminggroup/getgeozoneid');
INSERT INTO `stl_scm_systemparameter` VALUES ('DGM_IPAndPort', 'DGM地址及其端口', null, 'Change', null, null, '192.168.0.197:9096');
INSERT INTO `stl_scm_systemparameter` VALUES ('LIM_DELETELAMP_ADDRESS', 'GZM模块用来删除LIM模块灯信息的地址', null, 'notChange', null, null, 'http://${LIM_IPAndPort}/lampinfo/geozone/delete/');
INSERT INTO `stl_scm_systemparameter` VALUES ('LIM_GETALLLAMP_ADDRESS', 'GZM模块用来获取LIM灯信息的地址', null, 'notChange', null, null, 'http://${LIM_IPAndPort}/lampinfo/geozone/get/all');
INSERT INTO `stl_scm_systemparameter` VALUES ('LIM_IPAndPort', 'LIM模块的IP地址和端口', null, 'Change', null, null, '192.168.0.197:9090');
INSERT INTO `stl_scm_systemparameter` VALUES ('LIM_POSTLAMP_ADDRESS', 'GZM模块用来给LIM推送灯信息的地址', null, 'Change', null, null, 'http://${LIM_IPAndPort}/lampinfo/geozone/devices');
INSERT INTO `stl_scm_systemparameter` VALUES ('password', 'mysql密码', null, 'Change', null, null, '123456');
INSERT INTO `stl_scm_systemparameter` VALUES ('Polling_Interval', '设备状态轮询周期', null, 'Change', null, 'Minutes', '5');
INSERT INTO `stl_scm_systemparameter` VALUES ('url', 'mysql连接地址', null, 'Change', null, null, 'jdbc:mysql://192.168.0.197:3306/sl?characterEncoding=utf8');
INSERT INTO `stl_scm_systemparameter` VALUES ('username', 'mysql用户名', null, 'Change', null, null, 'sl');
