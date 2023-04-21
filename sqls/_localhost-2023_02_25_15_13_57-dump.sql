-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: yigou
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '种类id，作为category表的主键',
  `name` varchar(30) DEFAULT NULL COMMENT '商品种类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品种类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1001,'手机'),(1002,'电视'),(1003,'家电'),(1004,'笔记本'),(1005,'平板'),(1006,'出行穿戴'),(1007,'耳机'),(1008,'音响'),(1009,'健身'),(1010,'生活'),(1011,'智能附属'),(1012,'配件');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `user_id` bigint DEFAULT NULL COMMENT '发出评论者',
  `foreign_id` bigint DEFAULT NULL COMMENT '外部订单id',
  `type` int DEFAULT NULL COMMENT '评论种类：1，购后评论；2，商品评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hot_model`
--

DROP TABLE IF EXISTS `hot_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hot_model` (
  `category_id` bigint NOT NULL COMMENT '种类id',
  `model_id` bigint NOT NULL COMMENT '机型型号id',
  PRIMARY KEY (`category_id`,`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='热门机型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hot_model`
--

LOCK TABLES `hot_model` WRITE;
/*!40000 ALTER TABLE `hot_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `hot_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `type` smallint DEFAULT NULL COMMENT '图片种类：1，轮播图；2，产品图；3，退货上传图；4，论坛配图',
  `foreign_id` bigint DEFAULT NULL COMMENT '外键，在其他表中作为主键',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `seq` int DEFAULT NULL COMMENT '图片顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,5,50000001,NULL,1);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_id` bigint DEFAULT NULL COMMENT '聊天室id',
  `user_id` bigint DEFAULT NULL COMMENT '发送者id',
  `content` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `seen` int DEFAULT NULL COMMENT '是否被阅读',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '消息创建时间，可用作消息的排序',
  `update_time` timestamp NULL DEFAULT NULL,
  `version` bigint DEFAULT NULL COMMENT '消息版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='与商家聊天的消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '机型id，用作主键',
  `category_id` bigint DEFAULT NULL COMMENT '种类id',
  `title` varchar(30) DEFAULT NULL COMMENT '机型名称，或者是页面标题',
  `advertisement` varchar(255) DEFAULT NULL COMMENT '广告',
  `cover_img_url` varchar(255) DEFAULT NULL COMMENT '封面图片地址',
  `seller_id` bigint DEFAULT NULL COMMENT '出售者的用户id，用来查询售卖者的信息',
  `config_main` varchar(60) DEFAULT NULL COMMENT '以此区分同种商品不同的主要配置（外观）',
  `config1` varchar(60) DEFAULT NULL COMMENT '五个电子设备的配置内容，如存储空间、内存、颜色、CPU/GPU、颜色',
  `config2` varchar(60) DEFAULT NULL COMMENT '电子设备配置2',
  `config3` varchar(60) DEFAULT NULL COMMENT '电子设备配置3',
  `config4` varchar(60) DEFAULT NULL COMMENT '电子设备配置4',
  `config5` varchar(60) DEFAULT NULL COMMENT '电子设备配置5',
  `star_cnt` int DEFAULT NULL COMMENT '被收藏数',
  `sell_cnt` int DEFAULT NULL COMMENT '售出数',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '商品创建时间戳',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '商品更新时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100012 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='机型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (100001,1001,'iPhone 14 Pro Max','灵动的 iPhone 新玩法，迎面而来。重大的安全新功能，为拯救生命而设计。创新的 4800 万像素主摄，让细节纤毫毕现。更有 iPhone 芯片中的速度之王，为一切提供强大原动力。','https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100001/cover.jpg',70260777,'颜色','容量','',NULL,NULL,NULL,999,250000,'2023-02-24 07:57:38','2023-02-24 07:57:42'),(100002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100003,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100005,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100006,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100007,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100008,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100010,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100011,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '具体产品的编号，用作主键',
  `category_id` bigint DEFAULT NULL COMMENT '种类id',
  `model_id` bigint DEFAULT NULL COMMENT '匹配机型的id，作外键',
  `price` double DEFAULT NULL COMMENT '价格',
  `description` varchar(255) DEFAULT NULL COMMENT '具体规格产品的介绍，可以是折扣、赠品',
  `seq` int DEFAULT NULL COMMENT '具体规格显示的序号',
  `config_main` varchar(30) DEFAULT NULL,
  `config1` varchar(30) DEFAULT NULL COMMENT '具体产品配置的内容，如：5G，128G，深空灰',
  `config2` varchar(30) DEFAULT NULL,
  `config3` varchar(30) DEFAULT NULL,
  `config4` varchar(30) DEFAULT NULL,
  `config5` varchar(30) DEFAULT NULL,
  `main_img_url` varchar(255) DEFAULT NULL COMMENT '主图，可以是img表中对应产品seq最小的',
  `gift` varchar(80) DEFAULT NULL COMMENT '赠品信息，如果null则表示没有赠品',
  `stack_cnt` int DEFAULT NULL,
  `sell_cnt` int DEFAULT NULL COMMENT '销售量',
  `on_sale` int DEFAULT NULL COMMENT '折扣数，如果是100则表示不打折，79则表示79%或者-21%',
  PRIMARY KEY (`id`),
  KEY `product_category_id_fk1` (`category_id`),
  KEY `product_model_id_fk` (`model_id`),
  CONSTRAINT `product_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_model_id_fk` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000017 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='具体产品，model的进一级划分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1000001,1001,100001,8999,'深空的黑色，藏着无尽的秘密',1,'深空黑色','128GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000002,1001,100001,8999,'低调高贵的银色，才能彰显出主人的气质',2,'银色','128GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000003,1001,100001,8999,'闪闪高贵的金色，衬托主人的品味',3,'金色','128GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000004,1001,100001,8999,'紫色，致命的性感，成熟的魅力',4,'暗紫色','128GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000005,1001,100001,9899,'深空的黑色，藏着无尽的秘密',1,'深空黑色','256GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000006,1001,100001,9899,'低调高贵的银色，才能彰显出主人的气质',2,'银色','256GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000007,1001,100001,9899,'闪闪高贵的金色，衬托主人的品味',3,'金色','256GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000008,1001,100001,9899,'紫色，致命的性感，成熟的魅力',4,'暗紫色','256GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000009,1001,100001,11699,'深空的黑色，藏着无尽的秘密',1,'深空黑色','512GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000010,1001,100001,11699,'低调高贵的银色，才能彰显出主人的气质',2,'银色','512GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000011,1001,100001,11699,'闪闪高贵的金色，衬托主人的品味',3,'金色','512GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000012,1001,100001,11699,'紫色，致命的性感，成熟的魅力',4,'暗紫色','512GB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000013,1001,100001,13499,'深空的黑色，藏着无尽的秘密',1,'深空黑色','1TB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000014,1001,100001,13499,'低调高贵的银色，才能彰显出主人的气质',2,'银色','1TB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000015,1001,100001,13499,'闪闪高贵的金色，衬托主人的品味',3,'金色','1TB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100),(1000016,1001,100001,13499,'紫色，致命的性感，成熟的魅力',4,'暗紫色','1TB',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `trade_id` bigint DEFAULT NULL COMMENT '订单id',
  `state` int DEFAULT NULL COMMENT '状态：1，申请，未同意；2，同意；3，已拒绝；4，客服介入；5，客服处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='退货表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '聊天室id',
  `room_name` varchar(60) DEFAULT NULL COMMENT '聊天室名称',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='聊天室';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '店铺的id',
  `user_id` bigint DEFAULT NULL COMMENT '所属者id',
  `shop_name` varchar(60) DEFAULT NULL COMMENT '店铺名',
  `property` int DEFAULT NULL COMMENT '注册资产',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='店铺表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,70260777,NULL,NULL);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `star`
--

DROP TABLE IF EXISTS `star`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `star` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `star_product_id_fk` (`product_id`),
  KEY `star_user_id_fk` (`user_id`),
  CONSTRAINT `star_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `star_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `star`
--

LOCK TABLES `star` WRITE;
/*!40000 ALTER TABLE `star` DISABLE KEYS */;
/*!40000 ALTER TABLE `star` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trade` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `seller_id` bigint DEFAULT NULL COMMENT '售卖者的用户id',
  `buyer_id` bigint DEFAULT NULL COMMENT '购买者的用户id',
  `product_id` bigint DEFAULT NULL COMMENT '具体产品id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间戳',
  `state` smallint DEFAULT NULL COMMENT '订单状态：1，下单，未付；2，已付，未收到；3，收到；4，退货中；5，交易完成；6，订单关闭',
  `version` bigint DEFAULT NULL COMMENT '乐观锁',
  `return_id` bigint DEFAULT NULL COMMENT '退货表单号',
  `comment_id` bigint DEFAULT NULL COMMENT '评论表单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='交易表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES (70000001,70260777,366602633,1000001,'2023-02-25 06:34:53','2023-02-27 06:34:55',5,3,NULL,NULL);
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户表的id主键，唯一标识每一个用户',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名，作为登录账号，不能为空，不能重复',
  `password` varchar(255) DEFAULT NULL COMMENT '用户账号的密码，储存加密之后的密码',
  `email` varchar(255) DEFAULT NULL COMMENT '用户的注册邮箱，不可更改，唯一',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `credit_score` int DEFAULT NULL COMMENT '信誉积分，满分100分',
  `cumulative_score` int DEFAULT NULL COMMENT '积分，没消费100元积1积分',
  `balance` double DEFAULT NULL COMMENT '账户余额',
  `isSeller` tinyint(1) DEFAULT NULL COMMENT '是否是商家',
  `shop_id` bigint DEFAULT NULL COMMENT '是否是商家，如果为null，则不是商家，否则记录对应商铺的id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新信息的时间',
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50000003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (50000001,'70260777','C0SRfcRFXB2ZIufE7c2KCw==','70260777@qq.com',NULL,100,0,999999,1,1,'2023-02-23 07:57:38','2023-02-24 07:57:38',1),(50000002,'366602633','C0SRfcRFXB2ZIufE7c2KCw==','366602633@qq.com',NULL,100,0,999999,0,NULL,'2023-02-23 07:57:38','2023-02-24 07:57:38',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_in_room`
--

DROP TABLE IF EXISTS `user_in_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_in_room` (
  `user_id` bigint NOT NULL COMMENT '用户id',
  `room_id` bigint NOT NULL COMMENT '聊天室id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '入群时间',
  PRIMARY KEY (`user_id`,`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_in_room`
--

LOCK TABLES `user_in_room` WRITE;
/*!40000 ALTER TABLE `user_in_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_in_room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-25 15:13:58
