DROP TABLE
IF
	EXISTS t_user;
CREATE TABLE t_user (
id VARCHAR ( 255 ) NOT NULL COMMENT '主键ID',
NAME VARCHAR ( 30 ) NULL DEFAULT NULL COMMENT '姓名',
account VARCHAR ( 50 ) NULL DEFAULT NULL COMMENT '帐号',
PASSWORD VARCHAR ( 50 ) NULL DEFAULT NULL COMMENT '密码',
PRIMARY KEY ( id ) 
);
DROP TABLE
IF
	EXISTS t_user_info;
CREATE TABLE t_user_info (
id VARCHAR ( 255 ) NOT NULL COMMENT '主键ID',
user_id VARCHAR ( 255 ) NULL DEFAULT NULL COMMENT '用户id',
user_token VARCHAR ( 255 ) NULL DEFAULT NULL COMMENT '用户token',
PRIMARY KEY ( id ) 
);
DROP TABLE
IF
	EXISTS t_order;
CREATE TABLE t_order (
id VARCHAR ( 255 ) NOT NULL COMMENT '主键ID',
reserve_phone VARCHAR ( 20 ) NULL DEFAULT NULL COMMENT '手机号',
address VARCHAR ( 100 ) NULL DEFAULT NULL COMMENT '地址',
join_number VARCHAR ( 10 ) NULL DEFAULT NULL COMMENT '加入人数',
reserve_type VARCHAR ( 50 ) NULL DEFAULT NULL COMMENT '类型',
start_date TIMESTAMP NULL COMMENT '开始日期',
end_date TIMESTAMP NULL COMMENT '结束日期',
budget VARCHAR ( 50 ) NULL DEFAULT NULL COMMENT '预算',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY ( id ) 
);
INSERT INTO t_user ( id, NAME, account, PASSWORD )
VALUES
	( "1", "1", "1", "1" ),
	( "2", "2", "2", "2" ),
	( "3", "3", "3", "3" )