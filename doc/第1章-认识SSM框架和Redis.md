# 第1章 认识SSM框架和Redis

标签：SSM

---

## Spring 框架

- Spring IoC（向上转型...）
- Spring AOP（切面处理某种情况...）

---

## ORM 技术

- ORM 技术：对象关系映射，把POJO对象和数据库表相互映射的框架称为关系映射框架
- Hibernate 和 MyBatis 对比
	- Hibernate优：配置不需要配置接口和SQL（不要求开发者会写SQL）
	- Hibernate缺：多表关联使用Hibernate联级性能很差，响应过慢；不支持存储过程。
	- MyBatis优：自由书写SQL、支持存储过程等；满足各类需求和性能优化的需要
	- MyBatis缺：编写SQL和映射规则，工作量大于Hibernate；插件不如Hibernate的丰富
	- 总结：建议对性能要求不太苛刻的系统，如管理系统、ERP等推荐使用Hibernate；而对于性能要求高、响应快、灵活的系统则推荐使用MyBatis

---

## 缓存数据库 Redis

- Redis优势：
	- 相应快速，每秒可作110000个写操作等，其速度远远超过数据库
	- 支持6中数据类型
	- 操作都是原子的，高并发场合可考虑使用Redis事务，处理一些需要锁的业务
	- MultiUtility工具，Redis可在缓存、消息传递队列、Web应用程序绘画、网站页面点击数等任何短暂的数据中使用
- 总结：Nosql缓存数据库，从内存中读取数据，适合现实读操作非常频繁的项目；Nosql也能满足高并发需要高速处理数据的场合，比如抢红包、商品秒杀等场景。这些场合需要高速处理，并保证并发数据安全和一致性。

---

## SSM+Redis结构框图及概述

- 终端-SpringMVC-Spring事务层-Redis

Spring事务层-MyBatis-数据库系统