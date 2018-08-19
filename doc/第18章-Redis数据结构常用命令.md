# 第18章 Redis数据结构常用命令

标签：SSM

---

## Redis 字符串（简略）

- 基本命令：set key；get key；del key；getset key value
- Spring中操作：
	- 步骤一：配置Redis字符串的运行环境<property> 指定Redis 的bean（最常使用RedisTemplate自带），配置3个参数connectionFactory（Redis连接池）、另外两个关于序列化的参数keySerializer valueSerializer（都实现RedisSerializer接口的序列化器，该书大部分以stringRedisSerializer为例）    
	- 步骤二：可在程序中调用，作为bean，先获取Spring容器，getBean获取redisTemplate，进行操作，命令如，redisTemplate.opsForValue().set("key1","value1");Long length=redisTemplate.opsForValue().size("key2");

---

## Redis数据结构——哈希、链表、集合、有序集合、基数

- redisTemplate.opsForHash().put(key,"f3","v3");
- redisTempalte.boundSetOps("set1").add("v1","v2");
- ... 各有不同（试多应用中学习记忆吧）
- 注：书中都有例和总结命令表格