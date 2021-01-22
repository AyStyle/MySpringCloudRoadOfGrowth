#! /bin/bash

# 启动Redis
docker container run --network develop -d --rm --name develop-redis --hostname RedisService --ip 10.10.10.20 -p 6379:6379 -m 67108864 redis

# 启动MariaDB
docker container run --network develop -d --rm --name develop-mariadb -e MYSQL_ROOT_PASSWORD=888888 --hostname MariaDB --ip 10.10.10.22 -p 6033:3306 mariadb

# 启动nginx
docker container run --network develop -d --rm --name nginx-server --hostname NginxServer --ip 10.10.10.21 -p 80:80 --add-host GatewayServer1:10.10.10.50 --add-host GatewayServer2:10.10.10.51 --add-host GatewayServer3:10.10.10.52 dreedisgood/nginx:cloud

# 启动service-center
docker container run --network develop -d --rm --name service-center1 --hostname EurekaService1 --ip 10.10.10.11 -p 8100:8761 --add-host EurekaService2:10.10.10.12 dreedisgood/service-center:cloud --spring.profiles.active=1
docker container run --network develop -d --rm --name service-center2 --hostname EurekaService2 --ip 10.10.10.12 -p 8101:8761 --add-host EurekaService1:10.10.10.11 dreedisgood/service-center:cloud --spring.profiles.active=2

# 启动common-server
docker container run --network develop -d --rm --name common-server1 --hostname CommonServer1 --ip 10.10.10.30 -p 8200:8080 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/common-server:cloud --spring.profiles.active=pro
docker container run --network develop -d --rm --name common-server2 --hostname CommonServer2 --ip 10.10.10.31 -p 8201:8080 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/common-server:cloud --spring.profiles.active=pro

# 启动user-server
docker container run --network develop -d --rm --name user-server1 --hostname UserServer1 --ip 10.10.10.40 -p 8300:8080 --add-host CommonServer1:10.10.10.30 --add-host CommonServer2:10.10.10.31 --add-host MariaDB:10.10.10.22 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 dreedisgood/user-server:cloud --spring.profiles.active=pro
docker container run --network develop -d --rm --name user-server2 --hostname UserServer2 --ip 10.10.10.41 -p 8301:8080 --add-host CommonServer1:10.10.10.30 --add-host CommonServer2:10.10.10.31 --add-host MariaDB:10.10.10.22 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 dreedisgood/user-server:cloud --spring.profiles.active=pro

# 启动gateway-server
docker container run --network develop -d --rm --name gateway-server1 --hostname GatewayServer1 --ip 10.10.10.50 -p 8500:8080 --add-host UserServer1:10.10.10.40 --add-host UserServer2:10.10.10.41 --add-host CommonServer1:10.10.10.30 --add-host CommonServer2:10.10.10.31 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/gateway-server:cloud --spring.profiles.active=pro
docker container run --network develop -d --rm --name gateway-server2 --hostname GatewayServer2 --ip 10.10.10.51 -p 8501:8080 --add-host UserServer1:10.10.10.40 --add-host UserServer2:10.10.10.41 --add-host CommonServer1:10.10.10.30 --add-host CommonServer2:10.10.10.31 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/gateway-server:cloud --spring.profiles.active=pro
docker container run --network develop -d --rm --name gateway-server3 --hostname GatewayServer3 --ip 10.10.10.52 -p 8502:8080 --add-host UserServer1:10.10.10.40 --add-host UserServer2:10.10.10.41 --add-host CommonServer1:10.10.10.30 --add-host CommonServer2:10.10.10.31 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/gateway-server:cloud --spring.profiles.active=pro

CREATE DATABASE `springcloud` CHARSET = 'utf8mb4';
CREATE TABLE `r_resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(10) DEFAULT NULL ,
  `birthday` varchar(30) DEFAULT NULL ,
  `workYear` varchar(100) DEFAULT NULL ,
  `phone` varchar(20) DEFAULT NULL ,
  `email` varchar(100) DEFAULT NULL ,
  `status` varchar(80) DEFAULT NULL ,
  `resumeName` varchar(500) DEFAULT NULL ,
  `name` varchar(40) DEFAULT NULL ,
  `createTime` datetime DEFAULT NULL ,
  `headPic` varchar(100) DEFAULT NULL ,
  `isDel` int(2) DEFAULT NULL ,
  `updateTime` datetime DEFAULT NULL ,
  `userId` int(11) DEFAULT NULL ,
  `isDefault` int(2) DEFAULT NULL ,
  `highestEducation` varchar(20) DEFAULT '' ,
  `deliverNearByConfirm` int(2) DEFAULT 0 ,
  `refuseCount` int(11) NOT NULL DEFAULT 0 ,
  `markCanInterviewCount` int(11) NOT NULL DEFAULT 0 ,
  `haveNoticeInterCount` int(11) NOT NULL DEFAULT 0 ,
  `oneWord` varchar(100) DEFAULT '' ,
  `liveCity` varchar(100) DEFAULT '' ,
  `resumeScore` int(3) DEFAULT NULL ,
  `userIdentity` int(1) DEFAULT 0 ,
  `isOpenResume` int(1) DEFAULT 3 ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

