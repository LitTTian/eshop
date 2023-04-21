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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11000010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (11000001,70260777,1001,'当今手机的发展','随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。','随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。随着科技与时代的发展，手机的发展似乎遇到了瓶颈，很多手机开发商开始由性能转而研究软件层面对用户体验的影响。',1015,'2023-03-15 08:13:24','2023-03-22 18:48:02',17),(11000006,366602633,1007,'test','为什么airpods这么受欢迎','第3代AirPods，建议售价1,399元。\n\n年假一转眼就结束了，入手新玩具一起迎接开工肯定能大大消减不想上班的情绪！果粉们等了很久的第3代AirPods近日终于正式出货，如果你还没用过任何一款AirPods，或是上一代用户还在考虑要不要更新，以下这5个优点值得你赶快下单。\n\n外型小巧、配戴舒适\n乍看之下，第3代AirPods的充电盒与AirPods Pro外型极为相似，实际相比尺寸却小了一圈；若与前一代AirPods相比，第3代AirPods的耳机柄比之前短了33%，同时也从敲敲控制变成了如同AirPods Pro以耳机柄上的力度传感器操控的方式，更直觉易用。而针对耳机本体，如果你对降噪耳机的封闭性容易感到不适，第3代AirPods的开放式设计，应该可以让你感到恰恰好的舒适。\n\n续航时间更长，且支持MagSafe\n第3代AirPods充1次电后，享有最高达6小时的聆听音乐时间，且仅需在充电盒中快充5分钟，即可充入1小时电量，搭配充电盒使用，更可提供最高达30小时的总聆听时间，长时间工作使用也不用担心。这次充电盒也支持MagSafe无线充电功能，可与手边现有的iPhoneMagSafe充电器搭配使用，也可以通过其他Qi认证充电器进行充电。\n\n新增适应性等化功能\n第3代AirPods除了塞入了特制的驱动单元和高动态范围扩音器，更加入了之前仅见于AirPods Pro和AirPods Max的适应性等化功能，通过耳机内新增的内向式麦克风来接收耳中的声音，并通过音讯运算技术自动将中、低频声音实时调整，这个功能对开放式耳机设计来说很重要，是提供丰富、具一致性的聆听体验的关键。\n\n拥有空间音频、动态头部关注功能\n新款AirPods也具备了原本在AirPods Pro才有的空间音频以及动态头部关注功能，运用强大的H1芯片，不管是听音乐、看电影，还是群组FaceTime视频通话，微调左右耳个别收到的频率，让声音更具有真实的环绕感。更棒的是，这个功能除了支持苹果自家平台，也支持Netflix、Disney+等主流影音平台。\n\n支持「寻找」功能\n针对许多用户最担心的遗失问题，新款AirPods现在也支持「寻找」功能，你可以设定在离开iPhone蓝牙范围时立刻推送离身警示，或是远在天边近在眼前却又找不到的时候让AirPods播放警示音以利寻找。真的不知道丢到哪去了，也可以通过「寻找」App关注AirPods上次联机的位置，增加寻回设备的机会。\n\n该买第3代AirPods还是AirPods Pro？\n现在才想要入手AirPods，或是想要更新第2代的用户，肯定会在要买哪一款之间挣扎。第3代AirPods与AirPods Pro相比，最关键的差异就在「主动降噪功能」，虽然新款AirPods在耳机顶部、机身与耳机柄底部都加上声学网面，可于通话时降低风噪，通过物理与软件共同达成让通话更清晰的目标，但如果你经常在搭乘大众交通工具时使用、或是常有在线会议等需要阻绝外界声音干扰的需求，AirPods Pro会是更适合的选择。但如果你不喜欢耳塞配戴时的感觉，平常大部分是开车、没有太多需要降噪功能的使用情境，那其他功能几乎与AirPods Pro相同的第3代AirPods绝对是更容易入手的绝佳选择。',321,'2023-03-17 00:22:48','2023-03-22 19:20:50',321),(11000008,70260777,1001,'关于华为手机','华为手机真的好用','1、屏幕：屏幕尺寸6.5英寸，屏幕色彩1670万色，分辨率FHD+ 2376 × 1080 像素，看电影更加舒畅。\n2、相机：后置摄像头：超感知摄像头5000万像素+超广角摄像头1600万像素+长焦摄像头800万像素，支持自动对焦。前置摄像头：超感知摄像头1300万像素，支持固定焦距，拍照更加细腻，更加清晰。\n3、性能：采用EMUI 11.0（基于Android 10）系统，搭载麒麟9000E，八核处理器 ，带来高速、流畅的体验。\n4、电池：配备4200mAh（典型值）大容量电池，续航持久。\n5、芯片：麒麟9000E芯片采用先进的半导体制程，是当前技术工艺最领先的5纳米5G Soc 手机芯片，将处理器和5G基带融于一体，带来速度更快发热更低和能效比更强的运行表现，从容应对5G时代中复杂的计算，负载任务，使HUAWEI Mate 40 成为领先业界的5G 手机。\n6、特色功能：畅连大文件闪传、智感支付、灵动熄屏显示、AI 隔空操控、微电影、AI跟拍、AI 字幕、超级微距、双景录像、自拍慢动作、多屏协同、畅连通话、四网协同、智慧剪辑、智慧多窗、AI 信息保护、人脸解锁、智能截屏、小艺智慧语音、智慧视觉、情景智能、华为分享等等。\n可以登录迅购商城了解更多的手机参数，根据个人的喜好和需求选择。',4,'2023-03-17 00:43:11','2023-03-22 18:48:06',4),(11000009,70260777,1001,'关于华为手机','华为手机真的好用','1、屏幕：屏幕尺寸6.5英寸，屏幕色彩1670万色，分辨率FHD+ 2376 × 1080 像素，看电影更加舒畅。\n2、相机：后置摄像头：超感知摄像头5000万像素+超广角摄像头1600万像素+长焦摄像头800万像素，支持自动对焦。前置摄像头：超感知摄像头1300万像素，支持固定焦距，拍照更加细腻，更加清晰。\n3、性能：采用EMUI 11.0（基于Android 10）系统，搭载麒麟9000E，八核处理器 ，带来高速、流畅的体验。\n4、电池：配备4200mAh（典型值）大容量电池，续航持久。\n5、芯片：麒麟9000E芯片采用先进的半导体制程，是当前技术工艺最领先的5纳米5G Soc 手机芯片，将处理器和5G基带融于一体，带来速度更快发热更低和能效比更强的运行表现，从容应对5G时代中复杂的计算，负载任务，使HUAWEI Mate 40 成为领先业界的5G 手机。\n6、特色功能：畅连大文件闪传、智感支付、灵动熄屏显示、AI 隔空操控、微电影、AI跟拍、AI 字幕、超级微距、双景录像、自拍慢动作、多屏协同、畅连通话、四网协同、智慧剪辑、智慧多窗、AI 信息保护、人脸解锁、智能截屏、小艺智慧语音、智慧视觉、情景智能、华为分享等等。\n可以登录迅购商城了解更多的手机参数，根据个人的喜好和需求选择。',2,'2023-03-17 00:43:11','2023-03-19 07:56:56',2);
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
-- Table structure for table `article_like`
--

DROP TABLE IF EXISTS `article_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_like` (
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
-- Dumping data for table `article_like`
--

LOCK TABLES `article_like` WRITE;
/*!40000 ALTER TABLE `article_like` DISABLE KEYS */;
INSERT INTO `article_like` VALUES (55000014,70260777,33000001,2,1,'2023-03-15 08:32:40','2023-03-15 08:32:41',1),(55000016,70260777,44000001,3,1,'2023-03-15 08:32:40','2023-03-15 08:32:41',1),(55000019,70260777,44000010,3,1,'2023-03-19 05:28:04','2023-03-19 05:28:04',1),(55000020,70260777,44000009,3,1,'2023-03-19 05:28:05','2023-03-19 05:28:05',1),(55000021,70260777,44000008,3,1,'2023-03-19 05:28:05','2023-03-19 05:28:05',1),(55000022,70260777,33000003,2,1,'2023-03-19 05:28:07','2023-03-19 05:28:07',1),(55000035,70260777,11000008,1,1,'2023-03-19 07:19:05','2023-03-19 07:19:05',1),(55000036,70260777,11000006,1,1,'2023-03-19 07:19:07','2023-03-21 07:32:09',5),(55000037,70260777,33000005,2,1,'2023-03-20 17:58:58','2023-03-20 17:58:58',1),(55000044,70260777,11000001,1,1,'2023-03-21 07:35:41','2023-03-21 07:35:42',2);
/*!40000 ALTER TABLE `article_like` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,5,50000001,NULL,1,0),(43,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/bd7cf9497cae4802ac910ba9d7b36b10.png',2,0),(44,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/486019fc4148480a96a02452520ecb2c.png',3,0),(46,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b0297324d3704db6811f8350501de5e2.png',4,0),(47,1,100034,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/da00cecf95fa45f19b0e5af44d693811.png',5,0),(48,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/308d72707e10483dad1367378a9ccfd0.png',2,0),(49,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png',1,0),(50,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/d009314bfcf64c3a90e5060ac0e0e41c.png',3,0),(51,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/38aaa9f8af184e72a3b5bcdce9e7cb52.png',4,0),(52,1,100031,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f03ad9bb824a488aacf3723decb0c4c0.png',5,0),(53,1,100001,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100001/cover.jpg',1,0),(54,1,100002,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100002/cover.png',1,0),(55,1,100003,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100003/cover.png',1,0),(56,1,100004,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100004/cover.png',1,0),(57,1,100008,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100008/cover.png',1,0),(58,1,100009,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100009/cover.png',1,0),(59,1,100010,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100010/cover.png',1,0),(60,1,100012,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100012/cover.png',1,0),(61,1,100013,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100013/cover.png',1,0),(62,1,100014,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1001/100014/cover.png',1,0),(63,1,100015,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100015/cover.png',1,0),(64,1,100016,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/products/1004/100016/cover.png',1,0),(66,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg',1,0),(67,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/6afca07bbf584a089cdc726c91fced18.jpg',2,0),(68,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e6c01742ab5a492baedbd4104d4abdd0.jpg',3,0),(69,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/cadf44c5a61e4f788ef4a2c52ba4384e.jpg',4,0),(70,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/6b51c3bd5bf84462a118d098350b94c2.jpg',5,0),(71,1,100035,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ddfbf4e5e9f84aa984019107691f5c48.jpg',6,0),(72,1,100036,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/72f2e9f501d840d18c40b46df8238b8d.png',1,0),(73,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24b554aec0d4ad9bfdb2c27bebcbce2.jpg',1,0),(74,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/4dd33aa1a64f4da3a13e94decc4612c7.jpg',2,0),(75,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b28d48e967454379b3653c20c554aa99.jpg',3,0),(76,1,100037,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/6efd6cc8806a4d45ac3d80d704b61128.jpg',4,0),(77,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/cddd550b9a8c40bfb673392a03f53493.png',1,0),(78,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/5bb939bd02ee44ba82e9b343b51367e7.png',2,0),(79,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/df315eb5be1d4d5f86a99ba6f1efedfd.png',3,0),(80,1,100038,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/380b258c005645b799aed930303e1ac3.png',4,0),(81,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/c02be5cd71de421292e1742fb6e6bec4.png',2,0),(82,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f2e71e5dcd0f4f5ca32327a87e2ea22a.png',1,0),(83,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/7724b0712d6d4ebe88c41a4142470a65.png',3,0),(84,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e5503ad0914a472692195055ab96998c.png',4,0),(85,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/009798f648e944b28f4ce863f8a7fa04.png',5,0),(86,1,100039,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2d297c484beb488db5b665d4327a5c52.png',6,0),(87,1,100040,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/4c88a6038bc942b697757991336c3cee.png',1,0),(88,1,100041,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/bc6136a7cc3d46b8b553ab68a0037c30.jpg',1,0),(89,1,100041,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/cca30103af854e4f87dffb8a3b071b60.png',2,0),(90,1,100041,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/47bc3126b12141ad93274ba3ef3ee298.png',3,0),(92,1,100043,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/a5e8be7a58504e35be71f63b3f7048c4.png',1,0),(93,1,100044,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/412da2873dc746e2a4d626be412cba95.png',1,0),(94,1,100044,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/c36822b8611d4f5393acd253c7bd28c6.png',2,0),(95,1,100044,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ec787a089510448ca55e65e6dc1a3a00.png',3,0),(96,1,100045,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/920f95b62a964c8194ea57c2486b8023.png',1,0),(97,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f816992785814dc994e0655caab9657d.jpg',1,0),(98,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/fc94094420a04223888d20bd2e200fa0.jpg',2,0),(99,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/4caa4c5b4a4c47fd9a50722c2739cb4d.jpg',3,0),(100,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/3a01e581dac348e4a7691b483c28ea2e.jpg',4,0),(101,1,100046,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/de90cba39822423f921c6f6a5b6e841d.jpg',5,0),(102,1,100047,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ab590dc9eea449cdb82320a8d69b75c5.png',1,0),(103,1,100047,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/9295f9c5cf654626920b56134a9e2478.png',2,0),(104,1,100047,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/8e9cb241e9914090a36d54104139c358.png',3,0),(105,1,100048,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg',1,0),(106,1,100048,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/9f8bb69441db450ab75a6010394c57e0.jpg',2,0),(107,1,100048,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/00048c40a82b427a84f34a0b243dba69.jpg',3,0),(108,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/89ab24c0d8fb42d0a0f7b857799c48d5.jpg',1,0),(109,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/15b346f857d64e8b806aede7b21cb183.jpg',2,0),(110,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f4df92f3e63d413f964d7937a29eec18.jpg',3,0),(111,1,100049,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/f4ccd7e0e1d34e1499fb3b7fe9fda139.jpg',4,0),(112,1,100050,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/da8c0ff9301b4b909889f222b6ed8ec5.jpg',1,0),(113,1,100050,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/17df81393caa4bfb86b6c812af8aafc2.jpg',2,0),(114,1,100050,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/81332dae4767488eacd6f3c178e72a93.jpg',3,0),(115,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/161206dcab034a18b1986d29ad7a770b.jpg',1,0),(116,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/76392c3dc02743d1a7a732f4baf8e170.jpg',2,0),(117,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/922656ee9eda497ab76fc16d50670502.jpg',3,0),(118,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/919ffaa58c534d6f8f71e66f5bc31e84.jpg',4,0),(119,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/599f650b4887440da41e036c2f6b5a93.jpg',5,0),(120,1,100051,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/baf4dc5d79984e33ad297978656461ea.jpg',6,0),(121,4,11000001,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/32a9ca793fc5441db3dec821c7c51426.jpg',1,0),(122,4,11000001,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e94ab812520e4f50abbd36aa58c7011d.jpg',2,0),(161,4,11000006,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/32a9ca793fc5441db3dec821c7c51426.jpg',1,1),(162,4,11000006,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/e94ab812520e4f50abbd36aa58c7011d.jpg',2,1),(163,4,11000006,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/ae3f9d61f15c484e9be6815a82a4f711.jpg',3,1);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
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
  `status` smallint DEFAULT NULL COMMENT '标志地址是否被移除：0表示移除，1表示正常使用。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (70000001,70260777,1,'李瑞之','18860966866','江苏','南京市','浦口区','盘城街道','南京信息工程大学','学校',1),(70000002,70260777,2,'lrz','18860966866','江苏','南京市','浦口区','盘城街道','南信大沁园','宿舍',1),(70000003,366602633,1,'李瑞之','18860966866','江苏','南京市','浦口区','盘城街道','南京信息工程大学','学校',1),(70000004,366602633,2,'lrz','18860966866','江苏','南京市','浦口区','盘城街道','南信大沁园','宿舍',1),(70000005,70260777,3,'123','18860966866','北京市','市辖区','东城区','东华门街道办事处','12333','11',1),(70000006,70260777,4,'1234','18860966866','北京市','市辖区','东城区','东华门街道办事处','12321','333',1),(70000007,70260777,5,'132123','18860966866','北京市','市辖区','西城区','西长安街街道办事处','11','2',0),(70000008,70260777,6,'1','18860966866','天津市','市辖区','和平区','小白楼街道','21','3',0);
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
  `content` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `type` tinyint DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '消息创建时间，可用作消息的排序',
  `update_time` timestamp NULL DEFAULT NULL,
  `version` bigint DEFAULT NULL COMMENT '消息版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11000032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='与商家聊天的消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (11000001,22000001,70260777,'test1',NULL,'2023-03-10 14:45:14','2023-03-10 14:45:18',1),(11000002,22000001,366602633,'test111',NULL,'2023-03-10 14:46:01','2023-03-10 14:46:02',1),(11000003,22000001,70260777,'test1',NULL,'2023-03-10 14:47:01','2023-03-10 14:47:01',1),(11000004,22000001,366602633,'test111',NULL,'2023-03-10 14:48:01','2023-03-10 14:48:01',1),(11000005,22000001,70260777,'test1',NULL,'2023-03-10 14:49:01','2023-03-10 14:49:01',1),(11000006,22000001,366602633,'test111',NULL,'2023-03-10 14:51:01','2023-03-10 14:51:01',1),(11000007,22000001,70260777,'test1',NULL,'2023-03-10 14:53:01','2023-03-10 14:53:01',1),(11000008,22000001,366602633,'test111',NULL,'2023-03-10 14:54:01','2023-03-10 14:54:01',1),(11000009,22000001,70260777,'test1',NULL,'2023-03-10 14:58:01','2023-03-10 14:58:01',1),(11000010,22000001,366602633,'test111',NULL,'2023-03-10 14:59:01','2023-03-10 14:59:01',1),(11000011,22000001,366602633,'dsadaDsada',NULL,'2023-03-10 22:36:20','2023-03-10 22:36:20',0),(11000012,22000001,366602633,'hello',NULL,'2023-03-10 22:37:45','2023-03-10 22:37:45',0),(11000013,22000001,366602633,'可以便宜点吗',NULL,'2023-03-10 22:38:06','2023-03-10 22:38:06',0),(11000014,22000001,70260777,'你好，可以的哦',NULL,'2023-03-10 22:40:02','2023-03-10 22:40:02',0),(11000015,22000001,70260777,'你好，宝贝还要吗',NULL,'2023-03-10 23:42:50','2023-03-10 23:42:50',0),(11000016,22000001,366602633,'在',NULL,'2023-03-10 23:46:59','2023-03-10 23:46:59',0),(11000017,22000001,70260777,'111',NULL,'2023-03-10 23:59:14','2023-03-10 23:59:14',0),(11000018,22000001,70260777,'666',NULL,'2023-03-10 23:59:17','2023-03-10 23:59:17',0),(11000019,22000001,366602633,'666',NULL,'2023-03-10 23:59:29','2023-03-10 23:59:29',0),(11000020,22000001,366602633,'在吗',NULL,'2023-03-11 04:25:56','2023-03-11 04:25:56',0),(11000021,22000001,70260777,'在',NULL,'2023-03-11 04:26:13','2023-03-11 04:26:13',0),(11000022,22000001,70260777,'早上好',NULL,'2023-03-11 04:26:55','2023-03-11 04:26:55',0),(11000023,22000001,366602633,'好好好',NULL,'2023-03-11 04:27:02','2023-03-11 04:27:02',0),(11000024,22000001,70260777,'15165156',NULL,'2023-03-11 23:20:58','2023-03-11 23:20:58',0),(11000025,22000001,70260777,'111',NULL,'2023-03-21 05:02:48','2023-03-21 05:02:48',0),(11000026,22000001,366602633,'111',NULL,'2023-03-21 05:02:57','2023-03-21 05:02:57',0),(11000027,22000001,70260777,'dsadsa',NULL,'2023-03-21 07:38:14','2023-03-21 07:38:14',0),(11000029,22000001,366602633,NULL,NULL,'2023-04-13 15:41:41','2023-04-13 15:41:41',0),(11000030,22000001,70260777,NULL,NULL,'2023-04-13 15:41:57','2023-04-13 15:41:57',0),(11000031,22000001,366602633,NULL,NULL,'2023-04-13 15:42:00','2023-04-13 15:42:00',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=33000082 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='存储加密后的消息内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_content`
--

LOCK TABLES `message_content` WRITE;
/*!40000 ALTER TABLE `message_content` DISABLE KEYS */;
INSERT INTO `message_content` VALUES (33000001,11000001,186685337576,1644754232,0),(33000002,11000001,351977296158,96167261487,1),(33000003,11000002,231645608796,302366024579,0),(33000004,11000002,285580988671,29029147750,1),(33000005,11000002,48032614631,147591837845,2),(33000006,11000003,292505950890,52897395552,0),(33000007,11000003,155523397261,270520040633,1),(33000008,11000004,16243018423,34868422981,0),(33000009,11000004,99846100618,205704164764,1),(33000010,11000004,77078548062,264351309230,2),(33000011,11000005,217724785394,199196093997,0),(33000012,11000005,248874971023,240962267639,1),(33000013,11000006,93211693675,24941644365,0),(33000014,11000006,62721266661,182497255794,1),(33000015,11000006,223470355058,114959621860,2),(33000016,11000007,195609523612,107300031417,0),(33000017,11000007,269373387068,119602805432,1),(33000018,11000008,43342652659,273135503759,0),(33000019,11000008,71844593059,185145200857,1),(33000020,11000008,62192120511,41748281147,2),(33000021,11000009,320087777302,4055667270,0),(33000022,11000009,218637602278,174610765671,1),(33000023,11000010,129668981233,359398633972,0),(33000024,11000010,30934938646,326244446214,1),(33000025,11000010,226075812582,101146069469,2),(33000026,11000011,127725049370,117196317463,0),(33000027,11000011,93973065163,617758680,1),(33000028,11000011,119618628200,180921601803,2),(33000029,11000011,170755380331,23351839058,3),(33000030,11000012,266217807048,358816941895,0),(33000031,11000012,296406518966,20609014166,1),(33000032,11000013,127639750812,266433394872,0),(33000033,11000013,11615402759,307500920930,1),(33000034,11000013,120891708367,26325761221,2),(33000035,11000013,224034222526,268355324915,3),(33000036,11000013,148739663353,327351948462,4),(33000037,11000013,18922750258,269964408661,5),(33000038,11000014,253575822767,352707003279,0),(33000039,11000014,174927033790,339096193551,1),(33000040,11000014,213029472391,2190221285,2),(33000041,11000014,228528701249,142401530111,3),(33000042,11000014,237086827543,191094259110,4),(33000043,11000014,174158629161,124389713716,5),(33000044,11000014,121740762999,111650793411,6),(33000045,11000015,299649378226,117625202246,0),(33000046,11000015,57438716103,125982450320,1),(33000047,11000015,99464741230,56535866802,2),(33000048,11000015,189758042351,122746470683,3),(33000049,11000015,109105958429,301556172244,4),(33000050,11000015,189449810947,234685905442,5),(33000051,11000015,166676664450,318226813128,6),(33000052,11000015,265736910715,257742112666,7),(33000053,11000016,94733041499,196067925064,0),(33000054,11000017,228595278985,139839847066,0),(33000055,11000018,299892726986,254279470670,0),(33000056,11000019,264653393492,97443376104,0),(33000057,11000020,36509092200,351203243330,0),(33000058,11000020,322819654326,43541271128,1),(33000059,11000021,249049301746,32175518025,0),(33000060,11000022,96116866137,229064378528,0),(33000061,11000022,262734686707,358308600042,1),(33000062,11000022,281453912381,185144148270,2),(33000063,11000023,49495708164,8026188276,0),(33000064,11000023,206376534932,86519544689,1),(33000065,11000023,71463009599,291275420395,2),(33000066,11000024,232732511133,69204162883,0),(33000067,11000024,346301274833,192506582552,1),(33000068,11000024,99681023340,303318264641,2),(33000069,11000025,352131069480,316496010853,0),(33000070,11000026,57202507962,98317094919,0),(33000071,11000027,2398310984,39236510094,0),(33000072,11000027,2723619778,130952282587,1),(33000073,11000029,252324483544,240379485439,0),(33000074,11000029,113668294665,177888818102,1),(33000075,11000029,130289479175,263058111927,2),(33000076,11000030,81552335056,333065024384,0),(33000077,11000030,333044617578,196955410838,1),(33000078,11000030,96134175526,47573145667,2),(33000079,11000031,53543399054,219092311843,0),(33000080,11000031,16970791009,231646556145,1),(33000081,11000031,337672669899,365637954058,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=100052 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='机型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (100001,1001,'iPhone 14 Pro Max','灵动的 iPhone 新玩法，迎面而来。重大的安全新功能，为拯救生命而设计。创新的 4800 万像素主摄，让细节纤毫毕现。更有 iPhone 芯片中的速度之王，为一切提供强大原动力。',70260777,999,'2023-02-24 07:57:38','2023-02-24 07:57:42',1,0),(100002,1001,'iPhone 14 Pro','灵动的 iPhone 新玩法，迎面而来。重大的安全新功能，为拯救生命而设计。创新的 4800 万像素主摄，让细节纤毫毕现。更有 iPhone 芯片中的速度之王，为一切提供强大原动力。',70260777,0,'2023-02-24 07:57:38','2023-03-21 04:49:24',5,0),(100008,1004,'16英寸 MacBook Pro',NULL,366602633,0,'2023-02-26 09:21:33','2023-02-28 12:38:57',2,0),(100009,1004,'14英寸 MacBook Pro',NULL,366602633,0,'2023-02-26 09:21:31','2023-02-28 12:39:02',2,0),(100010,1004,'13英寸 MacBook Pro',NULL,366602633,57,'2023-02-24 07:57:38','2023-02-28 12:38:13',2,0),(100012,1001,'iPhone 13 mini','5.4 英寸超视网膜 XDR 显示屏¹\n先进的双摄系统可拍摄惊艳的低光照片和视频\n配备 4 核图形处理器的 A15 仿生，速度快如闪电',366602633,874,'2023-02-24 07:57:38','2023-02-28 10:10:47',2,0),(100013,1001,'iPhone 13','6.1 英寸超视网膜 XDR 显示屏¹\n先进的双摄系统可拍摄惊艳的低光照片和视频\n配备 4 核图形处理器的 A15 仿生，速度快如闪电',366602633,64,'2023-02-24 07:57:38','2023-02-28 10:12:31',2,0),(100014,1001,'iPhone SE','4.7 英寸高清视网膜显示屏 脚注¹，明亮、绚丽又锐利\n超强 A15 仿生，iPhone 13 同款芯片\n5G 网络，畅享高速下载和高品质流媒体播放 脚注²',366602633,978,'2023-02-24 07:57:38','2023-02-28 10:13:26',2,0),(100015,1004,'Mac Book Air M1','搭载 M1 芯片的 MacBook Air 是一款实力出众的轻便型笔记本电脑。不仅又快又轻巧，还采用静谧的无风扇设计，并配备绚丽的视网膜显示屏。这样的纤薄外形，再加上从早用到晚的电池续航，你能轻轻松松带着这部 MacBook Air 随身而行，随时出手。',366602633,78,'2023-02-28 12:33:23','2023-02-28 12:36:01',1,0),(100016,1004,'Mac Book Air M2','全新 MacBook Air 以新一代芯片 M2 为核心重新打造，超薄形态再进化，性能和能效更非凡，并将一切融于坚固耐用的全铝金属机身之中。有这台速度超快、实力超强的笔记本电脑飘然在手，工作、娱乐和创作，随时随地尽情来。',366602633,465,'2023-02-28 12:37:12','2023-02-28 12:37:26',1,0),(100017,1004,'Mac Book Air M2','全新 MacBook Air 以新一代芯片 M2 为核心重新打造，超薄形态再进化，性能和能效更非凡，并将一切融于坚固耐用的全铝金属机身之中。有这台速度超快、实力超强的笔记本电脑飘然在手，工作、娱乐和创作，随时随地尽情来。',366602633,787,'2023-03-01 19:50:32','2023-03-01 19:50:32',0,0),(100031,1001,'Xiaomi 13','「购机至高享24期免息，+199得50W立式无线充Pro」第二代骁龙8｜徕卡专业光学镜头｜徕卡原生双画质｜徕卡75mm长焦 | 超窄边屏幕｜67W澎湃秒充',366602633,5867,'2023-03-02 06:00:29','2023-03-02 06:00:29',0,0),(100034,1001,'Galaxy S23 Ultra','三星全新机型',366602633,555,'2023-03-02 07:53:33','2023-03-02 07:53:33',0,0),(100035,1002,'Redmi X65 65英寸L65R8-X','双120Hz高刷屏 | HDMI 2.1接口 | 3GB+32GB',366602633,424,'2023-03-02 15:22:10','2023-03-02 15:22:10',0,0),(100036,1003,'速冷静 米家空调 1.5匹新3级能效','强劲动力，舒适速享',366602633,557,'2023-03-02 15:30:55','2023-03-02 15:30:55',0,0),(100037,1004,'ROG枪神7','2023新品！为信仰而战！为游戏而生！',366602633,99999,'2023-03-02 15:37:35','2023-03-02 15:37:35',0,0),(100038,1005,'Redmi Pad','入门平板，三大升级｜屏幕升级:90Hz高刷护眼屏｜外观升级:全金属一体化机身｜系统升级:MIUI Pad大屏定制系统',366602633,0,'2023-03-02 15:44:45','2023-03-02 15:44:45',0,0),(100039,1001,'Xiaomi 13 限量定制色','「购机至高享24期免息，+199得50W立式无线充Pro」第二代骁龙8｜徕卡专业光学镜头｜徕卡原生双画质｜徕卡75mm长焦 | 超窄边屏幕｜67W澎湃秒充',366602633,0,'2023-03-03 05:15:00','2023-03-03 05:15:00',0,0),(100040,1005,'小米平板5','骁龙860芯片 | 2.5K超清屏 | 120Hz高刷新率｜8720mAh大电池',366602633,0,'2023-03-03 07:30:38','2023-03-03 07:30:38',0,0),(100041,1003,'巨省电 米家空调 1.5匹新1级能效 睡眠版','强劲制冷 | 安静舒适 | 智能互联',366602633,0,'2023-03-08 20:41:19','2023-03-08 20:41:19',0,0),(100043,1004,'Xiaomi Book Air 13','薄至约12mm 时尚超薄 | 2.8K OLED 大师触控屏，音画双绝 | 高端百变翻转屏 | 小米妙享PC版 |英特尔 Evo认证',366602633,0,'2023-03-08 21:00:39','2023-03-08 21:00:39',0,0),(100044,1006,'小米手环7','1.62″AMOLED 跑道屏 | 四大专业运动数据分析 | 全天连续血氧饱和度监测',366602633,0,'2023-03-08 21:10:10','2023-03-08 21:10:10',0,0),(100045,1004,'Redmi G Pro 游戏本 2022 锐龙版','R7 6800H｜RTX 3060｜16\" 2.5K 240Hz',366602633,0,'2023-03-08 21:15:08','2023-03-08 21:15:08',0,0),(100046,1002,'小米电视6 OLED系列','4K OLED,更薄更清晰,0nit极夜黑,低蓝光认证,全场景互联',366602633,0,'2023-03-08 21:18:49','2023-03-08 21:18:49',0,0),(100047,1007,'Xiaomi Buds 4','年度旗舰半入耳降噪耳机',366602633,0,'2023-03-08 21:22:09','2023-03-08 21:22:09',0,0),(100048,1003,'米家冰箱对开门610L墨羽岩','「以旧换新至高再省165元」春来你鲜尝，一次储够两周鲜！海量空间，一次储够两周鲜|墨羽岩面板，颜值出众|压缩机10年质保|风冷无霜不结冰|银离子抗菌净味|智能互联',366602633,0,'2023-03-08 21:25:17','2023-03-08 21:25:17',0,0),(100049,1008,'小米小爱音箱Play 增强版','内置红外遥控，一句话控制传统家电内置红外遥控，一句话控制传统家电 | LED时钟显示，自适应亮度调节',366602633,0,'2023-03-08 21:29:16','2023-03-08 21:29:16',0,0),(100050,1006,'iwatchs8','戴上苹果手表，更健康的你不再只是想象',70260777,0,'2023-03-11 10:33:14','2023-03-11 10:33:14',0,0),(100051,1007,'AirPods (第三代) - 配闪电充电盒','表情符号、名字、缩写和数字混合镌刻，打造你独一无二的专属 AirPods。Apple 独家福利。',70260777,0,'2023-03-11 10:40:53','2023-03-11 10:40:53',0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=1000107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='具体产品，model的进一级划分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1000001,1001,100001,8999,100,8999,'深空的黑色，藏着无尽的秘密',1,'深空黑色','128GB',NULL,NULL,NULL,NULL,666,524),(1000002,1001,100001,8999,100,8999,'低调高贵的银色，才能彰显出主人的气质',2,'银色','128GB',NULL,NULL,NULL,NULL,666,454),(1000003,1001,100001,8999,100,8999,'闪闪高贵的金色，衬托主人的品味',3,'金色','128GB',NULL,NULL,NULL,NULL,555,25),(1000004,1001,100001,8999,100,8999,'紫色，致命的性感，成熟的魅力',4,'暗紫色','128GB',NULL,NULL,NULL,NULL,666,4654),(1000005,1001,100001,9899,100,9899,'深空的黑色，藏着无尽的秘密',5,'深空黑色','256GB',NULL,NULL,NULL,NULL,666,56),(1000006,1001,100001,9899,100,9899,'低调高贵的银色，才能彰显出主人的气质',6,'银色','256GB',NULL,NULL,NULL,NULL,666,4242),(1000007,1001,100001,9899,100,9899,'闪闪高贵的金色，衬托主人的品味',7,'金色','256GB',NULL,NULL,NULL,NULL,666,4),(1000008,1001,100001,9899,100,9899,'紫色，致命的性感，成熟的魅力',8,'暗紫色','256GB',NULL,NULL,NULL,NULL,666,16),(1000009,1001,100001,11699,100,11699,'深空的黑色，藏着无尽的秘密',9,'深空黑色','512GB',NULL,NULL,NULL,NULL,666,11),(1000010,1001,100001,11699,100,11699,'低调高贵的银色，才能彰显出主人的气质',10,'银色','512GB',NULL,NULL,NULL,NULL,666,59),(1000011,1001,100001,11699,100,11699,'闪闪高贵的金色，衬托主人的品味',11,'金色','512GB',NULL,NULL,NULL,NULL,666,456),(1000012,1001,100001,11699,100,11699,'紫色，致命的性感，成熟的魅力',12,'暗紫色','512GB',NULL,NULL,NULL,NULL,666,48456),(1000013,1001,100001,13499,100,13499,'深空的黑色，藏着无尽的秘密',13,'深空黑色','1TB',NULL,NULL,NULL,NULL,666,222),(1000014,1001,100001,13499,100,13499,'低调高贵的银色，才能彰显出主人的气质',14,'银色','1TB',NULL,NULL,NULL,NULL,666,456),(1000015,1001,100001,13499,100,13499,'闪闪高贵的金色，衬托主人的品味',15,'金色','1TB',NULL,NULL,NULL,NULL,666,1548),(1000016,1001,100001,13499,100,13499,'紫色，致命的性感，成熟的魅力',16,'暗紫色','1TB',NULL,NULL,NULL,NULL,666,548),(1000020,1001,100002,7999,100,7999,'666',1,'暗紫色','128GB',NULL,NULL,NULL,NULL,666,489),(1000021,1001,100002,7999,100,7999,'666',2,'金色','128GB',NULL,NULL,NULL,NULL,666,45465),(1000023,1001,100002,7999,100,7999,'666',3,'银色','128GB',NULL,NULL,NULL,NULL,666,415),(1000024,1001,100002,7999,100,7999,'666',4,'深空黑色','128GB',NULL,NULL,NULL,NULL,666,458),(1000025,1001,100002,8899,100,8899,'666',5,'暗紫色','256GB',NULL,NULL,NULL,NULL,666,4),(1000026,1001,100002,8899,100,8899,'666',6,'金色','256GB',NULL,NULL,NULL,NULL,666,45),(1000027,1001,100002,8899,100,8899,'666',7,'银色','256GB',NULL,NULL,NULL,NULL,666,45),(1000028,1001,100002,8899,100,8899,'666',8,'深空黑色','256GB',NULL,NULL,NULL,NULL,666,456),(1000029,1001,100002,10699,100,10699,'666',9,'暗紫色','512GB',NULL,NULL,NULL,NULL,666,45645),(1000030,1001,100002,10699,100,10699,'666',10,'金色','512GB',NULL,NULL,NULL,NULL,666,415),(1000031,1001,100002,10699,100,10699,'666',11,'银色','512GB',NULL,NULL,NULL,NULL,666,45),(1000032,1001,100002,10699,100,10699,'666',12,'深空黑色','512GB',NULL,NULL,NULL,NULL,666,645),(1000033,1001,100002,12499,100,12499,'666',13,'暗紫色','1TB',NULL,NULL,NULL,NULL,666,45),(1000034,1001,100002,12499,100,12499,'666',14,'金色','1TB',NULL,NULL,NULL,NULL,666,456),(1000035,1001,100002,12499,100,12499,'666',15,'银色','1TB',NULL,NULL,NULL,NULL,666,45),(1000036,1001,100002,12499,100,12499,'666',16,'深空黑色','1TB',NULL,NULL,NULL,NULL,666,4889),(1000037,1004,100015,7999,100,7999,'选择你的新款 MacBook Air M1',1,'深空灰色','8 核中央处理器','7 核图形处理器','8GB 统一内存','256GB 固态硬盘¹','赠送airpods 3',666,456),(1000038,1004,100015,7999,100,7999,'选择你的新款 MacBook Air M1',2,'金色','8 核中央处理器','7 核图形处理器','8GB 统一内存','256GB 固态硬盘¹','赠送airpods 3',666,415),(1000039,1004,100015,7999,100,7999,'选择你的新款 MacBook Air M1',3,'银色','8 核中央处理器','7 核图形处理器','8GB 统一内存','256GB 固态硬盘¹','赠送airpods 3',666,456),(1000063,1001,100031,4599,100,4599,'',1,'黑色','12GB+256GB',NULL,NULL,NULL,'',354,48),(1000064,1001,100031,3999,100,3999,'',2,'黑色','8GB+128GB',NULL,NULL,NULL,'',159,45),(1000065,1001,100031,4299,100,4299,'',3,'黑色','8GB+256GB',NULL,NULL,NULL,'',651,156),(1000070,1001,100034,8999,95,8549,'赠送商品，送完即止',1,'黑色','256GB|8GB',NULL,NULL,NULL,'赠送三星蓝牙耳机',666,122),(1000071,1001,100034,12699,100,12699,'至尊顶配版',2,'红色','1TB|12GB',NULL,NULL,NULL,'',3333,1545),(1000072,1002,100035,2899,100,2899,'65英寸，超高分辨率，巨爽！！',1,'蓝色','65英寸',NULL,NULL,NULL,'赠送智能音响2台',360,79),(1000073,1003,100036,1999,100,1999,'强劲变频，节能新标准！！',1,'白色',NULL,NULL,NULL,NULL,'',366,6765),(1000074,1004,100037,14999,100,14999,'双显三模！DDR5内存！三风扇散热！2.5K星云屏！新液金导热！',1,'黑色','i9-13980HX','1TB','RTX4070','16GB','rog背包',120,775),(1000075,1004,100037,11999,100,11999,'全新40系显卡，让你快人一步！！',2,'黑色','i9-13980HX','1TB','RTX4060','16G','rog鼠标垫',331,67),(1000076,1005,100038,1499,100,1499,'基础配置，价格实惠！',1,'烟青绿','6GB+128GB',NULL,NULL,NULL,'',333,3543),(1000077,1005,100038,1299,100,1299,'',2,'烟青绿','4GB+128GB',NULL,NULL,NULL,'',231,544),(1000078,1005,100038,1799,100,1799,'至尊配置，学习和娱乐都在行',3,'烟青绿','8GB+128GB',NULL,NULL,NULL,'小米专属电子笔',543,66),(1000079,1005,100038,1799,100,1799,'至尊配置，学习和娱乐都在行',4,'银色','8GB+128GB',NULL,NULL,NULL,'小米专属电子笔',435,66),(1000080,1005,100038,1799,100,1799,'至尊配置，学习和娱乐都在行',5,'银色','8GB+128GB',NULL,NULL,NULL,'小米专属电子笔',435,80),(1000081,1001,100039,4999,100,4999,'',1,'飓风黄','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',111,0),(1000082,1001,100039,4999,100,4999,'',2,'宝石蓝','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',222,0),(1000083,1001,100039,4999,100,4999,'',3,'丛林绿','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',333,0),(1000084,1001,100039,4999,100,4999,'',4,'烈焰红','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',321,0),(1000085,1001,100039,4999,100,4999,'',5,'水泥灰','12GB+512GB',NULL,NULL,NULL,'价值249元米家水离子护发吹风机 H500x1，赠完即止',123,0),(1000086,1005,100040,1999,90,1799,'',1,'黑色','6GB+128GB',NULL,NULL,NULL,'价值69元小米33W充电器套装 第二代 白色x1，赠完即止',0,0),(1000087,1005,100040,2299,90,2069,'',2,'绿色','6GB+256GB',NULL,NULL,NULL,'价值69元小米33W充电器套装 第二代 白色x1，赠完即止',0,0),(1000088,1005,100040,2599,90,2339,'',3,'白色','8GB+256GB',NULL,NULL,NULL,'价值69元小米33W充电器套装 第二代 白色x1，赠完即止',0,0),(1000089,1003,100041,2399,92,2199,'小米自营',1,'白色',NULL,NULL,NULL,NULL,'',1399,0),(1000090,1004,100043,5999,83,4999,'',1,'白色','i5','512G','Xe','16G','',1351,0),(1000091,1004,100043,6999,85,5999,'',2,'白色','i7','512G','Xe','16G','',0,0),(1000092,1006,100044,249,83,209,'',1,'夜跃黑',NULL,NULL,NULL,NULL,'',777,0),(1000093,1006,100044,249,83,209,'',2,'舒展蓝',NULL,NULL,NULL,NULL,'',543,0),(1000094,1006,100044,249,83,209,'',3,'悦活粉',NULL,NULL,NULL,NULL,'',111,0),(1000095,1004,100045,8799,79,6999,'',1,'战舰灰','R7 6800H','512G','RTX 3060','16G','价值199元定制简约双肩包 灰色x1，赠完即止',134,0),(1000096,1002,100046,4999,95,4799,'',1,'黑色','55英寸',NULL,NULL,NULL,'',1344,0),(1000097,1002,100046,6999,95,6699,'',2,'黑色','65英寸',NULL,NULL,NULL,'下单立减700元',2110,0),(1000098,1007,100047,699,100,699,'',1,'月影黑',NULL,NULL,NULL,NULL,'',2131,0),(1000099,1007,100047,699,100,699,'',2,'盐湖白',NULL,NULL,NULL,NULL,'',3221,0),(1000100,1007,100047,699,100,699,'',3,'旷野绿',NULL,NULL,NULL,NULL,'',411,0),(1000101,1003,100048,2799,89,2499,'',1,'墨羽岩',NULL,NULL,NULL,NULL,'',3411,0),(1000102,1008,100049,149,100,149,'',1,'黑色',NULL,NULL,NULL,NULL,'',1231,0),(1000103,1006,100050,2999,100,2999,'了解更多表带类型，尝试不同表壳材质。Apple Watch 定制坊让你充分展现个人风格。',1,'Black Unity 41mm',NULL,NULL,NULL,NULL,'Black Unity表带',1311,0),(1000104,1006,100050,3199,100,3199,'',2,'彩虹版 45mm',NULL,NULL,NULL,NULL,'彩虹表带',321,0),(1000105,1007,100051,1349,100,1349,'免费赠送镌刻服务',1,'白色-闪电充电盒',NULL,NULL,NULL,NULL,'免费镌刻服务',377,0),(1000106,1007,100051,1399,100,1399,'免费赠送镌刻服务',2,'白色-MagSafe充电盒',NULL,NULL,NULL,NULL,'免费镌刻服务',241,0);
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
  `type` smallint DEFAULT NULL COMMENT '1、商品；2、文章；3、用户',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `star_product_id_fk` (`foreign_id`),
  KEY `star_user_id_fk` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `star`
--

LOCK TABLES `star` WRITE;
/*!40000 ALTER TABLE `star` DISABLE KEYS */;
INSERT INTO `star` VALUES (64,70260777,100039,2,'2023-03-08 18:59:31','2023-03-08 18:59:31',0),(66,70260777,100035,2,'2023-03-08 18:59:47','2023-03-08 18:59:47',0),(68,70260777,100031,2,'2023-03-08 19:00:01','2023-03-08 19:00:01',0),(72,366602633,100044,2,'2023-03-09 18:49:21','2023-03-09 18:49:21',0),(73,366602633,100049,2,'2023-03-09 18:49:27','2023-03-09 18:49:27',0),(74,366602633,100046,2,'2023-03-09 19:05:47','2023-03-09 19:05:47',0),(75,366602633,100035,2,'2023-03-09 19:05:54','2023-03-09 19:05:54',0),(76,366602633,100040,2,'2023-03-09 20:05:02','2023-03-09 20:05:02',0),(77,366602633,100038,2,'2023-03-09 20:05:06','2023-03-09 20:05:06',0),(78,366602633,100047,2,'2023-03-09 20:06:17','2023-03-09 20:06:17',0),(79,366602633,100043,2,'2023-03-09 20:06:26','2023-03-09 20:06:26',0),(80,366602633,100045,2,'2023-03-09 20:06:31','2023-03-09 20:06:31',0),(83,70260777,100051,2,'2023-03-11 23:12:47','2023-03-11 23:12:47',0),(84,70260777,100048,2,'2023-03-11 23:12:53','2023-03-11 23:12:53',0),(86,70260777,100049,2,'2023-03-18 07:59:47','2023-03-18 07:59:47',0),(114,70260777,11000006,1,'2023-03-19 05:28:58','2023-03-19 05:28:58',0),(117,70260777,100046,2,'2023-03-21 04:12:10','2023-03-21 04:12:10',0),(118,70260777,100002,2,'2023-03-21 05:00:46','2023-03-21 05:00:46',0);
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
  `state` smallint DEFAULT NULL COMMENT '订单状态：1，下单，未付；2，已付，未收到；3，收到；4，退货中；5，交易完成；6，订单关闭',
  `version` bigint DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='交易表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES (70000002,70260777,70000001,5,16695,0,0,NULL,NULL,'2023-03-07 23:53:54','2023-03-11 07:49:34',2,1),(70000003,70260777,70000002,2,6898,0,0,NULL,NULL,'2023-03-07 23:58:56','2023-03-11 07:49:15',2,1),(70000004,70260777,70000002,2,6898,0,0,NULL,NULL,'2023-03-07 23:59:40','2023-03-07 23:59:40',1,1),(70000005,70260777,70000001,4,12696,0,0,NULL,NULL,'2023-03-08 00:00:11','2023-03-08 00:00:11',1,1),(70000006,70260777,70000001,2,6898,0,0,NULL,NULL,'2023-03-08 00:02:17','2023-03-08 00:02:17',1,1),(70000007,70260777,70000001,2,6898,0,0,NULL,NULL,'2023-03-08 00:03:45','2023-03-08 00:03:45',1,1),(70000008,70260777,70000001,2,6898,0,0,NULL,NULL,'2023-03-08 00:04:05','2023-03-21 06:52:04',6,1),(70000009,70260777,70000002,3,5147,600,0,NULL,NULL,'2023-03-11 10:45:32','2023-03-11 10:45:40',2,2),(70000010,70260777,70000002,2,4998,600,0,NULL,NULL,'2023-03-11 23:13:01','2023-03-11 23:14:26',2,2),(70000011,70260777,70000002,2,298,0,0,NULL,NULL,'2023-03-13 15:02:12','2023-03-21 07:02:32',3,3),(70000012,70260777,70000006,2,5398,300,0,NULL,NULL,'2023-03-21 07:36:24','2023-03-21 07:36:24',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=50000021 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_detail`
--

LOCK TABLES `trade_detail` WRITE;
/*!40000 ALTER TABLE `trade_detail` DISABLE KEYS */;
INSERT INTO `trade_detail` VALUES (50000001,70000002,0,366602633,1000064,3999,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000002,70000002,1,366602633,1000072,2899,0,3,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000003,70000003,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000004,70000003,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000005,70000004,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000006,70000004,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000007,70000005,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000008,70000005,1,366602633,1000072,2899,0,3,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000009,70000006,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000010,70000006,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000011,70000007,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000012,70000007,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000013,70000008,0,366602633,1000064,3999,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/dcabcb1fb5804b968b8b870704e4d92a.png'),(50000014,70000008,1,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000015,70000009,0,366602633,1000102,149,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/89ab24c0d8fb42d0a0f7b857799c48d5.jpg'),(50000016,70000009,1,366602633,1000101,2499,300,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg'),(50000017,70000010,0,366602633,1000101,2499,300,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg'),(50000018,70000011,0,366602633,1000102,149,0,2,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/89ab24c0d8fb42d0a0f7b857799c48d5.jpg'),(50000019,70000012,0,366602633,1000072,2899,0,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/2f95824ced4c4fbba6f97b13d1474ee1.jpg'),(50000020,70000012,1,366602633,1000101,2499,300,1,0,'https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/testUpload/b24a24eccd404000af597b104f09f9d6.jpg');
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
INSERT INTO `user` VALUES (70260777,'天天7','70260777','3b31a3bb4e24bcb10b71909de39a49e0974fd3ed5a83d1d0fb6ae04326720a29','70260777@qq.com','https://e-shop-oss.oss-cn-hangzhou.aliyuncs.com/images/users/50000001/avatar/9f7b4ca174524ef29026e6062806271d.jpg',100,0,949268,1,1,'2023-02-23 07:57:38','2023-03-13 15:02:17',24),(366602633,'天天366','366602633','3b31a3bb4e24bcb10b71909de39a49e0974fd3ed5a83d1d0fb6ae04326720a29','366602633@qq.com',NULL,100,0,999999,0,NULL,'2023-02-23 07:57:38','2023-02-24 07:57:38',1),(1629740934187651075,'李瑞之','liruizhi','3b31a3bb4e24bcb10b71909de39a49e0974fd3ed5a83d1d0fb6ae04326720a29','qq366602633@163.com',NULL,0,0,0,0,NULL,'2023-02-27 04:01:01','2023-02-27 04:01:01',0);
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

-- Dump completed on 2023-04-13 23:44:21
