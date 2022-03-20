/*
SQLyog Community Edition- MySQL GUI v7.01 
MySQL - 5.1.44-community : Database - bank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bank`;

/*Table structure for table `account_transactions` */

DROP TABLE IF EXISTS `account_transactions`;

CREATE TABLE `account_transactions` (
  `transaction_id` varchar(200) NOT NULL,
  `account_number` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `transaction_dt` date NOT NULL,
  `transaction_summary` varchar(200) NOT NULL,
  `transaction_type` varchar(100) NOT NULL,
  `transaction_amt` int(11) NOT NULL,
  `closing_balance` int(11) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `employee_id` (`employee_id`),
  KEY `account_number` (`account_number`),
  CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`account_number`) REFERENCES `accounts` (`account_number`) ON DELETE CASCADE,
  CONSTRAINT `acct_user_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `account_transactions` */

LOCK TABLES `account_transactions` WRITE;

insert  into `account_transactions`(`transaction_id`,`account_number`,`employee_id`,`transaction_dt`,`transaction_summary`,`transaction_type`,`transaction_amt`,`closing_balance`,`create_dt`) values ('b30462d3-a831-11ec-8e3d-f7c701ac5cc7',2147483647,1,'2022-03-13','Coffee Shop','Withdrawal',30,34500,'2022-03-13'),('b304a9a5-a831-11ec-8e3d-f7c701ac5cc7',2147483647,1,'2022-03-14','Uber','Withdrawal',100,34400,'2022-03-14'),('b304f3fe-a831-11ec-8e3d-f7c701ac5cc7',2147483647,1,'2022-03-15','Self Deposit','Deposit',500,34900,'2022-03-15'),('b3052de1-a831-11ec-8e3d-f7c701ac5cc7',2147483647,1,'2022-03-16','Ebay','Withdrawal',600,34300,'2022-03-16'),('b3056442-a831-11ec-8e3d-f7c701ac5cc7',2147483647,1,'2022-03-18','OnlineTransfer','Deposit',700,35000,'2022-03-18'),('b3059782-a831-11ec-8e3d-f7c701ac5cc7',2147483647,1,'2022-03-19','Amazon.com','Withdrawal',100,34900,'2022-03-19');

UNLOCK TABLES;

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `employee_id` int(11) NOT NULL,
  `account_number` int(11) NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `accounts` */

LOCK TABLES `accounts` WRITE;

insert  into `accounts`(`employee_id`,`account_number`,`account_type`,`branch_address`,`create_dt`) values (1,2147483647,'Savings','123 Main Street, New York','2022-03-20');

UNLOCK TABLES;

/*Table structure for table `authorities` */

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `authorities` */

LOCK TABLES `authorities` WRITE;

insert  into `authorities`(`id`,`employee_id`,`name`) values (1,1,'ROLE_USER'),(2,1,'ROLE_ADMIN'),(3,2,'ROLE_ROOT');

UNLOCK TABLES;

/*Table structure for table `cards` */

DROP TABLE IF EXISTS `cards`;

CREATE TABLE `cards` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(100) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `card_type` varchar(100) NOT NULL,
  `total_limit` int(11) NOT NULL,
  `amount_used` int(11) NOT NULL,
  `available_amount` int(11) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `card_employee_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `cards` */

LOCK TABLES `cards` WRITE;

insert  into `cards`(`card_id`,`card_number`,`employee_id`,`card_type`,`total_limit`,`amount_used`,`available_amount`,`create_dt`) values (1,'4565XXXX4656',1,'Credit',10000,500,9500,'2022-03-20'),(2,'3455XXXX8673',1,'Credit',7500,600,6900,'2022-03-20'),(3,'2359XXXX9346',1,'Credit',20000,4000,16000,'2022-03-20');

UNLOCK TABLES;

/*Table structure for table `contact_messages` */

DROP TABLE IF EXISTS `contact_messages`;

CREATE TABLE `contact_messages` (
  `contact_id` varchar(50) NOT NULL,
  `contact_name` varchar(50) NOT NULL,
  `contact_email` varchar(100) NOT NULL,
  `subject` varchar(500) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contact_messages` */

LOCK TABLES `contact_messages` WRITE;

UNLOCK TABLES;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `role` varchar(100) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

LOCK TABLES `employee` WRITE;

insert  into `employee`(`employee_id`,`name`,`email`,`mobile_number`,`pwd`,`role`,`create_dt`) values (1,'Nasruddin khan','nasruddinkhan44@gmail.com','9987353738','$2a$10$4BMwkOWzltaIjDxQG1WIB.9fiTpTTIOm02.1MLHzkjguz3ZHx2LoW','admin','2022-03-20'),(2,'Khan Nasruddin','nasruddin.nk44@gmail.com','9594757518','$2a$10$4BMwkOWzltaIjDxQG1WIB.9fiTpTTIOm02.1MLHzkjguz3ZHx2LoW','root',NULL);

UNLOCK TABLES;

/*Table structure for table `loans` */

DROP TABLE IF EXISTS `loans`;

CREATE TABLE `loans` (
  `loan_number` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `start_dt` date NOT NULL,
  `loan_type` varchar(100) NOT NULL,
  `total_loan` int(11) NOT NULL,
  `amount_paid` int(11) NOT NULL,
  `outstanding_amount` int(11) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`loan_number`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `loan_employee_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `loans` */

LOCK TABLES `loans` WRITE;

insert  into `loans`(`loan_number`,`employee_id`,`start_dt`,`loan_type`,`total_loan`,`amount_paid`,`outstanding_amount`,`create_dt`) values (1,1,'2020-10-13','Home',200000,50000,150000,'2020-10-13'),(2,1,'2020-06-06','Vehicle',40000,10000,30000,'2020-06-06'),(3,2,'2018-02-14','Home',50000,10000,40000,'2018-02-14'),(4,2,'2018-02-14','Personal',10000,3500,6500,'2018-02-14');

UNLOCK TABLES;

/*Table structure for table `notice_details` */

DROP TABLE IF EXISTS `notice_details`;

CREATE TABLE `notice_details` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_summary` varchar(200) NOT NULL,
  `notice_details` varchar(500) NOT NULL,
  `notic_beg_dt` date NOT NULL,
  `notic_end_dt` date DEFAULT NULL,
  `create_dt` date DEFAULT NULL,
  `update_dt` date DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `notice_details` */

LOCK TABLES `notice_details` WRITE;

insert  into `notice_details`(`notice_id`,`notice_summary`,`notice_details`,`notic_beg_dt`,`notic_end_dt`,`create_dt`,`update_dt`) values (1,'Home Loan Interest rates reduced','Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately','2020-10-14','2022-03-20','2022-03-20',NULL),(2,'Net Banking Offers','employees who will opt for Internet banking while opening a saving account will get a $50 amazon voucher','2020-10-14','2022-03-20','2022-03-20',NULL),(3,'Mobile App Downtime','The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities','2020-10-14','2022-03-20','2022-03-20',NULL),(4,'E Auction notice','There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction','2020-10-14','2022-03-20','2022-03-20',NULL),(5,'Launch of Millennia Cards','Millennia Credit Cards are launched for the premium employees of EazyBank. With these cards, you will get 5% cashback for each purchase','2020-10-14','2022-03-20','2022-03-20',NULL),(6,'COVID-19 Insurance','EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details','2020-10-14','2022-03-20','2022-03-20',NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
