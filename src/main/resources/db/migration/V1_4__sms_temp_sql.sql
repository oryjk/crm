/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : phpok

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2015-11-18 16:49:11
*/

-- ----------------------------`
-- Table structure for `ci_sms_temp`
-- ----------------------------
DROP TABLE IF EXISTS `ci_sms_temp`;
CREATE TABLE `ci_sms_temp` (
  `id`           SMALLINT(6) NOT NULL                AUTO_INCREMENT
  COMMENT '短信模板id',
  `title`   VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '短信模板标题',
  `content` VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '短信模板内容',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

