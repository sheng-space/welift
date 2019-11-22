/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.21 : Database - welife_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`welife_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `welife_db`;

/*Table structure for table `app_module` */

DROP TABLE IF EXISTS `app_module`;

CREATE TABLE `app_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) DEFAULT '1' COMMENT '0：启用：1禁用',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '图标',
  `jump_type` int(1) DEFAULT NULL COMMENT '跳转类型:0内部小程序链接、1外部小程序、2:h5,3其他待扩展',
  `jump_url` varchar(200) DEFAULT NULL COMMENT '跳转地址',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(1) DEFAULT '0' COMMENT '0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `app_module` */

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `seq` int(2) DEFAULT NULL COMMENT '顺序',
  `img_url` varchar(200) DEFAULT NULL COMMENT 'Banner图url',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id:有值就跳转',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` int(1) DEFAULT '0' COMMENT '作废:0:正常 1：作废',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `banner` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `seq` int(4) DEFAULT NULL COMMENT '顺序',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(1) DEFAULT '0' COMMENT '删除:0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `category` */

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `collect` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `content` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `grade` double(18,2) DEFAULT NULL COMMENT '评论分数',
  `create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `deleted` int(1) DEFAULT '0' COMMENT '0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `comment` */

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `key_str` varchar(30) DEFAULT NULL COMMENT 'key',
  `val_str` varchar(200) DEFAULT NULL COMMENT 'value',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人:关联用户ID',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人:关联用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `update_time` datetime DEFAULT NULL COMMENT '作废0:正常 1：作废',
  `deleted` int(1) DEFAULT '0' COMMENT '作废0:正常 1：作废',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `config` */

/*Table structure for table `floor` */

DROP TABLE IF EXISTS `floor`;

CREATE TABLE `floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `style_type` int(1) DEFAULT NULL COMMENT '样式类型',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `seq` int(1) DEFAULT NULL COMMENT '顺序',
  `img_url` varchar(200) DEFAULT NULL COMMENT '图标',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(1) DEFAULT '0' COMMENT '作废:0:正常 1：作废',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `floor` */

/*Table structure for table `floor_detail` */

DROP TABLE IF EXISTS `floor_detail`;

CREATE TABLE `floor_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `floor_id` int(11) DEFAULT NULL COMMENT '楼层ID',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `floor_detail` */

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `min_value` int(4) DEFAULT NULL COMMENT '最低值',
  `max_value` int(4) DEFAULT NULL COMMENT '最大值',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(1) DEFAULT '0' COMMENT '删除:0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `grade` */

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `message_type` int(1) DEFAULT '0' COMMENT '类型',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `bs_id` int(11) DEFAULT NULL COMMENT '业务Id',
  `title` varchar(30) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) DEFAULT NULL COMMENT '消息内容',
  `status` int(1) DEFAULT '0' COMMENT '0未读、1已读',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `message` */

/*Table structure for table `message_template` */

DROP TABLE IF EXISTS `message_template`;

CREATE TABLE `message_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) DEFAULT '1' COMMENT '0:启用，1：禁用',
  `number` varchar(30) DEFAULT NULL COMMENT '编号不可重复',
  `name` varchar(30) DEFAULT NULL COMMENT '模板名称',
  `is_sys` int(1) DEFAULT NULL COMMENT '是否发送系统消息0:否，1：是',
  `title` varchar(30) DEFAULT NULL COMMENT '消息标题',
  `content` varchar(100) DEFAULT NULL COMMENT '消息内容',
  `is_applet` int(1) DEFAULT NULL COMMENT '是否发送小程序消息0未删除、1已删除',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '微信模板截图',
  `code` varchar(100) DEFAULT NULL COMMENT '模板id',
  `slogans` varchar(100) DEFAULT NULL COMMENT '标语',
  `url` varchar(100) DEFAULT NULL COMMENT '跳转链接/路径',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(11) DEFAULT '0' COMMENT '删除:0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `message_template` */

/*Table structure for table `message_template_ext` */

DROP TABLE IF EXISTS `message_template_ext`;

CREATE TABLE `message_template_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `message_id` int(11) DEFAULT NULL COMMENT '模板id',
  `color` varchar(30) DEFAULT NULL COMMENT '颜色',
  `keyword` varchar(30) DEFAULT NULL COMMENT '对应微信模板的keyword',
  `keyword_data` varchar(200) DEFAULT NULL COMMENT '对应微信模板的DATA',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `message_template_ext` */

/*Table structure for table `org` */

DROP TABLE IF EXISTS `org`;

CREATE TABLE `org` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `seq` int(1) DEFAULT NULL COMMENT '顺序',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(1) DEFAULT '0' COMMENT '0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `org` */

/*Table structure for table `praise` */

DROP TABLE IF EXISTS `praise`;

CREATE TABLE `praise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `praise` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `intro` varchar(200) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `ave_grade` double(18,2) DEFAULT '0.00' COMMENT '平均分',
  `praise_qty` int(4) DEFAULT '0' COMMENT '点赞人数',
  `browse_qty` int(4) DEFAULT '0' COMMENT '浏览人数',
  `collect_qty` int(4) DEFAULT '0' COMMENT '评论人数',
  `comment_qty` int(4) DEFAULT '0' COMMENT '评论人数',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_id` int(11) DEFAULT NULL COMMENT '审核人',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新人',
  `deleted` int(1) DEFAULT NULL COMMENT '0未删除、1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `product` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) DEFAULT '0' COMMENT '0：启用，1：禁用',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `gender` int(1) DEFAULT NULL COMMENT '性别:0未知、1男、2女',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '头像',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `open_id` varchar(30) DEFAULT NULL COMMENT '微信标识',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号码',
  `point` double(18,2) DEFAULT NULL COMMENT '总积分',
  `grade_id` int(11) DEFAULT NULL COMMENT '等级',
  `is_sys` int(1) DEFAULT NULL COMMENT '系统用户:0:不是，1：是',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `org_id` int(11) DEFAULT NULL COMMENT '组织id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人',
  `deleted` int(1) DEFAULT '0' COMMENT '作废:0:正常 1：作废',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
