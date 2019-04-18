#springboot整合elasticearch docker版本

- ##docker安装
安装参考链接：https://blog.csdn.net/belonghuang157405/article/details/83301937
(```)
docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9200:9200 -p 9300:9300 -v /home/soft/ES/config/es1.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v /home/soft/ES/data1:/usr/share/elasticsearch/data --name elasticsearch elasticsearch:latest
(```)
其中elasticsearch.yml是配置文件，可以配置单机或者集群

- ##整合
pom文件引入
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency>
整合参考链接：https://blog.csdn.net/chengyuqiang/article/details/86135795
注意事项：9200端口是http请求使用，9300端口是tcp连接使用

本地开发单节点可以配置如下，如不配置，可能会报NoNodeAvailableException：
配置参考链接：https://blog.csdn.net/huang_550/article/details/89331898
```
cluster.name: "docker-cluster"
network.host: 0.0.0.0
network.publish_host: 192.168.139.129 #修改监听的IP为本机的IP地址
network.bind_host: 0.0.0.0
node.name: cloud
http.cors.enabled: true
http.cors.allow-origin: "*"
node.master: true
node.data: true
```

spring-boot-starter-data-elasticsearch地址：https://github.com/spring-projects/spring-data-elasticsearch

 
