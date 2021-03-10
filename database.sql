-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 121.37.129.14    Database: kunpeng
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `ActID` int NOT NULL AUTO_INCREMENT,
  `Act_Title` varchar(100) NOT NULL,
  `Act_Content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `Act_Publish_Time` datetime NOT NULL,
  `Act_Author` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Act_Attachment` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `Act_Undefined` varchar(8) DEFAULT NULL,
  `Act_Author_ID` int NOT NULL,
  PRIMARY KEY (`ActID`) USING BTREE,
  KEY `activity_admin_Ad_no_fk` (`Act_Author_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'桂工兄弟来啦！','<h1>\r\n	桂工兄弟来啦！\r\n</h1>\r\n<p>\r\n	<img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/0756c9a3f7080e646fb31e75b6cc2735.gif\" /><span style=\"color:#64451D;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;\">亲爱的宅男腐女们，喜欢看“Running Men”吗？喜欢看“奔跑吧！兄弟”吗？想要亲身体验奔跑的赶脚吗?鲲鹏素拓满足你！</span><span style=\"color:#64451D;font-family:Arial, &quot;font-size:14px;background-color:#FFFF00;\">桂工版Running Man强势来袭！</span><span style=\"color:#64451D;font-family:Arial, &quot;font-size:14px;background-color:#FFFF00;\">这是一场心理与体质的较量，这是一场团队的战斗。层层闯关游戏等你来挑战！</span>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#FFFFFF;\"><span><span style=\"color:#64451D;\">活动对象</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/1d55918ecf6d12a5196ebe3a0af882b2.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/1d55918ecf6d12a5196ebe3a0af882b2.gif\" /></span></span><span style=\"color:#F79646;\"><span style=\"color:#64451D;\">：</span><span style=\"color:#64451D;\">全校师生</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#FFFFFF;\"><span style=\"color:#64451D;\">奖励</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/04c465fb7a9f6914d6f6ae3eb727052b.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/04c465fb7a9f6914d6f6ae3eb727052b.gif\" /></span><span style=\"color:#F79646;\"><span style=\"color:#64451D;\">：</span><span style=\"color:#64451D;\">“最强战队”冠军：200RMB+奖状</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\">&nbsp; &nbsp;</span><span><span style=\"color:#64451D;\">&nbsp;</span><span style=\"color:#F79646;\"></span></span><span style=\"color:#64451D;\">“最强战队”亚军：150RMB+奖状</span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#F79646;\"><span style=\"color:#64451D;\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"color:#64451D;\">“最强战队”季军：100RMB+奖状</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\"><span style=\"color:#64451D;\">“十佳队长”：相框+奖状</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\"><span style=\"color:#64451D;\">“最佳人气奖 ”牛奶+奖状</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#FFFFFF;\"><span style=\"color:#64451D;\">设点报名</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/084d81de3e6cc71d4f79e1837b293fa0.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/084d81de3e6cc71d4f79e1837b293fa0.gif\" /><span style=\"color:#64451D;\">：</span></span><span style=\"color:#64451D;\">5月18日一号食堂</span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#F79646;\"><span style=\"color:#64451D;\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"color:#64451D;\">5月19日二号食堂</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#FFFFFF;\"><span><span style=\"color:#64451D;\">参赛形式</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/7de2dcac85040d2caa7776be64ee6814.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/7de2dcac85040d2caa7776be64ee6814.gif\" /></span></span><span style=\"color:#64451D;\">：自由组队，六人一组（凑不够队友肿么办，加群432175480，找到萌哒哒的队友）</span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#FFFFFF;\"><span style=\"color:#64451D;\">初赛时间地点及项目</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/5b93a3bf19211875a32103b1731b671e.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/5b93a3bf19211875a32103b1731b671e.gif\" /><span style=\"color:#64451D;\">：</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\"><span style=\"color:#64451D;\">5月24日 &nbsp; 风雨操场 &nbsp;</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\"><span style=\"color:#64451D;\">六人七足 &nbsp;同心横杆 &nbsp;合力乒乓 &nbsp;数独达人</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#FFFFFF;\"><span style=\"color:#64451D;\">决赛时间地点及项目</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/6318b6cdb7b73c511cde49f039f5deaa.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/6318b6cdb7b73c511cde49f039f5deaa.gif\" /><span style=\"color:#64451D;\">：</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\"><span style=\"color:#64451D;\">5月26日 &nbsp; 风雨操场 &nbsp; &nbsp;</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;text-align:center;\">\r\n		<span style=\"color:#64451D;\"><span style=\"color:#64451D;\">跳行长蛇 &nbsp;蒙眼投球 &nbsp;顺序翻牌 &nbsp;合作拼图</span></span>\r\n	</p>\r\n	<p style=\"color:#333333;font-family:Arial, &quot;font-size:14px;background-color:#FFFFFF;\">\r\n		<span style=\"color:#F79646;\"><span style=\"color:#FFFFFF;\"><span style=\"color:#64451D;\">&nbsp; &nbsp;你还在等什么，带上你的好基友好闺蜜，组队参加吧！我们设点宣传，你们报名参加，我们不见不散！</span><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/59d87483a356e4874389c21a5a94c0bc.gif\" /><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/p/img_t_sinajs_cn/59d87483a356e4874389c21a5a94c0bc.gif\" /><span style=\"color:#64451D;\">&nbsp;</span></span></span>\r\n	</p>\r\n</p>\r\n<p>\r\n	<img src=\"https://ww4.sinaimg.cn/mw690/005DYSw1gw1es3qrmwbzmj30f00qowfq.jpg\" />\r\n</p>','2020-10-19 14:23:34','李海','wais://kjszq.se/lmfhik',NULL,1),(2,'测试','测试a','2020-10-19 19:38:25','李海',NULL,NULL,1),(3,'测试','测试b','2020-10-19 19:38:25','李海',NULL,NULL,1),(4,'测试','测试c','2020-10-19 19:38:25','李海','',NULL,1),(5,'测试','测试d','2020-10-19 19:38:25','李海',NULL,NULL,1),(6,'测试','测试e','2020-10-19 19:38:25','李海',NULL,NULL,1),(7,'鲲鹏素拓协会成员内部集训','鲲鹏素拓协会成员内部集训:为了加强协会内部协作能力、加深协会成员对素拓游戏的理解，4月12日下午，鲲鹏素拓协会成员在心理活动室内开展了一次趣味横生的素质拓展活动。https://ww4.sinaimg.cn/mw690/005DYSw1jw1er4bo4agj8j30c813kk5e.jpg','2015-04-13 22:43:01','李海','https://weibo.com/u/5171450505?is_all=1#_rnd1602836327957',NULL,1),(8,'测试','测试f','2020-10-19 19:38:25','李海',NULL,NULL,1),(9,'(s9V@I','VTKM4$','2006-09-08 00:00:00','吴磊','http://ggujufxid.et/jihnr',NULL,10971953),(10,'(s9V@Ia','VTKM4$','2006-09-08 00:00:00','吴磊','http://ggujufxid.et/jihnr',NULL,10971953),(11,'&5z6O','[kEAX','2003-11-15 00:00:00','朱平','nntp://hokklpyi.mo/shdzxcydi',NULL,23763879),(12,'qqqqqqq','<p>欢迎来到全新编辑器，测试测试</p>','2020-10-20 00:00:00','萧静','',NULL,4),(13,'5365635','欢迎来到全新编辑器','2020-10-20 00:00:00','罗静','',NULL,3),(14,'5365635','<p>欢迎来到全新编辑器sf朱晓</p>','2020-10-20 00:00:00','罗静','',NULL,3),(15,'J!s[@','bdN','2009-09-03 00:00:00','史刚','nntp://pnihmig.mp/pllmqaex',NULL,-92957482),(16,'西部支援计划','西部支援计划不存在！','2020-10-21 07:37:22','黄晓明','www.bing.com',NULL,666),(17,'西部支援计划','西部支援计划不存在！','2020-10-21 07:50:44','黄晓明','www.bing.com',NULL,666),(18,'西部支援计划','西部支援计划不存在！','2020-10-21 07:55:08','黄晓明','www.bing.com',NULL,666),(19,'西部支援计划','西部支援计划不存在！','2020-10-21 08:22:21','黄晓明','www.bing.com',NULL,666),(20,'西部支援计划','西部支援计划不存在！','2020-10-21 08:34:34','黄晓明','www.bing.com',NULL,666),(21,'J!s[@','bdN','2009-09-03 00:00:00','史刚','nntp://pnihmig.mp/pllmqaex',NULL,-92957482),(22,'活动','<p>活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动</p>','2020-10-22 00:00:00','李海','',NULL,1),(23,'西部支援计划','西部支援计划不存在！','2020-10-22 12:46:38','黄晓明','www.bing.com',NULL,666),(24,'西部支援计划','西部支援计划不存在！','2020-10-22 14:49:43','黄晓明','www.bing.com',NULL,666),(25,'dds','欢迎来到全新编辑器','2020-10-23 00:00:00','郭艳','',NULL,13),(26,'dds','欢迎来到全新编辑器','2020-10-23 00:00:00','郭艳','',NULL,13),(27,'aa','<p>欢迎来到全新编辑器qqqqq</p>','2020-10-23 00:00:00','郭艳','',NULL,13),(28,'a','<p>欢迎来到全新编辑器sss</p>','2020-10-23 00:00:00','郭艳','',NULL,13),(29,'西部支援计划','西部支援计划不存在！','2020-11-03 13:00:44','黄晓明','www.bing.com',NULL,666),(30,'西部支援计划','西部支援计划不存在！','2020-11-03 13:24:31','黄晓明','www.bing.com',NULL,666),(31,'西部支援计划','西部支援计划不存在！','2020-11-03 13:39:26','黄晓明','www.bing.com',NULL,666);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `Ad_id` int NOT NULL AUTO_INCREMENT,
  `Ad_no` varchar(30) NOT NULL,
  `Ad_name` varchar(8) NOT NULL,
  `Ad_College` varchar(25) DEFAULT NULL,
  `Ad_password` varchar(100) NOT NULL,
  `Ad_Sex` varchar(2) DEFAULT NULL,
  `Ad_Portrait` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `Ad_age` int DEFAULT NULL,
  `Ad_authority` varchar(8) DEFAULT '0',
  PRIMARY KEY (`Ad_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'3172051051733','李海','机械与控制工程学院','f140e7c87d4874312f4167a7bad31d48','男',NULL,21,'1'),(12,'3172051052711','唐敏','环境科学与工程学院','f140e7c87d4874312f4167a7bad31d48','女',NULL,23,'0'),(13,'3172051051719','郭艳','机械与控制工程学院','f140e7c87d4874312f4167a7bad31d48','女',NULL,22,'0');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `CmtID` int NOT NULL AUTO_INCREMENT,
  `ActID` int DEFAULT NULL,
  `Sno` int DEFAULT NULL,
  `Cmt_Date` datetime NOT NULL,
  `Cmt_Content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cmt_Sname` varchar(8) NOT NULL,
  PRIMARY KEY (`CmtID`),
  KEY `comment_activity_ActID_fk` (`CmtID`) USING BTREE,
  KEY `comment_activity_ActID_fks` (`ActID`),
  CONSTRAINT `comment_activity_ActID_fks` FOREIGN KEY (`ActID`) REFERENCES `activity` (`ActID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (24,2,165,'2020-10-19 11:43:18','oAZpf','廖秀英'),(27,2,-362127160,'2020-10-19 14:27:00','E[z9','武艳'),(30,1,327327780,'2020-10-20 02:27:31','xh@Y','李强'),(32,1,1234567890,'2020-10-21 07:37:24','日批，亲嘴','a'),(33,1,1234567890,'2020-10-21 07:50:49','日批，亲嘴','b'),(34,1,1234567890,'2020-10-21 07:55:10','日批，亲嘴','c'),(35,1,1234567890,'2020-10-21 08:22:23','日批，亲嘴','d'),(37,1,123456789,'2020-10-21 08:30:11','7TTKUT5','刘平'),(38,1,1234567890,'2020-10-21 08:34:37','日批，亲嘴','e'),(40,NULL,123456789,'2020-10-22 03:18:07','dfddsf','k朱xx'),(41,1,1234567890,'2020-10-22 12:46:40','日批，亲嘴','忠'),(42,23,123456789,'2020-10-22 14:14:22','sdfsfs','k朱xx'),(43,20,123456789,'2020-10-22 14:27:38','测试无id 评论','k朱xx'),(44,20,123456789,'2020-10-22 14:35:52','评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论评论','k朱xx'),(45,20,158,'2020-10-22 14:43:33','qqqqqqqqqqqqqq','武秀兰'),(46,20,158,'2020-10-22 14:43:34','qqqqqqqqqqqqqq','武秀兰'),(47,20,158,'2020-10-22 14:43:34','qqqqqqqqqqqqqq','武秀兰'),(48,1,1234567890,'2020-10-22 14:49:46','日批，亲嘴','骚忠'),(49,NULL,158,'2020-10-23 01:16:22','ccccc','郭艳'),(50,NULL,158,'2020-10-23 01:16:27','wwww','郭艳'),(51,1,158,'2020-10-23 01:32:34','评论','武秀兰'),(53,1,1234567890,'2020-11-03 13:00:46','日批，亲嘴','骚忠'),(54,1,1234567890,'2020-11-03 13:24:33','日批，亲嘴','骚忠'),(55,1,1234567890,'2020-11-03 13:39:29','日批，亲嘴','骚忠');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `NtID` int NOT NULL AUTO_INCREMENT,
  `Nt_Title` varchar(100) NOT NULL,
  `Nt_Content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Nt_Publish_Time` datetime NOT NULL,
  `Nt_Author_ID` int NOT NULL,
  `Nt_Attachment` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `Nt_Author` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`NtID`) USING BTREE,
  KEY `notice_admin_Ad_no_fk` (`Nt_Author_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (9,'rsqj','0%bYtRc','2020-10-19 15:02:56',2,'nntp://ahmgchxba.gm/przyxv','武秀兰'),(13,'获取全部公告的标题qqq','<p>测试</p>','2020-10-20 00:00:00',4,'','萧静'),(14,'Lets play cttc3!!!','<p>CTTC3:<video width=\"300\" height=\"150\">\n<source src=\"https://www.bilibili.com/video/BV1b54y1m7mn\" /></video></p>','2020-10-20 00:00:00',4,'','萧静'),(15,'Lets play cttc3!!!','<p>CTTC3:<video width=\"300\" height=\"150\">\n<source src=\"https://www.bilibili.com/video/BV1b54y1m7mn\" /></video></p>','2020-10-20 00:00:00',4,'','萧静'),(17,'Lets play cttc3!!!','<p>CTTC3:<video width=\"300\" height=\"150\">\n<source src=\"https://www.bilibili.com/video/BV1b54y1m7mn\" /></video></p>','2020-10-20 00:00:00',4,'','萧静'),(18,'Lets play cttc3!!!','<p>CTTC3:<video width=\"300\" height=\"150\">\n<source src=\"https://www.bilibili.com/video/BV1b54y1m7mn\" /></video></p>','2020-10-20 00:00:00',4,'','萧静'),(19,'Lets play cttc3!!!','<p>CTTC3:<video width=\"300\" height=\"150\">\n<source src=\"https://www.bilibili.com/video/BV1b54y1m7mn\" /></video></p>','2020-10-20 00:00:00',4,'','萧静'),(20,'Lets play cttc3!!!','<p>CTTC3:<video width=\"300\" height=\"150\">\n<source src=\"https://www.bilibili.com/video/BV1b54y1m7mn\" /></video></p>','2020-10-20 00:00:00',4,'','萧静'),(21,'水水水水水水','<p>少时诵诗书s</p>','2020-10-20 00:00:00',4,'','萧静'),(22,'^%9Zb0','8INBd','1977-11-25 00:00:00',-796651926,'nntp://fhwh.eg/jsdq','邵军'),(28,'^%9Zb0','8INBd','1977-11-25 00:00:00',-796651926,'nntp://fhwh.eg/jsdq','邵军'),(29,'dssfdsf','<p>sdfdsf</p>','2020-10-22 00:00:00',1,'','李海'),(30,'主页','<p>aaaaaaaaaaaaaa</p>','2020-10-22 00:00:00',1,'','李海'),(31,'蔡徐坤','唱跳rap篮球','2020-10-22 12:46:40',123,'www.baidu.com','刘忠'),(32,'1','3','2020-10-22 14:49:45',123,'www.baidu.com','2'),(33,'wwwdd','<p>dd</p>','2020-10-23 00:00:00',13,'','郭艳'),(34,'news','<p>news</p>','2020-10-23 00:00:00',13,'','郭艳'),(35,'1','3','2020-11-03 13:00:46',123,'www.baidu.com','2'),(36,'1','3','2020-11-03 13:24:33',123,'www.baidu.com','2'),(37,'1','3','2020-11-03 13:39:29',123,'www.baidu.com','2');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Sno` varchar(16) DEFAULT NULL,
  `Sname` varchar(8),
  `SCollege` varchar(20) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `Sex` varchar(2) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Headportrait` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `Joined` varchar(20) NOT NULL DEFAULT 'false' COMMENT '是否加入社团（3个状态：''false''、''true''、''auditing''）',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (150,'3172051052711','唐敏','环境科学与工程学院','f140e7c87d4874312f4167a7bad31d48','女',23,NULL,'true'),(151,'3172051051711','傅洋','化学与生物工程学院','f140e7c87d4874312f4167a7bad31d48','男',26,NULL,'true'),(152,'3172051051713','龙涛','外国语学院','f140e7c87d4874312f4167a7bad31d48','女',22,NULL,'true'),(153,'3172051051715','彭洋','环境科学与工程学院','f140e7c87d4874312f4167a7bad31d48','男',21,NULL,'false'),(154,'3172051051718','李丽','信息科学与工程学院*','f140e7c87d4874312f4167a7bad31d48','男',23,NULL,'false'),(155,'3172051051719','郭艳','机械与控制工程学院','f140e7c87d4874312f4167a7bad31d48','女',22,NULL,'true'),(157,'3172051052712','龚勇','环境科学与工程学院','f140e7c87d4874312f4167a7bad31d48','男',23,NULL,'true'),(158,'3172051053710','武秀兰','化学与生物工程学院','f140e7c87d4874312f4167a7bad31d48','男',22,NULL,'false'),(159,'3172051053716','罗静','地球科学学院','f140e7c87d4874312f4167a7bad31d48','女',22,NULL,'false'),(160,'3172051056713','吕丽','机械与控制工程学院','f140e7c87d4874312f4167a7bad31d48','女',22,NULL,'true'),(161,'3172051051781','贾强','外国语学院','f140e7c87d4874312f4167a7bad31d48','男',21,NULL,'false'),(162,'3172051051721','林刚','信息科学与工程学院','f140e7c87d4874312f4167a7bad31d48','男',23,NULL,'true'),(163,'3172051051731','熊刚','环境科学与工程学院','f140e7c87d4874312f4167a7bad31d48','男',23,NULL,'false'),(165,'3172051733','廖秀英','^2Cja','202cb962ac59075b964b07152d234b70','女',-40145336,NULL,'false'),(167,'incididunt dolor','许芳','hpPoY','2ec43a340ae8fbabe365f7b156954096','女',-87694879,NULL,'false'),(168,'123456789','k朱xx','桂林理工大学','e10adc3949ba59abbe56e057f20f883e','男',18,NULL,'false');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-10 18:16:29
