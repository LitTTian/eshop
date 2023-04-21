-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eshop
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `aa_config`
--

DROP TABLE IF EXISTS `aa_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aa_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` bigint DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `value` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100017 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aa_config`
--

LOCK TABLES `aa_config` WRITE;
/*!40000 ALTER TABLE `aa_config` DISABLE KEYS */;
INSERT INTO `aa_config` VALUES (100001,1001,'颜色','黑色'),(100002,1001,'颜色','白色'),(100003,1001,'颜色','银色'),(100004,1001,'颜色','灰色'),(100005,1001,'颜色','蓝色'),(100006,1001,'颜色','黄色'),(100007,1001,'容量','128GB'),(100008,1001,'容量','256GB'),(100009,1001,'容量','512GB'),(100010,1001,'容量','1TB'),(100011,1001,'容量','2TB'),(100012,1004,'颜色',NULL),(100013,1004,'处理器',NULL),(100014,1004,'显卡',NULL),(100015,1004,'内存',NULL),(100016,1004,'固态',NULL);
/*!40000 ALTER TABLE `aa_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `abstracts` varchar(255) DEFAULT NULL,
  `content` text,
  `watches` int DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `version` int DEFAULT NULL,
  `type` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11000010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (11000001,70260777,1001,'当今手机的发展','随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。','随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。',1028,'2023-03-15 08:13:24','2023-04-20 09:37:51',32,1),(11000006,366602633,1007,'test','为什么airpods这么受欢迎','第3代AirPods，建议售价1,399元。\n\n年假一转眼就结束了，入手新玩具一起迎接开工肯定能大大消减不想上班的情绪！果粉们等了很久的第3代AirPods近日终于正式出货，如果你还没用过任何一款AirPods，或是上一代用户还在考虑要不要更新，以下这5个优点值得你赶快下单。\n\n外型小巧、配戴舒适\n乍看之下，第3代AirPods的充电盒与AirPods Pro外型极为相似，实际相比尺寸却小了一圈；若与前一代AirPods相比，第3代AirPods的耳机柄比之前短了33%，同时也从敲敲控制变成了如同AirPods Pro以耳机柄上的力度传感器操控的方式，更直觉易用。而针对耳机本体，如果你对降噪耳机的封闭性容易感到不适，第3代AirPods的开放式设计，应该可以让你感到恰恰好的舒适。\n\n续航时间更长，且支持MagSafe\n第3代AirPods充1次电后，享有最高达6小时的聆听音乐时间，且仅需在充电盒中快充5分钟，即可充入1小时电量，搭配充电盒使用，更可提供最高达30小时的总聆听时间，长时间工作使用也不用担心。这次充电盒也支持MagSafe无线充电功能，可与手边现有的iPhoneMagSafe充电器搭配使用，也可以通过其他Qi认证充电器进行充电。\n\n新增适应性等化功能\n第3代AirPods除了塞入了特制的驱动单元和高动态范围扩音器，更加入了之前仅见于AirPods Pro和AirPods Max的适应性等化功能，通过耳机内新增的内向式麦克风来接收耳中的声音，并通过音讯运算技术自动将中、低频声音实时调整，这个功能对开放式耳机设计来说很重要，是提供丰富、具一致性的聆听体验的关键。\n\n拥有空间音频、动态头部关注功能\n新款AirPods也具备了原本在AirPods Pro才有的空间音频以及动态头部关注功能，运用强大的H1芯片，不管是听音乐、看电影，还是群组FaceTime视频通话，微调左右耳个别收到的频率，让声音更具有真实的环绕感。更棒的是，这个功能除了支持苹果自家平台，也支持Netflix、Disney+等主流影音平台。\n\n支持「寻找」功能\n针对许多用户最担心的遗失问题，新款AirPods现在也支持「寻找」功能，你可以设定在离开iPhone蓝牙范围时立刻推送离身警示，或是远在天边近在眼前却又找不到的时候让AirPods播放警示音以利寻找。真的不知道丢到哪去了，也可以通过「寻找」App关注AirPods上次联机的位置，增加寻回设备的机会。\n\n该买第3代AirPods还是AirPods Pro？\n现在才想要入手AirPods，或是想要更新第2代的用户，肯定会在要买哪一款之间挣扎。第3代AirPods与AirPods Pro相比，最关键的差异就在「主动降噪功能」，虽然新款AirPods在耳机顶部、机身与耳机柄底部都加上声学网面，可于通话时降低风噪，通过物理与软件共同达成让通话更清晰的目标，但如果你经常在搭乘大众交通工具时使用、或是常有在线会议等需要阻绝外界声音干扰的需求，AirPods Pro会是更适合的选择。但如果你不喜欢耳塞配戴时的感觉，平常大部分是开车、没有太多需要降噪功能的使用情境，那其他功能几乎与AirPods Pro相同的第3代AirPods绝对是更容易入手的绝佳选择。',349,'2023-03-17 00:22:48','2023-04-20 10:01:54',349,1),(11000008,70260777,1001,'关于华为手机','华为手机真的好用','1、屏幕：屏幕尺寸6.5英寸，屏幕色彩1670万色，分辨率FHD+ 2376 × 1080 像素，看电影更加舒畅。\n2、相机：后置摄像头：超感知摄像头5000万像素+超广角摄像头1600万像素+长焦摄像头800万像素，支持自动对焦。前置摄像头：超感知摄像头1300万像素，支持固定焦距，拍照更加细腻，更加清晰。\n3、性能：采用EMUI 11.0（基于Android 10）系统，搭载麒麟9000E，八核处理器 ，带来高速、流畅的体验。\n4、电池：配备4200mAh（典型值）大容量电池，续航持久。\n5、芯片：麒麟9000E芯片采用先进的半导体制程，是当前技术工艺最领先的5纳米5G Soc 手机芯片，将处理器和5G基带融于一体，带来速度更快发热更低和能效比更强的运行表现，从容应对5G时代中复杂的计算，负载任务，使HUAWEI Mate 40 成为领先业界的5G 手机。\n6、特色功能：畅连大文件闪传、智感支付、灵动熄屏显示、AI 隔空操控、微电影、AI跟拍、AI 字幕、超级微距、双景录像、自拍慢动作、多屏协同、畅连通话、四网协同、智慧剪辑、智慧多窗、AI 信息保护、人脸解锁、智能截屏、小艺智慧语音、智慧视觉、情景智能、华为分享等等。\n可以登录迅购商城了解更多的手机参数，根据个人的喜好和需求选择。',6,'2023-03-17 00:43:11','2023-04-20 10:08:21',6,1),(11000009,70260777,1001,'关于华为手机','华为手机真的好用','1、屏幕：屏幕尺寸6.5英寸，屏幕色彩1670万色，分辨率FHD+ 2376 × 1080 像素，看电影更加舒畅。\n2、相机：后置摄像头：超感知摄像头5000万像素+超广角摄像头1600万像素+长焦摄像头800万像素，支持自动对焦。前置摄像头：超感知摄像头1300万像素，支持固定焦距，拍照更加细腻，更加清晰。\n3、性能：采用EMUI 11.0（基于Android 10）系统，搭载麒麟9000E，八核处理器 ，带来高速、流畅的体验。\n4、电池：配备4200mAh（典型值）大容量电池，续航持久。\n5、芯片：麒麟9000E芯片采用先进的半导体制程，是当前技术工艺最领先的5纳米5G Soc 手机芯片，将处理器和5G基带融于一体，带来速度更快发热更低和能效比更强的运行表现，从容应对5G时代中复杂的计算，负载任务，使HUAWEI Mate 40 成为领先业界的5G 手机。\n6、特色功能：畅连大文件闪传、智感支付、灵动熄屏显示、AI 隔空操控、微电影、AI跟拍、AI 字幕、超级微距、双景录像、自拍慢动作、多屏协同、畅连通话、四网协同、智慧剪辑、智慧多窗、AI 信息保护、人脸解锁、智能截屏、小艺智慧语音、智慧视觉、情景智能、华为分享等等。\n可以登录迅购商城了解更多的手机参数，根据个人的喜好和需求选择。',7,'2023-03-17 00:43:11','2023-04-19 08:32:40',7,1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment`
--

DROP TABLE IF EXISTS `article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `article_id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33000006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment`
--

LOCK TABLES `article_comment` WRITE;
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
INSERT INTO `article_comment` VALUES (33000001,70260777,11000006,'写的好啊','2023-03-12 07:42:25'),(33000002,70260777,11000006,'test','2023-03-19 05:13:57'),(33000003,70260777,11000006,'test2','2023-03-19 05:17:37'),(33000004,70260777,11000006,'test3','2023-03-19 05:19:21'),(33000005,70260777,11000001,'只会复制粘贴？？？','2023-03-20 17:52:05');
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment_child`
--

DROP TABLE IF EXISTS `article_comment_child`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_comment_child` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `article_id` bigint DEFAULT NULL,
  `main_comment_id` bigint DEFAULT NULL,
  `reply_comment_id` bigint DEFAULT NULL,
  `after_main` tinyint(1) DEFAULT NULL COMMENT '回复的是独立评论还是子评论',
  `content` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44000014 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment_child`
--

LOCK TABLES `article_comment_child` WRITE;
/*!40000 ALTER TABLE `article_comment_child` DISABLE KEYS */;
INSERT INTO `article_comment_child` VALUES (44000001,70260777,11000006,33000001,33000001,1,'真不错','2023-03-15 07:42:42'),(44000002,70260777,11000006,33000001,33000001,1,'是的','2023-03-18 09:41:52'),(44000003,70260777,11000006,33000002,33000002,1,'test111','2023-03-19 05:14:26'),(44000004,70260777,11000006,33000002,44000003,0,'test111','2023-03-19 05:16:22'),(44000005,70260777,11000006,33000002,44000004,0,'test222','2023-03-19 05:17:19'),(44000006,70260777,11000006,33000003,33000003,1,'test2_1','2023-03-19 05:19:06'),(44000007,70260777,11000006,33000003,33000003,1,'test2_2','2023-03-19 05:19:12'),(44000008,70260777,11000006,33000004,33000004,1,'test3_1','2023-03-19 05:26:42'),(44000009,70260777,11000006,33000004,33000004,1,'test3_2','2023-03-19 05:27:40'),(44000010,70260777,11000006,33000004,44000008,0,'test3_1_1','2023-03-19 05:27:50'),(44000011,70260777,11000001,33000005,33000005,1,'你再仔细看看，全文都是精华','2023-03-20 17:52:33'),(44000012,70260777,11000001,33000005,44000011,0,'111','2023-03-20 17:52:38'),(44000013,70260777,11000001,33000005,44000012,0,'2222','2023-03-20 17:52:57');
/*!40000 ALTER TABLE `article_comment_child` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_tag`
--

DROP TABLE IF EXISTS `article_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `article_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `seq` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77000009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_tag`
--

LOCK TABLES `article_tag` WRITE;
/*!40000 ALTER TABLE `article_tag` DISABLE KEYS */;
INSERT INTO `article_tag` VALUES (77000001,11000006,71000001,1),(77000002,11000006,71000002,1),(77000003,11000006,71000003,1),(77000004,11000006,71000004,1),(77000005,11000008,71000005,1),(77000006,11000008,71000006,2),(77000007,11000009,71000005,1),(77000008,11000009,71000006,2);
/*!40000 ALTER TABLE `article_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` smallint DEFAULT NULL,
  `foreign_id` int DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='轮播图表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (1,1,100001,'2023-02-28 07:05:42'),(2,1,100002,'2023-02-28 08:41:57'),(5,1,100015,'2023-02-28 09:19:31'),(6,1,100016,'2023-02-28 09:19:31'),(7,1,100012,'2023-02-28 09:19:31'),(8,1,100013,'2023-02-28 09:19:31'),(9,1,100014,'2023-02-28 09:19:31'),(10,1,100044,'2023-02-28 09:19:31'),(11,1,100050,'2023-02-28 09:19:31'),(12,1,100051,'2023-02-28 09:19:31');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '种类id，作为category表的主键',
  `name` varchar(30) DEFAULT NULL COMMENT '商品种类名称',
  `config1` varchar(60) DEFAULT NULL COMMENT '以此区分同种商品不同的主要配置（外观）',
  `config2` varchar(60) DEFAULT NULL,
  `config3` varchar(60) DEFAULT NULL,
  `config4` varchar(60) DEFAULT NULL,
  `config5` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品种类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1001,'手机','颜色','容量',NULL,NULL,NULL),(1002,'电视','颜色','尺寸',NULL,NULL,NULL),(1003,'家电','颜色',NULL,NULL,NULL,NULL),(1004,'笔记本','颜色','处理器','显卡','内存','固态'),(1005,'平板','颜色','存储',NULL,NULL,NULL),(1006,'出行穿戴','颜色',NULL,NULL,NULL,NULL),(1007,'耳机','颜色',NULL,NULL,NULL,NULL),(1008,'音响','颜色',NULL,NULL,NULL,NULL),(1009,'健身','颜色',NULL,NULL,NULL,NULL),(1010,'智能附属','颜色',NULL,NULL,NULL,NULL),(1011,'配件','颜色',NULL,NULL,NULL,NULL),(1012,'生活',NULL,NULL,NULL,NULL,NULL);
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
  `type` smallint DEFAULT NULL COMMENT '评论种类：1，购后评论；2，商品评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (70000001,NULL,NULL,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` bigint DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100019 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (100001,1001,'颜色'),(100002,1001,'容量'),(100003,1002,'颜色'),(100004,1002,'尺寸'),(100005,1003,'颜色'),(100006,1004,'颜色'),(100007,1004,'处理器'),(100008,1004,'显卡'),(100009,1004,'内存'),(100010,1004,'固态'),(100011,1005,'颜色'),(100012,1005,'存储'),(100013,1006,'颜色'),(100014,1007,'颜色'),(100015,1008,'颜色'),(100016,1009,'颜色'),(100017,1010,'颜色'),(100018,1011,'颜色');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
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
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,5,50000001,NULL,1,0),(43,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/bd7cf9497cae4802ac910ba9d7b36b10.png',2,0),(44,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/486019fc4148480a96a02452520ecb2c.png',3,0),(46,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b0297324d3704db6811f8350501de5e2.png',4,0),(47,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/da00cecf95fa45f19b0e5af44d693811.png',5,0),(48,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/308d72707e10483dad1367378a9ccfd0.png',2,0),(49,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png',1,0),(50,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/d009314bfcf64c3a90e5060ac0e0e41c.png',3,0),(51,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/38aaa9f8af184e72a3b5bcdce9e7cb52.png',4,0),(52,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f03ad9bb824a488aacf3723decb0c4c0.png',5,0),(53,1,100001,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100001/cover.jpg',1,0),(54,1,100002,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100002/cover.png',1,0),(55,1,100003,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100003/cover.png',1,0),(56,1,100004,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100004/cover.png',1,0),(57,1,100008,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100008/cover.png',1,0),(58,1,100009,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100009/cover.png',1,0),(59,1,100010,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100010/cover.png',1,0),(60,1,100012,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100012/cover.png',1,0),(61,1,100013,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100013/cover.png',1,0),(62,1,100014,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100014/cover.png',1,0),(63,1,100015,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100015/cover.png',1,0),(64,1,100016,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100016/cover.png',1,0),(66,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg',1,0),(67,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/6afca07bbf584a089cdc726c91fced18.jpg',2,0),(68,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e6c01742ab5a492baedbd4104d4abdd0.jpg',3,0),(69,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/cadf44c5a61e4f788ef4a2c52ba4384e.jpg',4,0),(70,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/6b51c3bd5bf84462a118d098350b94c2.jpg',5,0),(71,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ddfbf4e5e9f84aa984019107691f5c48.jpg',6,0),(72,1,100036,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/72f2e9f501d840d18c40b46df8238b8d.png',1,0),(73,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24b554aec0d4ad9bfdb2c27bebcbce2.jpg',1,0),(74,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/4dd33aa1a64f4da3a13e94decc4612c7.jpg',2,0),(75,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b28d48e967454379b3653c20c554aa99.jpg',3,0),(76,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/6efd6cc8806a4d45ac3d80d704b61128.jpg',4,0),(77,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/cddd550b9a8c40bfb673392a03f53493.png',1,0),(78,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/5bb939bd02ee44ba82e9b343b51367e7.png',2,0),(79,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/df315eb5be1d4d5f86a99ba6f1efedfd.png',3,0),(80,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/380b258c005645b799aed930303e1ac3.png',4,0),(81,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/c02be5cd71de421292e1742fb6e6bec4.png',2,0),(82,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f2e71e5dcd0f4f5ca32327a87e2ea22a.png',1,0),(83,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/7724b0712d6d4ebe88c41a4142470a65.png',3,0),(84,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e5503ad0914a472692195055ab96998c.png',4,0),(85,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/009798f648e944b28f4ce863f8a7fa04.png',5,0),(86,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2d297c484beb488db5b665d4327a5c52.png',6,0),(87,1,100040,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/4c88a6038bc942b697757991336c3cee.png',1,0),(88,1,100041,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/bc6136a7cc3d46b8b553ab68a0037c30.jpg',1,0),(89,1,100041,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/cca30103af854e4f87dffb8a3b071b60.png',2,0),(90,1,100041,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/47bc3126b12141ad93274ba3ef3ee298.png',3,0),(92,1,100043,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/a5e8be7a58504e35be71f63b3f7048c4.png',1,0),(93,1,100044,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/412da2873dc746e2a4d626be412cba95.png',1,0),(94,1,100044,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/c36822b8611d4f5393acd253c7bd28c6.png',2,0),(95,1,100044,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ec787a089510448ca55e65e6dc1a3a00.png',3,0),(96,1,100045,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/920f95b62a964c8194ea57c2486b8023.png',1,0),(97,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f816992785814dc994e0655caab9657d.jpg',1,0),(98,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/fc94094420a04223888d20bd2e200fa0.jpg',2,0),(99,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/4caa4c5b4a4c47fd9a50722c2739cb4d.jpg',3,0),(100,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/3a01e581dac348e4a7691b483c28ea2e.jpg',4,0),(101,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/de90cba39822423f921c6f6a5b6e841d.jpg',5,0),(102,1,100047,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ab590dc9eea449cdb82320a8d69b75c5.png',1,0),(103,1,100047,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/9295f9c5cf654626920b56134a9e2478.png',2,0),(104,1,100047,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/8e9cb241e9914090a36d54104139c358.png',3,0),(105,1,100048,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg',1,0),(106,1,100048,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/9f8bb69441db450ab75a6010394c57e0.jpg',2,0),(107,1,100048,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/00048c40a82b427a84f34a0b243dba69.jpg',3,0),(108,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/89ab24c0d8fb42d0a0f7b857799c48d5.jpg',1,0),(109,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/15b346f857d64e8b806aede7b21cb183.jpg',2,0),(110,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f4df92f3e63d413f964d7937a29eec18.jpg',3,0),(111,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f4ccd7e0e1d34e1499fb3b7fe9fda139.jpg',4,0),(112,1,100050,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/da8c0ff9301b4b909889f222b6ed8ec5.jpg',1,0),(113,1,100050,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/17df81393caa4bfb86b6c812af8aafc2.jpg',2,0),(114,1,100050,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/81332dae4767488eacd6f3c178e72a93.jpg',3,0),(115,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/161206dcab034a18b1986d29ad7a770b.jpg',1,0),(116,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/76392c3dc02743d1a7a732f4baf8e170.jpg',2,0),(117,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/922656ee9eda497ab76fc16d50670502.jpg',3,0),(118,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/919ffaa58c534d6f8f71e66f5bc31e84.jpg',4,0),(119,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/599f650b4887440da41e036c2f6b5a93.jpg',5,0),(120,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/baf4dc5d79984e33ad297978656461ea.jpg',6,0),(121,4,11000001,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/32a9ca793fc5441db3dec821c7c51426.jpg',1,0),(122,4,11000001,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e94ab812520e4f50abbd36aa58c7011d.jpg',2,0),(161,4,11000006,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/32a9ca793fc5441db3dec821c7c51426.jpg',1,1),(162,4,11000006,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e94ab812520e4f50abbd36aa58c7011d.jpg',2,1),(163,4,11000006,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ae3f9d61f15c484e9be6815a82a4f711.jpg',3,1),(178,1,100012,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/eb5b8bf3f261490b90c445a46f59892e.jpg',1,1),(179,1,100012,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/8ff4272788aa4ec78798c9273b823843.jpg',2,1),(180,1,100012,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/27cfdee6d3bb41d09d5ea20cf01dc0d5.jpg',3,1);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `foreign_id` bigint DEFAULT NULL,
  `type` smallint DEFAULT NULL,
  `is_like` tinyint DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55000045 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (55000014,70260777,33000001,2,1,'2023-03-15 08:32:40','2023-03-15 08:32:41',1),(55000016,70260777,44000001,3,1,'2023-03-15 08:32:40','2023-03-15 08:32:41',1),(55000019,70260777,44000010,3,1,'2023-03-19 05:28:04','2023-03-19 05:28:04',1),(55000020,70260777,44000009,3,1,'2023-03-19 05:28:05','2023-03-19 05:28:05',1),(55000021,70260777,44000008,3,1,'2023-03-19 05:28:05','2023-03-19 05:28:05',1),(55000022,70260777,33000003,2,1,'2023-03-19 05:28:07','2023-03-19 05:28:07',1),(55000035,70260777,11000008,1,1,'2023-03-19 07:19:05','2023-03-19 07:19:05',1),(55000036,70260777,11000006,1,1,'2023-03-19 07:19:07','2023-03-21 07:32:09',5),(55000037,70260777,33000005,2,1,'2023-03-20 17:58:58','2023-03-20 17:58:58',1),(55000044,70260777,11000001,1,1,'2023-03-21 07:35:41','2023-03-21 07:35:42',2);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `seq` int DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  `city` varchar(10) DEFAULT NULL COMMENT '市',
  `district` varchar(10) DEFAULT NULL,
  `street` varchar(10) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `label` varchar(10) DEFAULT NULL,
  `state` smallint DEFAULT NULL COMMENT '标志地址是否被移除：0表示移除，1表示正常使用。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (70000001,70260777,1,'李瑞之','18860966866','江苏','南京市','浦口区','盘城街道','南京信息工程大学','学校',1),(70000002,70260777,2,'lrz','18860966866','江苏','南京市','浦口区','盘城街道','南信大沁园','宿舍',1),(70000003,366602633,1,'李瑞之','18860966866','江苏','南京市','浦口区','盘城街道','南京信息工程大学','学校',1),(70000004,366602633,2,'lrz','18860966866','江苏','南京市','浦口区','盘城街道','南信大沁园','宿舍',1),(70000005,70260777,3,'123','18860966866','北京市','市辖区','东城区','东华门街道办事处','12333','11',1),(70000006,70260777,4,'1234','18860966866','北京市','市辖区','东城区','东华门街道办事处','12321','444',1),(70000007,70260777,5,'132123','18860966866','北京市','市辖区','西城区','西长安街街道办事处','11','2',0),(70000008,70260777,6,'1','18860966866','天津市','市辖区','和平区','小白楼街道','21','3',0);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
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
  `type` tinyint DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '消息创建时间，可用作消息的排序',
  `update_time` timestamp NULL DEFAULT NULL,
  `version` bigint DEFAULT NULL COMMENT '消息版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11000095 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='与商家聊天的消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (11000001,22000001,70260777,NULL,'2023-03-10 14:45:14','2023-03-10 14:45:18',1),(11000002,22000001,366602633,NULL,'2023-03-10 14:46:01','2023-03-10 14:46:02',1),(11000003,22000001,70260777,NULL,'2023-03-10 14:47:01','2023-03-10 14:47:01',1),(11000004,22000001,366602633,NULL,'2023-03-10 14:48:01','2023-03-10 14:48:01',1),(11000005,22000001,70260777,NULL,'2023-03-10 14:49:01','2023-03-10 14:49:01',1),(11000006,22000001,366602633,NULL,'2023-03-10 14:51:01','2023-03-10 14:51:01',1),(11000007,22000001,70260777,NULL,'2023-03-10 14:53:01','2023-03-10 14:53:01',1),(11000008,22000001,366602633,NULL,'2023-03-10 14:54:01','2023-03-10 14:54:01',1),(11000009,22000001,70260777,NULL,'2023-03-10 14:58:01','2023-03-10 14:58:01',1),(11000010,22000001,366602633,NULL,'2023-03-10 14:59:01','2023-03-10 14:59:01',1),(11000011,22000001,366602633,NULL,'2023-03-10 22:36:20','2023-03-10 22:36:20',0),(11000012,22000001,366602633,NULL,'2023-03-10 22:37:45','2023-03-10 22:37:45',0),(11000013,22000001,366602633,NULL,'2023-03-10 22:38:06','2023-03-10 22:38:06',0),(11000014,22000001,70260777,NULL,'2023-03-10 22:40:02','2023-03-10 22:40:02',0),(11000015,22000001,70260777,NULL,'2023-03-10 23:42:50','2023-03-10 23:42:50',0),(11000016,22000001,366602633,NULL,'2023-03-10 23:46:59','2023-03-10 23:46:59',0),(11000017,22000001,70260777,NULL,'2023-03-10 23:59:14','2023-03-10 23:59:14',0),(11000018,22000001,70260777,NULL,'2023-03-10 23:59:17','2023-03-10 23:59:17',0),(11000019,22000001,366602633,NULL,'2023-03-10 23:59:29','2023-03-10 23:59:29',0),(11000020,22000001,366602633,NULL,'2023-03-11 04:25:56','2023-03-11 04:25:56',0),(11000021,22000001,70260777,NULL,'2023-03-11 04:26:13','2023-03-11 04:26:13',0),(11000022,22000001,70260777,NULL,'2023-03-11 04:26:55','2023-03-11 04:26:55',0),(11000023,22000001,366602633,NULL,'2023-03-11 04:27:02','2023-03-11 04:27:02',0),(11000024,22000001,70260777,NULL,'2023-03-11 23:20:58','2023-03-11 23:20:58',0),(11000025,22000001,70260777,NULL,'2023-03-21 05:02:48','2023-03-21 05:02:48',0),(11000026,22000001,366602633,NULL,'2023-03-21 05:02:57','2023-03-21 05:02:57',0),(11000027,22000001,70260777,NULL,'2023-03-21 07:38:14','2023-03-21 07:38:14',0),(11000029,22000001,366602633,NULL,'2023-04-13 15:41:41','2023-04-13 15:41:41',0),(11000030,22000001,70260777,NULL,'2023-04-13 15:41:57','2023-04-13 15:41:57',0),(11000031,22000001,366602633,NULL,'2023-04-13 15:42:00','2023-04-13 15:42:00',0),(11000032,22000001,366602633,NULL,'2023-04-13 15:45:44','2023-04-13 15:45:44',0),(11000033,22000001,70260777,NULL,'2023-04-13 16:01:32','2023-04-13 16:01:32',0),(11000036,22000001,70260777,NULL,'2023-04-17 04:27:02','2023-04-17 04:27:02',0),(11000037,22000001,70260777,NULL,'2023-04-17 04:28:44','2023-04-17 04:28:44',0),(11000038,22000001,70260777,NULL,'2023-04-17 04:28:51','2023-04-17 04:28:51',0),(11000039,22000001,70260777,NULL,'2023-04-17 04:30:58','2023-04-17 04:30:58',0),(11000040,22000001,70260777,NULL,'2023-04-17 04:31:04','2023-04-17 04:31:04',0),(11000041,22000001,70260777,NULL,'2023-04-17 04:31:22','2023-04-17 04:31:22',0),(11000042,22000001,70260777,NULL,'2023-04-17 04:31:24','2023-04-17 04:31:24',0),(11000043,22000001,70260777,NULL,'2023-04-17 04:31:26','2023-04-17 04:31:26',0),(11000044,22000001,70260777,NULL,'2023-04-17 04:33:58','2023-04-17 04:33:58',0),(11000045,22000001,70260777,NULL,'2023-04-17 04:34:11','2023-04-17 04:34:11',0),(11000046,22000001,70260777,NULL,'2023-04-17 04:37:06','2023-04-17 04:37:06',0),(11000047,22000001,70260777,NULL,'2023-04-17 04:37:33','2023-04-17 04:37:33',0),(11000048,22000001,366602633,NULL,'2023-04-17 05:01:52','2023-04-17 05:01:52',0),(11000049,22000001,70260777,NULL,'2023-04-17 07:56:09','2023-04-17 07:56:09',0),(11000050,22000001,70260777,NULL,'2023-04-17 09:21:41','2023-04-17 09:21:41',0),(11000051,22000001,366602633,NULL,'2023-04-17 09:21:49','2023-04-17 09:21:49',0),(11000052,22000001,366602633,NULL,'2023-04-17 09:22:00','2023-04-17 09:22:00',0),(11000053,22000001,366602633,NULL,'2023-04-17 09:27:00','2023-04-17 09:27:00',0),(11000054,22000001,366602633,NULL,'2023-04-17 09:27:14','2023-04-17 09:27:14',0),(11000055,22000001,366602633,NULL,'2023-04-17 09:30:19','2023-04-17 09:30:19',0),(11000056,22000001,366602633,NULL,'2023-04-17 09:30:23','2023-04-17 09:30:23',0),(11000057,22000001,366602633,NULL,'2023-04-17 09:33:11','2023-04-17 09:33:11',0),(11000058,22000001,366602633,NULL,'2023-04-17 09:33:11','2023-04-17 09:33:11',0),(11000059,22000001,366602633,NULL,'2023-04-17 09:33:26','2023-04-17 09:33:26',0),(11000060,22000001,70260777,NULL,'2023-04-17 09:37:15','2023-04-17 09:37:15',0),(11000061,22000001,366602633,NULL,'2023-04-17 09:37:23','2023-04-17 09:37:23',0),(11000062,22000001,70260777,NULL,'2023-04-17 09:37:33','2023-04-17 09:37:33',0),(11000063,22000001,366602633,NULL,'2023-04-17 09:38:14','2023-04-17 09:38:14',0),(11000064,22000001,70260777,NULL,'2023-04-17 09:38:25','2023-04-17 09:38:25',0),(11000065,22000001,366602633,NULL,'2023-04-17 09:38:49','2023-04-17 09:38:49',0),(11000066,22000001,70260777,NULL,'2023-04-17 09:38:53','2023-04-17 09:38:53',0),(11000067,22000001,366602633,NULL,'2023-04-17 09:39:00','2023-04-17 09:39:00',0),(11000068,22000001,70260777,NULL,'2023-04-17 09:39:07','2023-04-17 09:39:07',0),(11000069,22000001,70260777,NULL,'2023-04-17 09:39:23','2023-04-17 09:39:23',0),(11000070,22000001,366602633,NULL,'2023-04-17 09:39:25','2023-04-17 09:39:25',0),(11000071,22000001,70260777,NULL,'2023-04-17 09:39:43','2023-04-17 09:39:43',0),(11000072,22000001,366602633,NULL,'2023-04-17 09:39:54','2023-04-17 09:39:54',0),(11000073,22000001,70260777,NULL,'2023-04-17 09:42:22','2023-04-17 09:42:22',0),(11000074,22000001,366602633,NULL,'2023-04-17 09:42:28','2023-04-17 09:42:28',0),(11000075,22000001,70260777,NULL,'2023-04-17 09:42:37','2023-04-17 09:42:37',0),(11000076,22000001,70260777,NULL,'2023-04-17 09:43:27','2023-04-17 09:43:27',0),(11000077,22000001,366602633,NULL,'2023-04-17 09:44:32','2023-04-17 09:44:32',0),(11000078,22000001,366602633,NULL,'2023-04-17 09:45:00','2023-04-17 09:45:00',0),(11000079,22000001,366602633,NULL,'2023-04-17 09:45:54','2023-04-17 09:45:54',0),(11000080,22000001,70260777,NULL,'2023-04-17 09:47:02','2023-04-17 09:47:02',0),(11000081,22000001,366602633,NULL,'2023-04-17 09:47:29','2023-04-17 09:47:29',0),(11000082,22000001,366602633,NULL,'2023-04-17 09:50:04','2023-04-17 09:50:04',0),(11000083,22000001,70260777,NULL,'2023-04-17 09:50:31','2023-04-17 09:50:31',0),(11000084,22000001,366602633,NULL,'2023-04-17 09:52:15','2023-04-17 09:52:15',0),(11000085,22000001,70260777,NULL,'2023-04-17 09:54:42','2023-04-17 09:54:42',0),(11000086,22000001,70260777,NULL,'2023-04-17 10:05:21','2023-04-17 10:05:21',0),(11000087,22000001,366602633,NULL,'2023-04-17 10:05:38','2023-04-17 10:05:38',0),(11000088,22000001,366602633,NULL,'2023-04-17 10:05:49','2023-04-17 10:05:49',0),(11000089,22000001,70260777,NULL,'2023-04-17 10:35:43','2023-04-17 10:35:43',0),(11000090,22000001,366602633,NULL,'2023-04-17 10:35:50','2023-04-17 10:35:50',0),(11000091,22000001,366602633,NULL,'2023-04-17 10:35:56','2023-04-17 10:35:56',0),(11000092,22000001,70260777,NULL,'2023-04-17 10:35:59','2023-04-17 10:35:59',0),(11000093,22000001,366602633,NULL,'2023-04-17 11:35:44','2023-04-17 11:35:44',0),(11000094,22000001,366602633,NULL,'2023-04-17 11:52:42','2023-04-17 11:52:42',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_content`
--

DROP TABLE IF EXISTS `message_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_content` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message_id` bigint DEFAULT NULL,
  `content1` bigint DEFAULT NULL,
  `content2` bigint DEFAULT NULL,
  `seq` int DEFAULT NULL COMMENT '标记加密后内容的顺序，查询和解密的时候按这个顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33000779 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='存储加密后的消息内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_content`
--

LOCK TABLES `message_content` WRITE;
/*!40000 ALTER TABLE `message_content` DISABLE KEYS */;
INSERT INTO `message_content` VALUES (33000001,11000001,186685337576,1644754232,0),(33000002,11000001,351977296158,96167261487,1),(33000003,11000002,231645608796,302366024579,0),(33000004,11000002,285580988671,29029147750,1),(33000005,11000002,48032614631,147591837845,2),(33000006,11000003,292505950890,52897395552,0),(33000007,11000003,155523397261,270520040633,1),(33000008,11000004,16243018423,34868422981,0),(33000009,11000004,99846100618,205704164764,1),(33000010,11000004,77078548062,264351309230,2),(33000011,11000005,217724785394,199196093997,0),(33000012,11000005,248874971023,240962267639,1),(33000013,11000006,93211693675,24941644365,0),(33000014,11000006,62721266661,182497255794,1),(33000015,11000006,223470355058,114959621860,2),(33000016,11000007,195609523612,107300031417,0),(33000017,11000007,269373387068,119602805432,1),(33000018,11000008,43342652659,273135503759,0),(33000019,11000008,71844593059,185145200857,1),(33000020,11000008,62192120511,41748281147,2),(33000021,11000009,320087777302,4055667270,0),(33000022,11000009,218637602278,174610765671,1),(33000023,11000010,129668981233,359398633972,0),(33000024,11000010,30934938646,326244446214,1),(33000025,11000010,226075812582,101146069469,2),(33000026,11000011,127725049370,117196317463,0),(33000027,11000011,93973065163,617758680,1),(33000028,11000011,119618628200,180921601803,2),(33000029,11000011,170755380331,23351839058,3),(33000030,11000012,266217807048,358816941895,0),(33000031,11000012,296406518966,20609014166,1),(33000032,11000013,127639750812,266433394872,0),(33000033,11000013,11615402759,307500920930,1),(33000034,11000013,120891708367,26325761221,2),(33000035,11000013,224034222526,268355324915,3),(33000036,11000013,148739663353,327351948462,4),(33000037,11000013,18922750258,269964408661,5),(33000038,11000014,253575822767,352707003279,0),(33000039,11000014,174927033790,339096193551,1),(33000040,11000014,213029472391,2190221285,2),(33000041,11000014,228528701249,142401530111,3),(33000042,11000014,237086827543,191094259110,4),(33000043,11000014,174158629161,124389713716,5),(33000044,11000014,121740762999,111650793411,6),(33000045,11000015,299649378226,117625202246,0),(33000046,11000015,57438716103,125982450320,1),(33000047,11000015,99464741230,56535866802,2),(33000048,11000015,189758042351,122746470683,3),(33000049,11000015,109105958429,301556172244,4),(33000050,11000015,189449810947,234685905442,5),(33000051,11000015,166676664450,318226813128,6),(33000052,11000015,265736910715,257742112666,7),(33000053,11000016,94733041499,196067925064,0),(33000054,11000017,228595278985,139839847066,0),(33000055,11000018,299892726986,254279470670,0),(33000056,11000019,264653393492,97443376104,0),(33000057,11000020,36509092200,351203243330,0),(33000058,11000020,322819654326,43541271128,1),(33000059,11000021,249049301746,32175518025,0),(33000060,11000022,96116866137,229064378528,0),(33000061,11000022,262734686707,358308600042,1),(33000062,11000022,281453912381,185144148270,2),(33000063,11000023,49495708164,8026188276,0),(33000064,11000023,206376534932,86519544689,1),(33000065,11000023,71463009599,291275420395,2),(33000066,11000024,232732511133,69204162883,0),(33000067,11000024,346301274833,192506582552,1),(33000068,11000024,99681023340,303318264641,2),(33000069,11000025,352131069480,316496010853,0),(33000070,11000026,57202507962,98317094919,0),(33000071,11000027,2398310984,39236510094,0),(33000072,11000027,2723619778,130952282587,1),(33000073,11000029,252324483544,240379485439,0),(33000074,11000029,113668294665,177888818102,1),(33000075,11000029,130289479175,263058111927,2),(33000076,11000030,81552335056,333065024384,0),(33000077,11000030,333044617578,196955410838,1),(33000078,11000030,96134175526,47573145667,2),(33000079,11000031,53543399054,219092311843,0),(33000080,11000031,16970791009,231646556145,1),(33000081,11000031,337672669899,365637954058,2),(33000082,11000032,95148788597,244067557173,0),(33000083,11000032,43056490640,132273235640,1),(33000084,11000032,205426562045,41986053809,2),(33000085,11000032,163076704845,134334371605,3),(33000086,11000032,322078361217,251671397574,4),(33000087,11000032,175366857265,301464889079,5),(33000088,11000032,194168270808,330665679369,6),(33000089,11000032,205388807839,57640065030,7),(33000090,11000032,177742885710,182006295241,8),(33000091,11000032,209110868389,56700823544,9),(33000092,11000032,319579074327,249618887972,10),(33000093,11000032,308615135744,198121186303,11),(33000094,11000032,198100742426,338692744556,12),(33000095,11000032,9247444516,20945795186,13),(33000096,11000032,202271799634,361218869608,14),(33000097,11000032,73931967869,352889253281,15),(33000098,11000032,69902930513,141945963362,16),(33000099,11000032,177530372745,149803556736,17),(33000100,11000032,188560558212,236542443892,18),(33000101,11000032,213397582906,106696791984,19),(33000102,11000032,341434274886,225631584307,20),(33000103,11000032,154365542021,210388064327,21),(33000104,11000032,365902396922,84201071263,22),(33000105,11000032,17048326018,166432065756,23),(33000106,11000032,206488335621,1050896489,24),(33000107,11000032,352271249861,361937971334,25),(33000108,11000032,77429419857,55537002429,26),(33000109,11000032,55151296008,274414560183,27),(33000110,11000032,280090353720,314943640320,28),(33000111,11000032,165765295606,318074555928,29),(33000112,11000032,333601885422,285527443869,30),(33000113,11000032,140575131936,87286040708,31),(33000114,11000032,86867924710,161568467106,32),(33000115,11000032,162417227909,68967765772,33),(33000116,11000032,302678316214,191156989502,34),(33000117,11000032,299271388093,197288229785,35),(33000118,11000032,23652150608,153254823158,36),(33000119,11000032,280405347081,246434799311,37),(33000120,11000032,173708408475,231080154730,38),(33000121,11000032,272947503291,207999467001,39),(33000122,11000032,262195996248,64455205915,40),(33000123,11000032,39450596154,60423543100,41),(33000124,11000032,278917646914,62112546683,42),(33000125,11000032,25364158043,317579607554,43),(33000126,11000032,303998076469,138672264751,44),(33000127,11000032,89602354923,108553710629,45),(33000128,11000032,235544024910,326743597095,46),(33000129,11000032,267513351687,343888165612,47),(33000130,11000032,27021789072,17548038347,48),(33000131,11000032,340155608234,172869665946,49),(33000132,11000032,164184012159,284560345169,50),(33000133,11000032,55877373949,329232473666,51),(33000134,11000032,191830242936,13961217753,52),(33000135,11000032,107046193532,68824230046,53),(33000136,11000032,115393588111,221564881349,54),(33000137,11000032,255272671246,131749565100,55),(33000138,11000032,211433082656,260680057124,56),(33000139,11000032,168926214188,142009245539,57),(33000140,11000032,223679465802,169897692877,58),(33000141,11000032,85726687074,209685882863,59),(33000142,11000032,15199656422,204247137046,60),(33000143,11000032,150007605444,136887992111,61),(33000144,11000032,64307522998,11435430026,62),(33000145,11000032,264127129899,354219815087,63),(33000146,11000032,60244279603,47455237081,64),(33000147,11000032,281811658975,353330381875,65),(33000148,11000032,180349487824,280456899549,66),(33000149,11000032,78052090878,28985578801,67),(33000150,11000032,349605285880,245712186342,68),(33000151,11000032,200973768391,212707352426,69),(33000152,11000032,336075657191,172556257436,70),(33000153,11000032,23326110722,42360803363,71),(33000154,11000032,339791720330,10661710717,72),(33000155,11000032,150340995834,166020557265,73),(33000156,11000032,278356883376,279857412164,74),(33000157,11000032,169816379739,43020071007,75),(33000158,11000032,207513229192,210668860657,76),(33000159,11000032,347459422224,304925235965,77),(33000160,11000032,163830561042,114797147933,78),(33000161,11000032,210064482620,292627281724,79),(33000162,11000032,2784285863,4865230467,80),(33000163,11000032,213997707647,88617012262,81),(33000164,11000032,182399929052,114320528059,82),(33000165,11000032,98220626580,300500821702,83),(33000166,11000032,348170691976,361472734629,84),(33000167,11000032,120242760584,29034686879,85),(33000168,11000032,231270721402,91253456722,86),(33000169,11000032,142261389234,330954485499,87),(33000170,11000032,109990770509,1811392569,88),(33000171,11000032,159860689340,278915983177,89),(33000172,11000032,335777080477,28310693255,90),(33000173,11000032,16547471667,338394709801,91),(33000174,11000032,203691917697,45136844247,92),(33000175,11000032,332666509445,323861941438,93),(33000176,11000032,329923094259,44861659117,94),(33000177,11000032,55068225032,353874932154,95),(33000178,11000032,49908277954,221105849906,96),(33000179,11000032,365434170321,28720361281,97),(33000180,11000032,166108849880,181803093920,98),(33000181,11000032,186450804401,288741041690,99),(33000182,11000032,244831089581,85553594846,100),(33000183,11000032,107791026832,299585313383,101),(33000184,11000032,216904182714,308425204338,102),(33000185,11000032,183254067238,158482675407,103),(33000186,11000032,199458722817,152347467183,104),(33000187,11000032,96531595904,227025800690,105),(33000188,11000032,335358110500,308526690566,106),(33000189,11000032,284407885742,356458364986,107),(33000190,11000032,355298429990,39817366772,108),(33000191,11000032,243042178501,81956156537,109),(33000192,11000032,197515671449,157739259202,110),(33000193,11000032,302210158380,135843224221,111),(33000194,11000032,308183142737,301519523388,112),(33000195,11000032,266571121261,177486351125,113),(33000196,11000032,92476040085,242373707717,114),(33000197,11000032,216259460106,126081952231,115),(33000198,11000032,357958713348,269595191748,116),(33000199,11000032,178317990814,280162153905,117),(33000200,11000032,60272951584,331753740010,118),(33000201,11000032,86506416754,259239303280,119),(33000202,11000032,357304488347,71673992084,120),(33000203,11000032,58567756575,96056715011,121),(33000204,11000032,75939972300,211562612461,122),(33000205,11000032,74897310136,225585929307,123),(33000206,11000032,56262371974,41117601174,124),(33000207,11000032,89739686451,146553171871,125),(33000208,11000032,301066083441,87113445102,126),(33000209,11000032,255057166652,121157576154,127),(33000210,11000032,55962446391,18005386498,128),(33000211,11000032,318273973189,277738318825,129),(33000212,11000032,45317035627,226533148895,130),(33000213,11000032,336621498670,269572614660,131),(33000214,11000032,360939567877,266465047053,132),(33000215,11000032,202251355911,261121647550,133),(33000216,11000032,48988453117,288190469281,134),(33000217,11000032,62235100302,283864088780,135),(33000218,11000032,265995443835,80663011199,136),(33000219,11000032,319422635185,267584442236,137),(33000220,11000032,226128736648,94653617468,138),(33000221,11000032,182830131704,240470126591,139),(33000222,11000032,68998468454,356914878852,140),(33000223,11000032,350626127320,343926396517,141),(33000224,11000032,55668938799,64326120668,142),(33000225,11000032,13431909183,179144296001,143),(33000226,11000032,307241227126,270481024364,144),(33000227,11000032,83743293105,357959911247,145),(33000228,11000032,35426467749,238930513381,146),(33000229,11000032,243033462015,319611794201,147),(33000230,11000032,129984382616,98614735949,148),(33000231,11000032,315820173896,137119587121,149),(33000232,11000032,175301485020,238121229477,150),(33000233,11000032,228873575576,134887661680,151),(33000234,11000032,323941600378,118683910949,152),(33000235,11000032,170960128698,137157083798,153),(33000236,11000032,79150415234,54596525215,154),(33000237,11000032,156910793580,110721994855,155),(33000238,11000032,353142138450,187282037768,156),(33000239,11000032,350985935384,183940657846,157),(33000240,11000032,11563260224,173083515139,158),(33000241,11000032,132932083431,160456619453,159),(33000242,11000032,209780230339,129572764817,160),(33000243,11000032,11597324856,215213133294,161),(33000244,11000032,291483964814,176684360122,162),(33000245,11000032,208154077365,269680805633,163),(33000246,11000032,83210295949,202425902368,164),(33000247,11000032,142261583318,324968265803,165),(33000248,11000032,174553508761,329002242046,166),(33000249,11000032,204261522279,108390203710,167),(33000250,11000032,245518157046,270507297515,168),(33000251,11000032,345695692829,142767004242,169),(33000252,11000032,363315218845,266290526819,170),(33000253,11000032,246620990742,308634014349,171),(33000254,11000032,91155614065,36523188214,172),(33000255,11000032,44764044908,270950079329,173),(33000256,11000032,178097464459,83754499616,174),(33000257,11000032,211909706404,305623025307,175),(33000258,11000032,17904011837,202496855786,176),(33000259,11000032,207505385716,24246956925,177),(33000260,11000032,92163587479,267264214317,178),(33000261,11000032,60806184291,286322377045,179),(33000262,11000032,264272881508,303703604587,180),(33000263,11000032,90977198797,59043186862,181),(33000264,11000032,289234219847,345557904819,182),(33000265,11000032,333951891736,282478784576,183),(33000266,11000032,129387471460,72130193125,184),(33000267,11000032,287510843481,352378773214,185),(33000268,11000032,20220969826,147449023346,186),(33000269,11000032,8746450080,137330485441,187),(33000270,11000032,16058706746,133763559445,188),(33000271,11000032,168926819081,105724506487,189),(33000272,11000032,62391210593,22517339419,190),(33000273,11000032,318766742696,331462712312,191),(33000274,11000032,41429540310,247125384016,192),(33000275,11000032,292699893660,40858193660,193),(33000276,11000032,159072931647,195243693672,194),(33000277,11000032,98104288075,141863874085,195),(33000278,11000032,352696353502,268966426706,196),(33000279,11000032,317923376132,83125980672,197),(33000280,11000032,22617688694,303504923731,198),(33000281,11000032,77076630364,204731828552,199),(33000282,11000032,160220978468,224589428483,200),(33000283,11000032,160211396721,234460325808,201),(33000284,11000032,122337768656,344345599700,202),(33000285,11000032,40659880614,280724521235,203),(33000286,11000032,252569967002,99917060454,204),(33000287,11000032,228905655947,113335430567,205),(33000288,11000032,239259221199,352841882719,206),(33000289,11000032,35107397772,221440496058,207),(33000290,11000032,54559978629,342542457475,208),(33000291,11000032,88701597501,168206304957,209),(33000292,11000032,355018647714,284065112404,210),(33000293,11000032,354059575139,264339333342,211),(33000294,11000032,134439092908,269008731246,212),(33000295,11000032,196284642124,62805113897,213),(33000296,11000032,142060483132,265123563684,214),(33000297,11000032,37796442687,47266139478,215),(33000298,11000032,129770378764,163286409755,216),(33000299,11000032,168392312867,12203894864,217),(33000300,11000032,171159781113,182345761989,218),(33000301,11000032,4900043598,64702544453,219),(33000302,11000032,252793606459,177880051722,220),(33000303,11000032,277138674357,359050350112,221),(33000304,11000032,258932666103,357791620603,222),(33000305,11000032,107000543251,245215553235,223),(33000306,11000032,116534133901,149429392210,224),(33000307,11000032,41495123389,365787089764,225),(33000308,11000032,311539885088,63314719759,226),(33000309,11000032,81270745440,157927121622,227),(33000310,11000032,162721171682,16330434184,228),(33000311,11000032,23032503569,61333630741,229),(33000312,11000032,127436186079,121852564078,230),(33000313,11000032,245221571275,271962891797,231),(33000314,11000032,107344548152,276888253312,232),(33000315,11000032,216567382311,26456539705,233),(33000316,11000032,129454970955,121006303333,234),(33000317,11000032,72253488548,24288534888,235),(33000318,11000032,220216469160,363976371849,236),(33000319,11000032,177097738009,166567561331,237),(33000320,11000032,324682706099,184091454192,238),(33000321,11000032,101601530793,337698255321,239),(33000322,11000032,119352507030,336802306625,240),(33000323,11000032,343118175676,305452930930,241),(33000324,11000032,277033447371,58036995898,242),(33000325,11000032,99393233121,146711608296,243),(33000326,11000032,54795025382,1497513347,244),(33000327,11000032,318226722376,167636957486,245),(33000328,11000032,360287799621,140473488298,246),(33000329,11000032,312050590233,176388780951,247),(33000330,11000032,135333233409,354769285409,248),(33000331,11000032,242992766732,183236001734,249),(33000332,11000032,297910428074,300791587836,250),(33000333,11000032,65787614178,353406634518,251),(33000334,11000032,212800617812,233419470279,252),(33000335,11000032,252613176938,76861439308,253),(33000336,11000032,354016738601,204944145155,254),(33000337,11000032,202325329925,48108569462,255),(33000338,11000032,66867770872,254116835747,256),(33000339,11000032,245378817820,25405355182,257),(33000340,11000032,362373619935,238510116950,258),(33000341,11000032,297122638765,346096499706,259),(33000342,11000032,272032298447,304864421503,260),(33000343,11000032,226331340649,218585705179,261),(33000344,11000032,24108702110,236740595105,262),(33000345,11000032,216067553660,61255251353,263),(33000346,11000032,62146017516,311189340271,264),(33000347,11000032,177301337918,137661734168,265),(33000348,11000032,134163656804,304961623408,266),(33000349,11000032,99772553561,46778902068,267),(33000350,11000032,43127104792,239535198084,268),(33000351,11000032,222456694830,112261067387,269),(33000352,11000032,288726120006,200498097758,270),(33000353,11000032,66140974124,328927857946,271),(33000354,11000032,11458103692,225669424736,272),(33000355,11000032,61217788741,105081334231,273),(33000356,11000032,58052856239,33105628387,274),(33000357,11000032,265760567318,235857877481,275),(33000358,11000032,319488644894,158585064959,276),(33000359,11000033,9238114168,95680580144,0),(33000360,11000033,198186439998,322443913215,1),(33000361,11000033,130466427198,15240117535,2),(33000362,11000033,215794684967,161981765918,3),(33000363,11000033,144134342947,175395600768,4),(33000364,11000033,227877477871,125302618340,5),(33000365,11000033,303086881184,319760880756,6),(33000366,11000033,193255875487,62985905133,7),(33000367,11000033,317340908010,254912340535,8),(33000368,11000033,341921325062,350412083240,9),(33000369,11000033,60281200392,138342096630,10),(33000370,11000033,285964663558,201013698009,11),(33000371,11000033,70585634408,165755855590,12),(33000372,11000033,85114089358,83604763724,13),(33000373,11000033,178271903397,49799130629,14),(33000374,11000033,348355143146,186247807468,15),(33000375,11000033,18456139215,178979409482,16),(33000376,11000033,22925347818,149126292506,17),(33000377,11000033,262660440809,275455292957,18),(33000378,11000033,196370764932,197599495806,19),(33000379,11000033,188991090689,225988402978,20),(33000380,11000033,58409432392,344764338998,21),(33000381,11000033,43388451727,247607161849,22),(33000382,11000033,223345639498,124032313385,23),(33000383,11000033,11727679235,175681649198,24),(33000384,11000033,326604416533,135498873422,25),(33000385,11000033,67050621563,135012203027,26),(33000386,11000033,89303685710,295974671906,27),(33000387,11000033,14719565706,96742960833,28),(33000388,11000033,222057803213,263497167944,29),(33000389,11000033,265283164135,9196959196,30),(33000390,11000033,103406954764,264216808960,31),(33000391,11000033,264208029802,224844778579,32),(33000392,11000033,166819805976,180771921546,33),(33000393,11000033,24225008587,279864707599,34),(33000394,11000033,296830853440,219532662293,35),(33000395,11000033,55532956614,178220803031,36),(33000396,11000033,300198542181,106800544742,37),(33000397,11000033,167150935907,351930561678,38),(33000398,11000033,129169832356,302638852662,39),(33000399,11000033,206618072336,76667545283,40),(33000400,11000033,63528976620,174380220593,41),(33000401,11000033,335818975834,275657309274,42),(33000402,11000033,275613145070,186691929331,43),(33000403,11000033,47759094499,95801660627,44),(33000404,11000033,38706763971,212519916031,45),(33000405,11000033,219871349325,102220884906,46),(33000406,11000033,103695064472,334106118586,47),(33000407,11000033,201473941590,353811123443,48),(33000408,11000033,31176640806,356143194236,49),(33000409,11000033,14405100829,335058656532,50),(33000410,11000033,179033090749,321554622234,51),(33000411,11000033,345670149949,201217203115,52),(33000412,11000033,6073880546,283318927675,53),(33000413,11000033,121383401579,234212824612,54),(33000414,11000033,282898877287,217670479095,55),(33000415,11000033,31204005653,176888511022,56),(33000416,11000033,106087868222,258177245130,57),(33000417,11000033,157898184410,31213833667,58),(33000418,11000033,241403207522,96363482300,59),(33000419,11000033,316586364300,359857437993,60),(33000420,11000033,218917881996,270574276578,61),(33000421,11000033,137347178768,313278506169,62),(33000422,11000033,127680324750,155471205537,63),(33000423,11000033,135459562429,207350329794,64),(33000424,11000033,170171042727,225066248445,65),(33000425,11000033,318851234942,126131598476,66),(33000426,11000033,87601706563,40060154178,67),(33000427,11000033,271317122536,109254913278,68),(33000428,11000033,39845229833,264019192877,69),(33000429,11000033,349428403995,169370652866,70),(33000430,11000033,99758595336,68100057013,71),(33000431,11000033,295242821897,294886613445,72),(33000432,11000033,172936877003,40567304094,73),(33000433,11000033,54483545238,207505872783,74),(33000434,11000033,83870278287,260302157434,75),(33000435,11000033,304663595789,298676389778,76),(33000436,11000033,287006078063,82646321503,77),(33000437,11000033,198752299377,270314518982,78),(33000438,11000033,361985256376,319132226409,79),(33000439,11000033,179217987685,120648314429,80),(33000440,11000033,271462586572,241710812983,81),(33000441,11000033,56623482881,15765280168,82),(33000442,11000033,144634099040,332686047463,83),(33000443,11000033,314036325443,277257814603,84),(33000444,11000033,18505864497,313491761143,85),(33000445,11000033,37259227283,304633651852,86),(33000446,11000033,23810430647,192159236852,87),(33000447,11000033,298265151210,288699816622,88),(33000448,11000033,180121797569,66758426062,89),(33000449,11000033,38237190956,95588986593,90),(33000450,11000033,246576095860,171820934206,91),(33000451,11000033,69470671209,230625518570,92),(33000452,11000033,203635671848,91620090738,93),(33000453,11000033,258004808503,14965488967,94),(33000454,11000033,1280776869,50525127981,95),(33000455,11000033,133550851795,209103653747,96),(33000456,11000033,281232566113,249738940511,97),(33000457,11000033,57120340942,163849880130,98),(33000458,11000033,338737786120,345851291559,99),(33000459,11000033,164224528915,158048616709,100),(33000460,11000033,144736541920,113598642993,101),(33000461,11000033,88165470504,362751575591,102),(33000462,11000033,339256888329,358272914458,103),(33000463,11000033,175131493565,184368550627,104),(33000464,11000033,132556110364,77390297240,105),(33000465,11000033,140247856505,342215798464,106),(33000466,11000033,96074806125,86593077957,107),(33000467,11000033,39823119712,111810950582,108),(33000468,11000033,203860332417,168949071762,109),(33000469,11000033,146255992584,253920445619,110),(33000470,11000033,238208847083,331330061000,111),(33000471,11000033,271565766300,203056969425,112),(33000472,11000033,124000527109,334831237736,113),(33000473,11000033,63083763967,127490266024,114),(33000474,11000033,35057101617,36942902397,115),(33000475,11000033,4583211486,77938476409,116),(33000476,11000033,146155148572,345975136959,117),(33000477,11000033,207896104430,26201671968,118),(33000478,11000033,273872202075,86498414012,119),(33000479,11000033,168121066081,307758354023,120),(33000480,11000033,154533862242,68434880404,121),(33000481,11000033,175937614851,81298679362,122),(33000482,11000033,293744766238,71721576623,123),(33000483,11000033,5568437967,197278791531,124),(33000484,11000033,213076258902,244751489776,125),(33000485,11000033,92757115531,165327108159,126),(33000486,11000033,274298704767,16401951890,127),(33000487,11000033,218738020783,133130654389,128),(33000488,11000033,337775374154,283992796217,129),(33000489,11000033,34817402823,148620731658,130),(33000490,11000033,140782730288,101534157257,131),(33000491,11000033,5484564897,138568297788,132),(33000492,11000033,336576685900,337581441520,133),(33000493,11000033,354054658000,209709376709,134),(33000494,11000033,299971911272,130840857571,135),(33000495,11000033,340050105250,336004056094,136),(33000496,11000033,359107244071,17839686169,137),(33000497,11000033,50981139294,180884026418,138),(33000498,11000033,345497373983,176086992621,139),(33000499,11000033,139745946544,26153292323,140),(33000500,11000033,4162072585,365680719312,141),(33000501,11000033,307197050876,145570287431,142),(33000502,11000033,160594436102,318848009780,143),(33000503,11000033,266128038880,349401531811,144),(33000504,11000033,23092613297,316231110766,145),(33000505,11000033,286143310635,21556486632,146),(33000506,11000033,289775407108,234075046954,147),(33000507,11000033,221009541027,102012152505,148),(33000508,11000033,196238396561,147658270441,149),(33000509,11000033,197283205584,118330285037,150),(33000510,11000033,180088840436,340309391206,151),(33000511,11000033,176193229055,318121444374,152),(33000512,11000033,330611387668,88937300597,153),(33000513,11000033,302901979565,293739750174,154),(33000514,11000033,179132851795,176092342513,155),(33000515,11000033,265889635544,360359029804,156),(33000516,11000033,107095533554,235841829634,157),(33000517,11000033,140670061884,104363401291,158),(33000518,11000033,352429951050,169863632610,159),(33000519,11000033,252607846620,253528248903,160),(33000520,11000033,155353237463,291440133702,161),(33000521,11000033,300990351601,293094533316,162),(33000522,11000033,347075762527,329863587117,163),(33000523,11000033,128627838998,80691688827,164),(33000524,11000033,326536957534,90951869858,165),(33000525,11000033,352219317328,63048545664,166),(33000526,11000033,248983923005,198528229556,167),(33000527,11000033,5079424946,362256921414,168),(33000528,11000033,37024531243,138371914885,169),(33000529,11000033,196690366621,260726359357,170),(33000530,11000033,271152812371,59817184112,171),(33000531,11000033,225247151458,251051538170,172),(33000532,11000033,251590930836,317402117576,173),(33000533,11000033,120546152385,14746064794,174),(33000534,11000033,40364218713,308982129868,175),(33000535,11000033,86254929292,139108375887,176),(33000536,11000033,327072755551,106982556898,177),(33000537,11000033,254728103460,311287585939,178),(33000538,11000033,51130651343,213653904518,179),(33000539,11000033,103900189868,315279149820,180),(33000540,11000033,234941243424,74830789946,181),(33000541,11000033,70318516790,80304913476,182),(33000542,11000033,182913768083,278759211692,183),(33000543,11000033,132594013330,269515594082,184),(33000544,11000033,101152886422,258149674049,185),(33000545,11000033,198133235739,127418804600,186),(33000546,11000033,290182164459,356845014391,187),(33000547,11000033,92111000687,108156458907,188),(33000548,11000033,63879129232,116380403663,189),(33000549,11000033,41437168776,240021098168,190),(33000550,11000033,206351094212,317926180816,191),(33000551,11000033,142638857098,332413205320,192),(33000552,11000033,99439949667,89521313753,193),(33000553,11000033,317250104911,70260423791,194),(33000554,11000033,284795916581,146962032735,195),(33000555,11000033,177698275833,38429467448,196),(33000556,11000033,315967632632,337558207726,197),(33000557,11000033,229871578958,313604006335,198),(33000558,11000033,159491940383,239439690175,199),(33000559,11000033,217150337661,31374501639,200),(33000560,11000033,205778998592,310199397289,201),(33000561,11000033,289365250612,308061689726,202),(33000562,11000033,275011578059,240627175615,203),(33000563,11000033,231327355361,52637983235,204),(33000564,11000033,308066157006,72549910523,205),(33000565,11000033,222984124175,171635261623,206),(33000566,11000033,60171672975,179095267996,207),(33000567,11000033,159853807950,45198450475,208),(33000568,11000033,288568409046,326499892054,209),(33000569,11000033,79184032933,345820748138,210),(33000570,11000033,320167046452,327339295027,211),(33000571,11000033,272358870360,74411176740,212),(33000572,11000033,235904530678,245456326553,213),(33000573,11000033,191396815408,285081980196,214),(33000574,11000033,193824545206,79684020002,215),(33000575,11000033,26426175894,13304028535,216),(33000576,11000033,331297359438,334293921291,217),(33000577,11000033,297867347310,274597122868,218),(33000578,11000033,38316094719,190748152780,219),(33000579,11000033,165451773818,360621542963,220),(33000580,11000033,105047577739,56044920915,221),(33000581,11000033,44627936330,245338591847,222),(33000582,11000033,215363980724,28344630972,223),(33000583,11000033,164739429453,276922049498,224),(33000584,11000033,205231100481,234108964806,225),(33000585,11000033,47765267321,146886665623,226),(33000586,11000033,116404286624,30535668507,227),(33000587,11000033,302422886815,11017699606,228),(33000588,11000033,317715107555,97201172396,229),(33000589,11000033,67207612115,59221460473,230),(33000590,11000033,136346437207,143620468014,231),(33000591,11000033,211072662244,166971414134,232),(33000592,11000033,251864381497,316561606786,233),(33000593,11000033,355527504571,286965191245,234),(33000594,11000033,304367900947,18311572001,235),(33000595,11000033,234558867905,358433509314,236),(33000596,11000033,304464258110,278783090854,237),(33000597,11000033,82938985698,275130677380,238),(33000598,11000033,1975523208,266915281508,239),(33000599,11000033,260246100477,112091210652,240),(33000600,11000033,210547117928,355921764291,241),(33000601,11000033,263194427832,254702152639,242),(33000602,11000033,175869423907,278060955341,243),(33000603,11000033,239107583257,17014932773,244),(33000604,11000033,49660426674,150366257756,245),(33000605,11000033,134511580748,315610843801,246),(33000606,11000033,128443440830,161487088318,247),(33000607,11000033,187264165403,231696282685,248),(33000608,11000033,101703132425,213422469817,249),(33000609,11000033,350346065210,49818320478,250),(33000610,11000033,359293245631,22680562693,251),(33000611,11000033,50038702721,262502463932,252),(33000612,11000033,162752384308,14270919201,253),(33000613,11000033,274845274101,364794373295,254),(33000614,11000033,96482709545,163452129450,255),(33000615,11000033,54462351294,109475055251,256),(33000616,11000033,48684563285,330997109099,257),(33000617,11000033,37341730517,5940931277,258),(33000618,11000033,25572244412,175835900600,259),(33000619,11000033,287849149397,96850550812,260),(33000620,11000033,192134081114,257779842759,261),(33000621,11000033,175246691193,70266242509,262),(33000622,11000033,115539476863,124595874910,263),(33000623,11000033,106251825658,39598935339,264),(33000624,11000033,189399629973,12073818459,265),(33000625,11000033,341384057231,28926991302,266),(33000626,11000033,150796069444,6732652386,267),(33000627,11000033,314504088029,40196400192,268),(33000628,11000033,66064886207,21487427749,269),(33000629,11000033,50899753224,176886869951,270),(33000630,11000033,215576451101,299228156101,271),(33000631,11000033,338371638353,50091540096,272),(33000632,11000033,202937001806,190790395498,273),(33000633,11000033,241931355564,362368710648,274),(33000634,11000033,324728123204,238772231104,275),(33000635,11000033,91763353116,257057376065,276),(33000636,11000036,49351985774,347374183215,0),(33000637,11000037,251637118866,361838980190,0),(33000638,11000038,59741945513,323712010733,0),(33000639,11000039,236070801190,20507647788,0),(33000640,11000040,342051709820,107416039896,0),(33000641,11000041,353124783065,21188384266,0),(33000642,11000042,1838024863,245585254569,0),(33000643,11000043,260227621841,206122923186,0),(33000644,11000044,271084942021,341868593030,0),(33000645,11000044,162538377403,233022975819,1),(33000646,11000045,155370318307,191733399848,0),(33000647,11000045,183129490477,295916904315,1),(33000648,11000046,8315810322,105239762244,0),(33000649,11000046,356188500018,121847412242,1),(33000650,11000047,174487801866,175224143802,0),(33000651,11000047,67423702048,102308039821,1),(33000652,11000047,33017034768,330492685923,2),(33000653,11000047,10573235181,57942063487,3),(33000654,11000047,42107401780,175715098708,4),(33000655,11000047,346655360339,101691519796,5),(33000656,11000048,353515276079,73743803440,0),(33000657,11000048,283672557791,272277155737,1),(33000658,11000048,356337147878,29130781433,2),(33000659,11000049,170811238991,192108861322,0),(33000660,11000050,157535485623,293301955924,0),(33000661,11000050,18903047669,268148751588,1),(33000662,11000050,13754042824,128036528951,2),(33000663,11000050,110970817253,213951813634,3),(33000664,11000051,355757042651,33046381338,0),(33000665,11000051,146753323350,322596667487,1),(33000666,11000051,67532759179,202203887621,2),(33000667,11000052,4107271999,3130450204,0),(33000668,11000052,248980586891,145031221446,1),(33000669,11000052,266282843411,18868712032,2),(33000670,11000053,186514395774,131703426490,0),(33000671,11000053,123855772125,212696002228,1),(33000672,11000053,336326537255,35524810029,2),(33000673,11000054,163834427777,196265242813,0),(33000674,11000054,186869891680,188095357989,1),(33000675,11000054,148919081649,274366166160,2),(33000676,11000055,289823577644,131821183448,0),(33000677,11000055,260993471603,120796736233,1),(33000678,11000055,144398666045,11442732190,2),(33000679,11000056,8790192959,347614377389,0),(33000680,11000056,14842278022,289134765799,1),(33000681,11000057,140282635928,135406465753,0),(33000682,11000057,304290831316,293300186851,1),(33000683,11000058,78351047569,147715680978,0),(33000684,11000059,188222574665,353903830544,0),(33000685,11000059,275986600094,47688083109,1),(33000686,11000060,225103708991,302678434644,0),(33000687,11000060,135565663299,155275972227,1),(33000688,11000061,314648228600,187564969309,0),(33000689,11000061,5127511930,37045091400,1),(33000690,11000062,322869514471,329511111612,0),(33000691,11000063,152234466594,287951637542,0),(33000692,11000063,241899242659,313961705845,1),(33000693,11000064,196324091737,119043930434,0),(33000694,11000064,318288053073,260184506479,1),(33000695,11000064,348358535151,19555197423,2),(33000696,11000065,346008823967,283292493117,0),(33000697,11000065,242653474706,51100609695,1),(33000698,11000066,307034896916,13828434459,0),(33000699,11000066,303426064139,12056573897,1),(33000700,11000067,139668096033,46694114599,0),(33000701,11000067,61800716388,7680011585,1),(33000702,11000068,83864511181,283987379895,0),(33000703,11000068,110828198777,240738892654,1),(33000704,11000069,341001455566,190696439388,0),(33000705,11000069,70333986878,314339283602,1),(33000706,11000070,152126461286,88514115467,0),(33000707,11000070,122728596875,26484148479,1),(33000708,11000070,292864118575,293090268072,2),(33000709,11000071,64366609497,237569744562,0),(33000710,11000071,134530440505,273100340906,1),(33000711,11000071,18924689654,93016569973,2),(33000712,11000071,283427033061,115242223163,3),(33000713,11000071,260098839831,52159468289,4),(33000714,11000072,331977366127,272884099709,0),(33000715,11000072,226651159841,103673768216,1),(33000716,11000072,63203624447,101602660668,2),(33000717,11000072,6268295300,351515932440,3),(33000718,11000073,123933324205,7079775359,0),(33000719,11000073,119548077779,301876542510,1),(33000720,11000073,191902730188,36195632135,2),(33000721,11000073,346495161560,49578018096,3),(33000722,11000074,340451539168,12597868904,0),(33000723,11000074,30551314543,316654220338,1),(33000724,11000074,183321393489,204134235278,2),(33000725,11000075,318252062375,331506995913,0),(33000726,11000075,340061116528,196464454846,1),(33000727,11000075,340575211738,31675847957,2),(33000728,11000075,106810305550,40646170481,3),(33000729,11000075,90185426371,108783065132,4),(33000730,11000076,176207655734,49253548813,0),(33000731,11000076,224994841883,293577898435,1),(33000732,11000077,103318732484,149499691438,0),(33000733,11000077,220249700113,183083864568,1),(33000734,11000078,339034666396,172833210193,0),(33000735,11000078,279488907971,40913901961,1),(33000736,11000079,203869805486,57487411108,0),(33000737,11000079,48005272290,18657410833,1),(33000738,11000080,276756300909,40344391662,0),(33000739,11000080,342376070347,132984905090,1),(33000740,11000080,76638158531,141806779125,2),(33000741,11000081,334736348019,113519735536,0),(33000742,11000081,333846986961,329395606574,1),(33000743,11000082,39418794451,328032536703,0),(33000744,11000082,24421185520,255333996889,1),(33000745,11000083,239931283192,147599408383,0),(33000746,11000083,137276004052,247204559002,1),(33000747,11000084,5822829290,4091532353,0),(33000748,11000084,143331343383,3231083965,1),(33000749,11000084,250775576282,354843959629,2),(33000750,11000084,39264138469,60571860084,3),(33000751,11000085,178257490801,338320931059,0),(33000752,11000085,271536650431,324130636845,1),(33000753,11000086,211923038076,300798664301,0),(33000754,11000086,43909300908,245793109027,1),(33000755,11000087,111593017768,59287903717,0),(33000756,11000087,131786367520,324747756918,1),(33000757,11000088,280350296277,702573543,0),(33000758,11000088,67046261518,231419039752,1),(33000759,11000088,93838920196,326771631707,2),(33000760,11000088,313862150101,152474047244,3),(33000761,11000089,98425415006,5137567958,0),(33000762,11000089,133914560263,113096919659,1),(33000763,11000089,29324583065,21703303626,2),(33000764,11000090,32204660849,302983437623,0),(33000765,11000090,18403609641,78613410969,1),(33000766,11000091,348176182502,59973392917,0),(33000767,11000091,277380597005,86616606027,1),(33000768,11000091,353573550614,40187049080,2),(33000769,11000091,278247613798,357468923748,3),(33000770,11000091,116844627974,79895211255,4),(33000771,11000091,230607208776,226173557027,5),(33000772,11000091,6703732995,101951694124,6),(33000773,11000092,230376427013,26198572920,0),(33000774,11000092,350458371447,144679655977,1),(33000775,11000093,221447407932,232178567849,0),(33000776,11000093,134099608816,66557032521,1),(33000777,11000094,133063456282,177289559449,0),(33000778,11000094,285088103006,164367505021,1);
/*!40000 ALTER TABLE `message_content` ENABLE KEYS */;
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
  `seller_id` bigint DEFAULT NULL COMMENT '出售者的用户id，用来查询售卖者的信息',
  `star_count` int DEFAULT NULL COMMENT '被收藏数',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '商品创建时间戳',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '商品更新时间戳',
  `version` int DEFAULT NULL,
  `deleted` tinyint DEFAULT NULL COMMENT '如果是1表示被移除',
  PRIMARY KEY (`id`),
  KEY `model_user_id_fk` (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100061 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='机型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (100001,1001,'iPhone 14 Pro Max','灵动的 iPhone 新玩法，迎面而来。重大的安全新功能，为拯救生命而设计。创新的 4800 万像素主摄，让细节纤毫毕现。更有 iPhone 芯片中的速度之王，为一切提供强大原动力。',70260777,999,'2023-02-24 07:57:38','2023-04-21 04:59:26',5,0),(100002,1001,'iPhone 14 Pro','灵动的 iPhone 新玩法，迎面而来。重大的安全新功能，为拯救生命而设计。创新的 4800 万像素主摄，让细节纤毫毕现。更有 iPhone 芯片中的速度之王，为一切提供强大原动力。',70260777,0,'2023-02-24 07:57:38','2023-03-21 04:49:24',5,0),(100008,1004,'16英寸 MacBook Pro',NULL,366602633,0,'2023-02-26 09:21:33','2023-02-28 12:38:57',2,1),(100009,1004,'14英寸 MacBook Pro',NULL,366602633,0,'2023-02-26 09:21:31','2023-02-28 12:39:02',2,1),(100010,1004,'13英寸 MacBook Pro',NULL,366602633,57,'2023-02-24 07:57:38','2023-02-28 12:38:13',2,1),(100012,1001,'iPhone 13 mini','5.4 英寸超视网膜 XDR 显示屏¹\n先进的双摄系统可拍摄惊艳的低光照片和视频\n配备 4 核图形处理器的 A15 仿生，速度快如闪电',366602633,874,'2023-02-24 07:57:38','2023-02-28 10:10:47',2,0),(100013,1001,'iPhone 13','6.1 英寸超视网膜 XDR 显示屏¹\n先进的双摄系统可拍摄惊艳的低光照片和视频\n配备 4 核图形处理器的 A15 仿生，速度快如闪电',366602633,64,'2023-02-24 07:57:38','2023-02-28 10:12:31',2,1),(100014,1001,'iPhone SE','4.7 英寸高清视网膜显示屏 脚注¹，明亮、绚丽又锐利\n超强 A15 仿生，iPhone 13 同款芯片\n5G 网络，畅享高速下载和高品质流媒体播放 脚注²',366602633,978,'2023-02-24 07:57:38','2023-02-28 10:13:26',2,1),(100015,1004,'Mac Book Air M1','搭载 M1 芯片的 MacBook Air 是一款实力出众的轻便型笔记本电脑。不仅又快又轻巧，还采用静谧的无风扇设计，并配备绚丽的视网膜显示屏。这样的纤薄外形，再加上从早用到晚的电池续航，你能轻轻松松带着这部 MacBook Air 随身而行，随时出手。',366602633,78,'2023-02-28 12:33:23','2023-02-28 12:36:01',1,0),(100016,1004,'Mac Book Air M2','全新 MacBook Air 以新一代芯片 M2 为核心重新打造，超薄形态再进化，性能和能效更非凡，并将一切融于坚固耐用的全铝金属机身之中。有这台速度超快、实力超强的笔记本电脑飘然在手，工作、娱乐和创作，随时随地尽情来。',366602633,465,'2023-02-28 12:37:12','2023-02-28 12:37:26',1,1),(100017,1004,'Mac Book Air M2','全新 MacBook Air 以新一代芯片 M2 为核心重新打造，超薄形态再进化，性能和能效更非凡，并将一切融于坚固耐用的全铝金属机身之中。有这台速度超快、实力超强的笔记本电脑飘然在手，工作、娱乐和创作，随时随地尽情来。',366602633,787,'2023-03-01 19:50:32','2023-03-01 19:50:32',0,1),(100031,1001,'Xiaomi 13','「购机至高享24期免息，+199得50W立式无线充Pro」第二代骁龙8｜徕卡专业光学镜头｜徕卡原生双画质｜徕卡75mm长焦 | 超窄边屏幕｜67W澎湃秒充',366602633,5867,'2023-03-02 06:00:29','2023-03-02 06:00:29',0,0),(100034,1001,'Galaxy S23 Ultra','三星全新机型',366602633,555,'2023-03-02 07:53:33','2023-03-02 07:53:33',0,0),(100035,1002,'Redmi X65 65英寸L65R8-X','双120Hz高刷屏 | HDMI 2.1接口 | 3GB+32GB',366602633,424,'2023-03-02 15:22:10','2023-03-02 15:22:10',0,0),(100036,1003,'速冷静 米家空调 1.5匹新3级能效','强劲动力，舒适速享',366602633,557,'2023-03-02 15:30:55','2023-03-02 15:30:55',0,0),(100037,1004,'ROG枪神7','2023新品！为信仰而战！为游戏而生！',366602633,99999,'2023-03-02 15:37:35','2023-03-02 15:37:35',0,0),(100038,1005,'Redmi Pad','入门平板，三大升级｜屏幕升级:90Hz高刷护眼屏｜外观升级:全金属一体化机身｜系统升级:MIUI Pad大屏定制系统',366602633,0,'2023-03-02 15:44:45','2023-03-02 15:44:45',0,0),(100039,1001,'Xiaomi 13 限量定制色','「购机至高享24期免息，+199得50W立式无线充Pro」第二代骁龙8｜徕卡专业光学镜头｜徕卡原生双画质｜徕卡75mm长焦 | 超窄边屏幕｜67W澎湃秒充',366602633,0,'2023-03-03 05:15:00','2023-03-03 05:15:00',0,0),(100040,1005,'小米平板5','骁龙860芯片 | 2.5K超清屏 | 120Hz高刷新率｜8720mAh大电池',366602633,0,'2023-03-03 07:30:38','2023-03-03 07:30:38',0,0),(100041,1003,'巨省电 米家空调 1.5匹新1级能效 睡眠版','强劲制冷 | 安静舒适 | 智能互联',366602633,0,'2023-03-08 20:41:19','2023-03-08 20:41:19',0,0),(100043,1004,'Xiaomi Book Air 13','薄至约12mm 时尚超薄 | 2.8K OLED 大师触控屏，音画双绝 | 高端百变翻转屏 | 小米妙享PC版 |英特尔 Evo认证',366602633,0,'2023-03-08 21:00:39','2023-03-08 21:00:39',0,0),(100044,1006,'小米手环7','1.62″AMOLED 跑道屏 | 四大专业运动数据分析 | 全天连续血氧饱和度监测',366602633,0,'2023-03-08 21:10:10','2023-03-08 21:10:10',0,0),(100045,1004,'Redmi G Pro 游戏本 2022 锐龙版','R7 6800H｜RTX 3060｜16\" 2.5K 240Hz',366602633,0,'2023-03-08 21:15:08','2023-03-08 21:15:08',0,0),(100046,1002,'小米电视6 OLED系列','4K OLED,更薄更清晰,0nit极夜黑,低蓝光认证,全场景互联',366602633,0,'2023-03-08 21:18:49','2023-03-08 21:18:49',0,0),(100047,1007,'Xiaomi Buds 4','年度旗舰半入耳降噪耳机',366602633,0,'2023-03-08 21:22:09','2023-03-08 21:22:09',0,0),(100048,1003,'米家冰箱对开门610L墨羽岩','「以旧换新至高再省165元」春来你鲜尝，一次储够两周鲜！海量空间，一次储够两周鲜|墨羽岩面板，颜值出众|压缩机10年质保|风冷无霜不结冰|银离子抗菌净味|智能互联',366602633,0,'2023-03-08 21:25:17','2023-03-08 21:25:17',0,0),(100049,1008,'小米小爱音箱Play 增强版','内置红外遥控，一句话控制传统家电内置红外遥控，一句话控制传统家电 | LED时钟显示，自适应亮度调节',366602633,0,'2023-03-08 21:29:16','2023-03-08 21:29:16',0,0),(100050,1006,'iwatchs8','戴上苹果手表，更健康的你不再只是想象',70260777,0,'2023-03-11 10:33:14','2023-03-11 10:33:14',0,0),(100051,1007,'AirPods (第三代) - 配闪电充电盒','表情符号、名字、缩写和数字混合镌刻，打造你独一无二的专属 AirPods。Apple 独家福利。',70260777,0,'2023-03-11 10:40:53','2023-03-11 10:40:53',0,0);
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
  `original_price` float DEFAULT NULL COMMENT '原价',
  `discount` int DEFAULT NULL COMMENT '折扣数，如果是100则表示不打折，79则表示79%或者-21%',
  `price` float DEFAULT NULL COMMENT '价格',
  `description` varchar(255) DEFAULT NULL COMMENT '具体规格产品的介绍，可以是折扣、赠品',
  `seq` int DEFAULT NULL COMMENT '具体规格显示的序号',
  `config1` varchar(30) DEFAULT NULL,
  `config2` varchar(30) DEFAULT NULL COMMENT '具体产品配置的内容，如：5G，128G，深空灰',
  `config5` varchar(30) DEFAULT NULL,
  `config3` varchar(30) DEFAULT NULL,
  `config4` varchar(30) DEFAULT NULL,
  `gift` varchar(80) DEFAULT NULL COMMENT '赠品信息，如果null则表示没有赠品',
  `stock` int DEFAULT NULL,
  `sell_count` int DEFAULT NULL COMMENT '销售量',
  PRIMARY KEY (`id`),
  KEY `product_category_id_fk1` (`category_id`),
  KEY `product_model_id_fk` (`model_id`),
  CONSTRAINT `product_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_model_id_fk` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='具体产品，model的进一级划分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1000001,1001,100001,8999,100,8999,'深空的黑色，藏着无尽的秘密',1,'深空黑色','128GB',NULL,NULL,NULL,NULL,666,524),(1000002,1001,100001,8999,100,8999,'低调高贵的银色，才能彰显出主人的气质',2,'银色','128GB',NULL,NULL,NULL,NULL,666,454),(1000003,1001,100001,8999,100,8999,'闪闪高贵的金色，衬托主人的品味',3,'金色','128GB',NULL,NULL,NULL,NULL,555,25),(1000004,1001,100001,8999,100,8999,'紫色，致命的性感，成熟的魅力',4,'暗紫色','128GB',NULL,NULL,NULL,NULL,666,4654),(1000005,1001,100001,9899,100,9899,'深空的黑色，藏着无尽的秘密',5,'深空黑色','256GB',NULL,NULL,NULL,NULL,666,56),(1000006,1001,100001,9899,100,9899,'低调高贵的银色，才能彰显出主人的气质',6,'银色','256GB',NULL,NULL,NULL,NULL,666,4242),(1000007,1001,100001,9899,100,9899,'闪闪高贵的金色，衬托主人的品味',7,'金色','256GB',NULL,NULL,NULL,NULL,666,4),(1000008,1001,100001,9899,100,9899,'紫色，致命的性感，成熟的魅力',8,'暗紫色','256GB',NULL,NULL,NULL,NULL,666,16),(1000009,1001,100001,11699,100,11699,'深空的黑色，藏着无尽的秘密',9,'深空黑色','512GB',NULL,NULL,NULL,NULL,666,11),(1000010,1001,100001,11699,100,11699,'低调高贵的银色，才能彰显出主人的气质',10,'银色','512GB',NULL,NULL,NULL,NULL,666,59),(1000011,1001,100001,11699,100,11699,'闪闪高贵的金色，衬托主人的品味',11,'金色','512GB',NULL,NULL,NULL,NULL,666,456),(1000012,1001,100001,11699,100,11699,'紫色，致命的性感，成熟的魅力',12,'暗紫色','512GB',NULL,NULL,NULL,NULL,666,48456),(1000013,1001,100001,13499,100,13499,'深空的黑色，藏着无尽的秘密',13,'深空黑色','1TB',NULL,NULL,NULL,NULL,666,222),(1000014,1001,100001,13499,100,13499,'低调高贵的银色，才能彰显出主人的气质',14,'银色','1TB',NULL,NULL,NULL,NULL,666,456),(1000015,1001,100001,13499,100,13499,'闪闪高贵的金色，衬托主人的品味',15,'金色','1TB',NULL,NULL,NULL,NULL,666,1548),(1000016,1001,100001,13499,100,13499,'紫色，致命的性感，成熟的魅力',16,'暗紫色','1TB',NULL,NULL,NULL,NULL,666,548),(1000020,1001,100002,7999,100,7999,'666',1,'暗紫色','128GB',NULL,NULL,NULL,NULL,666,489),(1000021,1001,100002,7999,100,7999,'666',2,'金色','128GB',NULL,NULL,NULL,NULL,666,45465),(1000023,1001,100002,7999,100,7999,'666',3,'银色','128GB',NULL,NULL,NULL,NULL,666,415),(1000024,1001,100002,7999,100,7999,'666',4,'深空黑色','128GB',NULL,NULL,NULL,NULL,666,458),(1000025,1001,100002,8899,100,8899,'666',5,'暗紫色','256GB',NULL,NULL,NULL,NULL,666,4),(1000026,1001,100002,8899,100,8899,'666',6,'金色','256GB',NULL,NULL,NULL,NULL,666,45),(1000027,1001,100002,8899,100,8899,'666',7,'银色','256GB',NULL,NULL,NULL,NULL,666,45),(1000028,1001,100002,8899,100,8899,'666',8,'深空黑色','256GB',NULL,NULL,NULL,NULL,666,456),(1000029,1001,100002,10699,100,10699,'666',9,'暗紫色','512GB',NULL,NULL,NULL,NULL,666,45645),(1000030,1001,100002,10699,100,10699,'666',10,'金色','512GB',NULL,NULL,NULL,NULL,666,415),(1000031,1001,100002,10699,100,10699,'666',11,'银色','512GB',NULL,NULL,NULL,NULL,666,45),(1000032,1001,100002,10699,100,10699,'666',12,'深空黑色','512GB',NULL,NULL,NULL,NULL,666,645),(1000033,1001,100002,12499,100,12499,'666',13,'暗紫色','1TB',NULL,NULL,NULL,NULL,666,45),(1000034,1001,100002,12499,100,12499,'666',14,'金色','1TB',NULL,NULL,NULL,NULL,666,456),(1000035,1001,100002,12499,100,12499,'666',15,'银色','1TB',NULL,NULL,NULL,NULL,666,45),(1000036,1001,100002,12499,100,12499,'666',16,'深空黑色','1TB',NULL,NULL,NULL,NULL,666,4889),(1000037,1004,100015,7999,100,7999,'选择你的新款 MacBook Air M1',1,'深空灰色','8 核中央处理器','7 核图形处理器','8GB 统一内存','256GB 固态硬盘¹','赠送airpods 3',666,456),(1000038,1004,100015,7999,100,7999,'选择你的新款 MacBook Air M1',2,'金色','8 核中央处理器','7 核图形处理器','8GB 统一内存','256GB 固态硬盘¹','赠送airpods 3',666,415),(1000039,1004,100015,7999,100,7999,'选择你的新款 MacBook Air M1',3,'银色','8 核中央处理器','7 核图形处理器','8GB 统一内存','256GB 固态硬盘¹','赠送airpods 3',666,456),(1000063,1001,100031,4599,100,4599,'',1,'黑色','12GB+256GB',NULL,NULL,NULL,'',354,48),(1000064,1001,100031,3999,100,3999,'',2,'黑色','8GB+128GB',NULL,NULL,NULL,'',159,45),(1000065,1001,100031,4299,100,4299,'',3,'黑色','8GB+256GB',NULL,NULL,NULL,'',651,156),(1000070,1001,100034,8999,95,8549,'赠送商品，送完即止',1,'黑色','256GB|8GB',NULL,NULL,NULL,'赠送三星蓝牙耳机',666,122),(1000071,1001,100034,12699,100,12699,'至尊顶配版',2,'红色','1TB|12GB',NULL,NULL,NULL,'',3333,1545),(1000072,1002,100035,2899,100,2899,'65英寸，超高分辨率，巨爽！！',1,'蓝色','65英寸',NULL,NULL,NULL,'赠送智能音响2台',360,79),(1000073,1003,100036,1999,100,1999,'强劲变频，节能新标准！！',1,'白色',NULL,NULL,NULL,NULL,'',366,6765),(1000074,1004,100037,14999,100,14999,'双显三模！DDR5内存！三风扇散热！2.5K星云屏！新液金导热！',1,'黑色','i9-13980HX','1TB','RTX4070','16GB','rog背包',120,775),(1000075,1004,100037,11999,100,11999,'全新40系显卡，让你快人一步！！',2,'黑色','i9-13980HX','1TB','RTX4060','16G','rog鼠标垫',331,67),(1000076,1005,100038,1499,100,1499,'基础配置，价格实惠！',1,'烟青绿','6GB+128GB',NULL,NULL,NULL,'',333,3543),(1000077,1005,100038,1299,100,1299,'',2,'烟青绿','4GB+128GB',NULL,NULL,NULL,'',231,544),(1000078,1005,100038,1799,100,1799,'至尊配置，学习和娱乐都在行',3,'烟青绿','8GB+128GB',NULL,NULL,NULL,'小米专属电子笔',543,66),(1000079,1005,100038,1799,100,1799,'至尊配置，学习和娱乐都在行',4,'银色','8GB+128GB',NULL,NULL,NULL,'小米专属电子笔',435,66),(1000080,1005,100038,1799,100,1799,'至尊配置，学习和娱乐都在行',5,'银色','8GB+128GB',NULL,NULL,NULL,'小米专属电子笔',435,80),(1000081,1001,100039,4999,100,4999,'',1,'飓风黄','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',111,0),(1000082,1001,100039,4999,100,4999,'',2,'宝石蓝','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',222,0),(1000083,1001,100039,4999,100,4999,'',3,'丛林绿','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',333,0),(1000084,1001,100039,4999,100,4999,'',4,'烈焰红','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',321,0),(1000085,1001,100039,4999,100,4999,'',5,'水泥灰','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',123,0),(1000086,1005,100040,1999,90,1799,'',1,'黑色','6GB+128GB',NULL,NULL,NULL,'价值69元小米33W充电器套装 第二代 白色x1，赠完即止',0,0),(1000087,1005,100040,2299,90,2069,'',2,'绿色','6GB+256GB',NULL,NULL,NULL,'价值69元小米33W充电器套装 第二代 白色x1，赠完即止',0,0),(1000088,1005,100040,2599,90,2339,'',3,'白色','8GB+256GB',NULL,NULL,NULL,'价值69元小米33W充电器套装 第二代 白色x1，赠完即止',0,0),(1000089,1003,100041,2399,92,2199,'小米自营',1,'白色',NULL,NULL,NULL,NULL,'',1399,0),(1000090,1004,100043,5999,83,4999,'',1,'白色','i5','512G','Xe','16G','',1351,0),(1000091,1004,100043,6999,85,5999,'',2,'白色','i7','512G','Xe','16G','',0,0),(1000092,1006,100044,249,83,209,'',1,'夜跃黑',NULL,NULL,NULL,NULL,'',777,0),(1000093,1006,100044,249,83,209,'',2,'舒展蓝',NULL,NULL,NULL,NULL,'',543,0),(1000094,1006,100044,249,83,209,'',3,'悦活粉',NULL,NULL,NULL,NULL,'',111,0),(1000095,1004,100045,8799,79,6999,'',1,'战舰灰','R7 6800H','512G','RTX 3060','16G','价值199元定制简约双肩包 灰色x1，赠完即止',134,0),(1000096,1002,100046,4999,95,4799,'',1,'黑色','55英寸',NULL,NULL,NULL,'',1344,0),(1000097,1002,100046,6999,95,6699,'',2,'黑色','65英寸',NULL,NULL,NULL,'下单立减700元',2110,0),(1000098,1007,100047,699,100,699,'',1,'月影黑',NULL,NULL,NULL,NULL,'',2131,0),(1000099,1007,100047,699,100,699,'',2,'盐湖白',NULL,NULL,NULL,NULL,'',3221,0),(1000100,1007,100047,699,100,699,'',3,'旷野绿',NULL,NULL,NULL,NULL,'',411,0),(1000101,1003,100048,2799,89,2499,'',1,'墨羽岩',NULL,NULL,NULL,NULL,'',3411,0),(1000102,1008,100049,149,100,149,'',1,'黑色',NULL,NULL,NULL,NULL,'',1231,0),(1000103,1006,100050,2999,100,2999,'了解更多表带类型，尝试不同表壳材质。Apple Watch 定制坊让你充分展现个人风格。',1,'Black Unity 41mm',NULL,NULL,NULL,NULL,'Black Unity表带',1311,0),(1000104,1006,100050,3199,100,3199,'',2,'彩虹版 45mm',NULL,NULL,NULL,NULL,'彩虹表带',321,0),(1000105,1007,100051,1349,100,1349,'免费赠送镌刻服务',1,'白色-闪电充电盒',NULL,NULL,NULL,NULL,'免费镌刻服务',377,0),(1000106,1007,100051,1399,100,1399,'免费赠送镌刻服务',2,'白色-MagSafe充电盒',NULL,NULL,NULL,NULL,'免费镌刻服务',241,0),(1000118,1001,100012,4699,98,4650,'',1,'蓝色','128GB',NULL,NULL,NULL,'官方充电线',600,0),(1000119,1001,100012,5599,99,5550,'',2,'粉色','256GB',NULL,NULL,NULL,'',333,0),(1000120,1001,100012,7399,99,7350,'',3,'午夜色','512GB',NULL,NULL,NULL,'',500,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `querytop`
--

DROP TABLE IF EXISTS `querytop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `querytop` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `model_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=700016 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `querytop`
--

LOCK TABLES `querytop` WRITE;
/*!40000 ALTER TABLE `querytop` DISABLE KEYS */;
INSERT INTO `querytop` VALUES (700001,100039),(700002,100031),(700003,100035),(700004,100038),(700005,100040),(700006,100041),(700007,100043),(700008,100044),(700009,100045),(700010,100046),(700011,100047),(700012,100048),(700013,100049),(700014,100050),(700015,100051);
/*!40000 ALTER TABLE `querytop` ENABLE KEYS */;
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
  `type` smallint DEFAULT NULL COMMENT '标识房间类型，如果是1表示私聊，如果是2表示群聊',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22000004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='聊天室';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (22000001,'','2023-03-10 13:06:54','2023-03-10 13:06:57',0,NULL,1),(22000002,NULL,'2023-03-12 07:47:52','2023-03-12 07:47:52',0,NULL,1),(22000003,NULL,'2023-03-12 07:50:37','2023-03-12 07:50:37',0,NULL,1);
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
  `foreign_id` bigint DEFAULT NULL COMMENT '外键id',
  `type` smallint DEFAULT NULL COMMENT '1、文章；2、商品；3、用户',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `star_product_id_fk` (`foreign_id`),
  KEY `star_user_id_fk` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `star`
--

LOCK TABLES `star` WRITE;
/*!40000 ALTER TABLE `star` DISABLE KEYS */;
INSERT INTO `star` VALUES (64,70260777,100039,2,'2023-03-08 18:59:31','2023-03-08 18:59:31',0),(66,70260777,100035,2,'2023-03-08 18:59:47','2023-03-08 18:59:47',0),(68,70260777,100031,2,'2023-03-08 19:00:01','2023-03-08 19:00:01',0),(72,366602633,100044,2,'2023-03-09 18:49:21','2023-03-09 18:49:21',0),(73,366602633,100049,2,'2023-03-09 18:49:27','2023-03-09 18:49:27',0),(74,366602633,100046,2,'2023-03-09 19:05:47','2023-03-09 19:05:47',0),(75,366602633,100035,2,'2023-03-09 19:05:54','2023-03-09 19:05:54',0),(76,366602633,100040,2,'2023-03-09 20:05:02','2023-03-09 20:05:02',0),(77,366602633,100038,2,'2023-03-09 20:05:06','2023-03-09 20:05:06',0),(78,366602633,100047,2,'2023-03-09 20:06:17','2023-03-09 20:06:17',0),(79,366602633,100043,2,'2023-03-09 20:06:26','2023-03-09 20:06:26',0),(80,366602633,100045,2,'2023-03-09 20:06:31','2023-03-09 20:06:31',0),(83,70260777,100051,2,'2023-03-11 23:12:47','2023-03-11 23:12:47',0),(84,70260777,100048,2,'2023-03-11 23:12:53','2023-03-11 23:12:53',0),(86,70260777,100049,2,'2023-03-18 07:59:47','2023-03-18 07:59:47',0),(117,70260777,100046,2,'2023-03-21 04:12:10','2023-03-21 04:12:10',0),(121,70260777,366602633,3,'2023-04-19 08:32:56','2023-04-19 08:32:56',0),(122,70260777,11000008,1,'2023-04-20 10:08:23','2023-04-20 10:08:23',0),(127,70260777,11000006,1,'2023-04-21 03:34:36','2023-04-21 03:34:36',0),(129,70260777,100050,2,'2023-04-21 04:03:35','2023-04-21 04:03:35',0),(130,70260777,100002,2,'2023-04-21 04:07:12','2023-04-21 04:07:12',0);
/*!40000 ALTER TABLE `star` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'tag内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71000007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (71000001,'airpods'),(71000002,'苹果耳机'),(71000003,'苹果'),(71000004,'蓝牙耳机'),(71000005,'华为'),(71000006,'华为手机');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trade` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `buyer_id` bigint DEFAULT NULL COMMENT '购买者的用户id',
  `location_id` bigint DEFAULT NULL,
  `total_count` int DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `total_discount` float DEFAULT NULL,
  `total_transportation_expenses` int DEFAULT NULL,
  `return_id` bigint DEFAULT NULL COMMENT '退货表单号',
  `comment_id` bigint DEFAULT NULL COMMENT '评论表单号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间戳',
  `state` tinyint DEFAULT NULL COMMENT '订单状态：1，下单，未付；2，已付，未收到；3，收到；4，退货中；5，交易完成；6，订单关闭',
  `version` bigint DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000021 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='交易表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES (70000002,70260777,70000001,5,16695,0,0,NULL,NULL,'2023-03-07 23:53:54','2023-03-11 07:49:34',3,1),(70000003,70260777,70000002,2,6898,0,0,NULL,NULL,'2023-03-07 23:58:56','2023-03-11 07:49:15',3,1),(70000004,70260777,70000002,2,6898,0,0,NULL,NULL,'2023-03-07 23:59:40','2023-04-15 19:14:24',7,2),(70000005,70260777,70000001,4,12696,0,0,NULL,NULL,'2023-03-08 00:00:11','2023-04-15 19:14:24',7,2),(70000006,70260777,70000001,2,6898,0,0,NULL,NULL,'2023-03-08 00:02:17','2023-04-15 19:14:24',7,2),(70000007,70260777,70000001,2,6898,0,0,NULL,NULL,'2023-03-08 00:03:45','2023-04-15 19:14:24',7,2),(70000008,70260777,70000001,2,6898,0,0,NULL,NULL,'2023-03-08 00:04:05','2023-03-21 06:52:04',7,1),(70000009,70260777,70000002,3,5147,600,0,NULL,NULL,'2023-03-11 10:45:32','2023-04-15 08:06:01',4,3),(70000010,70260777,70000002,2,4998,600,0,NULL,NULL,'2023-03-11 23:13:01','2023-04-17 11:58:26',4,3),(70000011,70260777,70000002,2,298,0,0,NULL,NULL,'2023-03-13 15:02:12','2023-03-21 07:02:32',4,3),(70000012,70260777,70000006,2,5398,300,0,NULL,NULL,'2023-03-21 07:36:24','2023-04-15 08:05:53',7,2),(70000013,70260777,70000006,2,5798,0,0,NULL,NULL,'2023-04-15 19:35:03','2023-04-15 19:51:07',7,2),(70000014,70260777,70000006,1,4599,0,0,NULL,NULL,'2023-04-15 19:53:40','2023-04-15 20:09:01',7,2),(70000015,70260777,70000006,2,9198,0,0,NULL,NULL,'2023-04-16 11:06:08','2023-04-16 11:35:18',7,2),(70000016,70260777,70000001,3,9597,600,0,NULL,NULL,'2023-04-16 11:24:39','2023-04-16 13:01:45',7,3),(70000017,70260777,70000006,2,9598,400,0,NULL,NULL,'2023-04-16 13:05:19','2023-04-16 13:06:18',3,2),(70000018,70260777,70000006,2,9198,0,0,NULL,NULL,'2023-04-16 13:34:52','2023-04-16 13:35:07',7,2),(70000019,70260777,70000006,3,8697,0,0,NULL,NULL,'2023-04-17 11:58:11','2023-04-17 11:58:22',3,2),(70000020,70260777,70000006,3,8697,0,0,NULL,NULL,'2023-04-17 12:02:04','2023-04-17 12:17:04',7,2);
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_detail`
--

DROP TABLE IF EXISTS `trade_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trade_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `trade_id` bigint DEFAULT NULL COMMENT '订单id',
  `seq` int DEFAULT NULL,
  `seller_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL COMMENT '具体产品id',
  `price` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `count` int DEFAULT NULL COMMENT '具体产品数量',
  `transportation_expenses` int DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50000030 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_detail`
--

LOCK TABLES `trade_detail` WRITE;
/*!40000 ALTER TABLE `trade_detail` DISABLE KEYS */;
INSERT INTO `trade_detail` VALUES (50000001,70000002,0,366602633,1000064,3999,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000002,70000002,1,366602633,1000072,2899,0,3,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000003,70000003,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000004,70000003,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000005,70000004,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000006,70000004,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000007,70000005,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000008,70000005,1,366602633,1000072,2899,0,3,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000009,70000006,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000010,70000006,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000011,70000007,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000012,70000007,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000013,70000008,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000014,70000008,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000015,70000009,0,366602633,1000102,149,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/89ab24c0d8fb42d0a0f7b857799c48d5.jpg'),(50000016,70000009,1,366602633,1000101,2499,300,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg'),(50000017,70000010,0,366602633,1000101,2499,300,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg'),(50000018,70000011,0,366602633,1000102,149,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/89ab24c0d8fb42d0a0f7b857799c48d5.jpg'),(50000019,70000012,0,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000020,70000012,1,366602633,1000101,2499,300,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg'),(50000021,70000013,0,366602633,1000072,2899,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000022,70000014,0,366602633,1000063,4599,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000023,70000015,0,366602633,1000063,4599,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000024,70000016,0,366602633,1000063,4599,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000025,70000016,1,366602633,1000101,2499,300,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg'),(50000026,70000017,0,366602633,1000096,4799,200,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f816992785814dc994e0655caab9657d.jpg'),(50000027,70000018,0,366602633,1000063,4599,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000028,70000019,0,366602633,1000072,2899,0,3,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000029,70000020,0,366602633,1000072,2899,0,3,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg');
/*!40000 ALTER TABLE `trade_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nickname` varchar(30) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名，作为登录账号，不能为空，不能重复',
  `password` varchar(255) DEFAULT NULL COMMENT '用户账号的密码，储存加密之后的密码',
  `email` varchar(255) DEFAULT NULL COMMENT '用户的注册邮箱，不可更改，唯一',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `credit_score` smallint DEFAULT NULL COMMENT '信誉积分，满分100分',
  `cumulative_score` int DEFAULT NULL COMMENT '积分，没消费100元积1积分',
  `balance` float DEFAULT NULL COMMENT '账户余额',
  `is_seller` tinyint(1) DEFAULT NULL COMMENT '是否是商家',
  `shop_id` bigint DEFAULT NULL COMMENT '是否是商家，如果为null，则不是商家，否则记录对应商铺的id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新信息的时间',
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1629740934187651076 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (70260777,'天天7','70260777','3b31a3bb4e24bcb10b71909de39a49e0974fd3ed5a83d1d0fb6ae04326720a29','70260777@qq.com','https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/users/50000001/avatar/9f7b4ca174524ef29026e6062806271d.jpg',100,0,930973,1,1,'2023-02-23 07:57:38','2023-04-17 11:58:22',26),(366602633,'天天366','366602633','3b31a3bb4e24bcb10b71909de39a49e0974fd3ed5a83d1d0fb6ae04326720a29','366602633@qq.com',NULL,100,0,999999,0,NULL,'2023-02-23 07:57:38','2023-02-24 07:57:38',1),(1629740934187651075,'李瑞之','liruizhi','3b31a3bb4e24bcb10b71909de39a49e0974fd3ed5a83d1d0fb6ae04326720a29','qq366602633@163.com',NULL,0,0,0,0,NULL,'2023-02-27 04:01:01','2023-02-27 04:01:01',0);
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
INSERT INTO `user_in_room` VALUES (70260777,22000001,'2023-03-10 13:07:13'),(366602633,22000001,'2023-03-10 13:07:18');
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

-- Dump completed on 2023-04-21 21:27:55
