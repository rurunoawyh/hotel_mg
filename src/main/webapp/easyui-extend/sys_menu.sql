/*
Navicat MySQL Data Transfer

Source Server         : yulei
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : cmfz_yulei

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-11-24 12:39:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL auto_increment,
  `menu_name` varchar(255) default NULL,
  `menu_url` varchar(255) default NULL,
  `menu_parent` int(11) default NULL,
  `iconCls` varchar(255) default NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `fk5` (`role_id`),
  CONSTRAINT `fk5` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统模块', null, '0', 'icon-user_suit_black', '1');
INSERT INTO `sys_menu` VALUES ('2', '管理员管理', '/cmfz_yul/showAdmin.jsp', '1', 'icon-2012081511913', '1');
INSERT INTO `sys_menu` VALUES ('3', '轮播图模块', null, '0', 'icon-user', '2');
INSERT INTO `sys_menu` VALUES ('4', '轮播图管理', '/cmfz_yul/showLunbotu2.jsp', '3', 'icon-folder_picture', '2');
INSERT INTO `sys_menu` VALUES ('5', '闻(吉祥妙音)模块', null, '0', 'icon-user', '2');
INSERT INTO `sys_menu` VALUES ('6', '专辑管理', '/cmfz_yul/showSpecialByMaster.jsp', '5', 'icon-cdr', '2');
INSERT INTO `sys_menu` VALUES ('7', '音频管理', '/cmfz_yul/showAudio.jsp', '5', 'icon-music', '2');
INSERT INTO `sys_menu` VALUES ('8', '思(甘露妙宝)模块', null, '0', 'icon-user', '2');
INSERT INTO `sys_menu` VALUES ('9', '文章管理', '/cmfz_yul/showArticle.jsp', '8', 'icon-application_edit', '2');
INSERT INTO `sys_menu` VALUES ('10', '用户模块', null, '0', 'icon-user_alert', '3');
INSERT INTO `sys_menu` VALUES ('11', '上师管理', '/cmfz_yul/showMaster.jsp', '10', 'icon-user_orange', '3');
INSERT INTO `sys_menu` VALUES ('12', '用户管理', '/cmfz_yul/showUser.jsp', '10', 'icon-user_comment', '3');
INSERT INTO `sys_menu` VALUES ('13', '功课管理', '/cmfz_yul/showLesson.jsp', '10', 'icon-color', '3');
INSERT INTO `sys_menu` VALUES ('14', '计数器', '/cmfz_yul/showCounter.jsp', '10', 'icon-wand', '3');
