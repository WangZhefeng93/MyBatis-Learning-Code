/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-01-08 13:40:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `basketballplayer`
-- ----------------------------
DROP TABLE IF EXISTS `basketballplayer`;
CREATE TABLE `basketballplayer` (
  `id` int(25) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `age` int(2) default NULL,
  `weight` double(25,1) default NULL,
  `height` int(25) default NULL,
  `number` int(25) default NULL,
  `team` varchar(255) default NULL,
  `position` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basketballplayer
-- ----------------------------
INSERT INTO `basketballplayer` VALUES ('1', 'LeBron James', '35', '113.4', '203', '23', 'LAL', 'F');
INSERT INTO `basketballplayer` VALUES ('2', 'Stephen Curry', '31', '86.2', '190', '30', 'WAS', 'G');
INSERT INTO `basketballplayer` VALUES ('3', 'Kevin Durant', '31', '108.8', '213', '35', 'WAS', 'F');
INSERT INTO `basketballplayer` VALUES ('4', 'James Harden', '30', '99.8', '195', '13', 'HOU', 'G');
INSERT INTO `basketballplayer` VALUES ('15', 'Kawhi Leonard', '28', '104.3', '200', '2', 'TRO', 'F');

-- ----------------------------
-- Table structure for `batch`
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `batch_id` int(11) NOT NULL auto_increment,
  `cus_id` int(11) NOT NULL COMMENT '创建批次用户id',
  `number` varchar(32) NOT NULL COMMENT '批次编码',
  `createtime` datetime NOT NULL COMMENT '创建批次时间',
  `note` varchar(100) default NULL COMMENT '备注',
  PRIMARY KEY  (`batch_id`),
  KEY `FK_batch_1` (`cus_id`),
  CONSTRAINT `FK_batch_id` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batch
-- ----------------------------
INSERT INTO `batch` VALUES ('1', '1', '00001', '2017-07-22 00:00:00', '首次购买');
INSERT INTO `batch` VALUES ('2', '3', '00002', '2017-03-11 00:00:00', '委托购买');

-- ----------------------------
-- Table structure for `batchdetail`
-- ----------------------------
DROP TABLE IF EXISTS `batchdetail`;
CREATE TABLE `batchdetail` (
  `id` int(11) NOT NULL auto_increment,
  `batch_id` int(11) NOT NULL COMMENT '批次id',
  `product_id` int(11) NOT NULL COMMENT '理财产品id',
  `product_num` int(11) default NULL COMMENT '理财产品购买数量',
  PRIMARY KEY  (`id`),
  KEY `FK_batchdetail_1` (`batch_id`),
  KEY `FK_batchdetail_2` (`product_id`),
  CONSTRAINT `FK_batchdetai_1` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_batchdetai_2` FOREIGN KEY (`product_id`) REFERENCES `finacial_products` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batchdetail
-- ----------------------------
INSERT INTO `batchdetail` VALUES ('1', '1', '1', '2');
INSERT INTO `batchdetail` VALUES ('2', '1', '2', '1');
INSERT INTO `batchdetail` VALUES ('3', '1', '3', '1');
INSERT INTO `batchdetail` VALUES ('4', '2', '1', '2');
INSERT INTO `batchdetail` VALUES ('5', '2', '2', '1');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(255) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `isbn` varchar(255) default NULL,
  `publisher` varchar(255) default NULL,
  `number` int(255) default NULL,
  `price` double(255,0) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java程序员开发指南', '张义，李剑编', '7-80172-267-001', '清华大学出版社', '10', '45');
INSERT INTO `book` VALUES ('2', '达芬奇密码', '丹·布朗', '7-80172-267-002', '兰登书屋', '10', '45');
INSERT INTO `book` VALUES ('3', '解忧杂货铺', '东野圭谷', '7-80172-267-003', '角川书店', '10', '45');
INSERT INTO `book` VALUES ('4', '为奴二十年', '所罗门·诺瑟普', '7-80172-267-004', '好莱坞', '10', '45');
INSERT INTO `book` VALUES ('5', '三体Ⅰ', '刘慈欣', '7-80172-267-005', '《科幻世界》杂志', '10', '45');
INSERT INTO `book` VALUES ('6', '冰与火之歌全集', '乔治·R·R·马丁(George R.R. Martin)', '7-80172-267-006', '《科幻世界》杂志', '10', '45');

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `cid` int(5) NOT NULL auto_increment,
  `cname` varchar(20) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'USA');
INSERT INTO `country` VALUES ('2', 'England');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(255) NOT NULL auto_increment,
  `no` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `score` int(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'C001', '数据结构', '3');
INSERT INTO `course` VALUES ('2', 'C002', '操作系统', '3');
INSERT INTO `course` VALUES ('3', 'C003', '计算机网络', '3');
INSERT INTO `course` VALUES ('4', 'C004', '计算机组成原理', '3');
INSERT INTO `course` VALUES ('5', 'C005', '算法设计与分析', '3');
INSERT INTO `course` VALUES ('6', 'C006', 'C语言程序设计', '3');
INSERT INTO `course` VALUES ('7', 'C007', '数据挖掘', '2');
INSERT INTO `course` VALUES ('8', 'C008', '机器学习', '2');
INSERT INTO `course` VALUES ('9', 'C009', 'Linus操作系统', '2');
INSERT INTO `course` VALUES ('10', 'C010', 'Java程序语言设计', '2');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cus_id` int(11) NOT NULL auto_increment,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `acno` varchar(32) default NULL COMMENT '卡号',
  `gender` varchar(4) default NULL COMMENT '性别',
  `phone` varchar(256) default NULL COMMENT '电话',
  PRIMARY KEY  (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '刘云', '6228286666666', '男', '13800000000');
INSERT INTO `customer` VALUES ('2', '李健', '622848111111', '男', '13811111111');
INSERT INTO `customer` VALUES ('3', '张丽丽', '622848333333', '女', '13822222222');

-- ----------------------------
-- Table structure for `finacial_products`
-- ----------------------------
DROP TABLE IF EXISTS `finacial_products`;
CREATE TABLE `finacial_products` (
  `product_id` int(11) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL COMMENT '理财产品名称',
  `price` float(10,1) NOT NULL COMMENT '理财产品定价',
  `detail` text COMMENT '理财产品描述',
  `pic` varchar(64) default NULL COMMENT '理财产品图片',
  `invasttime` datetime NOT NULL COMMENT '理财产品收益日期',
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finacial_products
-- ----------------------------
INSERT INTO `finacial_products` VALUES ('1', '一起富', '5000.0', '投资少，风险小', 'img001', '2017-06-21 00:00:00');
INSERT INTO `finacial_products` VALUES ('2', '惠薪富', '10000.0', '收益稳健', 'img002', '2017-05-03 00:00:00');
INSERT INTO `finacial_products` VALUES ('3', '安富尊容', '15000.0', '年收益率提升5%', 'img003', '2017-07-18 00:00:00');
INSERT INTO `finacial_products` VALUES ('4', '富津利', '2000.0', '企划收益率', 'img004', '2017-04-11 00:00:00');

-- ----------------------------
-- Table structure for `gameplayer`
-- ----------------------------
DROP TABLE IF EXISTS `gameplayer`;
CREATE TABLE `gameplayer` (
  `id` int(110) NOT NULL auto_increment,
  `name` varchar(225) collate utf8_bin default NULL,
  `gender` varchar(100) collate utf8_bin default NULL,
  `level` int(110) default NULL,
  `ptype` int(110) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gameplayer
-- ----------------------------
INSERT INTO `gameplayer` VALUES ('1', '牛牛战士', '男', '31', '1');
INSERT INTO `gameplayer` VALUES ('2', '芙蓉净月', '女', '22', '2');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(255) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `price` double(255,0) default NULL,
  `number` int(255) default NULL,
  `type` varchar(255) default NULL,
  `no` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'Bose QC35II', '2889', '50', '耳机', 'EJ456138');
INSERT INTO `goods` VALUES ('2', 'SKII 神仙水', '1035', '20', '化妆品', 'MZ789463');
INSERT INTO `goods` VALUES ('3', 'NIKE Kobe 15', '1689', '30', '鞋类', 'XZ459317');

-- ----------------------------
-- Table structure for `magician_info`
-- ----------------------------
DROP TABLE IF EXISTS `magician_info`;
CREATE TABLE `magician_info` (
  `range` int(110) default NULL,
  `power` int(110) default NULL,
  `gpid` int(110) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of magician_info
-- ----------------------------
INSERT INTO `magician_info` VALUES ('213', '210', '2');

-- ----------------------------
-- Table structure for `minister`
-- ----------------------------
DROP TABLE IF EXISTS `minister`;
CREATE TABLE `minister` (
  `mid` int(5) NOT NULL auto_increment,
  `mname` varchar(20) default NULL,
  `countryId` int(5) default NULL,
  PRIMARY KEY  (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of minister
-- ----------------------------
INSERT INTO `minister` VALUES ('1', 'aaa', '1');
INSERT INTO `minister` VALUES ('2', 'bbb', '1');
INSERT INTO `minister` VALUES ('3', 'ccc', '1');
INSERT INTO `minister` VALUES ('4', 'ddd', '2');
INSERT INTO `minister` VALUES ('5', 'eee', '2');

-- ----------------------------
-- Table structure for `newslabel`
-- ----------------------------
DROP TABLE IF EXISTS `newslabel`;
CREATE TABLE `newslabel` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `pid` int(5) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newslabel
-- ----------------------------
INSERT INTO `newslabel` VALUES ('1', '娱乐新闻', '0');
INSERT INTO `newslabel` VALUES ('2', '体育新闻', '0');
INSERT INTO `newslabel` VALUES ('3', 'NBA', '2');
INSERT INTO `newslabel` VALUES ('4', 'CBA', '2');
INSERT INTO `newslabel` VALUES ('5', '火箭', '3');
INSERT INTO `newslabel` VALUES ('6', '湖人', '3');
INSERT INTO `newslabel` VALUES ('7', '北京金隅', '4');
INSERT INTO `newslabel` VALUES ('8', '浙江广厦', '4');
INSERT INTO `newslabel` VALUES ('9', '青岛双星', '4');
INSERT INTO `newslabel` VALUES ('10', '港台明星', '1');
INSERT INTO `newslabel` VALUES ('11', '内地明星', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `age` int(3) default NULL,
  `score` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '23', '93.5');
INSERT INTO `student` VALUES ('2', '李四', '24', '94.5');
INSERT INTO `student` VALUES ('3', '王五', '25', '92.5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(120) collate utf8_bin default NULL,
  `password` varchar(50) collate utf8_bin default NULL,
  `gender` varchar(5) collate utf8_bin default NULL,
  `email` varchar(100) collate utf8_bin default NULL,
  `province` varchar(50) collate utf8_bin default NULL,
  `city` varchar(50) collate utf8_bin default NULL,
  `birthday` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '111', '男', 'zhangsan@126.com', '河南省', '郑州市', '1991-04-23');
INSERT INTO `user` VALUES ('2', '李四', '222', '男', '2222@126.com', '河北省', '唐山市', '1989-10-13');
INSERT INTO `user` VALUES ('3', '刘丽', '333', '女', '3333@126.com', '江苏省', '苏州市', '1994-06-09');
INSERT INTO `user` VALUES ('4', '王丽', '444', '女', '4444@126.com', '四川省', '成都市', '1992-11-07');

-- ----------------------------
-- Table structure for `warrior_info`
-- ----------------------------
DROP TABLE IF EXISTS `warrior_info`;
CREATE TABLE `warrior_info` (
  `svalue` int(110) default NULL,
  `power` int(110) default NULL,
  `gpid` int(110) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of warrior_info
-- ----------------------------
INSERT INTO `warrior_info` VALUES ('330', '420', '1');
