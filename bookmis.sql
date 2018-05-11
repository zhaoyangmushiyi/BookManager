# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2018-05-11 19:01:55
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "t_book"
#

DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `bookId` int(11) NOT NULL,
  `bookName` varchar(30) DEFAULT NULL,
  `bookState` varchar(30) DEFAULT NULL,
  `editor` varchar(30) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `press` varchar(30) DEFAULT NULL,
  `bookTypeName` varchar(30) DEFAULT NULL,
  `publishDate` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `recordDate` date DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_book"
#

INSERT INTO `t_book` VALUES (10001,'数据库管理','否','王珊','王珊','高等教育出版社','计算机','2010-01-11',35.5,'2018-04-29'),(10002,'软件测试','是','','贺平','机械工业出版社','计算机','2010-01-11',24.6,'2018-04-29'),(10003,'C++程序设计','否','','谭浩强','清华大学出版社','计算机','2010-01-11',30.5,'2018-04-29'),(10004,'红楼梦','否','','曹雪芹','人民文学出版社','文学','2010-01-11',45.5,'2018-04-29'),(10005,'西游记','否','','吴承恩','人民文学出版社','文学','2010-01-11',21.5,'2018-04-29'),(10006,'红与黑','否','','司汤达','人民文学出版社','文学','2010-01-11',66.5,'2018-04-29'),(10007,'高等数学','否','','李毅','清华大学出版社','数学','2010-01-11',38,'2018-04-29'),(10008,'有机化学','否','','张翔','高等教育出版社','化学','2010-01-11',37,'2018-04-29'),(10009,'大学英语','否','','王琳','高等教育出版社','外语','2010-01-11',12.5,'2018-04-29'),(10010,'英语教程','否','','王琳','高等教育出版社','外语','2010-01-11',33.5,'2018-04-29'),(10011,'新视野大学英语','否','','王琳','高等教育出版社','外语','2010-01-11',25.5,'2018-04-29'),(10012,'新视野大学英语','否','','郑海棠','高等教育出版社','外语','2010-01-12',15.5,'2018-04-29'),(10013,'三国演义','否','','罗贯中','人民文学出版社','文学','2010-01-11',16.5,'2018-04-29');

#
# Structure for table "t_manager"
#

DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `managerId` int(11) NOT NULL,
  `managerName` varchar(30) DEFAULT NULL,
  `accounts` varchar(30) DEFAULT NULL,
  `passwords` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_manager"
#

INSERT INTO `t_manager` VALUES (4564,'45844654','monochrome','admin');

#
# Structure for table "t_reader"
#

DROP TABLE IF EXISTS `t_reader`;
CREATE TABLE `t_reader` (
  `readerId` int(11) NOT NULL,
  `readerName` varchar(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `college` varchar(30) DEFAULT NULL,
  `enrollmentDate` date DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `recordDate` date DEFAULT NULL,
  PRIMARY KEY (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_reader"
#

INSERT INTO `t_reader` VALUES (4234,'张三','男','计算机技术','2008-10-10','123456789',564,'2018-04-29'),(4235,'李丽','女','经济管理','2017-09-01','12345678912',50,'2018-05-11');

#
# Structure for table "t_lendinfo"
#

DROP TABLE IF EXISTS `t_lendinfo`;
CREATE TABLE `t_lendinfo` (
  `lendID` int(11) NOT NULL,
  `readerId` int(11) DEFAULT NULL,
  `readerName` varchar(30) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `bookName` varchar(30) DEFAULT NULL,
  `borrowDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `lendState` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`lendID`),
  KEY `fk_lendinfo_reader` (`readerId`),
  KEY `fk_lendinfo_book` (`bookId`),
  CONSTRAINT `fk_lendinfo_book` FOREIGN KEY (`bookId`) REFERENCES `t_book` (`bookId`),
  CONSTRAINT `fk_lendinfo_reader` FOREIGN KEY (`readerId`) REFERENCES `t_reader` (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_lendinfo"
#

INSERT INTO `t_lendinfo` VALUES (1001,4235,'李丽',10002,'软件测试','2018-05-11','2018-05-15','否');

#
# Structure for table "t_ticketinfo"
#

DROP TABLE IF EXISTS `t_ticketinfo`;
CREATE TABLE `t_ticketinfo` (
  `ticketID` int(11) NOT NULL,
  `readerId` int(11) DEFAULT NULL,
  `readerName` varchar(30) DEFAULT NULL,
  `ticketTotal` double DEFAULT NULL,
  `lendID` int(11) DEFAULT NULL,
  `transactionDate` date DEFAULT NULL,
  PRIMARY KEY (`ticketID`),
  KEY `fk_ticketInfo_reader` (`readerId`),
  KEY `fk_ticketInfo_lendinfo` (`lendID`),
  CONSTRAINT `fk_ticketInfo_lendinfo` FOREIGN KEY (`lendID`) REFERENCES `t_lendinfo` (`lendID`),
  CONSTRAINT `fk_ticketInfo_reader` FOREIGN KEY (`readerId`) REFERENCES `t_reader` (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_ticketinfo"
#

