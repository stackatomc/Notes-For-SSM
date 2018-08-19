# 第17章 Redis概述

标签：SSM

---

## Redis 适合存储数据特征

- 缓存：常用、读操作多、业务数据小
- 举例：用户登陆的信息；一些主要的业务信息，比如银行存储一些客户基础信息、银行卡信息、最近交易信息等
- （思考:常用的能拿到不是收银员的登陆信息吗，还有主要的业务信息指的应该是近期经常访问的数据吧）

---

## Redis 与持久化

- Redis缓存是将数据写入内存，比磁盘读取有很大的性能优势；而当一个事件结束后，Redis缓存数据库会根据某些人为指定的触发事件批量性将缓存的数据写入磁盘，持久化
- Redis属于NoSQL，内存数据库安全性能上容易出现故障丢失数据的问题

---

## Redis 安装

- Windows下安装下载zip：https://github.com/MicrosoftArchive/redis/releases
- 解压后新建一个文件，startup.cmd，内容写入redis-server redis.windows.conf，代替原redis-server启动，可读取redis.window.conf的内容
- startup.cmd(代替redis-server.exe) -> redis-cli.exe

---

## Redis连接池

- 原理跟Hibernate连接池相同，用Jedis表示从连接池获取的连接

> 如果一个项目中如果需要多个连接，如果一直获取连接，断开连接，这样比较浪费资源，如果创建一个池，用池来管理Connection，这样就可以重复使用Connection。有了池我们就不用自己来创建Connection，而是通过池来获取Connection对象。当使用完Connection后，调用Connection的close（）方法也不会真的关闭Connection，而是把Connection“归还”给池。池就可以再利用这个Connection对象了。这里我们常用的连接池有两种，分别是：DBCP连接池和C3P0连接池，下边是对两种连接池的具体使用和比较。[DBCP连接池与C3P0连接池的比较](https://blog.csdn.net/m15732622413/article/details/55193023)(参考来源)

---

## Java与Redis

- 可以直接使用Java对Redis进行连接
- 书中有代码

---

## Spring与Redis

- 概念：由于无法直接将对象存入Redis，而Spring对Redis执行做了封装，Spring提供序列化的设计框架和一些序列化的类，可以通过序列化把Java对象转换，使得Redis把它存储起来。并且再读取的时候，再把由序列化过的字符串转化为Java对象。对比直接用Java对Redis进行操作，更加简单，更多的时候是通过Spring的RedisTemplate机制来使用Redis

---

## Redis 6种数据类型

- STRING：可以保存字符串、整数和浮点数。字符串增加字符串或者求子串，计算整数或浮点数
- LIST：从链表的两端插入或者弹出节点；获取一个或者多个节点，根据条件删除或查找等
- SET：不可重复，可以新增、读取、删除单个元素，检测元素是否再集合内；计算交集、并集等
- HASH：增删查改单个键值对，获取所有键值对等
- ZSET：有序集合，排序依据分值的大小来决定。增删查改，根据分支的范围或者成员获取对应元素。
- HyperLogLog（基数）：只提供基数的运算，不提供返回的功能，作用是计算重复的值，以确定存储的数量