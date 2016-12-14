/*
Navicat MySQL Data Transfer

Source Server         : StreetLight - 197
Source Server Version : 50519
Source Host           : 192.168.0.197:3306
Source Database       : sl

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-12-14 21:22:26
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
INSERT INTO `hibernate_sequence` VALUES ('176');
INSERT INTO `hibernate_sequence` VALUES ('176');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_asm_lifetime
-- ----------------------------
INSERT INTO `stl_asm_lifetime` VALUES ('1', '100', 'XSP LED-53 test', 'alert_120901', '0');
INSERT INTO `stl_asm_lifetime` VALUES ('6', '0', 'LPS 70', null, '1');
INSERT INTO `stl_asm_lifetime` VALUES ('7', '0', 'XSP LED-53 test', null, '1');

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
INSERT INTO `stl_asm_luminaire_model` VALUES ('1', 'DALI', 'LED Street/Area Light 53W', 'LED', '', 'TWL/CREE', 'XSP LED-53 test', '\0', '2', '', '53');
INSERT INTO `stl_asm_luminaire_model` VALUES ('2', '0-10V', 'HPS Cobra Street Light 100W', 'HPS', '\0', 'TWL', 'HPS Cobra 100', '\0', null, '\0', '100');
INSERT INTO `stl_asm_luminaire_model` VALUES ('3', 'DALI', 'MH Acorn Park Light 150W', 'MH', '', 'TWL', 'MH Acrorn 150', '', null, '\0', '150');
INSERT INTO `stl_asm_luminaire_model` VALUES ('4', 'DALI', 'LPS 70 Street Light 70W', 'LPS', '\0', 'TWL', 'LPS 70', '', null, '\0', '70');
INSERT INTO `stl_asm_luminaire_model` VALUES ('72', '0-10V', 'ddfd', 'HPS', '\0', 'dfd', 'sd', '\0', '1', '\0', '80');
INSERT INTO `stl_asm_luminaire_model` VALUES ('84', 'DALI', 'test23', 'HPS', '', 'test23', 'test23', '\0', '4', '\0', '3333');

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
INSERT INTO `stl_asm_pole_model` VALUES ('1', 'Hex pole for park lighting, 5m', '5', 'HEX-5 Park Pole', null, null);
INSERT INTO `stl_asm_pole_model` VALUES ('2', 'Hex post top pole for street lighting, 10m', '10', 'HEX-10 Post Top Street Pole', null, null);
INSERT INTO `stl_asm_pole_model` VALUES ('3', 'HEX 2-Armed pole for street lighting, 8m', '8', 'HEX-8 2-Armed Street Pole', null, null);
INSERT INTO `stl_asm_pole_model` VALUES ('4', 'Conical 1-Armed pole for street lighting, 8m', '8', 'CON-8 1-Armed Pole', null, null);

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
  KEY `FK82gjoksx84nhk9aub8ww9oh1l` (`config_id`) USING BTREE,
  CONSTRAINT `stl_asm_thresholds_lifetime_ibfk_1` FOREIGN KEY (`config_id`) REFERENCES `stl_asm_lifetime` (`id`),
  CONSTRAINT `stl_asm_thresholds_lifetime_ibfk_2` FOREIGN KEY (`config_id`) REFERENCES `stl_asm_lifetime` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_asm_thresholds_lifetime
-- ----------------------------
INSERT INTO `stl_asm_thresholds_lifetime` VALUES ('1', 'low', '1', '60', '1');
INSERT INTO `stl_asm_thresholds_lifetime` VALUES ('2', 'middle', '3', '70', '1');
INSERT INTO `stl_asm_thresholds_lifetime` VALUES ('3', 'high', '5', '80', '1');
INSERT INTO `stl_asm_thresholds_lifetime` VALUES ('9', '', '0', '', '7');

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
INSERT INTO `stl_atm_loginfo` VALUES ('4', 'save', '保存能源管理配置', 'save', null, '[{\"id\":3,\"name\":\"test\",\"type\":\"Electrical Parameters\",\"trackingEntityType\":\"\",\"thresholds\":[],\"luminaireTrackingCapability\":false,\"valueType\":\"RMS\"}]', '2016-12-07 19:04:31', null);
INSERT INTO `stl_atm_loginfo` VALUES ('5', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[3]', '2016-12-07 19:04:40', null);
INSERT INTO `stl_atm_loginfo` VALUES ('11', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"2a6d688c-26db-4155-a79a-e95c6213073d\"]', '2016-12-08 10:49:42', null);
INSERT INTO `stl_atm_loginfo` VALUES ('12', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"85c0bc4d-d480-4836-8315-0cf649d33c5e\"]', '2016-12-08 10:49:46', null);
INSERT INTO `stl_atm_loginfo` VALUES ('13', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"91dbedf9-52c3-40d7-b34d-69f77ea9e0f4\",\"name\":\"test_01\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.80738994656463,1.391901211700459],[103.86472484646697,1.3503591584778027],[103.84721538601775,1.3022939729309277],[103.79400035916228,1.3102528185896636],[103.79331371365447,1.3569447131209136],[103.80738994656463,1.391901211700459]]]},\\\"properties\\\":null}\"}]', '2016-12-08 10:50:13', null);
INSERT INTO `stl_atm_loginfo` VALUES ('14', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"a4061bc8-ccc8-431e-8df2-e63cbe3e3450\",\"name\":\"test_02\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74730846463103,1.3951627778625684],[103.76584789334197,1.3735334443664746],[103.72636577664275,1.3512174653625684],[103.71675273953338,1.3865797090149121],[103.74730846463103,1.3951627778625684]]]},\\\"properties\\\":null}\"}]', '2016-12-08 10:50:27', null);
INSERT INTO `stl_atm_loginfo` VALUES ('15', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"b1c8a1b0-63c6-48d9-9e15-f4c54a33af8a\",\"name\":\"test_02\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.72705242215056,1.4008276033020215],[103.75005504666228,1.3723318147278027],[103.71022960720916,1.3647787141418652],[103.69478008328338,1.3953344392395215],[103.72705242215056,1.4008276033020215]]]},\\\"properties\\\":null}\"}]', '2016-12-08 10:50:37', null);
INSERT INTO `stl_atm_loginfo` VALUES ('16', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"172ecff7-bd57-4578-ba7a-bb3e76f6bd88\",\"name\":\"test_03\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79553680419922,1.390122222900391],[103.85184173583984,1.3595664978027346],[103.85115509033203,1.3180244445800784],[103.79656677246093,1.3025749206542971],[103.80205993652343,1.3478935241699221],[103.78146057128906,1.3678062438964846],[103.79553680419922,1.390122222900391]]]},\\\"properties\\\":null}\"}]', '2016-12-08 10:54:11', null);
INSERT INTO `stl_atm_loginfo` VALUES ('17', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"name\":\"South \",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89073756782759,1.3486947905901863],[103.90069392769087,1.36483096002378],[103.90893367378462,1.39504336236753],[103.85365871040571,1.4094629180315925],[103.80147365181196,1.3995065581683113],[103.78293422310102,1.3500680816058113],[103.80113032905805,1.3054361235979988],[103.87769130317915,1.3026895415667488],[103.89073756782759,1.3486947905901863]]]},\\\"properties\\\":null}\"}]', '2016-12-08 10:55:47', null);
INSERT INTO `stl_atm_loginfo` VALUES ('18', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test01\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":null}\"}]', '2016-12-08 10:59:46', null);
INSERT INTO `stl_atm_loginfo` VALUES ('19', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\",\"name\":\"test_02\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.85460901205025,1.3848238373900463],[103.90095758382759,1.3590746308470776],[103.85357904378853,1.3086061860228588],[103.80482721273384,1.31306938182364],[103.79349756185493,1.363881149401765],[103.83332300130806,1.380360641589265],[103.85460901205025,1.3848238373900463]]]},\\\"properties\\\":null}\"}]', '2016-12-08 11:00:00', null);
INSERT INTO `stl_atm_loginfo` VALUES ('20', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"a51d2452-d66b-47b4-9073-0fa7378fca37\",\"name\":\"test_03\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88550805990181,1.4224176789427807],[103.93357324544868,1.3729792023802807],[103.89271783773384,1.3674860383177807],[103.86414126733517,1.3863687897826247],[103.86723117212033,1.407311477770906],[103.88550805990181,1.4224176789427807]]]},\\\"properties\\\":null}\"}]', '2016-12-08 11:00:10', null);
INSERT INTO `stl_atm_loginfo` VALUES ('21', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"0f55031b-7c67-4812-b831-1db3b7c38bf7\",\"name\":\"south\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89973526000976,1.3497817993164065],[103.88050918579101,1.4115798950195315],[103.80669479370117,1.3933837890625003],[103.77407913208008,1.344975280761719],[103.82180099487304,1.3151062011718753],[103.8743293762207,1.3391387939453128],[103.89973526000976,1.3497817993164065]]]},\\\"properties\\\":null}\"}]', '2016-12-08 11:00:16', null);
INSERT INTO `stl_atm_loginfo` VALUES ('22', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"54b65d6e-a006-4a7b-9346-f16d72a77e40\",\"name\":\"test)12\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82405328695259,1.4177828217650466],[103.83778619710884,1.3779573823119216],[103.81615686361275,1.3535814667845778],[103.7946991914936,1.386883773913484],[103.82405328695259,1.4177828217650466]]]},\\\"properties\\\":null}\"}]', '2016-12-08 11:00:20', null);
INSERT INTO `stl_atm_loginfo` VALUES ('23', 'createGZone', '保存区域', 'createGZone', null, '[{\"name\":\"test_03\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79006433431587,1.4296274567748122],[103.81856012289009,1.4014749909544997],[103.78285455648384,1.3726358796263747],[103.76671838705025,1.407311477770906],[103.79006433431587,1.4296274567748122]]]},\\\"properties\\\":null}\"}]', '2016-12-08 11:00:30', null);
INSERT INTO `stl_atm_loginfo` VALUES ('24', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\",\"name\":\"test_04\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89877918616564,1.3105695663119559],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\\\"properties\\\":null}\"}]', '2016-12-08 11:16:38', null);
INSERT INTO `stl_atm_loginfo` VALUES ('25', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"name\":\"test_02\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89877918616564,1.3105695663119559],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\"}}\"}]', '2016-12-08 11:25:51', null);
INSERT INTO `stl_atm_loginfo` VALUES ('26', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"name\":\"test_0212\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89877918616564,1.3105695663119559],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"name\\\":\\\"test_02\\\"}}\"}]', '2016-12-08 11:26:17', null);
INSERT INTO `stl_atm_loginfo` VALUES ('27', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\",\"name\":\"test_0475\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89877918616564,1.3105695663119559],[103.90804890052112,1.300098222317815],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\\\",\\\"name\\\":\\\"test_04\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:26:37', null);
INSERT INTO `stl_atm_loginfo` VALUES ('28', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\",\"name\":\"test_04ii\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89877918616564,1.3105695663119559],[103.90804890052112,1.300098222317815],[103.92212513343128,1.2976949630404713],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\\\",\\\"name\\\":\\\"test_0475\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:26:51', null);
INSERT INTO `stl_atm_loginfo` VALUES ('29', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test01\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.77071979895862,1.3210409103060963],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test01\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:27:06', null);
INSERT INTO `stl_atm_loginfo` VALUES ('30', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test01ui\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.77071979895862,1.3210409103060963],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test01\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:27:23', null);
INSERT INTO `stl_atm_loginfo` VALUES ('31', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test01uioo\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.78277385546663,1.3223941969938557],[103.77071979895862,1.3210409103060963],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test01ui\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:28:02', null);
INSERT INTO `stl_atm_loginfo` VALUES ('32', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test01uiooii\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.78277385546663,1.3223941969938557],[103.77071979895862,1.3210409103060963],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test01uioo\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:28:10', null);
INSERT INTO `stl_atm_loginfo` VALUES ('33', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\",\"name\":\"test_0212\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.85460901205025,1.3848238373900463],[103.90095758382759,1.3590746308470776],[103.89269714355468,1.3382804870605471],[103.85357904378853,1.3086061860228588],[103.80482721273384,1.31306938182364],[103.79349756185493,1.363881149401765],[103.83332300130806,1.380360641589265],[103.85460901205025,1.3848238373900463]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\\\",\\\"name\\\":\\\"test_02\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:29:10', null);
INSERT INTO `stl_atm_loginfo` VALUES ('34', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\",\"name\":\"test_021212\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.85460901205025,1.3848238373900463],[103.90095758382759,1.3590746308470776],[103.89269714355468,1.3382804870605471],[103.85357904378853,1.3086061860228588],[103.80482721273384,1.31306938182364],[103.79349756185493,1.363881149401765],[103.83332300130806,1.380360641589265],[103.85460901205025,1.3848238373900463]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\\\",\\\"name\\\":\\\"test_0212\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:29:33', null);
INSERT INTO `stl_atm_loginfo` VALUES ('35', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\",\"name\":\"test_0212121212\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.85460901205025,1.3848238373900463],[103.90095758382759,1.3590746308470776],[103.89269714355468,1.3382804870605471],[103.85357904378853,1.3086061860228588],[103.80482721273384,1.31306938182364],[103.79349756185493,1.363881149401765],[103.83332300130806,1.380360641589265],[103.85460901205025,1.3848238373900463]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\\\",\\\"name\\\":\\\"test_021212\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:29:41', null);
INSERT INTO `stl_atm_loginfo` VALUES ('36', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test_01\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.78277385546663,1.3223941969938557],[103.78111724853515,1.3187110900878907],[103.77071979895862,1.3210409103060963],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test01uiooii\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:30:38', null);
INSERT INTO `stl_atm_loginfo` VALUES ('37', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test_0112\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.78277385546663,1.3223941969938557],[103.78111724853515,1.3187110900878907],[103.77071979895862,1.3210409103060963],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test_01\\\",\\\"other\\\":null}}\"}]', '2016-12-08 11:30:48', null);
INSERT INTO `stl_atm_loginfo` VALUES ('39', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":38,\"area\":\"eee\",\"kValue\":\"5\",\"other\":\"qww\"}]', '2016-12-08 15:57:32', null);
INSERT INTO `stl_atm_loginfo` VALUES ('41', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":40,\"area\":\"aaa\",\"kValue\":\"5\",\"other\":\"ccc\"}]', '2016-12-08 15:57:42', null);
INSERT INTO `stl_atm_loginfo` VALUES ('43', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":42,\"area\":\"1234\",\"kValue\":\"5\",\"other\":\"ssd\"}]', '2016-12-08 16:08:35', null);
INSERT INTO `stl_atm_loginfo` VALUES ('45', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":44,\"area\":\"jijikul\",\"kValue\":\"5\",\"other\":\"321\"}]', '2016-12-08 16:18:40', null);
INSERT INTO `stl_atm_loginfo` VALUES ('51', 'save', '保存能源管理配置', 'save', null, '[{\"id\":46,\"name\":\"energy_120701\",\"type\":\"Energy Usage\",\"trackingEntityType\":\"Luminaire\",\"thresholds\":[{\"id\":47,\"name\":\"\",\"thValue\":\"50\",\"alertMessage\":\"low\",\"serverityLevel\":1},{\"id\":48,\"name\":\"\",\"thValue\":\"80\",\"alertMessage\":\"中\",\"serverityLevel\":3},{\"id\":49,\"name\":\"\",\"thValue\":\"90\",\"alertMessage\":\"高\",\"serverityLevel\":5},{\"id\":50,\"name\":\"\",\"thValue\":\"70\",\"alertMessage\":\"低\",\"serverityLevel\":2}],\"luminaireTrackingCapability\":false,\"valueType\":\"\"}]', '2016-12-08 16:42:20', null);
INSERT INTO `stl_atm_loginfo` VALUES ('53', 'save', '保存能源管理配置', 'save', null, '[{\"id\":52,\"name\":\"energy_120702\",\"type\":\"Electrical Parameters\",\"trackingEntityType\":\"\",\"thresholds\":[],\"luminaireTrackingCapability\":false,\"valueType\":\"RMS\"}]', '2016-12-08 16:44:43', null);
INSERT INTO `stl_atm_loginfo` VALUES ('60', 'save', '保存能源管理配置', 'save', null, '[{\"id\":54,\"name\":\"energy_120703\",\"type\":\"Energy Usage\",\"trackingEntityType\":\"CMS-Streetlight\",\"thresholds\":[{\"id\":55,\"name\":\"\",\"thValue\":\"90\",\"alertMessage\":\"5\",\"serverityLevel\":5},{\"id\":56,\"name\":\"\",\"thValue\":\"70\",\"alertMessage\":\"3\",\"serverityLevel\":3},{\"id\":57,\"name\":\"\",\"thValue\":\"50\",\"alertMessage\":\"1\",\"serverityLevel\":1},{\"id\":58,\"name\":\"\",\"thValue\":\"60\",\"alertMessage\":\"2\",\"serverityLevel\":2},{\"id\":59,\"name\":\"\",\"thValue\":\"80\",\"alertMessage\":\"4\",\"serverityLevel\":4}],\"luminaireTrackingCapability\":false,\"valueType\":\"\"}]', '2016-12-08 16:46:19', null);
INSERT INTO `stl_atm_loginfo` VALUES ('62', 'save', '保存能源管理配置', 'save', null, '[{\"id\":61,\"name\":\"\",\"type\":\"\",\"trackingEntityType\":\"\",\"thresholds\":[],\"luminaireTrackingCapability\":false,\"valueType\":\"\"}]', '2016-12-08 16:53:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('64', 'save', '保存能源管理配置', 'save', null, '[{\"id\":63,\"name\":\"\",\"type\":\"\",\"trackingEntityType\":\"\",\"thresholds\":[],\"luminaireTrackingCapability\":false,\"valueType\":\"\"}]', '2016-12-08 16:53:47', null);
INSERT INTO `stl_atm_loginfo` VALUES ('67', 'save', '保存能源管理配置', 'save', null, '[{\"id\":65,\"name\":\"\",\"type\":\"\",\"trackingEntityType\":\"\",\"thresholds\":[{\"id\":66,\"name\":\"\",\"thValue\":\"\",\"alertMessage\":\"\",\"serverityLevel\":0}],\"luminaireTrackingCapability\":false,\"valueType\":\"\"}]', '2016-12-08 16:59:04', null);
INSERT INTO `stl_atm_loginfo` VALUES ('68', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test_011212\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.78277385546663,1.3223941969938557],[103.78111724853515,1.3187110900878907],[103.77071979895862,1.3210409103060963],[103.75965957641601,1.3097846984863284],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"eb410a86-e340-4d21-8451-3556c273e4be\\\",\\\"name\\\":\\\"test_0112\\\",\\\"other\\\":null}}\"}]', '2016-12-08 17:03:15', null);
INSERT INTO `stl_atm_loginfo` VALUES ('69', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\",\"name\":\"test_04ii2\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.89877918616564,1.3105695663119559],[103.90804890052112,1.300098222317815],[103.92212513343128,1.2976949630404713],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\\\",\\\"name\\\":\\\"test_04ii\\\",\\\"other\\\":null}}\"}]', '2016-12-08 17:04:54', null);
INSERT INTO `stl_atm_loginfo` VALUES ('70', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"93fafeec-621e-4c08-859f-c25b64a15517\",\"name\":\"1222\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.69133834838867,1.373642730712891],[103.67829208374023,1.3444602966308596],[103.65631942749023,1.3757026672363284],[103.6652458190918,1.4096916198730471],[103.69133834838867,1.373642730712891]]]},\\\"properties\\\":null}\"}]', '2016-12-08 17:05:58', null);
INSERT INTO `stl_atm_loginfo` VALUES ('71', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"93fafeec-621e-4c08-859f-c25b64a15517\"]', '2016-12-08 17:06:04', null);
INSERT INTO `stl_atm_loginfo` VALUES ('77', 'save', '保存二氧化碳设置信息', 'save', null, '[{\"id\":76,\"area\":\"co2_120901\",\"kValue\":\"5\",\"other\":\"test\"}]', '2016-12-09 11:05:27', null);
INSERT INTO `stl_atm_loginfo` VALUES ('78', 'save', '删除二氧化碳设置信息', 'deleteCD', null, '[44]', '2016-12-09 11:05:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('79', 'save', '删除二氧化碳设置信息', 'deleteCD', null, '[40]', '2016-12-09 11:05:48', null);
INSERT INTO `stl_atm_loginfo` VALUES ('80', 'save', '修改二氧化碳设置信息', 'update', null, '[{\"id\":42,\"area\":\"1234\",\"kValue\":\"5\",\"other\":\"ssd\"}]', '2016-12-09 11:09:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('81', 'save', '修改二氧化碳设置信息', 'update', null, '[{\"id\":76,\"area\":\"co2_120901\",\"kValue\":\"5\",\"other\":\"test1111\"}]', '2016-12-09 11:09:07', null);
INSERT INTO `stl_atm_loginfo` VALUES ('82', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[63]', '2016-12-09 11:09:25', null);
INSERT INTO `stl_atm_loginfo` VALUES ('83', 'deleteEMC', '删除能源管理配置', 'deleteEMC', null, '[65]', '2016-12-09 11:09:37', null);
INSERT INTO `stl_atm_loginfo` VALUES ('85', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"93b7fb93-62a6-406c-b3e0-6fbac4939704\",\"name\":\"gis_120901\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.66988067626953,1.3678062438964846],[103.67812042236328,1.3369071960449221],[103.66473083496093,1.321457672119141],[103.64859466552734,1.3441169738769534],[103.66988067626953,1.3678062438964846]]]},\\\"properties\\\":null}\"}]', '2016-12-09 14:12:40', null);
INSERT INTO `stl_atm_loginfo` VALUES ('86', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"93b7fb93-62a6-406c-b3e0-6fbac4939704\"]', '2016-12-09 14:17:21', null);
INSERT INTO `stl_atm_loginfo` VALUES ('87', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"b34165ab-8c5f-4ebf-8875-b8d858385928\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.76709823608401,1.4079750061035161],[103.7887275695801,1.3808525085449224],[103.74787216186526,1.3712394714355474],[103.75199203491213,1.3976753234863286],[103.76709823608401,1.4079750061035161]]]},\\\"properties\\\":null}\"}]', '2016-12-09 14:17:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('88', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"2ccc6d9e-9a92-4343-a411-d6a74bd1149f\",\"name\":\"test120901\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.80246047973635,1.4397323608398445],[103.80623703002932,1.408833312988282],[103.75439529418948,1.3957870483398445],[103.75061874389651,1.4356124877929695],[103.80246047973635,1.4397323608398445]]]},\\\"properties\\\":null}\"}]', '2016-12-09 14:17:44', null);
INSERT INTO `stl_atm_loginfo` VALUES ('89', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"2ccc6d9e-9a92-4343-a411-d6a74bd1149f\"]', '2016-12-09 14:17:49', null);
INSERT INTO `stl_atm_loginfo` VALUES ('90', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"8c563c07-0ea9-4344-8616-1916fe9c5154\",\"name\":\"566\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82111434936523,1.3760459899902346],[103.84755020141601,1.370896148681641],[103.86059646606445,1.3430870056152346],[103.83793716430664,1.3166511535644534],[103.81321792602539,1.3025749206542971],[103.77991561889648,1.3331306457519534],[103.82111434936523,1.3760459899902346]]]},\\\"properties\\\":null}\"}]', '2016-12-09 16:40:14', null);
INSERT INTO `stl_atm_loginfo` VALUES ('91', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"6ef06be1-dd66-473a-a5ac-e13618b63e4f\",\"name\":\"333\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.93320150298753,1.3321386871292333],[103.96547384185472,1.3424383697464208],[103.96787710113206,1.381233840937827],[103.93217153472581,1.3513647613479833],[103.93320150298753,1.3321386871292333]]]},\\\"properties\\\":null}\"}]', '2016-12-09 17:24:43', null);
INSERT INTO `stl_atm_loginfo` VALUES ('92', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"8187327c-75f5-4c8f-b0fc-2b788b7017ce\",\"name\":\"222\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.9508826248137,1.3264738616897802],[103.95122594756761,1.3450132904007177],[103.99379796905198,1.3614927825882177],[104.00203771514573,1.3226973113968115],[103.99620122832933,1.3099943695022802],[103.9508826248137,1.3264738616897802]]]},\\\"properties\\\":null}\"}]', '2016-12-09 17:24:50', null);
INSERT INTO `stl_atm_loginfo` VALUES ('93', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"bacb06cb-b6ec-4243-9847-22fe055e97b2\",\"name\":\"fff\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.96289892120042,1.3190924224807958],[103.94950933379808,1.3465582427932958],[103.97697515411058,1.3596045074417333],[103.99517126006761,1.3438116607620458],[104.00375432891526,1.3252722320511083],[103.96289892120042,1.3190924224807958]]]},\\\"properties\\\":null}\"}]', '2016-12-09 17:25:09', null);
INSERT INTO `stl_atm_loginfo` VALUES ('94', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"70098385-903c-4607-a61a-c0a8204acf49\",\"name\":\"的是非得失\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.87570266723633,1.3537300109863284],[103.87741928100586,1.3973320007324221],[103.9127815246582,1.3935554504394534],[103.92514114379883,1.3657463073730471],[103.91484146118164,1.3437736511230471],[103.89527206420898,1.335190582275391],[103.87570266723633,1.3537300109863284]]]},\\\"properties\\\":null}\"}]', '2016-12-12 11:56:32', null);
INSERT INTO `stl_atm_loginfo` VALUES ('95', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"03054b81-e452-47d3-adaa-bcef501a3bbc\",\"name\":\"dsfasdfsdfasdf446789\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7812889099121,1.3861740112304688],[103.83124237060547,1.3502967834472657],[103.70850448608398,1.3284957885742188],[103.70867614746093,1.3889205932617188],[103.74695663452148,1.3956153869628907],[103.7812889099121,1.3861740112304688]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:06:03', null);
INSERT INTO `stl_atm_loginfo` VALUES ('96', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"725183a4-59b6-496a-84fd-f5150b628f4c\",\"name\":\"145623lokijhgyuh\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79390602111816,1.4240253448486324],[103.85467414855957,1.3910663604736324],[103.76197700500488,1.3831699371337887],[103.70120887756347,1.4161289215087887],[103.75305061340332,1.4284885406494137],[103.79390602111816,1.4240253448486324]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:06:31', null);
INSERT INTO `stl_atm_loginfo` VALUES ('97', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"717d8fda-c105-43c2-be29-ae66e0714755\",\"name\":\"656565963.；lpp\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.63049244632656,1.4926430038454128],[103.65006184329921,1.4589973739626003],[103.73554920902187,1.4919563583376003],[103.65761494388515,1.516332273864944],[103.58792042484218,1.5036293319704128],[103.63049244632656,1.4926430038454128]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:06:50', null);
INSERT INTO `stl_atm_loginfo` VALUES ('98', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"e0ee51cb-0877-46a7-8ce4-5d307f481b5b\",\"name\":\"ijijijijasdasdasdas545454\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.5094711755746,1.5875717453004912],[103.49024510135585,1.4907547286989287],[103.70104527225429,1.5353866867067412],[103.6413071130746,1.449899320984085],[103.60869145145351,1.550794185297633],[103.5314438318246,1.421704829828883],[103.53831028690273,1.5463309894968518],[103.5094711755746,1.5875717453004912]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:07:10', null);
INSERT INTO `stl_atm_loginfo` VALUES ('99', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"5158ae59-45bb-4890-ace2-a7c138a01127\",\"name\":\"456987lkokojojlk\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.57161259403166,1.84678042449971],[103.86549687137541,1.809701567077835],[103.83665776004729,1.655892973327835],[103.64989018192229,1.51169741668721],[103.34776615848479,1.584481840515335],[103.42879032840666,1.779489164734085],[103.57161259403166,1.84678042449971]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:07:42', null);
INSERT INTO `stl_atm_loginfo` VALUES ('100', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"9a8ade93-1555-4c67-be19-029fc0a86c24\",\"name\":\"1456789321lomjikh\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.68662571659027,1.3984009078981479],[103.66465306034027,1.3462158493043979],[103.74121403446136,1.3544555953981479],[103.76558994998871,1.4025207809450229],[103.72816776981293,1.4351364425661166],[103.69555210819183,1.4052673629762729],[103.68662571659027,1.3984009078981479]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:07:58', null);
INSERT INTO `stl_atm_loginfo` VALUES ('101', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"17385abb-a453-4453-92e5-86ab7208bc5a\",\"name\":\"kiauhuoljkjskjgjsdf\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.68807678222656,1.3614547729492186],[103.6849868774414,1.330555725097656],[103.64996795654297,1.322315979003906],[103.65614776611328,1.3720977783203123],[103.679150390625,1.370381164550781],[103.68807678222656,1.3614547729492186]]]},\\\"properties\\\":null}\"}]', '2016-12-12 14:24:26', null);
INSERT INTO `stl_atm_loginfo` VALUES ('102', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"85c0bc4d-d480-4836-8315-0cf649d33c5e\",\"name\":\"131\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.73219375610351,1.3496101379394534],[103.72361068725587,1.325749206542969],[103.71880416870117,1.3262641906738284],[103.71828918457032,1.311844635009766],[103.68653182983398,1.300858306884766],[103.67005233764648,1.3399971008300784],[103.6879051208496,1.3674629211425784],[103.73219375610351,1.3496101379394534]]]},\\\"properties\\\":{\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"85c0bc4d-d480-4836-8315-0cf649d33c5e\\\",\\\"name\\\":\\\"131\\\",\\\"other\\\":null,\\\"geoAreas\\\":\\\"East\\\"}}\"}]', '2016-12-12 16:40:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('103', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"8c563c07-0ea9-4344-8616-1916fe9c5154\"]', '2016-12-12 16:40:35', null);
INSERT INTO `stl_atm_loginfo` VALUES ('104', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"70098385-903c-4607-a61a-c0a8204acf49\"]', '2016-12-12 16:40:38', null);
INSERT INTO `stl_atm_loginfo` VALUES ('105', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"82c30de0-a0a5-4f1b-846b-942b9e10d05d\",\"name\":\"1222\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79845504760742,1.3815391540527346],[103.81459121704101,1.368149566650391],[103.75450973510742,1.3492668151855471],[103.76824264526367,1.386002349853516],[103.7867820739746,1.4069450378417971],[103.79845504760742,1.3815391540527346]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"East\\\"}}\"}]', '2016-12-12 16:47:41', null);
INSERT INTO `stl_atm_loginfo` VALUES ('106', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"82c30de0-a0a5-4f1b-846b-942b9e10d05d\",\"name\":\"1222\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79845504760742,1.3815391540527346],[103.81459121704101,1.368149566650391],[103.75450973510742,1.3492668151855471],[103.76824264526367,1.386002349853516],[103.7867820739746,1.4069450378417971],[103.79845504760742,1.3815391540527346]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"Central\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"82c30de0-a0a5-4f1b-846b-942b9e10d05d\\\",\\\"name\\\":\\\"1222\\\",\\\"other\\\":null}}\"}]', '2016-12-12 16:51:59', null);
INSERT INTO `stl_atm_loginfo` VALUES ('107', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"d35c1c90-ceaf-465c-84ef-6029ca89bac3\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79982833862304,1.3224876403808596],[103.82042770385742,1.368149566650391],[103.83210067749023,1.376389312744141],[103.86231307983398,1.3616264343261721],[103.8801658630371,1.337937164306641],[103.87364273071289,1.315964508056641],[103.79982833862304,1.3224876403808596]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"Central\\\"}}\"}]', '2016-12-12 17:48:36', null);
INSERT INTO `stl_atm_loginfo` VALUES ('108', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"220f8d58-9e4f-4cd0-a3d8-de79444b6141\",\"name\":\"55556\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88480072021484,1.3611114501953128],[103.86866455078125,1.3885772705078128],[103.8717544555664,1.4002502441406253],[103.90402679443359,1.4047134399414065],[103.92531280517578,1.3714111328125003],[103.88480072021484,1.3611114501953128]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"Central\\\"}}\"}]', '2016-12-12 17:48:47', null);
INSERT INTO `stl_atm_loginfo` VALUES ('109', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"b55c6fcc-5c1e-428d-8717-0f01aad6bd8d\",\"name\":\"dsfads\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.8646139723311,1.282983672230819],[103.89413972916704,1.3032397147112877],[103.91988893571,1.289850127308944],[103.9195456129561,1.2558611746722252],[103.89551302018266,1.2496813651019127],[103.8646139723311,1.282983672230819]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"Other\\\"}}\"}]', '2016-12-12 17:50:00', null);
INSERT INTO `stl_atm_loginfo` VALUES ('110', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"d35c1c90-ceaf-465c-84ef-6029ca89bac3\"]', '2016-12-13 09:31:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('111', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"146ec633-0121-4fd1-a47e-63548f4b73cf\",\"name\":\"55555555\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.80154495239258,1.3588798522949221],[103.8355339050293,1.376389312744141],[103.8575065612793,1.3523567199707034],[103.85853652954101,1.3286674499511721],[103.82901077270508,1.3115013122558596],[103.80394821166992,1.300858306884766],[103.80154495239258,1.3588798522949221]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"East\\\"}}\"}]', '2016-12-13 09:31:52', null);
INSERT INTO `stl_atm_loginfo` VALUES ('112', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"146ec633-0121-4fd1-a47e-63548f4b73cf\"]', '2016-12-13 09:32:15', null);
INSERT INTO `stl_atm_loginfo` VALUES ('113', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"9e9bbdff-56af-48c3-ab8a-3f18afcb0d92\",\"name\":\"1233333\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.8080680847168,1.3362205505371096],[103.82386093139648,1.369522857666016],[103.85510330200195,1.3468635559082034],[103.85716323852539,1.320084381103516],[103.8472068786621,1.3080680847167971],[103.8193977355957,1.2936485290527346],[103.79124526977539,1.2936485290527346],[103.79673843383789,1.320084381103516],[103.8080680847168,1.3362205505371096]]]},\\\"properties\\\":{\\\"geoAreas\\\":\\\"East\\\"}}\"}]', '2016-12-13 09:32:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('114', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"39f40275-8cb7-48d6-b67f-bc3302d9181c\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.91810302734376,1.5198982238769534],[103.9750946044922,1.4786994934082034],[103.89681701660159,1.4526069641113284],[103.8370788574219,1.5116584777832034],[103.8920104980469,1.538437652587891],[103.91810302734376,1.5198982238769534]]]},\\\"properties\\\":null}\"}]', '2016-12-13 15:01:42', null);
INSERT INTO `stl_atm_loginfo` VALUES ('115', 'createGZone', '保存区域', 'createGZone', null, '[{\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.78558044433596,1.5621269226074221],[103.80205993652346,1.5229881286621096],[103.76635437011721,1.5133750915527346],[103.75193481445315,1.5449607849121096],[103.78558044433596,1.5621269226074221]]]},\\\"properties\\\":null}\"}]', '2016-12-13 15:06:09', null);
INSERT INTO `stl_atm_loginfo` VALUES ('116', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"717d8fda-c105-43c2-be29-ae66e0714755\"]', '2016-12-13 15:27:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('117', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"85c0bc4d-d480-4836-8315-0cf649d33c5e\"]', '2016-12-13 16:27:00', null);
INSERT INTO `stl_atm_loginfo` VALUES ('118', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"220f8d58-9e4f-4cd0-a3d8-de79444b6141\",\"name\":\"55556\",\"gzoneArea\":\"\"}]', '2016-12-13 16:27:02', null);
INSERT INTO `stl_atm_loginfo` VALUES ('119', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"82c30de0-a0a5-4f1b-846b-942b9e10d05d\"]', '2016-12-13 16:27:04', null);
INSERT INTO `stl_atm_loginfo` VALUES ('120', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"9e9bbdff-56af-48c3-ab8a-3f18afcb0d92\"]', '2016-12-13 16:27:07', null);
INSERT INTO `stl_atm_loginfo` VALUES ('121', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"220f8d58-9e4f-4cd0-a3d8-de79444b6141\"]', '2016-12-13 16:27:09', null);
INSERT INTO `stl_atm_loginfo` VALUES ('122', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"b55c6fcc-5c1e-428d-8717-0f01aad6bd8d\"]', '2016-12-13 16:27:12', null);
INSERT INTO `stl_atm_loginfo` VALUES ('123', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"1a805e85-dcd5-4724-94c9-d615102ae20d\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.8362205505371,1.373642730712891],[103.86540298461914,1.3451469421386721],[103.84823684692384,1.3156211853027346],[103.82729415893556,1.3605964660644534],[103.81424789428712,1.3767326354980471],[103.8362205505371,1.373642730712891]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\"}}\"}]', '2016-12-13 16:27:31', null);
INSERT INTO `stl_atm_loginfo` VALUES ('124', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[100,0],[100,2],[104,2],[104,0],[100,0]]]},\\\"properties\\\":null}\",\"other\":\"test123456\"}]', '2016-12-13 16:28:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('125', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"2df6bf2c-b9c8-4aa0-9bad-c904943dfb95\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[100,0],[100,2],[104,2],[104,0],[100,0]]]},\\\"properties\\\":null}\",\"other\":\"test123456\"}]', '2016-12-13 16:29:24', null);
INSERT INTO `stl_atm_loginfo` VALUES ('126', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"1a805e85-dcd5-4724-94c9-d615102ae20d\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.8362205505371,1.373642730712891],[103.86540298461914,1.3451469421386721],[103.84823684692384,1.3156211853027346],[103.82729415893556,1.3605964660644534],[103.81424789428712,1.3767326354980471],[103.8362205505371,1.373642730712891]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Weast@Singapore\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"1a805e85-dcd5-4724-94c9-d615102ae20d\\\",\\\"name\\\":\\\"123\\\",\\\"other\\\":null}}\"}]', '2016-12-13 16:35:08', null);
INSERT INTO `stl_atm_loginfo` VALUES ('127', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"44477b33-319f-4ab0-8680-bdf3ece4dd89\",\"name\":\"\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.80274658203126,1.346402500459595],[103.82471923828126,1.3374761088580325],[103.82059936523439,1.3127568705767825],[103.79176025390626,1.3082936747760012],[103.78970031738282,1.3294080241412356],[103.80274658203126,1.346402500459595]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"\\\"}}\"}]', '2016-12-13 16:43:40', null);
INSERT INTO `stl_atm_loginfo` VALUES ('128', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\",\"name\":\"fdddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88540153503419,1.3988450511187749],[103.88505821228028,1.3682893260211186],[103.86840705871583,1.348204944917603],[103.85364418029786,1.3713792308062749],[103.85398750305177,1.3914636119097905],[103.88540153503419,1.3988450511187749]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"fdddd\\\"}}\"}]', '2016-12-13 16:43:55', null);
INSERT INTO `stl_atm_loginfo` VALUES ('129', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"44477b33-319f-4ab0-8680-bdf3ece4dd89\"]', '2016-12-13 16:44:08', null);
INSERT INTO `stl_atm_loginfo` VALUES ('130', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"1a805e85-dcd5-4724-94c9-d615102ae20d\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.8362205505371,1.373642730712891],[103.86540298461914,1.3451469421386721],[103.84823684692384,1.3156211853027346],[103.82729415893556,1.3605964660644534],[103.81424789428712,1.3767326354980471],[103.8362205505371,1.373642730712891]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Weast@East@Singapore\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"1a805e85-dcd5-4724-94c9-d615102ae20d\\\",\\\"name\\\":\\\"123\\\",\\\"other\\\":null}}\"}]', '2016-12-13 16:44:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('131', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"1a805e85-dcd5-4724-94c9-d615102ae20d\",\"name\":\"123\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.8362205505371,1.373642730712891],[103.86540298461914,1.3451469421386721],[103.84823684692384,1.3156211853027346],[103.82729415893556,1.3605964660644534],[103.81424789428712,1.3767326354980471],[103.8362205505371,1.373642730712891]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"j1_11@East@Singapore\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"1a805e85-dcd5-4724-94c9-d615102ae20d\\\",\\\"name\\\":\\\"123\\\",\\\"other\\\":null}}\"}]', '2016-12-13 16:47:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('132', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\",\"name\":\"fdddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88540153503419,1.3988450511187749],[103.88505821228028,1.3682893260211186],[103.86840705871583,1.348204944917603],[103.85364418029786,1.3713792308062749],[103.85398750305177,1.3914636119097905],[103.88540153503419,1.3988450511187749]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"fdddd\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\\\",\\\"other\\\":null}}\"}]', '2016-12-13 16:50:12', null);
INSERT INTO `stl_atm_loginfo` VALUES ('133', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\",\"name\":\"fdddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88540153503419,1.3988450511187749],[103.88505821228028,1.3682893260211186],[103.86840705871583,1.348204944917603],[103.85364418029786,1.3713792308062749],[103.85398750305177,1.3914636119097905],[103.88540153503419,1.3988450511187749]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"fdddd\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\\\",\\\"other\\\":null}}\"}]', '2016-12-13 16:50:29', null);
INSERT INTO `stl_atm_loginfo` VALUES ('134', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\",\"name\":\"fdddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88540153503419,1.3988450511187749],[103.88505821228028,1.3682893260211186],[103.86840705871583,1.348204944917603],[103.85364418029786,1.3713792308062749],[103.85398750305177,1.3914636119097905],[103.88540153503419,1.3988450511187749]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"j1_10@East@Singapore\\\",\\\"name\\\":\\\"fdddd\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\\\",\\\"other\\\":null}}\"}]', '2016-12-13 16:53:55', null);
INSERT INTO `stl_atm_loginfo` VALUES ('135', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"9664a9d2-6e10-4ee0-bd8c-c6eb62a6b817\"]', '2016-12-13 17:02:25', null);
INSERT INTO `stl_atm_loginfo` VALUES ('136', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"1a805e85-dcd5-4724-94c9-d615102ae20d\"]', '2016-12-13 17:02:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('137', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"888\\\"}}\"}]', '2016-12-13 17:02:49', null);
INSERT INTO `stl_atm_loginfo` VALUES ('138', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"888\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:04:31', null);
INSERT INTO `stl_atm_loginfo` VALUES ('139', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"j1_10@North@Singapore\\\",\\\"name\\\":\\\"888\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:06:05', null);
INSERT INTO `stl_atm_loginfo` VALUES ('140', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"888\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:13:37', null);
INSERT INTO `stl_atm_loginfo` VALUES ('141', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"888\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:14:57', null);
INSERT INTO `stl_atm_loginfo` VALUES ('142', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"New node@North@Singapore\\\",\\\"name\\\":\\\"888\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:15:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('143', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.7977684020996,1.390122222900391],[103.87192611694336,1.3835990905761721],[103.86162643432617,1.3303840637207034],[103.83107070922851,1.2778556823730471],[103.75691299438476,1.3399971008300784],[103.76927261352539,1.3753593444824221],[103.7977684020996,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"888\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:15:14', null);
INSERT INTO `stl_atm_loginfo` VALUES ('144', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"f68e2f17-1d36-4d8c-999d-87709b2c50e5\"]', '2016-12-13 17:15:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('145', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"24ca86dc-adf6-445a-a208-0a84b8d100db\",\"name\":\"555\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.77098922729492,1.3588798522949221],[103.85613327026367,1.3331306457519534],[103.77476577758789,1.2654960632324221],[103.7146842956543,1.3142478942871096],[103.7263572692871,1.3537300109863284],[103.77098922729492,1.3588798522949221]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"555\\\"}}\"}]', '2016-12-13 17:15:50', null);
INSERT INTO `stl_atm_loginfo` VALUES ('146', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"24ca86dc-adf6-445a-a208-0a84b8d100db\"]', '2016-12-13 17:15:58', null);
INSERT INTO `stl_atm_loginfo` VALUES ('147', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"8cc8d17e-16f8-488d-89e9-7a797940614f\",\"name\":\"8888888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82660751342773,1.3825691223144534],[103.8472068786621,1.3595664978027346],[103.78581595386724,1.3398582897603784],[103.78993582691412,1.377967115443972],[103.82660751342773,1.3825691223144534]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"8888888\\\"}}\"}]', '2016-12-13 17:19:21', null);
INSERT INTO `stl_atm_loginfo` VALUES ('148', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"8cc8d17e-16f8-488d-89e9-7a797940614f\"]', '2016-12-13 17:19:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('149', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"68deb1c9-fe2b-4518-bc97-b122f761f814\",\"name\":\"888\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82935409545898,1.390122222900391],[103.89355545043945,1.3060081481933596],[103.78266220092773,1.2888420104980471],[103.77819900512695,1.3757026672363284],[103.78437881469726,1.396988677978516],[103.81218795776367,1.4041984558105471],[103.82935409545898,1.390122222900391]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"888\\\"}}\"}]', '2016-12-13 17:21:22', null);
INSERT INTO `stl_atm_loginfo` VALUES ('150', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"68deb1c9-fe2b-4518-bc97-b122f761f814\"]', '2016-12-13 17:22:14', null);
INSERT INTO `stl_atm_loginfo` VALUES ('151', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"014bca06-0cb8-4043-b0ec-d7abcf4315e9\",\"name\":\"555\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.83021240234375,1.3772476196289065],[103.86179809570312,1.3607681274414065],[103.80943534692187,1.325119111626303],[103.79776237328906,1.3563614822317718],[103.83021240234375,1.3772476196289065]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"555\\\"}}\"}]', '2016-12-13 17:22:28', null);
INSERT INTO `stl_atm_loginfo` VALUES ('152', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"014bca06-0cb8-4043-b0ec-d7abcf4315e9\"]', '2016-12-13 17:22:42', null);
INSERT INTO `stl_atm_loginfo` VALUES ('153', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\",\"name\":\"123323\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82248764038086,1.3770759582519534],[103.87226943969726,1.3609397888183596],[103.8575065612793,1.311844635009766],[103.82420425415039,1.3029182434082034],[103.7696159362793,1.3290107727050784],[103.77201919555664,1.3691795349121096],[103.82248764038086,1.3770759582519534]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"123323\\\"}}\"}]', '2016-12-13 17:23:57', null);
INSERT INTO `stl_atm_loginfo` VALUES ('154', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"b43e2e05-6e48-4262-b49d-68acc7b7d501\",\"name\":\"dsfdsf\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88617401123048,1.3593948364257815],[103.87347106933595,1.395787048339844],[103.88960723876954,1.4156997680664065],[103.93320922851564,1.397160339355469],[103.93320922851564,1.3597381591796878],[103.88617401123048,1.3593948364257815]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"South@Singapore\\\",\\\"name\\\":\\\"dsfdsf\\\"}}\"}]', '2016-12-13 17:24:09', null);
INSERT INTO `stl_atm_loginfo` VALUES ('155', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\",\"name\":\"123323\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82248764038086,1.3770759582519534],[103.87226943969726,1.3609397888183596],[103.8575065612793,1.311844635009766],[103.82420425415039,1.3029182434082034],[103.7696159362793,1.3290107727050784],[103.77201919555664,1.3691795349121096],[103.82248764038086,1.3770759582519534]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Singapore\\\",\\\"name\\\":\\\"123323\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:24:22', null);
INSERT INTO `stl_atm_loginfo` VALUES ('156', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\",\"name\":\"123323\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82248764038086,1.3770759582519534],[103.87226943969726,1.3609397888183596],[103.8575065612793,1.311844635009766],[103.82420425415039,1.3029182434082034],[103.7696159362793,1.3290107727050784],[103.77201919555664,1.3691795349121096],[103.82248764038086,1.3770759582519534]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Weast@Singapore\\\",\\\"name\\\":\\\"123323\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:24:25', null);
INSERT INTO `stl_atm_loginfo` VALUES ('157', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"b43e2e05-6e48-4262-b49d-68acc7b7d501\",\"name\":\"dsfdsf\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.88617401123048,1.3593948364257815],[103.87347106933595,1.395787048339844],[103.88960723876954,1.4156997680664065],[103.93320922851564,1.397160339355469],[103.93320922851564,1.3597381591796878],[103.88617401123048,1.3593948364257815]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Weast@Singapore\\\",\\\"name\\\":\\\"dsfdsf\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"b43e2e05-6e48-4262-b49d-68acc7b7d501\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:24:30', null);
INSERT INTO `stl_atm_loginfo` VALUES ('158', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\",\"name\":\"123323\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.82248764038086,1.3770759582519534],[103.87226943969726,1.3609397888183596],[103.8575065612793,1.311844635009766],[103.82420425415039,1.3029182434082034],[103.7696159362793,1.3290107727050784],[103.77201919555664,1.3691795349121096],[103.82248764038086,1.3770759582519534]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"dfdfdsfdsf@Weast@Singapore\\\",\\\"name\\\":\\\"123323\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:24:54', null);
INSERT INTO `stl_atm_loginfo` VALUES ('159', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"f0c67d85-9fe1-44e4-9722-49d08818b0c8\"]', '2016-12-13 17:27:10', null);
INSERT INTO `stl_atm_loginfo` VALUES ('160', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"b43e2e05-6e48-4262-b49d-68acc7b7d501\"]', '2016-12-13 17:27:17', null);
INSERT INTO `stl_atm_loginfo` VALUES ('161', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"81dc2a60-67e7-46bf-a4a4-cca61504ddc9\",\"name\":\"12323\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.85441665649414,1.3774192810058596],[103.89012222290039,1.3537300109863284],[103.8520133972168,1.310471343994141],[103.83107070922851,1.3084114074707034],[103.81081466674804,1.3784492492675784],[103.85441665649414,1.3774192810058596]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"12323\\\"}}\"}]', '2016-12-13 17:27:34', null);
INSERT INTO `stl_atm_loginfo` VALUES ('162', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"81dc2a60-67e7-46bf-a4a4-cca61504ddc9\"]', '2016-12-13 17:36:46', null);
INSERT INTO `stl_atm_loginfo` VALUES ('163', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"fe7d0e37-e9af-41ec-9485-ec98cd133cb1\",\"name\":\"555\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.80738143920898,1.3684928894042971],[103.82866744995117,1.380509185791016],[103.85647659301758,1.3492668151855471],[103.8468635559082,1.2987983703613284],[103.80772476196289,1.2960517883300784],[103.78300552368164,1.3427436828613284],[103.80738143920898,1.3684928894042971]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"555\\\"}}\"}]', '2016-12-13 17:36:55', null);
INSERT INTO `stl_atm_loginfo` VALUES ('164', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"b7dc9d17-77c8-4fa1-87f8-2556ff03fd85\",\"name\":\"999\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.87364273071289,1.3509834289550784],[103.86162643432617,1.372269439697266],[103.86505966186523,1.3980186462402346],[103.9076316833496,1.405228424072266],[103.90591506958008,1.3616264343261721],[103.9072883605957,1.3375938415527346],[103.87364273071289,1.3509834289550784]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"999\\\"}}\"}]', '2016-12-13 17:38:41', null);
INSERT INTO `stl_atm_loginfo` VALUES ('165', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"b7dc9d17-77c8-4fa1-87f8-2556ff03fd85\",\"name\":\"999\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.87364273071289,1.3509834289550784],[103.86162643432617,1.372269439697266],[103.86505966186523,1.3980186462402346],[103.9076316833496,1.405228424072266],[103.90591506958008,1.3616264343261721],[103.9072883605957,1.3375938415527346],[103.87364273071289,1.3509834289550784]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Singapore\\\",\\\"name\\\":\\\"999\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"b7dc9d17-77c8-4fa1-87f8-2556ff03fd85\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:42:57', null);
INSERT INTO `stl_atm_loginfo` VALUES ('166', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"b7dc9d17-77c8-4fa1-87f8-2556ff03fd85\",\"name\":\"999\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.87364273071289,1.3509834289550784],[103.86162643432617,1.372269439697266],[103.86505966186523,1.3980186462402346],[103.9076316833496,1.405228424072266],[103.90591506958008,1.3616264343261721],[103.9072883605957,1.3375938415527346],[103.87364273071289,1.3509834289550784]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"999\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"b7dc9d17-77c8-4fa1-87f8-2556ff03fd85\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:44:23', null);
INSERT INTO `stl_atm_loginfo` VALUES ('167', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"fe7d0e37-e9af-41ec-9485-ec98cd133cb1\"]', '2016-12-13 17:45:01', null);
INSERT INTO `stl_atm_loginfo` VALUES ('168', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"b7dc9d17-77c8-4fa1-87f8-2556ff03fd85\"]', '2016-12-13 17:45:06', null);
INSERT INTO `stl_atm_loginfo` VALUES ('169', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"5717dac9-b721-4804-b318-0d81298e853d\",\"name\":\"95212\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.79605178833008,1.3698661804199221],[103.88050918579101,1.3839424133300784],[103.87329940795898,1.3389671325683596],[103.8575065612793,1.3029182434082034],[103.82626419067383,1.3097846984863284],[103.79605178833008,1.3698661804199221]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"95212\\\"}}\"}]', '2016-12-13 17:45:29', null);
INSERT INTO `stl_atm_loginfo` VALUES ('170', 'deleteGZoneByGZoneId', '删除区域', 'deleteGZoneByGZoneId', null, '[\"5717dac9-b721-4804-b318-0d81298e853d\"]', '2016-12-13 17:50:12', null);
INSERT INTO `stl_atm_loginfo` VALUES ('171', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"f90fc3af-a6db-437c-8c09-037f02055111\",\"name\":\"dddddddddddddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.78506546020509,1.3671195983886721],[103.84446029663087,1.3729560852050784],[103.85578994750978,1.351670074462891],[103.85029678344728,1.3272941589355471],[103.82832412719726,1.2902153015136721],[103.7970817565918,1.3166511535644534],[103.78506546020509,1.3671195983886721]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"dddddddddddddd\\\"}}\"}]', '2016-12-13 17:50:23', null);
INSERT INTO `stl_atm_loginfo` VALUES ('172', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f90fc3af-a6db-437c-8c09-037f02055111\",\"name\":\"dddddddddddddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.78506546020509,1.3671195983886721],[103.84446029663087,1.3729560852050784],[103.85578994750978,1.351670074462891],[103.85029678344728,1.3272941589355471],[103.82832412719726,1.2902153015136721],[103.7970817565918,1.3166511535644534],[103.78506546020509,1.3671195983886721]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Weast@Singapore\\\",\\\"name\\\":\\\"dddddddddddddd\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f90fc3af-a6db-437c-8c09-037f02055111\\\",\\\"other\\\":null}}\"}]', '2016-12-13 17:51:57', null);
INSERT INTO `stl_atm_loginfo` VALUES ('173', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f90fc3af-a6db-437c-8c09-037f02055111\",\"name\":\"dddddddddddddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.78506546020509,1.3671195983886721],[103.84446029663087,1.3729560852050784],[103.85578994750978,1.351670074462891],[103.85029678344728,1.3272941589355471],[103.82832412719726,1.2902153015136721],[103.7970817565918,1.3166511535644534],[103.78506546020509,1.3671195983886721]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"Central@Singapore\\\",\\\"name\\\":\\\"dddddddddddddd\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f90fc3af-a6db-437c-8c09-037f02055111\\\",\\\"other\\\":null}}\"}]', '2016-12-13 18:00:30', null);
INSERT INTO `stl_atm_loginfo` VALUES ('174', 'createGZone', '保存区域', 'createGZone', null, '[{\"gzoneId\":\"22aebe4a-927b-4261-a6f4-dfff9850b1b8\",\"name\":\"555555555555555555\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.87261276245117,1.3509834289550784],[103.85716323852539,1.3712394714355471],[103.86505966186523,1.390122222900391],[103.88394241333008,1.3987052917480471],[103.90351181030273,1.3904655456542971],[103.90007417779887,1.3608282845435995],[103.89698427301371,1.3443487923560995],[103.87261276245117,1.3509834289550784]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"East@Singapore\\\",\\\"name\\\":\\\"555555555555555555\\\"}}\"}]', '2016-12-13 18:03:50', null);
INSERT INTO `stl_atm_loginfo` VALUES ('175', 'updateGZone', '更新区域', 'updateGZone', null, '[{\"gzoneId\":\"f90fc3af-a6db-437c-8c09-037f02055111\",\"name\":\"dddddddddddddd\",\"gzoneArea\":\"{\\\"type\\\":\\\"Feature\\\",\\\"geometry\\\":{\\\"type\\\":\\\"Polygon\\\",\\\"coordinates\\\":[[[103.78506546020509,1.3671195983886721],[103.84446029663087,1.3729560852050784],[103.85578994750978,1.351670074462891],[103.85029678344728,1.3272941589355471],[103.86059646606445,1.3125312805175784],[103.82832412719726,1.2902153015136721],[103.7970817565918,1.3166511535644534],[103.78506546020509,1.3671195983886721]]]},\\\"properties\\\":{\\\"geoTree\\\":\\\"North@Singapore\\\",\\\"name\\\":\\\"dddddddddddddd\\\",\\\"type\\\":\\\"geozone\\\",\\\"gzoneId\\\":\\\"f90fc3af-a6db-437c-8c09-037f02055111\\\",\\\"other\\\":null}}\"}]', '2016-12-14 09:10:01', null);

-- ----------------------------
-- Table structure for stl_bhcp_alert
-- ----------------------------
DROP TABLE IF EXISTS `stl_bhcp_alert`;
CREATE TABLE `stl_bhcp_alert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alert_msg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `burning_hour` int(11) DEFAULT NULL,
  `luminarire_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ratio` int(11) DEFAULT NULL,
  `severity_level` int(11) DEFAULT NULL,
  `tracking_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_bhcp_alert
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_cpm_calendar_profile
-- ----------------------------
INSERT INTO `stl_cpm_calendar_profile` VALUES ('1', null, '2016-12-08 09:21:36', null, 'tetete', 'PLANNED', '2', '2016-12-13');
INSERT INTO `stl_cpm_calendar_profile` VALUES ('2', null, '2016-12-08 11:45:04', null, 'calendar_01', 'PLANNED', '0', null);
INSERT INTO `stl_cpm_calendar_profile` VALUES ('5', null, '2016-12-08 15:47:55', null, 'calendar-120701', 'PLANNED', '0', null);
INSERT INTO `stl_cpm_calendar_profile` VALUES ('7', null, '2016-12-09 16:42:19', null, 'calendar_120905', 'PLANNED', '0', null);

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
  KEY `FK25kprmt9oyv1362hkfxqsty66` (`plan_id`) USING BTREE,
  CONSTRAINT `stl_cpm_scheduling_rule_ibfk_1` FOREIGN KEY (`plan_id`) REFERENCES `stl_cpm_calendar_profile` (`id`),
  CONSTRAINT `stl_cpm_scheduling_rule_ibfk_2` FOREIGN KEY (`plan_id`) REFERENCES `stl_cpm_calendar_profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_cpm_scheduling_rule
-- ----------------------------
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('1', '', '2016-12-08', '1', 'Day-based:Mon', 'test', '2016-12-01', '1');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('2', '', '2016-12-08', '2', 'Day-based:Tue', 'test', '2016-12-01', '1');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('3', '', '2017-03-01', '3', 'Day-based:Wed', 'test', '2016-08-01', '2');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('4', '', '2017-03-01', '3', 'Date-based DD:12', 'test', '2016-08-01', '2');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('5', '', '2017-03-01', '4', 'Date-based DD.MM:15.11', 'test', '2016-08-01', '2');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('6', '', '2017-01-01', '3', 'Date-based DD:12', 'test', '2016-10-01', null);
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('9', '', '2017-03-01', '3', 'Date-based DD.MM:12.18', 'Daily test_01', '2015-12-01', '5');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('10', '', '2017-03-01', '4', 'Date-based DD.MM.YYYY:19.20.12', 'test', '2015-12-01', '5');
INSERT INTO `stl_cpm_scheduling_rule` VALUES ('12', '', '2016-10-01', '3', 'Date-based DD.MM:12.10', 'daily_120705', '2016-12-01', '7');

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
INSERT INTO `stl_dgm_group` VALUES ('123', '2016-12-14 17:45:45', '456', '0', '');

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
  `seqnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmow526jxvmrx6bcmf618xawxj` (`daily_name`) USING BTREE,
  CONSTRAINT `stl_dpm_command_ibfk_1` FOREIGN KEY (`daily_name`) REFERENCES `stl_dpm_dailyprofile` (`name`),
  CONSTRAINT `stl_dpm_command_ibfk_2` FOREIGN KEY (`daily_name`) REFERENCES `stl_dpm_dailyprofile` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_dpm_command
-- ----------------------------
INSERT INTO `stl_dpm_command` VALUES ('1', '06:14', '0', '20', '06:00', '0', null, '1');
INSERT INTO `stl_dpm_command` VALUES ('2', '06:00', '0', '100', '00:00', '0', null, '0');
INSERT INTO `stl_dpm_command` VALUES ('3', '02:33', '0', '89', '12:13', '0', null, '2');
INSERT INTO `stl_dpm_command` VALUES ('4', '09:14', '0', '45', '14:46', '0', null, '3');
INSERT INTO `stl_dpm_command` VALUES ('5', '02:33', '0', '89', '12:13', '0', null, '2');
INSERT INTO `stl_dpm_command` VALUES ('6', '06:00', '0', '100', '00:00', '0', null, '0');
INSERT INTO `stl_dpm_command` VALUES ('7', '09:14', '0', '45', '14:46', '0', null, '3');
INSERT INTO `stl_dpm_command` VALUES ('8', '06:14', '0', '20', '06:00', '0', null, '1');
INSERT INTO `stl_dpm_command` VALUES ('9', '02:33', '0', '89', '12:13', '0', null, '2');
INSERT INTO `stl_dpm_command` VALUES ('10', '09:14', '0', '45', '14:46', '0', null, '3');
INSERT INTO `stl_dpm_command` VALUES ('11', '06:14', '0', '20', '06:00', '0', null, '1');
INSERT INTO `stl_dpm_command` VALUES ('12', '06:00', '0', '100', '00:00', '0', null, '0');
INSERT INTO `stl_dpm_command` VALUES ('13', '06:00', '0', '100', '00:00', '0', null, '0');
INSERT INTO `stl_dpm_command` VALUES ('14', '02:33', '0', '89', '12:13', '0', null, '2');
INSERT INTO `stl_dpm_command` VALUES ('15', '06:14', '0', '20', '06:00', '0', null, '1');
INSERT INTO `stl_dpm_command` VALUES ('16', '09:14', '0', '45', '14:46', '0', null, '3');
INSERT INTO `stl_dpm_command` VALUES ('21', '06:20', '0', '36', '00:00', '0', null, '0');
INSERT INTO `stl_dpm_command` VALUES ('22', '08:39', '0', '98', '06:20', '0', null, '1');
INSERT INTO `stl_dpm_command` VALUES ('23', '09:01', '0', '74', '15:00', '0', null, '2');
INSERT INTO `stl_dpm_command` VALUES ('24', '05:00', '0', '30', '00:00', '0', 'Daily test_01', '0');
INSERT INTO `stl_dpm_command` VALUES ('25', '02:05', '0', '27', '21:55', '0', 'Daily test_01', '4');
INSERT INTO `stl_dpm_command` VALUES ('26', '01:57', '0', '100', '05:00', '0', 'Daily test_01', '1');
INSERT INTO `stl_dpm_command` VALUES ('27', '11:00', '0', '0', '06:56', '0', 'Daily test_01', '2');
INSERT INTO `stl_dpm_command` VALUES ('28', '03:58', '0', '100', '17:57', '0', 'Daily test_01', '3');
INSERT INTO `stl_dpm_command` VALUES ('29', '12:03', '0', '0', '05:56', '0', 'daily 120701', '1');
INSERT INTO `stl_dpm_command` VALUES ('30', '06:00', '0', '97', '18:00', '0', 'daily 120701', '2');
INSERT INTO `stl_dpm_command` VALUES ('31', '05:56', '0', '67', '00:00', '0', 'daily 120701', '0');
INSERT INTO `stl_dpm_command` VALUES ('32', '06:05', '0', '99', '17:54', '0', 'daily_120705', '2');
INSERT INTO `stl_dpm_command` VALUES ('33', '06:01', '0', '24', '00:00', '0', 'daily_120705', '0');
INSERT INTO `stl_dpm_command` VALUES ('34', '11:54', '0', '0', '06:01', '0', 'daily_120705', '1');
INSERT INTO `stl_dpm_command` VALUES ('35', '12:01', '0', '88', '11:59', '0', 'test', '1');
INSERT INTO `stl_dpm_command` VALUES ('36', '11:59', '0', '21', '00:00', '0', 'test', '0');
INSERT INTO `stl_dpm_command` VALUES ('37', '24:00', '0', '50', '00:00', '0', '23333333', '0');
INSERT INTO `stl_dpm_command` VALUES ('38', '24:00', '0', '50', '00:00', '0', '999999999999999', '0');

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
INSERT INTO `stl_dpm_dailyprofile` VALUES ('23333333', '');
INSERT INTO `stl_dpm_dailyprofile` VALUES ('999999999999999', '');
INSERT INTO `stl_dpm_dailyprofile` VALUES ('daily 120701', '');
INSERT INTO `stl_dpm_dailyprofile` VALUES ('Daily test_01', '');
INSERT INTO `stl_dpm_dailyprofile` VALUES ('daily_120705', '');
INSERT INTO `stl_dpm_dailyprofile` VALUES ('test', '');

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
  KEY `FKnsi0i4xl5a1p08t8n5lemq9xb` (`dimming_group_id`) USING BTREE,
  CONSTRAINT `stl_gzm_gzone_ibfk_1` FOREIGN KEY (`dimming_group_id`) REFERENCES `stl_dgm_group` (`name`),
  CONSTRAINT `stl_gzm_gzone_ibfk_2` FOREIGN KEY (`dimming_group_id`) REFERENCES `stl_dgm_group` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_gzm_gzone
-- ----------------------------
INSERT INTO `stl_gzm_gzone` VALUES ('17385abb-a453-4453-92e5-86ab7208bc5a', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.68807678222656,1.3614547729492186],[103.6849868774414,1.330555725097656],[103.64996795654297,1.322315979003906],[103.65614776611328,1.3720977783203123],[103.679150390625,1.370381164550781],[103.68807678222656,1.3614547729492186]]]},\"properties\":null}', 'kiauhuoljkjskjgjsdf', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('39f40275-8cb7-48d6-b67f-bc3302d9181c', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.91810302734376,1.5198982238769534],[103.9750946044922,1.4786994934082034],[103.89681701660159,1.4526069641113284],[103.8370788574219,1.5116584777832034],[103.8920104980469,1.538437652587891],[103.91810302734376,1.5198982238769534]]]},\"properties\":null}', '123', null, '123');
INSERT INTO `stl_gzm_gzone` VALUES ('6ef06be1-dd66-473a-a5ac-e13618b63e4f', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.93320150298753,1.3321386871292333],[103.96547384185472,1.3424383697464208],[103.96787710113206,1.381233840937827],[103.93217153472581,1.3513647613479833],[103.93320150298753,1.3321386871292333]]]},\"properties\":null}', '333', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('725183a4-59b6-496a-84fd-f5150b628f4c', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.79390602111816,1.4240253448486324],[103.85467414855957,1.3910663604736324],[103.76197700500488,1.3831699371337887],[103.70120887756347,1.4161289215087887],[103.75305061340332,1.4284885406494137],[103.79390602111816,1.4240253448486324]]]},\"properties\":null}', '145623lokijhgyuh', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.89877918616564,1.3105695663119559],[103.90804890052112,1.300098222317815],[103.92212513343128,1.2976949630404713],[103.90178830912636,1.2724607406283626],[103.84896794230137,1.2688157436788836],[103.8668207255045,1.3137910244406024],[103.89877918616564,1.3105695663119559]]]},\"properties\":{\"type\":\"geozone\",\"gzoneId\":\"7d9dc593-4bc0-4ac8-b1e4-8b29b97efdae\",\"name\":\"test_04ii\",\"other\":null}}', 'test_04ii2', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('a1038f36-b0a5-4b3d-86cd-5bbe64e020bd', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.85460901205025,1.3848238373900463],[103.90095758382759,1.3590746308470776],[103.89269714355468,1.3382804870605471],[103.85357904378853,1.3086061860228588],[103.80482721273384,1.31306938182364],[103.79349756185493,1.363881149401765],[103.83332300130806,1.380360641589265],[103.85460901205025,1.3848238373900463]]]},\"properties\":{\"type\":\"geozone\",\"gzoneId\":\"a1038f36-b0a5-4b3d-86cd-5bbe64e020bd\",\"name\":\"test_021212\",\"other\":null}}', 'test_0212121212', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('a51d2452-d66b-47b4-9073-0fa7378fca37', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.88550805990181,1.4224176789427807],[103.93357324544868,1.3729792023802807],[103.89271783773384,1.3674860383177807],[103.86414126733517,1.3863687897826247],[103.86723117212033,1.407311477770906],[103.88550805990181,1.4224176789427807]]]},\"properties\":null}', 'test_03', null, null);
INSERT INTO `stl_gzm_gzone` VALUES ('eb410a86-e340-4d21-8451-3556c273e4be', '{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[103.74129180908203,1.3904655456542971],[103.79210357666015,1.343430328369141],[103.78277385546663,1.3223941969938557],[103.78111724853515,1.3187110900878907],[103.77071979895862,1.3210409103060963],[103.75965957641601,1.3097846984863284],[103.74712829589843,1.3018882751464846],[103.70592956542968,1.339310455322266],[103.74129180908203,1.3904655456542971]]]},\"properties\":{\"type\":\"geozone\",\"gzoneId\":\"eb410a86-e340-4d21-8451-3556c273e4be\",\"name\":\"test_0112\",\"other\":null}}', 'test_011212', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
INSERT INTO `stl_lim_energy_usage` VALUES ('11', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('12', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('13', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('14', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('15', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('16', '2016-12-08', '100');
INSERT INTO `stl_lim_energy_usage` VALUES ('17', '2016-12-08', '100');

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
  UNIQUE KEY `UK_o0qelm8i34kbwre7r6eso54r` (`control_id`) USING BTREE,
  UNIQUE KEY `UK_fkantbw1no9kh3896rqwx52u5` (`pole_id`) USING BTREE,
  UNIQUE KEY `UK_3qrhhlg48t1kkpukruk6ui0fx` (`status_id`) USING BTREE,
  UNIQUE KEY `UK_gjqbjvpephfow9gq6wt1o9aog` (`location_id`) USING BTREE,
  CONSTRAINT `stl_lim_lamp_info_ibfk_1` FOREIGN KEY (`control_id`) REFERENCES `stl_lim_lamp_control` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `stl_lim_location` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_3` FOREIGN KEY (`pole_id`) REFERENCES `stl_lim_lamp_pole` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_4` FOREIGN KEY (`status_id`) REFERENCES `stl_lim_lamp_status` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_5` FOREIGN KEY (`location_id`) REFERENCES `stl_lim_location` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_6` FOREIGN KEY (`control_id`) REFERENCES `stl_lim_lamp_control` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_7` FOREIGN KEY (`pole_id`) REFERENCES `stl_lim_lamp_pole` (`id`),
  CONSTRAINT `stl_lim_lamp_info_ibfk_8` FOREIGN KEY (`status_id`) REFERENCES `stl_lim_lamp_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_lamp_info
-- ----------------------------
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-000', 'Random Address 00', 'dddddddddddddd', 'XSP LED-53', 'Lamp-000', '1', '1', '1', '1');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-001', 'Random Address 01', '66.71896654673316', 'XSP LED-53', 'Lamp-001', '2', '2', '2', '2');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-002', 'Random Address 02', 'dddddddddddddd', 'XSP LED-53', 'Lamp-002', '3', '3', '3', '3');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-003', 'Random Address 03', 'dddddddddddddd', 'XSP LED-53', 'Lamp-003', '4', '4', '4', '4');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-004', 'Random Address 04', 'dddddddddddddd', 'XSP LED-53', 'Lamp-004', '5', '5', '5', '5');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-005', 'Random Address 05', 'dddddddddddddd', 'XSP LED-53', 'Lamp-005', '6', '6', '6', '6');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-006', 'Random Address 06', '555555555555555555', 'XSP LED-53', 'Lamp-006', '7', '7', '7', '7');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-007', 'Random Address 07', 'dddddddddddddd', 'XSP LED-53', 'Lamp-007', '8', '8', '8', '8');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-008', 'Random Address 08', '555555555555555555', 'XSP LED-53', 'Lamp-008', '9', '9', '9', '9');
INSERT INTO `stl_lim_lamp_info` VALUES ('Lamp-009', 'Random Address 09', 'dddddddddddddd', 'XSP LED-53', 'Lamp-009', '10', '10', '10', '10');

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
  UNIQUE KEY `UK_mhdbv67lwtsi3p9byxc9jksor` (`usage_id`) USING BTREE,
  CONSTRAINT `stl_lim_lamp_status_ibfk_1` FOREIGN KEY (`usage_id`) REFERENCES `stl_lim_energy_usage` (`id`),
  CONSTRAINT `stl_lim_lamp_status_ibfk_2` FOREIGN KEY (`usage_id`) REFERENCES `stl_lim_energy_usage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_lim_lamp_status
-- ----------------------------
INSERT INTO `stl_lim_lamp_status` VALUES ('1', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '17');
INSERT INTO `stl_lim_lamp_status` VALUES ('2', '53', '10', '100', '15', '2016-12-08', '75', '\0', null, null, '11', '11', '42', '12', '13');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_nia_connect_param
-- ----------------------------
INSERT INTO `stl_nia_connect_param` VALUES ('1', 'nms.rest.scheduled', '/rest/secure/nms/provisioningapi/schedule');
INSERT INTO `stl_nia_connect_param` VALUES ('2', 'nms.port', '7090');
INSERT INTO `stl_nia_connect_param` VALUES ('3', 'nms.auth.id', 'root');
INSERT INTO `stl_nia_connect_param` VALUES ('4', 'nms.rest.token', '/rest/authentication/oauth/access_token');
INSERT INTO `stl_nia_connect_param` VALUES ('5', 'nms.rest.realtime', '/rest/secure/nms/provisioningapi/realtime');
INSERT INTO `stl_nia_connect_param` VALUES ('6', 'nms.host', '27.104.124.126');
INSERT INTO `stl_nia_connect_param` VALUES ('7', 'nms.auth.password', 'public');

-- ----------------------------
-- Table structure for stl_nia_lamppoint_meaning
-- ----------------------------
DROP TABLE IF EXISTS `stl_nia_lamppoint_meaning`;
CREATE TABLE `stl_nia_lamppoint_meaning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meaning` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_nia_lamppoint_meaning
-- ----------------------------
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('1', 'Current');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('2', 'LampCommandMode');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('3', 'LampCommandSwitch');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('4', 'LampEnergy');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('5', 'LampFailure');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('6', 'LampLevel');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('7', 'LampLevelCommand');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('8', 'LampPower');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('9', 'LampSwitch');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('10', 'LampVoltage');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('11', 'LostCommunication');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('12', 'MainVoltage');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('13', 'MotionControl');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('14', 'NodeFailure');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('15', 'NodeFailureMessage');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('16', 'PowerFactor');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('17', 'SetStateTimeoutConrol');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('18', 'Temperature');
INSERT INTO `stl_nia_lamppoint_meaning` VALUES ('19', 'UnknowIdentifier');

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
INSERT INTO `stl_ocm_carbodioxide` VALUES ('38', 'eee', '5', 'qww');
INSERT INTO `stl_ocm_carbodioxide` VALUES ('42', '1234', '5', 'ssd');
INSERT INTO `stl_ocm_carbodioxide` VALUES ('76', 'co2_120901', '5', 'test1111');

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
INSERT INTO `stl_ocm_emc` VALUES ('46', '\0', 'energy_120701', 'Luminaire', 'Energy Usage', '');
INSERT INTO `stl_ocm_emc` VALUES ('52', '\0', 'energy_120702', '', 'Electrical Parameters', 'RMS');
INSERT INTO `stl_ocm_emc` VALUES ('54', '\0', 'energy_120703', 'CMS-Streetlight', 'Energy Usage', '');
INSERT INTO `stl_ocm_emc` VALUES ('61', '\0', '', '', '', '');
INSERT INTO `stl_ocm_emc` VALUES ('65', '\0', '', '', '', '');

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
  KEY `FK70ibfj7mrpril328r01ld7lv1` (`emc_id`) USING BTREE,
  CONSTRAINT `stl_ocm_threshold_ibfk_1` FOREIGN KEY (`emc_id`) REFERENCES `stl_ocm_emc` (`id`),
  CONSTRAINT `stl_ocm_threshold_ibfk_2` FOREIGN KEY (`emc_id`) REFERENCES `stl_ocm_emc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stl_ocm_threshold
-- ----------------------------
INSERT INTO `stl_ocm_threshold` VALUES ('47', 'low', null, null, '', '1', '50', '46');
INSERT INTO `stl_ocm_threshold` VALUES ('48', '中', null, null, '', '3', '80', '46');
INSERT INTO `stl_ocm_threshold` VALUES ('49', '高', null, null, '', '5', '90', '46');
INSERT INTO `stl_ocm_threshold` VALUES ('50', '低', null, null, '', '2', '70', '46');
INSERT INTO `stl_ocm_threshold` VALUES ('55', '5', null, null, '', '5', '90', '54');
INSERT INTO `stl_ocm_threshold` VALUES ('56', '3', null, null, '', '3', '70', '54');
INSERT INTO `stl_ocm_threshold` VALUES ('57', '1', null, null, '', '1', '50', '54');
INSERT INTO `stl_ocm_threshold` VALUES ('58', '2', null, null, '', '2', '60', '54');
INSERT INTO `stl_ocm_threshold` VALUES ('59', '4', null, null, '', '4', '80', '54');
INSERT INTO `stl_ocm_threshold` VALUES ('66', '', null, null, '', '0', '', '65');

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

-- ----------------------------
-- Function structure for getGZoneTreeChildList
-- ----------------------------
DROP FUNCTION IF EXISTS `getGZoneTreeChildList`;
DELIMITER ;;

;;
DELIMITER ;
