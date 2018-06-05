/*
Navicat MySQL Data Transfer

Source Server         : GMS
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : fruits

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-06-04 22:12:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pwd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456', '1');
INSERT INTO `admin` VALUES ('2', 'kefu', '123456', '2');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  `c_num` int(11) DEFAULT '1',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('41', '2', '1', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comm_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` int(11) DEFAULT NULL,
  `comm_comment` text COLLATE utf8_unicode_ci,
  `comm_date` datetime DEFAULT NULL,
  `comm_flag` int(11) DEFAULT '0' COMMENT '评分',
  `comm_pointer` int(11) DEFAULT '1',
  PRIMARY KEY (`comm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '2', '好吃啊卧槽', '2018-05-28 16:12:13', '5', '1');
INSERT INTO `comment` VALUES ('3', '1', '这个南丰蜜桔是我吃过最好吃的', '2018-05-28 16:12:13', '3', '1');
INSERT INTO `comment` VALUES ('4', '10', '真好吃', '2018-06-03 14:32:33', '4', '1');
INSERT INTO `comment` VALUES ('5', '15', 'haochi', '2018-06-03 15:26:13', '4', '1');
INSERT INTO `comment` VALUES ('6', '16', '暂时未评论', '2018-06-04 11:16:05', '0', '1');
INSERT INTO `comment` VALUES ('7', '9', '暂时未评论', '2018-06-04 11:16:11', '0', '1');

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `f_guige` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `f_tuwen` text COLLATE utf8_unicode_ci,
  `f_kucun` int(11) DEFAULT NULL,
  `f_price` int(11) DEFAULT NULL,
  `f_yuanJia` int(11) DEFAULT NULL,
  `f_pic` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `f_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of fruit
-- ----------------------------
INSERT INTO `fruit` VALUES ('2', '1', '12个装', '好吃不贵', '96122', '35', '90', 'shell651/images/ad841b18591d4568bd77cd53f12cffb6.png', '南丰蜜桔 2');
INSERT INTO `fruit` VALUES ('3', '1', '12个装', '好吃不贵', '9723', '32', '900', 'shell651/images/p2.jpg', '南丰蜜桔 3');
INSERT INTO `fruit` VALUES ('5', '1', '12个装', '好吃不贵', '102', '31', '90', 'shell651/images/p2.jpg', '南丰蜜桔 5');
INSERT INTO `fruit` VALUES ('6', '1', '12个装', '好吃不贵', '90', '39', '90', 'shell651/images/p2.jpg', '南丰蜜桔 6');
INSERT INTO `fruit` VALUES ('7', '1', '12个装', '好吃不贵', '97', '39', '90', 'shell651/images/p2.jpg', '南丰蜜桔7');
INSERT INTO `fruit` VALUES ('8', '2', '99个装', '好吃不贵', '98', '100', '250', 'shell651/images/g1.jpg', '南丰蜜桔');

-- ----------------------------
-- Table structure for local
-- ----------------------------
DROP TABLE IF EXISTS `local`;
CREATE TABLE `local` (
  `loc_id` int(11) NOT NULL AUTO_INCREMENT,
  `loc_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `local` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loc_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of local
-- ----------------------------
INSERT INTO `local` VALUES ('1', '杨振中', '北京市海淀区杏石口路98号甲骨文实训基地', '15565605846', '1');
INSERT INTO `local` VALUES ('2', 'ZhongGeGe', '开封市河南大学（金明）华源学生公寓', '18236560799', '1');
INSERT INTO `local` VALUES ('29', '222', '222', '222', '1');
INSERT INTO `local` VALUES ('30', '1112', '123', '123', '1');
INSERT INTO `local` VALUES ('31', 'a', '1', '1', '1');
INSERT INTO `local` VALUES ('32', '啊', '1', '1', '1');
INSERT INTO `local` VALUES ('33', '啊啊', '123', '123', '1');
INSERT INTO `local` VALUES ('34', '忠哥哥哥', '123', '123', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_id` int(11) DEFAULT NULL,
  `loc_id` int(11) DEFAULT NULL,
  `wl_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `o_zhifufangshi` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `o_date` datetime DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2', '1', '111', '微信支付', '2018-05-26 18:13:21', '1', '11');
INSERT INTO `orders` VALUES ('2', '2', '1', '111', 'qq支付', '2018-05-26 18:13:21', '1', '22');
INSERT INTO `orders` VALUES ('3', '3', '1', null, null, '2018-05-31 15:28:52', '1', '33');
INSERT INTO `orders` VALUES ('6', '3', '2', null, null, '2018-05-31 21:19:42', '1', '234');
INSERT INTO `orders` VALUES ('7', '1', '2', null, null, '2018-06-02 10:31:38', '1', '39');
INSERT INTO `orders` VALUES ('8', '1', '2', null, null, '2018-06-02 10:38:09', '1', '35');
INSERT INTO `orders` VALUES ('9', '2', '29', null, null, '2018-06-03 12:46:02', '1', '317');
INSERT INTO `orders` VALUES ('10', '2', '29', null, null, '2018-06-03 13:21:24', '1', '39');
INSERT INTO `orders` VALUES ('11', '2', '29', null, null, '2018-06-03 13:25:39', '1', '351');
INSERT INTO `orders` VALUES ('12', '2', '29', null, null, '2018-06-03 13:43:39', '1', '35');
INSERT INTO `orders` VALUES ('13', '2', '29', null, null, '2018-06-03 14:24:36', '1', '35');
INSERT INTO `orders` VALUES ('15', '2', '30', null, null, '2018-06-03 15:26:04', '1', '74');
INSERT INTO `orders` VALUES ('16', '2', '31', null, null, '2018-06-04 11:15:21', '1', '35');
INSERT INTO `orders` VALUES ('17', '3', '33', null, null, '2018-06-04 20:39:19', '1', '284');
INSERT INTO `orders` VALUES ('18', '1', '34', null, null, '2018-06-04 21:59:59', '1', '78');

-- ----------------------------
-- Table structure for qingdan
-- ----------------------------
DROP TABLE IF EXISTS `qingdan`;
CREATE TABLE `qingdan` (
  `qd_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` int(11) DEFAULT NULL,
  `f_id` int(11) DEFAULT NULL,
  `qd_num` int(11) DEFAULT NULL,
  `qd_price` int(10) DEFAULT NULL,
  PRIMARY KEY (`qd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of qingdan
-- ----------------------------
INSERT INTO `qingdan` VALUES ('1', '1', '1', '2', '80');
INSERT INTO `qingdan` VALUES ('2', '1', '1', '1', '39');
INSERT INTO `qingdan` VALUES ('3', '2', '2', '2', '80');
INSERT INTO `qingdan` VALUES ('5', '5', '3', '2', '39');
INSERT INTO `qingdan` VALUES ('6', '5', '6', '1', '39');
INSERT INTO `qingdan` VALUES ('7', '6', '4', '6', '39');
INSERT INTO `qingdan` VALUES ('8', '7', '1', '1', '39');
INSERT INTO `qingdan` VALUES ('9', '8', '2', '1', '35');
INSERT INTO `qingdan` VALUES ('10', '9', '8', '2', '100');
INSERT INTO `qingdan` VALUES ('11', '9', '4', '3', '39');
INSERT INTO `qingdan` VALUES ('12', '10', '7', '1', '39');
INSERT INTO `qingdan` VALUES ('13', '11', '6', '9', '39');
INSERT INTO `qingdan` VALUES ('14', '12', '2', '1', '35');
INSERT INTO `qingdan` VALUES ('15', '13', '2', '1', '35');
INSERT INTO `qingdan` VALUES ('16', '15', '3', '1', '39');
INSERT INTO `qingdan` VALUES ('17', '15', '2', '1', '35');
INSERT INTO `qingdan` VALUES ('18', '16', '2', '1', '35');
INSERT INTO `qingdan` VALUES ('19', '17', '2', '7', '35');
INSERT INTO `qingdan` VALUES ('20', '17', '7', '1', '39');
INSERT INTO `qingdan` VALUES ('21', '18', '7', '2', '39');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('1', '鲜果区');
INSERT INTO `sort` VALUES ('2', '礼盒专区');

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `state_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('1', '未完成');
INSERT INTO `state` VALUES ('2', '已完成');
INSERT INTO `state` VALUES ('3', '已取消');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `u_pwd` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `u_picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_lv` int(11) DEFAULT '0',
  `u_qq` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '15565605846', 'E10ADC3949BA59ABBE56E057F20F883E', '/upload/headPicture/test.jpg', '1', '1160951574', 'ZhongGeGe');
INSERT INTO `user` VALUES ('18', '15565605848', 'E10ADC3949BA59ABBE56E057F20F883E', null, '0', null, 'ZhongGeGe');
