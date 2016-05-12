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

-- ----------------------------
-- Table structure for `ci_sms_info`
-- ----------------------------
DROP TABLE IF EXISTS `ci_sms_info`;
CREATE TABLE `ci_sms_info` (
  `id`           SMALLINT(6) NOT NULL                AUTO_INCREMENT
  COMMENT '短信内容id',
  `contact_id`   VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '用户id',
  `contact_name` VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '用户名称',
  `phone`        VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '电话号码',
  `goods_id`     SMALLINT(6) NOT NULL
  COMMENT '商品id',
  `goods_name`   VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '商品名称',
  `goods_model`  VARCHAR(255)
                 COLLATE utf8_unicode_ci             DEFAULT ''
  COMMENT '商品型号',
  `update_date`  DATE                                DEFAULT NULL
  COMMENT '更新时间',
  `send_date`    DATE                                DEFAULT NULL
  COMMENT '发送短信时间',
  `sms_content`  TEXT
  COMMENT '发送短信内容',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

