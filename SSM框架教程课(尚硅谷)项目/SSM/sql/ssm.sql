# 创建数据库 ssm
CREATE DATABASE IF NOT EXISTS ssm;

# 选择数据库 ssm
USE ssm;

# 创建用户表 t_user
CREATE TABLE IF NOT EXISTS t_user
(
    id       INT AUTO_INCREMENT,
    username VARCHAR(20) NULL,
    password VARCHAR(20) NULL,
    age      INT         NULL,
    gender   CHAR        NULL,
    email    VARCHAR(50) NULL,
    CONSTRAINT t_user_pk
        PRIMARY KEY (id)
);

# 添加用户表 t_user 的数据
INSERT INTO t_user (id, username, password, age, gender, email)
VALUES (1, 'MYXH', '520.ILY!', 21, '男', '1735350920@qq.com'),
       (2, 'root', '000000', 21, '男', 'root@qq.com'),
       (3, 'admin', '123456', 21, '男', 'admin@qq.com'),
       (4, 'test', 'test', 18, '男', 'test@qq.com');

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

# 创建部门表 t_department
CREATE TABLE IF NOT EXISTS t_department
(
    department_id   INT AUTO_INCREMENT,
    department_name VARCHAR(20) NULL,
    email           VARCHAR(50) NULL,
    CONSTRAINT t_department_pk
        PRIMARY KEY (department_id)
);

# 添加部门表 t_department 的数据
INSERT INTO t_department (department_id, department_name, email)
VALUES (1, '开发', 'develop@qq.com'),
       (2, '测试', 'test@qq.com'),
       (3, '运维', 'operation@qq.com');

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
