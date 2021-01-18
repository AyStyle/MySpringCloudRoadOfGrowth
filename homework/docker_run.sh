#! /bin/bash

# 启动Redis
docker container run --network develop --name develop-redis --hostname RedisService --ip 10.10.10.20 -p 6379:6379  -m 67108864 redis

# 启动service-center
docker container run --network develop --name service-center1 --hostname EurekaService1 --ip 10.10.10.11 -p 8100:8761 --add-host EurekaService2:10.10.10.12 dreedisgood/service-center:cloud --spring.profiles.activate=1
docker container run --network develop --name service-center2 --hostname EurekaService2 --ip 10.10.10.12 -p 8101:8761 --add-host EurekaService1:10.10.10.11 dreedisgood/service-center:cloud --spring.profiles.activate=2

# 启动common-server
docker container run --network develop --name common-server1 --hostname CommonServer1 --ip 10.10.10.30 -p 8200:8080 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/common-server:cloud --spring.profiles.activate=pro
docker container run --network develop --name common-server2 --hostname CommonServer2 --ip 10.10.10.31 -p 8201:8080 --add-host EurekaService1:10.10.10.11 --add-host EurekaService2:10.10.10.12 --add-host RedisService:10.10.10.20 dreedisgood/common-server:cloud --spring.profiles.activate=pro




