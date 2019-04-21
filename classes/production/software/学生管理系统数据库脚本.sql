-- 删除数据库
DROP DATABASE software;
-- 创建删除库
CREATE DATABASE software;
-- 使用数据库
USE software;
-- 删除数据表
DROP TABLE super_admin;
DROP TABLE user;

-- 创建数据表
-- 1、创建超级管理员表
create table super_admin
(
   ad_name              VARCHAR(10),
   ad_number            VARCHAR(32) not null,
   ad_password          VARCHAR(32),
   ad_lastdate          DATE,
   primary key (ad_number)
);

-- 2、创建用户表
create table user
(
   u_name               VARCHAR(10),
   u_number             VARCHAR(10) not null,
   u_password           VARCHAR(32),
   u_lastdate           DATE,
   primary key (u_number)
);

-- 增加测试数据
-- id:16207231 password:15779035570
INSERT INTO super_admin(ad_name, ad_number,ad_password,ad_lastdate) VALUES ('钟坚鸿','22BB09850349B763292456715CC5E25F','15779035570',2000-10-02);
-- 提交
COMMIT;