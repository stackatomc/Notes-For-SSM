# 第20章 Redis配置

标签：SSM

---

## Redis 基础配置文件

- Windows：安装目录下/redis.windows.conf
- Linux/Unix：redis.conf

---

## 几个重要配置

- Redis备份（持久化）
	- 快照snapshotting
		- stop-writes-on-bgsave-error bgsave命令是支持客户端写，并开启新的线程将Redis的数据保存到对饮过的数据文件中。save命令则会阻塞客户端写入。且bgsave若已无法写入会报错，提示避免持久化错误的发生。
		- p550
	- 只追加文件append-only file,aop
		- appendfsync everysec //everysec表示每秒同步一次命令到AOP文件，这种备份会丢失1秒以内的命令，但是安全性还可以；若no，则只能由客户端调用写入命令，但容易失去备份，安全性比较差
- Redis内存回收策略
	- maxmemory-policy 由6种，默认是noeviction内存已满时可读但写操作时则返回错误。其他还有volatile-lru最近使用最少淘汰策略（超时的）、allkeys-lru最近使用最少淘汰策略（不仅仅是超时的）、随机淘汰策略删除...等等
	- 使用淘汰策略maxmemory-samples的指定时，注意数值越大，redis删除的越精确，但需要花更多的时间去计算和匹配更为精确的值
- 复制
	- 主从同步
		- 不只是客户端的读写有了性能优化，而且主机若出现故障，可切换从服务器进行替换，有利于程序的安全性
		- 主要选择哨兵模式，代替手动主机切换为从服务器的操作。同样是进行配置conf文件、从服务器的配置文件和在代码中进行哨兵的配置。哨兵会在主机不可用后，切换主机，重写Redis的哨兵配置文件，让其他从机都指向新的主机等，以适应新场景的需要p548-p564