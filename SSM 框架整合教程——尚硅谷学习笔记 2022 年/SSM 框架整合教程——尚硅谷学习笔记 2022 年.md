<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

# SSM 框架整合教程——尚硅谷学习笔记 2022 年

<!-- code_chunk_output -->

- [SSM 框架整合教程——尚硅谷学习笔记 2022 年](#ssm-框架整合教程尚硅谷学习笔记-2022-年)
- [一、MyBatis](#一-mybatis)
  - [1、MyBatis 简介](#1-mybatis-简介)
    - [1.1、MyBatis 历史](#11-mybatis-历史)
    - [1.2、MyBatis 特性](#12-mybatis-特性)
    - [1.3、MyBatis 下载](#13-mybatis-下载)
    - [1.4、和其它持久化层技术对比](#14-和其它持久化层技术对比)
  - [2、搭建 MyBatis](#2-搭建-mybatis)
    - [2.1、开发环境](#21-开发环境)
    - [2.2、创建 maven 工程](#22-创建-maven-工程)
    - [2.3、创建 MyBatis 的核心配置文件](#23-创建-mybatis-的核心配置文件)
    - [2.4、创建 mapper 接口](#24-创建-mapper-接口)
    - [2.5、创建 MyBatis 的映射文件](#25-创建-mybatis-的映射文件)
    - [2.6、通过 junit 测试功能](#26-通过-junit-测试功能)
    - [2.7、加入 log4j 日志功能](#27-加入-log4j-日志功能)
      - [2.7.1 ① 加入依赖](#271-1-加入依赖)
      - [2.7.2 ② 加入 log4j 的配置文件](#272-2-加入-log4j-的配置文件)
  - [3、核心配置文件详解](#3-核心配置文件详解)
  - [4、MyBatis 的增删改查](#4-mybatis-的增删改查)
    - [4.1、新增](#41-新增)
    - [4.2、删除](#42-删除)
    - [4.3、修改](#43-修改)
    - [4.4、查询一个实体类对象](#44-查询一个实体类对象)
    - [4.5、查询 list 集合](#45-查询-list-集合)
  - [5、MyBatis 获取参数值的两种方式](#5-mybatis-获取参数值的两种方式)
    - [5.1、单个字面量类型的参数](#51-单个字面量类型的参数)
    - [5.2、多个字面量类型的参数](#52-多个字面量类型的参数)
    - [5.3、map 集合类型的参数](#53-map-集合类型的参数)
    - [5.4、实体类类型的参数](#54-实体类类型的参数)
    - [5.5、使用@Param 标识参数](#55-使用param-标识参数)
  - [6、MyBatis 的各种查询功能](#6-mybatis-的各种查询功能)
    - [6.1、查询一个实体类对象](#61-查询一个实体类对象)
    - [6.2、查询一个 list 集合](#62-查询一个-list-集合)
    - [6.3、查询单个数据](#63-查询单个数据)
    - [6.4、查询一条数据为 map 集合](#64-查询一条数据为-map-集合)
    - [6.5、查询多条数据为 map 集合](#65-查询多条数据为-map-集合)
      - [6.5.1 ① 方式一](#651-1-方式一)
      - [6.5.2 ② 方式二](#652-2-方式二)
  - [7、特殊 SQL 的执行](#7-特殊-sql-的执行)
    - [7.1、模糊查询](#71-模糊查询)
    - [7.2、批量删除](#72-批量删除)
    - [7.3、动态设置表名](#73-动态设置表名)
    - [7.4、添加功能获取自增的主键](#74-添加功能获取自增的主键)
  - [8、自定义映射 resultMap](#8-自定义映射-resultmap)
    - [8.1、resultMap 处理字段和属性的映射关系](#81-resultmap-处理字段和属性的映射关系)
    - [8.2、多对一映射处理](#82-多对一映射处理)
      - [8.2.1、级联方式处理映射关系](#821-级联方式处理映射关系)
      - [8.2.2、使用 association 处理映射关系](#822-使用-association-处理映射关系)
      - [8.2.3、分步查询](#823-分步查询)
        - [8.2.3.1 ① 查询员工信息](#8231-1-查询员工信息)
        - [8.2.3.2 ② 根据员工所对应的部门 id 查询部门信息](#8232-2-根据员工所对应的部门-id-查询部门信息)
    - [8.3、一对多映射处理](#83-一对多映射处理)
      - [8.3.1、collection](#831-collection)
      - [8.3.2、分步查询](#832-分步查询)
        - [8.3.2.1 ① 查询部门信息](#8321-1-查询部门信息)
        - [8.3.2.2 ② 根据部门 id 查询部门中的所有员工](#8322-2-根据部门-id-查询部门中的所有员工)
  - [9、动态 SQL](#9-动态-sql)
    - [9.1、if](#91-if)
    - [9.2、where](#92-where)
    - [9.3、trim](#93-trim)
    - [9.4、choose、when、otherwise](#94-choose-when-otherwise)
    - [9.5、foreach](#95-foreach)
    - [9.6、SQL 片段](#96-sql-片段)
  - [10、MyBatis 的缓存](#10-mybatis-的缓存)
    - [10.1、MyBatis 的一级缓存](#101-mybatis-的一级缓存)
    - [10.2、MyBatis 的二级缓存](#102-mybatis-的二级缓存)
    - [10.3、二级缓存的相关配置](#103-二级缓存的相关配置)
    - [10.4、MyBatis 缓存查询的顺序](#104-mybatis-缓存查询的顺序)
    - [10.5、整合第三方缓存 EHCache](#105-整合第三方缓存-ehcache)
      - [10.5.1、添加依赖](#1051-添加依赖)
      - [10.5.2、各 jar 包功能](#1052-各-jar-包功能)
      - [10.5.3、创建 EHCache 的配置文件 ehcache.xml](#1053-创建-ehcache-的配置文件-ehcachexml)
      - [10.5.4、设置二级缓存的类型](#1054-设置二级缓存的类型)
      - [10.5.5、加入 logback 日志](#1055-加入-logback-日志)
      - [10.5.6、EHCache 配置文件说明](#1056-ehcache-配置文件说明)
  - [11、MyBatis 的逆向工程](#11-mybatis-的逆向工程)
    - [11.1、创建逆向工程的步骤](#111-创建逆向工程的步骤)
      - [11.1.1 ① 添加依赖和插件](#1111-1-添加依赖和插件)
      - [11.1.2 ② 创建 MyBatis 的核心配置文件](#1112-2-创建-mybatis-的核心配置文件)
      - [11.1.3 ③ 创建逆向工程的配置文件](#1113-3-创建逆向工程的配置文件)
      - [11.1.4 ④ 执行 MBG（myBatis-generate） 插件的 generate 目标](#1114-4-执行-mbgmybatis-generate-插件的-generate-目标)
      - [11.1.5 ⑤ 效果](#1115-5-效果)
    - [11.2、QBC（Query By Example 根据样例查询） 查询](#112-qbcquery-by-example-根据样例查询-查询)
  - [12、分页插件](#12-分页插件)
    - [12.1、分页插件的使用步骤](#121-分页插件的使用步骤)
      - [12.1.1 ① 添加依赖](#1211-1-添加依赖)
      - [12.1.2 ② 配置分页插件](#1212-2-配置分页插件)
    - [12.2、分页插件的使用](#122-分页插件的使用)
- [二、Spring](#二-spring)
  - [1、Spring 简介](#1-spring-简介)
    - [1.1、Spring 概述](#11-spring-概述)
    - [1.2、Spring 家族](#12-spring-家族)
    - [1.3、Spring Framework](#13-spring-framework)
      - [1.3.1、Spring Framework 特性](#131-spring-framework-特性)
      - [1.3.2、Spring Framework 五大功能模块](#132-spring-framework-五大功能模块)
  - [2、IOC](#2-ioc)
    - [2.1、IOC 容器](#21-ioc-容器)
      - [2.1.1、IOC 思想](#211-ioc-思想)
        - [2.1.1.1 ① 获取资源的传统方式](#2111-1-获取资源的传统方式)
        - [2.1.1.2 ② 反转控制方式获取资源](#2112-2-反转控制方式获取资源)
        - [2.1.1.3 ③ DI](#2113-3-di)
      - [2.1.2、IOC 容器在 Spring 中的实现](#212-ioc-容器在-spring-中的实现)
        - [2.1.2.1 ① BeanFactory](#2121-1-beanfactory)
        - [2.1.2.2 ② ApplicationContext](#2122-2-applicationcontext)
        - [2.1.2.3 ③ ApplicationContext 的主要实现类](#2123-3-applicationcontext-的主要实现类)
    - [2.2、基于 XML 管理 bean](#22-基于-xml-管理-bean)
      - [2.2.1、实验一：入门案例](#221-实验一入门案例)
        - [2.2.1.1 ① 创建 Maven Module](#2211-1-创建-maven-module)
        - [2.2.1.2 ② 引入依赖](#2212-2-引入依赖)
        - [2.2.1.3 ③ 创建类 HelloWorld](#2213-3-创建类-helloworld)
        - [2.2.1.4 ④ 创建 Spring 的配置文件](#2214-4-创建-spring-的配置文件)
        - [2.2.1.5 ⑤ 在 Spring 的配置文件中配置 bean](#2215-5-在-spring-的配置文件中配置-bean)
        - [2.2.1.6 ⑥ 创建测试类测试](#2216-6-创建测试类测试)
        - [2.2.1.7 ⑦ 思路](#2217-7-思路)
        - [2.2.1.8 ⑧ 注意](#2218-8-注意)
      - [2.2.2、实验二：获取 bean](#222-实验二获取-bean)
        - [2.2.2.1 ① 方式一：根据 id 获取](#2221-1-方式一根据-id-获取)
        - [2.2.2.2 ② 方式二：根据类型获取](#2222-2-方式二根据类型获取)
        - [2.2.2.3 ③ 方式三：根据 id 和类型](#2223-3-方式三根据-id-和类型)
        - [2.2.2.4 ④ 注意](#2224-4-注意)
        - [2.2.2.5 ⑤ 扩展](#2225-5-扩展)
        - [2.2.2.6 ⑥ 结论](#2226-6-结论)
      - [2.2.3、实验三：依赖注入之 setter 注入](#223-实验三依赖注入之-setter-注入)
        - [2.2.3.1 ① 创建学生类 Student](#2231-1-创建学生类-student)
        - [2.2.3.2 ② 配置 bean 时为属性赋值](#2232-2-配置-bean-时为属性赋值)
        - [2.2.3.3 ③ 测试](#2233-3-测试)
      - [2.2.4、实验四：依赖注入之构造器注入](#224-实验四依赖注入之构造器注入)
        - [2.2.4.1 ① 在 Student 类中添加有参构造](#2241-1-在-student-类中添加有参构造)
        - [2.2.4.2 ② 配置 bean](#2242-2-配置-bean)
        - [2.2.4.3 ③ 测试](#2243-3-测试)
      - [2.2.5、实验五：特殊值处理](#225-实验五特殊值处理)
        - [2.2.5.1 ① 字面量赋值](#2251-1-字面量赋值)
        - [2.2.5.2 ② null 值](#2252-2-null-值)
        - [2.2.5.2 ③ xml 实体](#2252-3-xml-实体)
        - [2.2.5.3 ④ CDATA 节](#2253-4-cdata-节)
      - [2.2.6、实验六：为类类型属性赋值](#226-实验六为类类型属性赋值)
        - [2.2.6.1 ① 创建班级类 Clazz](#2261-1-创建班级类-clazz)
        - [2.2.6.2 ② 修改 Student 类](#2262-2-修改-student-类)
        - [2.2.6.3 ③ 方式一：引用外部已声明的 bean](#2263-3-方式一引用外部已声明的-bean)
        - [2.2.6.4 ④ 方式二：内部 bean](#2264-4-方式二内部-bean)
        - [2.2.6.5 ⑤ 方式三：级联属性赋值](#2265-5-方式三级联属性赋值)
      - [2.2.7、实验七：为数组类型属性赋值](#227-实验七为数组类型属性赋值)
        - [2.2.7.1 ① 修改 Student 类](#2271-1-修改-student-类)
        - [2.2.7.2 ② 配置 bean](#2272-2-配置-bean)
      - [2.2.8、实验八：为集合类型属性赋值](#228-实验八为集合类型属性赋值)
        - [2.2.8.1 ① 为 List 集合类型属性赋值](#2281-1-为-list-集合类型属性赋值)
        - [2.2.8.2 ② 为 Map 集合类型属性赋值](#2282-2-为-map-集合类型属性赋值)
        - [2.2.8.3 ③ 引用集合类型的 bean](#2283-3-引用集合类型的-bean)
      - [2.2.9、实验九：p 命名空间](#229-实验九p-命名空间)
      - [2.2.10、实验十：引入外部属性文件](#2210-实验十引入外部属性文件)
        - [2.2.10.1 ① 加入依赖](#22101-1-加入依赖)
        - [2.2.10.2 ② 创建外部属性文件](#22102-2-创建外部属性文件)
        - [2.2.10.3 ③ 引入属性文件](#22103-3-引入属性文件)
        - [2.2.10.4 ④ 配置 bean](#22104-4-配置-bean)
        - [2.2.10.5 ⑤ 测试](#22105-5-测试)
      - [2.2.11、实验十一：bean 的作用域](#2211-实验十一bean-的作用域)
        - [2.2.11.1 ① 概念](#22111-1-概念)
        - [2.2.11.2 ② 创建类 User](#22112-2-创建类-user)
        - [2.2.11.3 ③ 配置 bean](#22113-3-配置-bean)
        - [2.2.11.4 ④ 测试](#22114-4-测试)
      - [2.2.12、实验十二：bean 的生命周期](#2212-实验十二bean-的生命周期)
        - [2.2.12.1 ① 具体的生命周期过程](#22121-1-具体的生命周期过程)
        - [2.2.12.2 ② 修改类 User](#22122-2-修改类-user)
        - [2.2.12.3 ③ 配置 bean](#22123-3-配置-bean)
        - [2.2.12.4 ④ 测试](#22124-4-测试)
        - [2.2.12.5 ⑤ bean 的后置处理器](#22125-5-bean-的后置处理器)
      - [2.2.13、实验十三：FactoryBean](#2213-实验十三factorybean)
        - [2.2.13.1 ① 简介](#22131-1-简介)
        - [2.2.13.2 ② 创建类 UserFactoryBean](#22132-2-创建类-userfactorybean)
        - [2.2.13.3 ③ 配置 bean](#22133-3-配置-bean)
        - [2.2.13.4 ④ 测试](#22134-4-测试)
        - [2.2.14、实验十四：基于 xml 的自动装配](#2214-实验十四基于-xml-的自动装配)
        - [2.2.14.1 ① 场景模拟](#22141-1-场景模拟)
        - [2.2.14.2 ② 配置 bean](#22142-2-配置-bean)
        - [2.2.14.3 ③ 测试](#22143-3-测试)
    - [2.3、基于注解管理 bean](#23-基于注解管理-bean)
      - [2.3.1、实验一：标记与扫描](#231-实验一标记与扫描)
        - [2.3.1.1 ① 注解](#2311-1-注解)
        - [2.3.1.2 ② 扫描](#2312-2-扫描)
        - [2.3.1.3 ③ 新建 Maven Module](#2313-3-新建-maven-module)
        - [2.3.1.4 ④ 创建 Spring 配置文件](#2314-4-创建-spring-配置文件)
        - [2.3.1.5 ⑤ 标识组件的常用注解](#2315-5-标识组件的常用注解)
        - [2.3.1.6 ⑥ 创建组件](#2316-6-创建组件)
        - [2.3.1.7 ⑦ 扫描组件](#2317-7-扫描组件)
        - [2.3.1.8 ⑧ 测试](#2318-8-测试)
        - [2.3.1.9 ⑨ 组件所对应的 bean 的 id](#2319-9-组件所对应的-bean-的-id)
      - [2.3.2、实验二：基于注解的自动装配](#232-实验二基于注解的自动装配)
        - [2.3.2.1 ① 场景模拟](#2321-1-场景模拟)
        - [2.3.2.2 ② @Autowired 注解](#2322-2-autowired-注解)
        - [2.3.2.3 ③ @Autowired 注解其他细节](#2323-3-autowired-注解其他细节)
        - [2.3.2.4 ④ @Autowired 工作流程](#2324-4-autowired-工作流程)
  - [3、AOP](#3-aop)
    - [3.1、场景模拟](#31-场景模拟)
      - [3.1.1、声明接口](#311-声明接口)
      - [3.1.2、创建实现类](#312-创建实现类)
      - [3.1.3、创建带日志功能的实现类](#313-创建带日志功能的实现类)
      - [3.1.4、提出问题](#314-提出问题)
        - [3.1.4.1 ① 现有代码缺陷](#3141-1-现有代码缺陷)
        - [3.1.4.2 ② 解决思路](#3142-2-解决思路)
        - [3.1.4.3 ③ 困难](#3143-3-困难)
    - [3.2、代理模式](#32-代理模式)
      - [3.2.1、概念](#321-概念)
        - [3.2.1.1 ① 介绍](#3211-1-介绍)
        - [3.2.1.2 ② 生活中的代理](#3212-2-生活中的代理)
        - [3.2.1.3 ③ 相关术语](#3213-3-相关术语)
      - [3.2.2、静态代理](#322-静态代理)
      - [3.2.3、动态代理](#323-动态代理)
      - [3.2.4、测试](#324-测试)
    - [3.3、AOP 概念及相关术语](#33-aop-概念及相关术语)
      - [3.3.1、概述](#331-概述)
      - [3.3.2、相关术语](#332-相关术语)
        - [3.3.2.1 ① 横切关注点](#3321-1-横切关注点)
        - [3.3.2.2 ② 通知](#3322-2-通知)
        - [3.3.2.3 ③ 切面](#3323-3-切面)
        - [3.3.2.4 ④ 目标](#3324-4-目标)
        - [3.3.2.5 ⑤ 代理](#3325-5-代理)
        - [3.3.2.6 ⑥ 连接点](#3326-6-连接点)
        - [3.3.2.7 ⑦ 切入点](#3327-7-切入点)
      - [3.3.3、作用](#333-作用)
    - [3.4、基于注解的 AOP](#34-基于注解的-aop)
      - [3.4.1、技术说明](#341-技术说明)
      - [3.4.2、准备工作](#342-准备工作)
        - [3.4.2.1 ① 添加依赖](#3421-1-添加依赖)
        - [3.4.2.2 ② 准备被代理的目标资源](#3422-2-准备被代理的目标资源)
      - [3.4.3、创建切面类并配置](#343-创建切面类并配置)
      - [3.4.4、各种通知](#344-各种通知)
      - [3.4.5、切入点表达式语法](#345-切入点表达式语法)
        - [3.4.5.1 ① 作用](#3451-1-作用)
        - [3.4.5.2 ② 语法细节](#3452-2-语法细节)
      - [3.4.6、重用切入点表达式](#346-重用切入点表达式)
        - [3.4.6.1 ① 声明](#3461-1-声明)
        - [3.4.6.2 ② 在同一个切面中使用](#3462-2-在同一个切面中使用)
        - [3.4.6.3 ③ 在不同切面中使用](#3463-3-在不同切面中使用)
      - [3.4.7、获取通知的相关信息](#347-获取通知的相关信息)
        - [3.4.7.1 ① 获取连接点信息](#3471-1-获取连接点信息)
        - [3.4.7.2 ② 获取目标方法的返回值](#3472-2-获取目标方法的返回值)
        - [3.4.7.3 ③ 获取目标方法的异常](#3473-3-获取目标方法的异常)
      - [3.4.8、环绕通知](#348-环绕通知)
      - [3.4.9、切面的优先级](#349-切面的优先级)
    - [3.5，基于 XML 的 AOP（了解）](#35基于-xml-的-aop了解)
      - [3.5.1、准备工作](#351-准备工作)
      - [3.5.2、实现](#352-实现)
  - [4、声明式事务](#4-声明式事务)
    - [4.1、JdbcTemplate](#41-jdbctemplate)
      - [4.1.1、简介](#411-简介)
      - [4.1.2、准备工作](#412-准备工作)
        - [4.1.2.1 ① 加入依赖](#4121-1-加入依赖)
        - [4.1.2.2 ② 创建 jdbc.properties](#4122-2-创建-jdbcproperties)
        - [4.1.2.3 ③ 配置 Spring 的配置文件](#4123-3-配置-spring-的配置文件)
      - [4.1.3、测试](#413-测试)
        - [4.1.3.1 ① 在测试类装配 JdbcTemplate](#4131-1-在测试类装配-jdbctemplate)
        - [4.1.3.2 ② 测试增删改功能](#4132-2-测试增删改功能)
        - [4.1.3.3 ③ 查询一条数据为实体类对象](#4133-3-查询一条数据为实体类对象)
        - [4.1.3.4 ④ 查询多条数据为一个 list 集合](#4134-4-查询多条数据为一个-list-集合)
        - [4.1.3.5 ⑤ 查询单行单列的值](#4135-5-查询单行单列的值)
    - [4.2、声明式事务概念](#42-声明式事务概念)
      - [4.2.1、编程式事务](#421-编程式事务)
      - [4.2.2、声明式事务](#422-声明式事务)
    - [4.3、基于注解的声明式事务](#43-基于注解的声明式事务)
      - [4.3.1、准备工作](#431-准备工作)
        - [4.3.1.1 ① 加入依赖](#4311-1-加入依赖)
        - [4.3.1.2 ② 创建 jdbc.properties](#4312-2-创建-jdbcproperties)
        - [4.3.1.3 ③ 配置 Spring 的配置文件](#4313-3-配置-spring-的配置文件)
        - [4.3.1.4 ④ 创建表](#4314-4-创建表)
        - [4.3.1.5 ⑤ 创建组件](#4315-5-创建组件)
      - [4.3.2、测试无事务情况](#432-测试无事务情况)
        - [4.3.2.1 ① 创建测试类](#4321-1-创建测试类)
        - [4.3.2.2 ② 模拟场景](#4322-2-模拟场景)
        - [4.3.2.3 ③ 观察结果](#4323-3-观察结果)
      - [4.3.3、加入事务](#433-加入事务)
        - [4.3.3.1 ① 添加事务配置](#4331-1-添加事务配置)
        - [4.3.3.2 ② 添加事务注解](#4332-2-添加事务注解)
        - [4.3.3.3 ③ 观察结果](#4333-3-观察结果)
      - [4.3.4、@Transactional 注解标识的位置](#434-transactional-注解标识的位置)
      - [4.3.5、事务属性：只读](#435-事务属性只读)
        - [4.3.5.1 ① 介绍](#4351-1-介绍)
        - [4.3.5.2 ② 使用方式](#4352-2-使用方式)
        - [4.3.5.3 ③ 注意](#4353-3-注意)
      - [4.3.6、事务属性：超时](#436-事务属性超时)
        - [4.3.6.1 ① 介绍](#4361-1-介绍)
        - [4.3.6.2 ② 使用方式](#4362-2-使用方式)
        - [4.3.6.3 ③ 观察结果](#4363-3-观察结果)
      - [4.3.7、事务属性：回滚策略](#437-事务属性回滚策略)
        - [4.3.7.1 ① 介绍](#4371-1-介绍)
        - [4.3.7.2 ② 使用方式](#4372-2-使用方式)
        - [4.3.7.3 ③ 观察结果](#4373-3-观察结果)
      - [4.3.8、事务属性：事务隔离级别](#438-事务属性事务隔离级别)
        - [4.3.8.1 ① 介绍](#4381-1-介绍)
        - [4.3.8.2 ② 使用方式](#4382-2-使用方式)
      - [4.3.9、事务属性：事务传播行为](#439-事务属性事务传播行为)
        - [4.3.9.1 ① 介绍](#4391-1-介绍)
        - [4.3.9.2 ② 测试](#4392-2-测试)
        - [4.3.9.3 ③ 观察结果](#4393-3-观察结果)
    - [4.4、基于 XML 的声明式事务](#44-基于-xml-的声明式事务)
      - [4.3.1、场景模拟](#431-场景模拟)
      - [4.3.2、修改 Spring 配置文件](#432-修改-spring-配置文件)
- [三、SpringMVC](#三-springmvc)
  - [1、SpringMVC 简介](#1-springmvc-简介)
    - [1.1、什么是 MVC](#11-什么是-mvc)
    - [1.2、什么是 SpringMVC](#12-什么是-springmvc)
    - [1.3、SpringMVC 的特点](#13-springmvc-的特点)
  - [2、入门案例](#2-入门案例)
    - [2.1、开发环境](#21-开发环境-1)
    - [2.2、创建 maven 工程](#22-创建-maven-工程-1)
      - [2.2.1 ① 添加 web 模块](#221-1-添加-web-模块)
      - [2.2.2 ② 打包方式：war](#222-2-打包方式war)
      - [2.2.3 ③ 引入依赖](#223-3-引入依赖)
    - [2.3、配置 web.xml](#23-配置-webxml)
      - [2.3.1 ① 默认配置方式](#231-1-默认配置方式)
      - [2.3.2 ② 扩展配置方式](#232-2-扩展配置方式)
    - [2.4、创建请求控制器](#24-创建请求控制器)
    - [2.5、创建 SpringMVC 的配置文件](#25-创建-springmvc-的配置文件)
    - [2.6、测试 HelloWorld](#26-测试-helloworld)
      - [2.6.1 ① 实现对首页的访问](#261-1-实现对首页的访问)
      - [2.6.2 ② 通过超链接跳转到指定页面](#262-2-通过超链接跳转到指定页面)
    - [2.7、总结](#27-总结)
  - [3、@RequestMapping 注解](#3-requestmapping-注解)
    - [3.1、@RequestMapping 注解的功能](#31-requestmapping-注解的功能)
    - [3.2、@RequestMapping 注解的位置](#32-requestmapping-注解的位置)
    - [3.3、@RequestMapping 注解的 value 属性](#33-requestmapping-注解的-value-属性)
    - [3.4、@RequestMapping 注解的 method 属性](#34-requestmapping-注解的-method-属性)
    - [3.5、@RequestMapping 注解的 params 属性（了解）](#35-requestmapping-注解的-params-属性了解)
    - [3.6、@RequestMapping 注解的 headers 属性（了解）](#36-requestmapping-注解的-headers-属性了解)
    - [3.7、SpringMVC 支持 ant 风格的路径](#37-springmvc-支持-ant-风格的路径)
    - [3.8、SpringMVC 支持路径中的占位符（重点）](#38-springmvc-支持路径中的占位符重点)
  - [4、SpringMVC 获取请求参数](#4-springmvc-获取请求参数)
    - [4.1、通过 ServletAPI 获取](#41-通过-servletapi-获取)
    - [4.2、通过控制器方法的形参获取请求参数](#42-通过控制器方法的形参获取请求参数)
    - [4.3、@RequestParam](#43-requestparam)
    - [4.4、@RequestHeader](#44-requestheader)
    - [4.5、@CookieValue](#45-cookievalue)
    - [4.6、通过 POJO 获取请求参数](#46-通过-pojo-获取请求参数)
    - [4.7、解决获取请求参数的乱码问题](#47-解决获取请求参数的乱码问题)
  - [5、域对象共享数据](#5-域对象共享数据)
    - [5.1、使用 ServletAPI 向 request 域对象共享数据](#51-使用-servletapi-向-request-域对象共享数据)
    - [5.2、使用 ModelAndView 向 request 域对象共享数据](#52-使用-modelandview-向-request-域对象共享数据)
    - [5.3、使用 Model 向 request 域对象共享数据](#53-使用-model-向-request-域对象共享数据)
    - [5.4、使用 ModelMap 向 request 域对象共享数据](#54-使用-modelmap-向-request-域对象共享数据)
    - [5.5、使用 map 向 request 域对象共享数据](#55-使用-map-向-request-域对象共享数据)
    - [5.6、Model、ModelMap、Map 的关系](#56-model-modelmap-map-的关系)
    - [5.7、向 session 域共享数据](#57-向-session-域共享数据)
    - [5.8、向 application 域共享数据](#58-向-application-域共享数据)
  - [6、SpringMVC 的视图](#6-springmvc-的视图)
    - [6.1、ThymeleafView](#61-thymeleafview)
    - [6.2、转发视图](#62-转发视图)
    - [6.3、重定向视图](#63-重定向视图)
    - [6.4、视图控制器 view-controller](#64-视图控制器-view-controller)
  - [7、RESTful](#7-restful)
    - [7.1、RESTful 简介](#71-restful-简介)
      - [7.1.1 ① 资源](#711-1-资源)
      - [7.1.2 ② 资源的表述](#712-2-资源的表述)
      - [7.1.3 ③ 状态转移](#713-3-状态转移)
    - [7.2、RESTful 的实现](#72-restful-的实现)
    - [7.3、HiddenHttpMethodFilter](#73-hiddenhttpmethodfilter)
    - [7.4、创建页面](#74-创建页面)
    - [7.5、创建控制器](#75-创建控制器)
  - [8、RESTful 案例](#8-restful-案例)
    - [8.1、准备工作](#81-准备工作)
    - [8.2、功能清单](#82-功能清单)
    - [8.3、具体功能：访问首页](#83-具体功能访问首页)
      - [8.3.1 ① 配置 view-controller](#831-1-配置-view-controller)
      - [8.3.2 ② 配置 default-servlet-handler](#832-2-配置-default-servlet-handler)
      - [8.3.3 ③ 创建页面](#833-3-创建页面)
    - [8.4、具体功能：查询所有员工数据](#84-具体功能查询所有员工数据)
      - [8.4.1 ① 控制器方法](#841-1-控制器方法)
      - [8.4.2 ② 创建 employee_list.html](#842-2-创建-employee_listhtml)
    - [8.5、具体功能：删除](#85-具体功能删除)
      - [8.5.1 ① 创建处理 delete 请求方式的表单](#851-1-创建处理-delete-请求方式的表单)
      - [8.5.2 ② 删除超链接绑定点击事件](#852-2-删除超链接绑定点击事件)
      - [8.5.3 ③ 控制器方法](#853-3-控制器方法)
    - [8.6、具体功能：跳转到添加数据页面](#86-具体功能跳转到添加数据页面)
      - [8.6.1 ① 配置 view-controller](#861-1-配置-view-controller)
      - [8.6.2 ② 创建 employee_add.html](#862-2-创建-employee_addhtml)
    - [8.7、具体功能：执行保存](#87-具体功能执行保存)
      - [8.7.1 ① 控制器方法](#871-1-控制器方法)
    - [8.8、具体功能：跳转到更新数据页面](#88-具体功能跳转到更新数据页面)
      - [8.8.1 ① 修改超链接](#881-1-修改超链接)
      - [8.8.2 ② 控制器方法](#882-2-控制器方法)
      - [8.8.3 ③ 创建 employee_update.html](#883-3-创建-employee_updatehtml)
    - [8.9、具体功能：执行更新](#89-具体功能执行更新)
      - [8.9.1 ① 控制器方法](#891-1-控制器方法)
  - [9、SpringMVC 处理 ajax 请求](#9-springmvc-处理-ajax-请求)
    - [9.1、@RequestBody](#91-requestbody)
    - [9.2、@RequestBody 获取 json 格式的请求参数](#92-requestbody-获取-json-格式的请求参数)
    - [9.3、@ResponseBody](#93-responsebody)
    - [9.4、@ResponseBody 响应浏览器 json 数据](#94-responsebody-响应浏览器-json-数据)
    - [9.5、@RestController 注解](#95-restcontroller-注解)
  - [10、文件上传和下载](#10-文件上传和下载)
    - [10.1、文件下载](#101-文件下载)
    - [10.2、文件上传](#102-文件上传)
      - [10.2.1 ① 在 SpringMVC 的配置文件中添加配置：](#1021-1-在-springmvc-的配置文件中添加配置)
      - [10.2.2 ② 创建页面：](#1022-2-创建页面)
      - [10.2.3 ③ 控制器方法：](#1023-3-控制器方法)
  - [11、拦截器](#11-拦截器)
    - [11.1、拦截器的配置](#111-拦截器的配置)
    - [11.2、拦截器的三个抽象方法](#112-拦截器的三个抽象方法)
    - [11.3、多个拦截器的执行顺序](#113-多个拦截器的执行顺序)
  - [12、异常处理器](#12-异常处理器)
    - [12.1、基于配置的异常处理](#121-基于配置的异常处理)
    - [12.2、基于注解的异常处理](#122-基于注解的异常处理)
  - [13、注解配置 SpringMVC](#13-注解配置-springmvc)
    - [13.1、创建初始化类，代替 web.xml](#131-创建初始化类代替-webxml)
    - [13.2、创建 SpringConfig 配置类，代替 spring 的配置文件](#132-创建-springconfig-配置类代替-spring-的配置文件)
    - [13.3、创建 WebConfig 配置类，代替 SpringMVC 的配置文件](#133-创建-webconfig-配置类代替-springmvc-的配置文件)
    - [13.4、测试功能](#134-测试功能)
  - [14、SpringMVC 执行流程](#14-springmvc-执行流程)
    - [14.1、SpringMVC 常用组件](#141-springmvc-常用组件)
    - [14.2、DispatcherServlet 初始化过程](#142-dispatcherservlet-初始化过程)
      - [14.2.1 ① 初始化 WebApplicationContext](#1421-1-初始化-webapplicationcontext)
      - [14.2.2 ② 创建 WebApplicationContext](#1422-2-创建-webapplicationcontext)
      - [14.2.3 ③ DispatcherServlet 初始化策略](#1423-3-dispatcherservlet-初始化策略)
    - [14.3、DispatcherServlet 调用组件处理请求](#143-dispatcherservlet-调用组件处理请求)
      - [14.3.1 ① processRequest()](#1431-1-processrequest)
      - [14.3.2 ② doService()](#1432-2-doservice)
      - [14.3.3 ③ doDispatch()](#1433-3-dodispatch)
      - [14.3.4 ④ processDispatchResult()](#1434-4-processdispatchresult)
    - [14.4、SpringMVC 的执行流程](#144-springmvc-的执行流程)
- [四、SSM 框架整合](#四-ssm-框架整合)
  - [4.1、ContextLoaderListener](#41-contextloaderlistener)
  - [4.2、准备工作](#42-准备工作)
    - [4.2.1 ① 创建 Maven Module](#421-1-创建-maven-module)
    - [4.2.2 ② 导入依赖](#422-2-导入依赖)
    - [4.2.3 ③ 创建表](#423-3-创建表)
  - [4.3、配置 web.xml](#43-配置-webxml)
  - [4.4、创建 SpringMVC 的配置文件并配置](#44-创建-springmvc-的配置文件并配置)
  - [4.5、搭建 MyBatis 环境](#45-搭建-mybatis-环境)
    - [4.5.1 ① 创建属性文件 jdbc.properties](#451-1-创建属性文件-jdbcproperties)
    - [4.5.2 ② 创建 MyBatis 的核心配置文件 mybatis-config.xml](#452-2-创建-mybatis-的核心配置文件-mybatis-configxml)
    - [4.5.3 ③ 创建 Mapper 接口和映射文件](#453-3-创建-mapper-接口和映射文件)
    - [4.5.4 ④ 创建日志文件 log4j.xml](#454-4-创建日志文件-log4jxml)
  - [4.6、创建 Spring 的配置文件并配置](#46-创建-spring-的配置文件并配置)
  - [4.7、测试功能](#47-测试功能)
    - [4.7.1 ① 创建组件](#471-1-创建组件)
    - [4.7.2 ② 创建页面](#472-2-创建页面)
    - [4.7.3 ③ 访问测试分页功能](#473-3-访问测试分页功能)

<!-- /code_chunk_output -->

# 一、MyBatis

## 1、MyBatis 简介

### 1.1、MyBatis 历史

MyBatis 最初是 Apache 的一个开源项目**iBatis**，2010 年 6 月这个项目由 Apache Software Foundation 迁移到了 Google Code。随着开发团队转投 Google Code 旗下， iBatis3.x 正式更名为 MyBatis。代码于 2013 年 11 月迁移到 Github。

iBatis 一词来源于“internet”和“abatis”的组合，是一个基于 Java 的持久层框架。 iBatis 提供的持久层框架包括 SQL Maps 和 Data Access Objects（DAO）。

### 1.2、MyBatis 特性

1. MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架。

2. MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。

3. MyBatis 可以使用简单的 XML 或注解用于配置和原始映射，将接口和 Java 的 POJO（Plain Old Java Objects，普通的 Java 对象）映射成数据库中的记录。

4. MyBatis 是一个 半自动的 ORM（Object Relation Mapping）框架。

### 1.3、MyBatis 下载

MyBatis 下载地址：https://github.com/mybatis/mybatis-3

![MyBatis 下载](https://img-blog.csdnimg.cn/0b94aa600639481cb4a0156f9bc4c4c6.png)

![MyBatis 下载](https://img-blog.csdnimg.cn/1a7057533fcc4bd49fdc44b30ca10216.png)

### 1.4、和其它持久化层技术对比

- JDBC

  - SQL 夹杂在 Java 代码中耦合度高，导致硬编码内伤。

  - 维护不易且实际开发需求中 SQL 有变化，频繁修改的情况多见。

  - 代码冗长，开发效率低。

- Hibernate 和 JPA

  - 操作简便，开发效率高。

  - 程序中的长难复杂 SQL 需要绕过框架。

  - 内部自动生产的 SQL，不容易做特殊优化。

  - 基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难。

  - 反射操作太多，导致数据库性能下降。

- MyBatis

  - 轻量级，性能出色。

  - SQL 和 Java 编码分开，功能边界清晰。Java 代码专注业务、SQL 语句专注数据。

  - 开发效率稍逊于 HIbernate，但是完全能够接受。

## 2、搭建 MyBatis

### 2.1、开发环境

IDE：idea 2022.3

构建工具：maven 3.8.1

MySQL 版本：MySQL 8

MyBatis 版本：MyBatis 3.5.13

> MySQL 不同版本的注意事项
>
> 1、驱动类 driver-class-name
>
> MySQL 5 版本使用 jdbc5 驱动，驱动类使用：com.mysql.jdbc.Driver
>
> MySQL 8 版本使用 jdbc8 驱动，驱动类使用：com.mysql.cj.jdbc.Driver
>
> 2、连接地址 url
>
> MySQL 5 版本的 url：
>
> jdbc:mysql://localhost:3306/ssm
>
> MySQL 8 版本的 url：
>
> jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
>
> 否则运行测试用例报告如下错误：
>
> java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more

### 2.2、创建 maven 工程

**① 打包方式：jar**

**② 引入依赖**

```xml
<dependencies>
    <!-- MySQL 驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>

    <!-- Mybatis 核心 -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.13</version>
    </dependency>

    <!-- junit 测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 2.3、创建 MyBatis 的核心配置文件

> 习惯上命名为 mybatis-config.xml，这个文件名仅仅只是建议，并非强制要求。将来整合 Spring 之后，这个配置文件可以省略，所以大家操作时可以直接复制、粘贴。
>
> 核心配置文件主要用于配置连接数据库的环境以及 MyBatis 的全局配置信息。
>
> 核心配置文件存放的位置是 src/main/resources 目录下。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 配置连接数据库的环境 -->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"/>
                <property name="username" value="MYXH"/>
                <property name="password" value="520.ILY!"/>
            </dataSource>
        </environment>
    </environments>

    <!--引入 MyBatis 的映射文件 -->
    <mappers>
        <package name="com.myxh.mybatis.mapper"/>
    </mappers>
</configuration>
```

### 2.4、创建 mapper 接口

> MyBatis 中的 mapper 接口相当于以前的 DAO。但是区别在于，mapper 仅仅是接口，我们不需要提供实现类。

```java
package com.myxh.mybatis.mapper;

import com.myxh.mybatis.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/11
 */
public interface UserMapper
{
    /**
     * 添加用户信息
     *
     * @return 影响的行数
     */
    int insertUser();
}
```

### 2.5、创建 MyBatis 的映射文件

相关概念：**ORM**（**O**bject **R**elationship **M**apping）对象关系映射。

- 对象：Java 的实体类对象。

- 关系：关系型数据库。

- 映射：二者之间的对应关系。

| **Java 概念** | **数据库概念** |
| ------------- | -------------- |
| 类            | 表             |
| 属性          | 字段/列        |
| 对象          | 记录/行        |

> 1、映射文件的命名规则：
>
> 表所对应的实体类的类名+Mapper.xml
>
> 例如：表 t_user，映射的实体类为 User，所对应的映射文件为 UserMapper.xml
>
> 因此一个映射文件对应一个实体类，对应一张表的操作。
>
> MyBatis 映射文件用于编写 SQL，访问以及操作表中的数据。
>
> MyBatis 映射文件存放的位置是 src/main/resources/mappers 目录下。
>
> 2、 MyBatis 中可以面向接口操作数据，要保证两个一致：
>
> ① mapper 接口的全类名和映射文件的命名空间（namespace）保持一致。
>
> ② mapper 接口中方法的方法名和映射文件中编写 SQL 的标签的 id 属性保持一致。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myxh.mybatis.mapper.UserMapper">
    <!--
        mapper 接口和映射文件要保证两个一致：
        1、mapper 接口的全类名和映射文件的 namespace 保持一致
        2、mapper 接口中的方法的方法名要和映射文件中的 sql 的 id 保持一致
     -->

    <!-- int insertUser(); -->
    <insert id="insertUser">
        insert into t_user (id, username, password, age, gender, email)
        values (null, 'myxh', '520.ILY!', 21, '男', '1735350920@qq.com'),
               (null, 'root', '000000', 21, '男', 'root@qq.com'),
               (null, 'admin', '123456', 21, '男', 'admin@qq.com');
    </insert>
</mapper>
```

### 2.6、通过 junit 测试功能

```java
package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.UserMapper;
import com.myxh.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author MYXH
 * @date 2023/8/11
 */
public class MyBatisTest
{
    @Test
    public void testInsert() throws IOException
    {
        // 获取核心配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取 sqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取 sqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 获取 sql 的会话对象 sqlSession(不会自动提交事务)，是 MyBatis 提供的操作数据库的对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取 sql 的会话对象 sqlSession(会自动提交事务)，是 MyBatis 提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取 userMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用 mapper 接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();

        //提供 sql 以及的唯一标识找到 sqL 并执行，唯一标识是 namespace.sqlId
        // int result = sqlSession.insert("com.myxh.mybatis.mapper.UserMapper.insertUser");

        System.out.println("结果：" + result);

        // 提交事务
        // sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }
}
```

> - SqlSession：代表 Java 程序和**数据库**之间的**会话**。（HttpSession 是 Java 程序和浏览器之间的会话）
>
> - SqlSessionFactory：是“生产”SqlSession 的“工厂”。
>
> - 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，以后都使用这个工厂类来“生产”我们需要的对象。

### 2.7、加入 log4j 日志功能

#### 2.7.1 ① 加入依赖

```xml
<!-- log4j 日志 -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

#### 2.7.2 ② 加入 log4j 的配置文件

> log4j 的配置文件名为 log4j.xml，存放的位置是 src/main/resources 目录下。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8"/>
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m (%F:%L) \n"/>
        </layout>
    </appender>

    <logger name="java.sql">
        <level value="debug"/>
    </logger>

    <logger name="org.apache.ibatis">
        <level value="info"/>
    </logger>

    <root>
        <level value="debug"/>
        <appender-ref ref="STDOUT"/>
    </root>
</log4j:configuration>

```

> **日志的级别**
>
> FATAL(致命) > ERROR(错误) > WARN(警告) > INFO(信息) > DEBUG(调试)
>
> 从左到右打印的内容越来越详细。

## 3、核心配置文件详解

> 核心配置文件中的标签必须按照固定的顺序：
>
> properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--
        MyBatis 核心配置文件中的标签必须要按照指定的顺序配置：
        properties?,settings?,typeAliases?,typeHandlers?,
        objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,
        environments?,databaseIdProvider?,mappers?
     -->

    <!-- 引入 properties 文件，此后就可以在当前文件中使用 ${key} 的方式访问 value -->
    <properties resource="jdbc.properties"/>

    <!--
        typeAlias：设置类型别名，即为某个具体的类型设置一个别名
        在 MyBatis 的范围中，就可以使用别名表示一个具体的类型
     -->
    <typeAliases>
        <!--
            typeAlias：设置某个类型的别名
            属性：
            type：设置需要设置别名的类型
            alias：设置某个类型的别名
         -->
        <!-- <typeAlias type="com.myxh.mybatis.pojo.User" alias="User"></typeAlias> -->
        <!-- 若不设置 alias，当前的类型拥有默认的别名，即类名且不区分大小写 -->
        <!-- <typeAlias type="com.myxh.mybatis.pojo.User"></typeAlias> -->

        <!-- 通过包设置类型别名，指定包下所有的类型将全部拥有默认的别名，即类名且不区分大小 -->
        <package name="com.myxh.mybatis.pojo"/>
    </typeAliases>

    <!--
        environments：配置连接数据库的环境
        属性：
        default：设置默认使用的环境的 id
     -->
    <environments default="development">
        <!--
            environment：设置一个具体地连接数据库的环境
            属性：
            id：设置环境的唯一标识，不能重复
         -->
        <environment id="development">
            <!--
                transactionManager：设置事务管理器
                属性：
                type：设置事务管理的方式
                type="JDBC|MANAGED"
                JDBC：表示使用 JDBC 中原生的事务管理方式
                MANAGED：被管理，例如 Spring
             -->
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--
                    datasource：设置数据源
                    属性：
                    type：设置数据源的类型
                    type="POOLED|UNPOOLED|JNDI"
                    POOLED：表示使用数据库连接池
                    UNPOOLED：表示不使用数据库连接池
                    JNDI：表示使用上下文中的数据源
                 -->
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>

        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--引入 MyBatis 的映射文件 -->
    <mappers>
        <!-- <mapper resource="com/myxh/mybatis/mapper/UserMapper.xml"/> -->
        <!--
            以包的方式引入映射文件，但是必须满足两个条件：
            1、mapper 接口和映射文件所在的包必须一致
            2、mapper 接口的名字和映射文件的名字必须一致
         -->
        <package name="com.myxh.mybatis.mapper"/>
    </mappers>
</configuration>
```

## 4、MyBatis 的增删改查

### 4.1、新增

```xml
<!-- int insertUser(); -->
<insert id="insertUser">
    insert into t_user (id, username, password, age, gender, email)
    values (null, 'myxh', '520.ILY!', 21, '男', '1735350920@qq.com'),
            (null, 'root', '000000', 21, '男', 'root@qq.com'),
            (null, 'admin', '123456', 21, '男', 'admin@qq.com');
</insert>
```

### 4.2、删除

```xml
<!-- int deleteUser(); -->
<delete id="deleteUser">
    delete from t_user where id = 3;
</delete>
```

### 4.3、修改

```xml
<!-- int updateUser(); -->
<update id="updateUser">
    update t_user set email = 'denglei_myxh@qq.com' where id = 1;
</update>
```

### 4.4、查询一个实体类对象

```xml
<!-- User getUserById(Integer id); -->
<!--
        resultType：设置结果类型，即查询的数据要转换为的 Java 类型
        resultMap：自定义映射，处理一对多或多对一的映射关系
    -->
<select id="getUserById" resultType="User">
    select * from t_user where id = 1;
</select>
```

### 4.5、查询 list 集合

```xml
<!-- List<User> getAllUser(); -->
<select id="getAllUser" resultType="User">
    select * from t_user;
</select>
```

> 注意：
>
> 查询的标签 select 必须设置属性 resultType 或 resultMap，用于设置实体类和数据库表的映射关系。
>
> resultType：自动映射，用于属性名和表中字段名一致的情况。
>
> resultMap：自定义映射，用于一对多或多对一或字段名和属性名不一致的情况。

## 5、MyBatis 获取参数值的两种方式

> MyBatis 获取参数值的两种方式：**${}** 和 **#{}**
>
> ${} 的本质就是字符串拼接，#{} 的本质就是占位符赋值。
>
> ${} 使用字符串拼接的方式拼接 sql，若为字符串类型或日期类型的字段进行赋值时，需要手动加单引号；但是 #{} 使用占位符赋值的方式拼接 sql，此时为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号。

### 5.1、单个字面量类型的参数

> 若 mapper 接口中的方法参数为单个的字面量类型，此时可以使用 \${} 和 \#{} 以任意的名称获取参数的值，注意 $ {} 需要手动加单引号。

### 5.2、多个字面量类型的参数

> 若 mapper 接口中的方法参数为多个时，此时 MyBatis 会自动将这些参数放在一个 map 集合中，以 arg0, arg1 ... 为键，以参数为值；以 param1, param2 ... 为键，以参数为值；因此只需要通过 \${} 和 \#{} 访问 map 集合的键就可以获取相对应的值，注意 ${} 需要手动加单引号。

### 5.3、map 集合类型的参数

> 若 mapper 接口中的方法需要的参数为多个时，此时可以手动创建 map 集合，将这些数据放在 map 中只需要通过 \${} 和 \#{} 访问 map 集合的键就可以获取相对应的值，注意${}需要手动加单引号。

### 5.4、实体类类型的参数

> 若 mapper 接口中的方法参数为实体类对象时，此时可以使用 \${} 和 \#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号。

### 5.5、使用@Param 标识参数

> 可以通过@Param 注解标识 mapper 接口中的方法参数，此时会将这些参数放在 map 集合中，以@Param 注解的 value 属性值为键，以参数为值；以 param1, param2 ... 为键，以参数为值；只需要通过 \${} 和 \#{} 访问 map 集合的键就可以获取相对应的值，注意 ${} 需要手动加单引号。

## 6、MyBatis 的各种查询功能

### 6.1、查询一个实体类对象

```java
/**
 * 根据 id 查询用户信息
 *
 * @param id 用户 id
 * @return 一个用户信息
 */
User getUserById(@Param("id") Integer id);
```

```xml
<!-- User getUserById(@Param("id") Integer id); -->
<select id="getUserById" resultType="User">
    select * from t_user where id = #{id};
</select>
```

### 6.2、查询一个 list 集合

```java
/**
 * 查询所有的用户信息
 *
 * @return 所有用户信息
 */
List<User> getAllUser();
```

```xml
<!-- List<User> getAllUser(); -->
<select id="getAllUser" resultType="User">
    select * from t_user;
</select>
```

> 当查询的数据为多条时，不能使用实体类作为返回值，否则会抛出异常 TooManyResultsException；但是若查询的数据只有一条，可以使用实体类或集合作为返回值。

### 6.3、查询单个数据

```java
/**
 * 查询用户的总数量
 *
 * @return 用户的总数量
 */
Integer getUserCount();
```

```xml
<!-- Integer getUserCount(); -->
<!--
MyBatis 中为 Java 中常用的类型设置了类型别名：
Integer：Integer，int
int：_int，_integer
Map：map
String：string
    -->
<select id="getUserCount" resultType="Integer">
    select count(*) from t_user;
</select>
```

### 6.4、查询一条数据为 map 集合

```java
/**
 * 根据 id 查询用户信息为 userMap 集合
 *
 * @param id 用户 id
 * @return 一个用户信息为 userMap 集合
 */
Map<String, Object> getUserByIdToUserMap(@Param("id") Integer id);
```

```xml
<!-- Map<String, Object> getUserByIdToUserMap(@Param("id") Integer id); -->
<select id="getUserByIdToUserMap" resultType="Map">
    select * from t_user where id = #{id};
</select>
```

### 6.5、查询多条数据为 map 集合

#### 6.5.1 ① 方式一

```java
/**
 * 查询所有的用户信息为 userMap 集台
 *
 * @return 所有用户信息为 userMap 集合
 */
List<Map<String, Object>> getAllUserToUserMap();
```

```xml
<!-- Map<String, Object> getAllUserToUserMap(); -->
<select id="getAllUserToUserMap" resultType="Map">
    select * from t_user;
</select>
```

#### 6.5.2 ② 方式二

```java
/**
 * 查询所有的用户信息为 userMap 集台
 * 若查询的数据有多条时，并且要将每条数据转换为 map 集合，
 * 此时有两种解决方案:
 * 1、将 mapper 接口方法的返回值设置为泛型是 Map 的 List 集合
 * List<Map<string，object>> getAllUserToUserMap();
 * 结果：[{password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH}, {password=000000, gender=男, id=2, age=21, email=root@qq.com, username=root}, {password=123456, gender=男, id=3, age=21, email=admin@qq.com, username=admin}]
 * 2、可以将每条数据转换的 map 集合放在一个大的 map 中，但是必须要通过 @MapKey 注解，
 * 将查询的某个字段的值作为大的 map 的键
 * @MapKey("id") Map<String, Object> getAllUserToUserMap();
 * 结果：
 * {
 *      1={password=520.ILY!, gender=男, id=1, age=21, email=1735350920@qq.com, username=MYXH},
 *      2={password=000000, gender=男, id=2, age=21, email=root@qq.com, username=root},
 *      3={password=123456, gender=男, id=3, age=21, email=admin@qq.com, username=admin}
 * }
 *
 * @return 所有用户信息为 userMap 集合
 */
@MapKey("id")
Map<String, Object> getAllUserToUserMap();
```

```xml
<!-- Map<String, Object> getAllUserToUserMap(); -->
<select id="getAllUserToUserMap" resultType="Map">
    select * from t_user;
</select>
```

## 7、特殊 SQL 的执行

### 7.1、模糊查询

```java
/**
 * 通过用户名模糊查询用户信息
 *
 * @param vagueUsername 模糊用户名
 * @return 一些用户信息
 */
List<User> getUserByLikeUsername(@Param("vagueUsername") String vagueUsername);
```

```xml
<!-- List<User> getUserByLikeUsername(@Param("username") String vagueUsername); -->
<select id="getUserByLikeUsername" resultType="User">
    <!-- select * from t_user where username like '%${vagueUsername}%'; -->
    <!-- select * from t_user where username like concat('%', #{vagueUsername}, '%'); -->
    select * from t_user where username like "%"#{vagueUsername}"%";
</select>
```

### 7.2、批量删除

```java
/**
 * 批量删除用户信息
 *
 * @param ids 一些用户 id
 * @return 影响的行数
 */
int deleteMoreUserByIds(@Param("ids") String ids);
```

```xml
<!-- int deleteMoreUserByIds(@Param("ids") String ids); -->
<delete id="deleteMoreUserByIds">
    <!-- ids: 4, 5 -->
    delete from t_user where id in(${ids});
</delete>
```

### 7.3、动态设置表名

```java
/**
 * 动态设置表名，查询用户信息
 *
 * @param tableName 动态表名
 * @return 一些用户信息
 */
List<User> getUserByTableNameToList(@Param("tableName") String tableName);
```

```xml
<!-- List<User> getUserByTableNameToList(@Param("tableName") String tableName); -->
<select id="getUserByTableNameToList" resultType="User">
    select * from ${tableName};
</select>
```

### 7.4、添加功能获取自增的主键

> 场景模拟：
>
> t_clazz(clazz_id,clazz_name)
>
> t_student(student_id,student_name,clazz_id)
>
> 1、添加班级信息
>
> 2、获取新添加的班级的 id
>
> 3、为班级分配学生，即将某学的班级 id 修改为新添加的班级的 id

```java
/**
 * 添加用户信息并获取自增的主键
 *
 * @param user 用户信息
 * @return 影响的行数
 */
int insertUser(User user);
```

```xml
<!-- int insertUser(User user); -->
<!--
useGeneratedKeys：表示当前添加功能使用自增的主键
keyProperty：将添加的数据的自增主键为实体类类型的参数的属性值
    -->
<insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
    insert into t_user (id, username, password, age, gender, email)
    values (null, #{username}, #{password}, #{age}, #{gender}, #{email});
</insert>
```

## 8、自定义映射 resultMap

### 8.1、resultMap 处理字段和属性的映射关系

> 若字段名和实体类中的属性名不一致，则可以通过 resultMap 设置自定义映射。

```xml
<!--
resultMap：设置自定义的映射关系
id：唯一标识
type：处理映射关系的实体类的类型
常用的标签：
id：处理主键和实体类中属性的映射关系
result：处理普通字段和实体类中属性的映射关系
association：处理多对一的映射关系（处理实体类类型的属性）
collection：处理一对多的映射关系（处理集合类型的属性）
column：设置映射关系中的字段名，必须是 SQL 查询出的某个字段
property：设置映射关系中的属性的属性名，必须是处理的实体类类型中的属性名
    -->
<resultMap id="EmployeeResultMap" type="Employee">
    <id column="employee_id" property="employeeId"/>
    <result column="employee_name" property="employeeName"/>
    <result column="age" property="age"/>
    <result column="gender" property="gender"/>
    <result column="email" property="email"/>
</resultMap>

<!-- Employee getEmployeeByEmployeeId(@Param("employeeId") Integer employeeId); -->
<!--
<select id="getEmployeeByEmployeeId" resultType="Employee">
    select employee_id as employeeId, employee_name as employeeName, age, gender, email from t_employee
    where employee_id = #{employeeId};
</select>
    -->
<!--
<select id="getEmployeeByEmployeeId" resultType="Employee">
    select * from t_employee where employee_id = #{employeeId};
</select>
    -->
<select id="getEmployeeByEmployeeId" resultMap="EmployeeResultMap">
    select * from t_employee where employee_id = #{employeeId};
</select>
```

> 若字段名和实体类中的属性名不一致，但是字段名符合数据库的规则（使用\_），实体类中的属性名符合 Java 的规则（使用驼峰），此时也可通过以下两种方式处理字段名和实体类中的属性的映射关系。
>
> 1、可以通过为字段起别名的方式，保证和实体类中的属性名保持一致。
>
> 2、可以在 MyBatis 的核心配置文件中设置一个全局配置信息 mapUnderscoreToCamelCase，可以在查询表中数据时，自动将\_类型的字段名转换为驼峰。
>
> 例如：字段名 employee_name，设置了 mapUnderscoreToCamelCase，此时字段名就会转换为 employeeName。

### 8.2、多对一映射处理

> 场景模拟：
>
> 查询员工信息以及员工所对应的部门信息。

#### 8.2.1、级联方式处理映射关系

```xml
<resultMap id="EmployeeAndDepartmentResultMap" type="Employee">
    <id column="employee_id" property="employeeId"></id>
    <result column="employee_name" property="employeeName"></result>
    <result column="age" property="age"></result>
    <result column="gender" property="gender"></result>
    <result column="employee_email" property="email"></result>
    <result column="department_id" property="department.departmentId"></result>
    <result column="department_name" property="department.departmentName"></result>
    <result column="department_email" property="department.email"></result>
</resultMap>

<!-- Employee getEmployeeAndDepartmentByEmployeeId(@Param("employeeId") Integer employeeId); -->
<select id="getEmployeeAndDepartmentByEmployeeId" resultMap="EmployeeAndDepartmentResultMap">
    select
    t_e.employee_id,
    t_e.employee_name,
    t_e.age,
    t_e.gender,
    t_e.email as employee_email,
    t_d.department_id,
    t_d.department_name,
    t_d.email as department_email
    from t_employee as t_e
    left join t_department as t_d
    on t_e.department_id = t_d.department_id
    where t_e.employee_id = #{employeeId};
</select>
```

#### 8.2.2、使用 association 处理映射关系

```xml
<resultMap id="EmployeeAndDepartmentResultMap" type="Employee">
    <id column="employee_id" property="employeeId"/>
    <result column="employee_name" property="employeeName"/>
    <result column="age" property="age"/>
    <result column="gender" property="gender"/>
    <result column="employee_email" property="email"/>
    <!--
    association：处理多对一的映射关系（处理实体类类型的属性）
    property：设置需要处理映射关系的属性的属性名
    javaType：设置要处理的属性的类型
        -->
    <association property="department" javaType="Department">
        <id column="department_id" property="departmentId"/>
        <result column="department_name" property="departmentName"/>
        <result column="department_email" property="email"/>
    </association>
</resultMap>

<!-- Employee getEmployeeAndDepartmentByEmployeeId(@Param("employeeId") Integer employeeId); -->
<select id="getEmployeeAndDepartmentByEmployeeId" resultMap="EmployeeAndDepartmentResultMap">
    select
    t_e.employee_id,
    t_e.employee_name,
    t_e.age,
    t_e.gender,
    t_e.email as employee_email,
    t_d.department_id,
    t_d.department_name,
    t_d.email as department_email
    from t_employee as t_e
    left join t_department as t_d
    on t_e.department_id = t_d.department_id
    where t_e.employee_id = #{employeeId};
</select>
```

#### 8.2.3、分步查询

##### 8.2.3.1 ① 查询员工信息

```java
/**
 * 通过分步查询查询员工信息以及所对应的部信息的第一步
 *
 * @param employeeId 员工 id
 * @return 一个员工信息
 */
Employee getEmployeeAndDepartmentByStepOne(@Param("employeeId") Integer employeeId);
```

```xml
<resultMap id="EmployeeAndDepartmentByStepResultMap" type="Employee">
    <id column="employee_id" property="employeeId"/>
    <result column="employee_name" property="employeeName"/>
    <result column="age" property="age"/>
    <result column="gender" property="gender"/>
    <result column="email" property="email"/>
    <!--
    property：设置需要处理映射关系的属性的属性名
    fetchType：在开启了延迟加载的环境中，通过该属性设置当前的分步查询是否使用延迟加
    fetchType="eager（立即加裁） | lazy（延迟加载）
    select：设置分步查询的 SQL 的唯一标识
    column：将查询出的某个字段作为分步查询的 SQL 的条件
        -->
    <association property="department" fetchType="eager"
                    select="com.myxh.mybatis.mapper.DepartmentMapper.getEmployeeAndDepartmentByStepTwo"
                    column="department_id">
    </association>
</resultMap>

<!-- Employee getEmployeeAndDepartmentByStepOne(@Param("employeeId") Integer employeeId); -->
<select id="getEmployeeAndDepartmentByStepOne" resultMap="EmployeeAndDepartmentByStepResultMap">
    select * from t_employee where employee_id = #{employeeId};
</select>
```

##### 8.2.3.2 ② 根据员工所对应的部门 id 查询部门信息

```java
/**
 * 通过分步查询查询员工信息以及所对应的部信息的第二步
 *
 * @param departmentId 部门 id
 * @return 一个员工所对应的部门信息
 */
Department getEmployeeAndDepartmentByStepTwo(@Param("departmentId") Integer departmentId);
```

```xml
<!-- Department getEmployeeAndDepartmentByStepTwo(@Param("departmentId") Integer departmentId); -->
<select id="getEmployeeAndDepartmentByStepTwo" resultType="Department">
    select * from t_department where department_id = #{departmentId};
</select>
```

### 8.3、一对多映射处理

#### 8.3.1、collection

```java
/**
 * 根据 id 获取部门信息以及部门中的所有员工信息
 *
 * @param departmentId 部门 id
 * @return 一个部门信息以及部门中的所有员工信息
 */
Department getDepartmentAndEmployeeByDepartmentId(@Param("departmentId") Integer departmentId);
```

```xml
<resultMap id="DepartmentAndEmployeeResultMap" type="Department">
    <id column="department_id" property="departmentId"/>
    <result column="department_name" property="departmentName"/>
    <result column="department_email" property="email"/>
    <!--
    collection：处理一对多的映射关系（处理集合类型的属性）
    ofType：设置要处理的集合类型的属性中存储的数据的类型
        -->
    <collection property="employees" ofType="Employee">
        <id column="employee_id" property="employeeId"/>
        <result column="employee_name" property="employeeName"/>
        <result column="age" property="age"/>
        <result column="gender" property="gender"/>
        <result column="employee_email" property="email"/>
    </collection>
</resultMap>

<!-- Department getDepartmentAndEmployeeByDepartmentId(@Param("departmentId") Integer departmentId); -->
<select id="getDepartmentAndEmployeeByDepartmentId" resultMap="DepartmentAndEmployeeResultMap">
    select
    t_d.department_id,
    t_d.department_name,
    t_d.email as department_email,
    t_e.employee_id,
    t_e.employee_name,
    t_e.age,
    t_e.gender,
    t_e.email as employee_email
    from t_department as t_d
    left join t_employee as t_e
    on t_d.department_id = t_e.department_id
    where t_d.department_id = #{departmentId};
</select>
```

#### 8.3.2、分步查询

##### 8.3.2.1 ① 查询部门信息

```java
/**
 * 通过分步查询查询部门信息以及部门中的所有员工信息的第一步
 *
 * @param departmentId 部门 id
 * @return 一个部门信息
 */
Department getDepartmentAndEmployeeByStepOne(@Param("departmentId") Integer departmentId);
```

```xml
<resultMap id="DepartmentAndEmployeeByStepResultMap" type="Department">
    <id column="department_id" property="departmentId"/>
    <result column="department_name" property="departmentName"/>
    <result column="email" property="email"/>
    <collection property="employees" fetchType="eager"
                select="com.myxh.mybatis.mapper.EmployeeMapper.getDepartmentAndEmployeeByStepTwo"
                column="department_id">
    </collection>
</resultMap>

<!-- Department getDepartmentAndEmployeeByStepOne(@Param("departmentId") Integer departmentId); -->
<select id="getDepartmentAndEmployeeByStepOne" resultMap="DepartmentAndEmployeeByStepResultMap">
    select * from t_department where department_id = #{departmentId};
</select>
```

##### 8.3.2.2 ② 根据部门 id 查询部门中的所有员工

```java
/**
 * 通过分步查询查询部门信息以及部门中的所有员工信息的第二步
 *
 * @param departmentId 部门 id
 * @return 一个部门中的所有员工信息
 */
List<Employee> getDepartmentAndEmployeeByStepTwo(@Param("departmentId") Integer departmentId);
```

```xml
<!-- List<Employee> getDepartmentAndEmployeeByStepTwo(@Param("departmentId") Integer departmentId); -->
<select id="getDepartmentAndEmployeeByStepTwo" resultType="Employee">
    select * from t_employee where department_id = #{departmentId};
</select>
```

> 分步查询的优点：可以实现延迟加载。
>
> 但是必须在核心配置文件中设置全局配置信息：
>
> lazyLoadingEnabled：延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。
>
> aggressiveLazyLoading：当开启时，任何方法的调用都会加载该对象的所有属性。否则，每个属性会按需加载。
>
> 此时就可以实现按需加载，获取的数据是什么，就只会执行相应的 sql。此时可通过 association 和 collection 中的 fetchType 属性设置当前的分步查询是否使用延迟加载，fetchType="lazy(延迟加载)|eager(立即加载)"。

## 9、动态 SQL

> Mybatis 框架的动态 SQL 技术是一种根据特定条件动态拼装 SQL 语句的功能，它存在的意义是为了解决拼接 SQL 语句字符串时的痛点问题。

### 9.1、if

> if 标签可通过 test 属性的表达式进行判断，若表达式的结果为 true，则标签中的内容会执行；反之标签中的内容不会执行。

```xml
<!-- List<Employee> getEmployeeByCondition(Employee employee); -->
<select id="getEmployeeByCondition" resultType="Employee">
        select * from t_employee where 1=1
        <if test="employeeName != null and employeeName != ''">
            and employee_name = #{employeeName}
        </if>
        <if test="age != null">
            and age = #{age}
        </if>
        <if test="gender != null and gender != ''">
            and gender = #{gender}
        </if>
        <if test="email != null and email != ''">
            and email = #{email}
        </if>
        ;
    </select>
```

### 9.2、where

> where 和 if 一般结合使用：
>
> 1、若 where 标签中的 if 条件都不满足，则 where 标签没有任何功能，即不会添加 where 关键字。
>
> 2、若 where 标签中的 if 条件满足，则 where 标签会自动添加 where 关键字，并将条件最前方多余的 and 去掉。
>
> 注意：where 标签不能去掉条件最后多余的 and。

```xml
<!-- List<Employee> getEmployeeByCondition(Employee employee); -->
<select id="getEmployeeByCondition" resultType="Employee">
    select * from t_employee
    <where>
        <if test="employeeName != null and employeeName != ''">
            employee_name = #{employeeName}
        </if>
        <if test="age != null">
            and age = #{age}
        </if>
        <if test="gender != null and gender != ''">
            and gender = #{gender}
        </if>
        <if test="email != null and email != ''">
            and email = #{email}
        </if>
    </where>
    ;
</select>
```

### 9.3、trim

> trim 用于去掉或添加标签中的内容。
>
> 常用属性：
>
> prefix：在 trim 标签中的内容的前面添加某些内容。
>
> prefixOverrides：在 trim 标签中的内容的前面去掉某些内容。
>
> suffix：在 trim 标签中的内容的后面添加某些内容。
>
> suffixOverrides：在 trim 标签中的内容的后面去掉某些内容。

```xml
<!-- List<Employee> getEmployeeByCondition(Employee employee); -->
<select id="getEmployeeByCondition" resultType="Employee">
    select * from t_employee
    <trim prefix="where" suffixOverrides="and">
        <if test="employeeName != null and employeeName != ''">
            employee_name = #{employeeName} and
        </if>
        <if test="age != null">
            age = #{age} and
        </if>
        <if test="gender != null and gender != ''">
            gender = #{gender} and
        </if>
        <if test="email != null and email != ''">
            email = #{email}
        </if>
    </trim>
    ;
</select>
```

### 9.4、choose、when、otherwise

> choose、when、 otherwise 相当于 if ... else if ... else。

```xml
<!-- List<Employee> getEmployeeByChoose(Employee employee); -->
<select id="getEmployeeByChoose" resultType="Employee">
    select <include refid="employeeColumns"/> from t_employee
    <where>
        <choose>
            <when test="employeeName != null and employeeName != ''">
                employee_name = #{employeeName}
            </when>
            <when test="age != null">
                age = #{age}
            </when>
            <when test="gender != null and gender != ''">
                gender = #{gender}
            </when>
            <when test="email != null and email != ''">
                email = #{email}
            </when>
        </choose>
    </where>
    ;
</select>
```

### 9.5、foreach

```xml
<!-- int insertMoreEmployee(@Param("employees") List<Employee> employees); -->
<insert id="insertMoreEmployee">
    insert into t_employee (employee_id, employee_name, age, gender, email, department_id)
    values
    <foreach collection="employees" item="employee" separator=",">
        (null, #{employee.employeeName}, #{employee.age}, #{employee.gender}, #{employee.email}, null)
    </foreach>
    ;
</insert>

<!-- int deleteMoreEmployee(@Param("employeeIds") Integer[] employeeIds); -->
<delete id="deleteMoreEmployee">
    delete from t_employee where employee_id in
    <foreach collection="employeeIds" item="employeeId" separator="," open="(" close=")">
        #{employeeId}
    </foreach>
    ;
</delete>

<!-- int deleteMoreEmployee(@Param("employeeIds") Integer[] employeeIds); -->
<delete id="deleteMoreEmployee">
    delete from t_employee where
    <foreach collection="employeeIds" item="employeeId" separator="or">
        employee_id = #{employeeId}
    </foreach>
    ;
</delete>
```

### 9.6、SQL 片段

> sql 片段，可以记录一段公共 sql 片段，在使用的地方通过 include 标签进行引入。

```xml
<sql id="employeeColumns">
    employee_id, employee_name, age, gender, email, department_id
</sql>
select <include refid="employeeColumns"/> from t_employee;
```

## 10、MyBatis 的缓存

### 10.1、MyBatis 的一级缓存

一级缓存是 SqlSession 级别的，通过同一个 SqlSession 查询的数据会被缓存，下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问。

使一级缓存失效的四种情况：

1. 不同的 SqlSession 对应不同的一级缓存。

2. 同一个 SqlSession 但是查询条件不同。

3. 同一个 SqlSession 两次查询期间执行了任何一次增删改操作。

4. 同一个 SqlSession 两次查询期间手动清空了缓存。

### 10.2、MyBatis 的二级缓存

二级缓存是 SqlSessionFactory 级别，通过同一个 SqlSessionFactory 创建的 SqlSession 查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取。

二级缓存开启的条件：

1、在核心配置文件中，设置全局配置属性 cacheEnabled="true"，默认为 true，不需要设置。

2、在映射文件中设置标签\<cache/>。

3、二级缓存必须在 SqlSession 关闭或提交之后有效。

4、查询的数据所转换的实体类类型必须实现序列化的接口。

使二级缓存失效的情况：

两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效。

### 10.3、二级缓存的相关配置

在 mapper 配置文件中添加的 cache 标签可以设置一些属性：

① eviction 属性：缓存回收策略，默认的是 LRU。

LRU（Least Recently Used） – 最近最少使用的：移除最长时间不被使用的对象。

FIFO（First in First out） – 先进先出：按对象进入缓存的顺序来移除它们。

SOFT – 软引用：移除基于垃圾回收器状态和软引用规则的对象。

WEAK – 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。

② flushInterval 属性：刷新间隔，单位毫秒。

默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新。

③ size 属性：引用数目，正整数。

代表缓存最多可以存储多少个对象，太大容易导致内存溢出。

④ readOnly 属性：只读， true/false。

true：只读缓存；会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了 很重要的性能优势。

false：读写缓存；会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是 false。

### 10.4、MyBatis 缓存查询的顺序

先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用。

如果二级缓存没有命中，再查询一级缓存。

如果一级缓存也没有命中，则查询数据库。

SqlSession 关闭之后，一级缓存中的数据会写入二级缓存。

### 10.5、整合第三方缓存 EHCache

#### 10.5.1、添加依赖

```xml
<!-- Mybatis EHCache 整合包 -->
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.2.3</version>
</dependency>

<!-- slf4j 日志门面的一个具体实现 -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.7</version>
</dependency>
```

#### 10.5.2、各 jar 包功能

| **jar 包名称**  | **作用**                          |
| --------------- | --------------------------------- |
| mybatis-ehcache | Mybatis 和 EHCache 的整合包       |
| ehcache         | EHCache 核心包                    |
| slf4j-api       | SLF4J 日志门面包                  |
| logback-classic | 支持 SLF4J 门面接口的一个具体实现 |

#### 10.5.3、创建 EHCache 的配置文件 ehcache.xml

```xml
<?xml version="1.0" encoding="utf-8" ?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="../config/ehcache.xsd">
    <!-- 磁盘保存路径 -->
    <diskStore path=".\ehcache"/>
    <defaultCache
            maxElementsInMemory="1000"
            maxElementsOnDisk="10000000"
            eternal="false"
            overflowToDisk="true"
            timeToIdleSeconds="120"
            timeToLiveSeconds="120"
            diskExpiryThreadIntervalSeconds="120"
            memoryStoreEvictionPolicy="LRU">
    </defaultCache>
</ehcache>
```

#### 10.5.4、设置二级缓存的类型

```xml
<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
```

#### 10.5.5、加入 logback 日志

> 存在 SLF4J 时，作为简易日志的 log4j 将失效，此时我们需要借助 SLF4J 的具体实现 logback 来打印日志。 创建 logback 的配置文件 logback.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="true">
    <!-- 指定日志输出的位置 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- 日志输出的格式 -->
            <!-- 按照顺序分别是：时间、日志级别、线程名称、打印日志的类、日志主体内容、换行 -->
            <pattern>[%d{HH:mm:ss.SSS}] [%-5level] [%thread] [%logger]
                [%msg]%n
            </pattern>
        </encoder>
    </appender>

    <!-- 设置全局日志级别，日志级别按顺序分别是： DEBUG、INFO、WARN、ERROR -->
    <!-- 指定任何一个日志级别都只打印当前级别和后面级别的日志 -->
    <root level="DEBUG">
        <!-- 指定打印日志的 appender，这里通过 "STDOUT" 引用了前面配置的 appender -->
        <appender-ref ref="STDOUT"/>
    </root>

    <!-- 根据特殊需求指定局部日志级别 -->
    <logger name="com.myxh.mybatis.mapper" level="DEBUG"/>
</configuration>
```

#### 10.5.6、EHCache 配置文件说明

| **属性名**                      | **是否必须** | **作用**                                                                                                                                                   |
| ------------------------------- | ------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| maxElementsInMemory             | 是           | 在内存中缓存的 element 的最大数目。                                                                                                                        |
| maxElementsOnDisk               | 是           | 在磁盘上缓存的 element 的最大数目，若是 0 表示无穷大。                                                                                                     |
| eternal                         | 是           | 设定缓存的 elements 是否永远不过期。 如果为 true，则缓存的数据始终有效， 如果为 false 那么还要根据 timeToIdleSeconds、timeToLiveSeconds 判断。             |
| overflowToDisk                  | 是           | 设定当内存缓存溢出的时候是否将过期的 element 缓存到磁盘上。                                                                                                |
| timeToIdleSeconds               | 否           | 当缓存在 EhCache 中的数据前后两次访问的时间超过 timeToIdleSeconds 的属性取值时， 这些数据便会删除，默认值是 0,也就是可闲置时间无穷大。                     |
| timeToLiveSeconds               | 否           | 缓存 element 的有效生命期，默认是 0.,也就是 element 存活时间无穷大。                                                                                       |
| diskSpoolBufferSizeMB           | 否           | DiskStore(磁盘缓存)的缓存区大小。默认是 30MB。每个 Cache 都应该有自己的一个缓冲区。                                                                        |
| diskPersistent                  | 否           | 在 VM 重启的时候是否启用磁盘保存 EhCache 中的数据，默认是 false。                                                                                          |
| diskExpiryThreadIntervalSeconds | 否           | 磁盘缓存的清理线程运行间隔，默认是 120 秒。每个 120s， 相应的线程会进行一次 EhCache 中数据的清理工作。                                                     |
| memoryStoreEvictionPolicy       | 否           | 当内存缓存达到最大，有新的 element 加入的时候， 移除缓存中 element 的策略。 默认是 LRU （最近最少使用），可选的有 LFU （最不常使用）和 FIFO （先进先出）。 |

## 11、MyBatis 的逆向工程

> 正向工程：先创建 Java 实体类，由框架负责根据实体类生成数据库表。 Hibernate 是支持正向工程的。
>
> 逆向工程：先创建数据库表，由框架负责根据数据库表，反向生成如下资源：
>
> - Java 实体类
>
> - Mapper 接口
>
> - Mapper 映射文件

### 11.1、创建逆向工程的步骤

#### 11.1.1 ① 添加依赖和插件

```xml
<!-- 依赖 MyBatis 核心包 -->
<dependencies>
    <!-- MySQL 驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>

    <!-- Mybatis 核心 -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.13</version>
    </dependency>

    <!-- junit 测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>

    <!-- log4j 日志 -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>
</dependencies>

<!-- 控制 Maven 在构建过程中相关配置 -->
<build>
    <!-- 构建过程中用到的插件 -->
    <plugins>
        <!-- 具体插件，逆向工程的操作是以构建过程中插件形式出现的 -->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.0</version>
            <!-- 插件的依赖 -->
            <dependencies>
                <!-- 逆向工程的核心依赖 -->
                <dependency>
                    <groupId>org.mybatis.generator</groupId>
                    <artifactId>mybatis-generator-core</artifactId>
                    <version>1.3.2</version>
                </dependency>

                <!-- MySQL 驱动 -->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.33</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```

#### 11.1.2 ② 创建 MyBatis 的核心配置文件

#### 11.1.3 ③ 创建逆向工程的配置文件

> 文件名必须是：generatorConfig.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--
    targetRuntime：执行生成的逆向工程的版本
    MyBatis3Simple：生成基本的 CRUD（清新简洁版）
    MyBatis3：生成带条件的 CRUD（奢华尊享版）
     -->
    <context id="DB2Tables" targetRuntime="MyBatis3">
        <!-- 数据库的连接信息 -->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"
                        userId="MYXH"
                        password="520.ILY!">
        </jdbcConnection>

        <!-- javaBean 的生成策略-->
        <javaModelGenerator targetPackage="com.myxh.mybatis.pojo"
                            targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- SQL 映射文件的生成策略 -->
        <sqlMapGenerator targetPackage="com.myxh.mybatis.mapper"
                         targetProject=".\src\main\resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- Mapper 接口的生成策略 -->
        <javaClientGenerator type="XMLMAPPER"
                             targetPackage="com.myxh.mybatis.mapper" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!-- 逆向分析的表 -->
        <!-- tableName 设置为 * 号，可以对应所有表，此时不写 domainObjectName -->
        <!-- domainObjectName 属性指定生成出来的实体类的类名 -->
        <table tableName="t_employee" domainObjectName="Employee"/>
        <table tableName="t_department" domainObjectName="Department"/>
    </context>
</generatorConfiguration>
```

#### 11.1.4 ④ 执行 MBG（myBatis-generate） 插件的 generate 目标

![④ 执行 MBG（myBatis-generate） 插件的 generate 目标](https://img-blog.csdnimg.cn/a01cbefd245a4eb5abccd58b2f22ceec.png)

#### 11.1.5 ⑤ 效果

![⑤ 效果](https://img-blog.csdnimg.cn/15b615ec743b47c898afe051886e6dd7.png)

### 11.2、QBC（Query By Example 根据样例查询） 查询

```java
package com.myxh.mybatis.test;

import com.myxh.mybatis.mapper.EmployeeMapper;
import com.myxh.mybatis.pojo.Employee;
import com.myxh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author MYXH
 * @date 2023/8/15
 */
public class mybatisGeneratorTest
{
    @Test
    public void testMybatisGenerator()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 根据 id 查询数据
        Employee employee = mapper.selectByPrimaryKey(1);
        System.out.println("结果：" + employee);

        // 查询所有数据
        List<Employee> employeeList = mapper.selectByExample(null);
        employeeList.forEach(System.out::println);

        // 根据条件查询数据

        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmployeeNameEqualTo("MYXH").andAgeGreaterThanOrEqualTo(20);
        example.or().andGenderEqualTo("男");
        List<Employee> employeeList = mapper.selectByExample(example);
        employeeList.forEach(System.out::println);

        // 测试普通修改功能
        /*
        Employee employee = new Employee(1, "末影小黑xh", 21, "男" , "1735350920@qq.com", null);
        int result = mapper.updateByPrimaryKey(employee);
        System.out.println("结果：" + result);
         */

        // 测试选择性修改功能
        Employee employee = new Employee(1, "末影小黑xh", 21, "男" , "1735350920@qq.com", null);
        int result = mapper.updateByPrimaryKeySelective(employee);
        System.out.println("结果：" + result);

        sqlSession.close();
    }
}
```

## 12、分页插件

SQL 语句：

```sql
SELECT * FROM t_employee
LIMIT index, pageSize;
```

分页代码：

```java
// 每页显示的条数
int pageSize;

// 当前页的页码
int pageNum;

// 当前页的起始索引
int index = (pageNum - 1) \* pageSize;

// 总记录数
int count;

// 总页数
int totalPage = count / pageSize;

if(count % pageSize != 0)
{
    totalPage += 1;
}
```

计算规律：

> pageSize = 5，pageNum = 1，index = 0，limit 0, 5
>
> pageSize = 5，pageNum = 3，index = 10，limit 10, 5
>
> pageSize = 5，pageNum = 6，index = 25，limit 25, 5

分页效果：

> 首页 上一页 2 3 4 5 6 下一页 末页

### 12.1、分页插件的使用步骤

#### 12.1.1 ① 添加依赖

```xml
<!-- 分页插件 -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.3.2</version>
</dependency>
```

#### 12.1.2 ② 配置分页插件

在 MyBatis 的核心配置文件中配置插件。

```xml
<plugins>
    <!-- 设置分页插件 -->
    <plugin interceptor="com.github.pagehelper.PageInterceptor"/>
</plugins>
```

### 12.2、分页插件的使用

1、在查询功能之前使用 PageHelper.startPage(int pageNum, int pageSize);开启分页功能。

> pageNum：当前页的页码
>
> pageSize：每页显示的条数

2、在查询获取 list 集合之后，使用 PageInfo<T> pageInfo = new PageInfo<>(List<T> list, int navigatePages);获取分页相关数据。

> list：分页之后的数据
>
> navigatePages：导航分页的页码数

3、分页相关数据。

> pageInfo = PageInfo{
> pageNum=1,
> pageSize=5,
> size=5,
> startRow=1,
> endRow=5,
> total=30,
> pages=6,
> list=Page{
> count=true,
> pageNum=1,
> pageSize=5,
> startRow=0,
> endRow=5,
> total=30,
> pages=6,
> reasonable=false,
> pageSizeZero=false
> }
> [Employee{employeeId=1, employeeName='MYXH', age=21, gender='男', email='1735350920@qq.com', departmentId=1}, Employee{employeeId=2, employeeName='张三', age=20, gender='男', email='zhangsan@qq.com', departmentId=1}, Employee{employeeId=3, employeeName='李四', age=22, gender='男', email='lisi@qq.com', departmentId=2}, Employee{employeeId=4, employeeName='王五', age=23, gender='男', email='wangwu@qq.com', departmentId=2}, Employee{employeeId=5, employeeName='赵六', age=24, gender='男', email='zhaoliu@qq.com', departmentId=3}],
> prePage=0,
> nextPage=2,
> isFirstPage=true,
> isLastPage=false,
> hasPreviousPage=false,
> hasNextPage=true,
> navigatePages=5,
> navigateFirstPage=1,
> navigateLastPage=5,
> navigatepageNums=[1, 2, 3, 4, 5]}

> pageNum：当前页的页码
>
> pageSize：每页显示的条数
>
> size：当前页显示的真实条数
>
> total：总记录数
>
> pages：总页数
>
> prePage：上一页的页码
>
> nextPage：下一页的页码
>
> isFirstPage/isLastPage：是否为第一页/最后一页
>
> hasPreviousPage/hasNextPage：是否存在上一页/下一页
>
> navigatePages：导航分页的页码数
>
> navigatepageNums：导航分页的页码，[1, 2, 3, 4, 5]

# 二、Spring

## 1、Spring 简介

### 1.1、Spring 概述

官网地址：https://spring.io/

> Spring 是最受欢迎的企业级 Java 应用程序开发框架，数以百万的来自世界各地的开发人员使用。
>
> Spring 框架来创建性能好、易于测试、可重用的代码。
>
> Spring 框架是一个开源的 Java 平台，它最初是由 Rod Johnson 编写的，并且于 2003 年 6 月首次在 Apache 2.0 许可下发布。
>
> Spring 是轻量级的框架，其基础版本只有 2 MB 左右的大小。
>
> Spring 框架的核心特性是可以用于开发任何 Java 应用程序，但是在 Java EE 平台上构建 web 应用程序是需要扩展的。 Spring 框架的目标是使 J2EE 开发变得更容易使用，通过启用基于 POJO 编程模型来促进良好的编程实践。

### 1.2、Spring 家族

项目列表：https://spring.io/projects

### 1.3、Spring Framework

Spring 基础框架，可以视为 Spring 基础设施，基本上任何其他 Spring 项目都是以 Spring Framework 为基础的。

#### 1.3.1、Spring Framework 特性

- 非侵入式：使用 Spring Framework 开发应用程序时，Spring 对应用程序本身的结构影响非常小。对领域模型可以做到零污染；对功能性组件也只需要使用几个简单的注解进行标记，完全不会破坏原有结构，反而能将组件结构进一步简化。这就使得基于 Spring Framework 开发应用程序时结构清晰、简洁优雅。

- 控制反转：IOC——Inversion of Control，翻转资源获取方向。把自己创建资源、向环境索取资源变成环境将资源准备好，我们享受资源注入。

- 面向切面编程：AOP——Aspect Oriented Programming，在不修改源代码的基础上增强代码功能。

- 容器：Spring IOC 是一个容器，因为它包含并且管理组件对象的生命周期。组件享受到了容器化的管理，替程序员屏蔽了组件创建过程中的大量细节，极大的降低了使用门槛，大幅度提高了开发效率。

- 组件化：Spring 实现了使用简单的组件配置组合成一个复杂的应用。在 Spring 中可以使用 XML 和 Java 注解组合这些对象。这使得我们可以基于一个个功能明确、边界清晰的组件有条不紊的搭建超大型复杂应用系统。

- 声明式：很多以前需要编写代码才能实现的功能，现在只需要声明需求即可由框架代为实现。

- 一站式：在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库。而且 Spring 旗下的项目已经覆盖了广泛领域，很多方面的功能性需求可以在 Spring Framework 的基础上全部使用 Spring 来实现。

#### 1.3.2、Spring Framework 五大功能模块

| **功能模块**            | **功能介绍**                                                |
| ----------------------- | ----------------------------------------------------------- |
| Core Container          | 核心容器，在 Spring 环境下使用任何功能都必须基于 IOC 容器。 |
| AOP&Aspects             | 面向切面编程。                                              |
| Testing                 | 提供了对 junit 或 TestNG 测试框架的整合。                   |
| Data Access/Integration | 提供了对数据访问/集成的功能。                               |
| Spring MVC              | 提供了面向 Web 应用程序的集成功能。                         |

## 2、IOC

### 2.1、IOC 容器

#### 2.1.1、IOC 思想

IOC：Inversion of Control，翻译过来是**反转控制**。

##### 2.1.1.1 ① 获取资源的传统方式

自己做饭：买菜、洗菜、择菜、改刀、炒菜，全过程参与，费时费力，必须清楚了解资源创建整个过程中的全部细节且熟练掌握。

在应用程序中的组件需要获取资源时，传统的方式是组件**主动**的从容器中获取所需要的资源，在这样的模式下开发人员往往需要知道在具体容器中特定资源的获取方式，增加了学习成本，同时降低了开发效率。

##### 2.1.1.2 ② 反转控制方式获取资源

点外卖：下单、等、吃，省时省力，不必关心资源创建过程的所有细节。

反转控制的思想完全颠覆了应用程序组件获取资源的传统方式：反转了资源的获取方向——改由容器主动的将资源推送给需要的组件，开发人员不需要知道容器是如何创建资源对象的，只需要提供接收资源的方式即可，极大的降低了学习成本，提高了开发的效率。这种行为也称为查找的**被动**形式。

##### 2.1.1.3 ③ DI

DI：Dependency Injection，翻译过来是**依赖注入**。

DI 是 IOC 的另一种表述方式：即组件以一些预先定义好的方式（例如：setter 方法）接受来自于容器的资源注入。相对于 IOC 而言，这种表述更直接。

所以结论是：IOC 就是一种反转控制的思想，而 DI 是对 IOC 的一种具体实现。

#### 2.1.2、IOC 容器在 Spring 中的实现

Spring 的 IOC 容器就是 IOC 思想的一个落地的产品实现。IOC 容器中管理的组件也叫做 bean。在创建 bean 之前，首先需要创建 IOC 容器。Spring 提供了 IOC 容器的两种实现方式。

##### 2.1.2.1 ① BeanFactory

这是 IOC 容器的基本实现，是 Spring 内部使用的接口。面向 Spring 本身，不提供给开发人员使用。

##### 2.1.2.2 ② ApplicationContext

BeanFactory 的子接口，提供了更多高级特性。面向 Spring 的使用者，几乎所有场合都使用 ApplicationContext 而不是底层的 BeanFactory。

##### 2.1.2.3 ③ ApplicationContext 的主要实现类

![③ ApplicationContext 的主要实现类](https://img-blog.csdnimg.cn/84a76983414146358ffdefae16d9141b.png)

| **类型名**                      | **简介**                                                                                                                      |
| ------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| ClassPathXmlApplicationContext  | 通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象。                                                                      |
| FileSystemXmlApplicationContext | 通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象。                                                                    |
| ConfigurableApplicationContext  | ApplicationContext 的子接口，包含一些扩展方法 refresh() 和 close() ，让 ApplicationContext 具有启动、关闭和刷新上下文的能力。 |
| WebApplicationContext           | 专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。                                   |

### 2.2、基于 XML 管理 bean

#### 2.2.1、实验一：入门案例

##### 2.2.1.1 ① 创建 Maven Module

##### 2.2.1.2 ② 引入依赖

```xml
<dependencies>
    <!-- 基于 Maven 依赖传递性，导入 spring-context 依赖即可导入当前所需所有 jar 包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.0.9</version>
    </dependency>

    <!-- junit 测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

![② 引入依赖](https://img-blog.csdnimg.cn/af0af77502954407b55a50171a7cb941.png)

##### 2.2.1.3 ③ 创建类 HelloWorld

```java
package com.myxh.spring.pojo;

/**
 * @author MYXH
 * @date 2023/8/22
 */
public class HelloWorld
{
    public void sayHello()
    {
        System.out.println("Hello Spring World!");
    }
}
```

##### 2.2.1.4 ④ 创建 Spring 的配置文件

![④ 创建 Spring 的配置文件](https://img-blog.csdnimg.cn/012c95b984a449c9955022f1d5af0a33.png)

![④ 创建 Spring 的配置文件](https://img-blog.csdnimg.cn/641f8993a3d0415498f43f2990311a6b.png)

##### 2.2.1.5 ⑤ 在 Spring 的配置文件中配置 bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--
    bean：配置一个 bean 对象，将对象交给 IOC 容器管理
    属性：
    id：bean 的唯一标识，不能重复
    class：设置 bean 对象所对应的类型
     -->
    <bean id="helloWorld" class="com.myxh.spring.pojo.HelloWorld"/>
</beans>
```

##### 2.2.1.6 ⑥ 创建测试类测试

```java
package com.myxh.spring.test;

import com.myxh.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/22
 */
public class HelloWorldTest
{
    @Test
    public void testHelloWorld()
    {
        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取 IOC 容器中的 bean
        HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");
        helloWorld.sayHello();
    }
}
```

##### 2.2.1.7 ⑦ 思路

![⑦ 思路](https://img-blog.csdnimg.cn/a6d27f2642f9459bb6b126ad511cdd94.png)

##### 2.2.1.8 ⑧ 注意

Spring 底层默认通过反射技术调用组件类的无参构造器来创建组件对象，这一点需要注意。如果在需要无参构造器时，没有无参构造器，则会抛出下面的异常：

> org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'helloworld' defined in class path resource [applicationContext.xml]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.myxh.spring.bean.HelloWorld]: No default constructor found; nested exception is java.lang.NoSuchMethodException: com.myxh.spring.pojo.HelloWorld.\<init\>()

#### 2.2.2、实验二：获取 bean

##### 2.2.2.1 ① 方式一：根据 id 获取

由于 id 属性指定了 bean 的唯一标识，所以根据 bean 标签的 id 属性可以精确获取到一个组件对象。

上个实验中我们使用的就是这种方式。

```java
@Test
public void testIOC()
{
    // 获取 IOC 容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

    // 获取 IOC 容器中的 bean
    Student student1 = (Student) ioc.getBean("student1");
    System.out.println("student1 = " + student1);
}
```

##### 2.2.2.2 ② 方式二：根据类型获取

```java
@Test
public void testIOC()
{
    // 获取 IOC 容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

    // 获取 IOC 容器中的 bean
    Student student = ioc.getBean(Student.class);
    System.out.println("student = " + student);
}
```

##### 2.2.2.3 ③ 方式三：根据 id 和类型

```java
/**
 * 获取 bean 的三种方式：
 * 1、根据 bean 的 id 获取
 * 2、根据 bean 的类型获取
 * 注意：根据类型获 bean 时，要求 IOC 容器中有且只有一个类型匹配的 bean
 * 若没有任何一个类型匹配的 bean，此时抛出异常：NoSuchBeanDefinitionException
 * 若有多个类型匹配的 bean，此时抛出异常：NoUniqueBeanDefinitionException
 * 3、根据 bean 的 id 和类型获取
 *
 * 结论:
 * 根据类型来获取 bean 时，在满足 bean 唯一性的前提下
 * 其实只是看：对象 instanceof 指定的类型的返回结果
 * 只要返回的是 true 就可以认定为和类型匹配，能够获取到
 * 即通过 bean 的类型、bean 所继承的类的类型、bean 所实现的接口的类型都可以获取 bean
 */
@Test
public void testIOC()
{
    // 获取 IOC 容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

    // 获取 IOC 容器中的 bean
    Student student1 = ioc.getBean("student1", Student.class);
    System.out.println("student1 = " + student1);
}
```

##### 2.2.2.4 ④ 注意

当根据类型获取 bean 时，要求 IOC 容器中指定类型的 bean 有且只能有一个。

当 IOC 容器中一共配置了两个：

```xml
<bean id="student1" class="com.myxh.spring.pojo.Student"/>

<bean id="student2" class="com.myxh.spring.pojo.Student"/>
```

根据类型获取时会抛出异常：

> org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.myxh.spring.pojo.Student' available: expected single matching bean but found 2: student1,student2

##### 2.2.2.5 ⑤ 扩展

如果组件类实现了接口，根据接口类型可以获取 bean 吗？

> 可以，前提是 bean 唯一。

如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？

> 不行，因为 bean 不唯一。

##### 2.2.2.6 ⑥ 结论

根据类型来获取 bean 时，在满足 bean 唯一性的前提下，其实只是看：『对象 **instanceof** 指定的类型』的返回结果，只要返回的是 true 就可以认定为和类型匹配，能够获取到。

#### 2.2.3、实验三：依赖注入之 setter 注入

##### 2.2.3.1 ① 创建学生类 Student

```java
package com.myxh.spring.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class Student implements Person
{
    private Integer studentId;
    private String studentName;
    private Integer age;
    private String gender;

    public Student()
    {

    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
```

##### 2.2.3.2 ② 配置 bean 时为属性赋值

```xml
<bean id="student2" class="com.myxh.spring.pojo.Student">
    <!--
    property：通过成员变量的 set 方法进行赋值
    name：设置需要值的属性名（和 set 方法有关）
    value：设置为属性所赋的值
        -->
    <property name="studentId" value="1"/>
    <property name="studentName" value="张三"/>
    <property name="age" value="20"/>
    <property name="gender" value="男"/>
</bean>
```

##### 2.2.3.3 ③ 测试

```java
@Test
public void testDI()
{
    // 获取 IOC 容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

    // 获取 IOC 容器中的 bean
    Student student2 = ioc.getBean("student2", Student.class);
    System.out.println("student2 = " + student2);
}
```

#### 2.2.4、实验四：依赖注入之构造器注入

##### 2.2.4.1 ① 在 Student 类中添加有参构造

```java
public Student(Integer studentId, String studentName, Integer age, String gender)
{
    this.studentId = studentId;
    this.studentName = studentName;
    this.age = age;
    this.gender = gender;
}
```

##### 2.2.4.2 ② 配置 bean

```xml
<bean id="student3" class="com.myxh.spring.pojo.Student">
    <constructor-arg value="2"/>
    <constructor-arg value="李四"/>
    <constructor-arg value="男"/>
    <constructor-arg value="21" name="age"/>
</bean>
```

> 注意：
>
> constructor-arg 标签还有两个属性可以进一步描述构造器参数：
>
> - index 属性：指定参数所在位置的索引（从 0 开始）。
>
> - name 属性：指定参数名。

##### 2.2.4.3 ③ 测试

```java
@Test
public void testDI()
{
    // 获取 IOC 容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

    // 获取 IOC 容器中的 bean
    Student student3 = ioc.getBean("student3", Student.class);
    System.out.println("student3 = " + student3);
}
```

#### 2.2.5、实验五：特殊值处理

##### 2.2.5.1 ① 字面量赋值

> 什么是字面量？
>
> int a = 10;
>
> 声明一个变量 a，初始化为 10，此时 a 就不代表字母 a 了，而是作为一个变量的名字。当我们引用 a 的时候，我们实际上拿到的值是 10。
>
> 而如果 a 是带引号的：'a'，那么它现在不是一个变量，它就是代表 a 这个字母本身，这就是字面量。所以字面量没有引申含义，就是我们看到的这个数据本身。

```xml
<!-- 使用value属性给bean的属性赋值时，Spring会把value属性的值看做字面量 -->
<property name="name" value="张三"/>
```

##### 2.2.5.2 ② null 值

```xml
<property name="gender">
    <null/>
</property>
```

> 注意：
>
> ```xml
> <property name="gender" value="null"/>
> ```
>
> 以上写法，为 name 所赋的值是字符串 null。

##### 2.2.5.2 ③ xml 实体

```xml
<bean id="student4" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="3"/>
    <!--
        <：&lt;
        >：&gt;
     -->
    <property name="studentName" value="&lt;王五&gt;"/>
    <property name="age" value="22"/>
    <property name="gender">
        <null/>
    </property>
</bean>
```

##### 2.2.5.3 ④ CDATA 节

```xml
<bean id="student4" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="3"/>
    <!--
        CDATA 节其中的内容会原样解析 <![CDATA[ ... ]]>
        CDATA 节是 xml 中一个特殊的标签，因此不能写在一个属性中
        -->
    <property name="studentName">
        <value><![CDATA[<王五>]]></value>
    </property>
    <property name="age" value="22"/>
    <property name="gender">
        <null/>
    </property>
</bean>
```

#### 2.2.6、实验六：为类类型属性赋值

##### 2.2.6.1 ① 创建班级类 Clazz

```java
package com.myxh.spring.pojo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class Clazz
{
    private Integer clazzId;
    private String clazzName;

    public Clazz()
    {

    }

    public Clazz(Integer clazzId, String clazzName)
    {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
    }

    public Integer getClazzId()
    {
        return clazzId;
    }

    public void setClazzId(Integer clazzId)
    {
        this.clazzId = clazzId;
    }

    public String getClazzName()
    {
        return clazzName;
    }

    public void setClazzName(String clazzName)
    {
        this.clazzName = clazzName;
    }

    @Override
    public String toString()
    {
        return "Clazz{" +
                "clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                '}';
    }
}
```

##### 2.2.6.2 ② 修改 Student 类

在 Student 类中添加以下代码：

```java
private Clazz clazz;

public Student(Integer studentId, String studentName, Integer age, String gender, Clazz clazz)
{
    this.studentId = studentId;
    this.studentName = studentName;
    this.age = age;
    this.gender = gender;
    this.clazz = clazz;
}

public Clazz getClazz()
{
    return clazz;
}

public void setClazz(Clazz clazz)
{
    this.clazz = clazz;
}

@Override
public String toString()
{
    return "Student{" +
            "studentId=" + studentId +
            ", studentName='" + studentName + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", clazz=" + clazz +
            '}';
}
```

##### 2.2.6.3 ③ 方式一：引用外部已声明的 bean

配置 Clazz 类型的 bean：

```xml
<bean id="clazz1" class="com.myxh.spring.pojo.Clazz">
    <property name="clazzId" value="1"/>
    <property name="clazzName" value="1 班"/>
</bean>
```

为 Student 中的 clazz 属性赋值：

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <!-- ref：引用 IOC 容器中的某个 bean 的 id -->
    <property name="clazz" ref="clazz1"/>
</bean>
```

错误演示：

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <!-- ref：引用 IOC 容器中的某个 bean 的 id -->
    <property name="clazz" value="clazz1"/>
</bean>
```

> 如果错把 ref 属性写成了 value 属性，会抛出异常： Caused by: java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.myxh.spring.bean.Clazz' for property 'clazz': no matching editors or conversion strategy found
>
> 意思是不能把 String 类型转换成我们要的 Clazz 类型，说明我们使用 value 属性时，Spring 只把这个属性看做一个普通的字符串，不会认为这是一个 bean 的 id，更不会根据它去找到 bean 来赋值。

##### 2.2.6.4 ④ 方式二：内部 bean

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <property name="clazz">
        <!-- 内部 bean，只能在当前 bean 的内部使用，不能直接通过 IOC 容器获取 -->
        <bean id="clazzInner" class="com.myxh.spring.pojo.Clazz">
            <property name="clazzId" value="3"/>
            <property name="clazzName" value="3 班"/>
        </bean>
    </property>
</bean>
```

##### 2.2.6.5 ⑤ 方式三：级联属性赋值

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <!-- ref：引用 IOC 容器中的某个 bean 的 id -->
    <property name="clazz" value="clazz1"/>

    <!-- 级联的方式，要保证提前为 Clazz 属性赋值或者实例化-->
    <property name="clazz.clazzId" value="2"/>
    <property name="clazz.clazzName" value="2 班"/>
</bean>

<bean id="clazz1" class="com.myxh.spring.pojo.Clazz">
    <property name="clazzId" value="1"/>
    <property name="clazzName" value="1 班"/>
</bean>
```

#### 2.2.7、实验七：为数组类型属性赋值

##### 2.2.7.1 ① 修改 Student 类

在 Student 类中添加以下代码：

```java
private String[] hobby;

public Student(Integer studentId, String studentName, Integer age, String gender, String[] hobby, Clazz clazz)
{
    this.studentId = studentId;
    this.studentName = studentName;
    this.age = age;
    this.gender = gender;
    this.hobby = hobby;
    this.clazz = clazz;
}

public String[] gethobby()
{
    return hobby;
}
public void sethobby(String[] hobby)
{
    this.hobby = hobby;
}

@Override
public String toString()
{
    return "Student{" +
            "studentId=" + studentId +
            ", studentName='" + studentName + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", hobby=" + Arrays.toString(hobby) +
            ", clazz=" + clazz +
            '}';
}
```

##### 2.2.7.2 ② 配置 bean

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <!-- ref：引用 IOC 容器中的某个 bean 的 id -->
    <!-- <property name="clazz" ref="clazz1"/> -->

    <!-- 级联的方式，要保证提前为 Clazz 属性赋值或者实例化-->
    <!--
    <property name="clazz.clazzId" value="2"/>
    <property name="clazz.clazzName" value="2 班"/>
        -->

    <property name="clazz">
        <!-- 内部 bean，只能在当前 bean 的内部使用，不能直接通过 IOC 容器获取 -->
        <bean id="clazzInner" class="com.myxh.spring.pojo.Clazz">
            <property name="clazzId" value="3"/>
            <property name="clazzName" value="3 班"/>
        </bean>
    </property>

    <property name="hobby">
        <array>
            <value>游戏</value>
            <value>动漫</value>
            <value>音乐</value>
        </array>
    </property>
</bean>
```

#### 2.2.8、实验八：为集合类型属性赋值

##### 2.2.8.1 ① 为 List 集合类型属性赋值

在 Clazz 类中添加以下代码：

```java
private List<Student> students;

public Clazz(Integer clazzId, String clazzName, List<Student> students)
{
    this.clazzId = clazzId;
    this.clazzName = clazzName;
    this.students = students;
}

public List<Student> getStudents()
{
    return students;
}

public void setStudents(List<Student> students)
{
    this.students = students;
}

@Override
public String toString()
{
    return "Clazz{" +
            "clazzId=" + clazzId +
            ", clazzName='" + clazzName + '\'' +
            ", students=" + students +
            '}';
}
```

配置 bean：

```xml
<bean id="clazz1" class="com.myxh.spring.pojo.Clazz">
    <property name="clazzId" value="1"/>
    <property name="clazzName" value="1 班"/>

    <property name="students">
        <list>
            <ref bean="student1"/>
            <ref bean="student2"/>
            <ref bean="student3"/>
            <ref bean="student4"/>
            <ref bean="student5"/>
        </list>
    </property>
</bean>
```

> 若为 Set 集合类型属性赋值，只需要将其中的 list 标签改为 set 标签即可。

##### 2.2.8.2 ② 为 Map 集合类型属性赋值

创建教师类 Teacher：

```java
package com.myxh.spring.pojo;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class Teacher
{
    private Integer teacherId;
    private String teacherName;

    public Teacher()
    {

    }

    public Teacher(Integer teacherId, String teacherName)
    {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Integer getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
```

在 Student 类中添加以下代码：

```java
private Map<String, Teacher> teacherMap;

public Student(Integer studentId, String studentName, Integer age, String gender, String[] hobby, Clazz clazz, Map<String, Teacher> teacherMap)
{
    this.studentId = studentId;
    this.studentName = studentName;
    this.age = age;
    this.gender = gender;
    this.hobby = hobby;
    this.clazz = clazz;
    this.teacherMap = teacherMap;
}

public Map<String, Teacher> getTeacherMap()
{
    return teacherMap;
}

public void setTeacherMap(Map<String, Teacher> teacherMap)
{
    this.teacherMap = teacherMap;
}

@Override
public String toString()
{
    return "Student{" +
            "studentId=" + studentId +
            ", studentName='" + studentName + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", hobby=" + Arrays.toString(hobby) +
            ", clazz=" + clazz +
            ", teacherMap=" + teacherMap +
            '}';
}
```

配置 bean：

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <!-- ref：引用 IOC 容器中的某个 bean 的 id -->
    <!-- <property name="clazz" ref="clazz1"/> -->

    <!-- 级联的方式，要保证提前为 Clazz 属性赋值或者实例化-->
    <!--
    <property name="clazz.clazzId" value="2"/>
    <property name="clazz.clazzName" value="2 班"/>
        -->

    <property name="clazz">
        <!-- 内部 bean，只能在当前 bean 的内部使用，不能直接通过 IOC 容器获取 -->
        <bean id="clazzInner" class="com.myxh.spring.pojo.Clazz">
            <property name="clazzId" value="3"/>
            <property name="clazzName" value="3 班"/>
        </bean>
    </property>

    <property name="hobby">
        <array>
            <value>游戏</value>
            <value>动漫</value>
            <value>音乐</value>
        </array>
    </property>

    <property name="teacherMap">
        <map>
            <entry key="1" value-ref="teacher1"/>
            <entry key="2" value-ref="teacher2"/>
        </map>
    </property>
</bean>

<bean id="teacher1" class="com.myxh.spring.pojo.Teacher">
    <property name="teacherId" value="1"/>
    <property name="teacherName" value="MYXH"/>
</bean>

<bean id="teacher2" class="com.myxh.spring.pojo.Teacher">
    <property name="teacherId" value="2"/>
    <property name="teacherName" value="末影小黑xh"/>
</bean>
```

##### 2.2.8.3 ③ 引用集合类型的 bean

```xml
<bean id="student5" class="com.myxh.spring.pojo.Student">
    <property name="studentId" value="4"/>
    <property name="studentName" value="赵六"/>
    <property name="age" value="23"/>
    <property name="gender" value="男"/>
    <!-- ref：引用 IOC 容器中的某个 bean 的 id -->
    <!-- <property name="clazz" ref="clazz1"/> -->

    <!-- 级联的方式，要保证提前为 Clazz 属性赋值或者实例化-->
    <!--
    <property name="clazz.clazzId" value="2"/>
    <property name="clazz.clazzName" value="2 班"/>
        -->

    <property name="clazz">
        <!-- 内部 bean，只能在当前 bean 的内部使用，不能直接通过 IOC 容器获取 -->
        <bean id="clazzInner" class="com.myxh.spring.pojo.Clazz">
            <property name="clazzId" value="3"/>
            <property name="clazzName" value="3 班"/>
        </bean>
    </property>

    <property name="hobby">
        <array>
            <value>游戏</value>
            <value>动漫</value>
            <value>音乐</value>
        </array>
    </property>

    <!--
    <property name="teacherMap">
        <map>
            <entry key="1" value-ref="teacher1"/>
            <entry key="2" value-ref="teacher2"/>
        </map>
    </property>
        -->

    <property name="teacherMap" ref="teacherMap"/>
</bean>

<bean id="clazz1" class="com.myxh.spring.pojo.Clazz">
    <property name="clazzId" value="1"/>
    <property name="clazzName" value="1 班"/>

    <!--
    <property name="students">
        <list>
            <ref bean="student1"/>
            <ref bean="student2"/>
            <ref bean="student3"/>
            <ref bean="student4"/>
            <ref bean="student5"/>
        </list>
    </property>
        -->

    <property name="students" ref="studentList"/>
</bean>

<!-- 配置一个集合类型的 bean，需要使用 util 的约束 -->
<util:list id="studentList">
    <ref bean="student1"/>
    <ref bean="student2"/>
    <ref bean="student3"/>
    <ref bean="student4"/>
    <ref bean="student5"/>
</util:list>

<util:map id="teacherMap">
    <entry key="1" value-ref="teacher1"/>
    <entry key="2" value-ref="teacher2"/>
</util:map>
```

> 使用 util:list、util:map 标签必须引入相应的命名空间，可以通过 idea 的提示功能选择。

#### 2.2.9、实验九：p 命名空间

引入 p 命名空间后，可以通过以下方式为 bean 的各个属性赋值。

```xml
<bean id="student6" class="com.myxh.spring.pojo.Student"
      p:studentId="6" p:studentName="钱七" p:age="24" p:gender="男" p:teacherMap-ref="teacherMap"/>
```

#### 2.2.10、实验十：引入外部属性文件

##### 2.2.10.1 ① 加入依赖

```xml
<!-- MySQL驱动 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

<!-- 数据源 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.16</version>
</dependency>
```

##### 2.2.10.2 ② 创建外部属性文件

![② 创建外部属性文件](https://img-blog.csdnimg.cn/d9dac5edaed343a2996684b8d42681a2.png)

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.username=MYXH
jdbc.password=520.ILY!
```

##### 2.2.10.3 ③ 引入属性文件

```xml
<!-- 引入外部属性文件 jdbc.properties，之后可以通过 ${key} 的方式访问 value -->
<context:property-placeholder location="jdbc.properties"/>
```

##### 2.2.10.4 ④ 配置 bean

```xml
<!-- 配置数据源 -->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
```

##### 2.2.10.5 ⑤ 测试

```java
package com.myxh.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class DataSourceTest
{
    @Test
    public void testDataSource() throws SQLException
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
        dataSource.close();
    }
}
```

#### 2.2.11、实验十一：bean 的作用域

##### 2.2.11.1 ① 概念

在 Spring 中可以通过配置 bean 标签的 scope 属性来指定 bean 的作用域范围，各取值含义参加下表：

| **取值**          | **含义**                                      | **创建对象的时机** |
| ----------------- | --------------------------------------------- | ------------------ |
| singleton（默认） | 在 IOC 容器中，这个 bean 的对象始终为单实例。 | IOC 容器初始化时。 |
| prototype         | 这个 bean 在 IOC 容器中有多个实例。           | 获取 bean 时。     |

如果是在 WebApplicationContext 环境下还会有另外两个作用域（但不常用）：

| **取值** | **含义**               |
| -------- | ---------------------- |
| request  | 在一个请求范围内有效。 |
| session  | 在一个会话范围内有效。 |

##### 2.2.11.2 ② 创建类 User

```java
package com.myxh.spring.pojo;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class User
{
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String email;

    public User()
    {

    }

    public User(Integer id, String username, String password, Integer age, String gender, String email)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
```

##### 2.2.11.3 ③ 配置 bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--
    scope：设置 bean 的作用域
    scope="singleton|prototype"
    singleton（单例）：表示获取该 bean 所对应的对象都是同一个
    prototype（多例）：表示获取该 bean 所对应的对象不是同一个
      -->
    <bean id="student" class="com.myxh.spring.pojo.Student" scope="prototype">
        <property name="studentId" value="1"/>
        <property name="studentName" value="张三"/>
        <property name="age" value="20"/>
        <property name="gender" value="男"/>
    </bean>
</beans>
```

##### 2.2.11.4 ④ 测试

```java
package com.myxh.spring.test;

import com.myxh.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class ScopeTest
{
    @Test
    public void testScope()
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student1 = ioc.getBean(Student.class);
        Student student2 = ioc.getBean(Student.class);
        System.out.println("(student1 == student2) = " + (student1 == student2));
    }
}
```

#### 2.2.12、实验十二：bean 的生命周期

##### 2.2.12.1 ① 具体的生命周期过程

- bean 对象创建（调用无参构造器）。

- 给 bean 对象设置属性。

- bean 对象初始化之前操作（由 bean 的后置处理器负责）。

- bean 对象初始化（需在配置 bean 时指定初始化方法）。

- bean 对象初始化之后操作（由 bean 的后置处理器负责）。

- bean 对象就绪可以使用。

- bean 对象销毁（需在配置 bean 时指定销毁方法）。

- IOC 容器关闭。

##### 2.2.12.2 ② 修改类 User

```java
package com.myxh.spring.pojo;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class User
{
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String email;

    public User()
    {
        System.out.println("生命周期 1：实例化");
    }

    public User(Integer id, String username, String password, Integer age, String gender, String email)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        System.out.println("生命周期 2：依赖注入");
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void initMethod()
    {
        System.out.println("生命周期 3：初始化");
    }

    public void destroyMethod()
    {
        System.out.println("生命周期 4：销毁");
    }
}
```

> 注意其中的 initMethod()和 destroyMethod()，可以通过配置 bean 指定为初始化和销毁的方法。

##### 2.2.12.3 ③ 配置 bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="user" class="com.myxh.spring.pojo.User" init-method="initMethod" destroy-method="destroyMethod">
        <property name="id" value="1"/>
        <property name="username" value="MYXH"/>
        <property name="password" value="520.ILY!"/>
        <property name="age" value="21"/>
        <property name="gender" value="男"/>
        <property name="email" value="1735350920@qq.com"/>
    </bean>
</bean>
```

##### 2.2.12.4 ④ 测试

```java
package com.myxh.spring.test;

import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class LifeCycleTest
{
    /**
     * bean 的生命周期：
     * 1、实例化
     * 2、依赖注入
     * 3、后置处理器的 postProcessBeforeInitialization
     * 4、初始化，需要通过 bean 的 init-method 属性指定初始化的方法
     * 5、后置处理器的 postProcessAfterInitialization
     * 6、IOC 容器关闭时销毁，需要通过 bean 的 destroy-method 属性指定销毁的方法
     * <p>
     * bean 的后置处理器会在生命周期的初始化前后添加额外的操作
     * 需要实现 BeanPostprocessor 接口且配置到 IOC 容器中
     * 要注意的是，bean 后置处理器不是单独针对某一个 bean 生效，而是针对 IOC 容器中所有 bean 都会执行
     * <p>
     * 注意：
     * 若 bean 的作用域为单例时，生命周期的前三个步骤会在获取 IOC 器时执行
     * 若 bean 的作用域为多例时，生命周期的前三个步骤会在获取 bean 时执行
     */
    @Test
    public void testLifeCycle()
    {
        /*
          ConfigurableApplicationContext ApplicationContext 的子接口，其中扩展了刷新和关闭容器的方法
         */
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println("user = " + user);
        ioc.close();
    }
}
```

##### 2.2.12.5 ⑤ bean 的后置处理器

bean 的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现 BeanPostProcessor 接口，且配置到 IOC 容器中，需要注意的是，bean 后置处理器不是单独针对某一个 bean 生效，而是针对 IOC 容器中所有 bean 都会执行。

创建 bean 的后置处理器：

```java
package com.myxh.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class MyBeanPostProcessor implements BeanPostProcessor
{
    /**
     * 此方法在 bean 的生命周期初始化之前执行
     *
     * @param bean     新的 bean 实例
     * @param beanName bean 的名称
     * @return 要使用的bean实例，原始实例或已包装实例；
     * 如果为 null，则不会调用后续 BeanPostProcessors
     * @throws org.springframework.beans.BeansException 如果出现错误
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("MyBeanPostProcessor -> 后置处理器 postProcessBeforeInitialization");

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 此方法在 bean 的生命周期初始化之后执行
     *
     * @param bean     新的 bean 实例
     * @param beanName bean 的名称
     * @return 要使用的 bean 实例，原始实例或已包装实例；
     * 如果为 null，则不会调用后续 BeanPostProcessors
     * @throws org.springframework.beans.BeansException 如果出现错误
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("MyBeanPostProcessor -> 后置处理器 postProcessAfterInitialization");

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
```

在 IOC 容器中配置后置处理器：

```xml
<bean id="myBeanPostProcessor" class="com.myxh.spring.processor.MyBeanPostProcessor"/>
```

#### 2.2.13、实验十三：FactoryBean

##### 2.2.13.1 ① 简介

FactoryBean 是 Spring 提供的一种整合第三方框架的常用机制。和普通的 bean 不同，配置一个 FactoryBean 类型的 bean，在获取 bean 的时候得到的并不是 class 属性中配置的这个类的对象，而是 getObject()方法的返回值。通过这种机制，Spring 可以帮我们把复杂组件创建的详细过程和繁琐细节都屏蔽起来，只把最简洁的使用界面展示给我们。

将来我们整合 Mybatis 时，Spring 就是通过 FactoryBean 机制来帮我们创建 SqlSessionFactory 对象的。

```java
/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory;

import org.springframework.lang.Nullable;

/**
 * Interface to be implemented by objects used within a {@link BeanFactory} which
 * are themselves factories for individual objects. If a bean implements this
 * interface, it is used as a factory for an object to expose, not directly as a
 * bean instance that will be exposed itself.
 *
 * <p><b>NB: A bean that implements this interface cannot be used as a normal bean.</b>
 * A FactoryBean is defined in a bean style, but the object exposed for bean
 * references ({@link #getObject()}) is always the object that it creates.
 *
 * <p>FactoryBeans can support singletons and prototypes, and can either create
 * objects lazily on demand or eagerly on startup. The {@link SmartFactoryBean}
 * interface allows for exposing more fine-grained behavioral metadata.
 *
 * <p>This interface is heavily used within the framework itself, for example for
 * the AOP {@link org.springframework.aop.framework.ProxyFactoryBean} or the
 * {@link org.springframework.jndi.JndiObjectFactoryBean}. It can be used for
 * custom components as well; however, this is only common for infrastructure code.
 *
 * <p><b>{@code FactoryBean} is a programmatic contract. Implementations are not
 * supposed to rely on annotation-driven injection or other reflective facilities.</b>
 * {@link #getObjectType()} {@link #getObject()} invocations may arrive early in the
 * bootstrap process, even ahead of any post-processor setup. If you need access to
 * other beans, implement {@link BeanFactoryAware} and obtain them programmatically.
 *
 * <p><b>The container is only responsible for managing the lifecycle of the FactoryBean
 * instance, not the lifecycle of the objects created by the FactoryBean.</b> Therefore,
 * a destroy method on an exposed bean object (such as {@link java.io.Closeable#close()})
 * will <i>not</i> be called automatically. Instead, a FactoryBean should implement
 * {@link DisposableBean} and delegate any such close call to the underlying object.
 *
 * <p>Finally, FactoryBean objects participate in the containing BeanFactory's
 * synchronization of bean creation. There is usually no need for internal
 * synchronization other than for purposes of lazy initialization within the
 * FactoryBean itself (or the like).
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 08.03.2003
 * @param <T> the bean type
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.aop.framework.ProxyFactoryBean
 * @see org.springframework.jndi.JndiObjectFactoryBean
 */
public interface FactoryBean<T> {

    /**
     * The name of an attribute that can be
     * {@link org.springframework.core.AttributeAccessor#setAttribute set} on a
     * {@link org.springframework.beans.factory.config.BeanDefinition} so that
     * factory beans can signal their object type when it can't be deduced from
     * the factory bean class.
     * @since 5.2
     */
    String OBJECT_TYPE_ATTRIBUTE = "factoryBeanObjectType";


    /**
     * Return an instance (possibly shared or independent) of the object
     * managed by this factory.
     * <p>As with a {@link BeanFactory}, this allows support for both the
     * Singleton and Prototype design pattern.
     * <p>If this FactoryBean is not fully initialized yet at the time of
     * the call (for example because it is involved in a circular reference),
     * throw a corresponding {@link FactoryBeanNotInitializedException}.
     * <p>As of Spring 2.0, FactoryBeans are allowed to return {@code null}
     * objects. The factory will consider this as normal value to be used; it
     * will not throw a FactoryBeanNotInitializedException in this case anymore.
     * FactoryBean implementations are encouraged to throw
     * FactoryBeanNotInitializedException themselves now, as appropriate.
     * @return an instance of the bean (can be {@code null})
     * @throws Exception in case of creation errors
     * @see FactoryBeanNotInitializedException
     */
    @Nullable
    T getObject() throws Exception;

    /**
     * Return the type of object that this FactoryBean creates,
     * or {@code null} if not known in advance.
     * <p>This allows one to check for specific types of beans without
     * instantiating objects, for example on autowiring.
     * <p>In the case of implementations that are creating a singleton object,
     * this method should try to avoid singleton creation as far as possible;
     * it should rather estimate the type in advance.
     * For prototypes, returning a meaningful type here is advisable too.
     * <p>This method can be called <i>before</i> this FactoryBean has
     * been fully initialized. It must not rely on state created during
     * initialization; of course, it can still use such state if available.
     * <p><b>NOTE:</b> Autowiring will simply ignore FactoryBeans that return
     * {@code null} here. Therefore, it is highly recommended to implement
     * this method properly, using the current state of the FactoryBean.
     * @return the type of object that this FactoryBean creates,
     * or {@code null} if not known at the time of the call
     * @see ListableBeanFactory#getBeansOfType
     */
    @Nullable
    Class<?> getObjectType();

    /**
     * Is the object managed by this factory a singleton? That is,
     * will {@link #getObject()} always return the same object
     * (a reference that can be cached)?
     * <p><b>NOTE:</b> If a FactoryBean indicates to hold a singleton object,
     * the object returned from {@code getObject()} might get cached
     * by the owning BeanFactory. Hence, do not return {@code true}
     * unless the FactoryBean always exposes the same reference.
     * <p>The singleton status of the FactoryBean itself will generally
     * be provided by the owning BeanFactory; usually, it has to be
     * defined as singleton there.
     * <p><b>NOTE:</b> This method returning {@code false} does not
     * necessarily indicate that returned objects are independent instances.
     * An implementation of the extended {@link SmartFactoryBean} interface
     * may explicitly indicate independent instances through its
     * {@link SmartFactoryBean#isPrototype()} method. Plain {@link FactoryBean}
     * implementations which do not implement this extended interface are
     * simply assumed to always return independent instances if the
     * {@code isSingleton()} implementation returns {@code false}.
     * <p>The default implementation returns {@code true}, since a
     * {@code FactoryBean} typically manages a singleton instance.
     * @return whether the exposed object is a singleton
     * @see #getObject()
     * @see SmartFactoryBean#isPrototype()
     */
    default boolean isSingleton() {
        return true;
    }

}
```

##### 2.2.13.2 ② 创建类 UserFactoryBean

```java
package com.myxh.spring.factory;

import com.myxh.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author MYXH
 * @date 2023/8/24
 * @description
 * FactoryBean 是一个接口，需要创建一个类实现该接口
 * 其中有三个方法：
 * getObject()：通过一个对象交给 IOC 容器管理
 * getObjectType()：设置所提供对象的类型
 * isSingleton()：所提供的对象是否单例
 * 当把 FactoryBean 的实现类配置为 bean 时，会将当前类中 getObject() 所返回的对象交给 IOC 容器管理
 */
public class UserFactoryBean implements FactoryBean
{
    @Override
    public Object getObject() throws Exception
    {
        return new User();
    }

    @Override
    public Class<?> getObjectType()
    {
        return User.class;
    }
}
```

##### 2.2.13.3 ③ 配置 bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean class="com.myxh.spring.factory.UserFactoryBean"/>
</beans>
```

##### 2.2.13.4 ④ 测试

```java
package com.myxh.spring.test;

import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class FactoryBeanTest
{
    @Test
    public void testFactoryBean()
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println("user = " + user);

    }
}
```

##### 2.2.14、实验十四：基于 xml 的自动装配

> 自动装配：
>
> 根据指定的策略，在 IOC 容器中匹配某一个 bean，自动为指定的 bean 中所依赖的类类型或接口类型属性赋值。

##### 2.2.14.1 ① 场景模拟

创建类 UserController

```java
package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class UserController
{
    private UserService userService;

    public UserService getUserService()
    {
        return userService;
    }

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    public void saveUser(User user)
    {
        userService.saveUser(user);
    }
}
```

创建接口 UserService

```java
package com.myxh.spring.service;

import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserService
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    void saveUser(User user);
}
```

创建类 UserServiceImpl 实现接口 UserService

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    public UserDao getUserDao()
    {
        return userDao;
    }

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    @Override
    public void saveUser(User user)
    {
        userDao.saveUser(user);
    }
}
```

创建接口 UserDao

```java
package com.myxh.spring.dao;

import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserDao
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    void saveUser(User user);
}
```

创建类 UserDaoImpl 实现接口 UserDao

```java
package com.myxh.spring.dao.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class UserDaoImpl implements UserDao
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    @Override
    public void saveUser(User user)
    {
        System.out.println("保存用户信息成功");
    }
}
```

##### 2.2.14.2 ② 配置 bean

> 使用 bean 标签的 autowire 属性设置自动装配效果。
>
> 自动装配方式：byType
>
> byType：根据类型匹配 IOC 容器中的某个兼容类型的 bean，为属性自动赋值。
>
> 若在 IOC 中，没有任何一个兼容类型的 bean 能够为属性赋值，则该属性不装配，即值为默认值 null。
>
> 若在 IOC 中，有多个兼容类型的 bean 能够为属性赋值，则抛出异常 NoUniqueBeanDefinitionException。

```xml
 <bean id="user" class="com.myxh.spring.pojo.User">
        <property name="id" value="1"/>
        <property name="username" value="MYXH"/>
        <property name="password" value="520.ILY!"/>
        <property name="age" value="21"/>
        <property name="gender" value="男"/>
        <property name="email" value="1735350920@qq.com"/>
    </bean>

    <!--
    <bean id="userController" class="com.myxh.spring.controller.UserController">
         <property name="userService" ref="userService"/>
    </bean>

    <bean id="userService" class="com.myxh.spring.service.impl.UserServiceImpl">
         <property name="userDao" ref="userDao"/>
    </bean>

    <bean id="userDao" class="com.myxh.spring.dao.impl.UserDaoImpl"/>
     -->

    <bean id="userController" class="com.myxh.spring.controller.UserController" autowire="byType"/>

    <bean id="userService" class="com.myxh.spring.service.impl.UserServiceImpl" autowire="byType"/>

    <bean id="userDao" class="com.myxh.spring.dao.impl.UserDaoImpl"/>
```

> 自动装配方式：byName
>
> byName：将自动装配的属性的属性名，作为 bean 的 id 在 IOC 容器中匹配相对应的 bean 进行赋值。

```xml
<bean id="userController" class="com.myxh.spring.controller.UserController" autowire="byName"/>

<bean id="userService" class="com.myxh.spring.service.impl.UserServiceImpl" autowire="byName"/>

<bean id="userService2" class="com.myxh.spring.service.impl.UserServiceImpl" autowire="byName"/>

<bean id="userDao" class="com.myxh.spring.dao.impl.UserDaoImpl"/>

<bean id="userDao2" class="com.myxh.spring.dao.impl.UserDaoImpl"/>
```

##### 2.2.14.3 ③ 测试

```java
package com.myxh.spring.test;

import com.myxh.spring.controller.UserController;
import com.myxh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public class AutowireByXmlTest
{
    /**
     * 自动装配：
     * 根据指定的策略，在 IOC 容器中匹配某个 bean，自动为 bean 中的类类型的属性或接口类型的属性赋值
     * 可以通过 bean 标签中的 autowire 属性设置自动装配的策略
     * <p>
     * 自动装配的策略：
     * 1、no、default：表示不装配，即 bean 中的属性不会自动匹配某个 bean 为属性赋值，此时属性使用默认值
     * 2、byType：根据要赋值的属性的类型，在 IOC 容器中匹配某个 bean，为属性赋值
     * 注意：
     * ① 若通过类型没有找到任何一个类型匹配的 bean，此时不装配，属性使用默认值
     * ② 若通过类型找到了多个类型匹配的 bean，此时会抛出异常：NoUniqueBeanDefinitionException
     * 总结：当使用 byType 实现自动装配时，IOC 容器中有且只有一个类型匹配的 bean 能够为属性赋值
     * 3、byName：将要赋值的属性的属性名作为 bean 的 id 在 IOC 容器中匹配 bean，为属性赋值
     * 总结：当类型匹配 bean 有多个时，此时可以使用 byName 实现自动装配
     */
    @Test
    public void testAutowire()
    {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        User user = ioc.getBean(User.class);
        System.out.println("user = " + user);
        UserController userController = ioc.getBean(UserController.class);
        System.out.println("userController = " + userController);
        userController.saveUser(user);
    }
}
```

### 2.3、基于注解管理 bean

#### 2.3.1、实验一：标记与扫描

##### 2.3.1.1 ① 注解

和 XML 配置文件一样，注解本身并不能执行，注解本身仅仅只是做一个标记，具体的功能是框架检测到注解标记的位置，然后针对这个位置按照注解标记的功能来执行具体操作。

本质上：所有一切的操作都是 Java 代码来完成的，XML 和注解只是告诉框架中的 Java 代码如何执行。

举例：元旦联欢会要布置教室，蓝色的地方贴上元旦快乐四个字，红色的地方贴上拉花，黄色的地方贴上气球。

![① 注解](https://img-blog.csdnimg.cn/c7663cfdb442454e97a411ee2446c383.png)

班长做了所有标记，同学们来完成具体工作。墙上的标记相当于我们在代码中使用的注解，后面同学们做的工作，相当于框架的具体操作。

##### 2.3.1.2 ② 扫描

Spring 为了知道程序员在哪些地方标记了什么注解，就需要通过扫描的方式，来进行检测。然后根据注解进行后续操作。

##### 2.3.1.3 ③ 新建 Maven Module

```xml
<dependencies>
    <!-- 基于 Maven 依赖传递性，导入 spring-context 依赖即可导入当前所需所有 jar 包 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.0.9</version>
    </dependency>

    <!-- junit 测试 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

##### 2.3.1.4 ④ 创建 Spring 配置文件

![④ 创建 Spring 配置文件](https://img-blog.csdnimg.cn/1a5d5a17e43d466b8f93408863be6985.png)

##### 2.3.1.5 ⑤ 标识组件的常用注解

> @Component：将类标识为普通组件。
> @Controller：将类标识为控制层组件。
> @Service：将类标识为业务层组件。
> @Repository：将类标识为持久层组件。

问：以上四个注解有什么关系和区别？

![⑤ 标识组件的常用注解](https://img-blog.csdnimg.cn/9fc8a104263a4531a3602176374b468e.png)

通过查看源码我们得知，@Controller、@Service、@Repository 这三个注解只是在@Component 注解的基础上起了三个新的名字。

对于 Spring 使用 IOC 容器管理这些组件来说没有区别。所以@Controller、@Service、@Repository 这三个注解只是给开发人员看的，让我们能够便于分辨组件的作用。

注意：虽然它们本质上一样，但是为了代码的可读性，为了程序结构严谨我们肯定不能随便胡乱标记。

##### 2.3.1.6 ⑥ 创建组件

创建控制层组件

```java
package com.myxh.spring.controller;

import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Controller
public class UserController
{
    public UserController()
    {

    }
}
```

创建接口 UserService

```java
package com.myxh.spring.service;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserService
{

}

```

创建业务层组件 UserServiceImpl

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Service
public class UserServiceImpl implements UserService
{

}

```

创建接口 UserDao

```java
package com.myxh.spring.dao;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserDao
{

}
```

创建持久层组件 UserDaoImpl

```java
package com.myxh.spring.dao.impl;

import com.myxh.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Repository
public class UserDaoImpl implements UserDao
{

}
```

##### 2.3.1.7 ⑦ 扫描组件

情况一：最基本的扫描方式

```xml
<!-- 扫描组件 -->
<context:component-scan base-package="com.myxh.spring"/>
```

情况二：指定要排除的组件

```xml
<!--
    context:exclude-filter：排除扫描
    type：设置排除扫描的方式
    type="annotation|assignable"
    annotation：根据注解的类型进行排除，expression 需要设置排除的注解的全类名
    assignable：根据类的类型进行排除，expression 需要设置排除的类的全类名
-->
<context:component-scan base-package="com.myxh.spring">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
        <context:exclude-filter type="assignable" expression="com.myxh.spring.controller.UserController"/>
</context:component-scan>
```

情况三：仅扫描指定组件

```xml
<!--
    context:include-filter: 包含扫描
    注意：需要在 context:component-scan 标签中设置 use-default-filters="false"
    use-default-filters="true"（默认），所设置的包下所有的类都需要扫描，此时可以使用排除扫描
    use-default-filters="false"，所设置的包下所有的类都不需要扫描，此时可以使用包含扫描
-->
<context:component-scan base-package="com.myxh.spring" use-default-filters="false">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Component"/>
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
</context:component-scan>
```

##### 2.3.1.8 ⑧ 测试

```java
@Test
public void testIoc()
{
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
    User user = ioc.getBean("user", User.class);
    System.out.println("user = " + user);
    UserController userController = ioc.getBean("userController", UserController.class);
    System.out.println("userController = " + userController);
    UserService userService = ioc.getBean("userServiceImpl", UserService.class);
    System.out.println("userService = " + userService);
    UserDao userDao = ioc.getBean("userDaoImpl", UserDao.class);
    System.out.println("userDao = " + userDao);
}
```

##### 2.3.1.9 ⑨ 组件所对应的 bean 的 id

在我们使用 XML 方式管理 bean 的时候，每个 bean 都有一个唯一标识，便于在其他地方引用。现在使用注解后，每个组件仍然应该有一个唯一标识。

> 默认情况
>
> 类名首字母小写就是 bean 的 id。例如：UserController 类对应的 bean 的 id 就是 userController。
>
> 自定义 bean 的 id 可通过标识组件的注解的 value 属性设置自定义的 bean 的 id。
>
> ```java
> // 默认为 userServiceImpl
> @Service("userService")
> public class UserServiceImpl implements UserService
> {
>
> }
> ```

#### 2.3.2、实验二：基于注解的自动装配

##### 2.3.2.1 ① 场景模拟

> 参考基于 xml 的自动装配。
>
> 在 UserController 中声明 UserService 对象。
>
> 在 UserServiceImpl 中声明 UserDao 对象。

##### 2.3.2.2 ② @Autowired 注解

在成员变量上直接标记@Autowired 注解即可完成自动装配，不需要提供 setXxx()方法。以后我们在项目中的正式用法就是这样。

```java
package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Controller
public class UserController
{
    @Autowired
    private  UserService userService;

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    public void saveUser(User user)
    {
        userService.saveUser(user);
    }
}
```

```java
package com.myxh.spring.service;

import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserService
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    void saveUser(User user);
}
```

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    @Override
    public void saveUser(User user)
    {
        userDao.saveUser(user);
    }
}
```

```java
package com.myxh.spring.dao;

import com.myxh.spring.pojo.User;

/**
 * @author MYXH
 * @date 2023/8/24
 */
public interface UserDao
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    void saveUser(User user);
}
```

```java
package com.myxh.spring.dao.impl;

import com.myxh.spring.dao.UserDao;
import com.myxh.spring.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Repository
public class UserDaoImpl implements UserDao
{
    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    @Override
    public void saveUser(User user)
    {
        System.out.println("保存用户信息成功");
    }
}
```

##### 2.3.2.3 ③ @Autowired 注解其他细节

> @Autowired 注解可以标记在构造器和 set 方法上

```java
package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Controller
public class UserController
{
    private  UserService userService;

    public UserController()
    {

    }

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    public void saveUser(User user)
    {
        userService.saveUser(user);
    }
}

```

```java
package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Controller
public class UserController
{
    private  UserService userService;

    public UserService getUserService()
    {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    public void saveUser(User user)
    {
        userService.saveUser(user);
    }
}
```

##### 2.3.2.4 ④ @Autowired 工作流程

![④ @Autowired 工作流程](https://img-blog.csdnimg.cn/720238047696435e999b5a8c94e77723.png)

- 首先根据所需要的组件类型到 IOC 容器中查找

  - 能够找到唯一的 bean：直接执行装配。

  - 如果完全找不到匹配这个类型的 bean：装配失败。

  - 和所需类型匹配的 bean 不止一个

    - 没有@Qualifier 注解：根据@Autowired 标记位置成员变量的变量名作为 bean 的 id 进行匹配。

    - 能够找到：执行装配。

    - 找不到：装配失败。

    - 使用@Qualifier 注解：根据@Qualifier 注解中指定的名称作为 bean 的 id 进行匹配。

    - 能够找到：执行装配。

    - 找不到：装配失败。

```java
package com.myxh.spring.controller;

import com.myxh.spring.pojo.User;
import com.myxh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/24
 */
@Controller
public class UserController
{
    // @Autowired(required = false)
    @Qualifier("userServiceImpl")
    private  UserService userService;

    /**
     * 保存用户信息
     *
     * @param user 一个用户信息
     */
    public void saveUser(User user)
    {
        userService.saveUser(user);
    }
}
```

> @Autowired 中有属性 required，默认值为 true，因此在自动装配无法找到相应的 bean 时，会装配失败。
>
> 可以将属性 required 的值设置为 false，则表示能装就装，装不上就不装，此时自动装配的属性为默认值。
>
> 但是实际开发时，基本上所有需要装配组件的地方都是必须装配的，用不上这个属性。

## 3、AOP

### 3.1、场景模拟

#### 3.1.1、声明接口

声明计算器接口 Calculator，包含加减乘除的抽象方法。

```java
package com.myxh.spring.aop.annotation;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public interface Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    Integer add(Integer x, Integer y);

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    Integer sub(Integer x, Integer y);

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    Integer mul(Integer x, Integer y);

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    Integer div(Integer x, Integer y);
}
```

#### 3.1.2、创建实现类

![创建实现类](https://img-blog.csdnimg.cn/a9e2c11aed4140739bd1d318a2d0c9ec.png)

```java
package com.myxh.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/8/25
 */
@Component
public class CalculatorImpl implements Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    @Override
    public Integer add(Integer x, Integer y)
    {
        Integer result = x + y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    @Override
    public Integer sub(Integer x, Integer y)
    {
        Integer result = x - y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    @Override
    public Integer mul(Integer x, Integer y)
    {
        Integer result = x * y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    @Override
    public Integer div(Integer x, Integer y)
    {
        Integer result = x / y;
        System.out.println("方法内部：result = " + result);

        return result;
    }
}
```

#### 3.1.3、创建带日志功能的实现类

![创建带日志功能的实现类](https://img-blog.csdnimg.cn/720e572df26e4704bd583e8167324d4c.png)

```java
package com.myxh.spring.proxy;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public class CalculatorImpl implements Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    @Override
    public Integer add(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：add，参数：[" + x + ", " + y + "]");

        Integer result = x + y;
        System.out.println("方法内部：result = " + result);

        System.out.println("[日志] 方法：add，结果：" + result);

        return result;
    }

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    @Override
    public Integer sub(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：sub，参数：[" + x + ", " + y + "]");

        Integer result = x - y;
        System.out.println("方法内部：result = " + result);

        System.out.println("[日志] 方法：sub，结果：" + result);

        return result;
    }

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    @Override
    public Integer mul(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：mul，参数：[" + x + ", " + y + "]");

        Integer result = x * y;
        System.out.println("方法内部：result = " + result);

        System.out.println("[日志] 方法：mul，结果：" + result);

        return result;
    }

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    @Override
    public Integer div(Integer x, Integer y)
    {

        System.out.println("[日志] 方法：div，参数：[" + x + ", " + y + "]");

        Integer result = x / y;
        System.out.println("方法内部：result = " + result);

        System.out.println("[日志] 方法：div，结果：" + result);

        return result;
    }
}
```

#### 3.1.4、提出问题

##### 3.1.4.1 ① 现有代码缺陷

针对带日志功能的实现类，我们发现有如下缺陷：

- 对核心业务功能有干扰，导致程序员在开发核心业务功能时分散了精力。

- 附加功能分散在各个业务功能方法中，不利于统一维护。

##### 3.1.4.2 ② 解决思路

解决这两个问题，核心就是：解耦。我们需要把附加功能从业务功能代码中抽取出来。

##### 3.1.4.3 ③ 困难

解决问题的困难：要抽取的代码在方法内部，靠以前把子类中的重复代码抽取到父类的方式没法解决。所以需要引入新的技术。

### 3.2、代理模式

#### 3.2.1、概念

##### 3.2.1.1 ① 介绍

二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类**间接**调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来——**解耦**。调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。

![① 介绍](https://img-blog.csdnimg.cn/caca2793d51d4bf5ba2eea0a1e670132.png)

使用代理后：

![① 介绍](https://img-blog.csdnimg.cn/f6e7ed4b089c4a738538ed8bdf7ef9f9.png)

##### 3.2.1.2 ② 生活中的代理

- 广告商找大明星拍广告需要经过经纪人。

- 合作伙伴找大老板谈合作要约见面时间需要经过秘书。

- 房产中介是买卖双方的代理。

##### 3.2.1.3 ③ 相关术语

- 代理：将非核心逻辑剥离出来以后，封装这些非核心逻辑的类、对象、方法。

- 目标：被代理“套用”了非核心逻辑代码的类、对象、方法。

#### 3.2.2、静态代理

创建静态代理类：

```java
package com.myxh.spring.proxy;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public class CalculatorStaticProxy implements Calculator
{
    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target)
    {
        this.target = target;
    }

    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    @Override
    public Integer add(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：add，参数：[" + x + ", " + y + "]");

        Integer result = target.add(x, y);

        System.out.println("[日志] 方法：add，结果：" + result);

        return result;
    }

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    @Override
    public Integer sub(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：sub，参数：[" + x + ", " + y + "]");

        Integer result = target.sub(x, y);

        System.out.println("[日志] 方法：sub，结果：" + result);

        return result;
    }

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    @Override
    public Integer mul(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：mul，参数：[" + x + ", " + y + "]");

        Integer result = target.mul(x, y);

        System.out.println("[日志] 方法：mul，结果：" + result);

        return result;
    }

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    @Override
    public Integer div(Integer x, Integer y)
    {
        System.out.println("[日志] 方法：div，参数：[" + x + ", " + y + "]");

        Integer result = target.div(x, y);

        System.out.println("[日志] 方法：div，结果：" + result);

        return result;
    }
}
```

> 静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性。就拿日志功能来说，将来其他地方也需要附加日志，那还得再声明更多个静态代理类，那就产生了大量重复的代码，日志功能还是分散的，没有统一管理。
>
> 提出进一步的需求：将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理类来实现。这就需要使用动态代理技术了。

#### 3.2.3、动态代理

![动态代理](https://img-blog.csdnimg.cn/3f97c0b4f3614428ae81606e1994d982.png)

生产代理对象的工厂类：

```java
package com.myxh.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public class ProxyFactory
{
    private final Object target;

    public ProxyFactory(Object target)
    {
        this.target = target;
    }

    public Object getProxy()
    {
        /*
          ClassLoader loader：指定加载动态生成的代理类的类加载器
          Class<?>[] interfaces：获取目标对象实现的所有接口的 class 对象的数组
          InvocationHandler h：设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler()
        {
            /**
             * proxy 表示代理对象，method 表示要执行的方法，args 表示要执行的方法的参数列表
             *
             * @param proxy 调用该方法的代理实例
             *
             * @param method 与代理实例上调用的接口方法相对应的 method 实例。
             *               Method 对象的声明类将是在其中声明该方法的接口，该接口可能是代理类通过其继承该方法的代理接口的超接口。
             *
             * @param args 一个对象数组，包含在代理实例上的方法调用中传递的参数值，如果接口方法不接受参数，则为 null。
             *             基元类型的参数被包装在适当的基元包装类的实例中，例如 java.lang.Integer 或 java.lang.Boolean。
             *
             * @return 从代理实例上的方法调用返回的值。
             * 如果接口方法声明的返回类型是基元类型，则此方法返回的值必须是相应基元包装类的实例；否则，它必须是可分配给声明的返回类型的类型。
             * 如果此方法返回的值为 null，并且接口方法的返回类型为基元，则方法调用将在代理实例上引发 NullPointerException。
             * 如果此方法返回的值与如上所述接口方法声明的返回类型不兼容，则方法调用将在代理实例上引发 ClassCastException
             * @throws Throwable 从代理实例上的方法调用中抛出的异常。
             * 异常的类型必须可分配给接口方法的 throws 子句中声明的任何异常类型，或者可分配给未检查的异常类型 java.lang.RuntimeException或java.lang.Error。
             * 如果此方法抛出了一个检查的异常，但该异常不可分配给接口方法的 throw 子句中声明任何异常类型，则包含此方法引发的异常的 UndeclaredThrowableException 将由代理实例上的方法调用引发。
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
            {
                Object result = null;

                try
                {
                    System.out.println("[日志] 方法：" + method.getName() + "，参数：" + Arrays.toString(args));

                    result = method.invoke(target, args);

                    System.out.println("[日志] 方法：" + method.getName() + "，结果：" + result);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    System.out.println("[日志] 方法：" + method.getName() + "，异常：" + e);
                    e.printStackTrace();
                } finally
                {
                    System.out.println("[日志] 方法：" + method.getName() + "，方法执行完毕");
                }

                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
```

#### 3.2.4、测试

```java
package com.myxh.spring.proxy.test;

import com.myxh.spring.proxy.Calculator;
import com.myxh.spring.proxy.CalculatorImpl;
import com.myxh.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author MYXH
 * @date 2023/8/25
 */
public class ProxyTest
{
    /**
     * 动态代理有两种：
     * 1、jdk 动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
     * 在 com.sun.proxy 包下，类名为 $proxy2
     * 2、cglib 动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */
    @Test
    public void testProxy()
    {
        // CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        // proxy.add(1, 2);

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
        // proxy.div(1, 0);
    }
}
```

### 3.3、AOP 概念及相关术语

#### 3.3.1、概述

AOP（Aspect Oriented Programming）是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现在不修改源代码的情况下给程序动态统一添加额外功能的一种技术。

#### 3.3.2、相关术语

##### 3.3.2.1 ① 横切关注点

从每个方法中抽取出来的同一类非核心业务。在同一个项目中，我们可以使用多个横切关注点对相关方法进行多个不同方面的增强。

这个概念不是语法层面天然存在的，而是根据附加功能的逻辑上的需要：有十个附加功能，就有十个横切关注点。

![① 横切关注点](https://img-blog.csdnimg.cn/cbabe12727e64892984c6c21589358fe.png)

##### 3.3.2.2 ② 通知

每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。

- 前置通知：在被代理的目标方法**前**执行。

- 返回通知：在被代理的目标方法**成功结束**后执行（**寿终正寝**）。

- 异常通知：在被代理的目标方法**异常结束**后执行（**死于非命**）。

- 后置通知：在被代理的目标方法**最终结束**后执行（**盖棺定论**）。

- 环绕通知：使用 try...catch...finally 结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置。

![② 通知](https://img-blog.csdnimg.cn/8128cb33c79e4fc1aecc808192ce4f77.png)

##### 3.3.2.3 ③ 切面

封装通知方法的类。

![③ 切面](https://img-blog.csdnimg.cn/c4c1635745d146b2a5fdf22abb355001.png)

##### 3.3.2.4 ④ 目标

被代理的目标对象。

##### 3.3.2.5 ⑤ 代理

向目标对象应用通知之后创建的代理对象。

##### 3.3.2.6 ⑥ 连接点

这也是一个纯逻辑概念，不是语法定义的。

把方法排成一排，每一个横切位置看成 x 轴方向，把方法从上到下执行的顺序看成 y 轴，x 轴和 y 轴的交叉点就是连接点。

![⑥ 连接点](https://img-blog.csdnimg.cn/bedd33a40f924a1dbaeff306da1f7d9f.png)

##### 3.3.2.7 ⑦ 切入点

定位连接点的方式。

每个类的方法中都包含多个连接点，所以连接点是类中客观存在的事物（从逻辑上来说）。

如果把连接点看作数据库中的记录，那么切入点就是查询记录的 SQL 语句。

Spring 的 AOP 技术可以通过切入点定位到特定的连接点。

切点通过 org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条件。

#### 3.3.3、作用

- 简化代码：把方法中固定位置的重复的代码**抽取**出来，让被抽取的方法更专注于自己的核心功能，提高内聚性。

- 代码增强：把特定的功能封装到切面类中，看哪里有需要，就往上套，被**套用**了切面逻辑的方法就被切面给增强了。

### 3.4、基于注解的 AOP

#### 3.4.1、技术说明

![技术说明](https://img-blog.csdnimg.cn/db086ceda98545fbae70f22374942eb1.png)

- 动态代理（InvocationHandler）：JDK 原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求**代理对象和目标对象实现同样的接口**（兄弟两个拜把子模式）。

- cglib：通过**继承被代理的目标类**（认干爹模式）实现代理，所以不需要目标类实现接口。

- AspectJ：本质上是静态代理，**将代理逻辑“织入”被代理的目标类编译得到的字节码文件**，所以最终效果是动态的。weaver 就是织入器。Spring 只是借用了 AspectJ 中的注解。

#### 3.4.2、准备工作

##### 3.4.2.1 ① 添加依赖

在 IOC 所需依赖基础上再加入下面依赖即可：

```xml
<!-- spring-aspects 会帮我们传递过来 aspectjweaver -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>6.0.9</version>
</dependency>
```

##### 3.4.2.2 ② 准备被代理的目标资源

接口：

```java
package com.myxh.spring.aop.annotation;

/**
 * @author MYXH
 * @date 2023/8/28
 */
public interface Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    Integer add(Integer x, Integer y);

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    Integer sub(Integer x, Integer y);

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    Integer mul(Integer x, Integer y);

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    Integer div(Integer x, Integer y);
}
```

实现类：

```java
package com.myxh.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/8/28
 */
@Component
public class CalculatorImpl implements Calculator
{
    /**
     * 加法计算
     *
     * @param x 被加数
     * @param y 加数
     * @return 和
     */
    @Override
    public Integer add(Integer x, Integer y)
    {
        Integer result = x + y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 减法计算
     *
     * @param x 被减数
     * @param y 减数
     * @return 差
     */
    @Override
    public Integer sub(Integer x, Integer y)
    {
        Integer result = x - y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 乘法计算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return 积
     */
    @Override
    public Integer mul(Integer x, Integer y)
    {
        Integer result = x * y;
        System.out.println("方法内部：result = " + result);

        return result;
    }

    /**
     * 除法计算
     *
     * @param x 被除数
     * @param y 除数
     * @return 商
     */
    @Override
    public Integer div(Integer x, Integer y)
    {
        Integer result = x / y;
        System.out.println("方法内部：result = " + result);

        return result;
    }
}
```

#### 3.4.3、创建切面类并配置

```java
package com.myxh.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author MYXH
 * @date 2023/8/28
 * @description
 * 1、在切面中，需要通过指定的注解将方法标识为通知方法
 * {@code @Before}：前置通知，在目标对象方法执行之前执行
 * {@code @After}：后置通知，在目标对象方法的 finally 字句中执行
 * {@code @AfterReturning}：返回通知，在目标对象方法返回值之后执行
 * {@code @AfterThrowing}：异常通知，在目标对象方法的 catch 子句中执行
 * {@code @Around}：环绕通知，环绕通知的方法的返回值一定要和目标对象方法的返回值一致
 * <p>
 * 2、切入点表达式：设置在标识通知的注解的 value 属性中
 * {@code execution(public Integer com.myxh.spring.aop.annotation.CalculatorImpl.add(Integer, Integer))}
 * {@code execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))}
 * 第一个 * 表示任意的访问修饰符和返回值类型
 * 第二个 * 表示类中任意的方法
 * .. 表示任意的参数列表
 * 类的地方也可以使用 *，表示包下所有的类
 * <p>
 * 3、获取连接点的信息
 * 在通知方法的参数位置，设置 JoinPoint 类型的参数，就可以获取连接点所对应方法的信息
 * {@code
 * // 获取连接点所对应方法的签名信息
 * Signature signature = joinPoint.getSignature();
 * <p>
 * // 获取连接点所对应方法的方法名
 * String name = signature.getName();
 * <p>
 * // 获取连接点所对应方法的参数
 * Object[] args = joinPoint.getArgs();
 * }
 */
@Component
// 将当前组件标识为切面
@Aspect
public class LoggerAspect
{
    // @Before("execution(public Integer com.myxh.spring.aop.annotation.CalculatorImpl.add(Integer, Integer))")
    @Before("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("[LoggerAspect] 方法：" + name + "，参数：" + Arrays.toString(args));
    }

    @After("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    public void afterAdviceMethod(JoinPoint joinPoint)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，方法执行完毕");
    }

    /**
     * 在返回通知中若要获取目标对象方法的返回值
     * 只需要通过 {@code @AfterReturning} 注解的 returning 属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     *
     * @param joinPoint 连接点
     * @param result 结果
     */
    @AfterReturning(value = "execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，结果：" + result);
    }

    /**
     * 在异常通知中若要获取目标对象方法的异常
     * 只需要通过 {@code @AfterThrowing} 注解的 throwing 属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法出现的异常的参数
     *
     * @param joinPoint 连接点
     * @param exception 异常
     */
    @AfterThrowing(value = "execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))", throwing = "exception")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable exception)
    {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        // 获取连接点所对应方法的方法名
        String name = signature.getName();

        System.out.println("[LoggerAspect] 方法：" + name + "，异常：" + exception);
    }

    /**
     * 环绕通知的方法的返回值一定要和目标对象方法的返回值一致
     *
     * @param joinPoint 连接点
     * @return result 结果
     */
    @Around("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint)
    {
        Object result = null;

        try
        {
            System.out.println("环绕通知 -> 前置通知");

            // 表示目标对象方法的执行
            result  = joinPoint.proceed();

            System.out.println("环绕通知 -> 返回通知");
        }
        catch (Throwable e)
        {
            System.out.println("环绕通知 -> 异常通知");
            e.printStackTrace();
        }
        finally
        {
            System.out.println("环绕通知 -> 后置通知");
        }

        return result;
    }
}
```

在 Spring 的配置文件中配置：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns="http://www.springframework.org/schema/beans"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd   http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--
    AOP 的注意事项：
    切面类和目标类都需要交给 IOC 器管理
    切面类必须通过 @Aspect 注解标识为一个切面
    在 Spring 的配置文件中设置 <aop:aspectj-autoproxy/> 开启基于注解的 AOP
     -->
    <!-- 扫描组件 -->
    <context:component-scan base-package="com.myxh.spring.aop.annotation"/>

    <!-- 开启基于注解的 AOP -->
    <aop:aspectj-autoproxy/>
</beans>
```

#### 3.4.4、各种通知

- 前置通知：使用@Before 注解标识，在被代理的目标方法**前**执行。

- 返回通知：使用@AfterReturning 注解标识，在被代理的目标方法**成功结束**后执行（**寿终正寝**）。

- 异常通知：使用@AfterThrowing 注解标识，在被代理的目标方法**异常结束**后执行（**死于非命**）。

- 后置通知：使用@After 注解标识，在被代理的目标方法**最终结束**后执行（**盖棺定论**）。

- 环绕通知：使用@Around 注解标识，使用 try...catch...finally 结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置。

> 各种通知的执行顺序：
>
> - Spring 版本 5.3.x 以前：
>
>   - 前置通知
>
>   - 目标操作
>
>   - 后置通知
>
>   - 返回通知或异常通知
>
> - Spring 版本 5.3.x 以后：
>
>   - 前置通知
>
>   - 目标操作
>
>   - 返回通知或异常通知
>
>   - 后置通知

#### 3.4.5、切入点表达式语法

##### 3.4.5.1 ① 作用

![① 作用](https://img-blog.csdnimg.cn/fd28ee9397184647960f44700e20b827.png)

##### 3.4.5.2 ② 语法细节

- 用 \* 号代替“权限修饰符”和“返回值”部分表示“权限修饰符”和“返回值”不限。

- 在包名的部分，一个“\*”号只能代表包的层次结构中的一层，表示这一层是任意的。

  - 例如：\*.Hello 匹配 com.Hello，不匹配 com.myxh.Hello。

- 在包名的部分，使用“\.\.”表示包名任意、包的层次深度任意。

- 在类名的部分，类名部分整体用 \* 号代替，表示类名任意。

- 在类名的部分，可以使用 \* 号代替类名的一部分。

  - 例如：\*Service 匹配所有名称以 Service 结尾的类或接口。

- 在方法名部分，可以使用 \* 号表示方法名任意。

- 在方法名部分，可以使用 \* 号代替方法名的一部分。

  - 例如：\*Operation 匹配所有方法名以 Operation 结尾的方法。

- ​ 在方法参数列表部分，使用 (\.\.) 表示参数列表任意。

- 在方法参数列表部分，使用 (int, \.\.) 表示参数列表以一个 int 类型的参数开头。

- 在方法参数列表部分，基本数据类型和对应的包装类型是不一样的。

  - 切入点表达式中使用 int 和实际方法中 Integer 是不匹配的。

- 在方法返回值部分，如果想要明确指定一个返回值类型，那么必须同时写明权限修饰符。

  - 例如：execution(public int \.\.Service.\*(\.\., int)) 正确。

  - 例如：execution(int \.\.Service.\*(\.\., int)) 错误。

![② 语法细节](https://img-blog.csdnimg.cn/68c83cdfc09d47cb8d2c4b8560b855a4.png)

#### 3.4.6、重用切入点表达式

##### 3.4.6.1 ① 声明

```java
// @Pointcut 声明一个公共的切入点表达式
@Pointcut("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
public void pointCut()
{

}
```

##### 3.4.6.2 ② 在同一个切面中使用

```java
// @Before("execution(public Integer com.myxh.spring.aop.annotation.CalculatorImpl.add(Integer, Integer))")
// @Before("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
@Before("pointCut()")
public void beforeAdviceMethod(JoinPoint joinPoint)
{
    // 获取连接点所对应方法的签名信息
    Signature signature = joinPoint.getSignature();

    // 获取连接点所对应方法的方法名
    String name = signature.getName();

    // 获取连接点所对应方法的参数
    Object[] args = joinPoint.getArgs();

    System.out.println("[LoggerAspect] 方法：" + name + "，参数：" + Arrays.toString(args));
}
```

##### 3.4.6.3 ③ 在不同切面中使用

```java
package com.myxh.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/8/28
 */
@Component
@Aspect
public class ValidateAspect
{
    // @Before("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.myxh.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod()
    {
        System.out.println("ValidateAspect -> 前置通知");
    }
}
```

#### 3.4.7、获取通知的相关信息

##### 3.4.7.1 ① 获取连接点信息

获取连接点信息可以在通知方法的参数位置设置 JoinPoint 类型的形参。

```java
// @Before("execution(public Integer com.myxh.spring.aop.annotation.CalculatorImpl.add(Integer, Integer))")
// @Before("execution(* com.myxh.spring.aop.annotation.CalculatorImpl.*(..))")
@Before("pointCut()")
public void beforeAdviceMethod(JoinPoint joinPoint)
{
    // 获取连接点所对应方法的签名信息
    Signature signature = joinPoint.getSignature();

    // 获取连接点所对应方法的方法名
    String name = signature.getName();

    // 获取连接点所对应方法的参数
    Object[] args = joinPoint.getArgs();

    System.out.println("[LoggerAspect] 方法：" + name + "，参数：" + Arrays.toString(args));
}
```

##### 3.4.7.2 ② 获取目标方法的返回值

@AfterReturning 中的属性 returning，用来将通知方法的某个形参，接收目标方法的返回值。

```java
/**
 * 在返回通知中若要获取目标对象方法的返回值
 * 只需要通过 {@code @AfterReturning} 注解的 returning 属性
 * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
 *
 * @param joinPoint 连接点
 * @param result 结果
 */
@AfterReturning(value = "pointCut()", returning = "result")
public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result)
{
    // 获取连接点所对应方法的签名信息
    Signature signature = joinPoint.getSignature();

    // 获取连接点所对应方法的方法名
    String name = signature.getName();

    System.out.println("[LoggerAspect] 方法：" + name + "，结果：" + result);
}
```

##### 3.4.7.3 ③ 获取目标方法的异常

@AfterThrowing 中的属性 throwing，用来将通知方法的某个形参，接收目标方法的异常。

```java
/**
 * 在异常通知中若要获取目标对象方法的异常
 * 只需要通过 {@code @AfterThrowing} 注解的 throwing 属性
 * 就可以将通知方法的某个参数指定为接收目标对象方法出现的异常的参数
 *
 * @param joinPoint 连接点
 * @param exception 异常
 */
@AfterThrowing(value = "pointCut()", throwing = "exception")
public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable exception)
{
    // 获取连接点所对应方法的签名信息
    Signature signature = joinPoint.getSignature();

    // 获取连接点所对应方法的方法名
    String name = signature.getName();

    System.out.println("[LoggerAspect] 方法：" + name + "，异常：" + exception);
}
```

#### 3.4.8、环绕通知

```java
/**
 * 环绕通知的方法的返回值一定要和目标对象方法的返回值一致
 *
 * @param joinPoint 连接点
 * @return result 结果
 */
@Around("pointCut()")
public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint)
{
    Object result = null;

    try
    {
        System.out.println("环绕通知 -> 前置通知");

        // 表示目标对象方法的执行
        result  = joinPoint.proceed();

        System.out.println("环绕通知 -> 返回通知");
    }
    catch (Throwable e)
    {
        System.out.println("环绕通知 -> 异常通知");
        e.printStackTrace();
    }
    finally
    {
        System.out.println("环绕通知 -> 后置通知");
    }

    return result;
}
```

#### 3.4.9、切面的优先级

相同目标方法上同时存在多个切面时，切面的优先级控制切面的**内外嵌套**顺序。

- 优先级高的切面：外面。

- 优先级低的切面：里面。

使用@Order 注解可以控制切面的优先级：

- @Order(较小的数)：优先级高。

- @Order(较大的数)：优先级低。

![切面的优先级](https://img-blog.csdnimg.cn/e5d18ddcdd494154939ff6c439ebb0a4.png)

### 3.5，基于 XML 的 AOP（了解）

#### 3.5.1、准备工作

参考基于注解的 AOP 环境。

#### 3.5.2、实现

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns="http://www.springframework.org/schema/beans"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd   http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!-- 扫描组件 -->
    <context:component-scan base-package="com.myxh.spring.aop.xml"/>

    <aop:config>
        <!-- 设置一个公共的切入点表达式 -->
        <aop:pointcut id="pointCut" expression="execution(* com.myxh.spring.aop.xml.CalculatorImpl.*(..))"/>

        <!-- 将 IOC 容器中的某个 bean 设置为切面 -->
        <aop:aspect ref="loggerAspect">
            <aop:before method="beforeAdviceMethod" pointcut-ref="pointCut"/>
            <aop:after method="afterAdviceMethod" pointcut-ref="pointCut"/>
            <aop:after-returning method="afterReturningAdviceMethod" returning="result" pointcut-ref="pointCut"/>
            <aop:after-throwing method="afterThrowingAdviceMethod" throwing="exception" pointcut-ref="pointCut"/>
            <aop:around method="aroundAdviceMethod" pointcut-ref="pointCut"/>
        </aop:aspect>

        <aop:aspect ref="validateAspect" order="1">
            <aop:before method="beforeMethod" pointcut-ref="pointCut"/>
        </aop:aspect>
    </aop:config>
</beans>
```

## 4、声明式事务

### 4.1、JdbcTemplate

#### 4.1.1、简介

Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作。

#### 4.1.2、准备工作

##### 4.1.2.1 ① 加入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.myxh.spring</groupId>
    <artifactId>spring_transaction</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- 基于 Maven 依赖传递性，导入 spring-context 依赖即可导入当前所需所有 jar 包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.0.9</version>
        </dependency>

        <!-- Spring 持久化层支持 jar 包 -->
        <!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用 orm、jdbc、tx 三个 jar 包 -->
        <!-- 导入 orm 包就可以通过 Maven 的依赖传递性把其他两个也导入 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>6.0.6</version>
        </dependency>

        <!-- Spring 测试相关 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>6.0.6</version>
        </dependency>

        <!-- junit 测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <!-- spring-aspects 会帮我们传递过来 aspectjweaver -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>6.0.9</version>
        </dependency>

        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>

        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.16</version>
        </dependency>
    </dependencies>
</project>
```

##### 4.1.2.2 ② 创建 jdbc.properties

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.username=MYXH
jdbc.password=520.ILY!
```

##### 4.1.2.3 ③ 配置 Spring 的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 引入外部属性文件 jdbc.properties -->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!-- 配置 JdbcTemplate -->
    <bean class="org.springframework.jdbc.core.JdbcTemplate">
        <!-- 装配数据源 -->
        <property name="dataSource" ref="dataSource"/>
    </bean>
</beans>
```

#### 4.1.3、测试

##### 4.1.3.1 ① 在测试类装配 JdbcTemplate

```java
package com.myxh.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MYXH
 * @date 2023/8/29
 */
// 指定当前测试类在 Spring 的测试环境中执行，此时就可以通过注入的方式直接获取 IOC 容器中的 bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置 spring 测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
```

##### 4.1.3.2 ② 测试增删改功能

```java
@Test
public void testInsert()
{
    String sql = "insert into t_user (id, username, password, age, gender, email) values (null, ?, ?, ?, ?, ?);";
    int result = jdbcTemplate.update(sql, "test", "test", 18, "男", "test@@qq.com");
    System.out.println("result = " + result);
}
```

##### 4.1.3.3 ③ 查询一条数据为实体类对象

```java
@Test
public void testGetUserById()
{
    String sql = "select * from t_user where id = ?;";
    User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
    System.out.println("user = " + user);
}
```

##### 4.1.3.4 ④ 查询多条数据为一个 list 集合

```java
@Test
public void testGetAllUser()
{
    String sql = "select * from t_user;";
    List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    userList.forEach(System.out::println);
}
```

##### 4.1.3.5 ⑤ 查询单行单列的值

```java
@Test
public void testGetCount()
{
    String sql = "select count(*) from t_user;";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    System.out.println("count = " + count);
}
```

### 4.2、声明式事务概念

#### 4.2.1、编程式事务

事务功能的相关操作全部通过自己编写代码来实现：

```java
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "MYXH", "520.ILY!");

try
{
    // 开启事务：关闭事务的自动提交
    connection.setAutoCommit(false);

    // 核心操作

    // 提交事务
    connection.commit();
}
catch(Exception e)
{
    // 回滚事务
    connection.rollBack();
}
finally
{
    // 释放数据库连接
    connection.close();
}
```

编程式的实现方式存在缺陷：

- 细节没有被屏蔽：具体操作过程中，所有细节都需要程序员自己来完成，比较繁琐。

- 代码复用性不高：如果没有有效抽取出来，每次实现功能都需要自己编写代码，代码就没有得到复用。

#### 4.2.2、声明式事务

既然事务控制的代码有规律可循，代码的结构基本是确定的，所以框架就可以将固定模式的代码抽取出来，进行相关的封装。

封装起来后，我们只需要在配置文件中进行简单的配置即可完成操作。

- 好处 1：提高开发效率。

- 好处 2：消除了冗余的代码。

- 好处 3：框架会综合考虑相关领域中在实际开发环境下有可能遇到的各种问题，进行了健壮性、性能等各个方面的优化。

所以，我们可以总结下面两个概念：

- **编程式**：**自己写代码**实现功能。

- **声明式**：通过**配置**让**框架**实现功能。

### 4.3、基于注解的声明式事务

#### 4.3.1、准备工作

##### 4.3.1.1 ① 加入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.myxh.spring</groupId>
    <artifactId>spring_transaction</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- 基于 Maven 依赖传递性，导入 spring-context 依赖即可导入当前所需所有 jar 包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.0.9</version>
        </dependency>

        <!-- Spring 持久化层支持 jar 包 -->
        <!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用 orm、jdbc、tx 三个 jar 包 -->
        <!-- 导入 orm 包就可以通过 Maven 的依赖传递性把其他两个也导入 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>6.0.6</version>
        </dependency>

        <!-- Spring 测试相关 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>6.0.6</version>
        </dependency>

        <!-- junit 测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <!-- spring-aspects 会帮我们传递过来 aspectjweaver -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>6.0.9</version>
        </dependency>

        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>

        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.16</version>
        </dependency>
    </dependencies>
</project>
```

##### 4.3.1.2 ② 创建 jdbc.properties

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.username=MYXH
jdbc.password=520.ILY!
```

##### 4.3.1.3 ③ 配置 Spring 的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns="http://www.springframework.org/schema/beans"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 扫描组件 -->
    <context:component-scan base-package="com.myxh.spring"/>

    <!-- 引入外部属性文件 jdbc.properties -->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!-- 配置 JdbcTemplate -->
    <bean class="org.springframework.jdbc.core.JdbcTemplate">
        <!-- 装配数据源 -->
        <property name="dataSource" ref="dataSource"/>
    </bean>
</bean>
```

##### 4.3.1.4 ④ 创建表

```sql

# 创建图书表 t_book
CREATE TABLE IF NOT EXISTS t_book
(
    book_id   INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    book_name VARCHAR(20)            DEFAULT NULL COMMENT '图书名称',
    price     DECIMAL(8, 2) UNSIGNED DEFAULT NULL COMMENT '价格',
    stock     INT(10) UNSIGNED       DEFAULT NULL COMMENT '库存（无符号）',
    PRIMARY KEY (book_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

# 添加图书表 t_book 的数据
insert into t_book(book_id, book_name, price, stock)
values (1, '三体', 80, 100),
       (2, '小王子', 50, 100);

# 创建书店用户表 t_bookstore_user
CREATE TABLE t_bookstore_user
(
    user_id  INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    username VARCHAR(20)            DEFAULT NULL COMMENT '用户名',
    balance  DECIMAL(8, 2) UNSIGNED DEFAULT NULL COMMENT '余额（无符号）',
    PRIMARY KEY (user_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

# 添加书店用户表 t_bookstore_user 的数据
INSERT INTO t_bookstore_user(user_id, username, balance)
VALUES (1, 'MYXH', 50);
```

##### 4.3.1.5 ⑤ 创建组件

创建 BookController：

```java
package com.myxh.spring.controller;

import com.myxh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Controller
public class BookController
{
    @Autowired
    private BookService bookService;

    public void buyBook(Integer userId, Integer bookId)
    {
        bookService.buyBook(userId, bookId);
    }
}
```

创建接口 BookService：

```java
package com.myxh.spring.service;

/**
 * @author MYXH
 * @date 2023/8/29
 */
public interface BookService
{
    /**
     * 买书
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     */
    void buyBook(Integer userId, Integer bookId);
}
```

创建实现类 BookServiceImpl：

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.dao.BookDao;
import com.myxh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDao bookDao;

    /**
     * 买书
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     */
    @Override
    public void buyBook(Integer userId, Integer bookId)
    {
        // 查询图书的价格
        BigDecimal price = bookDao.getPriceByBookId(bookId);

        // 更新图书的库存
        bookDao.updateStock(bookId);

        // 更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
```

创建接口 BookDao：

```java
package com.myxh.spring.dao;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
public interface BookDao
{
    /**
     * 根据图书的 id 查询图书的价格
     *
     * @param bookId 图书 id
     * @return 图书价格
     */
    BigDecimal getPriceByBookId(Integer bookId);

    /**
     * 更新图书的库存
     *
     * @param bookId 图书 id
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额
     *
     * @param userId 用户 id
     * @param price  图书价格
     */
    void updateBalance(Integer userId, BigDecimal price);
}
```

创建实现类 BookDaoImpl：

```java
package com.myxh.spring.dao.impl;

import com.myxh.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Repository
public class BookDaoImpl implements BookDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据图书的 id 查询图书的价格
     *
     * @param bookId 图书 id
     * @return 图书价格
     */
    @Override
    public BigDecimal getPriceByBookId(Integer bookId)
    {
        String sql = "select price from t_book where book_id = ?;";
        BigDecimal price = jdbcTemplate.queryForObject(sql, BigDecimal.class, bookId);

        return price;
    }

    /**
     * 更新图书的库存
     *
     * @param bookId 图书 id
     */
    @Override
    public void updateStock(Integer bookId)
    {
        String sql = "update t_book set stock = stock - 1 where book_id = ?;";
        jdbcTemplate.update(sql,bookId);
    }

    /**
     * 更新用户的余额
     *
     * @param userId 用户 id
     * @param price  图书价格
     */
    @Override
    public void updateBalance(Integer userId, BigDecimal price)
    {
        String sql = "update t_bookstore_user set balance = balance - ? where user_id = ?;";
        jdbcTemplate.update(sql,price, userId);
    }
}
```

#### 4.3.2、测试无事务情况

##### 4.3.2.1 ① 创建测试类

```java
package com.myxh.spring.test;

import com.myxh.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest
{
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook()
    {
        bookController.buyBook(1,1);
    }
}
```

##### 4.3.2.2 ② 模拟场景

用户购买图书，先查询图书的价格，再更新图书的库存和用户的余额。

假设用户 id 为 1 的用户，购买 id 为 1 的图书。

用户余额为 50，而图书价格为 80。

购买图书之后，用户的余额为-30，数据库中余额字段设置了无符号，因此无法将-30 插入到余额字段。

此时执行 sql 语句会抛出 SQLException。

##### 4.3.2.3 ③ 观察结果

因为没有添加事务，图书的库存更新了，但是用户的余额没有更新。

显然这样的结果是错误的，购买图书是一个完整的功能，更新库存和更新余额要么都成功要么都失败。

#### 4.3.3、加入事务

##### 4.3.3.1 ① 添加事务配置

在 Spring 的配置文件中添加配置：

```xml
<!-- 配置事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

<!--
开启事务的注解驱动
将使用 @Transactional 注解所标识的方法或类中所有的方法使用事务进行管理
transaction-manager 属性设置事务管理器的 id
若事务管理器的 bean 的 id 默认为 transactionManager，则该属性可以不写
    -->
<tx:annotation-driven transaction-manager="transactionManager"/>
```

注意：导入的名称空间需要 **tx** **结尾**的那个。

![① 添加事务配置](https://img-blog.csdnimg.cn/f37defe079a54a5eb1bb00a5f9a0ae01.png)

##### 4.3.3.2 ② 添加事务注解

因为 service 层表示业务逻辑层，一个方法表示一个完成的功能，因此处理事务一般在 service 层处理。

在 BookServiceImpl 的 buybook()添加注解@Transactional。

##### 4.3.3.3 ③ 观察结果

由于使用了 Spring 的声明式事务，更新库存和更新余额都没有执行。

#### 4.3.4、@Transactional 注解标识的位置

@Transactional 标识在方法上，咋只会影响该方法。

@Transactional 标识的类上，咋会影响类中所有的方法。

#### 4.3.5、事务属性：只读

##### 4.3.5.1 ① 介绍

对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。

##### 4.3.5.2 ② 使用方式

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.dao.BookDao;
import com.myxh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDao bookDao;

    /**
     * 买书
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     */
    @Override

    @Transactional(readOnly = true)
    public void buyBook(Integer userId, Integer bookId)
    {
        // 查询图书的价格
        BigDecimal price = bookDao.getPriceByBookId(bookId);

        // 更新图书的库存
        bookDao.updateStock(bookId);

        // 更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
```

##### 4.3.5.3 ③ 注意

对增删改操作设置只读会抛出下面异常：

> Caused by: java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed

#### 4.3.6、事务属性：超时

##### 4.3.6.1 ① 介绍

事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间占用资源，大概率是因为程序运行出现了问题（可能是 Java 程序或 MySQL 数据库或网络连接等等）。

此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常程序可以执行。

概括来说就是一句话：超时回滚，释放资源。

##### 4.3.6.2 ② 使用方式

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.dao.BookDao;
import com.myxh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDao bookDao;

    /**
     * 买书
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     */
    @Override
    @Transactional(
            // readOnly = true
            timeout = 3
    )
    public void buyBook(Integer userId, Integer bookId)
    {
        try
        {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // 查询图书的价格
        BigDecimal price = bookDao.getPriceByBookId(bookId);

        // 更新图书的库存
        bookDao.updateStock(bookId);

        // 更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
```

##### 4.3.6.3 ③ 观察结果

执行过程中抛出异常：

> org.springframework.transaction.**TransactionTimedOutException**: Transaction timed out: deadline was Fri Aug 29 12:00:00 CST 2023

#### 4.3.7、事务属性：回滚策略

##### 4.3.7.1 ① 介绍

声明式事务默认只针对运行时异常回滚，编译时异常不回滚。

可以通过@Transactional 中相关属性设置回滚策略

- rollbackFor 属性：需要设置一个 Class 类型的对象。

- rollbackForClassName 属性：需要设置一个字符串类型的全类名。

- noRollbackFor 属性：需要设置一个 Class 类型的对象。

- rollbackFor 属性：需要设置一个字符串类型的全类名。

##### 4.3.7.2 ② 使用方式

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.dao.BookDao;
import com.myxh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDao bookDao;

    /**
     * 买书
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     */
    @Override
    @Transactional(
            // readOnly = true
            // timeout = 3
            noRollbackFor = ArithmeticException.class
            // noRollbackForClassName = "java.lang.ArithmeticException"
    )
    public void buyBook(Integer userId, Integer bookId)
    {
        /*
        try
        {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
         */

        // 查询图书的价格
        BigDecimal price = bookDao.getPriceByBookId(bookId);

        // 更新图书的库存
        bookDao.updateStock(bookId);

        // 更新用户的余额
        bookDao.updateBalance(userId, price);

        System.out.println(1 / 0);
    }
}
```

##### 4.3.7.3 ③ 观察结果

虽然购买图书功能中出现了数学运算异常（ArithmeticException），但是我们设置的回滚策略是，当出现 ArithmeticException 不发生回滚，因此购买图书的操作正常执行。

#### 4.3.8、事务属性：事务隔离级别

##### 4.3.8.1 ① 介绍

数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题。一个事务与其他事务隔离的程度称为隔离级别。SQL 标准中规定了多种事务隔离级别，不同隔离级别对应不同的干扰程度，隔离级别越高，数据一致性就越好，但并发性越弱。

隔离级别一共有四种：

- 读未提交：READ UNCOMMITTED

允许 Transaction01 读取 Transaction02 未提交的修改。

- 读已提交：READ COMMITTED

要求 Transaction01 只能读取 Transaction02 已提交的修改。

- 可重复读：REPEATABLE READ

确保 Transaction01 可以多次从一个字段中读取到相同的值，即 Transaction01 执行期间禁止其它事务对这个字段进行更新。

- 串行化：SERIALIZABLE

确保 Transaction01 可以多次从一个表中读取到相同的行，在 Transaction01 执行期间，禁止其它事务对这个表进行添加、更新、删除操作。可以避免任何并发问题，但性能十分低下。

各个隔离级别解决并发问题的能力见下表：

| **隔离级别**     | **脏读** | **不可重复读** | **幻读** |
| ---------------- | -------- | -------------- | -------- |
| READ UNCOMMITTED | 有       | 有             | 有       |
| READ COMMITTED   | 无       | 有             | 有       |
| REPEATABLE READ  | 无       | 无             | 有       |
| SERIALIZABLE     | 无       | 无             | 无       |

各种数据库产品对事务隔离级别的支持程度：

| **隔离级别**     | **Oracle** | **MySQL** |
| ---------------- | ---------- | --------- |
| READ UNCOMMITTED | ×          | √         |
| READ COMMITTED   | √(默认)    | √         |
| REPEATABLE READ  | ×          | √(默认)   |
| SERIALIZABLE     | √          | √         |

##### 4.3.8.2 ② 使用方式

```java
// 使用数据库默认的隔离级别
@Transactional(isolation = Isolation.DEFAULT)

// 读未提交
@Transactional(isolation = Isolation.READ_UNCOMMITTED)

// 读已提交
@Transactional(isolation = Isolation.READ_COMMITTED)

// 可重复读
@Transactional(isolation = Isolation.REPEATABLE_READ)

// 串行化
@Transactional(isolation = Isolation.SERIALIZABLE)
```

#### 4.3.9、事务属性：事务传播行为

##### 4.3.9.1 ① 介绍

当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。

##### 4.3.9.2 ② 测试

创建接口 CheckoutService：

```java
package com.myxh.spring.service;

/**
 * @author MYXH
 * @date 2023/8/29
 */
public interface CheckoutService
{
    /**
     * 结账
     *
     * @param userId 用户 id
     * @param bookIds 一些图书 id
     */
    void checkout(Integer userId, Integer[] bookIds);
}
```

创建实现类 CheckoutServiceImpl：

```java
package com.myxh.spring.service.impl;

import com.myxh.spring.service.BookService;
import com.myxh.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/8/29
 */
@Service
public class CheckoutServiceImpl implements CheckoutService
{
    @Autowired
    private BookService bookService;

    /**
     * 结账
     *
     * @param userId 用户 id
     * @param bookIds 一些图书 id
     */
    @Override
    // @Transactional
    public void checkout(Integer userId, Integer[] bookIds)
    {
        for (Integer bookId : bookIds)
        {
            bookService.buyBook(userId,bookId);
        }
    }
}
```

在 BookController 中添加方法：

```java
@Autowired
private CheckoutService checkoutService;

public void checkout(Integer[] bookIds, Integer userId)
{
    checkoutService.checkout(bookIds, userId);
}
```

在数据库中将用户的余额修改为 100 元。

##### 4.3.9.3 ③ 观察结果

可以通过@Transactional 中的 propagation 属性设置事务传播行为。

修改 BookServiceImpl 中 buyBook()上，注解@Transactional 的 propagation 属性。

@Transactional(propagation = Propagation.REQUIRED)，默认情况，表示如果当前线程上有已经开启的事务可用，那么就在这个事务中运行。经过观察，购买图书的方法 buyBook()在 checkout()中被调用，checkout()上有事务注解，因此在此事务中执行。所购买的两本图书的价格为 80 和 50，而用户的余额为 100，因此在购买第二本图书时余额不足失败，导致整个 checkout()回滚，即只要有一本书买不了，就都买不了。

@Transactional(propagation = Propagation.REQUIRES_NEW)，表示不管当前线程上是否有已经开启的事务，都要开启新事务。同样的场景，每次购买图书都是在 buyBook()的事务中执行，因此第一本图书购买成功，事务结束，第二本图书购买失败，只在第二次的 buyBook()中回滚，购买第一本图书不受影响，即能买几本就买几本。

### 4.4、基于 XML 的声明式事务

#### 4.3.1、场景模拟

参考基于注解的声明式事务。

#### 4.3.2、修改 Spring 配置文件

将 Spring 配置文件中去掉 tx:annotation-driven 标签，并添加配置：

```xml
<!-- 配置事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

<!-- 配置事务通知 -->
<tx:advice id="tx" transaction-manager="transactionManager">
    <tx:attributes>
        <tx:method name="buyBook" propagation="REQUIRES_NEW"/>
        <tx:method name="checkout"/>
        <tx:method name="*"/>
    </tx:attributes>
</tx:advice>

<!-- 配置切入点表达式 -->
<aop:config>
    <aop:advisor advice-ref="tx" pointcut="execution(* com.myxh.spring.service.impl.*.*(..))"/>
</aop:config>
```

> 注意：基于 xml 实现的声明式事务，必须引入 aspectJ 的依赖。
>
> ```xml
> <!-- spring-aspects 会帮我们传递过来 aspectjweaver -->
> <dependency>
>     <groupId>org.springframework</groupId>
>     <artifactId>spring-aspects</artifactId>
>     <version>6.0.9</version>
> </dependency>
> ```

# 三、SpringMVC

## 1、SpringMVC 简介

### 1.1、什么是 MVC

MVC 是一种软件架构的思想，将软件按照模型、视图、控制器来划分。

M：Model，模型层，指工程中的 JavaBean，作用是处理数据。

JavaBean 分为两类：

- 一类称为实体类 Bean：专门存储业务数据的，如 Student、User 等。

- 一类称为业务处理 Bean：指 Service 或 Dao 对象，专门用于处理业务逻辑和数据访问。

V：View，视图层，指工程中的 html 或 jsp 等页面，作用是与用户进行交互，展示数据。

C：Controller，控制层，指工程中的 servlet，作用是接收请求和响应浏览器。

MVC 的工作流程： 用户通过视图层发送请求到服务器，在服务器中请求被 Controller 接收，Controller 调用相应的 Model 层处理请求，处理完毕将结果返回到 Controller，Controller 再根据请求处理的结果找到相应的 View 视图，渲染数据后最终响应给浏览器。

### 1.2、什么是 SpringMVC

SpringMVC 是 Spring 的一个后续产品，是 Spring 的一个子项目。

SpringMVC 是 Spring 为表述层开发提供的一整套完备的解决方案。在表述层框架历经 Strust、WebWork、Strust2 等诸多产品的历代更迭之后，目前业界普遍选择 SpringMVC 作为 Java EE 项目表述层开发的**首选方案**。

> 注意：三层架构分为表述层（或表示层）、业务逻辑层、数据访问层，表述层表示前台页面和后台 servlet。

### 1.3、SpringMVC 的特点

- **Spring** **家族原生产品**，与 IOC 容器等基础设施无缝对接。

- **基于原生的 Servlet**，通过了功能强大的**前端控制器 DispatcherServlet**，对请求和响应进行统一处理。

- 表述层各细分领域需要解决的问题**全方位覆盖**，提供**全面解决方案**。

- **代码清新简洁**，大幅度提升开发效率。

- 内部组件化程度高，可插拔式组件**即插即用**，想要什么功能配置相应组件即可。

- **性能卓著**，尤其适合现代大型、超大型互联网项目要求。

## 2、入门案例

### 2.1、开发环境

IDE：idea 2022.3

构建工具：maven 3.8.1

服务器：tomcat 10.1.13

Spring 版本：6.0.9

### 2.2、创建 maven 工程

#### 2.2.1 ① 添加 web 模块

#### 2.2.2 ② 打包方式：war

#### 2.2.3 ③ 引入依赖

```xml
<dependencies>
    <!-- SpringMVC -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>6.0.9</version>
    </dependency>

    <!-- 日志 -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.4.7</version>
    </dependency>

    <!-- ServletAPI -->
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>

    <!-- Spring6 和 Thymeleaf 整合包 -->
    <dependency>
        <groupId>org.thymeleaf</groupId>
        <artifactId>thymeleaf-spring6</artifactId>
        <version>3.1.1.RELEASE</version>
    </dependency>
</dependencies>
```

> 注意：由于 Maven 的传递性，我们不必将所有需要的包全部配置依赖，而是配置最顶端的依赖，其他靠传递性导入。

![③ 引入依赖](https://img-blog.csdnimg.cn/1dd63bd041864762bb555037baa1f380.png)

### 2.3、配置 web.xml

注册 SpringMVC 的前端控制器 DispatcherServlet。

#### 2.3.1 ① 默认配置方式

此配置作用下，SpringMVC 的配置文件默认位于 WEB-INF 下，默认名称为 \<servlet-name\>-servlet.xml，例如，以下配置所对应 SpringMVC 的配置文件位于 WEB-INF 下，文件名为 springMVC-servlet.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <!-- 配置 SpringMVC 的前端控制器 DispatcherServlet -->
    <!--
        SpringMVC 的配置文件默认的位置和名称：
        位置：WEB-INF 下
        名称：<servlet-name>-servlet.xml，当前配置下的配置文件名为 SpringMVC-servlet.xml
     -->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <!--
            url-pattern 中 / 和 /* 的区别：
            /：匹配浏览器向服务器发送的所有请求（不包括 .jsp）
            /*：匹配浏览器向服务器发送的所有请求（包括 .jsp）
         -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

#### 2.3.2 ② 扩展配置方式

可通过 init-param 标签设置 SpringMVC 配置文件的位置和名称，通过 load-on-startup 标签设置 SpringMVC 前端控制器 DispatcherServlet 的初始化时间。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <!-- 配置 SpringMVC 的前端控制器 DispatcherServlet -->
    <!--
        SpringMVC 的配置文件默认的位置和名称：
        位置：WEB-INF 下
        名称：<servlet-name>-servlet.xml，当前配置下的配置文件名为 SpringMVC-servlet.xml
     -->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <!-- 设置 SpringMVC 配置文件的位置和名称 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>

        <!-- 将 DispatcherServlet 的初始化时间提前到服务器启动时 -->
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <!--
            url-pattern 中 / 和 /* 的区别：
            /：匹配浏览器向服务器发送的所有请求（不包括 .jsp）
            /*：匹配浏览器向服务器发送的所有请求（包括 .jsp）
         -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

> 注意：
>
> <url-pattern>标签中使用 / 和 /\* 的区别：
>
> / 所匹配的请求可以是 /login 或 .html 或 .js 或 .css 方式的请求路径，但是 / 不能匹配 .jsp 请求路径的请求。
>
> 因此就可以避免在访问 jsp 页面时，该请求被 DispatcherServlet 处理，从而找不到相应的页面。
>
> /\* 则能够匹配所有请求，例如在使用过滤器时，若需要对所有请求进行过滤，就需要使用 /\* 的写法。

### 2.4、创建请求控制器

由于前端控制器对浏览器发送的请求进行了统一的处理，但是具体的请求有不同的处理过程，因此需要创建处理具体请求的类，即请求控制器。

请求控制器中每一个处理请求的方法成为控制器方法。。

因为 SpringMVC 的控制器由一个 POJO（普通的 Java 类）担任，因此需要通过@Controller 注解将其标识为一个控制层组件，交给 Spring 的 IOC 容器管理，此时 SpringMVC 才能够识别控制器的存在。

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/8/31
 */
@Controller
public class HelloController
{

}
```

### 2.5、创建 SpringMVC 的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns="http://www.springframework.org/schema/beans"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 扫描控制层组件 -->
    <context:component-scan base-package="com.myxh.springmvc.controller"/>

    <!-- 配置 Thymeleaf 视图解析器 -->
    <bean id="viewResolver" class="org.thymeleaf.spring6.view.ThymeleafViewResolver">
        <property name="order" value="1"/>
        <property name="characterEncoding" value="UTF-8"/>
        <property name="templateEngine">
            <bean class="org.thymeleaf.spring6.SpringTemplateEngine">
                <property name="templateResolver">
                    <bean class="org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver">
                        <!-- 视图前缀 -->
                        <property name="prefix" value="/WEB-INF/templates/"/>

                        <!-- 视图后缀 -->
                        <property name="suffix" value=".html"/>

                        <property name="templateMode" value="HTML"/>
                        <property name="characterEncoding" value="UTF-8"/>
                    </bean>
                </property>
            </bean>
        </property>
    </bean>
</beans>
```

### 2.6、测试 HelloWorld

#### 2.6.1 ① 实现对首页的访问

在请求控制器中创建处理请求的方法。

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/8/31
 */
@Controller
public class HelloController
{
    @RequestMapping("/")
    public String portal()
    {
        // 将逻辑视图返回
        return "index";
    }
}
```

#### 2.6.2 ② 通过超链接跳转到指定页面

在主页 index.html 中设置超链接。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <h1>index.html</h1>
    <h2>1、通过超链接跳转到指定页面</h2>
    <a th:href="@{/hello}">测试 SpringMVC 相对路径</a>
    <br />
    <a href="/hello">测试绝对路径</a>
  </body>
</html>
```

创建 success.html 页面。

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
  </body>
</html>
```

在请求控制器中创建处理请求的方法。

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/8/31
 */
@Controller
public class HelloController
{
    @RequestMapping("/")
    public String portal()
    {
        // 将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "success";
    }
}
```

### 2.7、总结

浏览器发送请求，若请求地址符合前端控制器的 url-pattern，该请求就会被前端控制器 DispatcherServlet 处理。前端控制器会读取 SpringMVC 的核心配置文件，通过扫描组件找到控制器，将请求地址和控制器中 @RequestMapping 注解的 value 属性值进行匹配，若匹配成功，该注解所标识的控制器方法就是处理请求的方法。处理请求的方法需要返回一个字符串类型的视图名称，该视图名称会被视图解析器解析，加上前缀和后缀组成视图的路径，通过 Thymeleaf 对视图进行渲染，最终转发到视图所对应页面。

## 3、@RequestMapping 注解

### 3.1、@RequestMapping 注解的功能

从注解名称上我们可以看到，@RequestMapping 注解的作用就是将请求和处理请求的控制器方法关联起来，建立映射关系。

SpringMVC 接收到指定的请求，就会来找到在映射关系中对应的控制器方法来处理这个请求。

### 3.2、@RequestMapping 注解的位置

@RequestMapping 标识一个类：设置映射请求的请求路径的初始信息。

@RequestMapping 标识一个方法：设置映射请求请求路径的具体信息。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <h1>index.html</h1>

    <h2>1、@RequestMapping注解</h2>
    <h3>1.1、@RequestMapping 注解标识的位置</h3>
    <a th:href="@{/test/hello}">测试 @RequestMapping 注解所标识的位置</a>
  </body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 1、@RequestMapping 注解标识的位置
 * {@code @RequestMapping} 标识一个类：设置映射请求的请求路径的初始信息
 * {@code @RequestMapping} 标识一个方法：设置映射请求请求路径的具体信息
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController
{
    // 此时控制器方法所匹配的请求的请路径为 /test/hello
    @RequestMapping("/hello")
    public String hello()
    {
        return "success";
    }
}
```

### 3.3、@RequestMapping 注解的 value 属性

@RequestMapping 注解的 value 属性通过请求的请求地址匹配请求映射。

@RequestMapping 注解的 value 属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求。

@RequestMapping 注解的 value 属性必须设置，至少通过请求地址匹配请求映射。

```html
<h3>1.2、@RequestMapping 注解 value 属性</h3>
<a th:href="@{/test/hello2}">测试 @RequestMapping 注解的 value 属性</a>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 1、@RequestMapping 注解标识的位置
 * {@code @RequestMapping} 标识一个类：设置映射请求的请求路径的初始信息
 * {@code @RequestMapping} 标识一个方法：设置映射请求请求路径的具体信息
 * <p>
 * 2、@RequestMapping 注解 value 属性
 * 作用：通过请求的请求路径匹配请求
 * value 属性是数组类型，即当前浏览器所发送请求的请求路径匹配 value 属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController
{
    // 此时控制器方法所匹配的请求的请路径为 /test/hello
    @RequestMapping(
            value = {"/hello", "/hello2"}
    )
    public String hello()
    {
        return "success";
    }
}
```

### 3.4、@RequestMapping 注解的 method 属性

@RequestMapping 注解的 method 属性通过请求的请求方式（get 或 post）匹配请求映射。

@RequestMapping 注解的 method 属性是一个 RequestMethod 类型的数组，表示该请求映射能够匹配多种请求方式的请求。

若当前请求的请求地址满足请求映射的 value 属性，但是请求方式不满足 method 属性，则浏览器报错 405：Request method 'POST' not supported。

```html
<h3>1.3、@RequestMapping 注解的 method属性</h3>
<form th:action="@{/test/hello}" method="post">
  <input type="submit" value="测试 @RequestMapping 注解的 method 属性" />
</form>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 1、@RequestMapping 注解标识的位置
 * {@code @RequestMapping} 标识一个类：设置映射请求的请求路径的初始信息
 * {@code @RequestMapping} 标识一个方法：设置映射请求请求路径的具体信息
 * <p>
 * 2、@RequestMapping 注解 value 属性
 * 作用：通过请求的请求路径匹配请求
 * value 属性是数组类型，即当前浏览器所发送请求的请求路径匹配 value 属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * <p>
 * 3、@RequestMapping 注解的 method属性
 * 作用：通过请求的请求方式匹配请求
 * method 属性是 RequestMethod 类型的数组，即当前浏览器所发送请求的请求方式匹配 method 属性中的任何一中请求方式
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求方式不匹配
 * 此时页面报错：HTTP 状态 405 - Request method 'XXX' not supported
 * 在 @RequestMapping 的基础上，结合请求方式的一些派生注解：
 * {@code @GetMapping}, @PostMapping, @DeleteMapping, @PutMapping
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController
{
    // 此时控制器方法所匹配的请求的请路径为 /test/hello
    @RequestMapping(
            value = {"/hello", "/hello2"},
            method = {RequestMethod.POST, RequestMethod.GET},
    )
    public String hello()
    {
        return "success";
    }
}
```

> 注意：
>
> 1、对于处理指定请求方式的控制器方法，SpringMVC 中提供了 @RequestMapping 的派生注解。
>
> 处理 get 请求的映射 -> @GetMapping。
>
> 处理 post 请求的映射 -> @PostMapping。
>
> 处理 put 请求的映射 -> @PutMapping。
>
> 处理 delete 请求的映射 -> @DeleteMapping。
>
> 2、常用的请求方式有 get，post，put，delete。
>
> 但是目前浏览器只支持 get 和 post，若在 form 表单提交时，为 method 设置了其他请求方式的字符串（put 或 delete），则按照默认的请求方式 get 处理。
>
> 若要发送 put 和 delete 请求，则需要通过 spring 提供的过滤 HiddenHttpMethodFilter，在 RESTful 部分。

### 3.5、@RequestMapping 注解的 params 属性（了解）

@RequestMapping 注解的 params 属性通过请求的请求参数匹配请求映射。

@RequestMapping 注解的 params 属性是一个字符串类型的数组，可以通过四种表达式设置请求参数和请求映射的匹配关系。

"param"：要求请求映射所匹配的请求必须携带 param 请求参数。

"!param"：要求请求映射所匹配的请求必须不能携带 param 请求参数。

"param=value"：要求请求映射所匹配的请求必须携带 param 请求参数且 param=value。

"param!=value"：要求请求映射所匹配的请求必须携带 param 请求参数但是 param!=value。

```html
<h3>1.4、@RequestMapping 注解的 params 属性</h3>
<form th:action="@{|/test/hello?username=${'MYXH'}|}" method="post">
  <input type="submit" value="测试 @RequestMapping 注解的 params 属性" />
</form>

<form th:action="@{/test/hello(username='MYXH')}" method="post">
  <input type="submit" value="测试 @RequestMapping 注解的 params 属性" />
</form>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 1、@RequestMapping 注解标识的位置
 * {@code @RequestMapping} 标识一个类：设置映射请求的请求路径的初始信息
 * {@code @RequestMapping} 标识一个方法：设置映射请求请求路径的具体信息
 * <p>
 * 2、@RequestMapping 注解 value 属性
 * 作用：通过请求的请求路径匹配请求
 * value 属性是数组类型，即当前浏览器所发送请求的请求路径匹配 value 属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * <p>
 * 3、@RequestMapping 注解的 method属性
 * 作用：通过请求的请求方式匹配请求
 * method 属性是 RequestMethod 类型的数组，即当前浏览器所发送请求的请求方式匹配 method 属性中的任何一中请求方式
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求方式不匹配
 * 此时页面报错：HTTP 状态 405 - Request method 'XXX' not supported
 * 在 @RequestMapping 的基础上，结合请求方式的一些派生注解：
 * {@code @GetMapping}, @PostMapping, @DeleteMapping, @PutMapping
 * <p>
 * 4、@RequestMapping 注解的 params 属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足 params 属性的设置
 * params 可以使用四种表达式：
 * "param"：表示当前所匹配请的请求参数中必须携带 param 参数
 * "!param"：表示当前所匹配请求的请求参数中一定不能携带 param 参数
 * "param=value"：表示当前所匹配请求的请求参数中必须携带 param 参数且值必须为 value
 * "param!=value"：表示当前所匹配请求的请求参数中可以不携带 param，若携带值一定不能是 value
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求参数不匹配
 * 此时页面报错：HTTP 状态 400 - Parameter conditions "username" not met for actual request parameters:
 * <p>
 * 5、@RequestMapping 注解的 headers 属性
 * 作用：通过请来的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足 headers 属性的设置
 * headers 可以使用四种表达式：
 * "header"：表示当前所匹配请的请求参数中必须携带 header 参数
 * "!header"：表示当前所匹配请求的请求参数中一定不能携带 header 参数
 * "header=value"：表示当前所匹配请求的请求参数中必须携带 header 参数且值必须为 value
 * "header!=value"：表示当前所匹配请求的请求参数中可以不携带 header，若携带值一定不能是 value
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求头信息不匹配
 * 此时页面报错：HTTP 状态 404 - The requested resource is not available.
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController
{
    // 此时控制器方法所匹配的请求的请路径为 /test/hello
    @RequestMapping(
            value = {"/hello", "/hello2"},
            method = {RequestMethod.POST, RequestMethod.GET},
            params = {"username", "!password", "age=21", "gender!=女"}
            headers = {"Referer"}
    )
    public String hello()
    {
        return "success";
    }
}
```

> 注意：
>
> 若当前请求满足 @RequestMapping 注解的 value 和 method 属性，但是不满足 params 属性，此时页面回报错 400：Parameter conditions "username, password!=520.ILY！" not met for actual request parameters: username={MYXH}, password={520.ILY!}

### 3.6、@RequestMapping 注解的 headers 属性（了解）

@RequestMapping 注解的 headers 属性通过请求的请求头信息匹配请求映射。

@RequestMapping 注解的 headers 属性是一个字符串类型的数组，可以通过四种表达式设置请求头信息和请求映射的匹配关系。

"header"：要求请求映射所匹配的请求必须携带 header 请求头信息。

"!header"：要求请求映射所匹配的请求必须不能携带 header 请求头信息。

"header=value"：要求请求映射所匹配的请求必须携带 header 请求头信息且 header=value。

"header!=value"：要求请求映射所匹配的请求必须携带 header 请求头信息且 header!=value。

若当前请求满足@RequestMapping 注解的 value 和 method 属性，但是不满足 headers 属性，此时页面显示 404 错误，即资源未找到。

### 3.7、SpringMVC 支持 ant 风格的路径

？：表示任意的单个字符。

\*：表示任意的 0 个或多个字符。

\*\*：表示任意层数的任意目录。

注意：在使用\*\*时，只能使用/\*\*/xx 的方式。

### 3.8、SpringMVC 支持路径中的占位符（重点）

原始方式：/deleteUser?id=1

rest 方式：/user/delete/1

SpringMVC 路径中的占位符常用于 RESTful 风格中，当请求路径中将某些数据通过路径的方式传输到服务器中，就可以在相应的 @RequestMapping 注解的 value 属性中通过占位符{xx}表示传输的数据，在通过 @PathVariable 注解，将占位符所表示的数据赋值给控制器方法的形参。

```html
<h3>1.5、SpringMVC 支持 ant 风格的路径</h3>
<a th:href="@{/test/ant/test}">测试 @RequestMapping 注解支持 ant 风格的路径</a>

<h3>1.6、SpringMVC 支持路径中的占位符</h3>
<form th:action="@{/test/rest/1/MYXH}" method="post">
  <input type="submit" value="测试 @RequestMapping 注解的 value 属性的占位符" />
</form>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 1、@RequestMapping 注解标识的位置
 * {@code @RequestMapping} 标识一个类：设置映射请求的请求路径的初始信息
 * {@code @RequestMapping} 标识一个方法：设置映射请求请求路径的具体信息
 * <p>
 * 2、@RequestMapping 注解 value 属性
 * 作用：通过请求的请求路径匹配请求
 * value 属性是数组类型，即当前浏览器所发送请求的请求路径匹配 value 属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * <p>
 * 3、@RequestMapping 注解的 method属性
 * 作用：通过请求的请求方式匹配请求
 * method 属性是 RequestMethod 类型的数组，即当前浏览器所发送请求的请求方式匹配 method 属性中的任何一中请求方式
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求方式不匹配
 * 此时页面报错：HTTP 状态 405 - Request method 'XXX' not supported
 * 在 @RequestMapping 的基础上，结合请求方式的一些派生注解：
 * {@code @GetMapping}, @PostMapping, @DeleteMapping, @PutMapping
 * <p>
 * 4、@RequestMapping 注解的 params 属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足 params 属性的设置
 * params 可以使用四种表达式：
 * "param"：表示当前所匹配请的请求参数中必须携带 param 参数
 * "!param"：表示当前所匹配请求的请求参数中一定不能携带 param 参数
 * "param=value"：表示当前所匹配请求的请求参数中必须携带 param 参数且值必须为 value
 * "param!=value"：表示当前所匹配请求的请求参数中可以不携带 param，若携带值一定不能是 value
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求参数不匹配
 * 此时页面报错：HTTP 状态 400 - Parameter conditions "username" not met for actual request parameters:
 * <p>
 * 5、@RequestMapping 注解的 headers 属性
 * 作用：通过请来的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足 headers 属性的设置
 * headers 可以使用四种表达式：
 * "header"：表示当前所匹配请的请求参数中必须携带 header 参数
 * "!header"：表示当前所匹配请求的请求参数中一定不能携带 header 参数
 * "header=value"：表示当前所匹配请求的请求参数中必须携带 header 参数且值必须为 value
 * "header!=value"：表示当前所匹配请求的请求参数中可以不携带 header，若携带值一定不能是 value
 * 若浏览器所发送的请求的请求路径和 @RequestMapping 注解 value 属性匹配，但是请求头信息不匹配
 * 此时页面报错：HTTP 状态 404 - The requested resource is not available.
 * <p>
 * 6、SpringMVC 支持 ant 风格的路径
 * 在 @RequestMapping 注解的 value 属性值中设置一些特殊字符
 * ?：任意的单个字符（不包括 ? 和 /）
 * *：任意个数的任意字符（不包括 ? 和 /）
 * **：任意层数的任意目录，注意使用方式只能 / ** /，** 写在双斜线中，前后不能有任何的其他字符
 * <p>
 * 7、@RequestMapping 注解使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest：/user/delete/1
 * 需要在 @RequestMapping 注解的 value 属性中所设置的路径中，使用(xx}的方式表示路径中的数据
 * 在通过 @PathVariable 注解，将位符所标识的值和控制器方法的形参进行绑定
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController
{
    // 此时控制器方法所匹配的请求的请路径为 /test/hello
    @RequestMapping(
            value = {"/hello", "/hello2"},
            method = {RequestMethod.POST, RequestMethod.GET},
            // params = {"username", "!password", "age=21", "gender!=女"}
            headers = {"Referer"}
    )
    public String hello()
    {
        return "success";
    }

    @RequestMapping("/ant/**")
    public String testAnt()
    {
        return "success";
    }

    @RequestMapping("/rest/{id}/{username}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username)
    {
        System.out.println("id = " + id);
        System.out.println("username = " + username);

        return "success";
    }
}
```

## 4、SpringMVC 获取请求参数

### 4.1、通过 ServletAPI 获取

将 HttpServletRequest 作为控制器方法的形参，此时 HttpServletRequest 类型的参数表示封装了当前请求的请求报文的对象。

```html
<h2>2、SpringMVC 获取请求参数</h2>
<h3>2.1、通过 ServletAPI 获取请求参数</h3>
<form th:action="@{/param/servlet/api}" method="post">
  <label>
    用户名：
    <input type="text" name="username" /><br />
    密 码：<input type="password" name="password" /><br />
    <input type="submit" value="登录" />
  </label>
</form>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 * @deprecated
 * 获取请求参数的方式：
 * 1、通过 ServletAPI 获获取
 * 只需要在控制器方法的形参位置设置 HttpServletRequest 类型的形参
 * 就可以在控制器方法中使用 request 对象获取请求参数
 */
@Controller
public class TestParamController
{
    @RequestMapping("/param/servlet/api")
    public String getParamByServletAPI(HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        return "success";
    }
}
```

### 4.2、通过控制器方法的形参获取请求参数

在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在 DispatcherServlet 中就会将请求参数赋值给相应的形参。

```html
<h3>2.2、通过控制器方法的形参获取请求参数</h3>
<form th:action="@{/param}" method="post">
  <label>
    用户名：
    <input type="text" name="name" /><br />
    密 码：<input type="password" name="password" /><br />
    <input type="submit" value="登录" />
  </label>
</form>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MYXH
 * @date 2023/9/1
 * @deprecated
 * 获取请求参数的方式：
 * 1、通过 ServletAPI 获获取
 * 只需要在控制器方法的形参位置设置 HttpServletRequest 类型的形参
 * 就可以在控制器方法中使用 request 对象获取请求参数
 * <p>
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 * <p>
 * 3、@RequestParam: 将请求参数和控制器方法的形参绑定
 * {@code @RequestParam} 注解的三个属性: value, required, defaultValue
 * value：设置和形参绑定的请参数的名宇
 * required：设置是否必须传输 vaLue 所对应的请求参数
 * 默认值为 true，表示 value 所对应的请求参数必须传输，否则页面报错：
 * HTTP 状态 400 - Required string parameter 'xxx' is not present
 * 若设置为 false，则表示 value 所对应的请求参数不是必须传输，若为传输，则形参值为 null
 * defaultValue：设置当没有传输 value 所对应的请求参数时，为形参设置的默认值，此时和 required 属性值无关
 * <p>
 * 4、@RequestHeader：请求头信息和控制器方法的形参绑定
 * {@code @RequestHeader} 注解的三个属性: value, required, defaultValue
 * <p>
 * 5、@CookieValue：cookie 数据和控制器方法的形参绑定
 * {@code @CookieValue} 注解的三个属性: value, required, defaultValue
 */
@Controller
public class TestParamController
{
    @RequestMapping("/param/servlet/api")
    public String getParamByServletAPI(HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "name", required = true, defaultValue = "MYXH") String username,
                           String password,
                           @RequestHeader("Referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId
    )
    {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("referer = " + referer);
        System.out.println("jsessionId = " + jsessionId);

        return "success";
    }
}
```

> 注意：
>
> 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数。
>
> 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据。
>
> 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果。

### 4.3、@RequestParam

@RequestParam 是将请求参数和控制器方法的形参创建映射关系。

@RequestParam 注解一共有三个属性：

value：指定为形参赋值的请求参数的参数名。

required：设置是否必须传输此请求参数，默认值为 true。

若设置为 true 时，则当前请求必须传输 value 所指定的请求参数，若没有传输该请求参数，且没有设置 defaultValue 属性，则页面报错 400：Required String parameter 'xxx' is not present；若设置为 false，则当前请求不是必须传输 value 所指定的请求参数，若没有传输，则注解所标识的形参的值为 null。

defaultValue：不管 required 属性值为 true 或 false，当 value 所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值。

### 4.4、@RequestHeader

@RequestHeader 是将请求头信息和控制器方法的形参创建映射关系。

@RequestHeader 注解一共有三个属性：value、required、defaultValue，用法同@RequestParam。

### 4.5、@CookieValue

@CookieValue 是将 cookie 数据和控制器方法的形参创建映射关系。

@CookieValue 注解一共有三个属性：value、required、defaultValue，用法同 @RequestParam。

### 4.6、通过 POJO 获取请求参数

可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，那么请求参数就会为此属性赋值。

```html
<h3>2.3、通过 pojo 取请求参数</h3>
<form th:action="@{/param/pojo}" method="post">
  <label>
    用户名：
    <input type="text" name="username" /><br />
    密 码：<input type="password" name="password" /><br />
    <input type="submit" value="登录" />
  </label>
</form>
```

```java
package com.myxh.springmvc.pojo;

import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/1
 */
@Component
public class User
{
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String email;

    public User()
    {

    }

    public User(Integer id, String username, String password, Integer age, String gender, String email)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
```

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MYXH
 * @date 2023/9/1
 * @deprecated
 * 获取请求参数的方式：
 * 1、通过 ServletAPI 获获取
 * 只需要在控制器方法的形参位置设置 HttpServletRequest 类型的形参
 * 就可以在控制器方法中使用 request 对象获取请求参数
 * <p>
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 * <p>
 * 3、@RequestParam: 将请求参数和控制器方法的形参绑定
 * {@code @RequestParam} 注解的三个属性: value, required, defaultValue
 * value：设置和形参绑定的请参数的名宇
 * required：设置是否必须传输 vaLue 所对应的请求参数
 * 默认值为 true，表示 value 所对应的请求参数必须传输，否则页面报错：
 * HTTP 状态 400 - Required string parameter 'xxx' is not present
 * 若设置为 false，则表示 value 所对应的请求参数不是必须传输，若为传输，则形参值为 null
 * defaultValue：设置当没有传输 value 所对应的请求参数时，为形参设置的默认值，此时和 required 属性值无关
 * <p>
 * 4、@RequestHeader：请求头信息和控制器方法的形参绑定
 * {@code @RequestHeader} 注解的三个属性: value, required, defaultValue
 * <p>
 * 5、@CookieValue：cookie 数据和控制器方法的形参绑定
 * {@code @CookieValue} 注解的三个属性: value, required, defaultValue
 * <p>
 * 6、通过控制器方法的实体类类型的形参获取请求参数
 * 需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的名字一致
 * 可以通过实体类类型的形参获取请求参数
 * <p>
 * 7、解决获取请求此参数的乱码问题
 * 在 web.xml 中配置 Spring 的编码过滤器 characterEncodingFilter
 */
@Controller
public class TestParamController
{
    @RequestMapping("/param/servlet/api")
    public String getParamByServletAPI(HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "name", required = true, defaultValue = "MYXH") String username,
                           String password,
                           @RequestHeader("Referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId
    )
    {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("referer = " + referer);
        System.out.println("jsessionId = " + jsessionId);

        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user)
    {
        System.out.println("user = " + user);

        return "success";
    }
}
```

### 4.7、解决获取请求参数的乱码问题

解决获取请求参数的乱码问题，可以使用 SpringMVC 提供的编码过滤器 CharacterEncodingFilter，但是必须在 web.xml 中进行注册。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <!-- 配置 Spring 的编码过滤器 -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>

        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 设置 SpringMVC 的前端控制器 -->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

> 注意：
>
> SpringMVC 中处理编码的过滤器一定要配置到其他过滤器之前，否则无效。

## 5、域对象共享数据

### 5.1、使用 ServletAPI 向 request 域对象共享数据

```html
<h2>3、域对象共享数据</h2>
<h3>3.1、使用 ServletAPI 向 request 域对象共享数据</h3>
<a th:href="@{/test/servlet/api}">测试 ServletAPI 向 request 域对象共享数据</a>
```

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
    <p th:text="${testRequestScope}" />
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }
}
```

### 5.2、使用 ModelAndView 向 request 域对象共享数据

```html
<h3>3.2、使用 ModelAndView 向 request 域对象共享数据</h3>
<a th:href="@{|/test/model/${#strings.escapeXml('and')}/view|}"
  >测试 ModelAndView 向 request 域对象共享数据</a
>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
```

### 5.3、使用 Model 向 request 域对象共享数据

```html
<h3>3.3、使用 Model 向 request 域对象共享数据</h3>
<a th:href="@{/test/model}">测试 Model 向 request 域对象共享数据</a>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 * <p>
 * 3、使用 Model 向 request 域对象共享数据
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model.getClass().getName() = " + model.getClass().getName());

        // 向请求域中共享数据
        model.addAttribute("testRequestScope", "Hello, Model");
        Object testRequestScope = model.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }
}
```

### 5.4、使用 ModelMap 向 request 域对象共享数据

```html
<h3>3.4、使用 ModelMap 向 request 域对象共享数据</h3>
<a th:href="@{/test/model/map}">测试 ModelMap 向 request 域对象共享数据</a>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 * <p>
 * 3、使用 Model 向 request 域对象共享数据
 * <p>
 * 4、使用 ModelMap 向 request 域对象共享数据
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model.getClass().getName() = " + model.getClass().getName());

        // 向请求域中共享数据
        model.addAttribute("testRequestScope", "Hello, Model");
        Object testRequestScope = model.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/model/map")
    public String testModelMap(ModelMap modelMap)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("modelMap.getClass().getName() = " + modelMap.getClass().getName());

        // 向请求域中共享数据
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");
        Object testRequestScope = modelMap.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }
}
```

### 5.5、使用 map 向 request 域对象共享数据

```html
<h3>3.5、使用 map 向 request 域对象共享数据</h3>
<a th:href="@{/test/map}">测试 map 向 request 域对象共享数据</a>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 * <p>
 * 3、使用 Model 向 request 域对象共享数据
 * <p>
 * 4、使用 ModelMap 向 request 域对象共享数据
 * <p>
 * 5、使用 map 向 request 域对象共享数据
 * 6、Model 和 ModelMap 和 map 的关系
 * 其实在底层中，这些类型的形参最终都是通过 BindingAwareModelMap 创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 * public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {}
 * public interface Model {}
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model.getClass().getName() = " + model.getClass().getName());

        // 向请求域中共享数据
        model.addAttribute("testRequestScope", "Hello, Model");
        Object testRequestScope = model.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/model/map")
    public String testModelMap(ModelMap modelMap)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("modelMap.getClass().getName() = " + modelMap.getClass().getName());

        // 向请求域中共享数据
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");
        Object testRequestScope = modelMap.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("map.getClass().getName() = " + map.getClass().getName());

        // 向请求域中共享数据
        map.put("testRequestScope", "Hello, map");
        Object testRequestScope = map.get("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }
}
```

### 5.6、Model、ModelMap、Map 的关系

Model、ModelMap、Map 类型的参数其实本质上都是 BindingAwareModelMap 类型的。

```java
public interface Model {}
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {}
public class ModelMap extends LinkedHashMap<String, Object> {}
public class ExtendedModelMap extends ModelMap implements Model {}
public class BindingAwareModelMap extends ExtendedModelMap {}
```

### 5.7、向 session 域共享数据

```html
<h3>3.6、使用 ServletAPI 向 session 域共享数据</h3>
<a th:href="@{/test/session}">测试 ServletAPI 向 session 域共享数据</a>
```

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
    <p th:text="${testRequestScope}" />
    <p th:text="${session.testSessionScope}" />
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 * <p>
 * 3、使用 Model 向 request 域对象共享数据
 * <p>
 * 4、使用 ModelMap 向 request 域对象共享数据
 * <p>
 * 5、使用 map 向 request 域对象共享数据
 * <p>
 * 6、Model 和 ModelMap 和 map 的关系
 * 其实在底层中，这些类型的形参最终都是通过 BindingAwareModelMap 创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 * public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {}
 * public interface Model {}
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model.getClass().getName() = " + model.getClass().getName());

        // 向请求域中共享数据
        model.addAttribute("testRequestScope", "Hello, Model");
        Object testRequestScope = model.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/model/map")
    public String testModelMap(ModelMap modelMap)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("modelMap.getClass().getName() = " + modelMap.getClass().getName());

        // 向请求域中共享数据
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");
        Object testRequestScope = modelMap.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("map.getClass().getName() = " + map.getClass().getName());

        // 向请求域中共享数据
        map.put("testRequestScope", "Hello, map");
        Object testRequestScope = map.get("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session)
    {
        session.setAttribute("testSessionScope", "Hello, Session");
        Object testSessionScope = session.getAttribute("testSessionScope");
        System.out.println("testSessionScope = " + testSessionScope);

        return "success";
    }
}
```

### 5.8、向 application 域共享数据

```html
<h3>3.7、使用 ServletAPI 向 application 域共享数据</h3>
<a th:href="@{/test/application}">测试 map 向 application 域共享数据</a>
```

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
    <p th:text="${testRequestScope}" />
    <p th:text="${session.testSessionScope}" />
    <p th:text="${application.testApplicationScope}" />
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/1
 * @description
 * 向域对象共享数据：
 * 1、使用 ServletAPI 向 request 域对象共享数据
 * <p>
 * 2、使用 ModelAndView 向 request 域对象共享数据
 * 使刚 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要 ModelAndView 作为方法的返回值
 * <p>
 * 3、使用 Model 向 request 域对象共享数据
 * <p>
 * 4、使用 ModelMap 向 request 域对象共享数据
 * <p>
 * 5、使用 map 向 request 域对象共享数据
 * <p>
 * 6、Model 和 ModelMap 和 map 的关系
 * 其实在底层中，这些类型的形参最终都是通过 BindingAwareModelMap 创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 * public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {}
 * public interface Model {}
 */
@Controller
public class TestScopeController
{
    @RequestMapping("/test/servlet/api")
    public String testServletAPI(HttpServletRequest request)
    {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        Object testRequestScope = request.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    /**
     * ModelAndView 包含 Model 和 view 的功能
     * Model：向请求域中共享数据
     * view：设置逻辑视图实现页面跳转
     *
     * @return 模型和视图
     */
    @RequestMapping("/test/model/and/view")
    public ModelAndView testModelAndView()
    {
        ModelAndView modelAndView = new ModelAndView();

        // 向请求域中共享数据
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        // 设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("model.getClass().getName() = " + model.getClass().getName());

        // 向请求域中共享数据
        model.addAttribute("testRequestScope", "Hello, Model");
        Object testRequestScope = model.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/model/map")
    public String testModelMap(ModelMap modelMap)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("modelMap.getClass().getName() = " + modelMap.getClass().getName());

        // 向请求域中共享数据
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");
        Object testRequestScope = modelMap.getAttribute("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map)
    {
        // org.springframework.validation.support.BindingAwareModelMap
        System.out.println("map.getClass().getName() = " + map.getClass().getName());

        // 向请求域中共享数据
        map.put("testRequestScope", "Hello, map");
        Object testRequestScope = map.get("testRequestScope");
        System.out.println("testRequestScope = " + testRequestScope);

        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session)
    {
        session.setAttribute("testSessionScope", "Hello, Session");
        Object testSessionScope = session.getAttribute("testSessionScope");
        System.out.println("testSessionScope = " + testSessionScope);

        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session)
    {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "Hello, Application");
        Object testApplicationScope = servletContext.getAttribute("testApplicationScope");
        System.out.println("testApplicationScope = " + testApplicationScope);

        return "success";
    }
}
```

## 6、SpringMVC 的视图

SpringMVC 中的视图是 View 接口，视图的作用渲染数据，将模型 Model 中的数据展示给用户。

SpringMVC 视图的种类很多，默认有转发视图和重定向视图。

当工程引入 jstl 的依赖，转发视图会自动转换为 JstlView。

若使用的视图技术为 Thymeleaf，在 SpringMVC 的配置文件中配置了 Thymeleaf 的视图解析器，由此视图解析器解析之后所得到的是 ThymeleafView。

### 6.1、ThymeleafView

当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被 SpringMVC 配置文件中所配置的视图解析器解析，视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳转。

```html
<h2>4、SpringMVC 的视图</h2>
<h3>4.1、ThymeleafView</h3>
<a th:href="@{/test/view/thymeleaf}">测试 SpringMVC 的视图 ThymeleafView</a>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 */
@Controller
public class TestViewController
{
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView()
    {
        return "success";
    }
}
```

![ThymeleafView](https://img-blog.csdnimg.cn/bcfb0756e08046cda1798fe2468c91fc.png)

### 6.2、转发视图

SpringMVC 中默认的转发视图是 InternalResourceView。

SpringMVC 中创建转发视图的情况：

当控制器方法中所设置的视图名称以"forward:"为前缀时，创建 InternalResourceView 视图，此时的视图名称不会被 SpringMVC 配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部分作为最终路径通过转发的方式实现跳转。

例如"forward:/"，"forward:/test/model"

```html
<h3>4.2、转发视图</h3>
<a th:href="@{/test/view/forward}"
  >测试 SpringMVC 的视图 InternalResonanceView</a
>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 */
@Controller
public class TestViewController
{
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView()
    {
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResonanceView()
    {
        return "forward:/test/model";
    }
}
```

![转发视图](https://img-blog.csdnimg.cn/befa9cc7c41c432bb769dfcfccea8fc2.png)

### 6.3、重定向视图

SpringMVC 中默认的重定向视图是 RedirectView。

当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建 RedirectView 视图，此时的视图名称不会被 SpringMVC 配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，剩余部分作为最终路径通过重定向的方式实现跳转。

例如"redirect:/"，"redirect:/test/model"

```html
<h3>4.3、重定向视图</h3>
<a th:href="@{/test/view/redirect}">测试 SpringMVC 的视图 RedirectView</a>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MYXH
 * @date 2023/9/1
 */
@Controller
public class TestViewController
{
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView()
    {
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResonanceView()
    {
        return "forward:/test/model";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView()
    {
        return "redirect:/test/model";
    }
}
```

![重定向视图](https://img-blog.csdnimg.cn/81723125682b4800a805654a8138d17d.png)

> 注意：
>
> 重定向视图在解析时，会先将 redirect:前缀去掉，然后会判断剩余部分是否以/开头，若是则会自动拼接上下文路径。

### 6.4、视图控制器 view-controller

当控制器方法中，仅仅用来实现页面跳转，即只需要设置视图名称时，可以将处理器方法使用 view-controller 标签进行表示。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns="http://www.springframework.org/schema/beans"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!-- 扫描控制层组件 -->
    <context:component-scan base-package="com.myxh.springmvc.controller"/>

    <!-- 配置 Thymeleaf 视图解析器 -->
    <bean id="viewResolver" class="org.thymeleaf.spring6.view.ThymeleafViewResolver">
        <property name="order" value="1"/>
        <property name="characterEncoding" value="UTF-8"/>
        <property name="templateEngine">
            <bean class="org.thymeleaf.spring6.SpringTemplateEngine">
                <property name="templateResolver">
                    <bean class="org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver">
                        <!-- 视图前缀 -->
                        <property name="prefix" value="/WEB-INF/templates/"/>

                        <!-- 视图后缀 -->
                        <property name="suffix" value=".html"/>

                        <property name="templateMode" value="HTML"/>
                        <property name="characterEncoding" value="UTF-8"/>
                    </bean>
                </property>
            </bean>
        </property>
    </bean>

    <!-- 开启 mvc 的注解驱动 -->
    <mvc:annotation-driven/>

    <!--
        视图控制器：为当前的请求直接设置视图名称实现页面跳转
        若设置视图控制器，则只有视图控制器所设置的请求会被处理，其他的请求将全部 404
        此时必须在配置一个标签：<mvc:annotation-driven/>
     -->
    <mvc:view-controller path="/" view-name="index"/>
</beans>
```

> 注意：
>
> 当 SpringMVC 中设置任何一个 view-controller 时，其他控制器中的请求映射将全部失效，此时需要在 SpringMVC 的核心配置文件中设置开启 mvc 注解驱动的标签：
>
> \<mvc:annotation-driven\/\>

## 7、RESTful

### 7.1、RESTful 简介

REST：**Re**presentational **S**tate **T**ransfer，表现层资源状态转移。

#### 7.1.1 ① 资源

资源是一种看待服务器的方式，即，将服务器看作是由很多离散的资源组成。每个资源是服务器上一个可命名的抽象概念。因为资源是一个抽象的概念，所以它不仅仅能代表服务器文件系统中的一个文件、数据库中的一张表等等具体的东西，可以将资源设计的要多抽象有多抽象，只要想象力允许而且客户端应用开发者能够理解。与面向对象设计类似，资源是以名词为核心来组织的，首先关注的是名词。一个资源可以由一个或多个 URI 来标识。URI 既是资源的名称，也是资源在 Web 上的地址。对某个资源感兴趣的客户端应用，可以通过资源的 URI 与其进行交互。

#### 7.1.2 ② 资源的表述

资源的表述是一段对于资源在某个特定时刻的状态的描述。可以在客户端-服务器端之间转移（交换）。资源的表述可以有多种格式，例如 HTML/XML/JSON/纯文本/图片/视频/音频等等。资源的表述格式可以通过协商机制来确定。请求-响应方向的表述通常使用不同的格式。

#### 7.1.3 ③ 状态转移

状态转移说的是：在客户端和服务器端之间转移（transfer）代表资源状态的表述。通过转移和操作资源的表述，来间接实现操作资源的目的。

### 7.2、RESTful 的实现

具体说，就是 HTTP 协议里面，四个表示操作方式的动词：GET、POST、PUT、DELETE。

它们分别对应四种基本操作：GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源。

REST 风格提倡 URL 地址使用统一的风格设计，从前到后各个单词使用斜杠分开，不使用问号键值对方式携带请求参数，而是将要发送给服务器的数据作为 URL 地址的一部分，以保证整体风格的一致性。

| **操作** | **传统方式**     | **REST 风格**             |
| -------- | ---------------- | ------------------------- |
| 查询操作 | getUserById?id=1 | user/1 -> GET 请求方式    |
| 保存操作 | saveUser         | user -> POST 请求方式     |
| 删除操作 | deleteUser?id=1  | user/1 -> DELETE 请求方式 |
| 更新操作 | updateUser       | user -> PUT 请求方式      |

### 7.3、HiddenHttpMethodFilter

由于浏览器只支持发送 get 和 post 方式的请求，那么该如何发送 put 和 delete 请求呢？

SpringMVC 提供了 **HiddenHttpMethodFilter** 帮助我们**将 POST 请求转换为 DELETE 或 PUT 请求**。

**HiddenHttpMethodFilter** 处理 put 和 delete 请求的条件：

① 当前请求的请求方式必须为 post

② 当前请求必须传输请求参数 \_method

满足以上条件，**HiddenHttpMethodFilter** 过滤器就会将当前请求的请求方式转换为请求参数 \_method 的值，因此请求参数\_method 的值才是最终的请求方式。

在 web.xml 中注册**HiddenHttpMethodFilter**。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <!-- 配置 Spring 的编码过滤器 -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>

        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 配置处理请求方式的过滤器 -->
    <filter>
        <filter-name>hiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>hiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 设置 SpringMVC 的前端控制器 -->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

> 注意：
>
> 目前为止，SpringMVC 中提供了两个过滤器：CharacterEncodingFilter 和 HiddenHttpMethodFilter。
>
> 在 web.xml 中注册时，必须先注册 CharacterEncodingFilter，再注册 HiddenHttpMethodFilter。
>
> 原因：
>
> - 在 CharacterEncodingFilter 中通过 request.setCharacterEncoding(encoding) 方法设置字符集的怕编码。
>
> - request.setCharacterEncoding(encoding) 方法要求前面不能有任何获取请求参数的操作。
>
> - 而 HiddenHttpMethodFilter 恰恰有一个获取请求方式的操作：
>
> - ```java
>   String paramValue = request.getParameter(this.methodParam);
>   ```

### 7.4、创建页面

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <h1>index.html</h1>

    <h2>1、RESTful</h2>
    <h3>1.1、查询所有的用户信息</h3>
    <a th:href="@{/user}">查询所有的用户信息</a>

    <h3>1.2、根据 id 查询用户信息</h3>
    <form th:action="@{/user/1}">
      <input type="submit" value="查询 id 为 1 的用户信息" />
    </form>

    <h3>1.3、添加用户信息</h3>
    <form th:action="@{/user}" method="post">
      <input type="submit" value="添加用户信息" />
    </form>

    <h3>1.4、修改用户信息</h3>
    <form th:action="@{/user}" method="post">
      <input type="hidden" name="_method" value="put" />
      <input type="submit" value="修改用户信息" />
    </form>

    <h3>1.5、根据 id 删除用户信息</h3>
    <form th:action="@{/user/1}" method="post">
      <input type="hidden" name="_method" value="delete" />
      <input type="submit" value="删除 id 为 1 的用户信息" />
    </form>
  </body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
  </body>
</html>
```

### 7.5、创建控制器

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description
 * 查询所有的用户信息：/user -> GET
 * 根据 id 查询用户信息：/user/1 -> GET
 * 添加用户信息：/user -> POST
 * 修改用户信息：/user -> PUT
 * 根据 id 删除用户信息：/user/1 -> DELETE
 * <p>
 * 注意：浏览器目前只能发送 get 和 post 请求
 * 若要发送 put 和 delete 请求，需要在 web.xml 中配置一个过滤器 HiddenHttpMethodFilter
 * 配置了过滤器之后，发送的请求要满足两个件，才能将请求方式转换为 put 或 delete
 * 1、当前请求必须为 post
 * 2、当前请求必须传输请求参数 method，method 的值才是最终的请求方式
 */
@Controller
public class TestRestController
{
    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser()
    {
        System.out.println("查询所有的用户信息：/user -> GET");

        return "success";
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id)
    {
        System.out.println("根据 id 查询用户信息：/user/" + id + "-> GET");

        return "success";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser()
    {
        System.out.println("添加用户信息：/user -> POST");

        return "success";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser()
    {
        System.out.println("修改用户信息：/user -> PUT");

        return "success";
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id)
    {
        System.out.println("根据 id 删除用户信息：/user/" + id + "-> DELETE");

        return "success";
    }
}
```

## 8、RESTful 案例

### 8.1、准备工作

和传统 CRUD 一样，实现对员工信息的增删改查。

- 搭建环境。

- 准备实体类。

```java
package com.myxh.springmvc.pojo;

/**
 * @author MYXH
 * @date 2023/9/2
 */
public class Employee
{
    private Integer employeeId;
    private String employeeName;
    private Integer age;
    private String gender;
    private String email;

    public Employee()
    {

    }

    public Employee(Integer employeeId, String employeeName, Integer age, String gender, String email)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Integer getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
```

- 准备 DAO 模拟数据。

```java
package com.myxh.springmvc.dao;

import com.myxh.springmvc.pojo.Employee;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 */
public interface EmployeeDao
{
    void save(Employee employee);

    Collection<Employee> getAll();

    Employee get(Integer id);

    void delete(Integer id);
}
```

```java
package com.myxh.springmvc.dao.impl;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/2
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
    private static final Map<Integer, Employee> employees;

    static
    {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "MYXH", 21, "男", "1735350920@qq.com"));
        employees.put(2, new Employee(2, "张三", 20, "男", "zhangsan@qq.com"));
        employees.put(3, new Employee(3, "李四", 22, "男", "lisi@qq.com"));
        employees.put(4, new Employee(4, "王五", 23, "男", "wangwu@qq.com"));
        employees.put(5, new Employee(5, "赵六", 24, "男", "zhaoliu@qq.com"));
    }

    private static Integer initId = 6;

    public void save(Employee employee)
    {
        if (employee.getEmployeeId() == null)
        {
            employee.setEmployeeId(initId++);
        }
        employees.put(employee.getEmployeeId(), employee);
    }

    public Collection<Employee> getAll()
    {
        return employees.values();
    }

    public Employee get(Integer id)
    {
        return employees.get(id);
    }

    public void delete(Integer id)
    {
        employees.remove(id);
    }
}
```

### 8.2、功能清单

| **功能**             | **URL** **地址** | **请求方式** |
| -------------------- | ---------------- | ------------ |
| 访问首页 √           | /                | GET          |
| 查询全部数据 √       | /employee        | GET          |
| 删除 √               | /employee/1      | DELETE       |
| 跳转到添加数据页面 √ | /to/add          | GET          |
| 执行保存 √           | /employee        | POST         |
| 跳转到更新数据页面 √ | /employee/1      | GET          |
| 执行更新 √           | /employee        | PUT          |

### 8.3、具体功能：访问首页

#### 8.3.1 ① 配置 view-controller

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>

<!-- 配置视图控制器 -->
<mvc:view-controller path="/" view-name="index"/>
```

#### 8.3.2 ② 配置 default-servlet-handler

```xml
<!--
    配置默认的 servlet 处理静态资源

    当前工程的 web.xml 配置的前端控制器 DispatcherServlet 的 url-pattern 是 /
    tomcat 的 web.xml 配置的 DefaultServlet 的 url-pattern 也是 /
    此时，浏览器发送的请求会优先被 DispatcherServlet 进行处理，但是 DispatcherServlet 无法处理静态资源
    若配置了 <mvc:default-servlet-handler/>，此时浏览器发送的所有请求都会被 DefaultServlet 处理
    若配置了 <mvc:default-servlet-handler/> 和 <mvc:annotation-driven/>
    浏览器发送的请求会先被 DispatcherServlet 处理，无法处理在交给 DefaultServlet 处理
    -->
<mvc:default-servlet-handler/>
```

#### 8.3.3 ③ 创建页面

```html
<h2>2、RESTful 案例</h2>
<h3>2.1、查询所有的员工信息</h3>
<a th:href="@{/employee}">查询所有的员工信息</a>
```

### 8.4、具体功能：查询所有员工数据

#### 8.4.1 ① 控制器方法

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description
 * 查询所有的员工信息：/employee -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);

        // 跳转到列表页面
        return "employee_list";
    }
}
```

#### 8.4.2 ② 创建 employee_list.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <table>
      <tr>
        <th colspan="6">员工列表</th>
      </tr>

      <tr>
        <th>员工 id</th>
        <th>员工姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>电子邮件</th>
        <th>选项（<a th:href="@{/to/add}">添加</a>）</th>
      </tr>

      <tr th:each="employee : ${allEmployee}">
        <td th:text="${employee.employeeId}"></td>
        <td th:text="${employee.employeeName}"></td>
        <td th:text="${employee.age}"></td>
        <td th:text="${employee.gender}"></td>
        <td th:text="${employee.email}"></td>

        <td>
          <a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
        </td>
      </tr>
    </table>
  </body>
</html>
```

### 8.5、具体功能：删除

#### 8.5.1 ① 创建处理 delete 请求方式的表单

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <table>
      <tr>
        <th colspan="6">员工列表</th>
      </tr>

      <tr>
        <th>员工 id</th>
        <th>员工姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>电子邮件</th>
        <th>选项（<a th:href="@{/to/add}">添加</a>）</th>
      </tr>

      <tr th:each="employee : ${allEmployee}">
        <td th:text="${employee.employeeId}"></td>
        <td th:text="${employee.employeeName}"></td>
        <td th:text="${employee.age}"></td>
        <td th:text="${employee.gender}"></td>
        <td th:text="${employee.email}"></td>

        <td>
          <a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
        </td>
      </tr>
    </table>

    <form method="post">
      <input type="hidden" name="_method" value="delete" />
    </form>
  </body>
</html>
```

#### 8.5.2 ② 删除超链接绑定点击事件

引入 vue.js。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <table>
      <tr>
        <th colspan="6">员工列表</th>
      </tr>

      <tr>
        <th>员工 id</th>
        <th>员工姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>电子邮件</th>
        <th>选项（<a th:href="@{/to/add}">添加</a>）</th>
      </tr>

      <tr th:each="employee : ${allEmployee}">
        <td th:text="${employee.employeeId}"></td>
        <td th:text="${employee.employeeName}"></td>
        <td th:text="${employee.age}"></td>
        <td th:text="${employee.gender}"></td>
        <td th:text="${employee.email}"></td>

        <td>
          <a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
        </td>
      </tr>
    </table>

    <form method="post">
      <input type="hidden" name="_method" value="delete" />
    </form>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
  </body>
</html>
```

删除超链接。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <table>
      <tr>
        <th colspan="6">员工列表</th>
      </tr>

      <tr>
        <th>员工 id</th>
        <th>员工姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>电子邮件</th>
        <th>选项（<a th:href="@{/to/add}">添加</a>）</th>
      </tr>

      <tr th:each="employee : ${allEmployee}">
        <td th:text="${employee.employeeId}"></td>
        <td th:text="${employee.employeeName}"></td>
        <td th:text="${employee.age}"></td>
        <td th:text="${employee.gender}"></td>
        <td th:text="${employee.email}"></td>

        <td>
          <a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
          <a
            @click="deleteEmployee"
            th:href="@{|/employee/${employee.employeeId}|}"
            >删除</a
          >
        </td>
      </tr>
    </table>

    <form method="post">
      <input type="hidden" name="_method" value="delete" />
    </form>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
  </body>
</html>
```

通过 vue 处理点击事件。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <div id="app">
      <table>
        <tr>
          <th colspan="6">员工列表</th>
        </tr>

        <tr>
          <th>员工 id</th>
          <th>员工姓名</th>
          <th>年龄</th>
          <th>性别</th>
          <th>电子邮件</th>
          <th>选项（<a th:href="@{/to/add}">添加</a>）</th>
        </tr>

        <tr th:each="employee : ${allEmployee}">
          <td th:text="${employee.employeeId}"></td>
          <td th:text="${employee.employeeName}"></td>
          <td th:text="${employee.age}"></td>
          <td th:text="${employee.gender}"></td>
          <td th:text="${employee.email}"></td>

          <td>
            <a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
            <a
              @click="deleteEmployee"
              th:href="@{|/employee/${employee.employeeId}|}"
              >删除</a
            >
          </td>
        </tr>
      </table>

      <form method="post">
        <input type="hidden" name="_method" value="delete" />
      </form>
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>

    <script type="text/javascript">
      let vue = new Vue({
        el: "#app",

        methods: {
          deleteEmployee() {
            // 获取 form 表单
            let form = document.getElementsByTagName("form")[0];

            // 将超链接的 href 属性值赋值给 form 表单的 action 属性
            // event.target 表示当前触发事件的标签
            form.action = event.target.href;

            // 表单提交
            form.submit();

            // 阻止超链接的默认行为
            event.preventDefault();
          },
        },
      });
    </script>
  </body>
</html>
```

#### 8.5.3 ③ 控制器方法

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description 查询所有的员工信息：/employee -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 删除员工信息
        employeeDao.delete(employeeId);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }
}
```

### 8.6、具体功能：跳转到添加数据页面

#### 8.6.1 ① 配置 view-controller

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>

<!-- 配置视图控制器 -->
<mvc:view-controller path="/" view-name="index"/>
<mvc:view-controller path="/to/add" view-name="employee_add"/>
```

#### 8.6.2 ② 创建 employee_add.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>添加员工</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <form th:action="@{/employee}" method="post">
      <table>
        <tr>
          <th colspan="2">添加员工</th>
        </tr>

        <tr>
          <td>员工姓名</td>
          <td>
            <label>
              <input type="text" name="employeeName" />
            </label>
          </td>
        </tr>

        <tr>
          <td>年龄</td>
          <td>
            <label>
              <input type="text" name="age" />
            </label>
          </td>
        </tr>

        <tr>
          <td>性别</td>
          <td>
            <label>
              <input type="radio" name="gender" value="男" />
              男
            </label>
            <label>
              <input type="radio" name="gender" value="女" />
              女
            </label>
          </td>
        </tr>

        <tr>
          <td>电子邮件</td>
          <td>
            <label>
              <input type="text" name="email" />
            </label>
          </td>
        </tr>

        <tr>
          <td colspan="2">
            <input type="submit" value="添加" />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
```

### 8.7、具体功能：执行保存

#### 8.7.1 ① 控制器方法

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description 查询所有的员工信息：/employee -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee)
    {
        // 保存员工信息
        employeeDao.save(employee);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 删除员工信息
        employeeDao.delete(employeeId);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }
}
```

### 8.8、具体功能：跳转到更新数据页面

#### 8.8.1 ① 修改超链接

```html
<a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
```

#### 8.8.2 ② 控制器方法

```java

package com.myxh.springmvc.controller;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description 查询所有的员工信息：/employee -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee)
    {
        // 保存员工信息
        employeeDao.save(employee);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.GET)
    public String toUpdate(Model model,@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 查询员工信息
        Employee employee = employeeDao.get(employeeId);

        // 将员工信息在请求域中共享
        model.addAttribute("employee", employee);

        // 跳转到修改页面
        return "employee_update";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 删除员工信息
        employeeDao.delete(employeeId);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }
}
```

#### 8.8.3 ③ 创建 employee_update.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>修改员工</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <form th:action="@{/employee}" method="post">
      <input type="hidden" name="_method" value="put" />
      <input
        type="hidden"
        name="employeeId"
        th:value="${employee.employeeId}"
      />

      <table>
        <tr>
          <th colspan="2">修改员工</th>
        </tr>

        <tr>
          <td>员工姓名</td>
          <td>
            <label>
              <input
                type="text"
                name="employeeName"
                th:value="${employee.employeeName}"
              />
            </label>
          </td>
        </tr>

        <tr>
          <td>年龄</td>
          <td>
            <label>
              <input type="text" name="age" th:value="${employee.age}" />
            </label>
          </td>
        </tr>

        <tr>
          <td>性别</td>
          <td>
            <label>
              <input
                type="radio"
                name="gender"
                value="男"
                th:field="${employee.gender}"
              />
              男
            </label>
            <label>
              <input
                type="radio"
                name="gender"
                value="女"
                th:field="${employee.gender}"
              />
              女
            </label>
          </td>
        </tr>

        <tr>
          <td>电子邮件</td>
          <td>
            <label>
              <input type="text" name="email" th:value="${employee.email}" />
            </label>
          </td>
        </tr>

        <tr>
          <td colspan="2">
            <input type="submit" value="修改" />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
```

### 8.9、具体功能：执行更新

#### 8.9.1 ① 控制器方法

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.dao.EmployeeDao;
import com.myxh.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author MYXH
 * @date 2023/9/2
 * @description 查询所有的员工信息：/employee -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee)
    {
        // 保存员工信息
        employeeDao.save(employee);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.GET)
    public String toUpdate(Model model,@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 查询员工信息
        Employee employee = employeeDao.get(employeeId);

        // 将员工信息在请求域中共享
        model.addAttribute("employee", employee);

        // 跳转到修改页面
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee)
    {
        // 修改员工信息
        employeeDao.save(employee);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId)
    {
        // 根据 id 删除员工信息
        employeeDao.delete(employeeId);

        // 重定向到列表功能：/employee
        return "redirect:/employee";
    }
}
```

## 9、SpringMVC 处理 ajax 请求

### 9.1、@RequestBody

@RequestBody 可以获取请求体信息，使用@RequestBody 注解标识控制器方法的形参，当前请求的请求体就会为当前注解所标识的形参赋值。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <div id="app">
      <h1>index.html</h1>

      <h2>1、SpringMVC 处理 ajax 请求</h2>
      <h3>1.1、SpringMVC 处理 ajax 请求</h3>
      <input
        type="button"
        value="测试 SpringMVC 处理 ajax 请求"
        @click="testAjax"
      />
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
    <script type="text/javascript" th:src="@{/static/js/axios.js}"></script>

    <script type="text/javascript">
      /**
       *     axios({
       *         // 请求路径
       *         url:"",
       *
       *         // 请求方式
       *         method:"",
       *
       *         // 以 name=value&name=value 的方式发送的请求参数
       *         // 不管使用的请方式是 get 或 post，请参数都会被拼接到请求地址后
       *         // 此种方式的请求参数可以通过 request.getParameter() 获取
       *         params:{},
       *
       *         // 以 json 格式发送的请求参数
       *         // 请求参数会被保存到请求报文的请求体传输到服务器
       *         // 此种方式的请求参数可以不通过 request.getParameter() 获取
       *         data:{}
       *     }).then(response=>{
       *         console.log(response.data);
       *     });
       */
      let vue = new Vue({
        el: "#app",

        methods: {
          testAjax() {
            axios
              .post("/spring_mvc_ajax/test/ajax?id=1", {
                username: "MYXH",
                password: "520.ILY!",
              })
              .then((response) => {
                console.log(response.data);
              });
          },
        },
      });
    </script>
  </body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>成功</title>
  </head>

  <body>
    <h1>success.html</h1>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 */
@Controller
public class TestAjaxController
{
    @RequestMapping("/test/ajax")
    public void testAjax(@RequestBody String requestBody, HttpServletResponse response, Integer id) throws IOException
    {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("Hello, axios");
    }
}
```

> 输出结果：
>
> requestBody = {"username":"MYXH","password":"520.ILY!"}
> id = 1

### 9.2、@RequestBody 获取 json 格式的请求参数

> 在使用了 axios 发送 ajax 请求之后，浏览器发送到服务器的请求参数有两种格式：
>
> 1、name=value&name=value ...，此时的请求参数可以通过 request.getParameter() 获取，对应 SpringMVC 中，可以直接通过控制器方法的形参获取此类请求参数。
>
> 2、{key:value,key:value, ...}，此时无法通过 request.getParameter()获取，之前我们使用操作 json 的相关 jar 包 gson 或 jackson 处理此类请求参数，可以将其转换为指定的实体类对象或 map 集合。在 SpringMVC 中，直接使用 @RequestBody 注解标识控制器方法的形参即可将此类请求参数转换为 Java 对象。

使用@RequestBody 获取 json 格式的请求参数的条件：

1、导入 jackson 的依赖。

```xml
<!-- jackson -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.1</version>
</dependency>
```

2、SpringMVC 的配置文件中设置开启 mvc 的注解驱动。

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>
```

3、在控制器方法的形参位置，设置 json 格式的请求参数要转换成的 Java 类型（实体类或 map）的参数，并使用 @RequestBody 注解标识。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <div id="app">
      <h1>index.html</h1>

      <h2>1、SpringMVC 处理 ajax 请求</h2>
      <h3>1.1、SpringMVC 处理 ajax 请求</h3>
      <input
        type="button"
        value="测试 SpringMVC 处理 ajax 请求"
        @click="testAjax"
      />

      <h3>1.2、@RequestBody 获取 json 格式的请求参数</h3>
      <input
        type="button"
        value="测试 @RequestBody 注解处理 json 格式的请求参数"
        @click="testRequestBody"
      />
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
    <script type="text/javascript" th:src="@{/static/js/axios.js}"></script>

    <script type="text/javascript">
      /**
       *     axios({
       *         // 请求路径
       *         url:"",
       *
       *         // 请求方式
       *         method:"",
       *
       *         // 以 name=value&name=value 的方式发送的请求参数
       *         // 不管使用的请方式是 get 或 post，请参数都会被拼接到请求地址后
       *         // 此种方式的请求参数可以通过 request.getParameter() 获取
       *         params:{},
       *
       *         // 以 json 格式发送的请求参数
       *         // 请求参数会被保存到请求报文的请求体传输到服务器
       *         // 此种方式的请求参数可以不通过 request.getParameter() 获取
       *         data:{}
       *     }).then(response=>{
       *         console.log(response.data);
       *     });
       */
      let vue = new Vue({
        el: "#app",

        methods: {
          testAjax() {
            axios
              .post("/spring_mvc_ajax/test/ajax?id=1", {
                username: "MYXH",
                password: "520.ILY!",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testRequestBody() {
            axios
              .post("/spring_mvc_ajax/test/requestBody/json", {
                id: "1",
                username: "MYXH",
                password: "520.ILY!",
                age: "21",
                gender: "男",
                email: "1735350920@qq.com",
              })
              .then((response) => {
                console.log(response.data);
              });
          },
        },
      });
    </script>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用 @RequestBody 注解将 json 格式的请求参数转换为 Java 对象
 * ① 导入 jackson 的依赖
 * ② 在 SpringMVC 的配置文件中设置 <mvc:annotation-driven/>
 * ③ 在处理请求的控制器方法的形参位置，直接设置 json 格式的请求参数要转换的 Java 类型的形参，使用 @RequestBody 注解标识即可
 */
@Controller
public class TestAjaxController
{
    @RequestMapping("/test/ajax")
    public void testAjax(@RequestBody String requestBody, HttpServletResponse response, Integer id) throws IOException
    {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("Hello, axios");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException
    {
        System.out.println("user = " + user);
        response.getWriter().write("Hello, requestBody");
    }

    // @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException
    {
        System.out.println("map = " + map);
        response.getWriter().write("Hello, requestBody");
    }
}
```

### 9.3、@ResponseBody

@ResponseBody 用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <div id="app">
      <h1>index.html</h1>

      <h2>1、SpringMVC 处理 ajax 请求</h2>
      <h3>1.1、SpringMVC 处理 ajax 请求</h3>
      <input
        type="button"
        value="测试 SpringMVC 处理 ajax 请求"
        @click="testAjax"
      />

      <h3>1.2、@RequestBody 获取 json 格式的请求参数</h3>
      <input
        type="button"
        value="测试 @RequestBody 注解处理 json 格式的请求参数"
        @click="testRequestBody"
      />

      <h3>1.3、@ResponseBody 响应浏览器数据</h3>
      <a th:href="@{/test/responseBody}"
        >测试 @ResponseBody 注解响应浏览器数据</a
      >
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
    <script type="text/javascript" th:src="@{/static/js/axios.js}"></script>

    <script type="text/javascript">
      /**
       *     axios({
       *         // 请求路径
       *         url:"",
       *
       *         // 请求方式
       *         method:"",
       *
       *         // 以 name=value&name=value 的方式发送的请求参数
       *         // 不管使用的请方式是 get 或 post，请参数都会被拼接到请求地址后
       *         // 此种方式的请求参数可以通过 request.getParameter() 获取
       *         params:{},
       *
       *         // 以 json 格式发送的请求参数
       *         // 请求参数会被保存到请求报文的请求体传输到服务器
       *         // 此种方式的请求参数可以不通过 request.getParameter() 获取
       *         data:{}
       *     }).then(response=>{
       *         console.log(response.data);
       *     });
       */
      let vue = new Vue({
        el: "#app",

        methods: {
          testAjax() {
            axios
              .post("/spring_mvc_ajax/test/ajax?id=1", {
                username: "MYXH",
                password: "520.ILY!",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testRequestBody() {
            axios
              .post("/spring_mvc_ajax/test/requestBody/json", {
                id: "1",
                username: "MYXH",
                password: "520.ILY!",
                age: "21",
                gender: "男",
                email: "1735350920@qq.com",
              })
              .then((response) => {
                console.log(response.data);
              });
          },
        },
      });
    </script>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用 @RequestBody 注解将 json 格式的请求参数转换为 Java 对象
 * ① 导入 jackson 的依赖
 * ② 在 SpringMVC 的配置文件中设置 <mvc:annotation-driven/>
 * ③ 在处理请求的控制器方法的形参位置，直接设置 json 格式的请求参数要转换的 Java 类型的形参，使用 @RequestBody 注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 */
@Controller
public class TestAjaxController
{
    @RequestMapping("/test/ajax")
    public void testAjax(@RequestBody String requestBody, HttpServletResponse response, Integer id) throws IOException
    {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("Hello, axios");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException
    {
        System.out.println("user = " + user);
        response.getWriter().write("Hello, requestBody");
    }

    // @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException
    {
        System.out.println("map = " + map);
        response.getWriter().write("Hello, requestBody");
    }

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody()
    {
        return "Hello, responseBody";
    }
}
```

### 9.4、@ResponseBody 响应浏览器 json 数据

服务器处理 ajax 请求之后，大多数情况都需要向浏览器响应一个 Java 对象，此时必须将 Java 对象转换为 json 字符串才可以响应到浏览器，之前我们使用操作 json 数据的 jar 包 gson 或 jackson 将 java 对象转换为 json 字符串。在 SpringMVC 中，我们可以直接使用@ResponseBody 注解实现此功能。

@ResponseBody 响应浏览器 json 数据的条件：

1、导入 jackson 的依赖。

```xml
<!-- jackson -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.1</version>
</dependency>
```

2、SpringMVC 的配置文件中设置开启 mvc 的注解驱动。

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>
```

3、使用@ResponseBody 注解标识控制器方法，在方法中，将需要转换为 json 字符串并响应到浏览器的 Java 对象作为控制器方法的返回值，此时 SpringMVC 就可以将此对象直接转换为 json 字符串并响应到浏览器。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <div id="app">
      <h1>index.html</h1>

      <h2>1、SpringMVC 处理 ajax 请求</h2>
      <h3>1.1、SpringMVC 处理 ajax 请求</h3>
      <input
        type="button"
        value="测试 SpringMVC 处理 ajax 请求"
        @click="testAjax"
      />

      <h3>1.2、@RequestBody 获取 json 格式的请求参数</h3>
      <input
        type="button"
        value="测试 @RequestBody 注解处理 json 格式的请求参数"
        @click="testRequestBody"
      />

      <h3>1.3、@ResponseBody 响应浏览器数据</h3>
      <a th:href="@{/test/responseBody}"
        >测试 @ResponseBody 注解响应浏览器数据</a
      >

      <h3>1.4、@ResponseBody 响应浏览器 json 数据</h3>
      <input
        type="button"
        value="测试 @ResponseBody 注解响应浏览器 json 数据"
        @click="testResponseBody"
      />
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
    <script type="text/javascript" th:src="@{/static/js/axios.js}"></script>

    <script type="text/javascript">
      /**
       *     axios({
       *         // 请求路径
       *         url:"",
       *
       *         // 请求方式
       *         method:"",
       *
       *         // 以 name=value&name=value 的方式发送的请求参数
       *         // 不管使用的请方式是 get 或 post，请参数都会被拼接到请求地址后
       *         // 此种方式的请求参数可以通过 request.getParameter() 获取
       *         params:{},
       *
       *         // 以 json 格式发送的请求参数
       *         // 请求参数会被保存到请求报文的请求体传输到服务器
       *         // 此种方式的请求参数可以不通过 request.getParameter() 获取
       *         data:{}
       *     }).then(response=>{
       *         console.log(response.data);
       *     });
       */
      let vue = new Vue({
        el: "#app",

        methods: {
          testAjax() {
            axios
              .post("/spring_mvc_ajax/test/ajax?id=1", {
                username: "MYXH",
                password: "520.ILY!",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testRequestBody() {
            axios
              .post("/spring_mvc_ajax/test/requestBody/json", {
                id: "1",
                username: "MYXH",
                password: "520.ILY!",
                age: "21",
                gender: "男",
                email: "1735350920@qq.com",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testResponseBody() {
            axios
              .post("/spring_mvc_ajax/test/responseBody/json")
              .then((response) => {
                console.log(response.data);
              });
          },
        },
      });
    </script>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import com.myxh.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用 @RequestBody 注解将 json 格式的请求参数转换为 Java 对象
 * ① 导入 jackson 的依赖
 * ② 在 SpringMVC 的配置文件中设置 <mvc:annotation-driven/>
 * ③ 在处理请求的控制器方法的形参位置，直接设置 json 格式的请求参数要转换的 Java 类型的形参，使用 @RequestBody 注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用 @ResponseBody 注解响应浏览器 json 格式的数据
 * ① 导入 jackson 的依赖
 * ② 在 SpringMVC 的配置文件中设置 <mvc:annotation-driven/>
 * ③ 将需要转换为 json 字符串的 Java 对象直接作为控制器方法的返回值，使用 @ResponseBody 注解标识控制器方法
 * 就可以将 Java 对象直接转换为 json 字符串，并响应到浏览器
 * <p>
 * 常用的 Java 对象转换为 json 的结果：
 * 实体类 -> json 对象
 * Map -> json 对象
 * List -> json 数组
 */
@Controller
// @RestController 相当于 @Controller + @ResponseBody
// @RestController
public class TestAjaxController
{
    @RequestMapping("/test/ajax")
    public void testAjax(@RequestBody String requestBody, HttpServletResponse response, Integer id) throws IOException
    {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("Hello, axios");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException
    {
        System.out.println("user = " + user);
        response.getWriter().write("Hello, requestBody");
    }

    // @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException
    {
        System.out.println("map = " + map);
        response.getWriter().write("Hello, requestBody");
    }

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody()
    {
        return "Hello, responseBody";
    }

    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public User testResponseBodyJson()
    {
        User user = new User(1, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");

        return user;
    }

    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson()
    {
        User user1 = new User(1, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");
        User user2 = new User(2, "root", "000000", 21, "男", "root@qq.com");
        User user3 = new User(3, "admin", "123456", 21, "男", "admin@qq.com");
        User user4 = new User(4, "test", "test", 18, "男", "test@qq.com");
        List<User> list = Arrays.asList(user1, user2, user3, user4);

        return list;
    }

    @RequestMapping("/test/responseBody/json")
    @ResponseBody
    public Map<String , Object> testResponseBodyJson()
    {
        User user1 = new User(1, "MYXH", "520.ILY!", 21, "男", "1735350920@qq.com");
        User user2 = new User(2, "root", "000000", 21, "男", "root@qq.com");
        User user3 = new User(3, "admin", "123456", 21, "男", "admin@qq.com");
        User user4 = new User(4, "test", "test", 18, "男", "test@qq.com");
        Map<String, Object> map = new HashMap<>();
        map.put("1", user1);
        map.put("2", user2);
        map.put("3", user3);
        map.put("4", user4);

        return map;
    }
}
```

### 9.5、@RestController 注解

@RestController 注解是 springMVC 提供的一个复合注解，标识在控制器的类上，就相当于为类添加了 @Controller 注解，并且为其中的每个方法添加了@ResponseBody 注解。

## 10、文件上传和下载

### 10.1、文件下载

ResponseEntity 用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文。

使用 ResponseEntity 实现下载文件的功能。

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <div id="app">
      <h1>index.html</h1>

      <h2>1、SpringMVC 处理 ajax 请求</h2>
      <h3>1.1、SpringMVC 处理 ajax 请求</h3>
      <input
        type="button"
        value="测试 SpringMVC 处理 ajax 请求"
        @click="testAjax"
      />

      <h3>1.2、@RequestBody 获取 json 格式的请求参数</h3>
      <input
        type="button"
        value="测试 @RequestBody 注解处理 json 格式的请求参数"
        @click="testRequestBody"
      />

      <h3>1.3、@ResponseBody 响应浏览器数据</h3>
      <a th:href="@{/test/responseBody}"
        >测试 @ResponseBody 注解响应浏览器数据</a
      >

      <h3>1.4、@ResponseBody 响应浏览器 json 数据</h3>
      <input
        type="button"
        value="测试 @ResponseBody 注解响应浏览器 json 数据"
        @click="testResponseBody"
      />

      <hr />

      <h2>2、文件上传和下载</h2>
      <h3>2.1、下载图片</h3>
      <a th:href="@{/test/download}">下载图片</a>
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
    <script type="text/javascript" th:src="@{/static/js/axios.js}"></script>

    <script type="text/javascript">
      /**
       *     axios({
       *         // 请求路径
       *         url:"",
       *
       *         // 请求方式
       *         method:"",
       *
       *         // 以 name=value&name=value 的方式发送的请求参数
       *         // 不管使用的请方式是 get 或 post，请参数都会被拼接到请求地址后
       *         // 此种方式的请求参数可以通过 request.getParameter() 获取
       *         params:{},
       *
       *         // 以 json 格式发送的请求参数
       *         // 请求参数会被保存到请求报文的请求体传输到服务器
       *         // 此种方式的请求参数可以不通过 request.getParameter() 获取
       *         data:{}
       *     }).then(response=>{
       *         console.log(response.data);
       *     });
       */
      let vue = new Vue({
        el: "#app",

        methods: {
          testAjax() {
            axios
              .post("/spring_mvc_ajax/test/ajax?id=1", {
                username: "MYXH",
                password: "520.ILY!",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testRequestBody() {
            axios
              .post("/spring_mvc_ajax/test/requestBody/json", {
                id: "1",
                username: "MYXH",
                password: "520.ILY!",
                age: "21",
                gender: "男",
                email: "1735350920@qq.com",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testResponseBody() {
            axios
              .post("/spring_mvc_ajax/test/responseBody/json")
              .then((response) => {
                console.log(response.data);
              });
          },
        },
      });
    </script>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * ResponseEntity：可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
 * <p>
 * 文件上传的要求：
 * 1、form 表单的请求方式必须为 post
 * 2、form 表单必须设置属性 enctype="multipart/form-data"
 */
@Controller
public class FileUploadAndDownloadController
{
    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException
    {
        // 获取 ServletContext 对象
        ServletContext servletContext = session.getServletContext();

        // 获取服务器中文件的真实路径
        // String realPath = servletContext.getRealPath("/static/img/大户爱.png");
        String realPath = servletContext.getRealPath(File.separator + "static" + File.separator + "img" + File.separator + "大户爱.png");

        // 创建输入流
        InputStream inputStream = new FileInputStream(realPath);

        // 创建字节数组，is.available() 获取输入流所对应文件的字节数
        byte[] bytes = new byte[inputStream.available()];

        // 将流读到字节数组中
        inputStream.read(bytes);

        // 创建 HttpHeaders 对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();

        // 对文件名进行 URL 编码
        String filename = "大户爱.png";
        String encodedFileName = URLEncoder.encode(filename, StandardCharsets.UTF_8);

        // 设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);

        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;

        // 创建 ResponseEntity 对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        // 关闭输入流
        inputStream.close();

        return responseEntity;
    }
}
```

### 10.2、文件上传

文件上传要求 form 表单的请求方式必须为 post，并且添加属性 enctype="multipart/form-data"。

SpringMVC 中将上传的文件封装到 MultipartFile 对象中，通过此对象可以获取文件相关信息。

上传步骤：

#### 10.2.1 ① 在 SpringMVC 的配置文件中添加配置：

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>

<!-- 配置文件上传解析器 -->
<!-- 配置 StandardServletMultipartResolver 为 MultipartResolver -->
<!-- 该类实现了 Servlet3.0 规范的文件上传支持 -->
<bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver"/>
```

#### 10.2.2 ② 创建页面：

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <div id="app">
      <h1>index.html</h1>

      <h2>1、SpringMVC 处理 ajax 请求</h2>
      <h3>1.1、SpringMVC 处理 ajax 请求</h3>
      <input
        type="button"
        value="测试 SpringMVC 处理 ajax 请求"
        @click="testAjax"
      />

      <h3>1.2、@RequestBody 获取 json 格式的请求参数</h3>
      <input
        type="button"
        value="测试 @RequestBody 注解处理 json 格式的请求参数"
        @click="testRequestBody"
      />

      <h3>1.3、@ResponseBody 响应浏览器数据</h3>
      <a th:href="@{/test/responseBody}"
        >测试 @ResponseBody 注解响应浏览器数据</a
      >

      <h3>1.4、@ResponseBody 响应浏览器 json 数据</h3>
      <input
        type="button"
        value="测试 @ResponseBody 注解响应浏览器 json 数据"
        @click="testResponseBody"
      />

      <hr />

      <h2>2、文件上传和下载</h2>
      <h3>2.1、下载图片</h3>
      <a th:href="@{/test/download}">下载图片</a>

      <h2>2.2、上传图片</h2>
      <form
        th:action="@{/test/upload}"
        method="post"
        enctype="multipart/form-data"
      >
        头像<input
          type="file"
          id="picture"
          name="picture"
          required
          accept="image/*"
        /><br />
        <input type="submit" value="上传" />
      </form>
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>
    <script type="text/javascript" th:src="@{/static/js/axios.js}"></script>

    <script type="text/javascript">
      /**
       *     axios({
       *         // 请求路径
       *         url:"",
       *
       *         // 请求方式
       *         method:"",
       *
       *         // 以 name=value&name=value 的方式发送的请求参数
       *         // 不管使用的请方式是 get 或 post，请参数都会被拼接到请求地址后
       *         // 此种方式的请求参数可以通过 request.getParameter() 获取
       *         params:{},
       *
       *         // 以 json 格式发送的请求参数
       *         // 请求参数会被保存到请求报文的请求体传输到服务器
       *         // 此种方式的请求参数可以不通过 request.getParameter() 获取
       *         data:{}
       *     }).then(response=>{
       *         console.log(response.data);
       *     });
       */
      let vue = new Vue({
        el: "#app",

        methods: {
          testAjax() {
            axios
              .post("/spring_mvc_ajax/test/ajax?id=1", {
                username: "MYXH",
                password: "520.ILY!",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testRequestBody() {
            axios
              .post("/spring_mvc_ajax/test/requestBody/json", {
                id: "1",
                username: "MYXH",
                password: "520.ILY!",
                age: "21",
                gender: "男",
                email: "1735350920@qq.com",
              })
              .then((response) => {
                console.log(response.data);
              });
          },

          testResponseBody() {
            axios
              .post("/spring_mvc_ajax/test/responseBody/json")
              .then((response) => {
                console.log(response.data);
              });
          },
        },
      });
    </script>
  </body>
</html>
```

#### 10.2.3 ③ 控制器方法：

```java
package com.myxh.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * ResponseEntity：可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
 * <p>
 * 文件上传的要求：
 * 1、form 表单的请求方式必须为 post
 * 2、form 表单必须设置属性 enctype="multipart/form-data"
 */
@Controller
public class FileUploadAndDownloadController
{
    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException
    {
        // 获取 ServletContext 对象
        ServletContext servletContext = session.getServletContext();

        // 获取服务器中文件的真实路径
        // String realPath = servletContext.getRealPath("/static/img/大户爱.png");
        String realPath = servletContext.getRealPath(File.separator + "static" + File.separator + "img" + File.separator + "大户爱.png");

        // 创建输入流
        InputStream inputStream = new FileInputStream(realPath);

        // 创建字节数组，is.available() 获取输入流所对应文件的字节数
        byte[] bytes = new byte[inputStream.available()];

        // 将流读到字节数组中
        inputStream.read(bytes);

        // 创建 HttpHeaders 对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();

        // 对文件名进行 URL 编码
        String filename = "大户爱.png";
        String encodedFileName = URLEncoder.encode(filename, StandardCharsets.UTF_8);

        // 设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);

        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;

        // 创建 ResponseEntity 对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        // 关闭输入流
        inputStream.close();

        return responseEntity;
    }

    @RequestMapping("/test/upload")
    public String testUpload(@RequestParam("picture") MultipartFile picture, HttpSession session) throws IOException
    {

        // 获取上传的文件的文件名
        String filename = picture.getOriginalFilename();

        // 获取上传的文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));

        // 获取 UUID
        String uuid = UUID.randomUUID().toString();

        // 拼接一个新的文件名
        filename = uuid + suffixName;

        // 获取 ServLetContext 对象
        ServletContext servletContext = session.getServletContext();

        // 获取当前工程下 img 目录的真实路径
        String imgPath = servletContext.getRealPath(File.separator + "static" + File.separator + "img");

        // 创建 imgPath 所对应的 FiLe 对象
        File file = new File(imgPath);

        // 判断 fiLe 所对应目录是否存在
        if (!file.exists())
        {
            file.mkdir();
        }

        String finalPath = imgPath + File.separator + filename;

        // 上传文件
        picture.transferTo(new File(finalPath));

        return "success";
    }
}
```

## 11、拦截器

### 11.1、拦截器的配置

SpringMVC 中的拦截器用于拦截控制器方法的执行。

SpringMVC 中的拦截器需要实现 HandlerInterceptor。

SpringMVC 的拦截器必须在 SpringMVC 的配置文件中进行配置：

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>

<!-- <bean id="firstInterceptor" class="com.myxh.springmvc.interceptor.FirstInterceptor"/> -->

<mvc:interceptors>
    <!-- bean 和 ref 标签所配置的拦截器默认对 DispatcherServlet 处理的所有的请求进行拦截 -->
    <!-- <bean class="com.myxh.springmvc.interceptor.FirstInterceptor"/> -->
    <ref bean="firstInterceptor"/>
    <ref bean="secondInterceptor"/>
    <!--
    <mvc:interceptor>
        &lt;!&ndash; 配置需要拦截的请求的请求路径，/** 表示所有请求 &ndash;&gt;
        <mvc:mapping path="/**"/>

        &lt;!&ndash; 配置需要排除拦截的请求的请求路径 &ndash;&gt;
        <mvc:exclude-mapping path="/test/exclude"/>

        &lt;!&ndash; 配置拦载器 &ndash;&gt;
        <ref bean="firstInterceptor"/>
    </mvc:interceptor>
        -->
</mvc:interceptors>
```

### 11.2、拦截器的三个抽象方法

SpringMVC 中的拦截器有三个抽象方法：

preHandle：控制器方法执行之前执行 preHandle()，其 boolean 类型的返回值表示是否拦截或放行，返回 true 为放行，即调用控制器方法；返回 false 表示拦截，即不调用控制器方法。

postHandle：控制器方法执行之后执行 postHandle()。

afterCompletion：处理完视图和模型数据，渲染视图完毕之后执行 afterCompletion()。

### 11.3、多个拦截器的执行顺序

① 若每个拦截器的 preHandle()都返回 true。

此时多个拦截器的执行顺序和拦截器在 SpringMVC 的配置文件的配置顺序有关：

preHandle()会按照配置的顺序执行，而 postHandle()和 afterCompletion()会按照配置的反序执行。

② 若某个拦截器的 preHandle()返回了 false。

preHandle()返回 false 和它之前的拦截器的 preHandle()都会执行，postHandle()都不执行，返回 false 的拦截器之前的拦截器的 afterCompletion()会执行。

```java
package com.myxh.springmvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 拦截器的三个方法：
 * preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截（false）或放行（true）
 * postHandle()：在控制器方法执行之后执行
 * afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 * <p>
 * 多个拦截器的执行顺序和在 SpringMVC 的配置文件中配置的顺序有关
 * preHandle() 按照配置的顺序执行，而 postHandle()和 afterCompletion() 按照配置的反序执行
 * <p>
 * 若拦截器中有某个拦截器的 preHandle() 返回了 false
 * 拦截器的 preHandle() 返回 false 和它之前的拦截器的 preHandle() 都会执行
 * 所有的拦截器的 postHandle() 都不执行
 * 拦截器的 preHandle() 返回 false 之前的拦截器的 afterCompletion() 会执行
 */
@Component
public class FirstInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        System.out.println("FirstInterceptor -> preHandle");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    {
        System.out.println("FirstInterceptor -> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        System.out.println("FirstInterceptor -> afterCompletion");
    }
}
```

```java
package com.myxh.springmvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * 拦截器的三个方法：
 * preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截（false）或放行（true）
 * postHandle()：在控制器方法执行之后执行
 * afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 * <p>
 * 多个拦截器的执行顺序和在 SpringMVC 的配置文件中配置的顺序有关
 * preHandle() 按照配置的顺序执行，而 postHandle()和 afterCompletion() 按照配置的反序执行
 * <p>
 * 若拦截器中有某个拦截器的 preHandle() 返回了 false
 * 拦截器的 preHandle() 返回 false 和它之前的拦截器的 preHandle() 都会执行
 * 所有的拦截器的 postHandle() 都不执行
 * 拦截器的 preHandle() 返回 false 之前的拦截器的 afterCompletion() 会执行
 */
@Component
public class SecondInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        System.out.println("SecondInterceptor -> preHandle");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    {
        System.out.println("SecondInterceptor -> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        System.out.println("SecondInterceptor -> afterCompletion");
    }
}
```

## 12、异常处理器

### 12.1、基于配置的异常处理

SpringMVC 提供了一个处理控制器方法执行过程中所出现的异常的接口：HandlerExceptionResolver

HandlerExceptionResolver 接口的实现类有：DefaultHandlerExceptionResolver 和 SimpleMappingExceptionResolver。

SpringMVC 提供了自定义的异常处理器 SimpleMappingExceptionResolver，使用方式：

```xml
<!-- 开启 mvc 的注解驱动 -->
<mvc:annotation-driven/>

<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
    <property name="exceptionMappings">
        <props>
            <!-- key 设置要处理的异常，value 设置出现该异常时要跳转的页面所对应的逻辑视图 -->
            <prop key="java.lang.ArithmeticException">error</prop>
        </props>
    </property>

    <!-- 设置共享在请求域中的异常信息的属性名 -->
    <property name="exceptionAttribute" value="ex"/>
</bean>
```

### 12.2、基于注解的异常处理

```java
package com.myxh.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author MYXH
 * @date 2023/9/6
 */
// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController
{
    // 设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model)
    {
        // ex 表示控制器方法所出现的异常
        model.addAttribute("ex", ex);

        return "error";
    }
}
```

## 13、注解配置 SpringMVC

使用配置类和注解代替 web.xml 和 SpringMVC 配置文件的功能。

### 13.1、创建初始化类，代替 web.xml

在 Servlet3.0 环境中，容器会在类路径中查找实现 javax.servlet.ServletContainerInitializer 接口的类，如果找到的话就用它来配置 Servlet 容器。 Spring 提供了这个接口的实现，名为 SpringServletContainerInitializer，这个类反过来又会查找实现 WebApplicationInitializer 的类并将配置的任务交给它们来完成。Spring3.2 引入了一个便利的 WebApplicationInitializer 基础实现，名为 AbstractAnnotationConfigDispatcherServletInitializer，当我们的类扩展了 AbstractAnnotationConfigDispatcherServletInitializer 并将其部署到 Servlet3.0 容器的时候，容器会自动发现它，并用它来配置 Servlet 上下文。

在 Servlet5.0 之后 javax 包名更改为了 jakarta。

```java
package com.myxh.springmvc.config;

import jakarta.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description 代替 web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer
{
    /**
     * 设置一个配置类代替 Spring 的配置文件
     *
     * @return 根应用程序上下文的配置，如果不需要创建和注册根上下文，则为 null
     */
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 设置一个配置类代替 SpringMVC 的配置文件
     * @return Servlet 应用程序上下文的配置，如果所有配置都是通过根配置类指定的，则为 null
     */
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]{WebConfig.class};
    }

    /**
     * 设置 SpringMVC 的前端控制器 DispatcherServlet 的 url-pattern
     */
    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }

    /**
     * 设置当前的过滤器
     * @return 筛选器数组或 null
     */
    @Override
    protected Filter[] getServletFilters()
    {
        // 创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        // 创建处理请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
```

### 13.2、创建 SpringConfig 配置类，代替 spring 的配置文件

```java
package com.myxh.springmvc.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description 代替 Spring 的配置文件
 */
// 将类标识为配置类
@Configuration
public class SpringConfig
{

}
```

### 13.3、创建 WebConfig 配置类，代替 SpringMVC 的配置文件

```java
package com.myxh.springmvc.config;

import com.myxh.springmvc.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description 代替 SpringMVC 的配置文件
 * 扫描组件、视图解析器、默认的 servlet、mvc 的注解驱动
 * 视图控制器、文件上传解析器、拦截器、异常解析器
 */
// 将类标识为配置类
@Configuration
// 扫描组件
@ComponentScan("com.myxh.springmvc.controller")
// 开启 mvc 的注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{
    /**
     * 默认的 servlet 处理静态资源
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    /**
     * 配置视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * {@code @Bean} 注解可以将标识的方法的返回值作为 bean 进行管理，bean 的 id 为方法的方法名
     */
    @Bean
    public StandardServletMultipartResolver multipartResolver()
    {
        return new StandardServletMultipartResolver();
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        FirstInterceptor firstInterceptor = new FirstInterceptor();
        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
    }

    /**
     * 配置异常解析器
     *
     * @param resolvers 解析器–最初是一个空列表
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers)
    {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        exceptionResolver.setExceptionMappings(prop);
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    /**
     * 配置生成模板解析器
     *
     * @return templateResolver 模板解析程序
     */
    @Bean
    public ITemplateResolver templateResolver()
    {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        return templateResolver;
    }

    /**
     * 生成模板引擎并为模板引擎注入模板解析器
     *
     * @param templateResolver 模板解析程序
     * @return templateEngine 模板引擎
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver)
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        return templateEngine;
    }

    /**
     * 生成视图解析器并未解析器注入模板引擎
     *
     * @param templateEngine 模板引擎
     * @return viewResolver 视图解析程序
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine)
    {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);

        return viewResolver;
    }
}
```

### 13.4、测试功能

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <h1>index.html</h1>
  </body>
</html>
```

```java
package com.myxh.springmvc.controller;

import org.springframework.stereotype.Controller;

/**
 * @author MYXH
 * @date 2023/9/6
 */
@Controller
public class TestController
{

}
```

```java
package com.myxh.springmvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MYXH
 * @date 2023/9/6
 */
public class FirstInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
```

## 14、SpringMVC 执行流程

### 14.1、SpringMVC 常用组件

- DispatcherServlet：**前端控制器**，不需要工程师开发，由框架提供。

  作用：统一处理请求和响应，整个流程控制的中心，由它调用其它组件处理用户的请求。

- HandlerMapping：**处理器映射器**，不需要工程师开发，由框架提供。

  作用：根据请求的 url、method 等信息查找 Handler，即控制器方法。

- Handler：**处理器**，需要工程师开发。

  作用：在 DispatcherServlet 的控制下 Handler 对具体的用户请求进行处理。

- HandlerAdapter：**处理器适配器**，不需要工程师开发，由框架提供。

  作用：通过 HandlerAdapter 对处理器（控制器方法）进行执行。

- ViewResolver：**视图解析器**，不需要工程师开发，由框架提供。

  作用：进行视图解析，得到相应的视图，例如：ThymeleafView、InternalResourceView、RedirectView。

- View：**视图**。

  作用：将模型数据通过页面展示给用户。

### 14.2、DispatcherServlet 初始化过程

DispatcherServlet 本质上是一个 Servlet，所以天然的遵循 Servlet 的生命周期。所以宏观上是 Servlet 生命周期来进行调度。

![DispatcherServlet 初始化过程](https://img-blog.csdnimg.cn/b509109a8fc149aa804f5303bc26e315.png)

#### 14.2.1 ① 初始化 WebApplicationContext

所在类：org.springframework.web.servlet.FrameworkServlet。

```java
/**
 * Initialize and publish the WebApplicationContext for this servlet.
 * <p>Delegates to {@link #createWebApplicationContext} for actual creation
 * of the context. Can be overridden in subclasses.
 * @return the WebApplicationContext instance
 * @see #FrameworkServlet(WebApplicationContext)
 * @see #setContextClass
 * @see #setContextConfigLocation
 */
protected WebApplicationContext initWebApplicationContext() {
    WebApplicationContext rootContext =
            WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    WebApplicationContext wac = null;

    if (this.webApplicationContext != null) {
        // A context instance was injected at construction time -> use it
        wac = this.webApplicationContext;
        if (wac instanceof ConfigurableWebApplicationContext cwac && !cwac.isActive()) {
            // The context has not yet been refreshed -> provide services such as
            // setting the parent context, setting the application context id, etc
            if (cwac.getParent() == null) {
                // The context instance was injected without an explicit parent -> set
                // the root application context (if any; may be null) as the parent
                cwac.setParent(rootContext);
            }
            configureAndRefreshWebApplicationContext(cwac);
        }
    }

    if (wac == null) {
        // No context instance was injected at construction time -> see if one
        // has been registered in the servlet context. If one exists, it is assumed
        // that the parent context (if any) has already been set and that the
        // user has performed any initialization such as setting the context id
        wac = findWebApplicationContext();
    }

    if (wac == null) {
        // No context instance is defined for this servlet -> create a local one
        // 创建 WebApplicationContext
        wac = createWebApplicationContext(rootContext);
    }

    if (!this.refreshEventReceived) {
        // Either the context is not a ConfigurableApplicationContext with refresh
        // support or the context injected at construction time had already been
        // refreshed -> trigger initial onRefresh manually here.
        synchronized (this.onRefreshMonitor) {
            onRefresh(wac);
        }
    }

    if (this.publishContext) {
        // Publish the context as a servlet context attribute.
        // 将 IOC 容器在应用域共享
        String attrName = getServletContextAttributeName();
        getServletContext().setAttribute(attrName, wac);
    }

    return wac;
}
```

#### 14.2.2 ② 创建 WebApplicationContext

所在类：org.springframework.web.servlet.FrameworkServlet。

```java
/**
 * Instantiate the WebApplicationContext for this servlet, either a default
 * {@link org.springframework.web.context.support.XmlWebApplicationContext}
 * or a {@link #setContextClass custom context class}, if set.
 * <p>This implementation expects custom contexts to implement the
 * {@link org.springframework.web.context.ConfigurableWebApplicationContext}
 * interface. Can be overridden in subclasses.
 * <p>Do not forget to register this servlet instance as application listener on the
 * created context (for triggering its {@link #onRefresh callback}), and to call
 * {@link org.springframework.context.ConfigurableApplicationContext#refresh()}
 * before returning the context instance.
 * @param parent the parent ApplicationContext to use, or {@code null} if none
 * @return the WebApplicationContext for this servlet
 * @see org.springframework.web.context.support.XmlWebApplicationContext
 */
protected WebApplicationContext createWebApplicationContext(@Nullable ApplicationContext parent) {
    Class<?> contextClass = getContextClass();
    if (!ConfigurableWebApplicationContext.class.isAssignableFrom(contextClass)) {
        throw new ApplicationContextException(
                "Fatal initialization error in servlet with name '" + getServletName() +
                "': custom WebApplicationContext class [" + contextClass.getName() +
                "] is not of type ConfigurableWebApplicationContext");
    }

     // 通过反射创建 IOC 容器对象
    ConfigurableWebApplicationContext wac =
            (ConfigurableWebApplicationContext) BeanUtils.instantiateClass(contextClass);

    wac.setEnvironment(getEnvironment());

     // 设置父容器
    wac.setParent(parent);
    String configLocation = getContextConfigLocation();
    if (configLocation != null) {
        wac.setConfigLocation(configLocation);
    }
    configureAndRefreshWebApplicationContext(wac);

    return wac;
}
```

#### 14.2.3 ③ DispatcherServlet 初始化策略

FrameworkServlet 创建 WebApplicationContext 后，刷新容器，调用 onRefresh(wac)，此方法在 DispatcherServlet 中进行了重写，调用了 initStrategies(context)方法，初始化策略，即初始化 DispatcherServlet 的各个组件。

所在类：org.springframework.web.servlet.DispatcherServlet。

```java
/**
 * Initialize the strategy objects that this servlet uses.
 * <p>May be overridden in subclasses in order to initialize further strategy objects.
 */
protected void initStrategies(ApplicationContext context) {
    initMultipartResolver(context);
    initLocaleResolver(context);
    initThemeResolver(context);
    initHandlerMappings(context);
    initHandlerAdapters(context);
    initHandlerExceptionResolvers(context);
    initRequestToViewNameTranslator(context);
    initViewResolvers(context);
    initFlashMapManager(context);
}
```

### 14.3、DispatcherServlet 调用组件处理请求

#### 14.3.1 ① processRequest()

FrameworkServlet 重写 HttpServlet 中的 service()和 doXxx()，这些方法中调用了 processRequest(request, response)。

所在类：org.springframework.web.servlet.FrameworkServlet。

```java
/**
 * Process this request, publishing an event regardless of the outcome.
 * <p>The actual event handling is performed by the abstract
 * {@link #doService} template method.
 */
protected final void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    long startTime = System.currentTimeMillis();
    Throwable failureCause = null;

    LocaleContext previousLocaleContext = LocaleContextHolder.getLocaleContext();
    LocaleContext localeContext = buildLocaleContext(request);

    RequestAttributes previousAttributes = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes requestAttributes = buildRequestAttributes(request, response, previousAttributes);

    WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
    asyncManager.registerCallableInterceptor(FrameworkServlet.class.getName(), new RequestBindingInterceptor());

    initContextHolders(request, localeContext, requestAttributes);

    try {
         // 执行服务，doService() 是一个抽象方法，在 DispatcherServlet 中进行了重写
        doService(request, response);
    }
    catch (ServletException | IOException ex) {
        failureCause = ex;
        throw ex;
    }
    catch (Throwable ex) {
        failureCause = ex;
        throw new ServletException("Request processing failed: " + ex, ex);
    }

    finally {
        resetContextHolders(request, previousLocaleContext, previousAttributes);
        if (requestAttributes != null) {
            requestAttributes.requestCompleted();
        }
        logResult(request, response, failureCause, asyncManager);
        publishRequestHandledEvent(request, response, startTime, failureCause);
    }
}
```

#### 14.3.2 ② doService()

所在类：org.springframework.web.servlet.DispatcherServlet。

```java
/**
 * Exposes the DispatcherServlet-specific request attributes and delegates to {@link #doDispatch}
 * for the actual dispatching.
 */
@Override
protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
    logRequest(request);

    // Keep a snapshot of the request attributes in case of an include,
    // to be able to restore the original attributes after the include.
    Map<String, Object> attributesSnapshot = null;
    if (WebUtils.isIncludeRequest(request)) {
        attributesSnapshot = new HashMap<>();
        Enumeration<?> attrNames = request.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            String attrName = (String) attrNames.nextElement();
            if (this.cleanupAfterInclude || attrName.startsWith(DEFAULT_STRATEGIES_PREFIX)) {
                attributesSnapshot.put(attrName, request.getAttribute(attrName));
            }
        }
    }

    // Make framework objects available to handlers and view objects.
    request.setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE, getWebApplicationContext());
    request.setAttribute(LOCALE_RESOLVER_ATTRIBUTE, this.localeResolver);
    request.setAttribute(THEME_RESOLVER_ATTRIBUTE, this.themeResolver);
    request.setAttribute(THEME_SOURCE_ATTRIBUTE, getThemeSource());

    if (this.flashMapManager != null) {
        FlashMap inputFlashMap = this.flashMapManager.retrieveAndUpdate(request, response);
        if (inputFlashMap != null) {
            request.setAttribute(INPUT_FLASH_MAP_ATTRIBUTE, Collections.unmodifiableMap(inputFlashMap));
        }
        request.setAttribute(OUTPUT_FLASH_MAP_ATTRIBUTE, new FlashMap());
        request.setAttribute(FLASH_MAP_MANAGER_ATTRIBUTE, this.flashMapManager);
    }

    RequestPath previousRequestPath = null;
    if (this.parseRequestPath) {
        previousRequestPath = (RequestPath) request.getAttribute(ServletRequestPathUtils.PATH_ATTRIBUTE);
        ServletRequestPathUtils.parseAndCache(request);
    }

    try {
        // 处理请求和响应
        doDispatch(request, response);
    }
    finally {
        if (!WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted()) {
            // Restore the original attribute snapshot, in case of an include.
            if (attributesSnapshot != null) {
                restoreAttributesAfterInclude(request, attributesSnapshot);
            }
        }
        if (this.parseRequestPath) {
            ServletRequestPathUtils.setParsedRequestPath(previousRequestPath, request);
        }
    }
}
```

#### 14.3.3 ③ doDispatch()

所在类：org.springframework.web.servlet.DispatcherServlet。

```java
/**
 * Process the actual dispatching to the handler.
 * <p>The handler will be obtained by applying the servlet's HandlerMappings in order.
 * The HandlerAdapter will be obtained by querying the servlet's installed HandlerAdapters
 * to find the first that supports the handler class.
 * <p>All HTTP methods are handled by this method. It's up to HandlerAdapters or handlers
 * themselves to decide which methods are acceptable.
 * @param request current HTTP request
 * @param response current HTTP response
 * @throws Exception in case of any kind of processing failure
 */
@SuppressWarnings("deprecation")
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpServletRequest processedRequest = request;
    HandlerExecutionChain mappedHandler = null;
    boolean multipartRequestParsed = false;

    WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);

    try {
        ModelAndView mv = null;
        Exception dispatchException = null;

        try {
            processedRequest = checkMultipart(request);
            multipartRequestParsed = (processedRequest != request);

            // Determine handler for the current request.
            /*
                mappedHandler：调用链
                包含handler、interceptorList、interceptorIndex
                handler：浏览器发送的请求所匹配的控制器方法
                interceptorList：处理控制器方法的所有拦截器集合
                interceptorIndex：拦截器索引，控制拦截器 afterCompletion() 的执行
             */
            mappedHandler = getHandler(processedRequest);
            if (mappedHandler == null) {
                noHandlerFound(processedRequest, response);
                return;
            }

            // Determine handler adapter for the current request.
            // 通过控制器方法创建相应的处理器适配器，调用所对应的控制器方法
            HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());

            // Process last-modified header, if supported by the handler.
            String method = request.getMethod();
            boolean isGet = HttpMethod.GET.matches(method);
            if (isGet || HttpMethod.HEAD.matches(method)) {
                long lastModified = ha.getLastModified(request, mappedHandler.getHandler());
                if (new ServletWebRequest(request, response).checkNotModified(lastModified) && isGet) {
                    return;
                }
            }

            // 调用拦截器的 preHandle()
            if (!mappedHandler.applyPreHandle(processedRequest, response)) {
                return;
            }

            // Actually invoke the handler.
            // 由处理器适配器调用具体的控制器方法，最终获得 ModelAndView 对象
            mv = ha.handle(processedRequest, response, mappedHandler.getHandler());

            if (asyncManager.isConcurrentHandlingStarted()) {
                return;
            }

            applyDefaultViewName(processedRequest, mv);

            // 调用拦截器的 postHandle()
            mappedHandler.applyPostHandle(processedRequest, response, mv);
        }
        catch (Exception ex) {
            dispatchException = ex;
        }
        catch (Throwable err) {
            // As of 4.3, we're processing Errors thrown from handler methods as well,
            // making them available for @ExceptionHandler methods and other scenarios.
            dispatchException = new ServletException("Handler dispatch failed: " + err, err);
        }

        // 后续处理：处理模型数据和渲染视图
        processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
    }
    catch (Exception ex) {
        triggerAfterCompletion(processedRequest, response, mappedHandler, ex);
    }
    catch (Throwable err) {
        triggerAfterCompletion(processedRequest, response, mappedHandler,
                new ServletException("Handler processing failed: " + err, err));
    }
    finally {
        if (asyncManager.isConcurrentHandlingStarted()) {
            // Instead of postHandle and afterCompletion
            if (mappedHandler != null) {
                mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response);
            }
        }
        else {
            // Clean up any resources used by a multipart request.
            if (multipartRequestParsed) {
                cleanupMultipart(processedRequest);
            }
        }
    }
}
```

#### 14.3.4 ④ processDispatchResult()

```java
/**
 * Handle the result of handler selection and handler invocation, which is
 * either a ModelAndView or an Exception to be resolved to a ModelAndView.
 */
private void processDispatchResult(HttpServletRequest request, HttpServletResponse response,
        @Nullable HandlerExecutionChain mappedHandler, @Nullable ModelAndView mv,
        @Nullable Exception exception) throws Exception {

    boolean errorView = false;

    if (exception != null) {
        if (exception instanceof ModelAndViewDefiningException mavDefiningException) {
            logger.debug("ModelAndViewDefiningException encountered", exception);
            mv = mavDefiningException.getModelAndView();
        }
        else {
            Object handler = (mappedHandler != null ? mappedHandler.getHandler() : null);
            mv = processHandlerException(request, response, handler, exception);
            errorView = (mv != null);
        }
    }

    // Did the handler return a view to render?
    if (mv != null && !mv.wasCleared()) {
        // 处理模型数据和渲染视图
        render(mv, request, response);
        if (errorView) {
            WebUtils.clearErrorRequestAttributes(request);
        }
    }
    else {
        if (logger.isTraceEnabled()) {
            logger.trace("No view rendering, null ModelAndView returned.");
        }
    }

    if (WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted()) {
        // Concurrent handling started during a forward
        return;
    }

    if (mappedHandler != null) {
        // Exception (if any) is already handled..
        // 调用拦截器的afterCompletion()
        mappedHandler.triggerAfterCompletion(request, response, null);
    }
}
```

### 14.4、SpringMVC 的执行流程

1、用户向服务器发送请求，请求被 SpringMVC 前端控制器 DispatcherServlet 捕获。

2、DispatcherServlet 对请求 URL 进行解析，得到请求资源标识符（URI），判断请求 URI 对应的映射：

① 不存在。

i. 再判断是否配置了 mvc:default-servlet-handler。

ii. 如果没配置，则控制台报映射查找不到，客户端展示 404 错误。

![SpringMVC 的执行流程](https://img-blog.csdnimg.cn/b749860fab964acb9f3881cc647a1999.png)

![SpringMVC 的执行流程](https://img-blog.csdnimg.cn/ac00ef78e3ef4008b428a64bd62f05dd.png)

iii. 如果有配置，则访问目标资源（一般为静态资源，如：JS,CSS,HTML），找不到客户端也会展示 404 错误。

![SpringMVC 的执行流程](https://img-blog.csdnimg.cn/5487ab8968234942b4fa6685faa94657.png)

![SpringMVC 的执行流程](https://img-blog.csdnimg.cn/1516d536f838490ab4c1152022dc2be3.png)

② 存在则执行下面的流程。

3、根据该 URI，调用 HandlerMapping 获得该 Handler 配置的所有相关的对象（包括 Handler 对象以及 Handler 对象对应的拦截器），最后 HandlerExecutionChain 执行链对象的形式返回。

4、DispatcherServlet 根据获得的 Handler，选择一个合适的 HandlerAdapter。

5、如果成功获得 HandlerAdapter，此时将开始执行拦截器的 preHandler(...)方法【正向】。

6、提取 Request 中的模型数据，填充 Handler 入参，开始执行 Handler（Controller）方法，处理请求。在填充 Handler 的入参过程中，根据你的配置，Spring 将帮你做一些额外的工作：

① HttpMessageConveter： 将请求消息（如 json、xml 等数据）转换成一个对象，将对象转换为指定的响应信息。

② 数据转换：对请求消息进行数据转换。如 String 转换成 Integer、Double 等。

③ 数据格式化：对请求消息进行数据格式化。 如将字符串转换成格式化数字或格式化日期等。

④ 数据验证：验证数据的有效性（长度、格式等），验证结果存储到 BindingResult 或 Error 中。

7、Handler 执行完成后，向 DispatcherServlet 返回一个 ModelAndView 对象。

8、此时将开始执行拦截器的 postHandle(...)方法【逆向】。

9、根据返回的 ModelAndView（此时会判断是否存在异常：如果存在异常，则执行 HandlerExceptionResolver 进行异常处理）选择一个适合的 ViewResolver 进行视图解析，根据 Model 和 View，来渲染视图。

10、渲染视图完毕执行拦截器的 afterCompletion(...)方法【逆向】。

11、将渲染结果返回给客户端。

# 四、SSM 框架整合

## 4.1、ContextLoaderListener

Spring 提供了监听器 ContextLoaderListener，实现 ServletContextListener 接口，可监听 ServletContext 的状态，在 web 服务器的启动，读取 Spring 的配置文件，创建 Spring 的 IOC 容器。web 应用中必须在 web.xml 中配置。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <!-- 配置 Spring 的监听器 -->
    <listener>
        <!-- 配置 Spring 的监听器，在服务器启动时加载 Spring 的配置文件
        Spring 配置文件默认位置和名称：/WEB-INF/applicationContext.xml
        可通过上下文参数自定义 Spring 配置文件的位置和名称
         -->
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- 自定义 Spring 配置文件的位置和名称 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>

    <!-- 配置 Spring 的编码过滤器 -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>

        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 设置 SpringMVC 的前端控制器 -->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

## 4.2、准备工作

### 4.2.1 ① 创建 Maven Module

### 4.2.2 ② 导入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.myxh.ssm</groupId>
    <artifactId>spring_springmvc_mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring.version>6.0.9</spring.version>
    </properties>

    <dependencies>
        <!-- 基于 Maven 依赖传递性，导入 spring-context 依赖即可导入当前所需所有 jar 包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- spring-aspects 会帮我们传递过来 aspectjweaver -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Spring 持久化层支持 jar 包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>6.0.6</version>
        </dependency>

        <!-- Spring 测试相关 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>6.0.6</version>
        </dependency>

        <!-- SpringMVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- SpringMVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- ServletAPI -->
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.0.0</version>
            <scope>provided</scope>
        </dependency>

        <!-- Spring6 和 Thymeleaf 整合包 -->
        <dependency>
            <groupId>org.thymeleaf</groupId>
            <artifactId>thymeleaf-spring6</artifactId>
            <version>3.1.1.RELEASE</version>
        </dependency>

        <!-- jackson -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.1</version>
        </dependency>

        <!-- Mybatis核心 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>

        <!-- Mybatis 和 Spring的整合包-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>3.0.2</version>
        </dependency>

        <!-- MySQL 驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>

        <!-- 数据源连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.16</version>
        </dependency>

        <!-- 分页插件 -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.3.2</version>
        </dependency>

        <!-- junit 测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <!-- log4j 日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>

        <!-- slf4j 日志门面的一个具体实现 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.7</version>
        </dependency>
    </dependencies>
</project>
```

### 4.2.3 ③ 创建表

```sql
# 创建数据库 ssm
CREATE DATABASE IF NOT EXISTS ssm;

# 选择数据库 ssm
USE ssm;

# 创建员工表 t_employee
CREATE TABLE IF NOT EXISTS t_employee
(
    employee_id   INT AUTO_INCREMENT,
    employee_name VARCHAR(20) NULL,
    age           INT         NULL,
    gender        CHAR        NULL,
    email         VARCHAR(50) NULL,
    department_id INT         NULL,
    CONSTRAINT t_employee_pk
        PRIMARY KEY (employee_id)
);

# 添加员工表 t_employee 的数据
INSERT INTO t_employee (employee_id, employee_name, age, gender, email, department_id)
VALUES (1, 'MYXH', 21, '男', '1735350920@qq.com', 1),
       (2, '张三', 20, '男', 'zhangsan@qq.com', 1),
       (3, '李四', 22, '男', 'lisi@qq.com', 2),
       (4, '王五', 23, '男', 'wangwu@qq.com', 2),
       (5, '赵六', 24, '男', 'zhaoliu@qq.com', 3),
       (6, 'test1', 18, '男', 'test1@qq.com', null),
       (7, 'test2', 18, '男', 'test2@qq.com', null),
       (8, 'test3', 18, '男', 'test3@qq.com', null),
       (9, 'test4', 18, '男', 'test4@qq.com', null),
       (10, 'test5', 18, '男', 'test5@qq.com', null),
       (11, 'test6', 18, '男', 'test6@qq.com', null),
       (12, 'test7', 18, '男', 'test7@qq.com', null),
       (13, 'test8', 18, '男', 'test8@qq.com', null),
       (14, 'test9', 18, '男', 'test9@qq.com', null),
       (15, 'test10', 18, '男', 'test10@qq.com', null),
       (16, 'test11', 18, '男', 'test11@qq.com', null),
       (17, 'test12', 18, '男', 'test12@qq.com', null),
       (18, 'test13', 18, '男', 'test13@qq.com', null),
       (19, 'test14', 18, '男', 'test14@qq.com', null),
       (20, 'test15', 18, '男', 'test15@qq.com', null),
       (21, 'test16', 18, '男', 'test16@qq.com', null),
       (22, 'test17', 18, '男', 'test17@qq.com', null),
       (23, 'test18', 18, '男', 'test18@qq.com', null),
       (24, 'test19', 18, '男', 'test19@qq.com', null),
       (25, 'test20', 18, '男', 'test20@qq.com', null),
       (26, 'test21', 18, '男', 'test21@qq.com', null),
       (27, 'test22', 18, '男', 'test22@qq.com', null),
       (28, 'test23', 18, '男', 'test23@qq.com', null),
       (29, 'test24', 18, '男', 'test24@qq.com', null),
       (30, 'test25', 18, '男', 'test25@qq.com', null);
```

## 4.3、配置 web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <!-- 配置 Spring 的监听器 -->
    <listener>
        <!-- 配置 Spring 的监听器，在服务器启动时加载 Spring 的配置文件
        Spring 配置文件默认位置和名称：/WEB-INF/applicationContext.xml
        可通过上下文参数自定义 Spring 配置文件的位置和名称
         -->
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- 设置 Spring 配置文件自定义的位置和名称 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>

    <!-- 配置 Spring 的编码过滤器 -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>

        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 配置处理请求方式的过滤器 -->
    <filter>
        <filter-name>hiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>hiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 配置 SpringMVC 的前端控制器 DispatcherServlet -->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <!-- 设置 SpringMVC 配置文件自定义的位置和名称 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>

        <!-- 将 DispatcherServLet 的初始化时间提前到服务器启动时 -->
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

## 4.4、创建 SpringMVC 的配置文件并配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 扫描控制层组件 -->
    <context:component-scan base-package="com.myxh.ssm.controller"/>

    <!-- 配置 Thymeleaf 视图解析器 -->
    <bean id="viewResolver" class="org.thymeleaf.spring6.view.ThymeleafViewResolver">
        <property name="order" value="1"/>
        <property name="characterEncoding" value="UTF-8"/>
        <property name="templateEngine">
            <bean class="org.thymeleaf.spring6.SpringTemplateEngine">
                <property name="templateResolver">
                    <bean class="org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver">
                        <!-- 视图前缀 -->
                        <property name="prefix" value="/WEB-INF/templates/"/>

                        <!-- 视图后缀 -->
                        <property name="suffix" value=".html"/>

                        <property name="templateMode" value="HTML"/>
                        <property name="characterEncoding" value="UTF-8"/>
                    </bean>
                </property>
            </bean>
        </property>
    </bean>

    <!-- 配置默认的 servlet 处理静态资源 -->
    <mvc:default-servlet-handler/>

    <!-- 开启 mvc 的注解驱动 -->
    <mvc:annotation-driven/>

    <!-- 配置视图控制器 -->
    <mvc:view-controller path="/" view-name="index"/>

    <!-- 配置文件上传解析器 -->
    <!-- 配置 StandardServletMultipartResolver 为 MultipartResolver -->
    <!-- 该类实现了 Servlet3.0 规范的文件上传支持 -->
    <bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver"/>
</beans>
```

## 4.5、搭建 MyBatis 环境

### 4.5.1 ① 创建属性文件 jdbc.properties

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.username=MYXH
jdbc.password=520.ILY!
```

### 4.5.2 ② 创建 MyBatis 的核心配置文件 mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--
        MyBatis 核心配置文件中的标签必须要按照指定的顺序配置：
        properties?,settings?,typeAliases?,typeHandlers?,
        objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,
        environments?,databaseIdProvider?,mappers?
     -->
    <settings>
        <!-- 将下划线命名风格映射为驼峰命名风格 -->
        <setting name="mapUnderscoreToCamelCase" value="true"/>

        <!-- 开启延迟加载 -->
        <setting name="lazyLoadingEnabled" value="true"/>

        <!-- 按需加载 -->
        <setting name="aggressiveLazyLoading" value="false"/>
    </settings>

    <plugins>
        <!-- 配置分页插件 -->
        <plugin interceptor="com.github.pagehelper.PageInterceptor"/>
    </plugins>
</configuration>
```

### 4.5.3 ③ 创建 Mapper 接口和映射文件

```java
package com.myxh.ssm.mapper;

import com.myxh.ssm.pojo.Employee;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 */
public interface EmployeeMapper
{
    /**
     * 查询所有的员工信息
     *
     * @return 所有员工信息
     */
    List<Employee> getAllEmployee();
}
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myxh.ssm.mapper.EmployeeMapper">
    <!-- List<Employee> getAllEmployee(); -->
    <select id="getAllEmployee" resultType="Employee">
        select * from t_employee
    </select>
</mapper>
```

### 4.5.4 ④ 创建日志文件 log4j.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8"/>
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m (%F:%L) \n"/>
        </layout>
    </appender>

    <logger name="java.sql">
        <level value="debug"/>
    </logger>

    <logger name="org.apache.ibatis">
        <level value="info"/>
    </logger>

    <root>
        <level value="debug"/>
        <appender-ref ref="STDOUT"/>
    </root>
</log4j:configuration>
```

## 4.6、创建 Spring 的配置文件并配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    <!-- 扫描组件（排除控制层） -->
    <context:component-scan base-package="com.myxh.ssm">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <!-- 引入外部属性文件 jdbc.properties -->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!-- 配置事务管理器 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--
        开启事务的注解驱动
        将使用注解 @Transactional 标识的方法或类中所有的方法进行事务管理
     -->
    <tx:annotation-driven transaction-manager="transactionManager"/>

    <!-- 配置 sqlSessionFactoryBean，可以直接在 Spring 的 IOC 中获取 sqlSessionFactory -->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 设置 MyBatis 的核心配置文件的路径 -->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>

        <!-- 设置数据源 -->
        <property name="dataSource" ref="dataSource"/>

        <!-- 设置类型别名所对应的包 -->
        <property name="typeAliasesPackage" value="com.myxh.ssm.pojo"/>

        <!-- 设置 MyBatis 映射文件的路径，只有映射文件的包和 mapper 接口的包不一致时需要设置-->
        <!-- <property name="mapperLocations" value="classpath:com/myxh/ssm/mapper/*.xml"/> -->
    </bean>

    <!--
      配置 mapper 接口的扫描，可以将指定包下所有的 mapper 接口
      通过 SqlSession 创建代理实现类对象，并将这些对象交给 IOC 容器管理
     -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.myxh.ssm.mapper"/>
    </bean>
</beans>
```

## 4.7、测试功能

### 4.7.1 ① 创建组件

实体类 Employee。

```java
package com.myxh.ssm.pojo;

/**
 * @author MYXH
 * @date 2023/9/9
 */
public class Employee
{
    private Integer employeeId;
    private String employeeName;
    private Integer age;
    private String gender;
    private String email;

    public Employee()
    {

    }

    public Employee(Integer employeeId, String employeeName, Integer age, String gender, String email)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Integer getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
```

创建控制层组件 EmployeeController。

```java
package com.myxh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.myxh.ssm.pojo.Employee;
import com.myxh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 * @description
 * 查询所有的员工信息：/employee -> GET
 * 查询员工的分页信息：/employee/page/1 -> GET
 * 根据 id 查询员工信息：/employee/1 -> GET
 * 跳转到添加页面：/to/add -> GET
 * 添加员工信息：/employee -> POST
 * 跳转到修改页面：/employee/1 -> GET
 * 修改员工信息：/employee -> PUT
 * 根据 id 删除员工信息：/employee/1 -> DELETE
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
        // 查询所有的员工信息
        List<Employee> employeeList = employeeService.getAllEmployee();

        // 将所有的员工信息在请求域中共享
        model.addAttribute("employeeList", employeeList);

        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model)
    {
        // 获取员工的分页信息
        PageInfo<Employee> employeePage = employeeService.getEmployeePage(pageNum);

        // 将分页数据共享到请求域中
        model.addAttribute("employeePage", employeePage);

        // 跳转到列表页面
        return "employee_list";
    }
}
```

创建接口 EmployeeService。

```java
package com.myxh.ssm.service;

import com.github.pagehelper.PageInfo;
import com.myxh.ssm.pojo.Employee;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 */
public interface EmployeeService
{


    /**
     * 查询所有的员工信息
     *
     * @return 所有员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum 当前页的页码
     * @return 员工的分页信息
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
```

创建实现类 EmployeeServiceImpl。

```java
package com.myxh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myxh.ssm.mapper.EmployeeMapper;
import com.myxh.ssm.pojo.Employee;
import com.myxh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/9
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有的员工信息
     *
     * @return 所有员工信息
     */
    @Override
    public List<Employee> getAllEmployee()
    {
        return employeeMapper.getAllEmployee();
    }

    /**
     * 获取员工的分页信息
     * @param pageNum 当前页的页码
     * @return 员工的分页信息
     */
    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum)
    {
        // 开启分页功能
        PageHelper.startPage(pageNum, 5);

        // 查询所有的员工信息
        List<Employee> employeeList = employeeMapper.getAllEmployee();

        // 获取分页相关数据
        PageInfo<Employee> employeePage = new PageInfo<>(employeeList, 5);

        return employeePage;
    }
}
```

### 4.7.2 ② 创建页面

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>首页</title>
  </head>

  <body>
    <h1>index.html</h1>

    <h2>1、SSM 框架整合</h2>
    <h3>1.1、查询所有的员工信息</h3>
    <a th:href="@{/employee}">查询所有的员工信息</a>

    <h3>1.2、查询员工的分页信息</h3>
    <a th:href="@{/employee/page/1}">查询员工的分页信息</a>
  </body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>员工列表</title>
    <link rel="stylesheet" th:href="@{/static/css/index_work.css}" />
  </head>

  <body>
    <div id="app">
      <table>
        <tr>
          <th colspan="7">员工列表</th>
        </tr>

        <tr>
          <th>序号</th>
          <th>员工 id</th>
          <th>员工姓名</th>
          <th>年龄</th>
          <th>性别</th>
          <th>电子邮件</th>
          <th>选项（<a th:href="@{/to/add}">添加</a>）</th>
        </tr>

        <!-- <tr th:each="employee, status : ${employeeList}"> -->
        <tr th:each="employee, status : ${employeePage.list}">
          <td th:text="${status.count}"></td>
          <td th:text="${employee.employeeId}"></td>
          <td th:text="${employee.employeeName}"></td>
          <td th:text="${employee.age}"></td>
          <td th:text="${employee.gender}"></td>
          <td th:text="${employee.email}"></td>

          <td>
            <a th:href="@{|/employee/${employee.employeeId}|}">修改</a>
            <a
              @click="deleteEmployee"
              th:href="@{|/employee/${employee.employeeId}|}"
              >删除</a
            >
          </td>
        </tr>
      </table>

      <div style="text-align: center">
        <a th:if="${employeePage.hasPreviousPage}" th:href="@{/employee/page/1}"
          >首页</a
        >
        <a
          th:if="${employeePage.hasPreviousPage}"
          th:href="@{|/employee/page/${employeePage.prePage}|}"
          >上一页</a
        >
        <span th:each="navigatepageNum : ${employeePage.navigatepageNums}">
          <a
            th:if="${employeePage.pageNum == navigatepageNum}"
            style="color: red"
            th:href="@{|/employee/page/${navigatepageNum}|}"
            th:text="|[${navigatepageNum}]|"
          ></a>
          <a
            th:if="${employeePage.pageNum != navigatepageNum}"
            th:href="@{|/employee/page/${navigatepageNum}|}"
            th:text="${navigatepageNum}"
          ></a>
        </span>
        <a
          th:if="${employeePage.hasNextPage}"
          th:href="@{|/employee/page/${employeePage.nextPage}|}"
          >下一页</a
        >
        <a
          th:if="${employeePage.hasNextPage}"
          th:href="@{|/employee/page/${employeePage.pages}|}"
          >末页</a
        >
      </div>

      <form method="post">
        <input type="hidden" name="_method" value="delete" />
      </form>
    </div>

    <script type="text/javascript" th:src="@{/static/js/vue.js}"></script>

    <script type="text/javascript">
      let vue = new Vue({
        el: "#app",

        methods: {
          deleteEmployee() {
            // 获取 form 表单
            let form = document.getElementsByTagName("form")[0];

            // 将超链接的 href 属性值赋值给 form 表单的 action 属性
            // event.target 表示当前触发事件的标签
            form.action = event.target.href;

            // 表单提交
            form.submit();

            // 阻止超链接的默认行为
            event.preventDefault();
          },
        },
      });
    </script>
  </body>
</html>
```

### 4.7.3 ③ 访问测试分页功能

http://localhost:8080/spring_springmvc_mybatis/employee/page/1

![访问测试分页功能](https://img-blog.csdnimg.cn/b5e15244270446a9bed5225ff4eb239e.png)

![访问测试分页功能](https://img-blog.csdnimg.cn/f1dd8dcbecb74960bb3928073dcf32c2.png)
