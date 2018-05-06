# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2018-05-04 23:50:39
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

INSERT INTO `t_book` VALUES (1,'wdfs','��','','sdf','sdfs','sdf','2016-12-12',155,'2018-04-29'),(10001,'���ݿ����','��','��ɺ','��ɺ','�ߵȽ���������','�����','2010-01-11',35.5,'2018-04-29'),(10002,'�������','��','','��ƽ','��е��ҵ������','�����','2010-01-11',24.6,'2018-04-29'),(10003,'C++�������','��','','̷��ǿ','�廪��ѧ������','�����','2010-01-11',30.5,'2018-04-29'),(10004,'��¥��','��','','��ѩ��','������ѧ������','��ѧ','2010-01-11',45.5,'2018-04-29'),(10005,'���μ�','��','','��ж�','������ѧ������','��ѧ','2010-01-11',21.5,'2018-04-29'),(10006,'�����','��','','˾����','������ѧ������','��ѧ','2010-01-11',66.5,'2018-04-29'),(10007,'�ߵ���ѧ','��','','����','�廪��ѧ������','��ѧ','2010-01-11',38,'2018-04-29'),(10008,'�л���ѧ','��','','����','�ߵȽ���������','��ѧ','2010-01-11',37,'2018-04-29'),(10009,'��ѧӢ��','��','','����','�ߵȽ���������','����','2010-01-11',12.5,'2018-04-29'),(10010,'Ӣ��̳�','��','','����','�ߵȽ���������','����','2010-01-11',33.5,'2018-04-29'),(10011,'����Ұ��ѧӢ��','��','','����','�ߵȽ���������','����','2010-01-11',25.5,'2018-04-29'),(10012,'����Ұ��ѧӢ��','��','','֣����','�ߵȽ���������','����','2010-01-12',15.5,'2018-04-29'),(10013,'��������','��','','�޹���','������ѧ������','��ѧ','2010-01-11',16.5,'2018-04-29'),(12341,'sdfs','��','��','sdfsdf','fasdfs','dfssdf','2008-12-12',42,'2018-04-29');

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

INSERT INTO `t_reader` VALUES (4234,'1234','456456','453','2008-10-10','456456',564,'2018-04-29'),(423432,'1234123','456456213','45312346','2008-10-10','456456',564,'2018-04-29');

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
  CONSTRAINT `fk_lendinfo_reader` FOREIGN KEY (`readerId`) REFERENCES `t_reader` (`readerId`),
  CONSTRAINT `fk_lendinfo_book` FOREIGN KEY (`bookId`) REFERENCES `t_book` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_lendinfo"
#

INSERT INTO `t_lendinfo` VALUES (234,4234,'1234',10007,'�ߵ���ѧ','2008-08-08','2008-08-10','��'),(549848,423432,'1234123',10005,'���μ�','2018-05-04','2018-05-12','��');

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
  CONSTRAINT `fk_ticketInfo_reader` FOREIGN KEY (`readerId`) REFERENCES `t_reader` (`readerId`),
  CONSTRAINT `fk_ticketInfo_lendinfo` FOREIGN KEY (`lendID`) REFERENCES `t_lendinfo` (`lendID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_ticketinfo"
#

