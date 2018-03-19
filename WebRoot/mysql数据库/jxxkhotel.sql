/*
 Navicat MySQL Data Transfer

 Source Server         : guan
 Source Server Version : 50173
 Source Host           : localhost
 Source Database       : jxxkhotel

 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 03/30/2017 00:18:02 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `balance`
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordernum` varchar(255) DEFAULT '' COMMENT '入住单号',
  `handnum` varchar(255) DEFAULT NULL COMMENT ' 手工单号',
  `billtime` varchar(255) DEFAULT NULL COMMENT '收款时间',
  `totalmoney` double DEFAULT NULL COMMENT '总计消费金额',
  `mcash` double DEFAULT NULL COMMENT '现金',
  `mother` double DEFAULT NULL COMMENT '其他支付',
  `bookkeeper` varchar(255) DEFAULT NULL COMMENT '操作员',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `balance`
-- ----------------------------
BEGIN;
INSERT INTO `balance` VALUES ('1', '20170106010642', '', '2017-01-06 06:07:39', '1555', '311', '1244', 'recept', '||'), ('2', '20170228230125', '123', '2017-02-28 23:30:21', '144', '44', '100', 'recept', '123'), ('3', '20170228233502', '', '2017-02-28 23:35:23', '100', '100', '0', 'recept', ''), ('4', '20170329150630', '78974', '2017-03-29 15:16:46', '44', '-9957', '10001', 'hotel1', ''), ('5', '20170329151603', '', '2017-03-29 15:17:07', '68', '-32', '100', 'hotel1', ''), ('6', '20170329150003', '', '2017-03-29 21:26:56', '153', '53', '100', 'hotel1', ''), ('7', '20170329142925', '', '2017-03-29 21:27:59', '329', '-671', '1000', 'hotel1', ''), ('8', '20170329212625', '', '2017-03-29 21:28:26', '68', '-932', '1000', 'hotel1', ''), ('9', '20170329151625', '', '2017-03-29 21:28:54', '44', '-9957', '10001', 'hotel1', '');
COMMIT;

-- ----------------------------
--  Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pro_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid_pid` (`pro_id`),
  CONSTRAINT `cid_pid` FOREIGN KEY (`pro_id`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `city`
-- ----------------------------
BEGIN;
INSERT INTO `city` VALUES ('1', '长春', '1'), ('2', '吉林', '1'), ('3', '成都', '2'), ('4', '攀枝花', '2'), ('5', '长沙', '3'), ('6', '岳阳', '3'), ('7', '湘潭', '3'), ('8', '沈阳', '4'), ('9', '大连', '4'), ('10', '南京', '5'), ('11', '常州', '5'), ('12', '无锡', '5'), ('13', '苏州', '5'), ('14', '盐城', '5');
COMMIT;

-- ----------------------------
--  Table structure for `consumption`
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '酒店ID',
  `ordernum` varchar(255) DEFAULT NULL COMMENT '入账单号',
  `guestname` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL COMMENT '入账时间',
  `roomnum` varchar(255) DEFAULT NULL COMMENT '房号',
  `checked` int(11) NOT NULL DEFAULT '0' COMMENT '判断是否已经结账（0表示未结账1表示结账）',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `consumption`
-- ----------------------------
BEGIN;
INSERT INTO `consumption` VALUES ('44', '1', '20170106010642', '王丹丹', '2017-01-06 01:06:42', 'HH007', '1', ''), ('45', '1', '20170228230125', '王丹丹', '2017-02-28 23:01:25', 'YC004', '1', '124123'), ('46', '1', '20170228233121', '管生辉', '2017-02-28 23:31:21', 'YC004', '1', 'kapchuang'), ('49', '1', '20170311215547', '王丹丹', '2017-03-11 21:55:47', 'YC002', '1', '傻  逼'), ('51', '1', '20170320091702', '王丹丹', '2017-03-20 09:17:02', 'YC001', '1', ''), ('52', '1', '20170329090712', '王丹丹', '2017-03-29 09:07:12', 'YC002', '1', ''), ('53', '1', '20170329092554', '王丹丹', '2017-03-29 09:25:54', 'YC002', '1', ''), ('54', '1', '20170329142925', '王丹丹', '2017-03-29 14:29:25', 'YC001', '1', ''), ('55', '1', '20170329150003', '管生辉', '2017-03-29 15:00:03', 'YC002', '1', ''), ('56', '1', '20170329150630', '王丹丹', '2017-03-29 15:06:30', 'YC004', '1', ''), ('57', '1', '20170329151603', '王丹丹', '2017-03-29 15:16:03', 'YC003', '1', ''), ('58', '1', '20170329151625', '王丹丹', '2017-03-29 15:16:25', 'YC004', '1', ''), ('59', '1', '20170329212625', '王丹丹', '2017-03-29 21:26:25', 'YC003', '1', ''), ('60', '1', '20170329212641', '大范甘迪', '2017-03-29 21:26:41', 'YC004', '0', ''), ('61', '1', '20170329232706', '王丹丹', '2017-03-29 23:27:06', 'YC003', '0', ''), ('62', '1', '20170329233446', '大范甘迪', '2017-03-29 23:34:46', 'YC001', '0', '');
COMMIT;

-- ----------------------------
--  Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '酒店id',
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `goods`
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES ('1', '1', '金士顿16G优盘', '32', '数码', '6', '30', null), ('2', '1', '斯伯丁篮球', '450', '运动', '6', '400', null), ('3', '1', '纯棉被套', '150', '床上用品', '7', '100', null), ('4', '1', '运动背包', '132', '运动', '4', '130', null), ('5', '1', '床上四件套', '456', '床上用品', '0', '400', null), ('6', '1', '蚕丝被', '220', '床上用品', '7', '220', null), ('7', '1', '手机壳', '25', '数码', '151', '15', null), ('8', '1', '手机支架', '21', '数码', '12', '20', null), ('9', '1', '大润发100元购物卡', '100', '其他', '97', '99', null), ('10', '1', '戴尔移动硬盘SSD', '500', '数码', '9', '500', null), ('11', '1', '护腕', '30', '运动', '15', '30', null);
COMMIT;

-- ----------------------------
--  Table structure for `guest`
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomid` int(255) NOT NULL COMMENT '房间号',
  `guestname` varchar(255) DEFAULT '' COMMENT '宾客姓名',
  `tel` varchar(255) DEFAULT '' COMMENT '联系电话',
  `sex` varchar(255) DEFAULT '' COMMENT '客人性别',
  `idtype` int(11) DEFAULT '1' COMMENT '证件类型（默认：0）\r\n1：身份证;\r\n2：学生证;\r\n3：军人证;\r\n4：驾驶证;\r\n5：护照;\r\n6：员工证;\r\n7：其他;\r\n',
  `idnum` varchar(255) DEFAULT '' COMMENT '证件号码',
  `area` varchar(255) DEFAULT '' COMMENT '客人地址',
  `guesttype` int(11) DEFAULT '1' COMMENT '客人类型（默认：1）\r\n1：普通宾客;\r\n2：VIP客户\r\n3：酒店员工\r\n4：协议单位',
  `guestsource` int(11) DEFAULT '1' COMMENT '客人来源（默认1）\r\n1：散客自入\r\n2：直接预定\r\n3：协议单位\r\n',
  `corporatename` varchar(11) DEFAULT '' COMMENT '协议单位',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `guest_type` (`guesttype`),
  KEY `guest_source` (`guestsource`),
  KEY `card_id` (`idtype`),
  CONSTRAINT `card_id` FOREIGN KEY (`idtype`) REFERENCES `idtype` (`id`),
  CONSTRAINT `guest_source` FOREIGN KEY (`guestsource`) REFERENCES `guest_source` (`id`),
  CONSTRAINT `guest_type` FOREIGN KEY (`guesttype`) REFERENCES `guest_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `guest`
-- ----------------------------
BEGIN;
INSERT INTO `guest` VALUES ('10', '2', '管生辉', '15206123630', '男', '1', '320923199511174213', '常州', '2', null, null, 'kapchuang'), ('26', '15', '王丹丹', '15206123630', '女', '1', '320923199511174213', '南京', '2', null, null, ''), ('27', '16', '管生辉', '15206123630', '男', '1', '320923199511174213', '常州', '2', null, null, ''), ('28', '18', '王丹丹', '15206123630', '女', '1', '320923199511174213', '南京', '2', null, null, ''), ('29', '17', '王丹丹', '15206123630', '女', '1', '320923199511174213', '南京', '2', null, null, ''), ('30', '18', '王丹丹', '15206123630', '女', '1', '320923199511174213', '南京', '2', null, null, ''), ('31', '17', '王丹丹', '15206123630', '女', '1', '320923199511174213', '南京', '2', null, null, ''), ('32', '18', '大范甘迪', '15206123630', '女', '1', '320923199511174213', '常州', '2', null, null, ''), ('33', '17', '王丹丹', '15206123630', '女', '1', '320923199511174213', '南京', '2', null, null, ''), ('34', '15', '大范甘迪', '15206123630', '女', '1', '320923199511174213', '常州', '2', null, null, '');
COMMIT;

-- ----------------------------
--  Table structure for `guest_source`
-- ----------------------------
DROP TABLE IF EXISTS `guest_source`;
CREATE TABLE `guest_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gsourcename` varchar(255) DEFAULT NULL COMMENT '宾客来源信息',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `guest_source`
-- ----------------------------
BEGIN;
INSERT INTO `guest_source` VALUES ('1', '散客自入'), ('2', 'vip会员'), ('3', '协议单位'), ('4', '酒店管理');
COMMIT;

-- ----------------------------
--  Table structure for `guest_type`
-- ----------------------------
DROP TABLE IF EXISTS `guest_type`;
CREATE TABLE `guest_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gtypename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `guest_type`
-- ----------------------------
BEGIN;
INSERT INTO `guest_type` VALUES ('1', '普通宾客'), ('2', 'VIP客户'), ('3', '酒店员工'), ('4', '协议单位');
COMMIT;

-- ----------------------------
--  Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hid` int(11) NOT NULL AUTO_INCREMENT COMMENT '酒店id',
  `hnum` varchar(255) NOT NULL DEFAULT '' COMMENT '酒店编号',
  `hname` varchar(255) NOT NULL DEFAULT '' COMMENT '酒店名称',
  `hlevel` int(11) NOT NULL DEFAULT '1' COMMENT '酒店等级/类型(1经济型酒店2星级酒店3豪华酒店)',
  `hchargetel` varchar(255) NOT NULL DEFAULT '' COMMENT '酒店负责人联系方式',
  `hadress` varchar(255) NOT NULL DEFAULT '' COMMENT '酒店地址',
  `haskid` int(11) NOT NULL DEFAULT '0' COMMENT '是否有添加分店权限(1有，0没有)',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`hid`),
  KEY `hid` (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hotel`
-- ----------------------------
BEGIN;
INSERT INTO `hotel` VALUES ('1', 'HN0001', '如家连锁酒店', '1', '8888-6666', '常州', '0', '无'), ('2', 'HN0002', '喜来登酒店', '1', '8888-6868', '常州', '0', '无');
COMMIT;

-- ----------------------------
--  Table structure for `hotel_kids`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_kids`;
CREATE TABLE `hotel_kids` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pidhid` int(11) NOT NULL COMMENT '主店id',
  `kidhid` int(11) NOT NULL COMMENT '分店id',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `hotel_mem`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_mem`;
CREATE TABLE `hotel_mem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '酒店id',
  `memid` int(11) NOT NULL COMMENT '会员ID',
  PRIMARY KEY (`id`),
  KEY `hid` (`hid`),
  KEY `memid` (`memid`),
  CONSTRAINT `fk_hid` FOREIGN KEY (`hid`) REFERENCES `hotel` (`hid`),
  CONSTRAINT `fk_memid` FOREIGN KEY (`memid`) REFERENCES `members` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `hotel_user`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_user`;
CREATE TABLE `hotel_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `hid` int(11) NOT NULL COMMENT '酒店id',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `hid` (`hid`),
  KEY `uid` (`uid`),
  CONSTRAINT `hid` FOREIGN KEY (`hid`) REFERENCES `hotel` (`hid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hotel_user`
-- ----------------------------
BEGIN;
INSERT INTO `hotel_user` VALUES ('1', '1', '1', ''), ('2', '2', '1', ''), ('3', '3', '2', '');
COMMIT;

-- ----------------------------
--  Table structure for `idtype`
-- ----------------------------
DROP TABLE IF EXISTS `idtype`;
CREATE TABLE `idtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `idtype`
-- ----------------------------
BEGIN;
INSERT INTO `idtype` VALUES ('1', '身份证'), ('2', '学生证'), ('3', '军人证'), ('4', '驾驶证'), ('5', '护照'), ('6', '员工证'), ('7', '其他');
COMMIT;

-- ----------------------------
--  Table structure for `mem_con`
-- ----------------------------
DROP TABLE IF EXISTS `mem_con`;
CREATE TABLE `mem_con` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memid` int(11) NOT NULL,
  `conid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `mem_type`
-- ----------------------------
DROP TABLE IF EXISTS `mem_type`;
CREATE TABLE `mem_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '酒店ID',
  `typename` varchar(255) NOT NULL COMMENT '会员类型名称',
  `cardfee` double NOT NULL COMMENT '卡费',
  `uppoints` double DEFAULT NULL COMMENT '升级所需积分',
  `roomrate` double DEFAULT NULL COMMENT '房费折扣率',
  `goodrate` double DEFAULT NULL COMMENT '商品消费折扣率',
  `pointsrule` int(11) DEFAULT '10' COMMENT '代表没消费多少金额增加一分（默认十）',
  `state` int(11) DEFAULT '1' COMMENT '默认1（使用）',
  `sprice` int(11) NOT NULL DEFAULT '0' COMMENT '特价房是否享受会员折扣（0否，1是）',
  `ramark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `mem_type`
-- ----------------------------
BEGIN;
INSERT INTO `mem_type` VALUES ('1', '2', '普通会员', '20', '100', '1', '1', '10', '1', '0', '每消费10元积1分，升级需100积分'), ('2', '2', '银卡会员', '30', '300', '0.95', '0.95', '9', '1', '0', '每消费9元积1分，升级需300积分'), ('3', '2', '金卡会员', '40', '600', '0.9', '0.9', '7', '1', '0', '每消费7元积1分，升级需600积分'), ('4', '2', '白金会员', '50', '1000', '0.85', '0.85', '6', '1', '0', '每消费6元积1分，分升级1000积分'), ('5', '2', '尊享会员', '80', '1500', '0.8', '0.8', '5', '1', '1', '每消费5元积1分，升级需1500积分');
COMMIT;

-- ----------------------------
--  Table structure for `members`
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memnum` varchar(255) DEFAULT '',
  `memname` varchar(255) DEFAULT '',
  `mempass` varchar(255) DEFAULT '',
  `sex` varchar(11) DEFAULT NULL,
  `age` int(11) DEFAULT '18',
  `tel` varchar(255) DEFAULT '',
  `area` varchar(11) DEFAULT '',
  `memtype` int(11) NOT NULL DEFAULT '1' COMMENT '默认1（普通会员）',
  `idtype` int(11) NOT NULL DEFAULT '1' COMMENT '默认身份证',
  `idnum` varchar(255) DEFAULT '',
  `birthday` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT '',
  `endtime` varchar(255) DEFAULT '',
  `totalmoney` double DEFAULT '0',
  `leftmoney` double DEFAULT '0',
  `totalpoints` double DEFAULT '0',
  `usedpoints` double DEFAULT '0',
  `leftpoints` double DEFAULT '0',
  `badrecord` int(11) DEFAULT '0' COMMENT '不良费消记录',
  `state` varchar(11) DEFAULT '1' COMMENT '默认正常（1），挂失（2），黑名单（3）',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `hid` int(11) NOT NULL COMMENT '酒店ID',
  PRIMARY KEY (`id`),
  KEY `id_type` (`idtype`),
  KEY `mem_type` (`memtype`),
  CONSTRAINT `id_type` FOREIGN KEY (`idtype`) REFERENCES `idtype` (`id`),
  CONSTRAINT `mem_type` FOREIGN KEY (`memtype`) REFERENCES `mem_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `members`
-- ----------------------------
BEGIN;
INSERT INTO `members` VALUES ('1', '10001', '王丹丹', '1234', '女', '18', '15206123630', '南京', '5', '1', '320923199511174213', '1995-08-01', '2016-12-30', '', '12227', '9591', '10525', '7892', '2383', '0', '1', '安静的房间', '0'), ('2', '10002', '管生辉', '1234', '男', '18', '15206123630', '常州', '4', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '1000', '9876', '10020', '0', '9760', '0', '1', '有窗', '0'), ('3', '10003', '发送到', '1234', '男', '18', '15206123630', '常州', '3', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '100', '15', '50', '0', '50', '0', '2', '14213', '0'), ('4', '10004', '爱发呆', '1234', '女', '18', '15206123630', '常州', '2', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '200', '21', '60', '0', '60', '0', '1', '1241232143', '0'), ('7', '10005', '大范甘迪', '1234', '女', '18', '15206123630', '常州', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '262', '156', '90', '80', '10', '0', '1', '1241231', '0'), ('11', '21651', '好地方规定', '1234', '女', '18', '15206123630', '盐城', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '1564', '1523', '150', '152', '21', '3', '1', '124123', '0'), ('12', '16562', '大锅饭', '1234', '男', '18', '15206123630', '盐城', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '212', '5', '263', '12', '14', '0', '1', '124124123', '0'), ('13', '21656', '阿士大夫撒旦', '1234', '女', '18', '15206123630', '盐城', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '5661', '1056', '152', '351', '14', '0', '1', '124123', '0'), ('14', '15151', '发送到', '1234', '男', '18', '15206123630', '南京', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '123', '165', '65', '231', '65', '0', '1', '啊噶是的', '0'), ('15', '01321', '噶是的企鹅', '1234', '男', '18', '15206123630', '盐城', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '12341', '213', '65156', '31', '32', '0', '1', '挨个发送的', '0'), ('16', '03201', '按是否撒的', '1234', '男', '18', '15206123630', '常州', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '156', '31', '651', '21032', '26', '0', '1', '啊噶是的', '0'), ('17', '15616', '412312', '1234', '女', '18', '15206123630', '南京', '1', '1', '320923199511174213', '1995-09-25', '2016-12-30', '', '213', '2315', '2011', '1', '26', '0', '1', '124123', '0'), ('18', '34567', '李锦鹏', '1234', '男', '18', '15206123618', '江苏省 淮安市 盱眙县', '1', '1', '320830199507061038', '-1-9-9-5--0-7--0-6-', '2017-01-04', '', '0', '0', '0', '0', '0', '0', '1', '小胖。安静的房间', '0');
COMMIT;

-- ----------------------------
--  Table structure for `operation`
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operationname` varchar(40) DEFAULT NULL,
  `resourceid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m8ifna0f29xchshh5omwnsxwc` (`resourceid`),
  CONSTRAINT `FK_m8ifna0f29xchshh5omwnsxwc` FOREIGN KEY (`resourceid`) REFERENCES `resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `org`
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `description` longtext,
  `iconCls` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `principal` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paymethod`
-- ----------------------------
DROP TABLE IF EXISTS `paymethod`;
CREATE TABLE `paymethod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `paymethod`
-- ----------------------------
BEGIN;
INSERT INTO `paymethod` VALUES ('1', '现金'), ('2', '入账'), ('3', '网上支付'), ('4', '储值卡'), ('5', '信用卡'), ('6', '酒店员工');
COMMIT;

-- ----------------------------
--  Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `province`
-- ----------------------------
BEGIN;
INSERT INTO `province` VALUES ('1', '吉林省'), ('2', '四川'), ('3', '湖南'), ('4', '辽宁'), ('5', '江苏');
COMMIT;

-- ----------------------------
--  Table structure for `recharge`
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memnum` varchar(255) DEFAULT NULL,
  `paymethod` int(11) DEFAULT NULL,
  `recmoney` double DEFAULT NULL,
  `rectime` varchar(255) DEFAULT NULL,
  `bookkeeper` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `paymethod` (`paymethod`),
  CONSTRAINT `pay_id` FOREIGN KEY (`paymethod`) REFERENCES `paymethod` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `recharge`
-- ----------------------------
BEGIN;
INSERT INTO `recharge` VALUES ('6', '10001', '1', '123', '2017-01-06 06:17:01', 'recept', null), ('7', '10001', '1', '100', '2017-03-29 21:59:17', 'hotel1', null);
COMMIT;

-- ----------------------------
--  Table structure for `reserve`
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resnumber` varchar(255) DEFAULT NULL COMMENT '订单号',
  `roomnum` varchar(11) NOT NULL COMMENT '房间号(空则系统随机一间类型房)',
  `memnum` varchar(11) DEFAULT '否' COMMENT '会员卡号',
  `resname` varchar(255) DEFAULT '' COMMENT '预定人姓名',
  `comname` varchar(255) DEFAULT '' COMMENT '公司名称',
  `restel` varchar(255) DEFAULT '' COMMENT '预订电话',
  `starttime` varchar(255) DEFAULT '' COMMENT '预抵时间',
  `endtime` varchar(255) DEFAULT '' COMMENT '预离时间',
  `restime` varchar(255) DEFAULT '' COMMENT '预订时间',
  `resstate` varchar(255) DEFAULT '正常' COMMENT '订单状态（默认正常；取消）',
  `ressource` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='InnoDB free: 3072 kB; (`memid`) REFER `jxxkhotel/members`(`i';

-- ----------------------------
--  Records of `reserve`
-- ----------------------------
BEGIN;
INSERT INTO `reserve` VALUES ('40', '20170315170624', 'BD002', '10001', '王丹丹', '', '15206123630', '2017-03-16 18:00:00', '2017-03-17 12:00:00', '2017-03-15 17:06:24', '取消', null, ''), ('41', '20170329130548', 'SW003', '10001', '王丹丹', '', '15206123630', '2017-03-30 18:00:00', '2017-03-31 12:00:00', '2017-03-29 13:05:48', '取消', null, '');
COMMIT;

-- ----------------------------
--  Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `checked` int(10) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `resource`
-- ----------------------------
BEGIN;
INSERT INTO `resource` VALUES ('1', '极限星空酒店后台管理系统', null, '0', null, '0'), ('2', '用户管理', null, '0', 'icon-treeuser', '1'), ('3', '用户信息', 'jump/system/tableedit.do', '0', 'icon-treeulist', '2'), ('4', '权限管理', 'jump/system/ushouquan.do', '0', 'icon-treeures', '2'), ('5', '用户3', null, '0', null, '2'), ('7', '用户4', '', '0', null, '2'), ('8', '房间管理', null, null, 'icon-treehouse', '1'), ('9', '房间列表', 'jump/system/roommanage.do', null, 'icon-treehouse', '8'), ('10', '房型设置', 'jump/system/roomtype.do', '0', null, '8'), ('11', '房间3', '', '0', null, '8'), ('12', '房间4', '', '0', null, '8'), ('13', '系统管理', '', '0', 'icon-treesys', '1'), ('14', '数据安全', 'jsp/shouquan.do', '0', 'icon-treedata', '13'), ('15', '菜单图标', '', '0', null, '13'), ('16', '系统3', '123', '0', null, '13'), ('17', '系统4', null, null, null, '13'), ('18', '其他', null, null, 'icon-treeother', '1'), ('19', '个人信息', 'jump/system/roommanage.do', null, 'icon-treepeo', '18'), ('20', '安全退出', 'jump/system/roommanage.do', null, 'icon-treeout', '18'), ('22', '会员管理', null, null, null, '1'), ('23', '积分规则', 'jump/system/mempoint.do', null, null, '22'), ('24', '黑名单管理', 'jump/system/memblack.do', null, null, '22'), ('25', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `rf_guest`
-- ----------------------------
DROP TABLE IF EXISTS `rf_guest`;
CREATE TABLE `rf_guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guestsource` varchar(255) DEFAULT NULL COMMENT '宾客来源',
  `sourcenum` int(11) DEFAULT NULL COMMENT '此来源的人数',
  `guesttype` varchar(255) DEFAULT NULL COMMENT '宾客类别',
  `typenum` int(11) DEFAULT NULL COMMENT '此类型的人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `rgood`
-- ----------------------------
DROP TABLE IF EXISTS `rgood`;
CREATE TABLE `rgood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spjm` varchar(255) NOT NULL,
  `spname` varchar(255) DEFAULT NULL,
  `spprice` double(255,0) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `sptype` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `rgood`
-- ----------------------------
BEGIN;
INSERT INTO `rgood` VALUES ('1', 'xb', '雪碧', '5', '46', '饮料酒水 ', null), ('2', 'hgds', '哈根达斯', '50', '43', '其他', null), ('3', 'pm', '泡面', '5', '49', '其他', null), ('4', 'gbm', '干拌面', '5', '46', '其他', null), ('5', 'xhpj', '雪花啤酒', '5', '50', '饮料酒水', null), ('6', 'xy', '香烟', '120', '42', '其他', null), ('7', 'zcj', '早餐券', '15', '48', '餐券', null), ('8', 'wcj', '晚餐劵', '20', '49', '餐券', null), ('9', 'wcj', '午餐劵', '20', '49', '餐券', null), ('10', 'sn', '桑拿', '150', '47', '客房服务', null), ('11', 'am', '按摩', '50', '50', '客房服务', null);
COMMIT;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '酒店ID',
  `rolename` varchar(255) DEFAULT NULL,
  `roledesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('0', '0', '系统用户', '系统用户，享有软件相关的所有权限'), ('1', '1', '注册用户', '1酒店注册用户，拥有属于此酒店的最高权限'), ('2', '2', '注册用户', '2酒店注册用户，拥有属于此酒店的最高权限'), ('3', '1', '酒店前台', '1酒店前台，接待中心');
COMMIT;

-- ----------------------------
--  Table structure for `role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resid` int(11) NOT NULL COMMENT '权限id',
  `roleid` int(11) NOT NULL COMMENT '角色id',
  `hid` int(11) NOT NULL COMMENT '酒店id',
  PRIMARY KEY (`id`),
  KEY `resid` (`resid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `resid` FOREIGN KEY (`resid`) REFERENCES `resource` (`id`),
  CONSTRAINT `rolid` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role_resource`
-- ----------------------------
BEGIN;
INSERT INTO `role_resource` VALUES ('54', '3', '2', '2'), ('55', '4', '2', '2'), ('56', '8', '2', '2'), ('57', '9', '2', '2'), ('58', '10', '2', '2'), ('59', '11', '2', '2'), ('60', '12', '2', '2'), ('61', '13', '2', '2'), ('62', '14', '2', '2'), ('63', '15', '2', '2'), ('64', '16', '2', '2'), ('65', '17', '2', '2'), ('66', '2', '2', '2');
COMMIT;

-- ----------------------------
--  Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '酒店ID',
  `roomnum` varchar(255) NOT NULL,
  `roomtype` int(11) DEFAULT NULL,
  `roompwd` varchar(255) DEFAULT NULL,
  `roomstate` int(255) DEFAULT '1' COMMENT '房间状态\r\n1空房;\r\n2预留;\r\n3打扫;\r\n4维修;\r\n5在住\r\n1只有：2,3,4\r\n5时只有：5\r\n\r\n',
  `tel` varchar(255) DEFAULT NULL COMMENT '房间电话',
  `floor` int(255) DEFAULT '1' COMMENT '所在楼层',
  `window` int(11) DEFAULT '1' COMMENT '1有窗0无',
  `hourday` int(11) DEFAULT '0' COMMENT '是否为钟点房1是0否',
  `relprice` double DEFAULT NULL COMMENT '实际价格',
  `starttime` varchar(255) DEFAULT NULL COMMENT '此时间之前可入住',
  `endtime` varchar(255) DEFAULT NULL COMMENT '次时间之后可入住',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `type` (`roomtype`),
  CONSTRAINT `type` FOREIGN KEY (`roomtype`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `room`
-- ----------------------------
BEGIN;
INSERT INTO `room` VALUES ('2', '1', 'BZ001', '2', 'BZ001', '1', '8802', '2', '1', '1', null, '2017-03-10 18:00:00', '2017-03-11 12:00:00', '124123'), ('3', '1', 'SD001', '3', 'SD001', '1', '8803', '3', '1', '0', null, '2017-01-07 18:00:00', '2017-01-08 12:00:00', '1234'), ('4', '1', 'SW001', '4', 'SW001', '1', '8804', '3', '1', '0', null, null, null, '1234'), ('5', '1', 'SD001', '3', 'SD001', '1', '8805', '2', '1', '0', null, null, null, '马桶漏水'), ('6', '1', 'HD001', '5', 'HD001', '1', '8806', '2', '1', '0', null, null, null, null), ('7', '1', 'HH001', '6', 'HH001', '1', '8807', '3', '1', '0', null, null, null, '1234'), ('8', '1', 'BD002', '1', 'BD002', '1', '8102', '1', '1', '0', null, '2017-03-16 18:00:00', '2017-03-17 12:00:00', '124123'), ('9', '1', 'BZ002', '2', 'BZ002', '1', '8103', '1', '1', '0', '90', '2017-01-07 18:00:00', '2017-01-08 12:00:00', '14123'), ('10', '1', 'HD002', '5', 'HD002', '1', '8104', '1', '1', '0', null, null, null, null), ('11', '1', 'HD003', '5', 'HD003', '1', '8105', '1', '1', '0', null, null, null, null), ('12', '1', 'HD004', '5', 'HD004', '1', '8106', '1', '1', '0', '10', null, null, null), ('13', '1', 'BZ005', '2', '1234', '1', '4563', '3', '1', '0', null, null, null, '41231'), ('15', '1', 'YC001', '7', '1234', '5', '1423', '3', '1', '0', null, null, null, '1234'), ('16', '1', 'YC002', '7', '1234', '2', '5545', '1', '1', '0', null, null, null, '1234'), ('17', '1', 'YC003', '7', '4587', '5', '7894', '1', '1', '0', '85', '2017-03-01 18:00:00', '2017-03-02 12:00:00', '123'), ('18', '1', 'YC004', '7', '4561', '1', '4561', '1', '1', '0', null, null, null, 'adasd'), ('19', '1', 'BZ003', '2', '4564', '1', '4561', '1', '1', '0', null, '', '', null), ('20', '1', 'BZ004', '2', '7894', '1', '1564', '1', '1', '0', null, null, null, null), ('21', '1', 'BZ008', '2', 'SADQ', '1', '1546', '1', '1', '0', null, null, null, null), ('22', '1', 'SW003', '4', '1234', '1', '1234', '1', '1', '0', null, '2017-03-30 18:00:00', '2017-03-31 12:00:00', null), ('23', '1', 'SW004', '4', '1234', '1', '1234', '1', '1', '0', null, '', '', null), ('24', '1', 'SW005', '4', '1234', '1', '1234', '1', '1', '0', null, null, null, null), ('25', '1', 'BD003', '1', '1234', '1', '1234', '1', '1', '0', null, '2017-01-07 18:00:00', '2017-01-08 12:00:00', '1234'), ('26', '1', 'HD005', '5', '1234', '1', '1234', '1', '1', '0', null, null, null, null), ('27', '1', 'HD006', '5', '1234', '1', '1234', '1', '1', '0', null, null, null, null), ('28', '1', 'HH005', '6', '1234', '1', '1234', '1', '1', '0', null, null, null, null), ('29', '1', 'HH006', '6', '1234', '1', '1234', '1', '1', '0', null, null, null, '124123'), ('30', '1', 'HH007', '6', '1234', '1', '1234', '1', '1', '1', null, null, null, null), ('31', '1', 'HH008', '6', '1234', '1', '1234', '1', '1', '0', '100', null, null, null), ('74', '1', 'BZ009', '2', '1234', '1', '1234', '1', '1', '0', null, null, null, null), ('75', '1', 'BZ010', '2', '[1234', '1', '8907', '1', '1', '0', null, null, null, null), ('76', '1', 'BZ011', '2', '[1234', '1', '7568', '1', '1', '0', null, null, null, null), ('77', '1', 'BZ012', '2', '1234', '1', '3456', '1', '1', '0', null, null, null, null), ('78', '1', 'BZ013', '2', '1234', '1', '4356', '1', '1', '0', null, null, null, null), ('79', '1', 'BZ014', '2', '1234', '1', '1234', '1', '1', '0', null, null, null, null), ('80', '1', 'BZ015', '2', '1234', '1', '4534', '1', '1', '0', null, null, null, null), ('81', '1', 'BZ016', '2', '1234', '1', '1234', '1', '1', '0', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `room_con_list`
-- ----------------------------
DROP TABLE IF EXISTS `room_con_list`;
CREATE TABLE `room_con_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(255) DEFAULT '' COMMENT '项目名称',
  `itemprice` double DEFAULT '0' COMMENT '项目价格',
  `amount` int(11) DEFAULT '1' COMMENT '消费数量',
  `paymethod` int(255) DEFAULT '6' COMMENT '支付方式（默认6入账；）',
  `totalprice` double DEFAULT '0' COMMENT '总价(默认：项目价格*消费数量)',
  `payprice` double DEFAULT '0' COMMENT '支付金额',
  `waiter` int(11) DEFAULT '0' COMMENT '服务员（默认0，不需要服务员）',
  `bookkeeper` varchar(255) DEFAULT '' COMMENT '操作员',
  `consumid` int(11) DEFAULT NULL,
  `bookitime` varchar(255) DEFAULT '' COMMENT '入账时间',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `paymethod` (`paymethod`),
  KEY `consumid` (`consumid`),
  CONSTRAINT `consumid` FOREIGN KEY (`consumid`) REFERENCES `consumption` (`id`),
  CONSTRAINT `FK_eebnc5uq249o7f2l8nc87i1td` FOREIGN KEY (`paymethod`) REFERENCES `paymethod` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `room_con_list`
-- ----------------------------
BEGIN;
INSERT INTO `room_con_list` VALUES ('20', '房费', '160', '1', '2', '160', '0', null, '系统', '44', '2017-01-06 01:06:42', ''), ('21', '入住押金', '0', '1', '1', '0', '1234', null, '系统', '44', '2017-01-06 01:06:42', null), ('22', '房费', '160', '1', '2', '160', '0', null, '系统', '44', '2017-01-06 03:06:44', ''), ('29', '泡面', '5', '1', '2', '5', '0', '0', 'recept', '44', '2017-01-06 04:05:46', ''), ('30', '哈根达斯', '50', '1', '2', '50', '0', '0', 'recept', '44', '2017-01-06 04:05:51', ''), ('31', '哈根达斯', '50', '1', '2', '50', '0', '0', 'recept', '44', '2017-01-06 04:05:55', ''), ('32', '哈根达斯', '50', '1', '2', '50', '0', '0', 'recept', '44', '2017-01-06 04:06:03', ''), ('33', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:06:06', ''), ('34', '午餐劵', '20', '1', '2', '20', '0', '0', 'recept', '44', '2017-01-06 04:06:08', ''), ('35', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:06:10', ''), ('36', '干拌面', '5', '1', '2', '5', '0', '0', 'recept', '44', '2017-01-06 04:18:43', ''), ('37', '哈根达斯', '50', '1', '2', '50', '0', '0', 'recept', '44', '2017-01-06 04:19:17', ''), ('38', '干拌面', '5', '1', '2', '5', '0', '0', 'recept', '44', '2017-01-06 04:19:19', ''), ('39', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:19:45', ''), ('40', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:19:47', ''), ('41', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:19:48', ''), ('42', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:19:50', ''), ('43', '香烟', '120', '1', '2', '120', '0', '0', 'recept', '44', '2017-01-06 04:19:52', ''), ('44', '储值卡支付', '10', '1', '4', '0', '10', '0', 'recept', '44', '2017-01-06 04:20:20', ''), ('45', '房费', '160', '1', '2', '160', '0', '0', '系统', '44', '2017-01-06 05:34:28', ''), ('46', '房费', '144', '1', '2', '144', '0', '0', '系统', '45', '2017-02-28 23:01:25', ''), ('47', '入住押金', '0', '1', '1', '0', '100', '0', '系统', '45', '2017-02-28 23:01:25', ''), ('48', '房费', '153', '1', '2', '153', '0', '0', '系统', '46', '2017-02-28 23:31:21', ''), ('49', '入住押金', '0', '1', '1', '0', '100', '0', '系统', '46', '2017-02-28 23:31:21', ''), ('50', '雪碧', '5', '1', '2', '5', '0', '0', 'recept', '46', '2017-02-28 23:33:19', ''), ('51', '干拌面', '5', '1', '2', '5', '0', '0', 'recept', '46', '2017-02-28 23:33:25', ''), ('52', '干拌面', '5', '1', '2', '5', '0', '0', 'recept', '46', '2017-02-28 23:33:28', ''), ('53', '早餐券', '15', '1', '2', '15', '0', '0', 'recept', '46', '2017-02-28 23:33:32', ''), ('54', '晚餐劵', '20', '1', '2', '20', '0', '0', 'recept', '46', '2017-02-28 23:33:35', ''), ('55', '桑拿', '150', '1', '2', '150', '0', '0', 'recept', '46', '2017-02-28 23:33:39', ''), ('56', '桑拿', '150', '1', '2', '150', '0', '0', 'recept', '46', '2017-02-28 23:33:42', ''), ('57', '桑拿', '150', '1', '2', '150', '0', '0', 'recept', '46', '2017-02-28 23:33:44', ''), ('62', '房费', '144', '1', '2', '144', '0', '0', '系统', '49', '2017-03-11 21:55:47', ''), ('63', '入住押金', '0', '1', '1', '0', '200', '0', '系统', '49', '2017-03-11 21:55:47', ''), ('64', '房费', '432', '1', '2', '432', '0', '0', '系统', '49', '2017-03-15 13:56:11', '整天，超(12,24)补房价432.0'), ('67', '房费', '144', '1', '2', '144', '0', '0', '系统', '51', '2017-03-20 09:17:02', ''), ('68', '入住押金', '0', '1', '1', '0', '200', '0', '系统', '51', '2017-03-20 09:17:02', ''), ('69', '房费', '144', '1', '2', '144', '0', '0', '系统', '53', '2017-03-29 09:25:54', ''), ('70', '入住押金', '0', '1', '1', '0', '100', '0', '系统', '53', '2017-03-29 09:25:55', ''), ('72', '房费', '1152', '1', '2', '1152', '0', '0', '系统', '51', '2017-03-29 09:31:28', '补房价1152.0'), ('73', '房费', '144', '1', '2', '144', '0', '0', '系统', '54', '2017-03-29 14:29:25', ''), ('74', '入住押金', '0', '1', '1', '0', '1000', '0', '系统', '54', '2017-03-29 14:29:25', ''), ('75', '房费', '153', '1', '2', '153', '0', '0', '系统', '55', '2017-03-29 15:00:03', ''), ('76', '入住押金', '0', '1', '1', '0', '100', '0', '系统', '55', '2017-03-29 15:00:03', ''), ('77', '房费', '44', '1', '2', '44', '0', '0', '系统', '56', '2017-03-29 15:06:30', ''), ('78', '入住押金', '0', '1', '1', '0', '10001', '0', '系统', '56', '2017-03-29 15:06:30', ''), ('79', '房费', '68', '1', '2', '68', '0', '0', '系统', '57', '2017-03-29 15:16:03', ''), ('80', '入住押金', '0', '1', '1', '0', '100', '0', '系统', '57', '2017-03-29 15:16:03', ''), ('81', '房费', '44', '1', '2', '44', '0', '0', '系统', '58', '2017-03-29 15:16:25', ''), ('82', '入住押金', '0', '1', '1', '0', '10001', '0', '系统', '58', '2017-03-29 15:16:25', ''), ('83', '房费', '68', '1', '2', '68', '0', '0', '系统', '59', '2017-03-29 21:26:25', ''), ('84', '入住押金', '0', '1', '1', '0', '1000', '0', '系统', '59', '2017-03-29 21:26:25', ''), ('85', '房费', '180', '1', '2', '180', '0', '0', '系统', '60', '2017-03-29 21:26:41', ''), ('86', '入住押金', '0', '1', '1', '0', '200', '0', '系统', '60', '2017-03-29 21:26:41', ''), ('87', '哈根达斯', '50', '1', '2', '50', '0', '0', 'hotel1', '54', '2017-03-29 21:27:11', ''), ('88', '香烟', '120', '1', '2', '120', '0', '0', 'hotel1', '54', '2017-03-29 21:27:14', ''), ('89', '早餐券', '15', '1', '2', '15', '0', '0', 'hotel1', '54', '2017-03-29 21:27:17', ''), ('90', '房费', '68', '1', '2', '68', '0', '0', '系统', '61', '2017-03-29 23:27:06', ''), ('91', '入住押金', '0', '1', '1', '0', '1000', '0', '系统', '61', '2017-03-29 23:27:06', ''), ('92', '房费', '180', '1', '2', '180', '0', '0', '系统', '62', '2017-03-29 23:34:46', ''), ('93', '入住押金', '0', '1', '1', '0', '100', '0', '系统', '62', '2017-03-29 23:34:46', '');
COMMIT;

-- ----------------------------
--  Table structure for `room_type`
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(255) NOT NULL COMMENT '酒店ID',
  `typename` varchar(255) DEFAULT '' COMMENT '房型名称',
  `typecode` varchar(255) DEFAULT '' COMMENT '房型代号',
  `roomprice` double DEFAULT NULL COMMENT '房价',
  `deposit` double DEFAULT NULL COMMENT '押金',
  `hourprice` double NOT NULL COMMENT '钟点房价',
  `sprice` int(11) NOT NULL DEFAULT '0' COMMENT '特价房是否有折扣（0否，1是）',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `room_type`
-- ----------------------------
BEGIN;
INSERT INTO `room_type` VALUES ('1', '1', '标准单人间', 'BD', '100', '150', '40', '0', null), ('2', '1', '标准间', 'BZ', '100', '150', '40', '0', null), ('3', '1', '商务单人间', 'SD', '150', '200', '50', '0', null), ('4', '1', '商务标准间', 'SW', '150', '200', '50', '0', null), ('5', '1', '豪华单人间', 'HD', '200', '250', '60', '0', null), ('6', '1', '豪华标准间', 'HH', '200', '250', '60', '0', null), ('7', '1', '圆床房', 'YC', '180', '180', '55', '0', '');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `usernum` varchar(255) DEFAULT '',
  `username` varchar(50) DEFAULT '',
  `password` varchar(50) DEFAULT '',
  `tel` varchar(255) DEFAULT '' COMMENT '手机号',
  `email` varchar(255) DEFAULT '' COMMENT '电子邮件',
  `sex` varchar(10) DEFAULT '',
  `age` int(10) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT '',
  `city` int(10) DEFAULT NULL,
  `salary` varchar(50) DEFAULT '',
  `starttime` varchar(100) DEFAULT '',
  `endtime` varchar(100) DEFAULT '',
  `description` varchar(500) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `city_id` (`city`),
  CONSTRAINT `city_id` FOREIGN KEY (`city`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '1', '10001', 'hotel1', '1234', '15206123630', '978079141@qq.com', '1', '23', '1995-08-01', '1', '4000.00', '2017-03-07', '2018-03-15', 'ADQW'), ('2', '2', '10002', 'admin', '1234', '15206123630', '978079141@qq.com', '1', '24', '1995-09-25', '1', '8000.00', '2017-03-15', '2017-03-21', '阿是错的AS'), ('3', '2', '10003', 'hotel2', '1234', '15206123630', '978079141@qq.com', '2', '23', '1995-09-25', '1', '8000.00', '2017-03-15', '2017-03-22', '阿斯顿发送到');
COMMIT;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `roleid` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_role`
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES ('2', '2', '1'), ('4', '3', '2'), ('5', '1', '3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
