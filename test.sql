CREATE TABLE `test` (
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`name`,`path`) values ('系统设置/用户/新增','A01.A0101.A010101'),('系统设置/用户/修改','A01.A0101.A010102'),('系统设置/角色/新增','A01.A0102.A010201'),('系统设置/角色/修改','A01.A0102.A010202'),('客户管理/新增','A02.A0201'),('客户管理/修改','A02.A0202');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
